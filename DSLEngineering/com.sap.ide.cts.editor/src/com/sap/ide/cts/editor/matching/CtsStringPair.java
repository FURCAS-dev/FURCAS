package com.sap.ide.cts.editor.matching;

public class CtsStringPair{
	
	
	private String firstString;
	private String endString;
	public CtsStringPair(String opening, String closing)
	{
		this.firstString=opening;
		this.endString=closing;
						
	}
		
	protected String getClosing(){
		return endString;
	}
	protected String getOpening(){
		return firstString;
	}


}
