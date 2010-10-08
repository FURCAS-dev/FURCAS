/**
 * 
 */
package com.sap.furcas.metamodel.TCS.stubs;

import com.sap.furcas.metamodel.TCS.Literal;
import com.sap.furcas.metamodel.TCS.LiteralRef;

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

}
