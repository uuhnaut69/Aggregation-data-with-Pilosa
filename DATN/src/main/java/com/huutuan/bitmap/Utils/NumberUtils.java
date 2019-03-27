package com.huutuan.bitmap.Utils;

/**
 * @author uuhnaut
 *
 */
public class NumberUtils {
	/**
	 * @param num
	 * @param def
	 * @return
	 */
	public static int nvl(Integer num, int def) {
		if (num == null)
			return def;

		return num;
	}
}
