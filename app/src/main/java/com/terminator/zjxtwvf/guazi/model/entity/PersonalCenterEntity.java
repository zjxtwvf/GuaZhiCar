package com.terminator.zjxtwvf.guazi.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/1/14.
 */

public class PersonalCenterEntity {

    /**
     * code : 0
     * message : 成功
     * data : [{"title":"订单中心","category":1,"template_type":1,"list":[{"title":"买车订单","alias":"buyorder","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/buyorder.png","url":"guazi://openapi/openWebview?url=http%3A%2F%2Fuc.guazi.com%2F%23%2Fbuycarlist%3Fca_s%3Dapp_tg%26ca_n%3Dmeizu","ge":"02859547","value":"","needLogin":1,"desc":""},{"title":"卖车订单","alias":"saleorder","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/saleorder.png","url":"guazi://openapi/openWebview?url=https%3A%2F%2Fuc.guazi.com%2F%23%2FsellCarList%3Fca_s%3Dapp_tg%26ca_n%3Dmeizu&title=%E5%8D%96%E8%BD%A6%E8%BF%9B%E5%BA%A6","ge":"0000000000000370","value":"","needLogin":1,"desc":""}]},{"title":"常用功能","category":2,"template_type":1,"list":[{"title":"收藏车辆","alias":"collection","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/collection.png","url":"guazi://openapi/openMyCollection","ge":"0000000000000352","value":"","needLogin":1,"desc":""},{"title":"订阅车源","alias":"subscribe","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/subscribe.png","url":"guazi://openapi/subscribeHaveUpdate","ge":"0000000000000355","value":"","needLogin":1,"desc":""},{"title":"砍价记录","alias":"bargain","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/bargain.png","url":"guazi://openapi/openBargainPage","ge":"1215230001000004","value":"","needLogin":1,"desc":""},{"title":"降价提醒","alias":"reduction","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/depreciate.png","url":"guazi://openapi/openPriceReduction","ge":"1215230001000005","value":"","needLogin":1,"desc":""},{"title":"浏览记录","alias":"history","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/record.png","url":"guazi://openapi/openBrowseHistory","ge":"0000000000000356","value":"","needLogin":0,"desc":""},{"title":"购车贷款","alias":"loan","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/loan.png","url":"https://app2-jr.guazi.com/?city_id=45&jr_from=personalcenter&platform=app&ca_s=app_tg&ca_n=meizu","ge":"0000000000000364","value":"","needLogin":0,"desc":""},{"title":"车辆对比","alias":"compare","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/parity.png","url":"guazi://openapi/openCarCompare","ge":"1215330721000001","value":"","needLogin":1,"desc":""},{"title":"在线客服","alias":"service","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/service.png","url":"http://www.sobot.com/chat/h5/index.html?sysNum=fcf7665c86fe48d795058eea91f5d271&partnerId=&rput=1&rpuc=07a8eac11b9660db41b14a66158a5b7b0.zhaohui&groupId=135d8424c8c04c59b851f2f0e9d8c307","ge":"1215230001000014","value":"","needLogin":1,"desc":""}]},{"title":"其它","category":3,"template_type":2,"list":[{"title":"我的优惠","alias":"coupon","imageUrl":"","url":"guazi://openapi/openMyCoupon","ge":"0000000000000354","value":"","needLogin":1,"desc":""},{"title":"电话客服","alias":"contact","imageUrl":"","url":"guazi://openapi/callPhone?type=0","ge":"","value":"","needLogin":0,"desc":""},{"title":"意见反馈","alias":"suggestion","imageUrl":"","url":"guazi://openapi/openFeedBack","ge":"0000000000000366","value":"","needLogin":0,"desc":""},{"title":"设置","alias":"settings","imageUrl":"","url":"guazi://openapi/openSetting","ge":"0000000000000367","value":"","needLogin":0,"desc":""}]}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 订单中心
         * category : 1
         * template_type : 1
         * list : [{"title":"买车订单","alias":"buyorder","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/buyorder.png","url":"guazi://openapi/openWebview?url=http%3A%2F%2Fuc.guazi.com%2F%23%2Fbuycarlist%3Fca_s%3Dapp_tg%26ca_n%3Dmeizu","ge":"02859547","value":"","needLogin":1,"desc":""},{"title":"卖车订单","alias":"saleorder","imageUrl":"https://sta.guazistatic.com/static/c2c/app/client/saleorder.png","url":"guazi://openapi/openWebview?url=https%3A%2F%2Fuc.guazi.com%2F%23%2FsellCarList%3Fca_s%3Dapp_tg%26ca_n%3Dmeizu&title=%E5%8D%96%E8%BD%A6%E8%BF%9B%E5%BA%A6","ge":"0000000000000370","value":"","needLogin":1,"desc":""}]
         */

        private String title;
        private int category;
        private int template_type;
        private List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getTemplate_type() {
            return template_type;
        }

        public void setTemplate_type(int template_type) {
            this.template_type = template_type;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * title : 买车订单
             * alias : buyorder
             * imageUrl : https://sta.guazistatic.com/static/c2c/app/client/buyorder.png
             * url : guazi://openapi/openWebview?url=http%3A%2F%2Fuc.guazi.com%2F%23%2Fbuycarlist%3Fca_s%3Dapp_tg%26ca_n%3Dmeizu
             * ge : 02859547
             * value :
             * needLogin : 1
             * desc :
             */

            private String title;
            private String alias;
            private String imageUrl;
            private String url;
            private String ge;
            private String value;
            private int needLogin;
            private String desc;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getGe() {
                return ge;
            }

            public void setGe(String ge) {
                this.ge = ge;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public int getNeedLogin() {
                return needLogin;
            }

            public void setNeedLogin(int needLogin) {
                this.needLogin = needLogin;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }
}
