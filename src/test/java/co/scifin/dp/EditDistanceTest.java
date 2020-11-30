package co.scifin.dp;

import org.junit.Assert;
import org.junit.Test;

public class EditDistanceTest
{
	public boolean isSubsequence(String s, String t)
	{
		if (s.isEmpty()) return true;

		if (t.equals("")) return false;

		if (s.charAt(0) == t.charAt(0)) return isSubsequence(s.substring(1), t.substring(1));

		return isSubsequence(s, t.substring(1));
	}

	@Test
	public void testSubs()
	{
		Assert.assertTrue(isSubsequence("abc", "ahbgdc"));
		Assert.assertFalse(isSubsequence("axc", "ahbgdc"));
	}

	private int[] nums = null;

	public int maxSubArray(int[] nums)
	{
		this.nums = nums;
		return maxsum(0, this.nums.length - 1);
	}

	private int maxsum(int start, int end)
	{
		if (start > end) return 0;

		if (start == end) return this.nums[start];

		int max = 0;

		for (int i = start; i <= end; i++)
		{
			max += this.nums[i];
		}

		for (int i = start; i < end; i++)
		{
			var part1 = maxsum(start, i);
			var part2 = maxsum(i + 1, end);
			max = Math.max(max, Math.max(part1, part2));
		}

		return max;
	}

	@Test
	public void testMaxSub()
	{
		Assert.assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		Assert.assertEquals(3, maxSubArray(new int[]{1, 2}));
	}

	class NumArray
	{
		private int[] nums;
		private int[] prefix;

		public NumArray(int[] nums)
		{
			this.nums = nums;
			this.prefix = new int[nums.length];

			if (nums.length == 0) return;

			this.prefix[0] = this.nums[0];

			for (int i = 1; i < nums.length; i++)
			{
				this.prefix[i] = this.prefix[i - 1] + this.nums[i];
			}
		}

		public int sumRange(int i, int j)
		{
			if (i == 0) return this.prefix[j];

			return this.prefix[j] - this.prefix[i - 1];
		}
	}

	@Test
	public void testRangeSum()
	{
		var nm = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
		Assert.assertEquals(1, nm.sumRange(0, 2));
		Assert.assertEquals(-1, nm.sumRange(2, 5));
		Assert.assertEquals(-3, nm.sumRange(0, 5));
	}

	private int[] numx = null;

	public int rob(int[] nums)
	{
		this.numx = nums;
		return this.robit(0);
	}

	private int robit(int idx)
	{
		if (idx >= numx.length) return 0;

		var take = this.numx[idx] + robit(idx + 2);

		var dont = robit(idx + 1);

		return Math.max(take, dont);
	}

	@Test
	public void testHouseRobber()
	{
		Assert.assertEquals(4, rob(new int[]{1, 2, 3, 1}));
		Assert.assertEquals(12, rob(new int[]{2, 7, 9, 3, 1}));
	}

	public int numWays(int n, int k)
	{
		if (n == 1) return k;

		if (n == 2) return k * k;

		if (n < 0) return 0;

		return numWays(n - 1, k) * (k - 1) + numWays(n - 2, k) * (k - 1);
	}

	@Test
	public void testNumWays()
	{
		Assert.assertEquals(6, numWays(3, 2));
	}

	private char[] vow = {'a', 'e', 'i', 'o', 'u'};

	public int countVowelStrings(int n)
	{
		return count(n, 0);
	}

	private int count(int x, int idx)
	{
		if (x == 0) return 1;

		int cnt = 0;

		for (int i = idx; i < 5; i++)
		{
			cnt += count(x - 1, i);
		}

		return cnt;
	}

	@Test
	public void testCountVowel()
	{
		Assert.assertEquals(5, countVowelStrings(1));
		Assert.assertEquals(15, countVowelStrings(2));
		Assert.assertEquals(66045, countVowelStrings(33));
	}
}
