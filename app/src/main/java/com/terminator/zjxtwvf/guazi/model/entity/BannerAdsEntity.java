package com.terminator.zjxtwvf.guazi.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/4/6.
 */

public class BannerAdsEntity {
    /**
     * code : 0
     * message : 成功
     * data : {"APP_BUY_LIST_BM":[{"id":"563","title":"瓜子保卖车","imgUrl":"https://image.guazistatic.com/gz01180209/04/42/a2f68ef1cef3f43205090387c9e2c8a2.png@base@tag=imgScale","link":"https://guaziapp-m.guazi.com/misc/BaoMaiDes?city=cd&ca_s=app_tg&ca_n=meizu","ge":"92416836","position":"0","end_time":1531547731,"other":[]}],"APP_BUY_LIST_JR":[{"id":"664","title":"寻春好车汇","imgUrl":"https://image.guazistatic.com/gz01180329/10/29/4dd5aa4ea98f78df3ee837486c89c9d6.jpg@base@tag=imgScale","link":"https://sta.guazi.com/promotion/xchch.html?ca_s=app_tg&ca_n=meizu","ge":"92740589","position":"0","end_time":"1523239200","other":[]}]}
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
        private List<APPBUYLISTBMBean> APP_BUY_LIST_BM;
        private List<APPBUYLISTJRBean> APP_BUY_LIST_JR;

        public List<APPBUYLISTBMBean> getAPP_BUY_LIST_BM() {
            return APP_BUY_LIST_BM;
        }

        public void setAPP_BUY_LIST_BM(List<APPBUYLISTBMBean> APP_BUY_LIST_BM) {
            this.APP_BUY_LIST_BM = APP_BUY_LIST_BM;
        }

        public List<APPBUYLISTJRBean> getAPP_BUY_LIST_JR() {
            return APP_BUY_LIST_JR;
        }

        public void setAPP_BUY_LIST_JR(List<APPBUYLISTJRBean> APP_BUY_LIST_JR) {
            this.APP_BUY_LIST_JR = APP_BUY_LIST_JR;
        }

        public static class APPBUYLISTBMBean {
            /**
             * id : 563
             * title : 瓜子保卖车
             * imgUrl : https://image.guazistatic.com/gz01180209/04/42/a2f68ef1cef3f43205090387c9e2c8a2.png@base@tag=imgScale
             * link : https://guaziapp-m.guazi.com/misc/BaoMaiDes?city=cd&ca_s=app_tg&ca_n=meizu
             * ge : 92416836
             * position : 0
             * end_time : 1531547731
             * other : []
             */

            private String id;
            private String title;
            private String imgUrl;
            private String link;
            private String ge;
            private String position;
            private int end_time;
            private List<?> other;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getGe() {
                return ge;
            }

            public void setGe(String ge) {
                this.ge = ge;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }

            public List<?> getOther() {
                return other;
            }

            public void setOther(List<?> other) {
                this.other = other;
            }
        }

        public static class APPBUYLISTJRBean {
            /**
             * id : 664
             * title : 寻春好车汇
             * imgUrl : https://image.guazistatic.com/gz01180329/10/29/4dd5aa4ea98f78df3ee837486c89c9d6.jpg@base@tag=imgScale
             * link : https://sta.guazi.com/promotion/xchch.html?ca_s=app_tg&ca_n=meizu
             * ge : 92740589
             * position : 0
             * end_time : 1523239200
             * other : []
             */

            private String id;
            private String title;
            private String imgUrl;
            private String link;
            private String ge;
            private String position;
            private String end_time;
            private List<?> other;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getGe() {
                return ge;
            }

            public void setGe(String ge) {
                this.ge = ge;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public List<?> getOther() {
                return other;
            }

            public void setOther(List<?> other) {
                this.other = other;
            }
        }
    }
}
