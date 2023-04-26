import javax.swing.*;
import java.awt.*;

public class ShowAllProductsFromCategoryPanel extends JPanel {

    ShowAllProductsFromCategoryPanel(JFrame myFrame){
        setBackground(new Color(233, 243, 245));
        setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);

        JLabel label = new JLabel();
        label.setText("Wyświetl produkty z danej kategorii");
        label.setBounds((MainFrame.WIDTH-500)/2,5,500,100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(getFont().deriveFont(30f));

        add(label);
        add(new ReturnButton("Cofnij",10,10,70,30,"showAllProductsFromCategoryPanel",myFrame));

        int x=100;
        for(Category category : Main.shoppingList.values()){
            int y=200;
            CategoryButton categoryButton = new CategoryButton(category.getName(),x,y,175,50,this, "show");
            add(categoryButton);

            repaint();

            x+=200;
        }
    }
}
