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
 * 创建日期：2017/7/18  下午4:50
 * <p/>
 * 描 述：发送短信
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class SendMessageBean implements Serializable {


    /**
     * verify_no : 18638583618
     * created_at : 2017-07-18 17:11:28
     * captcha : 301362
     */

    private String verify_no;
    private String created_at;
    private String captcha;

    public String getVerify_no() {
        return verify_no;
    }

    public void setVerify_no(String verify_no) {
        this.verify_no = verify_no;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
