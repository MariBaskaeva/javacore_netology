public abstract class Event{
	private String title;
	private Integer releaseYear;
	private Integer age;

	public Event(String title, Integer releaseYear, Integer age){
		this.title = title;
		this.releaseYear = releaseYear;
		this.age = age;
	}

	@Override
	public String toString(){
		return "title: " + title + 
		"\nrelease year: " + releaseYear +
		"\nage: " + age;
	}

	public String getTitle(){
		return title;
	}
	public Integer getReleaseYear(){
		return releaseYear;
	}
	public Integer getAge(){
		return age;
	}
}