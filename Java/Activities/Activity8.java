package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity8 {
public static void main(String[] args) {
	List<String> myList =new ArrayList<>();
	myList.add("Rama");
	myList.add("Shama");
	myList.add("Lahari");
	myList.add("Bhanu");
	myList.add("Soumya");
	
	for(String name:myList) {
		System.out.println(name);
	}
	System.out.println("2nd index value is: "+myList.get(2));//retrieve 3rd name
	if(myList.contains("Soumya")) {
		System.out.println("Array list contains Soumya");
	}else {
		System.out.println("Array list does not contains Soumya");

	}
	System.out.println("Size of the array list: "+myList.size());
	for(int i=0;i<myList.size();i++) {
	System.out.println(myList.get(i));
	}
	System.out.println("Removing: "+myList.remove(1));
	System.out.println("Size of the array list after removing a name: "+myList.size());
	

}
}
