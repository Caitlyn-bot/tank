package com.zzw.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 张志伟
 * @version v1.0
 */
public class TankFrame extends Frame {

    int x = 200;
    int y = 200;

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
        //添加键盘的监听事件
        this.addKeyListener(new MyKeyListener());
    }

    /**
     * 当窗口被改变时被自动调用
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
        x += 10;
//        y += 10;
    }

    /**
     * 处理键盘事件监听
     */
    class MyKeyListener extends KeyAdapter{
        /**
         * 一个键被按下时调用
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("key pressed");
            x += 200;
        }

        /**
         * 一个键被重开时调用
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
//            System.out.println("key released");
        }
    }

}
