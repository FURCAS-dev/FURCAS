package de.hpi.sam.bp2009.solution.impactAnalyzer.util;

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
import org.eclipse.ocl.ecore.TupleLiteralExp;

/**
 * The AnnotatedEObject is a delegate of an {@link EObject} that adds support for {@link Sting} annotations.
 * Additionally it holds a {@link Stack<EStructuralFeature>} to enable the backtracking of {@link TupleLiteralExp}
 * 
 * @author martin.hanysz
 *
 */
public class AnnotatedEObject implements EObject{
    private final String annotation;
    private final EObject eObject;
    public final static String NOT_IN_DEBUG_MODE_MESSAGE = "To enable annotations, set the system property de.hpi.sam.bp2009.solution.impactAnalyzer.debug to true, "
        + "e.g., by using the VM argument -Dde.hpi.sam.bp2009.solution.impactAnalyzer.debug=true";
    public final static boolean IS_IN_DEBUG_MODE = Boolean.getBoolean("de.hpi.sam.bp2009.solution.impactAnalyzer.debug");

    public boolean equals(Object o) {
        if (o instanceof AnnotatedEObject) {
            return eObject.equals(((AnnotatedEObject) o).eObject);
        } else {
            return super.equals(o);
        }
    }
    
    public int hashCode() {
        return eObject.hashCode();
    }
    
    /**
     * Constructor of the {@link AnnotatedEObject}.
     * 
     * @param annotatedObject the EObject to annotate
     * @param annotation an annotationString, assumed to be "" if omitted
     */
    public AnnotatedEObject(EObject annotatedObject, String annotation){
        this.eObject = annotatedObject;
        this.annotation = annotation;
    }
    
    public String getAnnotation(){
        return annotation;
    }
    
    public EObject getAnnotatedObject(){
        return eObject;
    }
    
    public TreeIterator<EObject> eAllContents() {
        return eObject.eAllContents();
    }

    public EClass eClass() {
        return eObject.eClass();
    }

    public EObject eContainer() {
        return eObject.eContainer();
    }

    public EStructuralFeature eContainingFeature() {
        return eObject.eContainingFeature();
    }

    public EReference eContainmentFeature() {
        return eObject.eContainmentFeature();
    }

    public EList<EObject> eContents() {
        return eObject.eContents();
    }

    public EList<EObject> eCrossReferences() {
        return eObject.eCrossReferences();
    }

    public Object eGet(EStructuralFeature feature) {
        return eObject.eGet(feature);
    }

    public Object eGet(EStructuralFeature feature, boolean resolve) {
        return eObject.eGet(feature, resolve);
    }

    public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
        return eObject.eInvoke(operation, arguments);
    }

    public boolean eIsProxy() {
        return eObject.eIsProxy();
    }

    public boolean eIsSet(EStructuralFeature feature) {
        return eObject.eIsSet(feature);
    }

    public Resource eResource() {
        return eObject.eResource();
    }

    public void eSet(EStructuralFeature feature, Object newValue) {
        eObject.eSet(feature, newValue);
    }

    public void eUnset(EStructuralFeature feature) {
        eObject.eUnset(feature);        
    }

    public EList<Adapter> eAdapters() {
        return eObject.eAdapters();
    }

    public boolean eDeliver() {
        return eObject.eDeliver();
    }

    public void eNotify(Notification notification) {
        eObject.eNotify(notification);
    }

    public void eSetDeliver(boolean deliver) {
        eObject.eSetDeliver(deliver);
    }
    
    @Override
    public String toString() {
        return super.toString() + " (annotatedObject: " + eObject.toString() + ") (annotation: " + annotation + ")";
    }
}
