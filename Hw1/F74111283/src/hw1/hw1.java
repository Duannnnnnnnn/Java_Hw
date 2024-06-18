package hw1;
import java.math.BigDecimal;
import java.util.Scanner;
public class hw1 {
	public static String add(String num1, String num2) {
        BigDecimal bd1 = new BigDecimal(num1);
        BigDecimal bd2 = new BigDecimal(num2);
        BigDecimal sum = bd1.add(bd2);
        return sum.toString();
    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] nums = line.split(" ");
		System.out.println(add(nums[0],nums[1]));
		scanner.close();
	}
}
