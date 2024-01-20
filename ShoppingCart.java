//Java Solution

import java.util.Scanner;

class ShoppingCart{

	//All prizes are in Doller($)

	int productA, productB, productC;

	int giftWrap, shipping;

	int totalAmountOfA, totalAmountOfB, totalAmountOfC;

	ShoppingCart(){

		productA = 20;
		productB = 40;
		productC = 50;

		giftWrap = 1;
		shipping = 5; //for 1 package and 1 package includes 10 units

	}

	int totalAmountOfProductA(int quantityA)
	{
		totalAmountOfA = quantityA * productA; 

		return totalAmountOfA;
	}

	int totalAmountOfProductB(int quantityB)
	{
		totalAmountOfB = quantityB * productB;
		
		return totalAmountOfB;
	}

	int totalAmountOfProductC(int quantityC)
	{
		totalAmountOfC = quantityC * productC;
		
		return totalAmountOfC;
	}

	float flat10Discount(int subTotal){

		float flat_10_discount = 0;

		if(subTotal > 200) //for flat_10_discount offer
		{
			flat_10_discount = 10;
			//System.out.println("flat_10_discount" + flat_10_discount);
		}

		return flat_10_discount;
	}

	float bulk5Discount(int quantityA, int quantityB, int quantityC)
	{
		float bulk_5_discount = 0;
		float bulk_5_discount_A = 0;
		float bulk_5_discount_B = 0;
		float bulk_5_discount_C = 0;

		if(quantityA > 10) // for 5% discount on that item's total price.
		{
			bulk_5_discount_A = (totalAmountOfProductA(quantityA) * 5)/100;
		
			if(quantityB > 10)
			{
				bulk_5_discount_B = (totalAmountOfProductB(quantityB) * 5)/100;		

				if(quantityC > 10)
				{
					bulk_5_discount_C = (totalAmountOfProductC(quantityC) * 5)/100;
				}
			}
			else if(quantityC > 10)
			{
				bulk_5_discount_C = (totalAmountOfProductC(quantityC) * 5)/100;
			}
			else
			{
				bulk_5_discount_B = 0;
				bulk_5_discount_C = 0;
			}
		}	

		bulk_5_discount = (bulk_5_discount_A + bulk_5_discount_B + bulk_5_discount_C);
		//System.out.println("bulk_5_discount    " + bulk_5_discount);

		return bulk_5_discount;
	}

	float bulk10Discount(int subTotal, int totalQuantity)
	{
		float bulk_10_discount = 0;
		
		if(totalQuantity > 20) // for bulk 10% discount
		{
			bulk_10_discount = (subTotal * 10)/100;
			//System.out.println("bulk_10_discount" + bulk_10_discount);
		}

		return bulk_10_discount;
	}

	float tiered50Discount(int totalQuantity, int quantityA, int quantityB, int quantityC)
	{	
		float tiered50DiscountA = 0;
		float tiered50DiscountB = 0; 
		float tiered50DiscountC = 0;
		float tiered_50_Discount = 0;

		if(totalQuantity > 30)
		{
			if ((totalAmountOfProductA(quantityA)) > 15) {
				
				tiered50DiscountA = (productA * 15) + (((quantityA - 15) * productA) * 50)/100;
				//System.out.println("tiered50DiscountA " + tiered50DiscountA);
			}
			else
				tiered50DiscountA = 0;

			if ((totalAmountOfProductB(quantityB)) > 15) {
				
				tiered50DiscountB = (productB * 15) + (((quantityB - 15) * productB) * 50)/100;
				//System.out.println("tiered50DiscountA " + tiered50DiscountA);
			}
			else
				tiered50DiscountB = 0;

			if ((totalAmountOfProductC(quantityC)) > 15) {
				
				tiered50DiscountC = (productC * 15) + (((quantityC - 15) * productC) * 50)/100;
				//System.out.println("tiered50DiscountA " + tiered50DiscountA);
			}
			else
				tiered50DiscountC = 0;
		}

		tiered_50_Discount = tiered50DiscountA + tiered50DiscountB + tiered50DiscountC;
		//System.out.println("tiered50Discount " + tiered50Discount);		
		return 0;
	}

	float appliedDiscount(float flat_10_discount, float bulk_5_discount, float bulk_10_discount, float tiered_50_Discount)
	{
    	if(flat_10_discount>bulk_5_discount && flat_10_discount>bulk_10_discount && flat_10_discount>tiered_50_Discount) {
    		System.out.println("Coupon - " + "$10    " + "    -$" + flat_10_discount);
    		return flat_10_discount;
		} else if(bulk_5_discount>flat_10_discount && bulk_5_discount>bulk_10_discount && bulk_5_discount>tiered_50_Discount) {
			System.out.println("Coupon - " + "5%     " + "    -$" + bulk_5_discount);
			return bulk_5_discount;
		} else if(bulk_10_discount>flat_10_discount && bulk_10_discount>bulk_5_discount && bulk_10_discount>tiered_50_Discount) {
			System.out.println("Coupon - " + "10%    " + "    -$" + bulk_10_discount);
			return bulk_10_discount;
		} else {
			System.out.println("Coupon - " + "50%    " + "    -$" + tiered_50_Discount);
			return tiered_50_Discount;
		}
	}

	int purchase(int quantityA, int quantityB, int quantityC, int giftWrapUnits)
	{	
		int totalQuantity;
		int subTotal;
		int giftWrapFees;
		int shippingFees;
		int pkgCount = 0;

		float flat_10_discount;
		float bulk_5_discount;
		float bulk_10_discount;
		float tiered_50_Discount;
		float appliedDiscount;

		float totalBillAmount;

		System.out.println("Product Name      " + "Quantity      " + "Total Amount of Product");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Product A            " + quantityA + "            " + totalAmountOfProductA(quantityA));
		System.out.println("Product B            " + quantityB + "            " + totalAmountOfProductB(quantityB));
		System.out.println("Product C            " + quantityC + "            " + totalAmountOfProductC(quantityC));

		totalQuantity = quantityA + quantityB + quantityC;

		System.out.println("-----------------------------------------------------------");
		System.out.println("Total Quantity       " + totalQuantity);

		subTotal = (quantityA * productA) + (quantityB * productB) + (quantityC * productC);
		System.out.println("Sub Total            $" + subTotal);

		flat_10_discount = flat10Discount(subTotal);

		bulk_5_discount = bulk5Discount(quantityA, quantityB, quantityC);

		bulk_10_discount = bulk10Discount(subTotal, totalQuantity);

		tiered_50_Discount = tiered50Discount(totalQuantity, quantityA, quantityB, quantityC);

		appliedDiscount = appliedDiscount(flat_10_discount, bulk_5_discount, bulk_10_discount, tiered_50_Discount);

		//for calculating shipping amount
		if(totalQuantity > 10)
		{
			while(totalQuantity > 0){
				totalQuantity -= 10;
				pkgCount++;
			}

			shippingFees = (pkgCount * shipping);
		}
		else{

			shippingFees = shipping;
		}
		
		System.out.println("Shipping Fees        $" + shippingFees);

		giftWrapFees = giftWrapUnits * giftWrap; //total fee applied for gift wrapping
		System.out.println("Wrapping Fees        $" + giftWrapFees);

		//Calculating total amount of bill

		totalBillAmount = (subTotal + shippingFees + giftWrapFees) - appliedDiscount;

		System.out.println();
		System.out.println("Total                $" + totalBillAmount);
		return 0;
	}

	public static void main(String[] args) {
		
		ShoppingCart shc = new ShoppingCart();

		Scanner sc = new Scanner(System.in);

		int giftWrapUnits;

		System.out.print("Enter the quantity for Product A : ");
		int quantityA = sc.nextInt();

		System.out.print("Enter the quantity for Product B : ");
		int quantityB = sc.nextInt();

		System.out.print("Enter the quantity for Product C : ");
		int quantityC = sc.nextInt();

		System.out.print("You want to wrap your product as gift or not? (Press Yes or No) ");
		String yesOrNo = sc.next();

		if(yesOrNo.equals("yes") || yesOrNo.equals("Yes"))
		{
			System.out.println("How many units you have to wrap ?");
			giftWrapUnits = sc.nextInt();
		}
		else{

			giftWrapUnits = 0;
		}

		shc.purchase(quantityA, quantityB, quantityC, giftWrapUnits);	

	}

}
