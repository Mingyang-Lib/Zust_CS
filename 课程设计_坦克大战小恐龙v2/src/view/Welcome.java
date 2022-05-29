package view;

import model.Constant;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

public class Welcome extends JPanel{
    private  String bg;
    private BufferedImage image;

    public Welcome(String bg_path) {
        this.bg = bg_path;
        this.setLayout(null);
        //未设置Layout时，java默认为flowLayout布局的，设置为null即为清空布局管理器，之后添加组件，
        // 常常是设置组件左上角坐标相对于容器左上角（0，0）的x,y值来确定组件的位置，即使更改容器大小也不会改变位置。
    }

    // 成员访问模式 public private protected
    // protected 不能被该类的对象访问
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        try{
            image = ImageIO.read(new File(bg));
        }catch (IOException e){
            e.printStackTrace();
        }
        // Toolkit.getDefaultToolkit().getImage(bg)
        g.drawImage(image,0, 0, Constant.WIN_WIDTH+200, Constant.WIN_HEIGHT, this);
    }
}
