/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.Associativity;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class PriorityStub extends LocatedElementStub implements Priority {

    public int value;
    public OperatorList list;
    public Associativity associativity;
    public EList<Operator> operators = new BasicEList<Operator>();
    
    @Override
    public Integer getValue() {
        return value;
    }
    @Override
    public void setValue(Integer value) {
        this.value = value;
    }
    @Override
    public OperatorList getList() {
        return list;
    }
    @Override
    public void setList(OperatorList list) {
        this.list = list;
    }
    @Override
    public Associativity getAssociativity() {
        return associativity;
    }
    @Override
    public void setAssociativity(Associativity associativity) {
        this.associativity = associativity;
    }
    /* (non-Javadoc)
     * @see TCS.Priority#getOperators()
     */
    @Override
    public EList<Operator> getOperators() {
        return operators;
    }
    
    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getPriority();
    }


}
