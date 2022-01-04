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
     * 坦克的图片
     */
    public static BufferedImage tankL, tankR, tankU, tankD;
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
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            //加载子弹图片
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            //加载爆炸图片
            for(int i=0; i<16; i++){
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
