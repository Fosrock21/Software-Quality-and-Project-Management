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
	 * @param number a String of the binary values. It should contain only zeros or
	 *               ones with any length and order. otherwise, the value of "0"
	 *               will be stored. Trailing zeros will be excluded and empty
	 *               string will be considered as zero.
	 */
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}

		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}

		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}

		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);

		if (this.number.isEmpty()) { // replace empty strings with a single zero
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
	 * Adding two binary variables. For more information, visit
	 * <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers
	 * </a>.
	 *
	 * @param num1 The first addend object
	 * @param num2 The second addend object
	 * @return A binary variable with a value of <i>num1+num2</i>.
	 */
	public static Binary add(Binary num1, Binary num2) {
		// the index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		// initial variable
		int carry = 0;
		String num3 = ""; // the binary value of the sum
		while (ind1 >= 0 || ind2 >= 0 || carry != 0) // loop until all digits are processed
		{
			int sum = carry; // previous carry
			if (ind1 >= 0) { // if num1 has a digit to add
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int
				ind1--; // update ind1
			}
			if (ind2 >= 0) { // if num2 has a digit to add
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // convert the digit to int
				ind2--; // update ind2
			}
			carry = sum / 2; // the new carry
			sum = sum % 2; // the resultant digit
			num3 = ((sum == 0) ? "0" : "1") + num3; // prepend the sum bit
		}
		return new Binary(num3);
	}

	/**
	 * Bitwise OR operation between two binary variables.
	 *
	 * @param num1 The first binary operand
	 * @param num2 The second binary operand
	 * @return A new Binary object representing (num1 OR num2).
	 */
	public static Binary or(Binary num1, Binary num2) {
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		StringBuilder result = new StringBuilder();

		// Process both strings from right to left
		while (ind1 >= 0 || ind2 >= 0) {
			char bit1 = (ind1 >= 0) ? num1.number.charAt(ind1) : '0';
			char bit2 = (ind2 >= 0) ? num2.number.charAt(ind2) : '0';

			// OR logic: '1' if either bit is '1'
			char orBit = (bit1 == '1' || bit2 == '1') ? '1' : '0';
			result.insert(0, orBit);

			ind1--;
			ind2--;
		}
		return new Binary(result.toString());
	}

	/**
	 * Bitwise AND operation between two binary variables.
	 *
	 * @param num1 The first binary operand
	 * @param num2 The second binary operand
	 * @return A new Binary object representing (num1 AND num2).
	 */
	public static Binary and(Binary num1, Binary num2) {
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		StringBuilder result = new StringBuilder();

		// Process both strings from right to left
		while (ind1 >= 0 || ind2 >= 0) {
			char bit1 = (ind1 >= 0) ? num1.number.charAt(ind1) : '0';
			char bit2 = (ind2 >= 0) ? num2.number.charAt(ind2) : '0';

			// AND logic: '1' if both bits are '1'
			char andBit = (bit1 == '1' && bit2 == '1') ? '1' : '0';
			result.insert(0, andBit);

			ind1--;
			ind2--;
		}
		return new Binary(result.toString());
	}

	/**
	 * Multiply two binary variables.
	 * You may use the add function to handle partial sums.
	 *
	 * @param num1 The first binary operand
	 * @param num2 The second binary operand
	 * @return A new Binary object representing (num1 * num2).
	 */
	public static Binary multiply(Binary num1, Binary num2) {
		// If either number is "0", return "0"
		if (num1.getValue().equals("0") || num2.getValue().equals("0")) {
			return new Binary("0");
		}

		Binary result = new Binary("0");
		String b2 = num2.getValue();

		// We'll iterate through each bit of num2 from right to left
		for (int i = 0; i < b2.length(); i++) {
			// Check the bit from the right side
			int bitIndex = b2.length() - 1 - i;
			if (b2.charAt(bitIndex) == '1') {
				// Shift num1 left i times (equivalent to multiplying by 2^i)
				String shifted = num1.getValue() + "0".repeat(i);
				// Add to result
				result = add(result, new Binary(shifted));
			}
		}
		return result;
	}
}
