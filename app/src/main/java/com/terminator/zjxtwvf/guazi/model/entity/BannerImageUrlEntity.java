package com.terminator.zjxtwvf.guazi.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/16.
 */

public class BannerImageUrlEntity {

    /**
     * code : 0
     * message : 成功
     * data : [{"type":2,"title":"瓜子好车汇","imgUrl":"https://image.guazistatic.com/gz01171212/16/33/264cb3f1f9c342ebd95d2d5ba8c5fd35.png@base@tag=imgScale","linkUrl":"https://sta.guazi.com/we_client/promotion.html#good-car-third","ge":"92834577"},{"type":2,"title":"瓜子优选 百里挑一","imgUrl":"https://image.guazistatic.com/gz01171214/15/22/ae3ab905b602206d879e12d576fa8214.png@base@tag=imgScale","linkUrl":"https://sta.guazi.com/we_client/promotion.html#optimum-car","ge":"92756687"},{"type":2,"title":"限时大降价","imgUrl":"https://image.guazistatic.com/gz01171206/14/04/53066aa67fc710f5803e414c6c864135.png@base@tag=imgScale","linkUrl":"https://sta.guazi.com/we_client/promotion.html#on-sale","ge":"92511170"},{"type":2,"title":"瓜子保障节","imgUrl":"https://image.guazistatic.com/gz01171111/11/20/509e3fd0f330820c0a844c54707b97a1.png@base@tag=imgScale","linkUrl":"https://sta.guazi.com/we_client/promotion.html#protect","ge":"92565197"},{"type":2,"title":"立即拿车款  安心卖高价","imgUrl":"https://image.guazistatic.com/gz01170921/14/03/f3af03674827c29aa505af1d06f74c4e.png@base@tag=imgScale","linkUrl":"https://guaziapp-m.guazi.com/www/baoMai/?clueS=14&from=index","ge":"1210240000000027"},{"type":2,"title":"向事故车说NO！","imgUrl":"https://image.guazistatic.com/gz01171204/19/10/df1c907931fd3cc532a492f03c8bfefa.jpg@base@tag=imgScale","linkUrl":"https://guaziapp-m.guazi.com/misc/article/?filter=4415","ge":"92509838"},{"type":2,"title":"瓜子二手车直卖网","imgUrl":"https://image.guazistatic.com/gz01171130/21/54/3d09b0ef48f34e676aea8e7d9bd804a5.png@base@tag=imgScale","linkUrl":"https://guaziapp-m.guazi.com/misc/article/4248/","ge":"1210240000000026"}]
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

    public static class DataBean extends Object{
        /**
         * type : 2
         * title : 瓜子好车汇
         * imgUrl : https://image.guazistatic.com/gz01171212/16/33/264cb3f1f9c342ebd95d2d5ba8c5fd35.png@base@tag=imgScale
         * linkUrl : https://sta.guazi.com/we_client/promotion.html#good-car-third
         * ge : 92834577
         */

        private int type;
        private String title;
        private String imgUrl;
        private String linkUrl;
        private String ge;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public String getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        public String getGe() {
            return ge;
        }

        public void setGe(String ge) {
            this.ge = ge;
        }
    }
}
