package io.pointgenesis.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Convenience class to provide string padding capabilities.
 * @author travis.steinmetz
 *
 */
public class Pad {
	private static final Logger log = LogManager.getLogger();
	
	/**
	 * Hidden to prevent instantiation.
	 */
	private Pad() {
	}

	/**
	 * Given an unformatted {@code value}, then format by left padding the string, {@code value}, using spaces as the padding character, for
	 * an overall length of {@code length} bytes.
	 * 
	 * @param value the given string.
	 * @param length the overall length of the new string.
	 * @return the formatted string.
	 */
	public static final String left(String value, int length) {
		return pad("%1$", value, ' ', length);
	}
	
	/**
	 * Given an unformatted {@code value}, then format by left padding the string, {@code value}, with character, {@code c}, for
	 * an overall length of {@code length} bytes.
	 * 
	 * @param value the given string.
	 * @param c the character to pad to the string.
	 * @param length the overall length of the new string.
	 * @return the formatted string.
	 */
	public static final String left(String value, char c, int length) {
		return pad("%1$", value, c, length);
	}

	/**
	 * Given an unformatted {@code value}, then format by right padding the string, {@code value}, using spaces as the padding character, for
	 * an overall length of {@code length} bytes.
	 * 
	 * @param value the given string.
	 * @param length the overall length of the new string.
	 * @return the formatted string.
	 */
	public static final String right(String value, int length) {
		return pad("%1$-", value, ' ', length);
	}
	
	/**
	 * Given an unformatted {@code value}, then format by right padding the string, {@code value}, with character, {@code c}, for
	 * an overall length of {@code length} bytes.
	 * 
	 * @param value the given string.
	 * @param c the character to pad to the string.
	 * @param length the overall length of the new string.
	 * @return the formatted string.
	 */
	public static final String right(String value, char c, int length) {
		return pad("%1$-", value, c, length);
	}
	
	/**
	 * Given an unformatted {@code value}, then format according to the given {@code pattern}, {@code value}, character {@code c}, for
	 * an overall length of {@code length} bytes.
	 * 
	 * @param value the given string.
	 * @param c the character to pad to the string.
	 * @param length the overall length of the new string.
	 * @return the formatted string.
	 */	
	private static final String pad(String pattern, String value, char c, int length) {
		if (log.isDebugEnabled()) {
			log.debug("pattern: {} | value: {} | c: {} | length: {}", pattern, value, c, length);
		}
		
		if (length < 0) {
			if (log.isWarnEnabled()) {
				log.warn("length must be greater than 0 -> length: {}", length);
			}
			throw new IllegalArgumentException("length must be greater than 0");
		}
		
		return String.format(pattern + length + "s", value).replace(' ', c);
	}
}