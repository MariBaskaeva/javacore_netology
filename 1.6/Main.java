class Main{
	public static void main(String[] args){
		Product prod1 = new Product(50, "Name1", "Descr1");
		Product prod2 = new Product(200, "Name2", "Descr2");
		Product prod3 = new Product(20, "Name3", "Descr3");
		Product prod4 = new Product(70, "Name4", "Descr4");
		Product prod5 = new Product(100, "Name5", "Descr5");

		Product[] products = {prod1, prod2, prod3, prod4, prod5};
		mySort(products, 0, products.length - 1);

		System.out.println("Sorted prices:");
		for(int i = 0; i < products.length; i++){
			System.out.print(products[i].getPrice() + " ");
		}
	}

	static void mySort(Product[] products, int left, int right){
		int i = left, j = right;
		int key = (left + right) / 2;

		while(i <= j){
			while(products[i].getPrice() < products[key].getPrice()){
				i++;
			}
			while(products[j].getPrice() > products[key].getPrice()){
				j--;
			}

			if(i <= j){
				int step = products[j].getPrice();
				products[j].setPrice(products[i].getPrice());
				products[i].setPrice(step);
				i++;
				j--;
			}			
		}

		if(left < j){
			mySort(products, left, j);
		}
		if(right > i){
			mySort(products, i, right);
		}
	}
}