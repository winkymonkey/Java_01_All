package com.example.java.i_immutable;

import java.util.Date;
import java.util.HashMap;


/**
 * Always remember that your instance variables will be either mutable or immutable.
 * Identify the mutable objects and return new objects with content copied in it.
 * Immutable variables can be returned safely without extra effort.
 */
@SuppressWarnings("unchecked")
public final class ImmutableClass {

	private final Integer immutableField1;			//Integer class is immutable (doesn't provide setter to change its content)
	private final String immutableField2;			//String class is immutable (doesn't provide setter to change its content)
	private final Date mutableField;				//Date class is mutable (provides setter to change various date/time parts)
	private final HashMap<String,String> mutableMap;//HashMap class is mutable (provides setter to change its content)
	
	
	//Constructor performing Deep Copy
	public ImmutableClass(Integer fld1, String fld2, Date date, HashMap<String,String> map) {
		this.immutableField1 = fld1;
		this.immutableField2 = fld2;
		this.mutableField = new Date(date.getTime());
		
		HashMap<String,String> newMap = new HashMap<String,String>();
		map.forEach((key,val)->newMap.put(key, val));
		this.mutableMap = newMap;
	}

	//NO SETTER METHOD
	
	//Integer class is immutable. So we can safely return the instance variable
	public Integer getImmutableField1() {
		return immutableField1;
	}
	//String class is immutable. So we can safely return the instance variable
	public String getImmutableField2() {
		return immutableField2;
	}

	
	//Date class is mutable so we should not return the reference of instance variable
	//Instead a cloned copy of the field should be returned
	public Date getMutableField() {
		return new Date(mutableField.getTime());
	}
	
	//HashMap class is mutable so we should not return the reference of instance variable
	//Instead a cloned copy of the field should be returned
	public HashMap<String, String> getMutableMap() {
		return (HashMap<String, String>)mutableMap.clone();
	}
	
}

