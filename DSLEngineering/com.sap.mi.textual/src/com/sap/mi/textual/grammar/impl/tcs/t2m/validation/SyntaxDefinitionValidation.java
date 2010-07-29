/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl.tcs.t2m.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.mi.textual.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.SemanticErrorBucket;


/**
 * The Class SyntaxDefinitionValidation.
 */
public class SyntaxDefinitionValidation {

	/** The rules. */
	private List<ISyntaxValidationRule> rules = new ArrayList<ISyntaxValidationRule>();
	
	/**
	 * Instantiates a new syntax definition validation.
	 */
	public SyntaxDefinitionValidation() {
		rules.add(new TemplateNameValidation());
		rules.add(new MainTemplateValidation());
		rules.add(new OperatorListValidation());
		rules.add(new TemplateAbstractWithSequenceValidation());
	}


    /**
     * @param syntax
     * @param metaLookup
     * @param errorBucket 
     */
    public void validateSyntax(ConcreteSyntax syntax,
            IMetaModelLookup<?> metaLookup, SemanticErrorBucket errorBucket) {
        for (Iterator<ISyntaxValidationRule> iterator = rules.iterator(); iterator.hasNext();) {
            ISyntaxValidationRule rule = iterator.next();
           
            rule.validate(syntax, metaLookup, errorBucket);
           
        }
        
    }
	
}
