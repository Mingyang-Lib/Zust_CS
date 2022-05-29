package model;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class Tank extends GameObject{
    public int width = Constant.TankWidth;
    public int height = Constant.TankWidth;
    public int speed = Constant.TANK_SPEED;
    public Direction direction = Direction.UP;
    private String upImg, downImg, leftImg, rightImg;
    public String[] playerimg = new String[]{Constant.Player_Img_upImg, Constant.Player_Img_downImg,
            Constant.Player_Img_leftImg, Constant.Player_Img_rightImg};  // Tank类的四张图片
    public String[] dinosaur = new String[]{
            Constant.dinosaur_Img, Constant.dinosaur_Img, Constant.dinosaur_Img_left, Constant.dinosaur_Img_right
    };
    public String[] playerimg_two = new String[]{Constant.Player2_Img_upImg, Constant.Player2_Img_downImg,
            Constant.Player2_Img_leftImg, Constant.Player2_Img_rightImg};  // Tank类的四张图片
    public boolean left = false, right = false, up = false, down = false;

    private boolean attackCoolDown = true;    // 冷却状态
    private int attackCoolDownTime = 500;  // 0.5 ms的冷却时间

    public Tank(GamePanel gamePanel, String img, int x, int y,
                String upImg, String downImg, String leftImg, String rightImg){
        super(gamePanel, img, x, y);  // 继承父类
        this.upImg = upImg;
        this.downImg = downImg;
        this.rightImg = rightImg;
        this.leftImg = leftImg;
    }

    // 移动 player
    public void upward(){
        if(!moveToBorder(x, y-height)){  // 判断是否出界
            y-= speed;
        }
        setImg(playerimg[0]);
        direction = Direction.UP;
    }

    public void downward(){
        if(!moveToBorder(x, y+height)){
            y += speed;
        }
        setImg(playerimg[1]);
        direction = Direction.DOWN;
    }

    public void leftward(){
        if(!moveToBorder(x-speed, y)){
            x -= speed;
        }
        setImg(playerimg[2]);
        direction = Direction.LEFT;
    }

    public void rightward(){
        if(!moveToBorder(x+speed, y)){
            x += speed;
        }
        setImg(playerimg[3]);
        direction = Direction.RIGHT;
    }

    // 移动enemy
    public void upward_enemy(){
        if(!moveToBorder(x, y-height)){  // 判断是否出界
            y-= speed;
        }
        setImg(dinosaur[0]);
        direction = Direction.UP;
    }

    public void downward_enemy(){
        if(!moveToBorder(x, y+height)){
            y += speed;
        }
        setImg(dinosaur[1]);
        direction = Direction.DOWN;
    }

    public void leftward_enemy(){
        if(!moveToBorder(x-speed, y)){
            x -= speed;
        }
        setImg(dinosaur[2]);
        direction = Direction.LEFT;
    }

    public void rightward_enemy(){
        if(!moveToBorder(x+speed, y)){
            x += speed;
        }
        setImg(dinosaur[3]);
        direction = Direction.RIGHT;
    }

    // player 2
    public void upward_player2(){
        if(!moveToBorder(x, y-height)){  // 判断是否出界
            y-= speed;
        }
        setImg(playerimg_two[0]);
        direction = Direction.UP;
    }

    public void downward_player2(){
        if(!moveToBorder(x, y+height)){
            y += speed;
        }
        setImg(playerimg_two[1]);
        direction = Direction.DOWN;
    }

    public void leftward_player2(){
        if(!moveToBorder(x-speed, y)){
            x -= speed;
        }
        setImg(playerimg_two[2]);
        direction = Direction.LEFT;
    }

    public void rightward_player2(){
        if(!moveToBorder(x+speed, y)){
            x += speed;
        }
        setImg(playerimg_two[3]);
        direction = Direction.RIGHT;
    }


    public void setImg(String img){
        this.img = Toolkit.getDefaultToolkit().getImage(img);
    }

    public abstract Rectangle getRec();

    // 射击时间的固定性  子弹发射 线程
    class AttackCD extends Thread{
        public void run(){
            attackCoolDown = false; // 攻击功能设计冷却时间
            try{
                Thread.sleep(attackCoolDownTime);  // 线程休眠1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            // 停止1ms
            attackCoolDown = true;            // 解除冷却状态
            // 终止线程
            this.stop();
        }
    }

    // 初始化子弹
    public void attack(){
        if(attackCoolDown){
            Point p = this.getHeadPoint();
            Bullet bullet = new Bullet(gamePanel, Constant.Bullet_Img, p.x, p.y, direction);  // 子弹
            this.gamePanel.bulletList.add(bullet);  // 初始化的新子弹 添加到列表中
            new AttackCD().start();  // 启动线程
        }
    }

    // 获取t图像的 头部的坐标，为了发射子弹
    public Point getHeadPoint(){
        switch (direction){
            case UP:
                return new Point(x+width/4 +5, y-height/2);
            case DOWN:
                return new Point(x + width/2 -10, y + height/2 + 20);
            case LEFT:
                return new Point(x - 10, y + height/2 - 10);
            case RIGHT:
                return new Point(x+width, y + height/2 -15);
            default:
                return null;
        }
    }

    public boolean moveToBorder(int x, int y){  // 判断坦克是否出界
        if(x < 0){
            return true;
        }else if(x + width > this.gamePanel.getWidth()){
            return true;
        }else if(y<0){
            return true;
        }else if(y+height > this.gamePanel.getHeight()){
            return true;
        }

        return false;
    }

    public abstract void keyPressed(KeyEvent e);

    @Override
    public abstract void paintSelf(Graphics g);

}
