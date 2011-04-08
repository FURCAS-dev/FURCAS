/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTags;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class ContextTagsStub extends LocatedElementStub implements ContextTags {

    public EList<String> tags = new BasicEList<String>();

    /* (non-Javadoc)
     * @see tcs.ContextTags#getTags()
     */
    @Override
    public EList<String> getTags() {
        // TODO Auto-generated method stub
        return tags;
    }

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getContextTags();
    }

}
