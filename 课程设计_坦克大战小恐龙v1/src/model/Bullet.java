package model;

import java.awt.*;
import java.util.ArrayList;

public class Bullet extends GameObject{

    private int Bullet_width = Constant.BULLET_Width;
    private int Bullet_height = Constant.WIN_HEIGHT;
    private int Bullet_speed = Constant.BulletNorSpeed;
    Direction direction; // 方向和坦克方向一致
    private GamePanel gamePanel;

    public Bullet(GamePanel gamePanel, String img, int x, int y, Direction direction){
        super(gamePanel,img, x, y);
        this.direction = direction;
    }

    // 子弹的移动
    public void upward(){
        y -= Bullet_speed;
    }
    public void downward(){
        y += Bullet_speed;
    }
    public void leftward(){
        x -= Bullet_speed;
    }
    public void rightward(){
        x += Bullet_speed;
    }

    public void go(){
        switch(direction){
            case UP:
                upward();
                break;
            case DOWN:
                downward();
                break;
            case LEFT:
                leftward();
                break;
            case RIGHT:
                rightward();
                break;
        }
    }

    public void hitbot(){
        ArrayList<Bot> bots = this.gamePanel.botlist;
        for(Bot bot:bots){
            if(this.gerRec().intersects(bot.gerRec())){
                this.gamePanel.bulletList.remove(bot);
                this.gamePanel.removelist.add(this);
                break; // 终止循环
            }

        }
    }
    @Override
    public void paintSelf(Graphics g) {
        // 画出子弹
        g.drawImage(img, x, y, null);
        this.go();  // go方法调用
//        this.hitbot();
    }

    @Override
    public Rectangle gerRec() {
        return new Rectangle(x, y, Bullet_width, Bullet_height);
    }


}
