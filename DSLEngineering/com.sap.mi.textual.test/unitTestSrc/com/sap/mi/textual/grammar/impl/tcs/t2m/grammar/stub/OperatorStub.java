/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.metamodel.TCS.Operator;
import com.sap.furcas.metamodel.TCS.OperatorTemplate;

/**
 *
 */
public class OperatorStub extends LocatedElementStub implements Operator {

    public String name;
    public int arity = 2;
    public List<OperatorTemplate> templatesList = new ArrayList<OperatorTemplate>();
    public Literal literal;
	public boolean isPostFix;
    
    /* (non-Javadoc)
     * @see TCS.NamedElement#getName()
     */
    public String getName() {
        return name;
    }
    /* (non-Javadoc)
     * @see TCS.NamedElement#setName(java.lang.String)
     */
    public void setName(String value) {
        name = value;   
    }
    

    /* (non-Javadoc)
     * @see TCS.Operator#getArity()
     */
    public int getArity() {
        return arity ;
    }
    /* (non-Javadoc)
     * @see TCS.Operator#getLiteral()
     */
    public Literal getLiteral() {
        return literal;
    }
    /* (non-Javadoc)
     * @see TCS.Operator#getPriority()
     */
    public Priority getPriority() {
        // TODO Auto-generated method stub
        return null;
    }
    /* (non-Javadoc)
     * @see TCS.Operator#getTemplates()
     */
    public List<OperatorTemplate> getTemplates() {
        return templatesList;
    }
    /* (non-Javadoc)
     * @see TCS.Operator#isIsPostfix()
     */
    public boolean isPostfix() {
        return isPostFix;
    }
    /* (non-Javadoc)
     * @see TCS.Operator#setArity(int)
     */
    public void setArity(int value) {
        // TODO Auto-generated method stub
        
    }
    /* (non-Javadoc)
     * @see TCS.Operator#setIsPostfix(boolean)
     */
    public void setPostfix(boolean value) {
        // TODO Auto-generated method stub
        
    }
    /* (non-Javadoc)
     * @see TCS.Operator#setLiteral(TCS.Literal)
     */
    public void setLiteral(Literal value) {
        // TODO Auto-generated method stub
        
    }
    /* (non-Javadoc)
     * @see TCS.Operator#setPriority(TCS.Priority)
     */
    public void setPriority(Priority value) {
        // TODO Auto-generated method stub
        
    }

    

}
