package co.scifin.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class SearchingArrayTest
{
	public boolean checkIfExist(int[] arr)
	{
		var hashSet = new HashSet<>();

		for (var a : arr)
		{
			var twice = a * 2;

			if (hashSet.contains(twice) || a % 2 == 0 && hashSet.contains(a / 2))
				return true;
			else
				hashSet.add(a);
		}

		return false;
	}

	@Test
	public void testExist()
	{
		Assert.assertTrue(checkIfExist(new int[]{10, 2, 5, 3}));
	}

	public boolean validMountainArray(int[] arr)
	{
		boolean goUp = true;

		if (arr.length == 1) return false;

		if (arr[0] >= arr[1]) return false;

		boolean valley = false;

		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] == arr[i - 1]) return false;

			if (goUp)
			{
				if (arr[i] < arr[i - 1])
				{
					goUp = false;
					i--;
				}
			}
			else // go down
			{
				if (arr[i] > arr[i - 1])
					return false;
				else
					valley = true;
			}
		}

		return !goUp && valley;
	}

	@Test
	public void testMountain()
	{
		Assert.assertTrue(validMountainArray(new int[]{1, 3, 2}));

		Assert.assertFalse(validMountainArray(new int[]{3, 5, 5}));
		Assert.assertTrue(validMountainArray(new int[]{0, 2, 3, 4, 5, 2, 1, 0}));
		Assert.assertFalse(validMountainArray(new int[]{0, 2, 3, 3, 5, 2, 1, 0}));
		Assert.assertFalse(validMountainArray(new int[]{2, 1}));
		Assert.assertFalse(validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
	}
}
