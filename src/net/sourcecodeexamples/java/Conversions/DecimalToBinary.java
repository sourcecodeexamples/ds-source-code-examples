package net.sourcecodeexamples.java.Conversions;

import java.util.Scanner;

/**
 * This class converts a Decimal number to a Binary number
 * 
 * @author https://www.sourcecodeexamples.net
 *
 */
class DecimalToBinary {

    /**
     * Main Method
     *
     * @param args Command Line Arguments
     */
    public static void main(String args[]) {
        bitwiseConversion();
    }

    /**
     * This method converts a decimal number
     * to a binary number using a bitwise
     * algorithm
     */
    public static void bitwiseConversion() {
        int n, b = 0, c = 0, d;
        Scanner input = new Scanner(System.in);
        System.out.printf("Bitwise conversion.%n Enter the decimal number: ");
        n = input.nextInt();
        while (n != 0) {
            d = (n & 1);
            b += d * (int) Math.pow(10, c++);
            n >>= 1;
        }
        System.out.println("\tBinary number: " + b);
        input.close();
    }

}
