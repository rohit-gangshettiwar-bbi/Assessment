public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];//Create a 2darray to store wether substring are palindrome
        int start = 0;//starting index of longest palindrome
        int maxLength = 1; //to store length of longest palindrome

        for (int i = 0; i < n; i++) { //Initialie the main diagonal with true values ()
            dp[i][i] = true;
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (length == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                    if (dp[i][j] && length > maxLength) {
                        maxLength = length;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        String longestPalindrome = longestPalindrome(input);
        System.out.println("Longest palindrome: " + longestPalindrome);
    }
}
