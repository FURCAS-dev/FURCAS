package com.sap.mi.fwk.util;

/**
 * Several utility methods for string manipulation.
 * 
 * @author D041623
 */
public final class StringUtil {

	/**
	 * Escape characters for text appearing in HTML markup.
	 * 
	 * @param string
	 * @return HTML escaped string
	 */
	public static String escapeForHTML(String string) {

		StringBuffer sb = new StringBuffer(string.length());
		int len = string.length();
		char c;

		for (int i = 0; i < len; i++) {

			c = string.charAt(i);

			if (c == '"') {
				sb.append("&quot;"); //$NON-NLS-1$
			} else if (c == '&') {
				sb.append("&amp;"); //$NON-NLS-1$
			} else if (c == '<') {
				sb.append("&lt;"); //$NON-NLS-1$
			} else if (c == '>') {
				sb.append("&gt;"); //$NON-NLS-1$
			} else if (c == '\n') {
				// Handle Newline
				sb.append("&lt;br/&gt;"); //$NON-NLS-1$
			} else {
				if (c > 0x7F) {
					// Not 7 Bit use the unicode system
					sb.append("&#"); //$NON-NLS-1$
					sb.append(Integer.toString(c, 10));
					sb.append(';');
				} else {
					// nothing special only 7 Bit
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

	private StringUtil() {
	}

}
