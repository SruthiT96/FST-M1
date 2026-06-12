package activities;

public class Activity4 {
public static void main(String[] args) {
	int arr[]= {8,7,10,2,5,1,0};
	System.out.println("Array before sorting");
	for(int i=0;i<arr.length ; i++) {
		System.out.print(arr[i]+" ");
	}
	for(int i=0;i<arr.length ; i++) {
		for(int j=i+1;j<arr.length; j++) {
			int temp=0;
			if(arr[i]>arr[j]) {
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
	System.out.println("");

	System.out.println("Array after sorting");
	for(int i=0;i<arr.length ; i++) {
		System.out.print(arr[i]+" ");
	}
}
}
