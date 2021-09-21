public class User{
	private String name;

	User(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	@Override
	public String toString(){
		return name;
	}
}