package com.itxiaoming.materialdesign.utils;

import android.util.Log;

/**
 * 作者:xjm.
 * 邮箱:xiaojiaming@infosec.com.cn
 * 公司:Infosec Technology
 * 创建时间:Created on 2017/1/13 13:17.
 * 该类的作用:用于打印日志
 * 版本号:
 */

public class LogUtil {
    public static final int VERBOSE=1;

    public static final int DEBUG=2;

    public static final int INFO=3;

    public static final int WARN=4;

    public static final int ERROR=5;

    public static final int NOTHING=6;

    //制定level的值来分别打印不同的Log日志
    public static int level = VERBOSE;
    public static void v(String tag,String msg){
        if(level <= VERBOSE){
            Log.v(tag,msg);
        }
    }
    public static void d(String tag,String msg){
        if(level <= DEBUG){
            Log.d(tag,msg);
        }
    }
    public static void i(String tag,String msg){
        if(level <= INFO){
            Log.i(tag,msg);
        }
    }
    public static void w(String tag,String msg){
        if(level <= WARN){
            Log.w(tag,msg);
        }
    }
    public static void e(String tag,String msg){
        if(level <= ERROR){
            Log.e(tag,msg);
        }
    }
}
