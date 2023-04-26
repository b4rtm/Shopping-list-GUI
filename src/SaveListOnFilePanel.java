import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveListOnFilePanel  extends JPanel{

    SaveListOnFilePanel(JFrame myFrame){
        setBackground(new Color(233, 243, 245));
        setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);

        JLabel label = new JLabel();
        label.setText("Zapisano listę zakupów do pliku");
        label.setBounds((MainFrame.WIDTH-600)/2,300,600,100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(getFont().deriveFont(25f));

        add(label);
        add(new ReturnButton("Cofnij",10,10,70,30,"saveListOnFilePanel",myFrame));

        repaint();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("shopping_list.txt"))){
            for(Category cats : Main.shoppingList.values()){
                writer.write(cats.toString());
            }
        }
        catch (IOException e){
            System.out.println("nie udało sie zapisać do pliku");
        }


    }

}
