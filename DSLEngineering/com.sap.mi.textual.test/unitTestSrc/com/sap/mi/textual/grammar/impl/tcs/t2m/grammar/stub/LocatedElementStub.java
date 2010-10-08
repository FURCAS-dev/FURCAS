/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.sap.furcas.metamodel.TCS.LocatedElement;
import com.sap.furcas.metamodel.TCS.Value;


/**
 *
 */
public class LocatedElementStub  implements LocatedElement, Value {

    public String representation;
    
    private String loc;
    private EList<String> cb;
    private EList<String> ca;
    
    /**
     * 
     */
    public LocatedElementStub() {
        super();
        String id = this.toString() + Math.random();
    }

    /* (non-Javadoc)
     * @see TCS.LocatedElement#getCommentsAfter()
     */
    @Override
    public EList<String> getCommentsAfter() {
        return ca;
    }

    /* (non-Javadoc)
     * @see TCS.LocatedElement#getCommentsBefore()
     */
    @Override
    public EList<String> getCommentsBefore() {
        // TODO Auto-generated method stub
        return cb;
    }

    /* (non-Javadoc)
     * @see TCS.LocatedElement#getLocation()
     */
    @Override
    public String getLocation() {
        // TODO Auto-generated method stub
        return loc;
    }

    /* (non-Javadoc)
     * @see TCS.LocatedElement#setLocation(java.lang.String)
     */
    @Override
    public void setLocation(String value) {
        loc = value;
    }

    @Override
    public EClass eClass() {
	// TODO Auto-generated method stub
	return null;
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
    public String getName() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setName(String value) {
	// TODO Auto-generated method stub
	
    }

  
    

}
