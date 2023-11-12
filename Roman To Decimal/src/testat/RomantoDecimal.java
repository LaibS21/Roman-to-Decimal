package testat;

import java.util.Scanner; //Important when you write Scanner.nextLine();

public class RomantoDecimal { // name of the Class

	public static void main(String[] args) { // Without this the program won't work
		Scanner sc = new Scanner(System.in);
		boolean text = true; // is for true and false
		while (text) {// its like a expression for true and false which must return to a boolean value
			System.out.println("Type 1 for Roman numbers to decimal :"); // read the text from boolean
			System.out.println("Type 2 for Decimal to Roman numbers :");
			int decimalnumber = 0; // int is a number without a fractional component, and they don't support decimal points.
			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) {
				System.out.print("Here the Roman numeral is converted :"); // reads the command from String
				String romannumber = sc.nextLine(); // Here the Roman numeral is converted
				for (int i = 0; i < romannumber.length(); i++) {
					//This is where the loop begins, iterating through each character of the Roman numeral.
					//"i" is the loop index running from 0 to the length of the string "romannumber".
					//"roman number.length()" returns the number of characters in the Roman numeral.

					if (romannumber.charAt(i) == 'I') { // Here is I
						// This checks whether the current character is 'I', which stands for the Roman numeral 1
						// If 'I' is found, various conditions are checked to determine whether 'I' is subtracted or added.
						// Depending on the condition, the value of `decimal number` is adjusted accordingly.
						if (i < romannumber.length() - 1
								&& (romannumber.charAt(i + 1) == 'V' || romannumber.charAt(i + 1) == 'C')) {
							decimalnumber = decimalnumber - 1; // Subtracting for 'IV'

						}

						else if (i < romannumber.length() - 1 && romannumber.charAt(i + 1) == 'X')
							decimalnumber = decimalnumber - 1; // Subtracting for 'IX'
						else {
							decimalnumber = decimalnumber + 1; // Adding for 'I'

						}

					}

					if (romannumber.charAt(i) == 'V') { // Here is V
						if (i < romannumber.length() - 1 && romannumber.charAt(i + 1) == 'X') {
							decimalnumber = decimalnumber - 10;
						} else if (i < romannumber.length() - 1 && romannumber.charAt(i + 1) == 'C') {
							decimalnumber = decimalnumber - 5;

						} else if (i < romannumber.length() - 1 && romannumber.charAt(i + 1) == 'D')
							decimalnumber = decimalnumber - 5;

						else
							decimalnumber = decimalnumber + 5; // Adding for 'V'

					}
					// X at position i
					if (romannumber.charAt(i) == 'X') { // Here is X
						// XL
						if (i < romannumber.length() - 1 && romannumber.charAt(i + 1) == 'L') {
							decimalnumber = decimalnumber - 10;
						} else if (i < romannumber.length() - 1 && romannumber.charAt(i + 1) == 'C') {
							decimalnumber = decimalnumber + 90;
						} else {

							decimalnumber = decimalnumber + 10; // Adding for 'X'

						}

					}
					if (romannumber.charAt(i) == 'L') { // Here is L
						if (i < romannumber.length() - 1 && romannumber.charAt(i + 1) == 'D')
							decimalnumber = decimalnumber - 50;
						else
							decimalnumber = decimalnumber + 50; // Adding for 'L'
					}
					if (romannumber.charAt(i) == 'C') { // Here is C
						if (i < romannumber.length() - 1 && romannumber.charAt(i + 1) == 'D') {
							decimalnumber = decimalnumber - 100; // CD = 400
						} else if (i < romannumber.length() - 1 && romannumber.charAt(i + 1) == 'M') {
							decimalnumber = decimalnumber + 900;
						} else if (!(i > 0 && romannumber.charAt(i - 1) == 'X')) {
							decimalnumber = decimalnumber + 100; // Adding for 'C'
						}

					}
					if (romannumber.charAt(i) == 'D') { // Here is D
						if (i < romannumber.length() - 1 && romannumber.charAt(i + 1) == 'M')
							decimalnumber = decimalnumber + 500;
						else
							decimalnumber = decimalnumber + 500; // Adding for 'D'

					}
					if (romannumber.charAt(i) == 'M') { // Here is M
						if (!(i > 0 && romannumber.charAt(i - 1) == 'C'))
							decimalnumber = decimalnumber + 1000; // Adding for 'M'
					}
				}
				System.out.println(decimalnumber);
			}

			else if (choice == 2) {
				System.out.println("Enter the Decimal Number :");
				int num = sc.nextInt(); // 1200 //MCC (Reads the entered number and stores it in the "num" variable.)
				System.out.print("Roman Number :");
				sc.nextLine();
				while (num > 0) {// 1200>0 true,200>0true,100>0true,0>0false		
					while (num >= 1000) { // 1200>=1000true,1200>1000false,100>=1000false
						System.out.print("M");// M //1920 % 1000 M = 920
						num = num - 1000;// 1200-1000=200
					}
					while (num >= 900) {// 200>=900false,100>=900false
						System.out.print("CM");
						num = num - 900;
					}
					// Each "while" loop checks if the decimal number is large enough to use the respective Roman numeral.
				    // If yes, it prints the Roman numeral and updates the value of "num" to subtract the converted part of the number.
					while (num >= 500) {// 200>=500false,100false,100>=500false
						System.out.print("D");
						num = num - 500;
					}
					while (num >= 400) {// 200>=400false,100>=400false
						System.out.print("CD");
						num = num - 400;
					}
					while (num >= 100) {// 200>100true,100>=100true
						System.out.print("C");// C
						num = num - 100;// 200-100=100,100-100=0
					}
					while (num >= 90) {
						System.out.print("XC");
						num = num - 90;
					}
					while (num >= 50) {
						System.out.print("L");
						num = num - 50;
					}
					while (num >= 40) {
						System.out.print("XL");
						num = num - 40;
					}
					while (num >= 10) {
						System.out.print("X");
						num = num - 10;
					}
					while (num >= 9) {
						System.out.print("IX");
						num = num - 9;
					}
					while (num >= 5) {
						System.out.print("V");
						num = num - 5;
					}
					while (num >= 4) {
						System.out.print("IV");
						num = num - 4;
					}
					while (num >= 1) {
						System.out.print("I");
						num = num - 1;

					}

				}
			}
			System.out.println();
			System.out.println("N/J or n/j: ");
	
			String abfrage = sc.nextLine();
			 if (abfrage.length() > 0 && abfrage.charAt(0) == 'N') {
				// Check if the input string starts with 'N' to exit the program.
				// Check if the input string is not empty and its first character is 'N'
				// Your code here if the condition is met
				text = false;
				return;
			}
			
		}
		
	} 
	
}

