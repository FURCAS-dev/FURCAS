package com.sap.ide.cts.editor.matching;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jface.text.IDocument;
/** 
 * <p>This class is responsible for Dynamic Matching, which is needed for AutoEditing (AutoIndentLine).
 * <p>For a given line, it finds the last opening XML Tag, produces the closing XML Tag according to the matching Tags in the whole document.    
 * <p>All the functions in this class can be extended by using the Interface {@linkplain ICtsDynamicMatcher} through the extension point.  
 * 
 * @author Armagan Kilic
 */

public class CtsDynamicMatcher {
	
	private String closingTag="";
	private boolean isXMLMatchingActive=true;
	private String closingXMLTagPrefix="</";
	private String openingTagExpression="<[^\\s|^<|^>|^/]+>";
		
		
	/**
	 * 
	 * @param openingTagExpression
	 * @param closingTag
	 */
	public CtsDynamicMatcher(String openingTagExpression,String closingTag){
		isXMLMatchingActive=false;
		this.openingTagExpression=openingTagExpression;
		this.closingTag=closingTag;
		
	}
	public CtsDynamicMatcher(){
		//default for xml matching
		
	}
	public String getClosingTag(String tag) {
		
		if(isXMLMatchingActive==true)
			return closingXMLTagPrefix+tag.substring(1);
		else
			return closingTag;		
	}
	public void setClosingTag(String tag){
		closingTag=tag;		
	}
	public void setOpeningTagExpression(String exp){
		openingTagExpression=exp;
	}
	/**
	 * 
	 * @param line
	 * @return
	 */
	public boolean isTagValid(String line){
			
	      Pattern pOpening = Pattern.compile(openingTagExpression);
	      Matcher mOpening = pOpening.matcher(line);
	      if (mOpening.find())return true;
	      else return false;
	}
	/**
	 * 
	 * @param line the line that has a valid Tag.
	 * @return returns the last valid Tag at the given line.
	 */
	public String getLastOpeningTag(String line){
	      Pattern pOpening = Pattern.compile(openingTagExpression);
	      Matcher mOpening = pOpening.matcher(line);
	      String a="";
	      while(mOpening.find())
	    	  a=mOpening.group();
	      return a;
	    
	}
	/**
	 * 
	 * @param d the document that will be changed
	 * @param tag
	 * @return
	 */
	public boolean areTagsMatching(IDocument d,String tag){
			Stack<String> stack= new Stack<String>();
		String fullText=d.get();
		Pattern pTag = Pattern.compile(tag+"|"+getClosingTag(tag));
		Matcher mTag = pTag.matcher(fullText);
		String t="";
		while(mTag.find()){
			
			t=mTag.group();
			if(t.equals(tag))
				stack.push(t);
				else{
				
				if (t.equals(getClosingTag(tag)))
						if (stack.size()==0)return true;
						stack.pop();
				}
					
				
	    }
		if(stack.size()>0)return false;
		else return true;
				
	}
	public String setIndentLine() {
		return "\t\t";
	}
}

