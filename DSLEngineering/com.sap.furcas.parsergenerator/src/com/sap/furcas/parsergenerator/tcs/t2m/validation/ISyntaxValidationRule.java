/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.validation;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.SemanticErrorBucket;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;



/**
 * The Interface ISyntaxValidationRule.
 */
public interface ISyntaxValidationRule {

	/**
	 * Validate.
	 * 
	 * @param syntax the syntax
	 * @param metaLookup 
	 * @param errorBucket 
	 * 
	 * @throws SyntaxDefValidationException the syntax def validation exception
	 */
	void validate(ConcreteSyntax syntax, IMetaModelLookup<?> metaLookup, SemanticErrorBucket errorBucket);
	
}
