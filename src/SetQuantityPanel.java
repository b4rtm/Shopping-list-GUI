import javax.swing.*;
import java.awt.*;


public class SetQuantityPanel extends JPanel {

    SetQuantityPanel(String productName, Category category, JPanel panel){
        setBounds(250,620,310,130);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);

        JLabel label =  new JLabel();
        label.setText("Podaj ilość dla produktu: " + productName);

        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setBounds(25,5,280,50);
        label.setFont(getFont().deriveFont(13f));
        label.setForeground(Color.BLACK);
        add(label);


        JTextField inputBox = new JTextField();
        inputBox.setBounds(25,60,50,30);
        add(inputBox);

        JButton button = new JButton();
        button.setText("Dodaj");
        button.setFocusable(false);
        button.setBounds(150,60,100,30);

        button.addActionListener(e -> addProduct(productName, inputBox.getText(), category, panel, this));

        add(button);

        repaint();

    }

    public static void addProduct(String productName, String quantity, Category category, JPanel panel, JPanel quantityPanel){

        int i;
        double d;

        for(Category categoryIterator : Main.products.values()){
            for(Product productIterator : categoryIterator.getProducts()){
                if(productName.equals(productIterator.getName())){
                    try{
                        if(productIterator.getUnit().equals("szt")) {
                            i = Integer.parseInt(quantity);
                            Main.shoppingList.get(categoryIterator.getName()).addProduct(productName, productIterator.getUnit(), categoryIterator, i);
                        }
                        else {
                            d = Double.parseDouble(quantity);
                            Main.shoppingList.get(categoryIterator.getName()).addProduct(productName, productIterator.getUnit(), categoryIterator, d);
                        }
                    }
                    catch (NumberFormatException e){
                        JLabel invalidLabel = new JLabel();
                        invalidLabel.setText("Nieprawidłowa wartość");
                        invalidLabel.setForeground(Color.RED);
                        invalidLabel.setBounds(150,90,200,30);
                        quantityPanel.add(invalidLabel);
                        quantityPanel.repaint();
                        return;
                    }

                }
            }
        }
        for (Component panelIterator : panel.getComponents()){
            if(panelIterator instanceof SetQuantityPanel){
                panel.remove(panelIterator);
            }
        }
        panel.repaint();

    }
}
