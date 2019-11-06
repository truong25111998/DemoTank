package ThridGraphics;

import javax.swing.Timer;

public class Bullet extends Object2d
{
    public void move() 
    {
        switch(ori)
        {
            case LEFT:
                x -= 3;               
                break;
            case RIGHT:
                x += 3;
                break;
            case UP:
                y -= 3;
                break;
            case DOWN:
                y += 3;
                break;
        }
    }
    public void delete()
    {          
        
    }

    public void startTimer() 
    {  
    Timer t = new Timer(10, null);
    if (t.isRunning()) {
        return;
    }
    t.start();
}
    
}
