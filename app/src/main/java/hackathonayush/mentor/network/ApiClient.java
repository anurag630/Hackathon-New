package hackathonayush.mentor.network;


import android.util.Log;


import com.google.gson.Gson;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://api.codekamp.in";
    private static ApiInterface apiInterface = null;

    public static ApiInterface getApiClient() {
        if (apiInterface == null) {

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.interceptors().add(httpLoggingInterceptor);

            if (SharedPrefs.getLoginToken() != null) {
                Interceptor interceptor = new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request newRequest = chain.request().newBuilder().addHeader("Authorization", "bearer " + SharedPrefs.getLoginToken()).build();
                        return chain.proceed(newRequest);
                    }
                };
                builder.interceptors().add(interceptor);
            }

            OkHttpClient okHttpClient = builder.build();

            apiInterface = new Retrofit.Builder().
                    baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                    .create(ApiInterface.class);
        }
        return apiInterface;
    }

    private static void setLoggedInUser(User user, String token) {
        SharedPrefs.setLoginToken(token);
        SharedPrefs.setUser(user);
        apiInterface = null;
    }

    private static void clearLoggedInUser() {
        SharedPrefs.clearLoggedInUser();
        apiInterface = null;
    }


    public static abstract class Callback<T> implements retrofit2.Callback<T> {
        private static final int ERROR_CODE_NETWORK_ERROR = -11;

        @Override
        public void onResponse(final Call<T> call, Response<T> response) {

            if (response.isSuccessful()) {
                executeAPIHooks(call.request().url().url().getPath(), response);
                success(response.body());
            } else {
                if (response.code() == 401) {
                    ApiClient.clearLoggedInUser();
                    EventBus.getDefault().post(new TokenExpiredEvent());
                    return;
                }
                try {
//                    // never call response.errorBody().string() twice
                    String responseString = response.errorBody().string();
                    Gson gson = new Gson();
                    Error error = gson.fromJson(responseString, Error.class);
                    failure(error);
                } catch (IOException e) {
                    Log.d("codekamp", "onResponse IOException failure " + e.getMessage());
                    failure(new Error());
                }
            }
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            Log.d("codekamp", "onFailure: retrofit failure");
            Log.d("codekamp", "" + t.getMessage());
            Error error = new Error(t.getMessage(), ERROR_CODE_NETWORK_ERROR);
            failure(error);
        }


        private void executeAPIHooks(String urlPath, Response<T> response) {
            switch (urlPath) {
                case "/authenticate":
                    login(response);
                    break;
                /*TODO : Will be adding logout Hook here further. (if needed)*/
            }
        }

        private void login(Response response) {
            LoginResponse loginResponse = (LoginResponse) response.body();
            ApiClient.setLoggedInUser(loginResponse.getUser(), loginResponse.getToken());
        }

        public abstract void success(T response);

        public abstract void failure(Error error);
    }
}
