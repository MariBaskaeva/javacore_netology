public class Main{
	public static void main(String[] args){
    	for (Event event: getMovies()) {
    	    validEvent(event);
    	}
    	for (Event event: getTheatres()) {
    	    validEvent(event);
    	}
    	System.out.println("All events are correct");
	}

    public static Movie[] getMovies(){
        return new Movie[]{
            new Movie("Inception", 2010, 16),
            new Movie("The Shack", null, 16)
        };
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
            new Theatre("Anna Karenina", 2017, 16)
        };
    }
    public static void validEvent(Event event){
    	if(event.getTitle().equals(null) || 
    		event.getReleaseYear() == 0 || event.getReleaseYear() == null ||
    		event.getAge() == 0 || event.getAge() == null)
    		throw new RuntimeException("Invalid input\n" + event);
    }

}