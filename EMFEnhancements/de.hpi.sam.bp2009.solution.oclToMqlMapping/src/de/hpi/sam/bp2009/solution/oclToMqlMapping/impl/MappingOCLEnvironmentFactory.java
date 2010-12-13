/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

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
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

public class MappingOCLEnvironmentFactory extends EcoreEnvironmentFactory {
    public static MappingOCLEnvironmentFactory INSTANCE = new MappingOCLEnvironmentFactory();

    /**
     * Initializes me. Environments that I create will use the global package registry to look up packages.
     */
    public MappingOCLEnvironmentFactory() {
        super();
    }

    /**
     * Initializes me with an <code>EPackage.Registry</code> that the environments I create will use to look up packages. As a
     * finder for "hidden opposites" based on name annotations on the forward references for the non-existing opposite's name a
     * <code>DefaultOppositeEndFinder</code> will be used. To not look for those annotations at all, use
     * {@link #EcoreEnvironmentFactory(org.eclipse.emf.ecore.EPackage.Registry, OppositeEndFinder)} and pass <code>null</code> for
     * the <code>OppositeEndFinder</code> argument.
     * 
     * @param reg
     *            my package registry (must not be <code>null</code>)
     */
    public MappingOCLEnvironmentFactory(EPackage.Registry reg) {
        super(reg);
    }

    @Override
    public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
        return new MappingEvaluationVisitor(env, evalEnv, extentMap);
    }

}
