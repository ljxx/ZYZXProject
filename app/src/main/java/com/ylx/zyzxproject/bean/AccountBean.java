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
 * 创建日期：2017/7/18  下午2:40
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class AccountBean implements Serializable {

    /**
     * totalAccount : 9.1797862429E8
     * notYetDelivery : 47
     * noSetup : 0
     * quota : 5099900642
     * won : 66
     * nickname : 扣欧诺11
     * attention : 75
     * tqznum : 0
     * delivered : 0
     * userId : 8039936
     * entrust : 0
     * unPaid : 2
     */

    private double totalAccount;
    private int notYetDelivery;
    private int noSetup;
    private long quota;
    private int won;
    private String nickname;
    private int attention;
    private int tqznum;
    private int delivered;
    private int userId;
    private int entrust;
    private int unPaid;

    public double getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(double totalAccount) {
        this.totalAccount = totalAccount;
    }

    public int getNotYetDelivery() {
        return notYetDelivery;
    }

    public void setNotYetDelivery(int notYetDelivery) {
        this.notYetDelivery = notYetDelivery;
    }

    public int getNoSetup() {
        return noSetup;
    }

    public void setNoSetup(int noSetup) {
        this.noSetup = noSetup;
    }

    public long getQuota() {
        return quota;
    }

    public void setQuota(long quota) {
        this.quota = quota;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public int getTqznum() {
        return tqznum;
    }

    public void setTqznum(int tqznum) {
        this.tqznum = tqznum;
    }

    public int getDelivered() {
        return delivered;
    }

    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEntrust() {
        return entrust;
    }

    public void setEntrust(int entrust) {
        this.entrust = entrust;
    }

    public int getUnPaid() {
        return unPaid;
    }

    public void setUnPaid(int unPaid) {
        this.unPaid = unPaid;
    }
}
