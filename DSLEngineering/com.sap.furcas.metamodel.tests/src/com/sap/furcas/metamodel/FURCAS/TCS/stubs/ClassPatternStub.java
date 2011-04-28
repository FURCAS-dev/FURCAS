/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class ClassPatternStub extends SimplePatternStub implements ClassPattern {
    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getClassPattern();
    }

}
