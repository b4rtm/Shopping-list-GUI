import javax.swing.*;
import java.awt.*;

public class AddProductButton extends JButton {

    AddProductButton(String productName, int x, int y, JPanel panel, Category category, String operation) {
        super(productName);
        setBounds(x, y, 175, 40);
        setFocusable(false);

        if (operation.equals("add"))
            addActionListener(e -> showSetQuantityPanel(productName, panel, category));
        else if (operation.equals("delete"))
            addActionListener(e -> deleteProduct(productName, category, panel, x, y));


    }

    public static void showSetQuantityPanel(String productName, JPanel panel, Category category) {
        for (Component panelIterator : panel.getComponents()) {
            if (panelIterator instanceof SetQuantityPanel) {
                panel.remove(panelIterator);
            }
        }

        panel.add(new SetQuantityPanel(productName, category, panel));
        panel.repaint();
    }

    public static void deleteProduct(String productName, Category category, JPanel panel, int x, int y) {
        Main.shoppingList.get(category.getName()).removeProduct(productName);

        for (Component panelIterator : panel.getComponents()) {
            if (panelIterator instanceof JButton && !((JButton) panelIterator).getText().equals("Cofnij") && panelIterator.getX()==x) {
                panel.remove(panelIterator);
                panel.repaint();
            }

            int y1 = 200;
            for (Product product : category.getProducts()) {
                y1 += 80;
                AddProductButton addProductButton = new AddProductButton(product.getName(), x, y1, panel, category, "delete");
                panel.add(addProductButton);
            }
        }
        panel.repaint();
    }
}

