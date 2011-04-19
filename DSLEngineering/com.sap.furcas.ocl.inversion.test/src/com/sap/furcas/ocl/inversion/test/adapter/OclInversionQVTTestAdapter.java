package com.sap.furcas.ocl.inversion.test.adapter;

import de.ikv.medini.qvt.test.QVTEMFTestAdapter;

public class OclInversionQVTTestAdapter extends QVTEMFTestAdapter {

    @Override
    public boolean supportsMetaModels(String[] metamodelIDs) {
//        for (String metaModelID : metamodelIDs) {
//                if (!(metaModelID.equals("EUML") || metaModelID.equals("AmedatoModeling") || metaModelID.equals("EARepository") || metaModelID.equals("uml"))) {
//                        return false;
//                }
//        }
        this.metamodelIDs = metamodelIDs;
        return true;
    }
    
    
}
