import javax.swing.*;
import java.awt.*;

public class ReturnButton extends JButton {

    public ReturnButton(String label,int x, int y, int buttonWidth, int buttonHeight,String panel ,JFrame myFrame){
        super(label);


        setBounds(x,y,buttonWidth,buttonHeight);
        setFocusable(false);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createEtchedBorder());
        addActionListener(e -> returnToPreviousPanel(panel,myFrame));
    }


    public void returnToPreviousPanel(String panel, JFrame myFrame){
        myFrame.remove(Main.panels.get(panel));
        myFrame.repaint();

        myFrame.add(Main.panels.get("mainPanel"));
    }

}
