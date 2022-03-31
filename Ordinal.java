package connect4;

/**
 * This class serves as a utility class containing only static methods about
 * ordinal numbers.
 * 
 * @author Matt
 * @version 1.0
 * @since 1.8
 * 
 */
public class Ordinal {

	/**
	 * Returns the ordinal value of the specified integer value.
	 * 
	 * @param integer
	 *            A cardinal integer value.
	 * @return The ordinal value of the cardinal integer value.
	 */
	public static String getOrdinal(int integer) {
		int modValue = integer % 10;
		if (modValue == 1) {
			return integer + "st";
		} else if (modValue == 2) {
			return integer + "nd";
		} else if (modValue == 3) {
			return integer + "rd";
		} else {
			return integer + "th";
		}
	}

}
