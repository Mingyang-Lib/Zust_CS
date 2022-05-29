package Start_JFrame_unFinish;

import model.Constant;
import model.GamePanel;
import view.Welcome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameFrame extends JFrame{
    private JPanel panel;
    private int curLevel;  // 现在坦克大战的界面等级

    // 通过键盘输入实现游戏模式之间的切换
    // 游戏未开始-state 0 实现单人模式 - 1，双人模式 - 2
    int key_tmp = 1;
    int state = 0;

    public GameFrame(){
        setTitle("坦克大战小恐龙-designed by WuMingyang-计科203");
        this.setSize(Constant.WIN_WIDTH, Constant.WIN_HEIGHT);
        this.setLayout(null);
        this.setLocationRelativeTo(null);  // 使屏幕居中
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        curLevel = 1;  // 当前的等级
        setResizable(false);  //setResizable值为true时，表示生成的窗体可以自由改变大小  fasle-用户不能调整窗口大小
    }

    public void welcome(){
        String bg = "image/background/BeginBackground.jpeg";
        JPanel wel = new Welcome(bg);
        this.addKeyListener(new GameFrame.KeyMonitor());  //添加键盘监视器

        // 按钮控制游戏模式
        JButton beginGame = new JButton("开始游戏");        // Java 按钮简洁风设计
        beginGame.setBounds(100, 450, 150, 40);
        beginGame.setContentAreaFilled(false);
        beginGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                playGame();  // 监听-切换页面
                GamePanel gp = new GamePanel();
                gp.lunch();
                // 窗体之间的跳转
            }
        });
        wel.add(beginGame);  // 面板中添加开始游戏的按钮

        JButton doubleGame = new JButton("游戏简介");
        doubleGame.setBounds(100,500, 150, 40);
        doubleGame.setContentAreaFilled(false);
        doubleGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // 双人游戏的页面
                doubleGame();
            }
        });
        wel.add(doubleGame);
        if(state == 1 || state == 2){ // 选择相应的模式
            if(state == 1){
                beginGame.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        playGame();  // 监听-切换页面
                    }
                });
            }
            if(state == 2){
                doubleGame.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        doubleGame();
                    }
                });
            }
        }

        this.setPanel(wel);
    }

    public void playGame(){
        this.setPanel(new OnePanel(this));
        this.getContentPane().requestFocus();
    }

    public void doubleGame(){
        this.setPanel(new DoublePanel(this, this.curLevel));
        this.getContentPane().requestFocus();
    }

    public void gameOver(){
        String bg = "image/background/gameover.jpg";
        JPanel over = new Welcome(bg);  // 创建一个新的结束页面
        // 重新开始游戏
        // 结束游戏按钮
        this.setPanel(over);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) { // 建立一个新的面板
        this.panel = panel;
        panel.setLayout(null);
        this.setContentPane(panel);
        this.setVisible(true);  // 显示
    }

    // 键盘监视器  -- 出问题  // 双缓冲技术
    class KeyMonitor extends KeyAdapter{
        // 按下键盘
        @Override
        public void keyPressed(KeyEvent e){
            // 返回键值
            int key = e.getKeyCode();
            System.out.println(e.getKeyCode());
            switch (key){
                case KeyEvent.VK_1:
                    key_tmp = 1;
                    break;
                case KeyEvent.VK_2:
                    key_tmp = 2;
                    break;
                case KeyEvent.VK_ENTER:
                    state = key_tmp;
                    break;
            }
        }
    }

    /**
     * get and set
     * @return 成员
     */
    public int getCurLevel(){
        return curLevel;
    }

    public void setCurLevel(int curlevel){
        this.curLevel = curlevel;
    }


    public static void main(String[] args){
        GameFrame win= new GameFrame();
        win.welcome();
    }
}

