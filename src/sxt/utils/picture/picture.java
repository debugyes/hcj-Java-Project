package sxt.utils.picture;
import java.util.ArrayList;
import sxt.GameWIN;
import sxt.obj.bulltleobj;
import sxt.obj.obj;
import sxt.obj.enemyobj;
import sxt.obj.bulltle2obj;

import java.awt.*;
import java.util.*;
import java.util.List;

public class picture {
    public static Image bglmg = Toolkit.getDefaultToolkit().getImage("images/bg.jpg");
    public static Image bossImg = Toolkit.getDefaultToolkit().getImage("images/boss.png");
    public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("images/explode/bomb.e6.gif");
    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("images/plane.png");
    public static Image bulltleImg = Toolkit.getDefaultToolkit().getImage("images/bulletGreen.png");
    public static Image enemyImg = Toolkit.getDefaultToolkit().getImage("images/enemy.png");
    public static Image bulltle2Img = Toolkit.getDefaultToolkit().getImage("images/bulletYellow.png");
    //物体合计
   public static List<obj> objList = new ArrayList<>();

    //子弹连续发射
  public static List<bulltleobj>bulltlelist = new ArrayList<>();
  //敌机
  public static  List<enemyobj>enemyobjList = new ArrayList<>();
   //删除敌机
    public static List<obj> removejList = new ArrayList<>();
    //boss子弹
    public static  List<bulltle2obj>bulltle2objList = new ArrayList<>();
    public static void  drawWord(Graphics glmage,String str,Color color,int size,int x,int y){
        glmage.setColor(color);
        glmage.setFont(new Font("仿宋",Font.BOLD,size));
        glmage.drawString(str,x,y);

    }
}


