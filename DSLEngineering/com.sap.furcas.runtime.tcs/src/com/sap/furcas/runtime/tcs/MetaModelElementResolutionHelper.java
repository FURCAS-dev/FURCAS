/**
 * 
 */
package com.sap.furcas.runtime.tcs;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;

/**
 *
 */
public class MetaModelElementResolutionHelper<Type extends Object> {

    private final IMetaModelLookup<Type> metaLookup;
    
    /**
     * @param metaLookup
     */
    public MetaModelElementResolutionHelper(IMetaModelLookup<Type> metaLookup) {
        super();
        if (metaLookup == null) {
            throw new IllegalArgumentException("null not allowed");
        }
        this.metaLookup = metaLookup;
    }
    
    @SuppressWarnings("unchecked")
    public ResolvedNameAndReferenceBean<Type> resolve(QualifiedNamedElement template) throws NameResolutionFailedException {
        if (template != null) {
            ResolvedNameAndReferenceBean<Type> result;
            try {
                if (template.getMetaReference() != null ) { // implies we are using MOIN,
                    // since MOIN cannot reference other technical implementation of MMs
                    result = metaLookup.resolveReferenceName((Type) template.getMetaReference());
                    if (result == null) {
                        throw new NameResolutionFailedException("Reference "+ template.getMetaReference() +" not known in Metamodel.");
                    }
                } else {
                    if (template.getNames() == null || template.getNames().size() == 0) {
                        throw new IllegalArgumentException("Bug: Template encountered having neither metamodel reference nor names.");
                    }
                    result = resolve(template.getNames());
                    if (result == null) {
                        throw new NameResolutionFailedException("Name "+ MessageHelper.getTemplateName(template) +" could not be resolved.");
                    }
                }
            } catch (MetaModelLookupException e) {
                throw new NameResolutionFailedException(e);
            }
            if(template instanceof OperatorTemplate) {
                List<String> names = new ArrayList<String>(result.getNames());
                for (Operator op : ((OperatorTemplate)template).getOperators()) {
                    names.add(op.getName());
                }
                result = new ResolvedNameAndReferenceBean<Type>(result.getNames(), result.getReference(), names);
            }
            
            return result;
        } else {
            throw new IllegalArgumentException("template may not be null");
        }
    }
    
    public ResolvedNameAndReferenceBean<Type> resolve(List<String> names) throws MetaModelLookupException {
        if (names == null ) {
            throw new IllegalArgumentException("null not allowed");
        }
        return metaLookup.resolveReference(names);
    }

    public IMetaModelLookup<Type> getMetaLookup() {
	return metaLookup;
    }
    
    
    
}
