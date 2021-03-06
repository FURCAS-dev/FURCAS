/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

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

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getEnumerationTemplate();
    }

}
