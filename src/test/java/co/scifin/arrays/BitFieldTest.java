package co.scifin.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;

/**
 * Bitfields as Set tools with O(1)
 * https://apps.topcoder.com/forums/?module=Thread&threadID=671561&start=0
 */
public class BitFieldTest
{
	public int missingNumber(int[] nums)
	{
		var set = 0;

		for (int i = 0; i < nums.length; i++)
		{
			set |= 1 << nums[i];
		}

		for (int i = 0; i < nums.length + 1; i++)
		{
			if ((set & (1 << i)) == 0) return i;
		}

		return -1;
	}

	@Test
	public void testMissingNumber()
	{
		Assert.assertEquals(2, missingNumber(new int[]{3, 0, 1}));
		Assert.assertEquals(2, missingNumber(new int[]{0, 1}));
		Assert.assertEquals(8, missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
		Assert.assertEquals(33, missingNumber(new int[]{44, 26, 34, 25, 23, 42, 0, 43, 38, 14, 47, 19, 49, 6, 16, 41, 24, 35, 10, 4, 32, 5, 8, 15, 31, 3, 46, 22, 2, 30, 28, 37, 1, 21, 39, 45, 9, 48, 36, 17, 7, 27, 18, 29, 13, 40, 11, 20, 12}));
	}

	public int findDuplicate(int[] nums)
	{
		var set = new BitSet();

		for (int i = 0; i < nums.length; i++)
		{
			if (set.get(nums[i]))
			{
				return nums[i];
			}
			else
			{
				set.set(nums[i]);
			}
		}

		return -1;
	}

	@Test
	public void testFindDuplicate()
	{
		Assert.assertEquals(2, findDuplicate(new int[]{1, 3, 4, 2, 2}));
		Assert.assertEquals(3, findDuplicate(new int[]{3, 1, 3, 4, 2}));
		Assert.assertEquals(1, findDuplicate(new int[]{1, 1}));
		Assert.assertEquals(13, findDuplicate(new int[]{13, 46, 8, 11, 20, 17, 40, 13}));
	}

	public int firstMissingPositive(int[] nums)
	{
		var bit = new BitSet();
		var max = 1;

		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] <= 0) continue;

			bit.set(nums[i]);

			max = Math.max(max, nums[i]);
		}

		for (int i = 1; i <= max + 1; i++)
		{
			if (bit.get(i)) continue;

			return i;
		}

		return 0;
	}

	@Test
	public void testFirstMissing()
	{
		Assert.assertEquals(3, firstMissingPositive(new int[]{1, 2, 0}));
		Assert.assertEquals(2, firstMissingPositive(new int[]{3, 4, -1, 1}));
		Assert.assertEquals(1, firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
	}
}
