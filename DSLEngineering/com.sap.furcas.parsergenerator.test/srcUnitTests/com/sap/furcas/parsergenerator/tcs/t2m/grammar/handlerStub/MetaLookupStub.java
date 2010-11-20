/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.MultiplicityBean;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;

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
    private final boolean isSubType = true;

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#get@Override
     * (java.util.List)
     */
    @Override
    public List<ResolvedNameAndReferenceBean<Type>> getDirectSubTypes(ResolvedNameAndReferenceBean typeName)
	    throws MetaModelLookupException {
	return subTypes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.interfaces.IMetaModelLookup#getFeatureClassName(jav
     * @Override ava.lang.String)
     */
    @Override
    public ResolvedNameAndReferenceBean getFeatureClassReference(ResolvedNameAndReferenceBean reference, String featureName)
	    throws MetaModelLookupException {
	return new ResolvedNameAndReferenceBean(featureClassName, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.interfaces.IMetaModelLookup#getMultiplicity(jav@Override
     * ava.lang.String)
     */
    @Override
    public MultiplicityBean getMultiplicity(ResolvedNameAndReferenceBean typename, String featureName)
	    throws MetaModelLookupException {
	return multiplicity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.interfaces.IMetaModelLookup#hasFeature(java.util.List,
     * java.lang.String)
     */
    public boolean hasFeature(ResolvedNameAndReferenceBean typename, String featureName) throws MetaModelLookupException {
	fail("not implemented yet");
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.interfaces.IMetaModelLookup#isClassName(java.util.
     * List)
     */
    public boolean isClassName(List<String> reference) {

	return isClassName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.inter@Override elLookup#close()
     */
    @Override
    public void close() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup@Override
     * ava.lang.String)
     */
    @Override
    public List<ResolvedNameAndReferenceBean<Type>> qualifyName(String typeName) {
	return qualifiedNames;
    }

    @Override
    public List<String> getEnumLiterals(ResolvedNameAndReferenceBean enumeration) {

	return enumLiterals;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.interfaces.IMetaModelLookup#isSubTypeOf(j@Override
     * java.util.List)
     */
    @Override
    public boolean isSubTypeOf(ResolvedNameAndReferenceBean subType, ResolvedNameAndReferenceBean superType) {
	return isSubType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#re@Override
     * (java.util.List)
     */
    @Override
    public ResolvedNameAndReferenceBean resolveReference(List<String> names) throws MetaModelLookupException {

	return new ResolvedNameAndReferenceBean(names, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.interfaces.IMetaModelLookup#resolveReferenceName(java
     * .lang.Object)
     */
    @Override
    public ResolvedNameAndReferenceBean resolveReferenceName(Object reference) {
	if (reference instanceof EClassifier) {
	    EClassifier stub = (EClassifier) reference;
	    ResolvedNameAndReferenceBean bean = new ResolvedNameAndReferenceBean(EcoreHelper.getQualifiedName(stub), null);
	    return bean;
	}
	fail("not implemented");
	return null;
    }

    @Override
    public boolean isAbstract(ResolvedNameAndReferenceBean bean) {
	return true;
    }

    @Override
    public List<String> validateOclQuery(Object template, String query, Object context) {
	return Collections.emptyList();
    }

}
