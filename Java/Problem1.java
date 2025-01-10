import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        List<List<Integer>> profitsTable = new ArrayList<>();
        List<Integer> profits = new ArrayList<>();

        // Get all the possible profits
        for (int buyDay = 0; buyDay < prices.length - 1; buyDay++) {
            for (int sellDay = buyDay + 1; sellDay < prices.length; sellDay++) {
                int profit = prices[sellDay] - prices[buyDay];
                profit = Math.max(profit, 0); // Ensure profit is non-negative
                profits.add(profit);
            }
            profitsTable.add(new ArrayList<>(profits));

            if (buyDay != prices.length) {
                profits.clear();
            }
        }

        List<Integer> combinations = new ArrayList<>();
        combinations.add(0);
        if (profitsTable.size() == 1) {
            combinations.add(profitsTable.get(0).get(0));
        }

        // Get the highest combination of two sums
        int nextIndex = 0;
        for (int i = 0; i < profitsTable.size(); i++) {
            nextIndex = i + 1;

            for (int profit1 : profitsTable.get(i)) {
                for (int j = nextIndex; j < profitsTable.size(); j++) {
                    for (int profit2 : profitsTable.get(j)) {
                        combinations.add(profit1 + profit2);
                    }
                }

                if (nextIndex == profitsTable.size()) {
                    break;
                }
                nextIndex++;
            }
        }

        int maxProfit = 0;
        for (int combination : combinations) {
            maxProfit = Math.max(maxProfit, combination);
        }

        return maxProfit;
    }
}