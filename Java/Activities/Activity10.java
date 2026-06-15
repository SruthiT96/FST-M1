package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity10 {
public static void main(String[] args) {
	Map<Integer, String> colours=new HashMap<>();
	colours.put(1, "Red");
	colours.put(2, "White");
	colours.put(3, "Blue");
	colours.put(4, "Green");
	colours.put(5, "Yellow");

	for(Integer key: colours.keySet()) {
		System.out.println(key+":"+colours.get(key));
	}
	System.out.println("Map: "+colours);
	System.out.println("Removing "+colours.remove(5));
    System.out.println("After removing Yellow: " + colours);
	if(colours.containsValue("green")){
		System.out.println("Green exists in the map");
	}else {
		System.out.println("Green doesnot exists in the map");

	}
	System.out.println("Size of the map: "+colours.size());
}
}
