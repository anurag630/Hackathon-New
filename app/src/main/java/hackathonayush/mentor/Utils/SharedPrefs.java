package hackathonayush.mentor.Utils;


import android.content.Context;
import android.content.SharedPreferences;

import hackathonayush.mentor.Activity.MentorApp;

public class SharedPrefs {


    private SharedPrefs() {
    }

    private static SharedPreferences getPrefrences() {
        Context context = MentorApp.getAppContext();
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }


}
