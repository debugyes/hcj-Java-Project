package sxt;

import sxt.obj.*;
import sxt.utils.picture.picture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameWIN extends JFrame {
   public static int state = 0;
    Image offScreenImage = null;//取消开始游戏的闪烁
    int width=390;
    int height = 390;
    //游戏重绘的次数
    int count = 1;
    //敌机数量
    int enemycount = 0;
    //游戏分数
    public static int score = 0;
    //背景图对象的移动
    bgobj bgobj = new bgobj(picture.bglmg,0,-200,3);
    //飞机
   public planeobj planeobj = new planeobj(picture.planeImg,180,180,20,30,0,this);
   //创建boss
    public  bossobj bossobj = null;

   public void launch(){
        this.setSize(width,height);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("hcj的飞机大战");

        //添加游戏物品
        picture.objList.add(bgobj);
        picture.objList.add(planeobj);

        //鼠标点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==1&&state==0){
                    state = 1;
                    repaint(); //重新调用paint方法
                }
            }
        });
       //键盘点击事件
       this.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
               if(e.getKeyCode() == 32){
                   switch (state){
                       case 1:
                           state=2;
                           break;
                       case 2:
                           state = 1;
                           break;
                       default:
                   }

               }
           }
       });
        while (true){
            if(state==1){
                createObj();
                repaint();
            }

            try{
                Thread.sleep(20);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    //背景图片增加
public void paint(Graphics g){

    if(state == 0) {
        g.drawImage(picture.bglmg,0,0,null);
        g.drawImage(picture.bossImg, 140, 70, null);
        g.drawImage(picture.explodeImg, 140, 70, null);//有问题
        picture.drawWord(g,"点击开始游戏",Color.YELLOW,40,70,200);
    }
    if(state == 1) {
for (int i = 0;i <picture.objList.size();i++){ //子弹判定
    picture.objList.get(i).paintSelf(g);

        }
picture.objList.removeAll(picture.removejList);
    }
    if(state == 3) {//碰撞后的结束状态
        g.drawImage(picture.explodeImg,planeobj.getX() -35,planeobj.getY()-50,null);
        picture.drawWord(g,"GAME OVER",Color.RED,40,100,200);
    }
    if(state == 4) {//通关界面
        g.drawImage(picture.explodeImg,bossobj.getX() +35,planeobj.getY(),null);
        picture.drawWord(g,"游戏通关",Color.RED,40,100,200);
    }
    //积分面板绘制在窗口
    picture.drawWord(g,score +" 分",Color.green,40,30,100);
    g.drawImage(offScreenImage, 0, 0, null);
count++;
    System.out.println(picture.objList.size());
    }


    void createObj() {
        if (count % 15 == 0) {//我方
            picture.bulltlelist.add(new bulltleobj(picture.bulltleImg, planeobj.getX() + 3, planeobj.getY() - 16, 14, 29, 5, this));
            //子弹
            picture.objList.add(picture.bulltlelist.get(picture.bulltlelist.size() - 1));
        }
        if (count % 15 == 0) {//敌方
            picture.enemyobjList.add(new enemyobj(picture.enemyImg,(int)(Math.random()*10)*30,0,49,36,4,this));
            picture.objList.add(picture.enemyobjList.get(picture.enemyobjList.size()- 1));
       enemycount++;
        }
        if (count % 15 == 0&&bossobj !=null) {//地方子弹
            picture.bulltle2objList.add(new bulltle2obj(picture.bulltle2Img,bossobj.getX()+76,bossobj.getY()+85,15,25,5,this));
        picture.objList.add(picture.bulltle2objList.get(picture.bulltle2objList.size() -1));
        }
if(enemycount>1 &&bossobj==null){
    bossobj =  new bossobj(picture.bossImg,100,0,150,100,5,this);
    picture.objList.add(bossobj);
}
    }
    public static void main(String[] args) {
        GameWIN gameWIN = new GameWIN();
        gameWIN.launch();
    }
}
