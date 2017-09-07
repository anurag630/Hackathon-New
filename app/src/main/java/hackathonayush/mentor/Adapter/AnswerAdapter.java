package hackathonayush.mentor.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hackathonayush.mentor.R;
import hackathonayush.mentor.View.AnswerViewHolder;

/**
 * Created by as on 07-Sep-17.
 */

public class AnswerAdapter extends RecyclerView.Adapter<AnswerViewHolder> {
    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.rv_single_answer_row, parent, false);
        return new AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
