import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    MainFrame(){

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // konczy aplikacje
        setTitle("Lista zakupów");
        setResizable(false);
        setSize(WIDTH,HEIGHT);
        ImageIcon image = new ImageIcon("wóżek.png");
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(233, 243, 245));

    }


}
