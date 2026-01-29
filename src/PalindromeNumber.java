package src;

class PalindromeNumber {

    public boolean isPalindrome(int x) {

        // weed out negatives or numbers ending in 0 that arent 0, e.g. 10, 100, 250
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        // now we can check the two cases: even len number (6776) or odd len number (67876)
        int reversedHalf = 0;

        while (x > reversedHalf) {

            // reversedHalf * 10 -> add another slot to reversedHalf
            // x % 10 -> pop the rightmost digit off of x and add it
            reversedHalf = reversedHalf * 10 + x % 10;

            // remove that popped digit from x
            x /= 10;
        }

        // even len: 6776 -> x = 67, reversedHalf = 67
        // odd len: 67876 -> x = 67, reversedHalf = 678 (drop middle digit)
        return (x == reversedHalf || x == reversedHalf / 10);
    }

    private static void runTest(int x, PalindromeNumber solver) {

        System.out.println("Input: " + x);
        System.out.println("Output: " + solver.isPalindrome(x));
        System.out.println();

    }

    public static void main(String[] args) {

        PalindromeNumber solver = new PalindromeNumber();

        runTest(121, solver);
        runTest(-121, solver);
        runTest(10, solver);
        runTest(1221, solver);
        runTest(12, solver);
        runTest(0, solver);

    }
    
}
