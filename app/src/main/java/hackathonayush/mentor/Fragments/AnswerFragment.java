package hackathonayush.mentor.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import hackathonayush.mentor.Adapter.AnswerAdapter;
import hackathonayush.mentor.R;

/**
 * Created by as on 07-Sep-17.
 */

public class AnswerFragment extends MentorFragment {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_answer;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new AnswerAdapter());
    }

    public static AnswerFragment getNewInstance() {

        AnswerFragment answerFragment = new AnswerFragment();
        return answerFragment;
    }


}
