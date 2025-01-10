from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 1:
            return 0

        profits = []
        profits_table = []

        # Get all the possible profits
        for buy_day in range(0, len(prices) - 1):
            for sell_day in range(buy_day + 1, len(prices)):
                profit = prices[sell_day] - prices[buy_day]
                if profit < 0:
                    profit = 0
                profits.append(profit)
            
            profits_table.append(profits.copy())
            
            if buy_day != len(prices):
                profits.clear()

        combinations = [0]
        if len(profits_table) == 1:
            combinations.append(profits_table[0][0])

        # Get the highest combination of two sums
        next_index = 0
        for i in range(0, len(profits_table)):
            next_index = i + 1

            for profit1 in profits_table[i]:
                for j in range(next_index, len(profits_table)):
                    for profit2 in profits_table[j]:
                        combination = profit1 + profit2
                        combinations.append(combination)

                if next_index == len(profits_table):
                    break
                next_index += 1

        return max(combinations) if max(combinations) > 0 else 0
