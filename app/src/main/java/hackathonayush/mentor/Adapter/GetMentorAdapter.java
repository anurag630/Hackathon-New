package hackathonayush.mentor.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hackathonayush.mentor.R;
import hackathonayush.mentor.View.GetMentorViewHolder;

/**
 * Created by user on 02-Sep-17.
 */

public class GetMentorAdapter extends RecyclerView.Adapter<GetMentorViewHolder> {


    @Override
    public GetMentorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.rv_single, parent, false);
        return new GetMentorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GetMentorViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
