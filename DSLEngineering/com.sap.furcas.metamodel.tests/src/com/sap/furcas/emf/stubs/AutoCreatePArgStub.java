package com.sap.furcas.emf.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class AutoCreatePArgStub extends PargStub implements AutoCreatePArg {

    public AutoCreateKind kind;

    /*
     * (non-Javadoc)
     * 
     * @see TCS.AutoCreatePArg#getValue()
     */
    @Override
    	public AutoCreateKind getValue() {
        return kind;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.AutoCreatePArg#setValue(TCS.AutoCreateKind)
     */
    @Override
    	public void setValue(AutoCreateKind value) {

    }

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getAutoCreatePArg();
    }

}