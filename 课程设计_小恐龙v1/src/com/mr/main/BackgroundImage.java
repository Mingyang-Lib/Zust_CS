package com.mr.main;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class BackgroundImage extends JFrame{
    public static Image img;
    public static Image img_1;
    public static int  speed = 4;  // 确定之后保持不变

    public BackgroundImage() {
        try {
            img = ImageIO.read(new File("./image/背景.png"));
            img_1 = ImageIO.read(new File("./image/背景2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon image = new ImageIcon(img);
        setSize(image.getIconWidth(), image.getIconHeight()); // 获取长宽

        Dinosaur dinosaur = new Dinosaur();
        // 在游戏面板中添加障碍物对象
        Obstacle obstacle = new Obstacle();

        CanvasPanel background = new CanvasPanel(dinosaur, obstacle); // 将恐龙类传递进去 // 构造函数的对象
        addKeyListener(background);  // 添加键盘的对象 框架类检测到消息
        add(background);  // 将背景面板添加到框架上

        FreshThread freshThread = new FreshThread(background, dinosaur, obstacle); // 线程刷新帧  需要传参数  背景的对象传递给线程
        freshThread.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("小恐龙-JAVA课设-吴明洋");
    }

    public static void main(String[] args) {
        new BackgroundImage().setVisible(true);
    }
}
