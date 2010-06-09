package com.sap.ide.cts.dialogs;

public enum PrettyPrintingModes
{
	CONSERVATIVE("conservative"), 
	PROGRESSIVE("progressive");
	
	private final String value;
	
	private PrettyPrintingModes(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return this.value;
	}
}
