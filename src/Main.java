import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, JPanel> panels = new HashMap<>();
    public static Map<String ,Category> shoppingList = new HashMap<>();
    public static Map<String ,Category> products = new HashMap<>();

    public static void main(String[] args) {

        readProducts();
        readShoppingList();

        MainFrame myFrame = new MainFrame();
        MainPanel mainPanel = new MainPanel(myFrame);
        Main.panels.put("mainPanel",mainPanel);
        myFrame.add(mainPanel);
        myFrame.repaint();

    }

    public static void readProducts(){
        try(BufferedReader reader = new BufferedReader(new FileReader("product_list.txt"))){
            String line;
            String currentCategoryName = null;
            while ((line =  reader.readLine()) != null){

                if(line.endsWith(":")){
                    currentCategoryName = line.substring(0,line.length()-1);
                    products.put(currentCategoryName, new Category(currentCategoryName));
                    shoppingList.put(currentCategoryName, new Category(currentCategoryName));
                }
                else {
                    String[] splitted = line.split("/");

                    products.get(currentCategoryName).addProduct(splitted[0],splitted[1], shoppingList.get(currentCategoryName));
                }
            }
        }
        catch (IOException e){
            System.out.println("nie znaleziono pliku");
        }
    }

    public static void readShoppingList(){
        try(BufferedReader reader = new BufferedReader(new FileReader("shopping_list.txt"))){
            String line;
            String currentCategoryName = null;
            while ((line =  reader.readLine()) != null){

                if(line.endsWith(":")){
                    currentCategoryName = line.substring(0,line.length()-1);
                }
                else {
                    String[] splitted = line.split("/");

                    shoppingList.get(currentCategoryName).addProduct(splitted[0],splitted[2], shoppingList.get(currentCategoryName), Double.parseDouble(splitted[1]));
                }
            }
        }
        catch (IOException e){
            System.out.println("nie znaleziono listy zakupów");
        }
    }
}


