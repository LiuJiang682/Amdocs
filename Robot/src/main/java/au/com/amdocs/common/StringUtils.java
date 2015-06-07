package au.com.amdocs.common;



public class StringUtils {
	
	public static boolean isNullOrEmpty(final String string) {
		return (string == null)||(string.length() == CommonConstants.ZERO);
	}
}
