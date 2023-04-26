import javax.swing.*;
import java.awt.*;

public class DeleteAllProductsFromCategoryPanel extends JPanel{

    DeleteAllProductsFromCategoryPanel(JFrame myFrame){
        setBackground(new Color(233, 243, 245));
        setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);

        JLabel label = new JLabel();
        label.setText("Wybierz kategorie z której chcesz usunąć wszystkie produkty");
        label.setBounds((MainFrame.WIDTH-600)/2,5,600,100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(getFont().deriveFont(20f));

        add(label);
        add(new ReturnButton("Cofnij",10,10,70,30,"deleteAllProductsFromCategoryPanel",myFrame));
        int x = 100;
        for(Category category : Main.shoppingList.values()){
            JButton button = new JButton(category.getName());
            button.setBounds(x,200,175,50);
            button.addActionListener(e -> deleteProductsFromCategory(category,this));
            button.setFocusable(false);
            add(button);
            x+=200;
        }
        repaint();

    }

    public static void deleteProductsFromCategory(Category category, JPanel panel){

        for (Component componentIterator : panel.getComponents()) {

            if (componentIterator instanceof JLabel) {
                if ((((JLabel) componentIterator).getText()).contains("kategorii")) {
                    panel.remove(componentIterator);
                    panel.repaint();
                }
            }
        }
        panel.repaint();


        JLabel label = new JLabel("Usunięto produkty z kategorii: " + category.getName());
        if(category.getProducts().isEmpty()){
            label.setText("Brak produktów w kategorii: " + category.getName());
        }
        else
            category.getProducts().clear();

        label.setBounds((MainFrame.WIDTH-500)/2,400,500,100);
        label.setFont(panel.getFont().deriveFont(20f));
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setBorder(BorderFactory.createEtchedBorder());
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        panel.add(label);
        panel.repaint();
    }
}
