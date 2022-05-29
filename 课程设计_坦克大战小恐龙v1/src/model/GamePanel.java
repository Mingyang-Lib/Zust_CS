package model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JFrame{
    private int width = Constant.WIN_WIDTH;
    private int height = Constant.WIN_HEIGHT;
    private int start_tank_y = 90;
    private int state_tmp = 0;
    private int state = 0;
    private int cnt = 0;  // 重绘此处
    private int enemy_cnt =0;
    public Image background_img;
    public Direction direction;// 方向
    private Image select = Toolkit.getDefaultToolkit().getImage(Constant.dinosaur_Img);
    private Image offScreemImage = null;

    public String[] playerimg = new String[]{Constant.Player_Img_upImg, Constant.Player_Img_downImg,
            Constant.Player_Img_leftImg, Constant.Player_Img_rightImg};  // Tank类的四张图片
    public String[] enemy_tank_img = new String[]{
            Constant.EnemyTank_IMG_UP, Constant.EnemyTank_IMG_DOWN, Constant.EnemyTank_IMG_LEFT, Constant.EnemyTank_IMG_RIGHT
    };
    public String[] dinosaur = new String[]{
            Constant.dinosaur_Img, Constant.dinosaur_Img, Constant.dinosaur_Img_left, Constant.dinosaur_Img_right
    };

    // 绘制子弹  --> 发射很多子弹  --> 新学到的
    ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    // 批量创建恐龙
    ArrayList<Bot> botlist = new ArrayList<Bot>();
    // Player one
    PlayerTank playerTank = new PlayerTank(this, playerimg[0], 100, 700, playerimg[0],
            playerimg[1], playerimg[2], playerimg[3]);
    // 删除子弹和恐龙
    ArrayList<Bullet> removelist = new ArrayList<Bullet>();

    //Enemy  tank
//    Bot bot = new Bot(this, enemy_tank_img[1], 100,200, enemy_tank_img[0], enemy_tank_img[1],
//            enemy_tank_img[2], enemy_tank_img[3]);
    // Enemy dinosaur
    Bot bot = new Bot(this, dinosaur[0], 200, 100, dinosaur[0], dinosaur[1], dinosaur[2], dinosaur[3]);


    public void lunch(){
        setTitle("java-课程设计-");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        setVisible(true);
        this.addKeyListener(new GamePanel.KeyMonitor());

        while(true){
            // 批量添加
            if(cnt % 100 == 1 && enemy_cnt <= 4){  // 每重绘100次添加一次敌方坦克
                // 未知随机生成
                Random random = new Random();
                int xnum = random.nextInt(800);
                int ynum = random.nextInt(400);
                // 横坐标
                botlist.add(new Bot(this, Constant.dinosaur_Img, xnum, ynum, Constant.dinosaur_Img,
                        Constant.dinosaur_Img,Constant.dinosaur_Img,Constant.dinosaur_Img));
                enemy_cnt++;
            }
            repaint();
            try{
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g){
        if(offScreemImage == null){
            offScreemImage = this.createImage(width, height);
        }

        Graphics gImage = offScreemImage.getGraphics();  // 该图片的画笔

        gImage.setColor(Color.gray);
        try {
            background_img = ImageIO.read(new File(Constant.background_map));
        } catch (IOException e) {
            e.printStackTrace();
        }
        gImage.drawImage(background_img, 0, 0, this);
        gImage.setColor(Color.GREEN);
        gImage.setFont(new Font("仿宋", Font.BOLD,50));
        if(state == 0){
            gImage.drawString("选择游戏" , 400, 100);
            gImage.drawString("单人游戏" , 400, 170);
            gImage.drawString("双人游戏" , 400, 240);
            gImage.drawString("请按1或2 及Enter 选择游戏模式", 100, 350);
            gImage.drawImage(select, 300, start_tank_y, null);            // 绘制指针
        }else if(state == 1 || state == 2){
            gImage.drawString("游戏开始" , 400, 100);
            if(state == 1){
                gImage.drawString("单人游戏" , 400, 170);
            }else{
                gImage.drawString("双人游戏" , 400, 170);
            }
            // 绘制 playerone
             playerTank.paintSelf(gImage);
            // 循环子弹列表 --> new
            for(Bullet bullet: bulletList){
                bullet.paintSelf(gImage); // 画列表中的每个元素  在玩家列表中添加空格键盘事件 调用这个东西
            }
            bulletList.removeAll(removelist); // 删除remove中的元素 子弹先放removelist中
            // 绘制敌方
            for(Bot bot:botlist){
                bot.paintSelf(gImage);
            }
//            bot.paintSelf(gImage);
//            dinosaur.paintSelf(gImage);
             cnt++;
        }
        // 将缓存区的图片存储
        g.drawImage(offScreemImage, 0, 0,null);
    }

    public static void main(String args[]){
        GamePanel gp = new GamePanel();
        gp.lunch();
    }


    // 键盘监视
    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_1:
                    state_tmp = 1;
                    start_tank_y = 90;
                    break;
                case KeyEvent.VK_2:
                    state_tmp = 2;
                    start_tank_y = 155;
                    break;
                case KeyEvent.VK_ENTER:
                    state = state_tmp;
                    break;
                default:
                    playerTank.keyPressed(e);
            }
        }
        // 键盘松开的方法
        @Override
        public void keyReleased(KeyEvent e){
            playerTank.keyReleased(e);
        }

    }
}



/*
 * 模式选择
 * 射击功能
 * 线程实现冷却
 * 批量添加 + 小恐龙随机生成
 * 随机方向 随机移动
 * 代码规范
 * */

