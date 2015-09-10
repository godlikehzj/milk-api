package com.godlikehzj.milk.util;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by godlikehzj on 15/9/9.
 */
public class SysApiStatus {
    public static Map<Integer,String> message=new HashMap<Integer, String>();;
    public static final Integer OK=200;
    public static final Integer ERROR=500;
    public static final Integer SYSTEMERROR=50000;

    static{
        message.put(OK,"成功");
        message.put(ERROR, "失败");
        message.put(SYSTEMERROR, "系统错误");
    }
    public static String getMessage(Integer key) {
        return message.get(key);
    }

}
