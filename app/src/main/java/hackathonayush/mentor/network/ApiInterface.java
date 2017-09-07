package hackathonayush.mentor.network;


import hackathonayush.mentor.Model.MentorSignUp;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {


    @POST("signup/mentor")
    @FormUrlEncoded
    Call<MentorSignUp> signUpMentor(@Field("name") String username,
                                    @Field("email") String email,
                                    @Field("password") String password

    );


}
