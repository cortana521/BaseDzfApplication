package com.example.dzfbase.utils;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;


import com.example.dzfbase.App;
import com.example.dzfbase.base.BaseApplication;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import androidx.annotation.ArrayRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;


/**
 * Created by jhonbjson on 2017/10/9.
 * 获取资源的工具类
 */
public class ResUtil {
    public static final float MAX_ALPHA = 1.0F;
    public static final float MIN_ALPHA = 0.0F;

    public static String getString(@StringRes int resId) {
        return App.getInstances().getString(resId);
    }

    public static String getString(Context context, @StringRes int resId) {
        if (context == null) {
            return "";
        }
        return context.getApplicationContext().getString(resId);
    }

    public static String getString(Context context, @StringRes int resId, Object... obj) {
        if (context == null) {
            return "";
        }
        return context.getApplicationContext().getString(resId, obj);
    }

    public static String getString(@StringRes int resId, Object... obj) {
        return App.getInstances().getString(resId, obj);
    }


    public static String getString(String formatString, Object... obj) {
        return String.format(formatString, obj);
    }

    public static String[] getStringArray(@ArrayRes int resId) {
        return App.getInstances().getResources().getStringArray(resId);
    }


    public static int getColor(Context context, @ColorRes int resId) {
        return ContextCompat.getColor(context.getApplicationContext(), resId);
    }

    public static int getColor(@ColorRes int resId) {
        return ContextCompat.getColor(App.getInstances(), resId);
    }

    public static ColorStateList getColorStateList(Context context, @ColorRes int resId) {
        return ContextCompat.getColorStateList(context.getApplicationContext(), resId);
    }

    public static ColorStateList getColorStateList(@ColorRes int resId) {
        return ContextCompat.getColorStateList(App.getInstances(), resId);
    }


    public static Drawable getDrawable(Context context, @DrawableRes int resId) {
        return ContextCompat.getDrawable(context.getApplicationContext(), resId);
    }

    public static Drawable getDrawable(@DrawableRes int resId) {
        return ContextCompat.getDrawable(App.getInstances(), resId);

    }

    public static int getDimens(Context context, @DimenRes int resId) {
        return context.getApplicationContext().getResources().getDimensionPixelSize(resId);
    }

    public static int getDimens(@DimenRes int resId) {
        return App.getInstances().getResources().getDimensionPixelSize(resId);
    }

    /**
     * 获取字体大小相同不同颜色的2个字符组成的字符串
     */
    public static Spannable getColorString(String font, String after, int fontColor, int afterColor) {
        String connectStr = new StringBuilder().append(font).append(after).toString();
        Spannable span = new SpannableString(connectStr);
        int indexOfFont = connectStr.indexOf(font);
        int indexOfAfter = connectStr.indexOf(after);
        span.setSpan(new ForegroundColorSpan(fontColor), indexOfFont, indexOfFont + font.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(afterColor), indexOfAfter, indexOfAfter + after.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return span;
    }

    public static int sp2px(Context context,float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics()
                .scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int dp2px(Context context,int dip) {
        final float scale =  context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * 改变颜色透明度
     *
     * @param gradient   透明 0.0完全透明-1.0完全不透明
     * @param colorResId 改变透明度颜色
     * @return 返回不用颜色值
     */
    public static int getAlphaColor(float gradient, int colorResId) {
        colorResId = ResUtil.getColor(colorResId);
        int alpha = Color.alpha(colorResId);
        int red = Color.red(colorResId);
        int green = Color.green(colorResId);
        int blue = Color.blue(colorResId);

        float newAlpha = gradient * (float) alpha;
        return Color.argb((int) newAlpha, red, green, blue);
    }

    /**
     * 颜色渐变
     * 从开始到结束过度
     *
     * @param gradient        过度比例 0.0-1.0
     * @param startColorResId 开始颜色
     * @param endColorResId   结束颜色
     * @return 返回过度颜色值
     */
    public static int getGradientColor(float gradient, int startColorResId, int endColorResId) {
        startColorResId = ResUtil.getColor(startColorResId);
        endColorResId = ResUtil.getColor(endColorResId);
        if (gradient == 0.0F) {
            return startColorResId;
        } else if (gradient == 1.0F) {
            return endColorResId;
        }
        int startAlpha = Color.alpha(startColorResId);
        int endAlpha = Color.alpha(endColorResId);
        int startRed = Color.red(startColorResId);
        int endRed = Color.red(endColorResId);
        int startGreen = Color.green(startColorResId);
        int endGreen = Color.green(endColorResId);
        int startBlue = Color.blue(startColorResId);
        int endBlue = Color.blue(endColorResId);

        float newAlpha = (float) startAlpha + ((float) endAlpha - (float) startAlpha) * gradient;
        float newRed = (float) startRed + ((float) endRed - (float) startRed) * gradient;
        float newGreen = (float) startGreen + ((float) endGreen - (float) startGreen) * gradient;
        float newBlue = (float) startBlue + ((float) endBlue - (float) startBlue) * gradient;
        return Color.argb((int) newAlpha, (int) newRed, (int) newGreen, (int) newBlue);
    }

    /**
     * 变化透明度截取
     *
     * @param gradient
     * @return
     */
    public static float getGradientOne(float gradient) {
        gradient = Math.abs(gradient);
        gradient = gradient > MAX_ALPHA ? MAX_ALPHA : gradient;
//        gradient = gradient > 0.9F ? MAX_ALPHA : gradient;
//        gradient = gradient < 0.1F ? MIN_ALPHA : gradient;
        return (float) ((int) (gradient * 100F)) / 100F;
    }


    public static int[] getResArray(@ArrayRes int arrayResId) {
        TypedArray typedArray = App.getInstances().getResources().obtainTypedArray(arrayResId);
        int len = typedArray.length();
        int[] resId = new int[len];
        for (int i = 0; i < len; i++) {
            resId[i] = typedArray.getResourceId(i, -1);
        }
        typedArray.recycle();
        return resId;
    }

    /**
     * 32位MD5加密
     *
     * @param content -- 待加密内容
     * @return
     */
    public static String md5Decode(String content) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(content.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        }
        //对生成的16字节数组进行补零操作
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}
