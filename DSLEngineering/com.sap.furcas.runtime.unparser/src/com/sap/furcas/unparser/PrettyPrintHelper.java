/*******************************************************************************
 * Copyright (c) 2007-2011 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *     SAP AG - API and implementation enhancements
 ******************************************************************************/
package com.sap.furcas.unparser;

import static com.sap.furcas.unparser.PrettyPrintConstants.TYPE_SYMBOL;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.runtime.common.util.EcoreHelper;

public class PrettyPrintHelper {

    public static boolean isSymbol(int type, int test) {
	test += TYPE_SYMBOL;
	return (type & test) == test;
    }

    public static boolean isInstanceOf(EObject element, List<String> type) {
	EClass m = element.eClass();

	List<EClassifier> typesToCheck = new ArrayList<EClassifier>(m.getEAllSuperTypes());
	// also add element type itself
	typesToCheck.add(m);

	for (EClassifier g : typesToCheck) {
	    List<String> qName = EcoreHelper.getQualifiedName(g);
	    // maybe type is not fully qualified, compare each part
	    if (isTypeMatch(qName, type)) {
		return true;
	    }
	}
	return false;
    }

    /**
     * compares the types from the end backwards (in case the
     * partiallyQulifiedTypeName is not fully qualified)
     * 
     * Example: ConcreteSyntax instead of TCS::ConcreteSyntax
     * 
     * @param fullyQualifiedTypeName
     * @param partiallyQualifiedTypeName
     * 
     * @return
     */
    public static boolean isTypeMatch(List<String> fullyQualifiedTypeName, List<String> partiallyQualifiedTypeName) {
	boolean allPartsMatch = true;
	if (fullyQualifiedTypeName.size() >= partiallyQualifiedTypeName.size()) {
	    for (int i = 1; i <= partiallyQualifiedTypeName.size(); i++) {
		if (!fullyQualifiedTypeName.get(fullyQualifiedTypeName.size() - i).equals(
			partiallyQualifiedTypeName.get(partiallyQualifiedTypeName.size() - i))) {
		    allPartsMatch = false;
		}
	    }
	}
	return allPartsMatch;
    }
    
}
