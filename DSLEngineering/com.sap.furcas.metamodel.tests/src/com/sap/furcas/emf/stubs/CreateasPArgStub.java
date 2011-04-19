package com.sap.furcas.emf.stubs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.CreateAsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class CreateasPArgStub extends PargStub implements CreateAsPArg {

    public EList<String> name;

    public void setName(EList<String> name) {
        this.name = name;
    }

    @Override
    public EList<String> getName() {
        return name;
    }

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getCreateAsPArg();
    }

}