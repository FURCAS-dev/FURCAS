/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import com.sap.furcas.metamodel.TCS.PrimitiveTemplate;

/**
 *
 */
public class PrimitiveTemplateStub extends TemplateStub implements PrimitiveTemplate {

    public String templateName;
    public String value;
    public boolean isOrkeyword;

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#getSerializer()
     */
    public String getSerializer() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#getTemplateName()
     */
    public String getTemplateName() {
        return templateName;
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#getTokenName()
     */
    public String getTokenName() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#getValue()
     */
    public String getValue() {
        return value;
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#isDefault()
     */
    public boolean isDefault() {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#isOrKeyword()
     */
    public boolean isOrKeyword() {
        return isOrkeyword;
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#setDefault(boolean)
     */
    public void setDefault(boolean value) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#setOrKeyword(boolean)
     */
    public void setOrKeyword(boolean value) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#setSerializer(java.lang.String)
     */
    public void setSerializer(String value) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#setTemplateName(java.lang.String)
     */
    public void setTemplateName(String value) {
        templateName = value;
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#setTokenName(java.lang.String)
     */
    public void setTokenName(String value) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see TCS.PrimitiveTemplate#setValue(java.lang.String)
     */
    public void setValue(String value) {
        // TODO Auto-generated method stub
        
    }

   

}
