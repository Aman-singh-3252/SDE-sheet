class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {

        int n = arr.length;

        long totalSum = 0;
        for (int it : arr)
            totalSum += it;

        long sumN = (long)n * (n + 1) / 2;

        long xMinusY = totalSum - sumN;

        long sumSquares = 0;
        for (int it : arr)
            sumSquares += (long)it * it;

        long expectedSquares = (long)n * (n + 1) * (2L * n + 1) / 6;

        long xSquareMinusYSquare = sumSquares - expectedSquares;

        long xPlusY = xSquareMinusYSquare / xMinusY;

        long x = (xPlusY + xMinusY) / 2;
        long y = xPlusY - x;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int)x);
        ans.add((int)y);

        return ans;
    }
}
