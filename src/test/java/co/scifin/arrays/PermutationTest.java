package co.scifin.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class PermutationTest
{
	@Test
	public void testPermutation()
	{
		var permute = new Permutation();
		var nums = new int[]{0, -1, 1};

		permute.permute(nums).forEach(System.out::println);
	}

	public String getPermutation(int n, int k)
	{
		var p = new Permutation();

		var arr = IntStream.range(1, n + 1).toArray();

		for (int i = 0; i < k - 1; i++)
		{
			p.next(arr);
		}


		var builder = new StringBuilder();
		for (int i = 0; i < arr.length; i++)
		{
			builder.append(arr[i] + "");
		}

		return builder.toString();
	}

	@Test
	public void permutationSequence()
	{
		var n = 3;
		var k = 3;

		Assert.assertEquals("213", getPermutation(n, k));
	}
}
