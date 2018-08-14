package com.amarpushp.project.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class EmailValidationUtil {

	private static Pattern pattern;
	private static Matcher matcher;

	private EmailValidationUtil() {

	}

	public static boolean validate(String regexPattern, String value) {
		pattern = Pattern.compile(regexPattern);
		matcher = pattern.matcher(value);
		return matcher.matches();
	}

	public static boolean validate(String regexPattern, List<String> values) {
		pattern = Pattern.compile(regexPattern);
		if(StringUtils.isNotEmpty(regexPattern) && values != null && values.size() > 0) {
		for(String value : values) {
			matcher = pattern.matcher(value);
			if (!matcher.matches()) {
				return false;
			}
		}
		}
		return true;
	}
}
