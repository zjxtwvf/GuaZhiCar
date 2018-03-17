package com.terminator.zjxtwvf.guazi.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/1/8.
 */

public class SellDetailInfoEntity {
    /**
     * code : 0
     * message : 成功
     * data : {"new_car_banner":[{"id":"143","title":"瓜子保卖服务","imgUrl":"https://image.guazistatic.com/gz01170921/14/12/b2aaa5e6b79f1b9e402000e6fdcac1f4.png@base@tag=imgScale","link":"https://guaziapp-m.guazi.com/cd/baoMai/?clueS=13&from=sell&scode=10101021631&ca_s=app_tg&ca_n=meizu","ge":"1213321000000001","position":"0","end_time":1524062183},{"id":"181","title":"0到1成首付买新车","imgUrl":"https://image.guazistatic.com/gz01180105/10/35/acbeb3657af72957373a21f8a5b9cfcc.png@base@tag=imgScale","link":"https://m.maodou.com?ca_s=xcsop_guaziapp&ca_n=sellcarbanner","ge":"1213310000123401","position":"1","end_time":1524062183}],"phone":"4000189962","gujia_url":"https://sta.guazi.com/we_client/c2c-common.html#appraisal?ca_s=app_tg&ca_n=meizu&platform=5&city_id=45&city_name=%E6%88%90%E9%83%BD&domain=cd&clueSourceCode=10101021631%2312&domain_tel=cd","banner_pic":"https://image.guazistatic.com/gz01171222/12/14/0e5b19e24440d403623bac2feb841f7f.png@base@tag=imgScale","sell_car_top_banner":[{"id":"86","title":"帮你高价卖好车","imgUrl":"https://image.guazistatic.com/gz01171222/12/14/0e5b19e24440d403623bac2feb841f7f.png@base@tag=imgScale","link":"","ge":"","position":"0","end_time":1524062183}],"clueNum":24708029,"pic_url":["https://sta.guazistatic.com/static/c2c/app/sell/sell-detail1_v2.png","https://sta.guazistatic.com/static/c2c/app/sell/sell-detail2.png","https://sta.guazistatic.com/static/c2c/app/sell/sell-detail3.png","https://sta.guazistatic.com/static/c2c/app/sell/sell-detail4.png"],"question":[{"ques":"瓜子二手车直卖网是谁？","anser":"瓜子二手车直卖网是中国领先的二手车直卖平台，平均每一分钟就成交一辆。瓜子二手车撮合个人直接卖给个人，没有中间商赚差价。在瓜子平台上，车源均为8年15万公里以内的个人二手车，并通过瓜子专业评估师的五维立体检测，从源头保障车况。"},{"ques":"出售车辆需符合怎样的条件？","anser":"年限里程需在8年/15万公里内，无重大事故，个人车源，过户次数不超过2次且最近2个月内无过户记录"},{"ques":"卖车流程是怎样的？","anser":"1、提交手机号码或拨打400-630-6361联系我们\n2、接受评估师专业的上门质检，定出售价\n3、评估师、交易专员带领买家上门看车\n4、达成交易协议，瓜子二手车直卖网帮你办过户"},{"ques":"卖车需要准备些什么？","anser":"在提交手机号码后，我们会与您联系，在约定时间准备好以下材料即可：\n1、身份证\n2、行驶证\n3、车辆登记证\n4、购置税本\n5、购置税发票\n6、车辆钥匙\n7、交强险单\n8、购车发票/最近一次过户发票"},{"ques":"大概多久能成交？","anser":"大部分车辆在瓜子二手车直卖网上只需一周就可成交"},{"ques":"是否收取费用？","anser":"瓜子二手车直卖网不会收取卖家任何费用，交易达成才会向买家收取不超过交易金额4%的服务费"}],"progress":"guazi://openapi/openWebview?url=https%3A%2F%2Fuc.guazi.com%2F%23%2FsellCarList&title=%E5%8D%96%E8%BD%A6%E8%BF%9B%E5%BA%A6"}
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
         * new_car_banner : [{"id":"143","title":"瓜子保卖服务","imgUrl":"https://image.guazistatic.com/gz01170921/14/12/b2aaa5e6b79f1b9e402000e6fdcac1f4.png@base@tag=imgScale","link":"https://guaziapp-m.guazi.com/cd/baoMai/?clueS=13&from=sell&scode=10101021631&ca_s=app_tg&ca_n=meizu","ge":"1213321000000001","position":"0","end_time":1524062183},{"id":"181","title":"0到1成首付买新车","imgUrl":"https://image.guazistatic.com/gz01180105/10/35/acbeb3657af72957373a21f8a5b9cfcc.png@base@tag=imgScale","link":"https://m.maodou.com?ca_s=xcsop_guaziapp&ca_n=sellcarbanner","ge":"1213310000123401","position":"1","end_time":1524062183}]
         * phone : 4000189962
         * gujia_url : https://sta.guazi.com/we_client/c2c-common.html#appraisal?ca_s=app_tg&ca_n=meizu&platform=5&city_id=45&city_name=%E6%88%90%E9%83%BD&domain=cd&clueSourceCode=10101021631%2312&domain_tel=cd
         * banner_pic : https://image.guazistatic.com/gz01171222/12/14/0e5b19e24440d403623bac2feb841f7f.png@base@tag=imgScale
         * sell_car_top_banner : [{"id":"86","title":"帮你高价卖好车","imgUrl":"https://image.guazistatic.com/gz01171222/12/14/0e5b19e24440d403623bac2feb841f7f.png@base@tag=imgScale","link":"","ge":"","position":"0","end_time":1524062183}]
         * clueNum : 24708029
         * pic_url : ["https://sta.guazistatic.com/static/c2c/app/sell/sell-detail1_v2.png","https://sta.guazistatic.com/static/c2c/app/sell/sell-detail2.png","https://sta.guazistatic.com/static/c2c/app/sell/sell-detail3.png","https://sta.guazistatic.com/static/c2c/app/sell/sell-detail4.png"]
         * question : [{"ques":"瓜子二手车直卖网是谁？","anser":"瓜子二手车直卖网是中国领先的二手车直卖平台，平均每一分钟就成交一辆。瓜子二手车撮合个人直接卖给个人，没有中间商赚差价。在瓜子平台上，车源均为8年15万公里以内的个人二手车，并通过瓜子专业评估师的五维立体检测，从源头保障车况。"},{"ques":"出售车辆需符合怎样的条件？","anser":"年限里程需在8年/15万公里内，无重大事故，个人车源，过户次数不超过2次且最近2个月内无过户记录"},{"ques":"卖车流程是怎样的？","anser":"1、提交手机号码或拨打400-630-6361联系我们\n2、接受评估师专业的上门质检，定出售价\n3、评估师、交易专员带领买家上门看车\n4、达成交易协议，瓜子二手车直卖网帮你办过户"},{"ques":"卖车需要准备些什么？","anser":"在提交手机号码后，我们会与您联系，在约定时间准备好以下材料即可：\n1、身份证\n2、行驶证\n3、车辆登记证\n4、购置税本\n5、购置税发票\n6、车辆钥匙\n7、交强险单\n8、购车发票/最近一次过户发票"},{"ques":"大概多久能成交？","anser":"大部分车辆在瓜子二手车直卖网上只需一周就可成交"},{"ques":"是否收取费用？","anser":"瓜子二手车直卖网不会收取卖家任何费用，交易达成才会向买家收取不超过交易金额4%的服务费"}]
         * progress : guazi://openapi/openWebview?url=https%3A%2F%2Fuc.guazi.com%2F%23%2FsellCarList&title=%E5%8D%96%E8%BD%A6%E8%BF%9B%E5%BA%A6
         */

        private String phone;
        private String gujia_url;
        private String banner_pic;
        private int clueNum;
        private String progress;
        private List<NewCarBannerBean> new_car_banner;
        private List<SellCarTopBannerBean> sell_car_top_banner;
        private List<String> pic_url;
        private List<QuestionBean> question;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getGujia_url() {
            return gujia_url;
        }

        public void setGujia_url(String gujia_url) {
            this.gujia_url = gujia_url;
        }

        public String getBanner_pic() {
            return banner_pic;
        }

        public void setBanner_pic(String banner_pic) {
            this.banner_pic = banner_pic;
        }

        public int getClueNum() {
            return clueNum;
        }

        public void setClueNum(int clueNum) {
            this.clueNum = clueNum;
        }

        public String getProgress() {
            return progress;
        }

        public void setProgress(String progress) {
            this.progress = progress;
        }

        public List<NewCarBannerBean> getNew_car_banner() {
            return new_car_banner;
        }

        public void setNew_car_banner(List<NewCarBannerBean> new_car_banner) {
            this.new_car_banner = new_car_banner;
        }

        public List<SellCarTopBannerBean> getSell_car_top_banner() {
            return sell_car_top_banner;
        }

        public void setSell_car_top_banner(List<SellCarTopBannerBean> sell_car_top_banner) {
            this.sell_car_top_banner = sell_car_top_banner;
        }

        public List<String> getPic_url() {
            return pic_url;
        }

        public void setPic_url(List<String> pic_url) {
            this.pic_url = pic_url;
        }

        public List<QuestionBean> getQuestion() {
            return question;
        }

        public void setQuestion(List<QuestionBean> question) {
            this.question = question;
        }

        public static class NewCarBannerBean {
            /**
             * id : 143
             * title : 瓜子保卖服务
             * imgUrl : https://image.guazistatic.com/gz01170921/14/12/b2aaa5e6b79f1b9e402000e6fdcac1f4.png@base@tag=imgScale
             * link : https://guaziapp-m.guazi.com/cd/baoMai/?clueS=13&from=sell&scode=10101021631&ca_s=app_tg&ca_n=meizu
             * ge : 1213321000000001
             * position : 0
             * end_time : 1524062183
             */

            private String id;
            private String title;
            private String imgUrl;
            private String link;
            private String ge;
            private String position;
            private int end_time;

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
        }

        public static class SellCarTopBannerBean {
            /**
             * id : 86
             * title : 帮你高价卖好车
             * imgUrl : https://image.guazistatic.com/gz01171222/12/14/0e5b19e24440d403623bac2feb841f7f.png@base@tag=imgScale
             * link :
             * ge :
             * position : 0
             * end_time : 1524062183
             */

            private String id;
            private String title;
            private String imgUrl;
            private String link;
            private String ge;
            private String position;
            private int end_time;

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
        }

        public static class QuestionBean {
            /**
             * ques : 瓜子二手车直卖网是谁？
             * anser : 瓜子二手车直卖网是中国领先的二手车直卖平台，平均每一分钟就成交一辆。瓜子二手车撮合个人直接卖给个人，没有中间商赚差价。在瓜子平台上，车源均为8年15万公里以内的个人二手车，并通过瓜子专业评估师的五维立体检测，从源头保障车况。
             */

            private String ques;
            private String anser;

            public String getQues() {
                return ques;
            }

            public void setQues(String ques) {
                this.ques = ques;
            }

            public String getAnser() {
                return anser;
            }

            public void setAnser(String anser) {
                this.anser = anser;
            }
        }
    }
}
