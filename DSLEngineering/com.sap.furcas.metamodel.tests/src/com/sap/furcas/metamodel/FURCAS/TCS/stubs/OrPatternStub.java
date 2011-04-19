/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.OrPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.SimplePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class OrPatternStub extends LocatedElementStub implements OrPattern {
    
    public EList<SimplePattern> simplePatterns;

    /* (non-Javadoc)
     * @see tcs.OrPattern#getSimplePatterns()
     */
    @Override
    public EList<SimplePattern> getSimplePatterns() {
        return simplePatterns;
    }
    
    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getOrPattern();
    }

}
