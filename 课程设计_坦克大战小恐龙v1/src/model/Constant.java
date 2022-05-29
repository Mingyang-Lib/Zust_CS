package model;

public class Constant {
    public final static int WIN_WIDTH = 1000;
    public final static int WIN_HEIGHT = 800;
    public final static int TankWidth = 60;
    public final static int dinosaurWidth = 100;

    // 生命值
    public final static int MAX_HP = 100;

    // Bullet类型
    public final static int BULLET_NOR = 1;   // 普通导弹
    public final static int BulletNorSpeed = 10;  // 普通子弹的速度
    public final static int NOR_DAMAGE = 20;  // 伤害大小
    public final static int BULLET_Width = 20;

    // 路径
    public final static String Player_Img_upImg = "image/tank/MyTank_up.png";
    public final static String Player_Img_leftImg = "image/tank/MyTank_left.png";
    public final static String Player_Img_rightImg = "image/tank/MyTank_right.png";
    public final static String Player_Img_downImg = "image/tank/MyTank_down.png";
    public final static String EnemyTank_IMG_UP = "image/tank/EnemyTank_up.png";
    public final static String EnemyTank_IMG_DOWN = "image/tank/EnemyTank_down.png";
    public final static String EnemyTank_IMG_RIGHT = "image/tank/EnemyTank_right.png";
    public final static String EnemyTank_IMG_LEFT = "image/tank/EnemyTank_left.png";
    public final static String Tank_Explosion = "image/explosion/tank_explosion";
    public final static String Bullet_Explosion = "image/explosion/bullet_explosion";

    public final static String dinosaur_Img = "image/tank/dinosaur.png";
    public final static String dinosaur_Img_left = "image/tank/dinosaur.png";
    public final static String dinosaur_Img_right = "image/tank/dinosaur-1.png";

    public final static String Bullet_Img = "image/bullet/Bullet.png";
    public final static String Bullet_Img_Nor = "image/bullet/fire.png";
    public final static String background_map = "image/map/gamemap.png";

    // 速度
    public final static int TANK_SPEED = 6;
}
