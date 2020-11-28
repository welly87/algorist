package co.scifin.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation
{
	public List<List<Integer>> permute(int[] nums)
	{
		var perm = new Permutation();

		Arrays.sort(nums);

		List<List<Integer>> results = new ArrayList<>();

		do
		{
			var ar = new ArrayList<Integer>();

			for (var n : nums)
			{
				ar.add(n);
			}

			results.add(ar);
		}
		while (perm.next(nums));

		return results;
	}

	public boolean next(int[] a)
	{
		int n = a.length;
		int i, j, k, temp;
		i = n - 2;

		while (i >= 0 && a[i] >= a[i + 1]) --i;

		if (i < 0)
		{
			for (j = 0, k = n - 1; j < k; j++, k--)
			{
				temp = a[j];
				a[j] = a[k];
				a[k] = temp;
			}

			return false;
		}

		j = n - 1;

		while (a[i] >= a[j]) --j;

		temp = a[i];
		a[i] = a[j];
		a[j] = temp;

		for (j = i + 1, k = n - 1; j < k; j++, k--)
		{
			temp = a[j];
			a[j] = a[k];
			a[k] = temp;
		}

		return true;
	}
}
