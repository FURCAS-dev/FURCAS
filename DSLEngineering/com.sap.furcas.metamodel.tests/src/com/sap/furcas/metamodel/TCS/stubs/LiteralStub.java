/**
 * 
 */
package com.sap.furcas.metamodel.TCS.stubs;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.TCS.Literal;
import com.sap.furcas.metamodel.TCS.LiteralRef;
import com.sap.furcas.metamodel.TCS.Operator;
import com.sap.furcas.metamodel.TCS.SpaceKind;
import com.sap.furcas.metamodel.TCS.Symbol;

/**
 *
 */
public class LiteralStub extends LiteralRefStub implements Literal, Symbol {

    public String value, name;
    public EList<Operator> operators;

    @Override
    public String getValue() {
	return value;
    }

    @Override
    public void setValue(String value) {
	this.value = value;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public void setName(String name) {
	this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.Literal#getLiteralRefs()
     */
    @Override
    public EList<LiteralRef> getLiteralRefs() {
	// TODO Auto-generated method stub
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.Literal#getOperators()
     */
    @Override
    public EList<Operator> getOperators() {
	return operators;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.Symbol#getSpaces()
     */
    @Override
    public EList<SpaceKind> getSpaces() {
	// TODO Auto-generated method stub
	return null;
    }

}
