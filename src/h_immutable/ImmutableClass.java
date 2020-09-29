package h_immutable;


import java.util.Date;

/**
 * Always remember that your instance variables will be either mutable or immutable.
 * Identify them and return new objects with copied content for all mutable objects.
 * Immutable variables can be returned safely without extra effort.
 */
public final class ImmutableClass {

	private final Integer immutableField1;		//Integer class is immutable (does not provide setter to change its content)
	private final String immutableField2;		//String class is immutable (does not provide setter to change its content)
	private final Date mutableField;			//Date class is mutable (provides setter to change various date/time parts)
	
	
	//Private constructor ensures no unplanned construction of class
	ImmutableClass(Integer fld1, String fld2, Date date) {
		this.immutableField1 = fld1;
		this.immutableField2 = fld2;
		this.mutableField = new Date(date.getTime());
	}

	//NO SETTER METHOD
	
	//Integer class is immutable so we can return the instance variable as it is
	public Integer getImmutableField1() {
		return immutableField1;
	}
	//String class is immutable so we can return the instance variable as it is
	public String getImmutableField2() {
		return immutableField2;
	}

	/**
	 * Date class is mutable so we need a little care here. We should not return the reference of original instance variable.
	 * Instead a new Date object, with content copied to it, should be returned.
	 */
	public Date getMutableField() {
		return new Date(mutableField.getTime());
	}
}

