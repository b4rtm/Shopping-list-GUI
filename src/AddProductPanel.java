import javax.swing.*;
import java.awt.*;

public class AddProductPanel extends JPanel {

    AddProductPanel(JFrame myFrame){
        setBackground(new Color(233, 243, 245));
        setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);

        JLabel label = new JLabel();
        label.setText("Dodaj produkty");
        label.setBounds((MainFrame.WIDTH-300)/2,5,300,100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(getFont().deriveFont(35f));
        add(label);

        add(new ReturnButton("Cofnij",10,10,70,30,"addProductPanel", myFrame));

        int x=100;
        for(Category category : Main.products.values()){
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
                AddProductButton addProductButton = new AddProductButton(product.getName(),x,y,this, category, "add");
                addProductButton.addActionListener(e -> showSetQuantityPanel(product.getName(),this, category));
                add(addProductButton);
            }

            repaint();
            x+=200;
        }

    }

    public static void showSetQuantityPanel(String productName,JPanel panel,Category category){
        panel.add(new SetQuantityPanel(productName,category,panel));
        panel.repaint();
    }

}
