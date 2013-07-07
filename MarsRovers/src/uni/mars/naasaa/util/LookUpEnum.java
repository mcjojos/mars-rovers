package uni.mars.naasaa.util;

import java.util.logging.Logger;

/**
 * Utility class whose purpose it to offer a way to look up enums, without
 * throwing {@link RuntimeException} in case no corresponding Enum value exist.
 * 
 * @author karanikasg
 * 
 */
public class LookUpEnum {
	/**
	 * Returns the {@link Enum} constant of the specified enumType with the
	 * specified name. The difference with the standard
	 * Enum.valueOf(java.lang.Class, java.lang.String) is that it will return
	 * null instead of throwing an {@link IllegalArgumentException} if the
	 * specified enum type has no constant with the specified name, or the
	 * specified class object does not represent an enum type. In that case it
	 * will log an info message.
	 * 
	 * @param enumType
	 * @param id
	 * @return the Enum constant
	 */
	public static <E extends Enum<E>> E lookup(Class<E> enumType, String name) {
		E result = null;
		try {
			result = Enum.valueOf(enumType, name);
		} catch (IllegalArgumentException e) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(
					"Invalid value for enum " + enumType.getSimpleName() + ": "
							+ name + ", skipping it");
		}

		return result;
	}
}
