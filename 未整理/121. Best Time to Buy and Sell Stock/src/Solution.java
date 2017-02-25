public class Solution {
    public int maxProfit(int[] prices) {
    	if(prices.length==0)return 0;
    	int minNum = prices[0];
    	int maxProfit = 0;
    	for(int price:prices){
    		if(price<minNum) minNum = price;
    		if(price-minNum>maxProfit) maxProfit = price-minNum;
    	}
        return maxProfit;
    }
}