package com.zzw.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 张志伟
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        TankFrame tf = new TankFrame();

        while (true){
            //每过50毫秒，调用一次repaint方法
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
