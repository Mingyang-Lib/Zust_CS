package model;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerTank extends Tank {
    public PlayerTank (GamePanel gamePanel, String img, int x, int y,
                String upImg, String downImg, String leftImg, String rightImg){
        super(gamePanel, img, x, y, upImg, downImg, leftImg, rightImg);  // 继承父类
    }

    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        System.out.println(key);
        switch(key){
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_SPACE:
                attack();  // 射击方法
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
        }
    }

    public void move(){
        if(left){
            leftward();
        }else if(right){
            rightward();
        }else if(up){
            upward();
        }else if(down){
            downward();
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
        move();

    }

    @Override
    public Rectangle gerRec() {
        return new Rectangle(x, y, width, height);
    }
}
