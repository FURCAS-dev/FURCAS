package com.sap.furcas.emf.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class ForcedLowerPArgStub extends PargStub implements ForcedLowerPArg {

    private final int value;

    public ForcedLowerPArgStub(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public void setValue(Integer value) {
        // TODO Auto-generated method stub

    }
    
    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getForcedLowerPArg();
    }

}