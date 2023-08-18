import java.util.Scanner;

public class SmallerNumbersCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int input = scanner.nextInt();

        int[] nums = new int[input];
        System.out.println("Enter the elements:");
        for (int i = 0; i < input; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] result = smallerNumbersThanCurrent(nums);

        System.out.println("Counts of smaller numbers for each element:");
        for (int count : result) {
            System.out.print(count + " ");
        }
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
