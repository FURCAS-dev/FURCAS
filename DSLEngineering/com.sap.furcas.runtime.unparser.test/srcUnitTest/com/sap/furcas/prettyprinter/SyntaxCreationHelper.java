/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.prettyprinter;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

/**
 * @author Stephan Erb
 *
 */
public class SyntaxCreationHelper {
    
    public static LiteralRef createKeyword(String keyword) {
        LiteralRef litRef1 = TCSFactory.eINSTANCE.createLiteralRef();
        Keyword lit1 = TCSFactory.eINSTANCE.createKeyword();
        litRef1.setReferredLiteral(lit1);
        lit1.setValue(keyword);
        return litRef1;
    }
    
    public static Property createProperty(EStructuralFeature feature) {
        PropertyReference propertyRef = TCSFactory.eINSTANCE.createPropertyReference();
        propertyRef.setStrucfeature(feature);
        Property property = TCSFactory.eINSTANCE.createProperty();
        property.setPropertyReference(propertyRef);
        return property;
    }
    
    public static Sequence createSequence(SequenceElement... elements) {
        Sequence sequence = TCSFactory.eINSTANCE.createSequence();
        for (SequenceElement se : elements) {
            sequence.getElements().add(se);
        }
        return sequence;
    }
}
