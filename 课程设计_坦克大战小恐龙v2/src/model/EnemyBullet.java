package model;

import java.awt.*;
import java.util.ArrayList;

public class EnemyBullet extends Bullet{

    public EnemyBullet(GamePanel gamePanel, String img, int x, int y, Direction direction) {
        super(gamePanel, img, x, y, direction);
    }

    // 子弹消失
    public void hitplayer(){
        ArrayList<Tank> players = this.gamePanel.playerlist;
        for(Tank player: players){
            if(this.getRec().intersects(player.getRec())){
                this.gamePanel.playerlist.remove(player);
                this.gamePanel.removelist.add(this);
                break; // 终止循环
            }
        }
    }

    public void paintSelf(Graphics g) {
        // 画出子弹
        g.drawImage(img, x, y, null);
        this.go();  // go方法调用
//        this.hitplayer();
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, Bullet_width, Bullet_height);
    }
}
