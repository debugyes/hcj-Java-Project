package sxt.obj;

import sxt.GameWIN;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class planeobj extends obj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public planeobj() {
        super();
    }

    public planeobj(Image img, int x, int y, int width, int height, double speed, GameWIN frame) {
        super(img, x, y, width, height, speed, frame);
        //添加鼠标移动参数
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                planeobj.super.x = e.getX() - 11;
                planeobj.super.y = e.getY() - 16;
            }
        });

    }

    @Override
    public void paintSelf(Graphics gImage) {//碰撞boss检测
        super.paintSelf(gImage);
        if(this.frame.bossobj !=null && this.getRec().intersects(this.frame.bossobj.getRec())){
            GameWIN.state=3;

        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}