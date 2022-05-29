package Start_JFrame_unFinish;

import model.Constant;
import model.GameFrame;

import javax.swing.*;
import java.awt.*;

// 游戏页面
public class DoublePanel extends JPanel {
    private GameFrame gameFrame;
    private int curLevel;
    private int score;

    public DoublePanel(GameFrame gameFrame, int level){
        this.gameFrame = gameFrame;
        this.setSize(Constant.WIN_WIDTH + 200, Constant.WIN_HEIGHT); // 大小
        curLevel = level;  // 当前等级
    }

    public void paint(Graphics g){
        g.setColor(Color.gray);

    }


    public static void main(String args[]){

    }

}
