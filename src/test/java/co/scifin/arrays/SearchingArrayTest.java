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
}
