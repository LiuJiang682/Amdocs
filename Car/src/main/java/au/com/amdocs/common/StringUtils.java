package au.com.amdocs.common;

public class StringUtils {
	
	public static boolean isNullOrEmpty(final String string) {
		return (string == null)||(string.length() == CommonConstants.ZERO);
	}
	
	public static boolean isNullOrEmptyArray(final String[] strings) {
		return ((strings == null) || (strings.length == CommonConstants.ZERO));
	}
}
