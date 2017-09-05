package hackathonayush.mentor.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jaredrummler.materialspinner.MaterialSpinner;

import butterknife.OnClick;
import hackathonayush.mentor.Activity.HomeActivity;
import hackathonayush.mentor.R;

/**
 * Created by user on 02-Sep-17.
 */

public class LoginFragment extends MentorFragment {

    public LoginFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_signin;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialSpinner materialSpinner = (MaterialSpinner) view.findViewById(R.id.spinner);
        materialSpinner.setBackgroundColor( Color.TRANSPARENT);
        materialSpinner.setTextColor(Color.WHITE);
        materialSpinner.setArrowColor(Color.WHITE);
        materialSpinner.setItems("Login As", "Mentor", "Student");
        materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

            }
        });
    }


}
