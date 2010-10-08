/**
 * 
 */
package com.sap.mi.textual.parsing;

import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.List;

import javax.xml.stream.events.Namespace;

import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ui.internal.keys.model.ModelElement;

import com.sap.mi.textual.test.util.StringListHelper;

/**
 * Stub only intended for testing. Only methods used by AbstractListbasedMetaLookup are being stubbed. 
 * Stubbed methods must be tested in MofStubtest.
 */
public class MofStructureFieldStub implements StructureField {

    /**
     * 
     */
    private static final long serialVersionUID = -3430564725833903776L;
    
    public String name;
    public ModelElement lookupElementExtended;
    public String lookupElementExtendedKey;
    public List<ModelElement> contents;
    public Classifier type;
    public List<GeneralizableElement> supertypes;
    public MultiplicityType multiplicityType;
    public int lower = 1;
    public int upper = -1;
    public RefObject createdInstance;
    

    public Classifier getType() {
        return type;
    }

    public void setType(Classifier type) {
        this.type = type;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#findRequiredElements(java.util.Collection, boolean)
     */
    public Collection<ModelElement> findRequiredElements(
            Collection<? extends String> kinds, boolean recursive)
            throws JmiException {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#getAnnotation()
     */
    public String getAnnotation() throws JmiException {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#getConstraints()
     */
    public Collection<Constraint> getConstraints() throws JmiException {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#getContainer()
     */
    public Namespace getContainer() throws JmiException {
        fail();
        return null;
    }


    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#getQualifiedName()
     */
    public List<String> getQualifiedName() throws JmiException {
        return StringListHelper.list("package", getName());
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#getRequiredElements()
     */
    public Collection<ModelElement> getRequiredElements() throws JmiException {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#isFrozen()
     */
    public boolean isFrozen() throws JmiException {
        fail();
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#isRequiredBecause(com.sap.tc.moin.repository.mmi.model.ModelElement, java.lang.String[])
     */
    public boolean isRequiredBecause(ModelElement otherElement, String[] reason)
            throws JmiException {
        fail();
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#isVisible(com.sap.tc.moin.repository.mmi.model.ModelElement)
     */
    public boolean isVisible(ModelElement otherElement) throws JmiException {
        fail();
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#setAnnotation(java.lang.String)
     */
    public void setAnnotation(String newValue) throws JmiException {
        fail();

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#setContainer(com.sap.tc.moin.repository.mmi.model.Namespace)
     */
    public void setContainer(Namespace newValue) throws JmiException {
        fail();

    }

   

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refClass()
     */
    public RefClass refClass() {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refDelete()
     */
    public void refDelete() {
        fail();

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refImmediateComposite()
     */
    public RefFeatured refImmediateComposite() {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refIsInstanceOf(com.sap.tc.moin.repository.mmi.reflect.RefObject, boolean)
     */
    public boolean refIsInstanceOf(RefObject objType, boolean considerSubtypes) {
        fail();
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refOutermostComposite()
     */
    public RefFeatured refOutermostComposite() {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refGetValue(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    public Object refGetValue(RefObject feature) {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refGetValue(java.lang.String)
     */
    public Object refGetValue(String featureName) {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refInvokeOperation(com.sap.tc.moin.repository.mmi.reflect.RefObject, java.util.List)
     */
    public Object refInvokeOperation(RefObject requestedOperation,
            List<? extends Object> args) throws RefException {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refInvokeOperation(java.lang.String, java.util.List)
     */
    public Object refInvokeOperation(String requestedOperation,
            List<? extends Object> args) throws RefException {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refSetValue(com.sap.tc.moin.repository.mmi.reflect.RefObject, java.lang.Object)
     */
    public void refSetValue(RefObject feature, Object value) {
        fail();

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refSetValue(java.lang.String, java.lang.Object)
     */
    public void refSetValue(String featureName, Object value) {
        fail();

    }
    

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refImmediatePackage()
     */
    public RefPackage refImmediatePackage() {
    	fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refMetaObject()
     */
    public RefObject refMetaObject() {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refMofId()
     */
    public String refMofId() {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refOutermostPackage()
     */
    public RefPackage refOutermostPackage() {
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refVerifyConstraints(boolean)
     */
    public Collection<JmiException> refVerifyConstraints(boolean deepVerify) {
        fail();
        return null;
    }

	@Override
	public void assign___Partition(ModelPartition mp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assign___PartitionIncludingChildren(ModelPartition mp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Connection get___Connection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends RefBaseObject> Class<T> get___JmiInterface() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MRI get___Mri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelPartition get___Partition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean is___Alive() {
		// TODO Auto-generated method stub
		return false;
	}


}
