package sxt.obj;

import sxt.GameWIN;
import sxt.utils.picture.picture;
import java.awt.*;

public class bulltle2obj extends obj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public bulltle2obj() {
        super();
    }

    public bulltle2obj(Image img, int x, int y, int width, int height, double speed, GameWIN frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        //碰撞检测
        if(this.getRec().intersects(this.frame.planeobj.getRec())){
            GameWIN.state =3;
        }
        if(y>600){
            this.x = -300;
            this.y =  300;
            picture.removejList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
