package sxt.obj;

import sxt.GameWIN;
import sxt.utils.picture.picture;

import java.awt.*;

public class enemyobj extends obj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public enemyobj() {
        super();
    }

    public enemyobj(Image img, int x, int y, int width, int height, double speed, GameWIN frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        //敌我飞机碰撞检测
        if(this.getRec().intersects(this.frame.planeobj.getRec())){
            GameWIN.state = 3;
        }
        if(y>600){
            this.x = -200;
            this.y= 200;
            picture.removejList.add(this);
        }
//敌机消失移动到的距离 我方子弹的距离
        for(bulltleobj bulltleobj: picture.bulltlelist){
            if(this.getRec().intersects(bulltleobj.getRec())){
                bulltleobj.setX(-100);
                bulltleobj.setX(100);
                this.x = -100;
                this.y = 100;
                picture.removejList.add(bulltleobj);
                picture.removejList.add(this);
                GameWIN.score++;
            }
        }

    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
