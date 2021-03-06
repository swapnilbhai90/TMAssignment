
package com.cloneplanets.tickledmedia.Retrofit.QuestonContributor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestonContributor {

    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("response")
    @Expose
    public List<Response> response = null;

    public Boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<Response> getResponse() {
        return response;
    }
}
