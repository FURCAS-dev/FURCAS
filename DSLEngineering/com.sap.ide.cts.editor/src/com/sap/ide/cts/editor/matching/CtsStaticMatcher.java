package com.sap.ide.cts.editor.matching;

import java.util.ArrayList;
import java.util.Stack;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

public class CtsStaticMatcher  {
	
	public static char[] MATCHING_BRACKETS= { '{', '}', '(', ')', '[', ']' /*, '<','>' */};
	private String AUTOINDENT_START_CHAR= "{";
	private  String AUTOINDENT_END_CHAR= "}";
	
	private ArrayList<CtsStringPair> pairs= new ArrayList<CtsStringPair>();
	
	public void setAutoIndentChars(String AUTOINDENT_START_CHAR,String AUTOINDENT_END_CHAR){
		this.AUTOINDENT_START_CHAR= AUTOINDENT_START_CHAR;
		this.AUTOINDENT_END_CHAR= AUTOINDENT_END_CHAR;
	}
	public CtsStaticMatcher(){
		
		pairs.add(new CtsStringPair("(",")"));
		pairs.add(new CtsStringPair("[","]"));
		// pairs.add(new CtsStringPair("<",">")); // for "less" this is really inconvenient...
		pairs.add(new CtsStringPair("\"","\""));
	}

		
	
	public String getClosingText(String openingText) {
		for (int i=0;i<pairs.size();i++){
			CtsStringPair p=pairs.get(i);
			if (openingText.equals(p.getOpening()))
				return p.getClosing();
			
		}
		return null;
	}

	
	public boolean isOpeningText(String text) {
		
		for (int i=0;i<pairs.size();i++){
			CtsStringPair p=pairs.get(i);
			if (text.equals(p.getOpening()))
				return true;
			
		}
		return false;
	}
	
	public boolean isClosingText(String text) {
		for (int i=0;i<pairs.size();i++){
			CtsStringPair p=pairs.get(i);
			if (text.equals(p.getClosing()))
				return true;
			
		}
		return false;
	}
	public boolean areBracesMatching(IDocument d) throws BadLocationException {
		
		Stack<String> stack= new Stack<String>();
		
		int counter=0;
		
		
		while (counter < d.getLength()) {
			String c=""+ d.getChar(counter);
			
			if(c.equals(AUTOINDENT_START_CHAR )){
				stack.push(AUTOINDENT_START_CHAR);
				
			}
			else{
				
				if (c.equals(AUTOINDENT_END_CHAR )){
					
					if (stack.size()==0)return true;
					stack.pop();
				}
					
			}
		counter++;
		
		}
				
		if(stack.size()>0)return false;
		else return true;
		
	}
	public boolean isIndentingChar(String c) {
		return AUTOINDENT_START_CHAR.equals(c) ; 
	}



	public String getClosingBrace() {
		
		return AUTOINDENT_END_CHAR;
	}
	


}
