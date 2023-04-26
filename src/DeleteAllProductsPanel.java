import javax.swing.*;
import java.awt.*;

public class DeleteAllProductsPanel extends JPanel {

    DeleteAllProductsPanel(JFrame myFrame){

        setBackground(new Color(233, 243, 245));
        setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);

        JLabel label = new JLabel();
        label.setText("Usunięto wszystkie produkty z listy zakupów");
        label.setBounds((MainFrame.WIDTH-600)/2,300,600,100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(getFont().deriveFont(25f));

        add(label);
        add(new ReturnButton("Cofnij",10,10,70,30,"deleteAllProductsPanel",myFrame));

        for(Category category : Main.shoppingList.values()){
            category.getProducts().clear();
        }
    }
}
