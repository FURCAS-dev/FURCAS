/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import tcs.Literal;
import tcs.LiteralRef;

/**
 *
 */
public class LiteralRefStub extends SequenceElementStub implements LiteralRef {

    public Literal referredLiteral = null;

    public Literal getReferredLiteral() {
        return referredLiteral;
    }

    public void setReferredLiteral(Literal referredLiteral) {
        this.referredLiteral = referredLiteral;
    }

}
