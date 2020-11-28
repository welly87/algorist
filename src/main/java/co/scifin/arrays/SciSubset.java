package co.scifin.arrays;

import java.util.ArrayList;
import java.util.List;

public class SciSubset
{
	public List<List<Integer>> generate(int[] nums)
	{
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < (1 << nums.length); i++)
		{
			var subset = new ArrayList<Integer>();

			for (int k = 0; k < nums.length; k++)
			{
				if ((i & (1 << k)) > 0)
				{
					subset.add(nums[k]);
				}
			}

			list.add(subset);
		}

		return list;
	}
}
