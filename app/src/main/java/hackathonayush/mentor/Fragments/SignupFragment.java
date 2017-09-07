package hackathonayush.mentor.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import butterknife.BindView;
import butterknife.OnClick;
import hackathonayush.mentor.Activity.HomeActivity;
import hackathonayush.mentor.Model.MentorSignUp;
import hackathonayush.mentor.R;
import hackathonayush.mentor.Utils.CustomToast;
import hackathonayush.mentor.network.ApiClient;

/**
 * Created by as on 05-Sep-17.
 */

public class SignupFragment extends MentorFragment {


    String selectedItem;

    @BindView(R.id.username)
    EditText userName;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_signup;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        SignupFragment signupFragment = new SignupFragment();
        return signupFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialSpinner materialSpinner = (MaterialSpinner) view.findViewById(R.id.spinner);
        materialSpinner.setItems("Login As", "Mentor", "Student");
        materialSpinner.setSelectedIndex(0);
        materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                selectedItem = (String) item;

            }
        });
    }


    @OnClick(R.id.sign_up)
    public void signUp() {


        if (selectedItem.equals("Mentor")) {

            ApiClient.getApiClient().signUpMentor(getStringFromEditText(userName), getStringFromEditText(email), getStringFromEditText(password))
                    .enqueue(new ApiClient.Callback<MentorSignUp>() {
                        @Override
                        public void success(MentorSignUp response) {
                            CustomToast.show("Sign Up Successfull !");
                            Intent intent = HomeActivity.getNewInstance(SignupFragment.this.getContext());
                            startActivity(intent);
                        }

                        @Override
                        public void failure(Error error) {
                            CustomToast.show(error.getMessage());

                        }
                    });

        } else if (selectedItem.equals("Student")) {


        } else {

            CustomToast.show("Please select Login As !");
        }


    }
}
