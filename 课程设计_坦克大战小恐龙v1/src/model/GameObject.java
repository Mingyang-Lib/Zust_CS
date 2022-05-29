package model;

import java.awt.*;

public abstract class GameObject {
    public Image img;
    public int x;
    public int y;
    public GamePanel gamePanel;  // 游戏界面

    // 游戏元素都需要的方法
    public GameObject(GamePanel gamePanel, String img, int x, int y){
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.x = x;
        this.y = y;
        this.gamePanel = gamePanel;
    }

    public abstract void paintSelf(Graphics g);  // 绘制方法，参数是一个画布

    public abstract Rectangle gerRec();      // 返回自身矩形的方法  判断tank之间是否发生碰撞

}
