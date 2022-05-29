package model;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Bot extends Tank{
    int moveTime = 0;
    private Direction dir;
    private int width = Constant.dinosaurWidth;


    public Bot(GamePanel gamePanel, String img, int x, int y,
                       String upImg, String downImg, String leftImg, String rightImg){
        super(gamePanel, img, x, y, upImg, downImg, leftImg, rightImg);  // 继承父类
    }

    public Direction getRandomDirection(){  // 根据随机数的数值 返回相应的方向
        Random random = new Random();
        int rnum = random.nextInt(4);
        switch(rnum){
            case 0:
                return Direction.UP;
            case 1:
                return Direction.DOWN;
            case 2:
                return Direction.LEFT;
            case 3:
                return Direction.RIGHT;
            default:
                return null;
        }
    }


    public void go(){
        if(moveTime >=20){
            dir = getRandomDirection(); // 生成随机的方向
            moveTime = 0;
        }else{
            moveTime ++;
        }
        switch (dir){
            case UP:
                upward_enemy();
                break;
            case DOWN:
                downward_enemy();
                break;
            case LEFT:
                leftward_enemy();
                break;
            case RIGHT:
                rightward_enemy();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
        this.go();
    }

    @Override
    public Rectangle gerRec() {  // 碰撞检测  判断矩形是否相交
        return new Rectangle(x, y, width, width);
    }
}
