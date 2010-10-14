/**
 * <copyright>
 * 
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLInvocationDelegate.java,v 1.2 2010/04/08 06:27:21 ewillink Exp $
 */
package de.hpi.sam.bp2009.solution.oclToAst.delegate;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.DelegateResourceAdapter;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.OCLDelegateException;
import org.eclipse.ocl.ecore.delegate.OCLInvocationDelegate;
import org.eclipse.osgi.util.NLS;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider;

/**
 * An implementation of an operation-invocation delegate for OCL body expressions.
 * 
 * @since 3.0
 */
public class OCLInvocationDelegateForAnnotations extends OCLInvocationDelegate {
    private OCLExpression body;
    private ValueConverter converter;
    final private OCL ocl;

    public OCLInvocationDelegateForAnnotations(OCLDelegateDomain delegateDomain, EOperation operation) {
        super(delegateDomain, operation);
        this.converter = operation.isMany() ? ValueConverter.LIST : ValueConverter.VERBATIM;
        ocl = createOclWithOclAstEnvironment(operation);
    }

    private OCL createOclWithOclAstEnvironment(EOperation operation) {
        EPackage ePackage = (EPackage) ((EClass) operation.eContainer()).eContainer();
        Resource res = ePackage.eResource();
        ResourceSet resourceSet = res.getResourceSet();
        OclAstEcoreEnvironmentFactory envFactory;
        if (res != null && resourceSet != null) {
            // it's a dynamic package. Use the local package registry
            EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
            envFactory = new OclAstEcoreEnvironmentFactory(packageRegistry, new Query2OppositeEndFinder(
                    new ProjectDependencyQueryContextProvider()));
            DelegateResourceAdapter.getAdapter(res);
        } else {
            // the shared instance uses the static package registry
            envFactory = new OclAstEcoreEnvironmentFactory(new Query2OppositeEndFinder(
                    new ProjectDependencyQueryContextProvider()));;
        }
        return OCLWithHiddenOpposites.newInstance(envFactory);
    }

    @Override
    public Object dynamicInvoke(InternalEObject target, EList<?> arguments) throws InvocationTargetException {
        if (body == null) {
            body = InvocationBehaviorForAnnotations.INSTANCE.getOperationBody(ocl, eOperation);
        }
        /*
         * call super behaviour if not able to resolve annotation
         */
        if (body == null) {
            Object res;
            System.err.println(EAnnotationOCLParser.MISSING_BODY_FOR_INVOCATION_DELEGATE + eOperation.getName() + " . "
                    + EAnnotationOCLParser.EXPRESSION_NOT_FOUND);
            if (EcoreUtil.getAnnotation(eOperation, OCLDelegateDomain.OCL_DELEGATE_URI, InvocationBehavior.BODY_CONSTRAINT_KEY) == null) {
                EcoreUtil.setAnnotation(eOperation, OCLDelegateDomain.OCL_DELEGATE_URI, InvocationBehavior.BODY_CONSTRAINT_KEY,
                        EcoreUtil.getAnnotation(eOperation, EAnnotationOCLParser.ANNOTATION_SOURCE,
                                InvocationBehavior.BODY_CONSTRAINT_KEY));
                res = trySuperOrMethodCall(target, arguments);
                eOperation.getEAnnotations().remove(eOperation.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI));
            } else {
                res = trySuperOrMethodCall(target, arguments);            }
            return res;
            // throw new IllegalArgumentException(EAnnotationOCLParser.MISSING_BODY_FOR_INVOCATION_DELEGATE + eOperation.getName()
            // +" . "+ EAnnotationOCLParser.EXPRESSION_NOT_FOUND);
        }

        OCL.Query query = ocl.createQuery(body);
        EList<EParameter> parms = eOperation.getEParameters();

        if (!parms.isEmpty()) {
            // bind arguments to parameter names
            EvaluationEnvironment<EClassifier, ?, ?, ?, ?> env = query.getEvaluationEnvironment();

            for (int i = 0; i < parms.size(); i++) {
                env.add(parms.get(i).getName(), arguments.get(i));
            }
        }
        Object result = query.evaluate(target);
        if (ocl.isInvalid(result)) {
            String message = NLS.bind("OCL evaluation result of ''{0}'' is invalid", getOperationName());
            throw new OCLDelegateException(message);
        }
        return converter.convert(ocl, result);
    }

    private Object trySuperOrMethodCall(InternalEObject target, EList<?> arguments) throws InvocationTargetException {
        Object res;
        try{
            res = super.dynamicInvoke(target, arguments);
        }catch(OCLDelegateException e){
            /*
             * ultimate fallback, the method itself
             */
            res = target.eInvoke(eOperation, arguments);
        }
        return res;
    }

}
