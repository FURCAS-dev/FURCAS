package de.hpi.sam.bp2009.solution.impactAnalyzer.util;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Constraint;
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
        while (parent != null && !(parent instanceof Constraint) && !(parent instanceof EAnnotation)) {
            x = parent;
            parent = (EObject) x.eContainer();
        }
        if (x instanceof OCLExpression) {
            return (OCLExpression) x;
        }
        throw new IllegalArgumentException();
    }
    
    
}
