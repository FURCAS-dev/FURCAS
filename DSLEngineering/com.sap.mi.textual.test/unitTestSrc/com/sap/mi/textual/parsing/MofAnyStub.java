/**
 * 
 */
package com.sap.mi.textual.parsing;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.naming.NameNotFoundException;
import javax.xml.stream.events.Namespace;

import org.eclipse.ocl.ecore.Constraint;

import com.sap.furcas.metamodel.TCS.ScopeKind;
import com.sap.furcas.parsergenerator.testutils.StringListHelper;
import com.sap.tc.moin.textual.moinadapter.adapter.stub.PRIStub;

/**
 * Stub only intended for testing. Only methods used by AbstractListbasedMetaLookup are being stubbed. 
 * Stubbed methods must be tested in MofStubtest.
 */
public class MofAnyStub implements Partitionable, Classifier, MofClass, RefClass, RefEnum, RefStruct, Association, AssociationEnd, StructuralFeature, Reference, GeneralizableElement, MultiplicityType, MofPackage, ModelElement {

    /**
     * 
     */
    private static final long serialVersionUID = -3430564725833903776L;
    
    public String name;
    public ModelElement lookupElementExtended;
    public String lookupElementExtendedKey;
    public List<ModelElement> contents = new ArrayList<ModelElement>();
    public Classifier type;
    public List<GeneralizableElement> supertypes;
    public MultiplicityType multiplicityType;
    public int lower = 1;
    public int upper = -1;
    public RefObject createdInstance;
    public RefClass refClass;

    public Object propertyValue;

    public MofClass metaObject;
    
 
    public MofAnyStub() {
    }
    
    public MofAnyStub(String string) {
        name = string;
    }

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
     * @see com.sap.tc.moin.repository.mmi.model.MofClass#isSingleton()
     */
    public boolean isSingleton() throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.MofClass#setSingleton(boolean)
     */
    public void setSingleton(boolean newValue) throws JmiException {
        fail("stub method not implemented");
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#allSupertypes()
     */
    public List<GeneralizableElement> allSupertypes() throws JmiException {
        return supertypes;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#findElementsByTypeExtended(com.sap.tc.moin.repository.mmi.model.MofClass, boolean)
     */
    public List<ModelElement> findElementsByTypeExtended(MofClass ofType,
            boolean includeSubtypes) throws JmiException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#getSupertypes()
     */
    public List<GeneralizableElement> getSupertypes() throws JmiException {
        return supertypes;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#getVisibility()
     */
    public VisibilityKind getVisibility() throws JmiException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#isAbstract()
     */
    public boolean isAbstract() throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#isLeaf()
     */
    public boolean isLeaf() throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#isRoot()
     */
    public boolean isRoot() throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#lookupElementExtended(java.lang.String)
     */
    public ModelElement lookupElementExtended(String name) throws JmiException {
        if (lookupElementExtendedKey != null && lookupElementExtendedKey.equals(name)) {
            return lookupElementExtended;
        }
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#setAbstract(boolean)
     */
    public void setAbstract(boolean newValue) throws JmiException {
        fail("stub method not implemented");

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#setLeaf(boolean)
     */
    public void setLeaf(boolean newValue) throws JmiException {
        fail("stub method not implemented");

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#setRoot(boolean)
     */
    public void setRoot(boolean newValue) throws JmiException {
        fail("stub method not implemented");

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.GeneralizableElement#setVisibility(com.sap.tc.moin.repository.mmi.model.VisibilityKind)
     */
    public void setVisibility(VisibilityKind newValue) throws JmiException {
        fail("stub method not implemented");

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.Namespace#findElementsByType(com.sap.tc.moin.repository.mmi.model.MofClass, boolean)
     */
    public List<ModelElement> findElementsByType(MofClass ofType,
            boolean includeSubtypes) throws JmiException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.Namespace#getContents()
     */
    public List<ModelElement> getContents() throws JmiException {
        return contents;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.Namespace#lookupElement(java.lang.String)
     */
    public ModelElement lookupElement(String name) throws JmiException,
            NameNotFoundException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.Namespace#nameIsValid(java.lang.String)
     */
    public boolean nameIsValid(String proposedName) throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.Namespace#resolveQualifiedName(java.util.List)
     */
    public ModelElement resolveQualifiedName(
            List<? extends String> qualifiedName) throws JmiException,
            NameNotResolvedException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#findRequiredElements(java.util.Collection, boolean)
     */
    public Collection<ModelElement> findRequiredElements(
            Collection<? extends String> kinds, boolean recursive)
            throws JmiException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#getAnnotation()
     */
    public String getAnnotation() throws JmiException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#getConstraints()
     */
    public Collection<Constraint> getConstraints() throws JmiException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#getContainer()
     */
    public Namespace getContainer() throws JmiException {
        fail("stub method not implemented");
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
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#isFrozen()
     */
    public boolean isFrozen() throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#isRequiredBecause(com.sap.tc.moin.repository.mmi.model.ModelElement, java.lang.String[])
     */
    public boolean isRequiredBecause(ModelElement otherElement, String[] reason)
            throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#isVisible(com.sap.tc.moin.repository.mmi.model.ModelElement)
     */
    public boolean isVisible(ModelElement otherElement) throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#setAnnotation(java.lang.String)
     */
    public void setAnnotation(String newValue) throws JmiException {
        fail("stub method not implemented");

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.ModelElement#setContainer(com.sap.tc.moin.repository.mmi.model.Namespace)
     */
    public void setContainer(Namespace newValue) throws JmiException {
        fail("stub method not implemented");

    }

   

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refClass()
     */
    public RefClass refClass() {
        return refClass;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refDelete()
     */
    public void refDelete() {
        fail("stub method not implemented");

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refImmediateComposite()
     */
    public RefFeatured refImmediateComposite() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refIsInstanceOf(com.sap.tc.moin.repository.mmi.reflect.RefObject, boolean)
     */
    public boolean refIsInstanceOf(RefObject objType, boolean considerSubtypes) {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refOutermostComposite()
     */
    public RefFeatured refOutermostComposite() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refGetValue(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    public Object refGetValue(RefObject feature) {
        return propertyValue;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refGetValue(java.lang.String)
     */
    public Object refGetValue(String featureName) {
        return propertyValue;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refInvokeOperation(com.sap.tc.moin.repository.mmi.reflect.RefObject, java.util.List)
     */
    public Object refInvokeOperation(RefObject requestedOperation,
            List<? extends Object> args) throws RefException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refInvokeOperation(java.lang.String, java.util.List)
     */
    public Object refInvokeOperation(String requestedOperation,
            List<? extends Object> args) throws RefException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refSetValue(com.sap.tc.moin.repository.mmi.reflect.RefObject, java.lang.Object)
     */
    public void refSetValue(RefObject feature, Object value) {
        this.propertyValue = value;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refSetValue(java.lang.String, java.lang.Object)
     */
    public void refSetValue(String featureName, Object value) {
        this.propertyValue = value;
    }
    

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refImmediatePackage()
     */
    public RefPackage refImmediatePackage() {
    	fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refMetaObject()
     */
    public MofClass refMetaObject() {
        return metaObject;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refMofId()
     */
    public String refMofId() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refOutermostPackage()
     */
    public RefPackage refOutermostPackage() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refVerifyConstraints(boolean)
     */
    public Collection<JmiException> refVerifyConstraints(boolean deepVerify) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.Association#isDerived()
     */
    public boolean isDerived() throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.Association#setDerived(boolean)
     */
    public void setDerived(boolean newValue) throws JmiException {
        fail("stub method not implemented");
        
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.AssociationEnd#getAggregation()
     */
    public AggregationKind getAggregation() throws JmiException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.AssociationEnd#getMultiplicity()
     */
    public MultiplicityType getMultiplicity() throws JmiException {
       
        return multiplicityType;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.AssociationEnd#isChangeable()
     */
    public boolean isChangeable() throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.AssociationEnd#isNavigable()
     */
    public boolean isNavigable() throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.AssociationEnd#otherEnd()
     */
    public AssociationEnd otherEnd() throws JmiException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.AssociationEnd#setAggregation(com.sap.tc.moin.repository.mmi.model.AggregationKind)
     */
    public void setAggregation(AggregationKind newValue) throws JmiException {
        fail("stub method not implemented");
        
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.AssociationEnd#setChangeable(boolean)
     */
    public void setChangeable(boolean newValue) throws JmiException {
        fail("stub method not implemented");
        
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.AssociationEnd#setMultiplicity(com.sap.tc.moin.repository.mmi.model.MultiplicityType)
     */
    public void setMultiplicity(MultiplicityType newValue) throws JmiException {
        multiplicityType = newValue;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.AssociationEnd#setNavigable(boolean)
     */
    public void setNavigable(boolean newValue) throws JmiException {
        fail("stub method not implemented");
        
    }

   

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.Feature#getScope()
     */
    public ScopeKind getScope() throws JmiException {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.Feature#setScope(com.sap.tc.moin.repository.mmi.model.ScopeKind)
     */
    public void setScope(ScopeKind newValue) throws JmiException {
        fail("stub method not implemented");
        
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.MultiplicityType#getLower()
     */
    public int getLower() throws JmiException {
        return lower;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.MultiplicityType#getUpper()
     */
    public int getUpper() throws JmiException {
        return upper;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.MultiplicityType#isOrdered()
     */
    public boolean isOrdered() throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.MultiplicityType#isUnique()
     */
    public boolean isUnique() throws JmiException {
        fail("stub method not implemented");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefStruct#refFieldNames()
     */
    public List<String> refFieldNames() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefStruct#refTypeName()
     */
    public List<String> refTypeName() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refAllAssociations()
     */
    public Collection<RefAssociation> refAllAssociations() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refAllClasses()
     */
    public Collection<RefClass> refAllClasses() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refAllPackages()
     */
    public Collection<RefPackage> refAllPackages() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refAssociation(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    public RefAssociation refAssociation(RefObject association) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refAssociation(java.lang.String)
     */
    public RefAssociation refAssociation(String associationName) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refClass(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    public RefClass refClass(RefObject type) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refClass(java.lang.String)
     */
    public RefClass refClass(String typeName) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refCreateStruct(com.sap.tc.moin.repository.mmi.reflect.RefObject, java.util.List)
     */
    public RefStruct refCreateStruct(RefObject struct,
            List<? extends Object> params) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refCreateStruct(java.lang.String, java.util.List)
     */
    public RefStruct refCreateStruct(String structName,
            List<? extends Object> params) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refGetEnum(com.sap.tc.moin.repository.mmi.reflect.RefObject, java.lang.String)
     */
    public RefEnum refGetEnum(RefObject enumType, String name) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refGetEnum(java.lang.String, java.lang.String)
     */
    public RefEnum refGetEnum(String enumName, String name) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refPackage(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    public RefPackage refPackage(RefObject nestedPackage) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refPackage(java.lang.String)
     */
    public RefPackage refPackage(String nestedPackageName) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefClass#refAllOfClass()
     */
    public Collection<RefObject> refAllOfClass() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefClass#refAllOfType()
     */
    public Collection<RefObject> refAllOfType() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefClass#refCreateInstance(java.util.List)
     */
    public RefObject refCreateInstance(List<? extends Object> args) {
        return createdInstance;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefClass#refCreateInstanceInPartition(java.util.List, com.sap.tc.moin.repository.ModelPartition)
     */
    public RefObject refCreateInstanceInPartition(List<? extends Object> args,
            ModelPartition partition) {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefClass#refCreateInstance()
     */
    public RefObject refCreateInstance() {
        return createdInstance;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefClass#refCreateInstanceInPartition(com.sap.tc.moin.repository.ModelPartition)
     */
    public RefObject refCreateInstanceInPartition(ModelPartition partition) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Partitionable#assign___Partition(com.sap.tc.moin.repository.ModelPartition)
     */
    @Override
    public void assign___Partition(ModelPartition mp) {
        fail("stub method not implemented");
        
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Partitionable#assign___PartitionIncludingChildren(com.sap.tc.moin.repository.ModelPartition)
     */
    @Override
    public void assign___PartitionIncludingChildren(ModelPartition mp) {
        fail("stub method not implemented");
        
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Partitionable#get___Connection()
     */
    @Override
    public Connection get___Connection() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Partitionable#get___JmiInterface()
     */
    @Override
    public <T extends RefBaseObject> Class<T> get___JmiInterface() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Partitionable#get___Mri()
     */
    @Override
    public MRI get___Mri() {
        fail("stub method not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Partitionable#get___Partition()
     */
    @Override
    public ModelPartition get___Partition() {
        return new ModelPartition() {

            @Override
            public void assignElement(Partitionable element) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void assignElementIncludingChildren(Partitionable element) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public <T extends RefObject> T createElement(Class<T> clazz) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void delete() {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void deleteElements() {
                // TODO Auto-generated method stub
                
            }

            @Override
            public Collection<Partitionable> getElements() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public PRI getPri() {
                return new PRIStub();
            }

            @Override
            public boolean isAlive() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isDirty() {
                // TODO Auto-generated method stub
                return false;
            }

			@Override
			public <T extends RefObject> T createElement(
					com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor<? extends RefClass, T> classDescriptor) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<CRI, String> getUsedMetamodels() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hadUnhandledErrorsDuringLoad() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isMemoryStateDifferentFromPersistentStateAfterLoad() {
				// TODO Auto-generated method stub
				return false;
			}};
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Partitionable#is___Alive()
     */
    @Override
    public boolean is___Alive() {
        fail("stub method not implemented");
        return false;
    }

	@Override
	public boolean refIsInstanceOf(MRI objTypeMri, boolean considerSubtypes) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public MRI refMetaObjectMri() {
		throw new RuntimeException("not implemented");
	}

	@Override
	public AssociationEnd getExposedEnd() throws JmiException {
	    throw new RuntimeException("not implemented");
	}

	@Override
	public AssociationEnd getReferencedEnd() throws JmiException {
	    throw new RuntimeException("not implemented");
	}

	@Override
	public void setExposedEnd(AssociationEnd newValue) throws JmiException {
	    throw new RuntimeException("not implemented");
	}

	@Override
	public void setReferencedEnd(AssociationEnd newValue)
		throws JmiException {
	    throw new RuntimeException("not implemented");
	}

    
    
}
