package de.hpi.sam.bp2009.testframework.operator;

import java.util.ArrayList;

import de.hpi.sam.bp2009.testframework.OptionObject;


public class OclOptions extends OptionObject {
	ArrayList<String> oclConstraints= new ArrayList<String>();
	
	public static OptionObject defaultValue(){
		OclOptions def = new OclOptions();
		def.oclConstraints.add("context Class0: self.attribute0 < 10");
		return def;
	}
}
