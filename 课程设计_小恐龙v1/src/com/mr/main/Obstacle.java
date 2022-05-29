package com.mr.main;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Obstacle {
    public Image img, cacti, stone;
    public int obstacle_cacti_y = 140, obstacle_stone_y = 175;
    public int obstacle_y = 0;  // 显示的高度
    public int obstacle_x = 800;
    int timer = 0; // 计数器
    int speed = BackgroundImage.speed;  // 静态类

    Obstacle(){
        try{
            cacti = ImageIO.read(new File("./image/仙人掌.png"));
            stone = ImageIO.read(new File("./image/石头.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        Random r = new Random(); // 创建随机数
        if(r.nextInt(2) == 1){
            // 产生两个整数
            img = stone;
        }else{
            img = cacti;
        }
    }

    Image img_display(){  // 延时程序
        Random r = new Random(); // 创建随机数
        if(timer++> 100){
            if(r.nextInt(2) == 1){// 产生两个整数
                img = stone;
                System.out.println("image = stone");
            }else{
                img = cacti;
                System.out.println("image = cacti");
            }
            timer = 0;
        }
        return img;
    }

    void move(){
        obstacle_x -= speed;
        if(obstacle_x < 0)
            obstacle_x = 800;
        if(img == stone)
            obstacle_y = obstacle_stone_y; // 判断y
        else
            obstacle_y = obstacle_cacti_y;
    }

}
