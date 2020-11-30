package co.scifin.dp;

import org.junit.Assert;
import org.junit.Test;

public class UglyNumberTest
{
	public int nthUglyNumber(int n)
	{
		int cnt = 1;

		var ugly = new int[n];

		ugly[0] = 1;

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		while (cnt < n)
		{
			int can2 = ugly[i2] * 2;
			int can3 = ugly[i3] * 3;
			int can5 = ugly[i5] * 5;

			int min = Math.min(can2, Math.min(can3, can5));

			if (min == can2)
			{
				i2++;
			}
			else if (min == can3)
			{
				i3++;
			}
			else if (min == can5)
			{
				i5++;
			}

			if (min != ugly[cnt - 1])
			{
				ugly[cnt] = min;
				cnt++;
			}
		}

		return ugly[cnt - 1];
	}

	@Test
	public void testUgly2()
	{
		Assert.assertEquals(12, nthUglyNumber(10));
		Assert.assertEquals(15, nthUglyNumber(11));
	}

	public int nthUglyNumber(int n, int a, int b, int c)
	{
		int cnt = 1;

		var ugly = new int[n + 1];

		ugly[0] = 1;

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		while (cnt <= n)
		{
			int can2 = ugly[i2] * a;
			int can3 = ugly[i3] * b;
			int can5 = ugly[i5] * c;

			int min = Math.min(can2, Math.min(can3, can5));

			if (min == can2)
			{
				i2++;
			}
			else if (min == can3)
			{
				i3++;
			}
			else if (min == can5)
			{
				i5++;
			}

			if (min != ugly[cnt - 1])
			{
				ugly[cnt] = min;
				cnt++;
			}
		}

		return ugly[cnt - 1];
	}

	@Test
	public void testUgly3()
	{
		Assert.assertEquals(4, nthUglyNumber(3, 2, 3, 5));
		Assert.assertEquals(6, nthUglyNumber(4, 2, 3, 4));
		Assert.assertEquals(10, nthUglyNumber(5, 2, 11, 13));
	}
}
