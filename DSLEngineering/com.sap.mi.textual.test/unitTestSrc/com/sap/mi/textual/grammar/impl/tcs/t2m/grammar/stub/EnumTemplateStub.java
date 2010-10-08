/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.List;

import com.sap.furcas.metamodel.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.TCS.EnumerationTemplate;

/**
 *
 */
public class EnumTemplateStub extends TemplateStub implements EnumerationTemplate {

    public List<EnumLiteralMapping> mappings;
    public boolean automatic;

    /* (non-Javadoc)
     * @see TCS.EnumerationTemplate#getMappings()
     */
    public List<EnumLiteralMapping> getMappings() {
        return mappings;
    }

    /* (non-Javadoc)
     * @see TCS.EnumerationTemplate#isAutomatic()
     */
    public boolean isAutomatic() {
        return automatic;
    }

    /* (non-Javadoc)
     * @see TCS.EnumerationTemplate#setAutomatic(boolean)
     */
    public void setAutomatic(boolean value) {
    }




}
