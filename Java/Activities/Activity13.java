package activities;

import java.util.Scanner;

public class Activity13 {
	public void registerUser(String age) {
		try {
			int ageNum = Integer.parseInt(age);
			if (ageNum < 18) {
				throw new IllegalArgumentException("Users must be at least 18 years old.");
			} else {
				System.out.println("Registration successful! Welcome aboard.");
			}
		} catch (NumberFormatException ne) {
			System.out.println("Error: Age must be a valid number.");
		} catch (IllegalArgumentException ie) {
			System.out.println("Registration Failed !! " + ie.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		Activity13 reg=new Activity13();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter age: ");
		String age = scan.next();
		scan.close();
		reg.registerUser(age);

	}
}
