/**
 * <copyright>
 * 
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CollectionLiteralExpOperations.java,v 1.2 2008/04/27 23:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Collection Literal Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#checkNoCollectionInstances(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check No Collection Instances</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#checkSetKind(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Set Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#checkSequenceKind(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Sequence Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#checkBagKind(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Bag Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#checkElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralExpOperations {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CollectionLiteralExpOperations() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * kind <> CollectionKind::Collection
     * @param collectionLiteralExp The receiving '<em><b>Collection Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C> boolean checkNoCollectionInstances(CollectionLiteralExp<C> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = collectionLiteralExp.getKind() != CollectionKind.COLLECTION_LITERAL;
    	
        if (!result) {
            if (diagnostics != null) {
            	// TODO: Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.COLLECTION_LITERAL_EXP__NO_COLLECTION_INSTANCES,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkNoCollectionInstances", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionLiteralExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * kind = CollectionKind::Set implies type.oclIsKindOf(SetType)
     * @param collectionLiteralExp The receiving '<em><b>Collection Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C> boolean checkSetKind(CollectionLiteralExp<C> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	CollectionKind kind = collectionLiteralExp.getKind();
    	boolean result = (kind != CollectionKind.SET_LITERAL)
    			|| TypesPackage.Literals.SET_TYPE.isInstance(collectionLiteralExp.getType());
    	
        if (!result) {
            if (diagnostics != null) {
            	// TODO: Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.COLLECTION_LITERAL_EXP__SET_KIND,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkSetKind", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionLiteralExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * kind = CollectionKind::Sequence implies type.oclIsKindOf(SequenceType)
     * @param collectionLiteralExp The receiving '<em><b>Collection Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C> boolean checkSequenceKind(CollectionLiteralExp<C> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	CollectionKind kind = collectionLiteralExp.getKind();
    	boolean result = (kind != CollectionKind.SEQUENCE_LITERAL)
    			|| TypesPackage.Literals.SEQUENCE_TYPE.isInstance(collectionLiteralExp.getType());
    	
        if (!result) {
            if (diagnostics != null) {
            	// TODO: Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.COLLECTION_LITERAL_EXP__SEQUENCE_KIND,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkSequenceKind", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionLiteralExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * kind = CollectionKind::Bag implies type.oclIsKindOf(BagType)
     * @param collectionLiteralExp The receiving '<em><b>Collection Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C> boolean checkBagKind(CollectionLiteralExp<C> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	CollectionKind kind = collectionLiteralExp.getKind();
    	boolean result = (kind != CollectionKind.BAG_LITERAL)
    			|| TypesPackage.Literals.BAG_TYPE.isInstance(collectionLiteralExp.getType());
    	
        if (!result) {
            if (diagnostics != null) {
            	// TODO: Specific message
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.COLLECTION_LITERAL_EXP__BAG_KIND,
                         org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkBagKind", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(collectionLiteralExp, context) }), //$NON-NLS-1$ //$NON-NLS-2$
                         new Object [] { collectionLiteralExp }));
            }
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type.oclAsType(CollectionType).elementType = part->iterate(p; c : Classifier = OclVoid | c.commonSuperType(p.type))
     * @param collectionLiteralExp The receiving '<em><b>Collection Literal Exp</b></em>' model object.
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @generated NOT
     */
    public static <C> boolean checkElementType(CollectionLiteralExp<C> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	String message = null;
    	Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(collectionLiteralExp, context);
		
		if (env != null) {
			C type = collectionLiteralExp.getType();
			
			if (type instanceof CollectionType) {
				@SuppressWarnings("unchecked")
				CollectionType<C, ?> ctype = (CollectionType<C, ?>) type;
				List<CollectionLiteralPart<C>> parts = collectionLiteralExp.getPart();
				
				if (parts.isEmpty()) {
					if (!(ctype.getElementType() instanceof VoidType)) {
						result = false;
						message = OCLMessages.bind(
								OCLMessages.TypeConformanceEmptyCollection_ERROR_,
								collectionLiteralExp.toString());
		            }
				} else {
					C partsType = parts.get(0).getType();
	
					for (CollectionLiteralPart<C> part : parts) {
			            partsType = TypeUtil.commonSuperType(null, env, partsType, part.getType());
					}
			        
					if ((partsType == null)
							|| !TypeUtil.exactTypeMatch(env, partsType, ctype
									.getElementType())) {
						result = false;
						message = OCLMessages
								.bind(
										OCLMessages.TypeConformanceCollectionElementType_ERROR_,
										collectionLiteralExp.toString());
					}
				}
			}
		}

        if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.COLLECTION_LITERAL_EXP__ELEMENT_TYPE,
                         message,
                         new Object [] { collectionLiteralExp }));
            }
        }
        return result;
    }

} // CollectionLiteralExpOperations