package ThridGraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener
{
    private Tank tank;
    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;
    private boolean isSpace;
    
    public MyPanel()
    {
        setSize(800,600);
        setBackground(Color.black);  
        tank = new Tank();
        tank.setY(200);
        tank.setX(200);
        tank.setC(Color.red);
        tank.setSize(100);
        tank.setOri(Orientation.DOWN);
        
        requestFocus();
        setFocusable(true);       
        addKeyListener(this);
        initThread();
    }
        @Override
    protected void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D)g;
       //khu rang cua
       //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
       //ve anh
       //chuyen duong dan anh thanh image
       Image img = new ImageIcon(getClass().getResource("/img.png")).getImage();
       g2d.drawImage(img, 0, 0, 800, 600, null);
       
//       g2d.setColor(Color.red);
//       g2d.fillRect(100, 150, 150, 150);
//       g2d.fillRect(150, 100, 50, 50);
//       g2d.fillOval(600, 150, 100, 100);
//       g2d.setColor(Color.BLUE);
//       Font f = new Font("Tahoma", 40, 40);
//       g2d.setFont(f);
//       g2d.drawString("hello java", 0, 400);
       
       tank.draw(g2d);
       
    }
    @Override
    public void keyTyped(KeyEvent e) 
    {
        
    }
    
            @Override
            public void keyPressed(KeyEvent e)
                {
                    switch(e.getKeyCode())
                    {
                        case KeyEvent.VK_LEFT:
                            //xoay huong cua dau xe tang
                            tank.setOri(Orientation.LEFT);
                            //di chuyen
                            isLeft = true;                            
                            break;
                        case KeyEvent.VK_RIGHT:
                            tank.setOri(Orientation.RIGHT);
                            isRight = true;                          
                            break;
                        case KeyEvent.VK_UP:
                            tank.setOri(Orientation.UP);
                            isUp = true;
                            break;
                        case KeyEvent.VK_DOWN:
                            tank.setOri(Orientation.DOWN);
                            isDown = true;
                            break;
                        case KeyEvent.VK_SPACE:
                            isSpace = true;
                            break;
                    }
                }
            @Override
            public void keyReleased(KeyEvent e)
            {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_LEFT:
                        isLeft = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        isRight = false;
                        break;
                    case KeyEvent.VK_UP:
                        isUp = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        isDown = false;
                        break;
                    case KeyEvent.VK_SPACE:
                        isSpace = false;
                        break;
                }                  
            }

            private void initThread()
                {
                    Runnable run = new Runnable()    
                {
                    @Override
                    public void run()
                    {
                        while(true)
                        {
                            if(isLeft) 
                            {
                                tank.setX(tank.getX() - 1 );
                            }
                            if(isRight)
                            {
                                tank.setX(tank.getX() + 1);
                            }
                            if(isUp)
                            {
                                tank.setY(tank.getY()- 1);
                            }
                            if(isDown)
                            {
                                tank.setY(tank.getY() + 1);
                            }
                            if(isSpace)
                            {
                               tank.fireBulet();
                       
                            }
                        tank.moveAllBulet();
                        repaint();
                        
                        try
                            {
                                Thread.sleep(20);
                            } 
                        catch (InterruptedException ex) 
                            {
                                ex.addSuppressed(ex);
                            }
                        }
                    }
                };
                    Thread th = new Thread(run);
                    th.start();
                }
            
}
