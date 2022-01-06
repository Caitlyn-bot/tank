package com.zzw.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 资源管理器
 * @author 张志伟
 * @version v1.0
 */
public class ResourceMgr {
    /**
     * 主战坦克的图片
     */
    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    /**
     * 子弹的图片
     */
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;
    /**
     * 爆炸的图片
     */
    public static BufferedImage[] explodes = new BufferedImage[16];


    static {
        try {
            //加载坦克图片
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);
            //加载子弹图片
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            //加载爆炸图片
            for(int i=0; i<16; i++){
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
