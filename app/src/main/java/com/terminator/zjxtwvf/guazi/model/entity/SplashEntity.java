package com.terminator.zjxtwvf.guazi.model.entity;

/**
 * Created by Administrator on 2017/12/3.
 */

public class SplashEntity {
    /**
     * code : 0
     * message : 成功
     * data : {"title":"两年四万公里","image":"https://image.guazistatic.com/gz01171130/19/49/8b49f347d49af7f15949ec880d1efa71.png@base@tag=imgScale","url":"","endTime":1512991697,"interval":"3","openUrl":""}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 两年四万公里
         * image : https://image.guazistatic.com/gz01171130/19/49/8b49f347d49af7f15949ec880d1efa71.png@base@tag=imgScale
         * url :
         * endTime : 1512991697
         * interval : 3
         * openUrl :
         */

        private String title;
        private String image;
        private String url;
        private long endTime;
        private String interval;
        private String openUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public String getInterval() {
            return interval;
        }

        public void setInterval(String interval) {
            this.interval = interval;
        }

        public String getOpenUrl() {
            return openUrl;
        }

        public void setOpenUrl(String openUrl) {
            this.openUrl = openUrl;
        }
    }
}
