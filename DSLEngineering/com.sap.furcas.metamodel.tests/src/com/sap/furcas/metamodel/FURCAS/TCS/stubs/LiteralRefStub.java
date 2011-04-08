/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.Literal;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class LiteralRefStub extends SequenceElementStub implements LiteralRef {

    public Literal referredLiteral = null;

    @Override
    public Literal getReferredLiteral() {
	return referredLiteral;
    }

    @Override
    public void setReferredLiteral(Literal referredLiteral) {
	this.referredLiteral = referredLiteral;
    }

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getLiteralRef();
    }

}
