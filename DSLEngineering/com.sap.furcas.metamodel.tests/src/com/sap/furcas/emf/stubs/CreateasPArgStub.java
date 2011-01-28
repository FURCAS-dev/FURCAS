package com.sap.furcas.emf.stubs;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.CreateAsPArg;

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

}