package com.jlabs.web.utils;

public class StringUtils {

	public static String capitalize(String text) {
		
		StringBuilder builder = new StringBuilder(text.length());
		builder
			.append( Character.toUpperCase( text.charAt(0) ) )
			.append( text.substring( 1 ).toLowerCase() );

		return builder.toString();
	}
	
	public static String kebabToCapitalizeCamelCase(String text) {
		StringBuilder builder = new StringBuilder(text.length());
		String[] split = text.split("-");
		
		for(int i=0; i<split.length; i++) {
			builder.append( capitalize( split[i] ));
		}
		
		return builder.toString();
	}
}
