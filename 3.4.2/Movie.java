public class Movie extends Event{

	public Movie(String title, Integer releaseYear, Integer age){
		super(title, releaseYear, age);
	}

	@Override
	public String toString(){
		return "Movie\n" + super.toString();
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