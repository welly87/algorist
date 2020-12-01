package co.scifin.arrays;

import org.junit.Assert;
import org.junit.Test;

public class DeletingArrayTest
{
	public int removeElement(int[] nums, int val)
	{
		int start = 0;
		int end = nums.length - 1;
		int length = nums.length;

		while (start <= end)
		{
			if (nums[start] == val)
			{
				nums[start] = nums[end];
				end--;
				length--;
			}
			else
			{
				start++;
			}
		}

		return length;
	}

	public int removeElement2(int[] nums, int val)
	{
		int length = nums.length;

		for (int i = 0; i < length; i++)
		{
			if (nums[i] == val)
			{
				for (int j = i; j < length - 1; j++)
				{
					nums[j] = nums[j + 1];
				}

				i--;
				length--;
			}
		}

		return length;
	}

	@Test
	public void testRemove()
	{
		var nums = new int[]{3, 2, 2, 3};

		Assert.assertEquals(2, removeElement(nums, 3));
//		Assert.assertArrayEquals(new int[] { 2, 2, 0, 0}, nums);

		Assert.assertEquals(5, removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

		Assert.assertEquals(0, removeElement(new int[]{1}, 1));
	}

	public int removeDuplicates(int[] nums)
	{
		int length = nums.length;
		int slow = 1;

		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i - 1] != nums[i])
			{
				nums[slow] = nums[i];
				slow++;
			}
			else
			{
				length--;
			}
		}

		return length;
	}

	@Test
	public void testDuplicate()
	{
		var nums = new int[]{1, 1, 2};

		Assert.assertEquals(2, removeDuplicates(nums));

		var result = new int[]{1, 2};

		for (int i = 0; i < result.length; i++)
		{
			Assert.assertEquals(nums[i], result[i]);
		}

		nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

		Assert.assertEquals(5, removeDuplicates(nums));

		result = new int[]{0, 1, 2, 3, 4};

		for (int i = 0; i < result.length; i++)
		{
			Assert.assertEquals(nums[i], result[i]);
		}
	}
}
