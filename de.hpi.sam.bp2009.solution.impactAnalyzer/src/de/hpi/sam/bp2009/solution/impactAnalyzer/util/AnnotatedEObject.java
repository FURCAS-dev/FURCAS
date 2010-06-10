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
    private final EObject refObject;
    
    /**
     * Constructor of the {@link AnnotatedEObject}.
     * 
     * @param annotatedObject the EObject to annotate
     * @param annotation an annotationString, assumed to be "" if omitted
     */
    public AnnotatedEObject(EObject annotatedObject, String annotation){
        this.refObject = annotatedObject;
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
        return refObject;
    }
    
    @Override
    public TreeIterator<EObject> eAllContents() {
        return refObject.eAllContents();
    }

    @Override
    public EClass eClass() {
        return refObject.eClass();
    }

    @Override
    public EObject eContainer() {
        return refObject.eContainer();
    }

    @Override
    public EStructuralFeature eContainingFeature() {
        return refObject.eContainingFeature();
    }

    @Override
    public EReference eContainmentFeature() {
        return refObject.eContainmentFeature();
    }

    @Override
    public EList<EObject> eContents() {
        return refObject.eContents();
    }

    @Override
    public EList<EObject> eCrossReferences() {
        return refObject.eCrossReferences();
    }

    @Override
    public Object eGet(EStructuralFeature feature) {
        return refObject.eGet(feature);
    }

    @Override
    public Object eGet(EStructuralFeature feature, boolean resolve) {
        return refObject.eGet(feature, resolve);
    }

    @Override
    public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
        return refObject.eInvoke(operation, arguments);
    }

    @Override
    public boolean eIsProxy() {
        return refObject.eIsProxy();
    }

    @Override
    public boolean eIsSet(EStructuralFeature feature) {
        return refObject.eIsSet(feature);
    }

    @Override
    public Resource eResource() {
        return refObject.eResource();
    }

    @Override
    public void eSet(EStructuralFeature feature, Object newValue) {
        refObject.eSet(feature, newValue);
    }

    @Override
    public void eUnset(EStructuralFeature feature) {
        refObject.eUnset(feature);        
    }

    @Override
    public EList<Adapter> eAdapters() {
        return refObject.eAdapters();
    }

    @Override
    public boolean eDeliver() {
        return refObject.eDeliver();
    }

    @Override
    public void eNotify(Notification notification) {
        refObject.eNotify(notification);
    }

    @Override
    public void eSetDeliver(boolean deliver) {
        refObject.eSetDeliver(deliver);
    }
    
    @Override
    public String toString() {
        return super.toString() + " (annotatedObject: " + refObject.toString() + ") (annotation: " + annotation + ")";
    }
}
