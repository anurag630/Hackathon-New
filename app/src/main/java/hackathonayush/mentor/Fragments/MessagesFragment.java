package hackathonayush.mentor.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import hackathonayush.mentor.R;

/**
 * Created by as on 05-Sep-17.
 */

public class MessagesFragment extends MentorFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_messages;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    public static Fragment getNewInstance() {
        MessagesFragment messagesFragment = new MessagesFragment();
        return messagesFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
