package ThridGraphics;

import java.awt.Color;
import java.awt.Graphics2D;

public class Object2d 
{
    protected int x, y;
    protected int size;
    protected Color c;
    protected Orientation ori;
    
    public void draw(Graphics2D g2d)
    {
        g2d.setColor(c);
        g2d.fillRect(x, y, size, size);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public Orientation getOri() {
        return ori;
    }

    public void setOri(Orientation ori) {
        this.ori = ori;
    }
    
    
}
