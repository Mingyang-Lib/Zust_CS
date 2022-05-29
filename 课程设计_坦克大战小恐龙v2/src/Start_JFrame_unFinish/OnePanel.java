package Start_JFrame_unFinish;

import model.Constant;

import javax.swing.*;
import java.awt.*;

// 游戏页面
public class OnePanel extends JPanel {
    private GameFrame gameFrame;
    private int curLevel;
    private int score;

    public OnePanel(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        this.setSize(Constant.WIN_WIDTH + 200, Constant.WIN_HEIGHT); // 大小

    }

    public void paint(Graphics g){
        g.setColor(Color.gray);

    }


    public static void main(String args[]){

    }

}
