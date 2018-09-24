package com.monsterlin.demo_dealimg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * <p >图片处理工具类 </p>
 * Created by  monsterLin on 2016/10/25.
 *
 *
 * <p>Android系统不允许直接修改原图<，累死PhotoShop的锁定/p>
 *   <p>必须通过原图创建一个同样大小的bitmap，并将原图会知道bitmap上，以一个副本的形式修改图像</p>
 */

public class ImageHelper {
    public static Bitmap HandleImageEffect(Bitmap bm, float hue, float saturation, float lum) {


        /**将原图转换为bitmap，并且呈现在画布上**/
        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bmp);

        /**  ***/

        Paint paint = new Paint();



        ColorMatrix hueMatrix = new ColorMatrix(); //颜色矩阵，用于处理颜色效果

        /**
         *
         * 设置色调
         * ColorMatrix 中的0,1,2分别代表RED ,GREEN ,BLUE ;
         *
         */

        hueMatrix.setRotate(0, hue);
        hueMatrix.setRotate(1, hue);
        hueMatrix.setRotate(2, hue);


        ColorMatrix saturationMatrix = new ColorMatrix();

        /**
         * 设置饱和度
         */
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();

        /**
         * 设置亮度
         */
        lumMatrix.setScale(lum, lum, lum, 1);


        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        /**
         * 使用画笔绘制原来的图像，从而将颜色矩阵作用到原图上
         */
        canvas.drawBitmap(bm, 0, 0, paint);

        return bmp;

    }
}
