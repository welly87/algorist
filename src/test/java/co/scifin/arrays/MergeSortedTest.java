package co.scifin.arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedTest
{
	public void merge(int[] nums1, int p1, int[] nums2, int p2)
	{
		int p = p1 + p2 - 1;

		p1--;
		p2--;

		while (p2 >= 0 && p1 >= 0)
		{
			if (nums2[p2] > nums1[p1])
			{
				nums1[p--] = nums2[p2--];
			}
			else
			{
				nums1[p--] = nums1[p1--];
			}
		}

		System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	}

	@Test
	public void testMerge()
	{
		var target = new int[]{1, 2, 3, 0, 0, 0};
		merge(target, 3, new int[]{2, 5, 6}, 3);

		Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, target);
	}

	@Test
	public void testMerge2()
	{
		var target = new int[]{1, 2, 3, 0, 0, 0};
		merge(target, 3, new int[]{1, 5, 6}, 3);

		Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 5, 6}, target);
	}
}

