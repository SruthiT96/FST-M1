package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity9 {
public static void main(String[] args) {
	Set<Object> hs=new HashSet<>();
	hs.add("Lucky");
	hs.add(23);
	hs.add(true);
	hs.add("Mohan");
	hs.add(16.5f);
	hs.add(78902567);
	System.out.println("Size of the hashset is "+hs.size());
	System.out.println("Removing 23 from the hash set: "+hs.remove(23));
	if(hs.remove(45)) {
		System.out.println("45 removed from the Set");
    } else {
    	System.out.println("45 is not present in the Set");
    }
	if(hs.contains("Money")){
		System.out.println("Money exists the Set");
    } else {
    	System.out.println("Money does not exists in the Set");
    }
	
	for(Object ob:hs) {
		System.out.println(ob);
	}
}
}
