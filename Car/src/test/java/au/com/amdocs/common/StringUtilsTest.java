package au.com.amdocs.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.common.StringUtils;

public class StringUtilsTest {

	@Test
	public void testIsNullOrEmpty() {
		assertTrue(StringUtils.isNullOrEmpty(null));
		assertTrue(StringUtils.isNullOrEmpty(""));
		assertFalse(StringUtils.isNullOrEmpty("abc"));
	}
	
	@Test
	public void testIsNullOrEmptyArray() {
		assertTrue(StringUtils.isNullOrEmptyArray(null));
		String[] testArrayEmpty = {};
		assertTrue(StringUtils.isNullOrEmptyArray(testArrayEmpty));
		String[] testArray = {"abc"};
		assertFalse(StringUtils.isNullOrEmptyArray(testArray));
	}
}
