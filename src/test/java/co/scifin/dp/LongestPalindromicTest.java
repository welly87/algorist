package co.scifin.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicTest
{
	private String res = "";

	public String longestPalindrome(String s)
	{
		this.res = s;
//		return pal(0, s.length() - 1);
		return null;
	}

//	private String pal(int start, int end, int size, String result)
//	{
//		if (start > end) return result;
//
//		if (start == end) return result;
//
//		if (res.charAt(start) == res.charAt(end))
//		{
//			var r = pal(start + 1, end - 1, size + 2, res.charAt(start) + result + res.charAt(start));
//
//			return Math.max(r.length(), Math.max(pal(start+1, end, 0, "").length(), pal(start, end -1, 0, "").length());
//		}
//
//
//
//		return Math.max(pal(start+1, end, 0, "").length(), pal(start, end -1, 0, "").length());
//	}

	@Test
	public void testLongsPalin()
	{

		Assert.assertEquals("aca", longestPalindrome("aacabdkacaa"));
		Assert.assertEquals("bab", longestPalindrome("babad"));
		Assert.assertEquals("bb", longestPalindrome("cbbd"));
		Assert.assertEquals("a", longestPalindrome("a"));
		Assert.assertEquals("a", longestPalindrome("ac"));
	}



}
