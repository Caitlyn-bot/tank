package com.zzw.tank;

import java.awt.*;

/**
 * 爆炸
 * @author 张志伟
 * @version v1.0
 */
public class Explode {
    /**
     * 爆炸宽度
     */
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    /**
     * 爆炸的高度
     */
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    /**
     * 爆炸的坐标
     */
    private int x, y;
    /**
     * 画到爆炸的第几步
     */
    private int step = 0;

    private TankFrame tf = null;

    public Explode(int x, int y ,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }



    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if(step >= ResourceMgr.explodes.length){
            step = 0;
        }


    }
}
