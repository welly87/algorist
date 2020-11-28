package co.scifin.arrays;

import org.junit.Assert;
import org.junit.Test;

public class StockTest
{
	public int maxProfit(int[] prices)
	{
		var low = Integer.MAX_VALUE;
		var maxima = 0;

		for (int i = 0; i < prices.length; i++)
		{
			if (low > prices[i])
			{
				low = prices[i];
			}
			else
			{
				maxima = Math.max(maxima, prices[i] - low);
			}
		}

		return maxima;
	}

	@Test
	public void testBuySell()
	{
		Assert.assertEquals(2, maxProfit(new int[]{2, 4, 1}));
		Assert.assertEquals(4, maxProfit(new int[]{3, 2, 6, 5, 0, 3}));

		Assert.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
	}
}
