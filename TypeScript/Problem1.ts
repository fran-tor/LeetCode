function maxProfit(prices: number[]): number {
    if (prices.length === 1) {
        return 0;
    }

    const profits: number[][] = [];
    const profits_table: number[][] = [];

    // Get all the possible profits
    for (let buy_day = 0; buy_day < prices.length - 1; buy_day++) {
        const inner_profits: number[] = [];
        for (let sell_day = buy_day + 1; sell_day < prices.length; sell_day++) {
            let profit = prices[sell_day] - prices[buy_day];
            if (profit < 0) {
                profit = 0;
            }
            inner_profits.push(profit);
        }
        profits_table.push([...inner_profits]); 
    }

    const combinations: number[] = [0];
    if (profits_table.length === 1) {
        combinations.push(profits_table[0][0]);
    }

    // Get the highest combination of two sums
    for (let i = 0; i < profits_table.length; i++) {
        let next_index = i + 1;

        for (const profit1 of profits_table[i]) {
            for (let j = next_index; j < profits_table.length; j++) {
                for (const profit2 of profits_table[j]) {
                    const combination = profit1 + profit2;
                    combinations.push(combination);
                }
            }
            if (next_index === profits_table.length) {
                break;
            }
            next_index += 1;
        }
    }

    return Math.max(...combinations) > 0 ? Math.max(...combinations) : 0;
};
