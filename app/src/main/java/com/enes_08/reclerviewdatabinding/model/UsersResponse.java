
package com.enes_08.reclerviewdatabinding.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersResponse extends BaseObservable {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("info")
    @Expose
    private Info info;

    @Bindable
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
