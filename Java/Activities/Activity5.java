package activityE;


//Main class

public class Activity5 {

    public static void main(String[] args) {

        // Create object of MyBook
        MyBook newNovel = new MyBook();

        // Set title
        String title = "The Great Gatsby";
        newNovel.setTitle(title);

        // Print title
        System.out.println("The title is: " + newNovel.getTitle());
    }
}

