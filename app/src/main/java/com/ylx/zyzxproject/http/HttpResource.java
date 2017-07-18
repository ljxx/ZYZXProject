package com.ylx.zyzxproject.http;

import com.ylx.zyzxproject.bean.ResourceBean;

import java.util.HashMap;
import java.util.Map;

public class HttpResource {

    private static final String TAG = "HttpResource";
    private static Map<String, String> resourceMap = new HashMap<String, String>();

    /**
     * 从本地取http resource 资源
     *
     * @param key :要取的资源类型
     */
    public static String getResource(String key) {
        return resourceMap.get(key);
    }

    /**
     * 将本地的resource数据存入一个临时的map中，以便使用时快速查找，而不是去耗时的读取本地资源进行查找
     */

    public static void fastGetResourceFromMap(ResourceBean mBean) {

        ResourceBean.MobileBean mb = mBean.getMobile();

        resourceMap.put("captcha", mb.getCaptcha());
        resourceMap.put("register", mb.getRegister());
        resourceMap.put("user", mb.getUser());
        resourceMap.put("auction", mb.getAuction());
        resourceMap.put("bidding", mb.getBidding());
        resourceMap.put("meta", mb.getMeta());
        resourceMap.put("special", mb.getSpecial());
        resourceMap.put("sms", mb.getSms());
        resourceMap.put("search", mb.getSearch());
        resourceMap.put("auth", mb.getAuth());
        resourceMap.put("collection", mb.getCollection());
        resourceMap.put("root", mb.getRoot());
        resourceMap.put("index_recommend_search",mb.getIndex_recommend_search());
        resourceMap.put("vizseek", mb.getVizseek());
        resourceMap.put("h5", mb.getH5());
        resourceMap.put("password",mb.getPassword());

        ResourceBean.UserServiceBean usb = mBean.getUser_service();
        resourceMap.put("mAuth",usb.getAuth());
        resourceMap.put("mAuth",usb.getAuth());
        resourceMap.put("mRegister",usb.getRegister());
        resourceMap.put("mUser",usb.getUser());
        resourceMap.put("mUserNickName",usb.getUser_nickname());
        resourceMap.put("mUserAddress",usb.getUser_address());
        resourceMap.put("mUserPassword",usb.getUser_password());
        resourceMap.put("mUserPhoneValid",usb.getUser_phone_valid());
    }
}
