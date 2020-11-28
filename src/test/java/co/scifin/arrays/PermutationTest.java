package co.scifin.arrays;

import org.junit.Test;

public class PermutationTest
{
	@Test
	public void testPermutation()
	{
		var permute = new Permutation();
		var nums = new int[]{0, -1, 1};

		permute.permute(nums).forEach(System.out::println);
	}
}
