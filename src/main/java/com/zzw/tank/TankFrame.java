package com.zzw.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 张志伟
 * @version v1.0
 */
public class TankFrame extends Frame {

    public TankFrame(){
        //设置窗口初始大小
        this.setSize(800,600);
        //窗口是否可以修改大小
        this.setResizable(true);
        //设置标题
        this.setTitle("tank war");
        //窗口设为可见
        this.setVisible(true);
        //添加监听事件，监听windowClosing事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 当窗口被改变时被自动调用
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g){
        g.fillRect(200,200,50,50);
        System.out.println("paint");
    }

}
