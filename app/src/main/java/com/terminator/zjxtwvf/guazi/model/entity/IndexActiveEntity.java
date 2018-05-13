package com.terminator.zjxtwvf.guazi.model.entity;

import java.util.List;

public class IndexActiveEntity {
    /**
     * code : 0
     * message : 成功
     * data : {"APP_INDEX_ACTIVE":[{"id":"824","title":"卖车先估价 心中更有谱","imgUrl":"https://image.guazistatic.com/gz01180312/18/10/3e61da07c3793f3e39d99c0de3212db9.jpg@base@tag=imgScale","link":"https://sta.guazi.com/we_client/c2c-common.html#appraisal?domain=cd&domain_tel=cd&city_id=45&city_name=%E6%88%90%E9%83%BD&clueSourceCode=10101284831%2326&ca_s=app_tg&ca_n=meizu","ge":"92679740","position":"0","end_time":1534849143,"other":[],"show_frequency":86400,"show_count":2}]}
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
        private List<APPINDEXACTIVEBean> APP_INDEX_ACTIVE;

        public List<APPINDEXACTIVEBean> getAPP_INDEX_ACTIVE() {
            return APP_INDEX_ACTIVE;
        }

        public void setAPP_INDEX_ACTIVE(List<APPINDEXACTIVEBean> APP_INDEX_ACTIVE) {
            this.APP_INDEX_ACTIVE = APP_INDEX_ACTIVE;
        }

        public static class APPINDEXACTIVEBean {
            /**
             * id : 824
             * title : 卖车先估价 心中更有谱
             * imgUrl : https://image.guazistatic.com/gz01180312/18/10/3e61da07c3793f3e39d99c0de3212db9.jpg@base@tag=imgScale
             * link : https://sta.guazi.com/we_client/c2c-common.html#appraisal?domain=cd&domain_tel=cd&city_id=45&city_name=%E6%88%90%E9%83%BD&clueSourceCode=10101284831%2326&ca_s=app_tg&ca_n=meizu
             * ge : 92679740
             * position : 0
             * end_time : 1534849143
             * other : []
             * show_frequency : 86400
             * show_count : 2
             */

            private String id;
            private String title;
            private String imgUrl;
            private String link;
            private String ge;
            private String position;
            private int end_time;
            private int show_frequency;
            private int show_count;
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

            public int getShow_frequency() {
                return show_frequency;
            }

            public void setShow_frequency(int show_frequency) {
                this.show_frequency = show_frequency;
            }

            public int getShow_count() {
                return show_count;
            }

            public void setShow_count(int show_count) {
                this.show_count = show_count;
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
