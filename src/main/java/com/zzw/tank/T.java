package com.zzw.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 张志伟
 * @version v1.0
 */
public class T {
    public static void main(String[] args) {
        Frame f = new Frame();
        //设置窗口初始大小
        f.setSize(800,600);
        //窗口是否可以修改大小
        f.setResizable(true);
        //设置标题
        f.setTitle("tank war");
        //窗口设为可见
        f.setVisible(true);
        //添加监听事件，监听windowClosing事件
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
