/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import java.util.List;

import tcs.QualifiedNamedElement;

import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.common.exceptions.NameResolutionFailedException;
import com.sap.mi.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.mi.textual.tcs.util.MetaModelElementResolutionHelper;

/**
 *
 */
public class MetaModelElementResolutionHelperStub extends
        MetaModelElementResolutionHelper {

    /**
     * @param metaLookup
     */
    public MetaModelElementResolutionHelperStub() {
        super(new MetaLookupStub());
    }

    @Override
    public ResolvedNameAndReferenceBean resolve(List names)
            throws MetaModelLookupException {
        return new ResolvedNameAndReferenceBean(names, null);
    }

    @Override
    public ResolvedNameAndReferenceBean resolve(QualifiedNamedElement template)
            throws NameResolutionFailedException {
        return new ResolvedNameAndReferenceBean(template.getNames(), null);
    }
    
    

}
