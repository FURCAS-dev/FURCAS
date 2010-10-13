/**
 * 
 */
package com.sap.furcas.metamodel.TCS.stubs;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.TCS.EnumerationTemplate;

/**
 *
 */
public class EnumTemplateStub extends TemplateStub implements EnumerationTemplate {

    public EList<EnumLiteralMapping> mappings;
    public boolean automatic;

    /* (non-Javadoc)
     * @see TCS.EnumerationTemplate#getMappings()
     */
    @Override
    public EList<EnumLiteralMapping> getMappings() {
        return mappings;
    }

    /* (non-Javadoc)
     * @see TCS.EnumerationTemplate#isAutomatic()
     */
    @Override
    public boolean isAutomatic() {
        return automatic;
    }

    /* (non-Javadoc)
     * @see TCS.EnumerationTemplate#setAutomatic(boolean)
     */
    @Override
    public void setAutomatic(boolean value) {
    }




}
