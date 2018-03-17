package com.terminator.zjxtwvf.guazi.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/1/13.
 */

public class SellRecordsEntity {
    /**
     * code : 0
     * message : 成功
     * data : {"list":[{"puid":3003427439,"title":"标致307 2010款 两厢 1.6L 手动舒适版","deal_price":"3.51万","deal_price_cha":"8千","seller_price":"2.63万","city_name":"成都","tag_name":"2日售出","thumb_img":"https://image1.guazistatic.com/qn180112102053633d07bc1a2e0d184e7a83ddae3162c4.jpg?imageView2/1/w/280/h/180/q/88","license_date":"2011年","road_haul":"4.9万公里"},{"puid":3003425976,"title":"标致308 2013款 1.6L 自动优尚陈坤出色版","deal_price":"5.76万","deal_price_cha":"1.4万","seller_price":"4.32万","city_name":"兰州","tag_name":"1日售出","thumb_img":"https://image1.guazistatic.com/qn180111205510b41bd68c1b531b67e53e81029a3c67dd.jpg?imageView2/1/w/280/h/180/q/88","license_date":"2014年","road_haul":"4.3万公里"},{"puid":3003424104,"title":"斯柯达晶锐 2009款 1.4L 自动晶致版","deal_price":"3万","deal_price_cha":"7千","seller_price":"2.25万","city_name":"重庆","tag_name":"2日售出","thumb_img":"https://image1.guazistatic.com/qn180111180003dfdfd392827c42d5139bd4d8006be3e0.jpg?imageView2/1/w/280/h/180/q/88","license_date":"2011年","road_haul":"7.8万公里"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * puid : 3003427439
             * title : 标致307 2010款 两厢 1.6L 手动舒适版
             * deal_price : 3.51万
             * deal_price_cha : 8千
             * seller_price : 2.63万
             * city_name : 成都
             * tag_name : 2日售出
             * thumb_img : https://image1.guazistatic.com/qn180112102053633d07bc1a2e0d184e7a83ddae3162c4.jpg?imageView2/1/w/280/h/180/q/88
             * license_date : 2011年
             * road_haul : 4.9万公里
             */

            private long puid;
            private String title;
            private String deal_price;
            private String deal_price_cha;
            private String seller_price;
            private String city_name;
            private String tag_name;
            private String thumb_img;
            private String license_date;
            private String road_haul;

            public long getPuid() {
                return puid;
            }

            public void setPuid(long puid) {
                this.puid = puid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDeal_price() {
                return deal_price;
            }

            public void setDeal_price(String deal_price) {
                this.deal_price = deal_price;
            }

            public String getDeal_price_cha() {
                return deal_price_cha;
            }

            public void setDeal_price_cha(String deal_price_cha) {
                this.deal_price_cha = deal_price_cha;
            }

            public String getSeller_price() {
                return seller_price;
            }

            public void setSeller_price(String seller_price) {
                this.seller_price = seller_price;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getTag_name() {
                return tag_name;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }

            public String getThumb_img() {
                return thumb_img;
            }

            public void setThumb_img(String thumb_img) {
                this.thumb_img = thumb_img;
            }

            public String getLicense_date() {
                return license_date;
            }

            public void setLicense_date(String license_date) {
                this.license_date = license_date;
            }

            public String getRoad_haul() {
                return road_haul;
            }

            public void setRoad_haul(String road_haul) {
                this.road_haul = road_haul;
            }
        }
    }
}
