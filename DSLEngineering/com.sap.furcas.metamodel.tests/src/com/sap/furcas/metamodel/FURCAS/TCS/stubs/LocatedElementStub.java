/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Internal;


/**
 *
 */
public abstract class LocatedElementStub  implements InternalEObject {

    public String representation;
    
    private String loc;
    private EList<String> cb;
    private EList<String> ca;
    
    /**
     * 
     */
    public LocatedElementStub() {
        super();
    }

    @Override
    public Resource eResource() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public EObject eContainer() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public EStructuralFeature eContainingFeature() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public EReference eContainmentFeature() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public EList<EObject> eContents() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public TreeIterator<EObject> eAllContents() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean eIsProxy() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public EList<EObject> eCrossReferences() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object eGet(EStructuralFeature feature) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object eGet(EStructuralFeature feature, boolean resolve) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void eSet(EStructuralFeature feature, Object newValue) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public boolean eIsSet(EStructuralFeature feature) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void eUnset(EStructuralFeature feature) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public EList<Adapter> eAdapters() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean eDeliver() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void eSetDeliver(boolean deliver) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void eNotify(Notification notification) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public boolean eNotificationRequired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String eURIFragmentSegment(EStructuralFeature eFeature, EObject eObject) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EObject eObjectForURIFragmentSegment(String uriFragmentSegment) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void eSetClass(EClass eClass) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Setting eSetting(EStructuralFeature feature) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int eContainerFeatureID() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public NotificationChain eSetResource(Internal resource, NotificationChain notifications) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class<?> baseClass,
            NotificationChain notifications) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class<?> baseClass,
            NotificationChain notifications) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID,
            NotificationChain notifications) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NotificationChain eBasicRemoveFromContainer(NotificationChain notifications) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public URI eProxyURI() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void eSetProxyURI(URI uri) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public EObject eResolveProxy(InternalEObject proxy) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InternalEObject eInternalContainer() {
        return (InternalEObject) eContainer();
    }

    @Override
    public Internal eInternalResource() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Internal eDirectResource() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EStore eStore() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void eSetStore(EStore store) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void eUnset(int featureID) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean eIsSet(int featureID) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        // TODO Auto-generated method stub
        return null;
    }    

}
