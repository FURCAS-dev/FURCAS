package de.hpi.sam.bp2009.solution.impactAnalyzer.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

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
    /**
     * Constructor of the {@link AnnotatedEObject}.
     * 
     * @param annotatedObject the EObject to annotate
     * @param annotation an annotationString, assumed to be "" if omitted
     * @param stackToCopy a stack of EStructuralFeatures that identify the tuple literals used up to this point of the OCL Expression, assumed to be an empty stack if omitted
     */
    public AnnotatedEObject(EObject annotatedObject){
        this(annotatedObject, "");
    }

    /**
     * Constructor of the {@link AnnotatedEObject}.
     * 
     * @param annotatedObject the EObject to annotate
     * @param annotation an annotationString, assumed to be "" if omitted
     * @param stackToCopy a stack of EStructuralFeatures that identify the tuple literals used up to this point of the OCL Expression, assumed to be an empty stack if omitted
     */
    public AnnotatedEObject(EObject annotatedObject, Stack<String> stackToCopy){
        this(annotatedObject, "");
    }
    
    public String getAnnotation(){
        return annotation;
    }
    
    public EObject getAnnotatedObject(){
        return eObject;
    }
    
    @Override
    public TreeIterator<EObject> eAllContents() {
        return eObject.eAllContents();
    }

    @Override
    public EClass eClass() {
        return eObject.eClass();
    }

    @Override
    public EObject eContainer() {
        return eObject.eContainer();
    }

    @Override
    public EStructuralFeature eContainingFeature() {
        return eObject.eContainingFeature();
    }

    @Override
    public EReference eContainmentFeature() {
        return eObject.eContainmentFeature();
    }

    @Override
    public EList<EObject> eContents() {
        return eObject.eContents();
    }

    @Override
    public EList<EObject> eCrossReferences() {
        return eObject.eCrossReferences();
    }

    @Override
    public Object eGet(EStructuralFeature feature) {
        return eObject.eGet(feature);
    }

    @Override
    public Object eGet(EStructuralFeature feature, boolean resolve) {
        return eObject.eGet(feature, resolve);
    }

    @Override
    public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
        return eObject.eInvoke(operation, arguments);
    }

    @Override
    public boolean eIsProxy() {
        return eObject.eIsProxy();
    }

    @Override
    public boolean eIsSet(EStructuralFeature feature) {
        return eObject.eIsSet(feature);
    }

    @Override
    public Resource eResource() {
        return eObject.eResource();
    }

    @Override
    public void eSet(EStructuralFeature feature, Object newValue) {
        eObject.eSet(feature, newValue);
    }

    @Override
    public void eUnset(EStructuralFeature feature) {
        eObject.eUnset(feature);        
    }

    @Override
    public EList<Adapter> eAdapters() {
        return eObject.eAdapters();
    }

    @Override
    public boolean eDeliver() {
        return eObject.eDeliver();
    }

    @Override
    public void eNotify(Notification notification) {
        eObject.eNotify(notification);
    }

    @Override
    public void eSetDeliver(boolean deliver) {
        eObject.eSetDeliver(deliver);
    }
    
    @Override
    public String toString() {
        return super.toString() + " (annotatedObject: " + eObject.toString() + ") (annotation: " + annotation + ")";
    }
}
