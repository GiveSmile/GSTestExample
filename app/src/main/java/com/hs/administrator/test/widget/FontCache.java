package com.hs.administrator.test.widget;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * @auther : yanbin
 * @time : 2018/7/24 0024 11:00
 * @describe :
 */

public class FontCache {
    // fongUrl是自定义字体分类的名称
    private static String fongUrl = "fonts/test.ttf";
    //Typeface是字体，这里我们创建一个对象
    private static Typeface tf;

    /**
     * 设置字体
     */
    public static Typeface setFont(Context context)
    {
        if (tf == null)
        {
            //给它设置你传入的自定义字体文件，再返回回来
            tf = Typeface.createFromAsset(context.getAssets(),fongUrl);
        }
        return tf;
    }
}
