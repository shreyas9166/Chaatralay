package com.example.chaatralay.Model;

public class getApplicationRecyclerModel {

    public String id,sid,reason,fromdate,todate,img_url;

    public getApplicationRecyclerModel() {
    }

    public getApplicationRecyclerModel(String img_url,String sid, String reason, String fromdate, String todate) {
        this.sid = sid;
        this.reason = reason;
        this.fromdate = fromdate;
        this.todate = todate;
        this.img_url = img_url;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public getApplicationRecyclerModel(String reason, String fromdate, String todate) {
        this.reason = reason;
        this.fromdate = fromdate;
        this.todate = todate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }
}
