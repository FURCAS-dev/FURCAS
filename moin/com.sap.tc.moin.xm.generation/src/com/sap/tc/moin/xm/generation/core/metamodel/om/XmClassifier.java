package com.sap.tc.moin.xm.generation.core.metamodel.om;

import com.sap.tc.moin.repository.mmi.model.Classifier;


/** Represents a MOF classifier. */
public interface XmClassifier extends XmModelElement {

    Classifier createModelElement( );

}
