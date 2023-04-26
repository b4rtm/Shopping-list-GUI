import javax.swing.*;
import java.awt.*;


public class MainPanel extends JPanel {

    MainPanel(JFrame myFrame){

        setBackground(new Color(233, 243, 245));
        setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);


        int buttonWidth = 400;
        int buttonHeight = 50;

        MainButton addProductButton = new MainButton("Dodaj produkt do listy zakupów",200,50,buttonWidth,buttonHeight,"addProductPanel", myFrame);
        add(addProductButton);

        MainButton showAllProductsButton = new MainButton("Wyświetl wszystkie produkty",200,150,buttonWidth,buttonHeight, "showAllProductsPanel",myFrame);
        add(showAllProductsButton);

        MainButton showAllProductsFromCategoryButton = new MainButton("Wyświetl wszystkie produkty z listy zakupów z danej kategorii",200,250,buttonWidth,buttonHeight,"showAllProductsFromCategoryPanel",myFrame);
        add(showAllProductsFromCategoryButton);

        MainButton deleteAllProductsButton = new MainButton("Usuń wszystkie produkty z listy zakupów",200,350,buttonWidth,buttonHeight,"deleteAllProductsPanel",myFrame);
        add(deleteAllProductsButton);

        MainButton deleteAllProductsFromCategoryButton = new MainButton("Usuń wszystkie produkty z listy zakupów z danej kategorii",200,450,buttonWidth,buttonHeight,"deleteAllProductsFromCategoryPanel",myFrame);
        add(deleteAllProductsFromCategoryButton);

        MainButton deleteProductButton = new MainButton("Usuń produkt z listy zakupów",200,550,buttonWidth,buttonHeight,"deleteProductPanel",myFrame);
        add(deleteProductButton);

        MainButton saveListOnFileButton = new MainButton("Zapisz listę zakupów do pliku",200,650,buttonWidth,buttonHeight, "saveListOnFilePanel",myFrame);
        add(saveListOnFileButton);


        repaint();

    }
}
