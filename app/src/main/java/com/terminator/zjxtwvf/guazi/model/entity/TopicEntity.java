package com.terminator.zjxtwvf.guazi.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */

public class TopicEntity {
    /**
     * code : 0
     * message : 成功
     * data : {"topline":{"category_name":"瓜子头条","list":[{"tag":"评测","title":"外观秒杀同级，配置还非常出色，拿下大发了","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2959074","color":"#FF7844","ge":"92244570"},{"tag":"评测","title":"实用之选，美系小排量增压的老虎","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2958846","color":"#FF7844","ge":"92244570"},{"tag":"导购","title":"看了标致308s之后才发现一点儿都不比高尔夫差","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2924126","color":"#FFAA06","ge":"92289746"},{"tag":"用车","title":"不懂汽车上按钮？可以用这篇文章打他脸！","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2965229","color":"#00BD92","ge":"92338747"}]}}
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
         * topline : {"category_name":"瓜子头条","list":[{"tag":"评测","title":"外观秒杀同级，配置还非常出色，拿下大发了","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2959074","color":"#FF7844","ge":"92244570"},{"tag":"评测","title":"实用之选，美系小排量增压的老虎","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2958846","color":"#FF7844","ge":"92244570"},{"tag":"导购","title":"看了标致308s之后才发现一点儿都不比高尔夫差","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2924126","color":"#FFAA06","ge":"92289746"},{"tag":"用车","title":"不懂汽车上按钮？可以用这篇文章打他脸！","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2965229","color":"#00BD92","ge":"92338747"}]}
         */

        private ToplineBean topline;

        public ToplineBean getTopline() {
            return topline;
        }

        public void setTopline(ToplineBean topline) {
            this.topline = topline;
        }

        public static class ToplineBean {
            /**
             * category_name : 瓜子头条
             * list : [{"tag":"评测","title":"外观秒杀同级，配置还非常出色，拿下大发了","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2959074","color":"#FF7844","ge":"92244570"},{"tag":"评测","title":"实用之选，美系小排量增压的老虎","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2958846","color":"#FF7844","ge":"92244570"},{"tag":"导购","title":"看了标致308s之后才发现一点儿都不比高尔夫差","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2924126","color":"#FFAA06","ge":"92289746"},{"tag":"用车","title":"不懂汽车上按钮？可以用这篇文章打他脸！","url":"https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2965229","color":"#00BD92","ge":"92338747"}]
             */

            private String category_name;
            private List<ListBean> list;

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * tag : 评测
                 * title : 外观秒杀同级，配置还非常出色，拿下大发了
                 * url : https://www.17getfun.com/publish/detail4guazi?vendor=guazi&id=2959074
                 * color : #FF7844
                 * ge : 92244570
                 */

                private String tag;
                private String title;
                private String url;
                private String color;
                private String ge;

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public String getGe() {
                    return ge;
                }

                public void setGe(String ge) {
                    this.ge = ge;
                }
            }
        }
    }
}
