package com.sap.emf.ocl.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCLExpression;

public class OclHelper {
    private static OclHelper instance = new OclHelper();
    
    public static OclHelper getInstance() {
        return instance;
    }

    public static OCLExpression getRootExpression(EObject x) {
        EObject parent = (EObject) x.eContainer();
        // The root expression could be contained in an Constraint or an EAnnotation. Therefore stop ascending
        // if parent is instance of a container type.
        while (parent != null && !(parent instanceof Constraint) && !(parent instanceof EAnnotation)
                && !(parent instanceof ExpressionInOCL)) {
            x = parent;
            parent = (EObject) x.eContainer();
        }
        if (x instanceof OCLExpression) {
            return (OCLExpression) x;
        }
        throw new IllegalArgumentException();
    }
    
    @SuppressWarnings("unchecked")
    public static Collection<Object> flatten(Object o) {
        Collection<Object> result;
        if (o instanceof Collection<?>) {
            if (((Collection<?>) o).isEmpty()) {
                result = (Collection<Object>) o;
            } else {
                result = new HashSet<Object>();
                for (Object subO : (Collection<?>) o) {
                    result.addAll(flatten(subO));
                }
            }
        } else {
            result = Collections.singleton(o);
        }
        return result;
    }

}
