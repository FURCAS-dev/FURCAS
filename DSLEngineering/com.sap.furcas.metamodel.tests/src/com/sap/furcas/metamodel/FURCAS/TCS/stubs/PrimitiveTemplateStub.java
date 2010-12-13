/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;

/**
 *
 */
public class PrimitiveTemplateStub extends TemplateStub implements PrimitiveTemplate {

    public String templateName;
    public String value;
    public boolean isOrkeyword;
    
    public PrimitiveTemplateStub() {
        super();
    }
    
    public PrimitiveTemplateStub(EList<String> names) {
        super(names);
    }

    @Override
    public String getSerializer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTemplateName() {
        return templateName;
    }

    @Override
    public String getTokenName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean isDefault() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isOrKeyword() {
        return isOrkeyword;
    }

    @Override
    public void setDefault(boolean value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setOrKeyword(boolean value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setSerializer(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTemplateName(String value) {
        templateName = value;
    }

    @Override
    public void setTokenName(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setValue(String value) {
        // TODO Auto-generated method stub
        
    }
   

}
