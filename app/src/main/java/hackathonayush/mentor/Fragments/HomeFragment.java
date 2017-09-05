package hackathonayush.mentor.Fragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import at.favre.lib.dali.Dali;
import butterknife.BindView;
import hackathonayush.mentor.R;

/**
 * Created by user on 02-Sep-17.
 */

public class HomeFragment extends MentorFragment {

    @BindView(R.id.large_imageview)
    ImageView largeImageView;

    public HomeFragment() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected String setToolbarTitle() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Dali.create(getContext()).load(R.drawable.shraddha_kapoor).blurRadius(20).downScale(4).into(largeImageView);
    }

    public static HomeFragment getNewInstance(){
        HomeFragment homeFragment=new HomeFragment();
        return homeFragment;
    }
}
