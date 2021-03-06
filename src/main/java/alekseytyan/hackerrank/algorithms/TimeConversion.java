package alekseytyan.hackerrank.algorithms;

import java.util.Formatter;

/**
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 *
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 *
 * Example
 *
 *
 * Return '12:01:00'.
 *
 *
 * Return '00:01:00'.
 *
 * Function Description
 *
 * Complete the timeConversion function in the editor below.
 * It should return a new string representing the input time in 24 hour format.
 *
 * timeConversion has the following parameter(s):
 *
 * string s: a time in  hour format
 * Returns
 *
 * string: the time in  hour format
 * Input Format
 *
 * A single string  that represents a time in -hour clock format (i.e.:  or ).
 *
 * Constraints
 *
 * All input times are valid
 * Sample Input 0
 *
 * 07:05:45PM
 * Sample Output 0
 *
 * 19:05:45
 */

// Сделано очень криво
public class TimeConversion {
    public static String timeConversion(String s) {
        if(s.endsWith("AM")) {
            if(s.startsWith("12")) {
                return s.replaceFirst("12","00").substring(0,s.length()-2);
            } else {
                return s.substring(0, s.length()-2);
            }
        }
        else if(s.endsWith("PM")) {
            if (s.startsWith("12")) return s.substring(0, s.length() - 2);
            else {
                int hour = Integer.parseInt(s.substring(0, 2));
                hour = (hour + 12) % 24;
                return new Formatter()
                        .format("%2s", ("00" + hour).substring(String.valueOf(hour).length()))
                        .toString() + s.substring(2, s.length() - 2);
            }
        }
        throw new IllegalArgumentException();
    }
}
