
package com.cloneplanets.tickledmedia.Retrofit.AnswerContributor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("user_id")
    @Expose
    public Integer userId;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("comments")
    @Expose
    public List<Comment> comments = null;

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public String getImage() {
        return image;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
