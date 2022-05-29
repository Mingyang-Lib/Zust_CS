package com.mr.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class CanvasPanel extends JPanel implements KeyListener {
    int x1 = 0, x2 = 800;
    Dinosaur dinosaur;
    Obstacle obstacle; // 产生一个对象

    // 实现键盘接口
    public CanvasPanel(Dinosaur dinosaur, Obstacle obstacle)
    {  // 对其他包、类可见
        this.dinosaur = dinosaur;  // 参数传递
        this.obstacle = obstacle;
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(BackgroundImage.img, x1, 0, this);  // 整个图片必须在框架类下才能显示出来
        g2.drawImage(BackgroundImage.img_1, x2,0,this);
        g2.drawImage(dinosaur.image_show, 20, Dinosaur.y_dinosaur, this);
        g2.drawImage(obstacle.img_display(), obstacle.obstacle_x, obstacle.obstacle_y, this);  // 在面板上画障碍物
        // 固定的障碍物变成随机的障碍物
//        LoopDisplayImg(g2);
    }


    public void roll(){
        // 第一张图片左移的效果, 第二张图片左移效果
        x1 -= BackgroundImage.speed;
        x2 -= BackgroundImage.speed;

        if(x1 <= -800){ // 当图片左移动的时候
            x1 = 800;
        }
        if(x2 <= -800){
            x2 = 800;
        }
    }

    // 实现
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
//            dinosaur.jump();
            dinosaur.move();  // 一直点键盘才有用
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

//void LoopDisplayImg(Graphics2D g2){
//    void LoopDisplayImg2(Graphics2D g2){
//        System.out.println();
//    }
//
//}