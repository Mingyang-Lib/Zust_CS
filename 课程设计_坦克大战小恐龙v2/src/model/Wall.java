package model;

import java.awt.*;

public class Wall extends GameObject{
    public Wall(GamePanel gamePanel, String img, int x, int y){
        super(gamePanel, img, x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, gamePanel);
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y, Constant.grassWidth, Constant.grassWidth);
    }
}
