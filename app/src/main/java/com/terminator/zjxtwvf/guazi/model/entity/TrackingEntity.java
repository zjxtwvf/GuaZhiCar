package com.terminator.zjxtwvf.guazi.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9.
 */

public class TrackingEntity {
    /**
     * common : {"app_id":12,"agency":"meizu","friendlyname":"魅蓝 note 3","carrier":"其他","brand":"m3 note","imei":"862007036501106","line":"c2c","app_version":"3.9.1.0"}
     * trackings : [{"tracking_type":"pageload","pageid":"63819286","network":"wifi","local_timestamp":"1512830780477","sessionid":"abe64e70-e458-4ebb-9891-744ba98790b2","wifissid":"\"360免费WiFi-UB\"","pagetype":"index","city":"cd","latlng":"30.698347,104.011115","page":"com.ganji.android.haoche_c.ui.main.MainActivity","userid":""},{"tracking_type":"startup","pageid":"","network":"wifi","local_timestamp":"1512830907339","sessionid":"abe64e70-e458-4ebb-9891-744ba98790b2","wifissid":"\"360免费WiFi-UB\"","pagetype":"","city":"cd","latlng":",","userid":""}]
     */

    private CommonBean common;
    private List<TrackingsBean> trackings;

    public CommonBean getCommon() {
        return common;
    }

    public void setCommon(CommonBean common) {
        this.common = common;
    }

    public List<TrackingsBean> getTrackings() {
        return trackings;
    }

    public void setTrackings(List<TrackingsBean> trackings) {
        this.trackings = trackings;
    }

    public static class CommonBean {
        /**
         * app_id : 12
         * agency : meizu
         * friendlyname : 魅蓝 note 3
         * carrier : 其他
         * brand : m3 note
         * imei : 862007036501106
         * line : c2c
         * app_version : 3.9.1.0
         */

        private int app_id;
        private String agency;
        private String friendlyname;
        private String carrier;
        private String brand;
        private String imei;
        private String line;
        private String app_version;

        public int getApp_id() {
            return app_id;
        }

        public void setApp_id(int app_id) {
            this.app_id = app_id;
        }

        public String getAgency() {
            return agency;
        }

        public void setAgency(String agency) {
            this.agency = agency;
        }

        public String getFriendlyname() {
            return friendlyname;
        }

        public void setFriendlyname(String friendlyname) {
            this.friendlyname = friendlyname;
        }

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        public String getApp_version() {
            return app_version;
        }

        public void setApp_version(String app_version) {
            this.app_version = app_version;
        }
    }

    public static class TrackingsBean {
        /**
         * tracking_type : pageload
         * pageid : 63819286
         * network : wifi
         * local_timestamp : 1512830780477
         * sessionid : abe64e70-e458-4ebb-9891-744ba98790b2
         * wifissid : "360免费WiFi-UB"
         * pagetype : index
         * city : cd
         * latlng : 30.698347,104.011115
         * page : com.ganji.android.haoche_c.ui.main.MainActivity
         * userid :
         */

        private String tracking_type;
        private String pageid;
        private String network;
        private String local_timestamp;
        private String sessionid;
        private String wifissid;
        private String pagetype;
        private String city;
        private String latlng;
        private String page;
        private String userid;

        public String getTracking_type() {
            return tracking_type;
        }

        public void setTracking_type(String tracking_type) {
            this.tracking_type = tracking_type;
        }

        public String getPageid() {
            return pageid;
        }

        public void setPageid(String pageid) {
            this.pageid = pageid;
        }

        public String getNetwork() {
            return network;
        }

        public void setNetwork(String network) {
            this.network = network;
        }

        public String getLocal_timestamp() {
            return local_timestamp;
        }

        public void setLocal_timestamp(String local_timestamp) {
            this.local_timestamp = local_timestamp;
        }

        public String getSessionid() {
            return sessionid;
        }

        public void setSessionid(String sessionid) {
            this.sessionid = sessionid;
        }

        public String getWifissid() {
            return wifissid;
        }

        public void setWifissid(String wifissid) {
            this.wifissid = wifissid;
        }

        public String getPagetype() {
            return pagetype;
        }

        public void setPagetype(String pagetype) {
            this.pagetype = pagetype;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLatlng() {
            return latlng;
        }

        public void setLatlng(String latlng) {
            this.latlng = latlng;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }
    }
}
