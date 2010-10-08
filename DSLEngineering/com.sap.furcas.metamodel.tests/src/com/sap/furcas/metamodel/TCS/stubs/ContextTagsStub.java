/**
 * 
 */
package com.sap.furcas.metamodel.TCS.stubs;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.TCS.ContextTags;

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



}
