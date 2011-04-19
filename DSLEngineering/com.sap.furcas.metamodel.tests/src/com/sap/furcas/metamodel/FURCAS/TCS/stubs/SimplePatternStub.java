/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.SimplePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class SimplePatternStub extends LocatedElementStub implements SimplePattern {

    public String  name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getSimplePattern();
    }

  
}
