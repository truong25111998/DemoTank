package ThridGraphics;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUI extends JFrame{
    private MyPanel p1 = new MyPanel();
    public GUI()
    {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(null);
        
        this.add(p1);
    }
    
}
