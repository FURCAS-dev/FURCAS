/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tcs.Alternative;

import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.furcas.textual.common.interfaces.IMetaModelLookup;
import com.sap.furcas.textual.common.interfaces.MultiplicityBean;
import com.sap.furcas.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyStringBuffer;
import com.sap.tc.moin.repository.mmi.model.Classifier;

/**
 *
 */
public class MetaLookupStub<Type extends Object> implements IMetaModelLookup<Type> {

    public List<Alternative> elements = new ArrayList<Alternative>();
    public List<RuleBodyStringBuffer> buffers = new ArrayList<RuleBodyStringBuffer>();
    public List<ResolvedNameAndReferenceBean<Type>> subTypes = new ArrayList<ResolvedNameAndReferenceBean<Type>>();
    public List<ResolvedNameAndReferenceBean<Type>> qualifiedNames;
    public boolean isClassName = false;
    public List<String> featureClassName;
    public List<String> enumLiterals;
    public MultiplicityBean multiplicity = new MultiplicityBean();
    private boolean isSubType = true;

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getDirectSubTypes(java.util.List)
     */
    public List<ResolvedNameAndReferenceBean<Type>> getDirectSubTypes(ResolvedNameAndReferenceBean typeName)
            throws MetaModelLookupException {
        return subTypes;
    }
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getFeatureClassName(java.util.List, java.lang.String)
     */
    public ResolvedNameAndReferenceBean getFeatureClassReference(ResolvedNameAndReferenceBean reference,
            String featureName) throws MetaModelLookupException {
        return new ResolvedNameAndReferenceBean(featureClassName, null);
    }
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getMultiplicity(java.util.List, java.lang.String)
     */
    public MultiplicityBean getMultiplicity(ResolvedNameAndReferenceBean typename,
            String featureName) throws MetaModelLookupException {
        return multiplicity;
    }
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#hasFeature(java.util.List, java.lang.String)
     */
    public boolean hasFeature(ResolvedNameAndReferenceBean typename, String featureName)
            throws MetaModelLookupException {
        fail("not implemented yet");
        return false;
    }
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#isClassName(java.util.List)
     */
    public boolean isClassName(List<String> reference) {
        
        return isClassName ;
    }
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#close()
     */
    public void close() {
    }
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#qualifyName(java.lang.String)
     */
    public List<ResolvedNameAndReferenceBean<Type>> qualifyName(String typeName) {
        return qualifiedNames;
    }

	public List<String> getEnumLiterals(ResolvedNameAndReferenceBean enumeration)
			throws MetaModelLookupException {
		return enumLiterals;
	}
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#isSubTypeOf(java.util.List, java.util.List)
     */
    public boolean isSubTypeOf(ResolvedNameAndReferenceBean subType, ResolvedNameAndReferenceBean superType) {
        return isSubType ;
    }
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#resolveReference(java.util.List)
     */
    public ResolvedNameAndReferenceBean resolveReference(
            List<String> names) throws MetaModelLookupException {

        return new ResolvedNameAndReferenceBean(names, null);
    }
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#resolveReferenceName(java.lang.Object)
     */
    @Override
    public ResolvedNameAndReferenceBean resolveReferenceName(
            Object reference) {
        if (reference instanceof Classifier) {
            Classifier stub = (Classifier) reference;
            ResolvedNameAndReferenceBean bean = new ResolvedNameAndReferenceBean(stub.getQualifiedName(), null);
            return bean;
        }
        fail("not implemented yet");
        return null;
    }
    public boolean isAbstract(ResolvedNameAndReferenceBean bean) {
        return true;
    }
  
    @Override
    public List<String> validateOclQuery(Object template, String query,
	    Object context) {
	return Collections.emptyList();
    }
   
}
