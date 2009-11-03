package com.sap.tc.moin.xm.generation.core.metamodel.om;

import com.sap.tc.moin.repository.mmi.model.TypedElement;

import com.sap.tc.moin.xm.generation.XmGeneratorInput;

public abstract class XmTypedElement extends XmModelElementImpl {

    XmTypedElement( final XmGeneratorInput input, final String xsdName, final String mofName, final XmNamespace namespace, final XmXsdComponentKind kind ) {

        super( input, xsdName, mofName, namespace, kind );
    }

    public abstract TypedElement createModelElement( );
}
