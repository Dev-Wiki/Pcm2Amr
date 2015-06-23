package com.asia.pcm2amr;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.widget.Toast;

/**
 * Toast工具类
 * @author Asia
 *
 */
public class ToastUtil {
    //工具类私有化构造器,防止实例化
    private ToastUtil(){}
    
    //控制是否显示Toast
    private static boolean isShow = true;
    
    private static String getShowInfo(Context context, int id){
        String info = "";
        try {
            info = context.getResources().getString(id);  
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return info;
    }
    
    /**
     * 显示短时间的Toast
     * @param context 上下文
     * @param info 要显示的信息
     */
    public static void showShort(Context context, String info){
        if (isShow) {
            Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
        }
    }
    
    /**
     * 显示短时间的Toast
     * @param context 上下文
     * @param id 要显示的文字资源id
     */
    public static void showShort(Context context, int id){
        if (isShow) {
            String info = getShowInfo(context, id);
            Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
        }
    }
    
    /**
     * 显示长时间的Toast
     * @param context 上下文
     * @param info 要显示的信息
     */
    public static void showLong(Context context, String info){
        if (isShow) {
            Toast.makeText(context, info, Toast.LENGTH_LONG).show();
        }
    }
    
    /**
     * 显示长时间的Toast
     * @param context 上下文
     * @param id 要显示的文字资源id
     */
    public static void showLong(Context context, int id){
        if (isShow) {
            String info = getShowInfo(context, id);
            Toast.makeText(context, info, Toast.LENGTH_LONG).show();
        }
    }
}
