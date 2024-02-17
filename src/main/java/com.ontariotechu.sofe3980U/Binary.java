package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary {
	private String number = "0"; // string containing the binary value '0' or '1'

	/**
	 * A constructor that generates a binary object.
	 *
	 * @param number a String of the binary values. It should contain only zeros or ones with any length and order. Otherwise, the value of "0" will be stored. Trailing zeros will be excluded and an empty string will be considered as zero.
	 */
	public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0')
				break;
		}
		//beg has the index of the first non-zero digit in the number
		this.number = number.substring(beg); // exclude the leading zeros if any

		if (this.number.equals("")) { // replace empty strings with a single zero
			this.number = "0";
		}

	}

	/**
	 * Return the binary value of the variable
	 *
	 * @return the binary value in a string format.
	 */
	public String getValue() {
		return this.number;
	}

	/**
	 * Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	 *
	 * @param num1 The first addend object
	 * @param num2 The second addend object
	 * @return A binary variable with a value of <i>num1+num2</i>.
	 */
	public static Binary add(Binary num1, Binary num2) {
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		int carry = 0;
		StringBuilder num3 = new StringBuilder(); // the binary value of the sum
		while (ind1 >= 0 || ind2 >= 0 || carry != 0) { // loop until all digits are processed
			int sum = carry; // previous carry
			if (ind1 >= 0) { // if num1 has a digit to add
				sum += num1.number.charAt(ind1) == '1' ? 1 : 0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if (ind2 >= 0) { // if num2 has a digit to add
				sum += num2.number.charAt(ind2) == '1' ? 1 : 0; // convert the digit to int and add it to sum
				ind2--; // update ind2
			}
			carry = sum / 2; // the new carry
			sum = sum % 2; // the resultant digit
			num3.insert(0, sum); // prepend the sum to num3
		}
		return new Binary(num3.toString()); // create a binary object with the calculated value.
	}

	/**
	 * Does a logical OR operation on two binary variables
	 *
	 * @param num1 the first operand
	 * @param num2 the second operand
	 * @return A binary variable with a value of <i>num1||num2</i>
	 */
	public static Binary or(Binary num1, Binary num2) {
		int i1 = num1.number.length() - 1;
		int i2 = num2.number.length() - 1;
		StringBuilder val_final = new StringBuilder(); // Variable initialization
		while (i1 >= 0 || i2 >= 0) {
			char bit1 = i1 >= 0 ? num1.number.charAt(i1) : '0';
			char bit2 = i2 >= 0 ? num2.number.charAt(i2) : '0';
			val_final.insert(0, (bit1 == '1' || bit2 == '1') ? "1" : "0"); // if either bit is 1, result is 1
			i1--;
			i2--;
		}
		return new Binary(val_final.toString()); // obj with final value
	}

	/**
	 * Does a logical AND operation on two binary variables
	 *
	 * @param num1 the first operand
	 * @param num2 the second operand
	 * @return a binary variable with a value of <i>num1 & num2</i>
	 */
	public static Binary and(Binary num1, Binary num2) {
		int i1 = num1.number.length() - 1;
		int i2 = num2.number.length() - 1;
		StringBuilder final_val = new StringBuilder(); // Variable initialization
		while (i1 >= 0 || i2 >= 0) {
			char bit1 = i1 >= 0 ? num1.number.charAt(i1) : '0';
			char bit2 = i2 >= 0 ? num2.number.charAt(i2) : '0';
			final_val.insert(0, (bit1 == '1' && bit2 == '1') ? "1" : "0"); // if both bits are 1, result is 1
			i1--;
			i2--;
		}
		return new Binary(final_val.toString()); // binary obj with final value
	}

	/**
	 * Multiplies two binary variables
	 *
	 * @param num1 the first operand
	 * @param num2 the second operand
	 * @return A binary variable with a value of <i>num1xnum2</i>
	 */
	public static Binary multiply(Binary num1, Binary num2) {
		int x = Integer.parseInt(num1.number, 2); // Converting to decimal
		int y = Integer.parseInt(num2.number, 2); // Performing multiplication
		int result = x * y;
		return new Binary(Integer.toBinaryString(result)); // binary obj with final value
	}
}
