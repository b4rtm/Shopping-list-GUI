import javax.swing.*;
import java.awt.*;

public class DeleteProductPanel extends JPanel {

    DeleteProductPanel(JFrame myFrame){
        setBackground(new Color(233, 243, 245));
        setBounds(0,0,MainFrame.WIDTH,MainFrame.HEIGHT);

        JLabel label = new JLabel();
        label.setText("Usuń dany produkt");
        label.setBounds((MainFrame.WIDTH-500)/2,5,500,100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(getFont().deriveFont(30f));


        add(label);
        add(new ReturnButton("Cofnij",10,10,70,30,"deleteProductPanel", myFrame));

        int x=100;
        for(Category category : Main.products.values()){
            int y=200;
            CategoryButton categoryButton = new CategoryButton(category.getName(),x,y,175,50,this,"delete");
            add(categoryButton);



            repaint();
            x+=200;
        }

        repaint();

    }
}
