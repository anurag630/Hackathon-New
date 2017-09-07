package hackathonayush.mentor.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kunwar on 7/9/17.
 */

public class Invite {

    @Expose
    @SerializedName("id")
    int id;

    @Expose
    @SerializedName("student_status")
    String studentStatus;

    @Expose
    @SerializedName("mentor_status")
    String mentorStatus;

    @Expose
    @SerializedName("student_id")
    String studentId;

    @Expose
    @SerializedName("mentor_id")
    String mentorId;

    @Expose
    @SerializedName("student") }
