package co.scifin.arrays;

/**
 * Set operation with bitfields
 * https://apps.topcoder.com/forums/?module=Thread&threadID=671561&start=0
 *
 */
public class UniqueCharacter
{
	public boolean isUniqueChars(String str)
	{
		var checker = 0;
		for (int i = 0; i < str.length(); i++)
		{
			var val = str.charAt(i) - 'a';

			// check if val exists in checker
			if ((checker & (1 << val)) > 0)
			{
				return false;
			}

			// add x in a set
			checker |= (1 << val);
		}

		return true;
	}
}
