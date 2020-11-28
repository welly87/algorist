package co.scifin.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class PalindromTest
{
	public boolean canPermutePalindrome(String s)
	{
		var memo = new HashMap<>();

		for (int i = 0; i < s.length(); i++)
		{
			var c = s.charAt(i);

			if (memo.containsKey(c))
			{
				memo.remove(c);
			}
			else
			{
				memo.put(c, "");
			}
		}

		return memo.size() <= 1;
	}

	@Test
	public void testPalindromPerm()
	{
		Assert.assertFalse(canPermutePalindrome("code"));
		Assert.assertTrue(canPermutePalindrome("aab"));
		Assert.assertTrue(canPermutePalindrome("carerac"));
	}

	public boolean isAnagram(String s, String t)
	{
		var a = s.toCharArray();
		Arrays.sort(a);

		var b = t.toCharArray();
		Arrays.sort(b);

		return Arrays.equals(a, b);
	}

	@Test
	public void testAnagram()
	{
		Assert.assertTrue(isAnagram("anagram", "nagaram"));
		Assert.assertFalse(isAnagram("rat", "car"));
	}
}
