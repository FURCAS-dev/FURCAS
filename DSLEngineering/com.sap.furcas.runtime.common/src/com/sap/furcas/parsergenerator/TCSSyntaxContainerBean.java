/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.parser.TextLocation;

/**
 * Data Object to transport a syntax definition and the keywords used in that
 * syntax.
 * 
 * @author C5107456
 */
public class TCSSyntaxContainerBean {

	/** The keywords. */
	private Set<Keyword> keywords;

	/** The syntax. */
	private ConcreteSyntax syntax;

	/** The imported syntaxes */
	private Collection<ConcreteSyntax> importedConcreteSyntaxes;

	/** The imported templates */
	private Collection<Template> importedTemplates;

	private Map<Object, TextLocation> elementToLocationMap;

	/**
	 * Gets the keywords.
	 * 
	 * @return the keywords
	 */
	public Set<Keyword> getKeywords() {
		return keywords;
	}

	/**
	 * Sets the keywords.
	 * 
	 * @param keywords
	 *            the new keywords
	 */
	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * Gets the syntax.
	 * 
	 * @return the syntax
	 */
	public ConcreteSyntax getSyntax() {
		return syntax;
	}

	/**
	 * Sets the syntax.
	 * 
	 * @param syntax
	 *            the new syntax
	 */
	public void setSyntax(ConcreteSyntax syntax) {
		this.syntax = syntax;
	}

	/**
	 * Gets the imported syntaxes.
	 * 
	 * @return the list of imported syntaxes
	 */
	public Collection<ConcreteSyntax> getImportedConcreteSyntaxes() {
		return importedConcreteSyntaxes;
	}

	/**
	 * Sets the imported syntaxes.
	 * 
	 * @param List
	 *            of imported syntaxes
	 */
	public void setImportedConcreteSyntaxes(
			ArrayList<ConcreteSyntax> importedConcreteSyntaxes) {
		this.importedConcreteSyntaxes = importedConcreteSyntaxes;
	}

	/**
	 * Gets the imported templates.
	 * 
	 * @return the list of imported templates
	 */
	public Collection<Template> getImportedTemplates() {
		return importedTemplates;
	}

	/**
	 * Sets the imported templates.
	 * 
	 * @param List
	 *            of imported templates.
	 */
	public void setImportedTemplates(Collection<Template> importedTemplates2) {
		this.importedTemplates = importedTemplates2;
	}

	public Map<Object, TextLocation> getElementToLocationMap() {
		return elementToLocationMap;
	}

	public void setElementToLocationMap(
			Map<Object, TextLocation> elementToLocationMap) {
		this.elementToLocationMap = elementToLocationMap;
	}

}
