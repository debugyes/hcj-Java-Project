package sxt.obj;

import sxt.GameWIN;
import sxt.utils.picture.picture;
import java.awt.*;

public class bulltleobj extends obj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public bulltleobj() {
        super();
    }

    public bulltleobj(Image img, int x, int y, int width, int height, double speed, GameWIN frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y -=speed;
        if(y<0){
            this.x = -100;
            this.y = 100;
            picture.removejList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
