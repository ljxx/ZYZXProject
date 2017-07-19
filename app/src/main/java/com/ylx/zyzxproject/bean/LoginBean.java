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
     * login_time : 2017-07-19 10:15:02
     * display : 扣欧诺11
     * user_id : 8039936
     * user : 8039936
     * channel_id : WECHAT
     * open_id : oy6lLs4pgBlU1am8f4K5UP8YjjGI
     * mobile : 18638583609
     * ticket : MWY5YjY1NjItYzI4ZC00M2IxLWI5MzMtYTdmMTNmMTcyMWRm
     * is_random_pwd : 0
     * login : 8039936
     * key : 49e777ec-082c-458d-ab16-8d78c376bba2
     * id : IvWTmbPlyOXTEGvvgIe
     * type : 0
     */

    private String login_time;
    private String display;
    private String user_id;
    private String user;
    private String channel_id;
    private String open_id;
    private String mobile;
    private String ticket;
    private int is_random_pwd;
    private String login;
    private String key;
    private String id;
    private int type;

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getIs_random_pwd() {
        return is_random_pwd;
    }

    public void setIs_random_pwd(int is_random_pwd) {
        this.is_random_pwd = is_random_pwd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
