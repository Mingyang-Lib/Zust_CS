package com.mr.main;

class FreshThread extends Thread{ // 从Thread中派生
    // BackgroundImage.CanvasPanel background;
    CanvasPanel background;  // CanvasPanel 被单独处理为一个类
    Dinosaur dinosaur;
    Obstacle obstacle; // 产生一个对象

    public int INTER = 50;

    FreshThread(CanvasPanel background, Dinosaur dinosaur, Obstacle obstacle){
        this.background = background;   // 可以在类中调用了  不同类之间变量的传递  参数传递之间
        this.dinosaur = dinosaur;
        this.obstacle = obstacle;
    }
    @Override
    public void run(){  // 死循环 改变横坐标  循环显示
        while(true){
            background.repaint();  //调用 repaint 就可以不需要传递参数
            background.roll();
            dinosaur.step();  // step 改变time 不断刷新和改变
            dinosaur.move();  //
            obstacle.move();  // 障碍物移动

            try{
                Thread.sleep(INTER);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

