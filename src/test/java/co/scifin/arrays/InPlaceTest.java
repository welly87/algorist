package co.scifin.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

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

	public int heightChecker(int[] heights)
	{
		var copy = Arrays.copyOf(heights, heights.length);
		Arrays.sort(copy);

		var move = 0;

		for (int i = 0; i < heights.length; i++)
		{
			if (heights[i] != copy[i]) move++;
		}
		return move;
	}

	@Test
	public void testHeight()
	{
		Assert.assertEquals(3, heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
		Assert.assertEquals(5, heightChecker(new int[]{5, 1, 2, 3, 4}));
		Assert.assertEquals(0, heightChecker(new int[]{1, 2, 3, 4, 5}));
	}

	public List<Integer> findDisappearedNumbers(int[] nums)
	{
		var set = new HashSet<Integer>();

		IntStream.range(1, nums.length + 1).forEach(x -> set.add(x));

		for (var n : nums)
		{
			set.remove(n);
		}

		return new ArrayList<>(set);
	}

	@Test
	public void testDissapear()
	{
		var result = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).toArray();

		int i = 0;

		for (var n : new int[]{5, 6})
		{
			Assert.assertEquals(result[i++], n);
		}
	}

	public int thirdMax(int[] nums)
	{
		Arrays.sort(nums);

		var set = new TreeSet<Integer>();

		for (var n : nums)
		{
			set.add(n);
		}

		var unique = set.toArray();

		if (unique.length < 3) return (int) unique[unique.length - 1];

		return (int) unique[unique.length - 3];
	}

	@Test
	public void test3rd()
	{
		Assert.assertEquals(1, thirdMax(new int[]{3, 2, 1}));
		Assert.assertEquals(2, thirdMax(new int[]{1, 2}));
		Assert.assertEquals(1, thirdMax(new int[]{2, 2, 3, 1}));

		Assert.assertEquals(5, thirdMax(new int[]{1, 2, 3, 4, 5, 6, 7}));
	}

	public int findMaxConsecutiveOnes(int[] nums)
	{
		var flipCount = 0;
		var noFlipCount = 0;
		var maxSoFar = 0;

		for (var n : nums)
		{
			if (n == 1)
			{
				noFlipCount++;
				flipCount++;
			}
			else // if n == 0
			{
				if (flipCount > noFlipCount) // already flipped
				{
					flipCount = noFlipCount + 1;
				}
				else
				{
					flipCount++;
				}

				noFlipCount = 0;
			}

			maxSoFar = Math.max(maxSoFar, flipCount);
		}

		return maxSoFar;
	}

	@Test
	public void testMaxCon()
	{
		Assert.assertEquals(4, findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));

		Assert.assertEquals(4, findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
	}

	public int[] plusOne(int[] digits)
	{
		var carry = 0;

		for (int i = digits.length - 1; i >= 0; i--)
		{
			var res = digits[i];

			if (digits.length - 1 == i)
			{
				res += 1;
			}
			else
			{
				res = digits[i] + carry;
			}

			if (res >= 10)
			{
				res %= 10;
				digits[i] = res;
				carry = 1;
			}
			else
			{
				carry = 0;
				digits[i] = res;
			}
		}

		if (carry == 1)
		{
			var newArr = new int[digits.length + 1];
			newArr[0] = 1;

			for (int i = 1; i <= digits.length; i++)
			{
				newArr[i] = digits[i - 1];
			}

			return newArr;
		}

		return digits;
	}

	@Test
	public void testPlusOne()
	{
		Assert.assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
		Assert.assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
	}
}
