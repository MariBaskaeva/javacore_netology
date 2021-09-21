public class Theatre extends Event{

	public Theatre(String title, Integer releaseYear, Integer age){
		super(title, releaseYear, age);
	}

	@Override
	public String toString(){
		return "Theatre\n" + super.toString();
	}
	@Override
	public String getTitle(){
		return super.getTitle();
	}
	@Override
	public Integer getReleaseYear(){
		return super.getReleaseYear();
	}
	@Override
	public Integer getAge(){
		return super.getAge();
	}
}