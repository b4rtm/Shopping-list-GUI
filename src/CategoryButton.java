import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CategoryButton extends JToggleButton {

    CategoryButton(String categoryName,int x, int y, int buttonWidth, int buttonHeight, JPanel panel, String operation ){
        super(categoryName);
        setBounds(x,y,buttonWidth,buttonHeight);
        setHorizontalAlignment(JButton.CENTER);
        setFocusable(false);
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createEtchedBorder());

        ItemListener itemListener = itemEvent -> {

            int state = itemEvent.getStateChange();

            if (state == ItemEvent.SELECTED) {
                if(operation.equals("show")) {
                    int iterator = 70;
                    for (Product product : Main.shoppingList.get(categoryName).getProducts()) {
                        JLabel label = new JLabel();
                        label.setText(product.getName()+" : " + product.getQuantity() + " " + product.getUnit());
                        label.setBounds(x, y + iterator, 175, 50);
                        label.setHorizontalAlignment(JLabel.CENTER);
                        label.setVerticalAlignment(JLabel.CENTER);
                        label.setOpaque(true);
                        label.setBackground(Color.WHITE);
                        label.setBorder(BorderFactory.createEtchedBorder());
                        panel.add(label);

                        iterator += 50;
                        panel.repaint();
                    }
                }
                else if(operation.equals("delete")){
                    int y1 =200;
                    for (Product product : Main.shoppingList.get(categoryName).getProducts()){
                        y1 +=80;
                        AddProductButton addProductButton = new AddProductButton(product.getName(),x, y1,panel, Main.shoppingList.get(categoryName),"delete");
                        panel.add(addProductButton);
                    }
                    panel.repaint();
                }
            }
            else {
                if(operation.equals("show")) {
                    for (Component componentIterator : panel.getComponents()) {
                        for (Product product : Main.shoppingList.get(categoryName).getProducts()) {
                            if (componentIterator instanceof JLabel) {
                                if ((((JLabel) componentIterator).getText()).contains(product.getName())) {
                                    panel.remove(componentIterator);
                                }
                            }
                            panel.repaint();
                        }
                    }
                }
                else if(operation.equals("delete")){
                    for (Component componentIterator : panel.getComponents()) {
                        for (Product product : Main.shoppingList.get(categoryName).getProducts()) {
                            if (componentIterator instanceof JButton) {
                                if (product.getName().equals(((JButton) componentIterator).getText())) {
                                    panel.remove(componentIterator);
                                }
                            }
                            panel.repaint();
                        }
                    }
                }

            }
        };

        addItemListener(itemListener);

    }

}
