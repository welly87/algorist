package co.scifin.arrays;

import org.junit.Assert;
import org.junit.Test;

public class InPlaceTest
{
	public int[] replaceElements(int[] arr)
	{
		var max = arr[arr.length - 1];

		for (int i = arr.length - 2; i >= 0; i--)
		{
			if (max > arr[i])
			{
				arr[i] = max;
			}
			else
			{
				max = arr[i];
			}
		}

		for (int i = 0; i < arr.length - 1; i++)
		{
			arr[i] = arr[i + 1];
		}

		arr[arr.length - 1] = -1;

		return arr;
	}

	@Test
	public void testReplace()
	{
		Assert.assertArrayEquals(new int[]{18, 6, 6, 6, 1, -1}, replaceElements(new int[]{17, 18, 5, 4, 6, 1}));
	}

	public void moveZeroes(int[] nums)
	{
		var write = 0;

		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != 0)
			{
				nums[write] = nums[i];
				write++;
			}
		}

		for (int i = write; i < nums.length; i++)
		{
			nums[i] = 0;
		}
	}

	@Test
	public void testMove()
	{
		var input = new int[]{0, 1, 0, 3, 12};
		moveZeroes(input);
		Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, input);
	}

	public int[] sortArrayByParity(int[] A)
	{
		int start = 0;
		int end = A.length - 1;

		while (start < end)
		{
			if (A[start] % 2 != 0 && A[end] % 2 == 0)
			{
				var temp = A[start];
				A[start] = A[end];
				A[end] = temp;
				start++;
				end--;
			}
			else
			{
				if (A[start] % 2 == 0)
				{
					start++;
				}

				if (A[end] % 2 != 0)
				{
					end--;
				}
			}
		}

		return A;
	}

	@Test
	public void testParity()
	{
		var input = new int[]{3, 1, 2, 4};
		Assert.assertArrayEquals(new int[]{4, 2, 1, 3}, sortArrayByParity(input));
	}
}
