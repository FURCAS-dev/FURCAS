/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class LiteralStub extends LiteralRefStub implements Symbol {

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

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getLiteral();
    }

}
