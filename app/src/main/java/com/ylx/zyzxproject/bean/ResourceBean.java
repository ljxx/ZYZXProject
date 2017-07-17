package com.ylx.zyzxproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/7/17  下午3:38
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class ResourceBean implements Serializable {


    /**
     * mobile : {"root":"http://192.168.16.131:8080","vizseek":"http://192.168.16.131:8080/vizseek","meta":"http://192.168.16.131:8080/meta","sms":"http://192.168.16.131:8080/sms","search":"http://116.236.187.5:8282/search","auth1":"http://116.236.187.3:8096/auth","auth":"http://116.236.187.5:11008/auth","autha":"https://116.236.187.3:8008/auth","captcha":"http://192.168.16.131:8080/captcha","password":"http://192.168.16.131:8080/password","collection":"http://192.168.16.131:8080/collection","register":"http://192.168.16.131:8080/register","user":"http://192.168.16.131:8080/user","auction":"http://192.168.16.131:8080/auction","bidding":"http://116.236.187.5:9097/bidding","pub":"http://192.168.16.131:8080/pub","special":"http://192.168.16.131:8080/special","push":"http://116.236.187.3:3001/app","share":"http://116.236.187.3:9090/auction-detail-share-mobile.shtml","h5":"http://192.168.16.131:8080/h5","coupon":"http://ft1.coupon.zhaoonline.com/coupon","cms":"http://116.236.187.5:8085","bms":"http://116.236.187.5:9091","index_recommend_search":"&order=from,collection,endAt&orderBy=desc,desc,asc&recommend=1&stage=2&stage=1&collection=100,157,520,400,700,600","version":{"valid_versions":["3.3"],"android_versions":["2.2","3.0"],"android_jc_version":["1.0"],"ios_url":"https://itunes.apple.com/us/app/zhao-yong-zai-xian-you-piao/id468613187?l=zh&ls=1&mt=8","android_url":"http://zhushou.360.cn/detail/index/soft_id/2389667","is_force":"true","isUpdatejcApk":"true"}}
     * user_service : {"meta":"http://116.236.187.5:13005/meta","auth":"http://116.236.187.5:13005/auth","register":"http://116.236.187.5:13005/register","user":"http://116.236.187.5:13005/user","user_nickname":"http://116.236.187.5:13005/user/nickname","user_address":"http://116.236.187.5:13005/user/address","user_password":"http://116.236.187.5:13005/user/password","user_phone_valid":"http://116.236.187.5:13005/user/cert/phone","version":"0.1"}
     */

    private MobileBean mobile;
    private UserServiceBean user_service;

    public MobileBean getMobile() {
        return mobile;
    }

    public void setMobile(MobileBean mobile) {
        this.mobile = mobile;
    }

    public UserServiceBean getUser_service() {
        return user_service;
    }

    public void setUser_service(UserServiceBean user_service) {
        this.user_service = user_service;
    }

    public static class MobileBean {
        /**
         * root : http://192.168.16.131:8080
         * vizseek : http://192.168.16.131:8080/vizseek
         * meta : http://192.168.16.131:8080/meta
         * sms : http://192.168.16.131:8080/sms
         * search : http://116.236.187.5:8282/search
         * auth1 : http://116.236.187.3:8096/auth
         * auth : http://116.236.187.5:11008/auth
         * autha : https://116.236.187.3:8008/auth
         * captcha : http://192.168.16.131:8080/captcha
         * password : http://192.168.16.131:8080/password
         * collection : http://192.168.16.131:8080/collection
         * register : http://192.168.16.131:8080/register
         * user : http://192.168.16.131:8080/user
         * auction : http://192.168.16.131:8080/auction
         * bidding : http://116.236.187.5:9097/bidding
         * pub : http://192.168.16.131:8080/pub
         * special : http://192.168.16.131:8080/special
         * push : http://116.236.187.3:3001/app
         * share : http://116.236.187.3:9090/auction-detail-share-mobile.shtml
         * h5 : http://192.168.16.131:8080/h5
         * coupon : http://ft1.coupon.zhaoonline.com/coupon
         * cms : http://116.236.187.5:8085
         * bms : http://116.236.187.5:9091
         * index_recommend_search : &order=from,collection,endAt&orderBy=desc,desc,asc&recommend=1&stage=2&stage=1&collection=100,157,520,400,700,600
         * version : {"valid_versions":["3.3"],"android_versions":["2.2","3.0"],"android_jc_version":["1.0"],"ios_url":"https://itunes.apple.com/us/app/zhao-yong-zai-xian-you-piao/id468613187?l=zh&ls=1&mt=8","android_url":"http://zhushou.360.cn/detail/index/soft_id/2389667","is_force":"true","isUpdatejcApk":"true"}
         */

        private String root;
        private String vizseek;
        private String meta;
        private String sms;
        private String search;
        private String auth1;
        private String auth;
        private String autha;
        private String captcha;
        private String password;
        private String collection;
        private String register;
        private String user;
        private String auction;
        private String bidding;
        private String pub;
        private String special;
        private String push;
        private String share;
        private String h5;
        private String coupon;
        private String cms;
        private String bms;
        private String index_recommend_search;
        private VersionBean version;

        public String getRoot() {
            return root;
        }

        public void setRoot(String root) {
            this.root = root;
        }

        public String getVizseek() {
            return vizseek;
        }

        public void setVizseek(String vizseek) {
            this.vizseek = vizseek;
        }

        public String getMeta() {
            return meta;
        }

        public void setMeta(String meta) {
            this.meta = meta;
        }

        public String getSms() {
            return sms;
        }

        public void setSms(String sms) {
            this.sms = sms;
        }

        public String getSearch() {
            return search;
        }

        public void setSearch(String search) {
            this.search = search;
        }

        public String getAuth1() {
            return auth1;
        }

        public void setAuth1(String auth1) {
            this.auth1 = auth1;
        }

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }

        public String getAutha() {
            return autha;
        }

        public void setAutha(String autha) {
            this.autha = autha;
        }

        public String getCaptcha() {
            return captcha;
        }

        public void setCaptcha(String captcha) {
            this.captcha = captcha;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getCollection() {
            return collection;
        }

        public void setCollection(String collection) {
            this.collection = collection;
        }

        public String getRegister() {
            return register;
        }

        public void setRegister(String register) {
            this.register = register;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getAuction() {
            return auction;
        }

        public void setAuction(String auction) {
            this.auction = auction;
        }

        public String getBidding() {
            return bidding;
        }

        public void setBidding(String bidding) {
            this.bidding = bidding;
        }

        public String getPub() {
            return pub;
        }

        public void setPub(String pub) {
            this.pub = pub;
        }

        public String getSpecial() {
            return special;
        }

        public void setSpecial(String special) {
            this.special = special;
        }

        public String getPush() {
            return push;
        }

        public void setPush(String push) {
            this.push = push;
        }

        public String getShare() {
            return share;
        }

        public void setShare(String share) {
            this.share = share;
        }

        public String getH5() {
            return h5;
        }

        public void setH5(String h5) {
            this.h5 = h5;
        }

        public String getCoupon() {
            return coupon;
        }

        public void setCoupon(String coupon) {
            this.coupon = coupon;
        }

        public String getCms() {
            return cms;
        }

        public void setCms(String cms) {
            this.cms = cms;
        }

        public String getBms() {
            return bms;
        }

        public void setBms(String bms) {
            this.bms = bms;
        }

        public String getIndex_recommend_search() {
            return index_recommend_search;
        }

        public void setIndex_recommend_search(String index_recommend_search) {
            this.index_recommend_search = index_recommend_search;
        }

        public VersionBean getVersion() {
            return version;
        }

        public void setVersion(VersionBean version) {
            this.version = version;
        }

        public static class VersionBean {
            /**
             * valid_versions : ["3.3"]
             * android_versions : ["2.2","3.0"]
             * android_jc_version : ["1.0"]
             * ios_url : https://itunes.apple.com/us/app/zhao-yong-zai-xian-you-piao/id468613187?l=zh&ls=1&mt=8
             * android_url : http://zhushou.360.cn/detail/index/soft_id/2389667
             * is_force : true
             * isUpdatejcApk : true
             */

            private String ios_url;
            private String android_url;
            private boolean is_force;
            private String isUpdatejcApk;
            private List<String> valid_versions;
            private List<String> android_versions;
            private List<String> android_jc_version;

            public String getIos_url() {
                return ios_url;
            }

            public void setIos_url(String ios_url) {
                this.ios_url = ios_url;
            }

            public String getAndroid_url() {
                return android_url;
            }

            public void setAndroid_url(String android_url) {
                this.android_url = android_url;
            }

            public boolean getIs_force() {
                return is_force;
            }

            public void setIs_force(boolean is_force) {
                this.is_force = is_force;
            }

            public String getIsUpdatejcApk() {
                return isUpdatejcApk;
            }

            public void setIsUpdatejcApk(String isUpdatejcApk) {
                this.isUpdatejcApk = isUpdatejcApk;
            }

            public List<String> getValid_versions() {
                return valid_versions;
            }

            public void setValid_versions(List<String> valid_versions) {
                this.valid_versions = valid_versions;
            }

            public List<String> getAndroid_versions() {
                return android_versions;
            }

            public void setAndroid_versions(List<String> android_versions) {
                this.android_versions = android_versions;
            }

            public List<String> getAndroid_jc_version() {
                return android_jc_version;
            }

            public void setAndroid_jc_version(List<String> android_jc_version) {
                this.android_jc_version = android_jc_version;
            }
        }
    }

    public static class UserServiceBean {
        /**
         * meta : http://116.236.187.5:13005/meta
         * auth : http://116.236.187.5:13005/auth
         * register : http://116.236.187.5:13005/register
         * user : http://116.236.187.5:13005/user
         * user_nickname : http://116.236.187.5:13005/user/nickname
         * user_address : http://116.236.187.5:13005/user/address
         * user_password : http://116.236.187.5:13005/user/password
         * user_phone_valid : http://116.236.187.5:13005/user/cert/phone
         * version : 0.1
         */

        private String meta;
        private String auth;
        private String register;
        private String user;
        private String user_nickname;
        private String user_address;
        private String user_password;
        private String user_phone_valid;
        private String version;

        public String getMeta() {
            return meta;
        }

        public void setMeta(String meta) {
            this.meta = meta;
        }

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }

        public String getRegister() {
            return register;
        }

        public void setRegister(String register) {
            this.register = register;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getUser_nickname() {
            return user_nickname;
        }

        public void setUser_nickname(String user_nickname) {
            this.user_nickname = user_nickname;
        }

        public String getUser_address() {
            return user_address;
        }

        public void setUser_address(String user_address) {
            this.user_address = user_address;
        }

        public String getUser_password() {
            return user_password;
        }

        public void setUser_password(String user_password) {
            this.user_password = user_password;
        }

        public String getUser_phone_valid() {
            return user_phone_valid;
        }

        public void setUser_phone_valid(String user_phone_valid) {
            this.user_phone_valid = user_phone_valid;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
