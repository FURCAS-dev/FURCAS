package de.hpi.sam.bp2009.solution.oclToAst.delegate;



import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.OCLDelegateException;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

/**
 * @since 3.0
 */
public class SettingBehaviorForAnnotations extends org.eclipse.ocl.ecore.delegate.SettingBehavior
{
    public static final SettingBehaviorForAnnotations INSTANCE = new SettingBehaviorForAnnotations();
    EAnnotationOCLParser parser= OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();

    public OCLExpression getFeatureBody(OCL ocl, EStructuralFeature structuralFeature) {
        String expr = EcoreUtil.getAnnotation(structuralFeature, OCLDelegateDomain.OCL_DELEGATE_URI, DERIVATION_CONSTRAINT_KEY);
        if (expr == null) {
            expr = EcoreUtil.getAnnotation(structuralFeature, OCLDelegateDomain.OCL_DELEGATE_URI, INITIAL_CONSTRAINT_KEY);
            if (expr == null) {
                return null;
            }
        }
        EClass context = structuralFeature.getEContainingClass();
        OCL.Helper helper = ocl.createOCLHelper();
        helper.setAttributeContext(context, structuralFeature);
        Constraint constraint;
        try {
            constraint = helper.createDerivedValueExpression(expr);
        } catch (ParserException e) {
            throw new OCLDelegateException(e.getLocalizedMessage(), e);
        }
        if (constraint == null) {
            return null;
        }
        ExpressionInOCL specification = (ExpressionInOCL) constraint.getSpecification();
        if (specification == null) {
            return null;
        }
        return (OCLExpression) specification.getBodyExpression();
    }

    public String getName() {
        return NAME;
    }

    public Class<SettingDelegate.Factory.Registry> getRegistryClass() {
        return SettingDelegate.Factory.Registry.class;
    }
}
