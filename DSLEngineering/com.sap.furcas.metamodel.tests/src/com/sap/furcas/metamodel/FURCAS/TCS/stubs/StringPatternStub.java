/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.StringPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class StringPatternStub extends SimplePatternStub implements StringPattern {
    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getStringPattern();
    }

}
