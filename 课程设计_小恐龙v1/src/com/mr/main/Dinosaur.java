package com.mr.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Dinosaur {
    public Image image_show , img1, img2, img3;
    public static int y_dinosaur = 150;
    public static boolean jumpstate = true;  // 起跳状态
    int timer = 25000;
    int jumpvalue;
    private final int jump_hight = 30;
    private final int jump_low = 130;


    // 在构造函数中添加
    Dinosaur(){
        try {
            img1 = ImageIO.read(new File("./image/恐龙1.png"));  //文件对引用
            img2 = ImageIO.read(new File("./image/恐龙2.png"));
            img3 = ImageIO.read(new File("./image/恐龙3.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // 改成一个随机图片的显示
    void step(){
        int temp = timer/250 % 3; //
        switch(temp){
            case 1:
                image_show = img1;
                break;
            case 2:
                image_show = img2;
                break;
            case 3:
                image_show = img3;
                break;
        }
        timer = timer + 35;  // 图片切换 不能是三的倍数
        if(timer > 10000)
            timer = 2500;
    }


    public void jump(){    // 小恐龙的跳跃
        if(jumpstate){
            y_dinosaur = jump_hight;  // 跳跃的话变成30
            jumpstate = false;
        }else{
            y_dinosaur = jump_low;
        }
    }

    public void move(){
        // 恐龙慢慢的上去 然后慢慢的下来  在30-130之间横跳
        // 起跳的最大高度 30 落地的最低坐标130
        if(jumpstate){
            if(y_dinosaur >= jump_low)
                jumpvalue = -4;  // 上移消失为止
            if(y_dinosaur <= jump_hight)
                jumpvalue = 4;   // 上下限之间的反复横跳
            y_dinosaur += jumpvalue;
            if(y_dinosaur >= jump_low)
            {
                jumpvalue = 0;
                jumpstate = !jumpstate;  // 调节时间
            }

        }

    }

    public static void main(String args[]){
        new Dinosaur();
    }

}
