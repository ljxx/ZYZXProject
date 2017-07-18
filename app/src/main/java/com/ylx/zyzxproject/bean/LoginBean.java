package com.ylx.zyzxproject.bean;

import java.io.Serializable;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/7/18  下午3:22
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class LoginBean implements Serializable {


    /**
     * status : SUCCESS
     * detail : 请求数据成功
     * data : {"login":"8039936","display":"扣欧诺11","loginTime":"2017-07-18 16:33:48","openId":"oy6lLs4pgBlU1am8f4K5UP8YjjGI","userId":"8039936","mobile":"18638583609","user":"8039936","isRandomPwd":0,"ticket":"MTEyZmM2NjEtMTM4Yy00YjhlLWFhZTktNzZmN2U2NjM1MmE5","channelId":"WECHAT","key":"fef9d436-6b26-43b2-9dbb-4a819aef37de","id":"K8oQ1cOaB50awSz25Lu","type":0}
     */

    private String status;
    private String detail;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * login : 8039936
         * display : 扣欧诺11
         * loginTime : 2017-07-18 16:33:48
         * openId : oy6lLs4pgBlU1am8f4K5UP8YjjGI
         * userId : 8039936
         * mobile : 18638583609
         * user : 8039936
         * isRandomPwd : 0
         * ticket : MTEyZmM2NjEtMTM4Yy00YjhlLWFhZTktNzZmN2U2NjM1MmE5
         * channelId : WECHAT
         * key : fef9d436-6b26-43b2-9dbb-4a819aef37de
         * id : K8oQ1cOaB50awSz25Lu
         * type : 0
         */

        private String login;
        private String display;
        private String loginTime;
        private String openId;
        private String userId;
        private String mobile;
        private String user;
        private int isRandomPwd;
        private String ticket;
        private String channelId;
        private String key;
        private String id;
        private int type;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getDisplay() {
            return display;
        }

        public void setDisplay(String display) {
            this.display = display;
        }

        public String getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(String loginTime) {
            this.loginTime = loginTime;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public int getIsRandomPwd() {
            return isRandomPwd;
        }

        public void setIsRandomPwd(int isRandomPwd) {
            this.isRandomPwd = isRandomPwd;
        }

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
