import javax.swing.*;
import java.awt.*;

public class ShowAllProductsPanel extends JPanel {

    ShowAllProductsPanel(JFrame myFrame){
        setBackground(new Color(233, 243, 245));
        setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);

        JLabel label = new JLabel();
        label.setText("Produkty na liście zakupów");
        label.setBounds((MainFrame.WIDTH-500)/2,5,500,100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(getFont().deriveFont(30f));

        add(label);
        add(new ReturnButton("Cofnij",10,10,70,30,"showAllProductsPanel",myFrame));

        int x=100;
        for(Category category : Main.shoppingList.values()){
            int y=200;
            JLabel categoryLabel = new JLabel(category.getName());
            categoryLabel.setBounds(x,y,175,50);
            categoryLabel.setFont(getFont().deriveFont(20f));
            categoryLabel.setHorizontalAlignment(JLabel.CENTER);
            categoryLabel.setVerticalAlignment(JLabel.CENTER);
            categoryLabel.setOpaque(true);
            categoryLabel.setBackground(Color.WHITE);
            categoryLabel.setBorder(BorderFactory.createEtchedBorder());
            add(categoryLabel);

            for (Product product : category.getProducts()){
                y+=80;
                JLabel productLabel = new JLabel();
                productLabel.setText(product.getName()+" : " + product.getQuantity() + " " + product.getUnit());
                productLabel.setBounds(x,y,175,50);

                productLabel.setHorizontalAlignment(JLabel.CENTER);
                productLabel.setVerticalAlignment(JLabel.CENTER);
                productLabel.setOpaque(true);
                productLabel.setBackground(new Color(217, 247, 252));
                productLabel.setBorder(BorderFactory.createEtchedBorder());
                add(productLabel);
            }

            repaint();
            x+=200;
        }
    }

}
