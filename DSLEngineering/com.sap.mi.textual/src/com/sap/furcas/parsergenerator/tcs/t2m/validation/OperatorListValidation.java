/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-07-18 14:17:12 +0200 (Fr, 18 Jul 2008) $
 * @version $Revision: 1250 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.validation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.OperatorList;
import com.sap.furcas.metamodel.TCS.Priority;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.SemanticErrorBucket;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;



/**
 * The Class UniquenessValidation.
 */
public class OperatorListValidation implements ISyntaxValidationRule {

	/* (non-Javadoc)
	 * @see com.sap.mi.textual.grammar.impl.tcs.t2m.validation.ISyntaxValidationRule#validate(TCS.ConcreteSyntax)
	 */
    public void validate(ConcreteSyntax syntax, IMetaModelLookup<?> metaLookup, SemanticErrorBucket errorBucket) {
        // check priorities includes zero, no gaps, no doubles
        List<OperatorList> opLists = syntax.getOperatorLists();
        
        Set<String> foundNames = new HashSet<String>();
        boolean anonymousListFound = false;
        
        for (Iterator<OperatorList> iterator = opLists.iterator(); iterator.hasNext();) {
            OperatorList operatorList = iterator.next();
            String name = operatorList.getName();
            if (name != null) {
            if (foundNames.contains(name)) {
                errorBucket.addError("Duplicate operatorList name '" + name + "'", operatorList);
            } else {
                foundNames.add(name);
            }
            } else { // name == null
                if (anonymousListFound == true) {
                    errorBucket.addError("Duplicate anonymous operator list", operatorList);
                } else {
                    anonymousListFound = true;
                }
            }
            
            List<Priority> prios = operatorList.getPriorities();
            if (prios != null ) {
                boolean[] covered = new boolean[prios.size()];
                boolean problemFound = false;
                for (Iterator<Priority> iterator2 = prios.iterator(); iterator2.hasNext();) {
                    Priority priority = iterator2.next();

                    try {
                        if (covered[priority.getValue()]) {
                            problemFound = true;
                            errorBucket.addError("Duplicate priority index " + priority.getValue(), priority);
                        } else {
                            covered[priority.getValue()] = true;
                        }
                    } catch(ArrayIndexOutOfBoundsException aioobe) {
                        if (priority.getValue() < 0) {
                            problemFound = true;
                            errorBucket.addError("Negative priority index " + priority.getValue(), priority);
                        } else {
                            // ignore, better to give error message about missing numbers later
                        }
                    }

                } // end for priorities

                // check for missing numbers, which would happen for indexes "0, 1, 2, 4, 5" missing 3. 
                if (! problemFound) { // previous errors also cause gaps, ignore gap message if already errors have been found
                    for (int i = 0; i < covered.length; i++) {
                        boolean indexCovered = covered[i];
                        if (! indexCovered) {
                            errorBucket.addError("Missing priority with index " + i, operatorList);
                        }
                    }
                }
                
            } // end if prios != null
        } // end for operatorLists
	}


}
