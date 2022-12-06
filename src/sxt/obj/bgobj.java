package sxt.obj;

import java.awt.*;

public class bgobj extends obj{
    public bgobj() {
        super();
    }

    public bgobj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y +=speed;
        if(y>=0){
            y = -200;
        }
    }
}
