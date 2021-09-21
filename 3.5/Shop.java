import java.util.*;

public class Shop<T extends Product> {
	private List<T> items = new ArrayList<>();
	private Random random = new Random();

	public void add(T product){
		items.add(product);
	}

	public T getRandom(){
		return items.get(random.nextInt(items.size()));
	}

	public T getCheapest(){
		int minIndex = 0;
		for(int i = 1; i < items.size(); i++){
			if(items.get(minIndex).getPrice() > items.get(i).getPrice()){
				minIndex = i;
			}
		}

		return items.get(minIndex);
	}
}