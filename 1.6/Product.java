public class Product {
   private String name;
   private int price;
   private String description;

   public Product(int price, String name, String description) {
      this.name = name;
      this.price = price;
      this.description = description;
   }
   public int getPrice(){
   		return price;
   }
   public void setPrice(int price){
   	this.price = price;
   }
}
