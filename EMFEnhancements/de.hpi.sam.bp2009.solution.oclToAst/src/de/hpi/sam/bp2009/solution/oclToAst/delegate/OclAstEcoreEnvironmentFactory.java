/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EMF_codetemplates.xml,v 1.1 2008/05/06 20:12:20 nickb Exp $
 */
package de.hpi.sam.bp2009.solution.oclToAst.delegate;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;

import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.oclToAst.OclAstEvaluationVisitor;

public class OclAstEcoreEnvironmentFactory extends EcoreEnvironmentFactoryWithHiddenOpposites {
    public static OclAstEcoreEnvironmentFactory INSTANCE = new OclAstEcoreEnvironmentFactory();

    public OclAstEcoreEnvironmentFactory() {
        super();
    }
    
    public OclAstEcoreEnvironmentFactory(EPackage.Registry reg) {
        super(reg);
    }

    public OclAstEcoreEnvironmentFactory(EPackage.Registry reg, OppositeEndFinder oppositeEndFinder) {
        super(reg, oppositeEndFinder);
    }
    
    public OclAstEcoreEnvironmentFactory(OppositeEndFinder oppositeEndFinder) {
        super(oppositeEndFinder);
    }
    
    @Override
    public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
        return new OclAstEvaluationVisitor(env, evalEnv, extentMap);
    }

}
