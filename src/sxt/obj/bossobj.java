package sxt.obj;

import sxt.GameWIN;
import sxt.utils.picture.picture;
import java.awt.*;

public class bossobj extends obj{
    //定义生命值
    int life = 10;
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public bossobj() {
        super();
    }

    public bossobj(Image img, int x, int y, int width, int height, double speed, GameWIN frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) { //bossmyself
        super.paintSelf(gImage);
        if(x>450||x<-50) {
            speed= -speed;
        }
        x += speed;
        //子弹碰撞代码
        for(bulltleobj bulltleobj :picture.bulltlelist ){
            if(this.getRec().intersects(bulltleobj.getRec())){
                bulltleobj.setX(-100);
                bulltleobj.setY(100);
                picture.removejList.add(bulltleobj);
                life--;
            }
            if(life<0){
                GameWIN.state = 4;

            }
        }
        //血条框
        gImage.setColor(Color.white);
        gImage.fillRect(20,40,100,10);
gImage.setColor(Color.red);
gImage.fillRect(20,40,life*100/10,10);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
