/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.Literal;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;

/**
 *
 */
public class OperatorStub extends LocatedElementStub implements Operator {

    public String name;
    public int arity = 2;
    public EList<OperatorTemplate> templatesList = new BasicEList<OperatorTemplate>();
    public Literal literal;
	public boolean isPostFix;
    
    /* (non-Javadoc)
     * @see TCS.NamedElement#getName()
     */
    @Override
    public String getName() {
        return name;
    }
    /* (non-Javadoc)
     * @see TCS.NamedElement#setName(java.lang.String)
     */
    @Override
    public void setName(String value) {
        name = value;   
    }
    

    /* (non-Javadoc)
     * @see TCS.Operator#getArity()
     */
    @Override
    public int getArity() {
        return arity ;
    }
    /* (non-Javadoc)
     * @see TCS.Operator#getLiteral()Integer
     */
    @Override
    public Literal getLiteral() {
        return literal;
    }
    /* (non-Javadoc)
     * @see TCS.Operator#getPriority()
     */
    @Override
    public Priority getPriority() {
        // TODO Auto-generated method stub
        return null;
    }
    /* (non-Javadoc)
     * @see TCS.Operator#getTemplates()
     */
    @Override
    public EList<OperatorTemplate> getTemplates() {
        return templatesList;
    }
    /* (non-Javadoc)
     * @see TCS.Operator#isIsPostfix()
     */
    @Override
    public boolean isIsPostfix() {
        return isPostFix;
    }
    /* (non-Javadoc)
     * @see TCS.Operator#setArity(int)
     */
    @Override
    public void setArity(int value) {
        // TODO Auto-generated method stub
        
    }
    /* (non-Javadoc)
     * @see TCS.Operator#setIsPostfix(boolean)
     */
    @Override
    public void setIsPostfix(boolean value) {
        // TODO Auto-generated method stub
        
    }
    /* (non-Javadoc)
     * @see TCS.Operator#setLiteral(TCS.Literal)
     */
    @Override
    public void setLiteral(Literal value) {
        // TODO Auto-generated method stub
        
    }
    /* (non-Javadoc)
     * @see TCS.Operator#setPriority(TCS.Priority)
     */
    @Override
    public void setPriority(Priority value) {
        // TODO Auto-generated method stub
        
    }

    

}
