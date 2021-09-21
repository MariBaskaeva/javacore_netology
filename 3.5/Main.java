public class Main{
	public static void main(String[] args){
		Device mobile = new Mobile("UPhone", "Orange", 30_000, 100);
		SmartWatch smartWatch = new SmartWatch("UWatch", "Black", 30_000, true);
		Book book1 = new Book("S", "M", 100);
		Product book2 = new Book("T", "H", 3000);
		Shop<Device> shop = new Shop<>();
		shop.add(mobile);
		shop.add(smartWatch);

		System.out.println(shop.getRandom().getTitle());
	}
}