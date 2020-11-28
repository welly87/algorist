package co.scifin.arrays;

import org.junit.Assert;
import org.junit.Test;

public class UniqueCharacterTest
{
	@Test
	public void testUniqueChars()
	{
		var unique = new UniqueCharacter();
		Assert.assertTrue(unique.isUniqueChars("asdfg"));
		Assert.assertFalse(unique.isUniqueChars("asdfag"));
	}
}
