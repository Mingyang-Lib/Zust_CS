package model;

        import java.awt.*;
        import java.awt.event.KeyEvent;

public class PlayerTank_two extends Tank {
    public PlayerTank_two (GamePanel gamePanel, String img, int x, int y,
                       String upImg, String downImg, String leftImg, String rightImg){
        super(gamePanel, img, x, y, upImg, downImg, leftImg, rightImg);  // 继承父类
    }

    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        System.out.println(key);
        switch(key){
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_SHIFT:  // shift 射击
                attack();  // 射击方法
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }
    }

    public void move(){
        if(left){
            leftward_player2();
        }else if(right){
            rightward_player2();
        }else if(up){
            upward_player2();
        }else if(down){
            downward_player2();
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
        move();

    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}
