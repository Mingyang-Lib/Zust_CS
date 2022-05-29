package model;

import java.awt.*;
import java.util.ArrayList;

public class Bullet extends GameObject{

    public int Bullet_width = Constant.BULLET_Width;
    public int Bullet_height = Constant.WIN_HEIGHT;
    public int Bullet_speed = Constant.BulletNorSpeed;
    Direction direction; // 方向和坦克方向一致
    public GamePanel gamePanel;

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
        // 碰撞检测功能
//        this.hitgrass();
    }

    // 子弹消失
    public void hitbot(){
        ArrayList<Enemy> bots = this.gamePanel.botlist;  // problem
        for(Enemy bot: bots){
            if(this.getRec().intersects(bot.getRec()))
            {
                this.gamePanel.bulletList.remove(bot);
                this.gamePanel.removelist.add(this);
                break; // 终止循环
            }
        }
    }

    public void hitgrass(){
        ArrayList<Wall> walls = this.gamePanel.grasslist;
        for(Wall wall: walls){
            // 与周围每一个墙进行碰撞检测
            if(this.getRec().intersects(wall.getRec())){
                this.gamePanel.grasslist.remove(wall);
                this.gamePanel.bulletList.add(this);
                break;
            }
        }
    }

    // 子弹出边界后消失
    public void moveToBorder(){
        if(x < 0 || x + Bullet_width > this.gamePanel.getWidth()){
            this.gamePanel.removelist.add(this);  // 表示出界 则删除子弹
        }
        if(y < 0 || y + Bullet_height > this.gamePanel.getHeight())
        {
            this.gamePanel.removelist.add(this);
        }
    }


    @Override
    public void paintSelf(Graphics g) {
        // 画出子弹
        g.drawImage(img, x, y, null);
        this.go();  // go方法调用
//        this.hitbot();  // 子弹碰撞消失
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x, y, Bullet_width, Bullet_height);
    }


}
