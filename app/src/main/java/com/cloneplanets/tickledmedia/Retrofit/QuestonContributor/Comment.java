
package com.cloneplanets.tickledmedia.Retrofit.QuestonContributor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("message")
    @Expose
    public String message;

    public String getMessage() {
        return message;
    }
}
