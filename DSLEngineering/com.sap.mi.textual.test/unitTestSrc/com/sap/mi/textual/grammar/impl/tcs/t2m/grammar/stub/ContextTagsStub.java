/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.ArrayList;
import java.util.Collection;

import tcs.ContextTags;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

/**
 *
 */
public class ContextTagsStub extends LocatedElementStub implements ContextTags {

    public Collection<String> tags = new ArrayList<String>();

    /* (non-Javadoc)
     * @see tcs.ContextTags#getTags()
     */
    @Override
    public Collection<String> getTags() throws JmiException {
        // TODO Auto-generated method stub
        return tags;
    }



}
