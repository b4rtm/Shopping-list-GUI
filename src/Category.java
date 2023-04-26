import java.util.ArrayList;

public class Category {
    private final String name;
    private ArrayList<Product> products;

    public Category(String name){
        this.name = name;
        products = new ArrayList<>();
    }

    public void addProduct(String productName, String unit, Category category){

        products.add(new Product(productName, unit, category));
    }

    public void addProduct(String productName, String unit, Category category,double quantity){

        products.add(new Product(productName, unit, category,quantity));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void clearProducts(){
        products.clear();
    }

    public void removeProduct(String product){
        for(Product productIterator : products){
            if(productIterator.getName().equals(product)) {
                products.remove(productIterator);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String productList = name + ":";
        for(Product product : products){
            productList += "\n" + product.getName() + "/" + product.getQuantity() + "/" + product.getUnit() ;
        }
        return productList + "\n";
    }
}
