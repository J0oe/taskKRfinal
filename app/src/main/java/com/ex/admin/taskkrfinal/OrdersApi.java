package com.ex.admin.taskkrfinal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 04.03.2018.
 */

public class OrdersApi  {

    public OrdersApi(String name, String iD, String parentID) {
        this.name = name;
        this.iD = iD;
        this.parentID = parentID;
    }

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("ParentID")
    @Expose
    private String parentID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

}