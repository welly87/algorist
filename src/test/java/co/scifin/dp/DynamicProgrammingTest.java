package co.scifin.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DynamicProgrammingTest
{


	public boolean divisorGame(int N)
	{
		return recurse(N, true);
	}

	private boolean recurse(int n, boolean alice)
	{
		if (n <= 1)
		{
			return !alice;
		}

		for (int i = 1; i < n; i++)
		{
			if (n % i == 0)
				return recurse(n - i, !alice);
		}

		return false;
	}

	@Test
	public void testDivisorGame()
	{
		Assert.assertTrue(divisorGame(2));
		Assert.assertFalse(divisorGame(3));
	}

	private int[] memo;
	private int[] cost;

	private int climb(int stair)
	{
		if (stair == this.cost.length - 1) return this.cost[stair];

		if (stair >= this.cost.length) return 0;

		if (memo[stair] == -1)
		{
			var first = climb(stair + 1);

			var second = climb(stair + 2);

			memo[stair] = cost[stair] + Math.min(first, second);
		}

		return memo[stair];
	}

	public int minCostClimbingStairs(int[] cost)
	{
		this.cost = cost;
		this.memo = new int[1005];

		Arrays.fill(this.memo, -1);

		return Math.min(climb(0), climb(1));
	}

	@Test
	public void testMinCostStairs()
	{
		Assert.assertEquals(15, minCostClimbingStairs(new int[]{10, 15, 20}));
	}

	private int[] memoz = null;

	public int climbStairs(int n)
	{
		this.memoz = new int[n + 3];

		Arrays.fill(memoz, -1);

		return climbing(n);
	}

	private int climbing(int n)
	{
		if (n < 0) return 0;

		if (n == 0) return 1;

		if (this.memoz[n] == -1)
		{
			this.memoz[n] = climbing(n - 1) + climbing(n - 2);
		}

		return memoz[n];
	}

	@Test
	public void testClimbing()
	{
		Assert.assertEquals(2, climbStairs(2));
		Assert.assertEquals(3, climbStairs(3));
	}

	private int[] coins;
	private int[] memox;

	public int coinChange(int[] coins, int amount)
	{
		this.coins = coins;
		this.memox = new int[10004];
		
		Arrays.fill(this.memox, -1);
		
		var result = coin(amount);

		return result < 0 || result == Integer.MAX_VALUE ? -1 : result;
	}

	private int coin(int amount)
	{
		if (amount == 0) return 0;

		if (amount < 0) return -1;

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < this.coins.length; i++)
		{
			if (amount >= this.coins[i])
			{
				var remaining = amount - this.coins[i];

				if (this.memox[remaining] == -1)
				{
					this.memox[remaining] = 1 + coin(remaining);
				}

				min = Math.min(min, this.memox[remaining]);
			}
		}

		return min;
	}

	@Test
	public void testCoinChange()
	{
		Assert.assertEquals(3, coinChange(new int[] { 1, 2, 5 }, 11));
	}
}
