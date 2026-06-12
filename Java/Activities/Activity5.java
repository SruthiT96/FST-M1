package activities;

public class Activity5 {	
	public static void main(String[] args) {
		MyBook newNovel=new MyBook();
		String title="Karvalo";
		newNovel.setTitle(title);
		//Print result
		System.out.println("The title is: " + newNovel.getTitle());
	}
	
}
class MyBook extends Book{
	@Override
	public void setTitle(String s) {
	    title = s;
	}
}

abstract class Book{
	public String title;
	
	public abstract void setTitle(String title);
	
	public String getTitle() {
		return this.title;
	}
	
}