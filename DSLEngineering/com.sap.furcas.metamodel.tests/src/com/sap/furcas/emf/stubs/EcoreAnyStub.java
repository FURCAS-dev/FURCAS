/**
 * 
 */
package com.sap.furcas.emf.stubs;

import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Stub only intended for testing. Only methods used by AbstractListbasedMetaLookup are being stubbed. 
 * Stubbed methods must be tested in MofStubtest.
 */
public class EcoreAnyStub implements EClass, EReference, EEnum, EPackage {

    /**
     * 
     */
    private static final long serialVersionUID = -3430564725833903776L;
    
    public String name;
//    public EModelElement lookupElementExtended;
//    public String lookupElementExtendedKey;
//    public EList<EModelElement> contents = new BasicEList<EModelElement>();
    public EClassifier type;
//    //public List<GeneralizableElement> supertypes;
////    public MultiplicityType multiplicityType;
//    public int lower = 1;
//    public int upper = -1;
//    //public EObject createdInstance;
////    public RefClass refClass;
//    public Object propertyValue;
//    public EClass metaObject;
    
 
    public EcoreAnyStub() {
    }
    
    public EcoreAnyStub(String string) {
        name = string;
    }

    public EClassifier getType() {
        return type;
    }

    public void setType(EClassifier type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public EClass eClass() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public Resource eResource() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EObject eContainer() {
	return null;
    }

    @Override
    public EStructuralFeature eContainingFeature() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EReference eContainmentFeature() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EObject> eContents() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public TreeIterator<EObject> eAllContents() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public boolean eIsProxy() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public EList<EObject> eCrossReferences() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public Object eGet(EStructuralFeature feature) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public Object eGet(EStructuralFeature feature, boolean resolve) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void eSet(EStructuralFeature feature, Object newValue) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean eIsSet(EStructuralFeature feature) {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void eUnset(EStructuralFeature feature) {
	fail("stub method not implemented");
    }

    @Override
    public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<Adapter> eAdapters() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public boolean eDeliver() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void eSetDeliver(boolean deliver) {
	fail("stub method not implemented");
	
    }

    @Override
    public void eNotify(Notification notification) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean isOrdered() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setOrdered(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean isUnique() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setUnique(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public int getLowerBound() {
	fail("stub method not implemented");
	return 0;
    }

    @Override
    public void setLowerBound(int value) {
	fail("stub method not implemented");
	
    }

    @Override
    public int getUpperBound() {
	fail("stub method not implemented");
	return 0;
    }

    @Override
    public void setUpperBound(int value) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean isMany() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public boolean isRequired() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public EClassifier getEType() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void setEType(EClassifier value) {
	fail("stub method not implemented");
	
    }

    @Override
    public EGenericType getEGenericType() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void setEGenericType(EGenericType value) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean isSerializable() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setSerializable(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public String getNsURI() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void setNsURI(String value) {
	fail("stub method not implemented");
	
    }

    @Override
    public String getNsPrefix() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void setNsPrefix(String value) {
	fail("stub method not implemented");
	
    }

    @Override
    public EFactory getEFactoryInstance() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void setEFactoryInstance(EFactory value) {
	fail("stub method not implemented");
	
    }

    @Override
    public EList<EClassifier> getEClassifiers() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EPackage> getESubpackages() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EPackage getESuperPackage() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EClassifier getEClassifier(@SuppressWarnings("hiding") String name) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EAnnotation> getEAnnotations() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EAnnotation getEAnnotation(String source) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EEnumLiteral> getELiterals() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EEnumLiteral getEEnumLiteral(@SuppressWarnings("hiding") String name) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EEnumLiteral getEEnumLiteral(int value) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EEnumLiteral getEEnumLiteralByLiteral(String literal) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public boolean isTransient() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setTransient(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean isVolatile() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setVolatile(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean isChangeable() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setChangeable(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public String getDefaultValueLiteral() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void setDefaultValueLiteral(String value) {
	fail("stub method not implemented");
	
    }

    @Override
    public void setDefaultValue(Object value) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean isUnsettable() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setUnsettable(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean isDerived() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setDerived(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public EClass getEContainingClass() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public int getFeatureID() {
	fail("stub method not implemented");
	return 0;
    }

    @Override
    public Class<?> getContainerClass() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public boolean isContainment() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setContainment(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean isContainer() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public boolean isResolveProxies() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setResolveProxies(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public EReference getEOpposite() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void setEOpposite(EReference value) {
	fail("stub method not implemented");
	
    }

    @Override
    public EClass getEReferenceType() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EAttribute> getEKeys() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public boolean isAbstract() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setAbstract(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public boolean isInterface() {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public void setInterface(boolean value) {
	fail("stub method not implemented");
	
    }

    @Override
    public EList<EClass> getESuperTypes() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EClass> getEAllSuperTypes() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EAttribute getEIDAttribute() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EStructuralFeature> getEStructuralFeatures() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EGenericType> getEGenericSuperTypes() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EGenericType> getEAllGenericSuperTypes() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EAttribute> getEAttributes() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EAttribute> getEAllAttributes() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EReference> getEReferences() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EReference> getEAllReferences() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EReference> getEAllContainments() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EStructuralFeature> getEAllStructuralFeatures() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EOperation> getEOperations() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<EOperation> getEAllOperations() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public boolean isSuperTypeOf(EClass someClass) {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public int getFeatureCount() {
	fail("stub method not implemented");
	return 0;
    }

    @Override
    public EStructuralFeature getEStructuralFeature(int featureID) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EStructuralFeature getEStructuralFeature(String featureName) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public int getOperationCount() {
	fail("stub method not implemented");
	return 0;
    }

    @Override
    public EOperation getEOperation(int operationID) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public int getOperationID(EOperation operation) {
	fail("stub method not implemented");
	return 0;
    }

    @Override
    public EOperation getOverride(EOperation operation) {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public int getFeatureID(EStructuralFeature feature) {
	fail("stub method not implemented");
	return 0;
    }

    @Override
    public String getInstanceClassName() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void setInstanceClassName(String value) {
	fail("stub method not implemented");
	
    }

    @Override
    public Class<?> getInstanceClass() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void setInstanceClass(Class<?> value) {
	fail("stub method not implemented");
	
    }

    @Override
    public Object getDefaultValue() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public String getInstanceTypeName() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public void setInstanceTypeName(String value) {
	fail("stub method not implemented");
	
    }

    @Override
    public EPackage getEPackage() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public EList<ETypeParameter> getETypeParameters() {
	fail("stub method not implemented");
	return null;
    }

    @Override
    public boolean isInstance(Object object) {
	fail("stub method not implemented");
	return false;
    }

    @Override
    public int getClassifierID() {
	fail("stub method not implemented");
	return 0;
    }

    
    
}
