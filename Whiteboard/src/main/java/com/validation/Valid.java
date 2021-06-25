package com.validation;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Valid {
	
	public static final boolean isNameValid(String name) 
	{
		return Pattern.matches("[\\p{L}A-Za-z-]{2,40}", name.trim());
	}
	
	public static final boolean isPasswordValid(String password) 
	{
		return validation_Password(password);
	}
	
	private static boolean validation_Password(final String password)    {
	  
	    try {
	        if (password!=null) {
	        	
	            final int MIN_LENGTH= 8;
	            final int MAX_LENGTH= 20;
	            final String DIGITS = "[0-9]";
	            final String LETTERS = "[A-Za-z]";
	            final String SPECIALCHARS = "";
	            Pattern digit = Pattern.compile("[0-9]");
	            Matcher m = digit.matcher(password);
   
	            if( password.length() < MIN_LENGTH) 
	            	return false;
	            if( password.length() > MAX_LENGTH)
	            	return false;
	            if( !m.find() );
	            	return false;
	            	
	        }    

	    } catch (Exception ex) {
	        return false;
	    }
	    return true;
	}        
	
}
