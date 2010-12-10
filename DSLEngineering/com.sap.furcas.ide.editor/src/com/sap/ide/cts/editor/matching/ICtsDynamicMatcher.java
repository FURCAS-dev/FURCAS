package com.sap.ide.cts.editor.matching;

import org.eclipse.jface.text.IDocument;

public interface ICtsDynamicMatcher {

	/**
	 * sets the closing Tag for the given Opening Tag Expression 
	 * @param tag
	 */
	public void setClosingTag(String tag);
	
	/**
	 *  sets the regular expression of the indenting tag.
	 * @param exp
	 */
	public void setOpeningTagExpression(String exp);
	
	/**
	 * returns the Closing Tag
	 * @param tag
	 * @return
	 */
	public String getClosingTag(String tag);
	
	/**
	 * finds whether the last tag of the line matches with openingExpression 
	 * @param line
	 * @return
	 */
	public boolean isTagValid(String line);
	
	/**
	 * returns the Indenting Tag
	 * @param line
	 * @return
	 */
	public String getLastOpeningTag(String line);
	
	/**
	 * calculates whether the closing and opening tags are matching
	 * @param d
	 * @param tag
	 * @return
	 */
	public boolean areTagsMatching(IDocument d,String tag);
	/**
	 * @return returns the Indenting 
	 */
	public String setIndentLine();
		
}
