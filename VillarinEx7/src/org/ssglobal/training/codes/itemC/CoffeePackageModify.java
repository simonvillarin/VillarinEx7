package org.ssglobal.training.codes.itemC;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CoffeePackageModify {
	private final double BAG_PRICE = 5.5;
	private final double LARGE_BOX_PRICE = 1.2;
	private final double MEDIUM_BOX_PRICE = 1.0;
	private final double SMALL_BOX_PRICE = 0.60;

	public void computation() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Enter bags ordered: ");
			int bagsOrdered = sc.nextInt();
			System.out.print("Enter order date: ");
			String orderDate = sc.next();

			double totalBagPrice = bagsOrdered * BAG_PRICE;

			DecimalFormat df = new DecimalFormat();
			df.applyPattern("###,##0.00");
			String valStr = df.format(totalBagPrice);

			System.out.print("Number of Bags Ordered: %s - \u0024 %s \n".formatted(bagsOrdered, valStr));
			System.out.println("Boxed Used: ");

			int largeQty = (int) bagsOrdered / 20;
			int mediumQty = (int) (bagsOrdered - (largeQty * 20)) / 10;
			int smallQty = (int) (bagsOrdered - ((largeQty * 20) + (mediumQty * 10)));

			if (smallQty <= 5 && smallQty > 0) {
				smallQty = 1;
			}

			double largePrice = largeQty * LARGE_BOX_PRICE;
			String valStr2 = df.format(largePrice);
			double mediumPrice = mediumQty * MEDIUM_BOX_PRICE;
			String valStr3 = df.format(mediumPrice);
			double smallPrice = smallQty * SMALL_BOX_PRICE;
			String valStr4 = df.format(smallPrice);

			System.out.println("%12d Large  - \u0024%s".formatted(largeQty, valStr2));
			System.out.println("%12d Medium - \u0024%s".formatted(mediumQty, valStr3));
			System.out.println("%12d Small  - \u0024%s".formatted(smallQty, valStr4));

			double totalPrice = totalBagPrice + largePrice + mediumPrice + smallPrice;
			String valStr5 = df.format(totalPrice);

			System.out.println("Your total cost: \u0024 %s".formatted(valStr5));

			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate now = LocalDate.parse(orderDate, dateFormat);
			String nowStr = now.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
			System.out.println("Date of Order: \t\t  %s".formatted(nowStr));

			now = now.plusDays(14);
			
			nowStr = now.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
			System.out.println("Expected Date of Arrival: %s".formatted(nowStr));
			System.out.print("Input more?[Y/N]: ");
			char choice = sc.next().charAt(0);

			if (choice == 'N' || choice == 'n') {
				break;
			}
		}
		sc.close();
	}
}
