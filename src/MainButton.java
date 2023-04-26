import javax.swing.*;
import java.awt.*;

public class MainButton extends JButton{

    public MainButton(String label,int x, int y, int buttonWidth, int buttonHeight, String panel, JFrame myFrame){
        super(label);


        setBounds(x,y,buttonWidth,buttonHeight);
        setHorizontalAlignment(JButton.CENTER);
        setFocusable(false);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createEtchedBorder());
        addActionListener(e -> switchPanel(panel, myFrame));

    }


    public void switchPanel(String panel, JFrame myFrame){

        myFrame.remove(Main.panels.get("mainPanel"));
        myFrame.repaint();

        switch (panel) {
            case "addProductPanel" -> {
                AddProductPanel addProductPanel = new AddProductPanel(myFrame);
                Main.panels.put("addProductPanel", addProductPanel);
                myFrame.add(Main.panels.get("addProductPanel"));
            }
            case "showAllProductsPanel" -> {
                ShowAllProductsPanel showAllProductsPanel = new ShowAllProductsPanel(myFrame);
                Main.panels.put("showAllProductsPanel", showAllProductsPanel);
                myFrame.add(Main.panels.get("showAllProductsPanel"));
            }
            case "showAllProductsFromCategoryPanel" -> {
                ShowAllProductsFromCategoryPanel showAllProductsFromCategoryPanel = new ShowAllProductsFromCategoryPanel(myFrame);
                Main.panels.put("showAllProductsFromCategoryPanel", showAllProductsFromCategoryPanel);
                myFrame.add(Main.panels.get("showAllProductsFromCategoryPanel"));
            }
            case "deleteAllProductsPanel" -> {
                DeleteAllProductsPanel deleteAllProductsPanel = new DeleteAllProductsPanel(myFrame);
                Main.panels.put("deleteAllProductsPanel", deleteAllProductsPanel);
                myFrame.add(Main.panels.get("deleteAllProductsPanel"));
            }
            case "deleteAllProductsFromCategoryPanel" -> {
                DeleteAllProductsFromCategoryPanel deleteAllProductsFromCategoryPanel = new DeleteAllProductsFromCategoryPanel(myFrame);
                Main.panels.put("deleteAllProductsFromCategoryPanel", deleteAllProductsFromCategoryPanel);
                myFrame.add(Main.panels.get("deleteAllProductsFromCategoryPanel"));
            }
            case "deleteProductPanel" -> {
                DeleteProductPanel deleteProductPanel = new DeleteProductPanel(myFrame);
                Main.panels.put("deleteProductPanel", deleteProductPanel);
                myFrame.add(Main.panels.get("deleteProductPanel"));
            }
            case "saveListOnFilePanel" -> {
                SaveListOnFilePanel saveListOnFilePanel = new SaveListOnFilePanel(myFrame);
                Main.panels.put("saveListOnFilePanel", saveListOnFilePanel);
                myFrame.add(Main.panels.get("saveListOnFilePanel"));
            }
        }
    }


}
