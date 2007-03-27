/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompatibilityUtil.java,v 1.3 2007/03/27 15:05:42 cdamus Exp $
 */

package org.eclipse.emf.ocl.internal.parser;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.types.ElementType;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.TypedElement;
import org.eclipse.emf.ocl.uml.UMLPackage;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.emf.ocl.utilities.Visitable;
import org.eclipse.ocl.ecore.AnyType;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * @author cdamus
 *
 */
public class CompatibilityUtil {
	
	private CompatibilityUtil() {
		super();
	}

	public static Environment getCompatibilityEnvironment(
			org.eclipse.ocl.Environment<
				EPackage, EClassifier, EOperation, EStructuralFeature,
				EEnumLiteral, EParameter,
				EObject, CallOperationAction, SendSignalAction, Constraint,
				EClass, EObject> environment) {
		if (environment instanceof CompatibilityEnvironment) {
			// just extract the old-style environment that it wraps
			return ((CompatibilityEnvironment) environment).getOldStyle();
		} else {
			return new ReverseCompatibilityEnvironment(environment);
		}
	}

	public static org.eclipse.ocl.Environment<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter,
		EObject, CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject>
	getCompatibilityEnvironment(
			org.eclipse.ocl.Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
			Environment environment,
			org.eclipse.ocl.EnvironmentFactory<
				EPackage, EClassifier, EOperation, EStructuralFeature,
				EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
				EClass, EObject> factory) {
		return new CompatibilityEnvironment(parent, environment, factory);
	}

	public static org.eclipse.ocl.EnvironmentFactory<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject>
	getCompatibilityFactory(EnvironmentFactory factory) {
		
		return new CompatibilityEnvironmentFactory(factory);
	}
	
	public static EOperation getOldOperation(
			EOperation oper,
			EClassifier oldOwner,
			EClassifier newOwner) {
		
		EOperation result = oper;
		
		if (newOwner instanceof org.eclipse.ocl.utilities.PredefinedType) {
			// find corresponding pre-defined operation
			for (Object o : ((org.eclipse.emf.ocl.utilities.PredefinedType) oldOwner).getOperations()) {
				EOperation next = (EOperation) o;
				
				if (next.getName().equals(oper.getName()) &&
						matchParms(next, oper)) {
					result = next;
					break;
				}
			}
		} else {
			// maybe it's an OclAny-defined operation?
			OCLStandardLibrary<EClassifier> stdlib =
				EcoreEnvironmentFactory.INSTANCE.createEnvironment().getOCLStandardLibrary();
			
			for (Object o : Types.OCL_ANY_TYPE.getOperations()) {
				EOperation next = (EOperation) o;
				
				if (next.getName().equals(oper.getName()) &&
						matchParms(next, oper)) {
					result = next;
					break;
				}
			}
		}
		
		return result;
	}
	
	public static EOperation getNewOperation(
			EOperation oper,
			EClassifier newOwner,
			EClassifier oldOwner) {
		
		EOperation result = oper;
		
		if (oldOwner instanceof org.eclipse.emf.ocl.utilities.PredefinedType) {
			// find corresponding pre-defined operation
			for (EOperation next : ((org.eclipse.ocl.utilities.PredefinedType<EOperation>) newOwner).oclOperations()) {
				if (next.getName().equals(oper.getName()) &&
						matchParms(next, oper)) {
					result = next;
					break;
				}
			}
		} else {
			// maybe it's an OclAny-defined operation?
			OCLStandardLibrary<EClassifier> stdlib =
				EcoreEnvironmentFactory.INSTANCE.createEnvironment().getOCLStandardLibrary();
			AnyType anyType = (AnyType) stdlib.getOclAny();
			
			for (EOperation next : anyType.oclOperations()) {
				if (next.getName().equals(oper.getName()) &&
						matchParms(next, oper)) {
					result = next;
					break;
				}
			}
		}
		
		return result;
	}
	
	static boolean matchParms(EOperation oper1, EOperation oper2) {
		EList<EParameter> parms1 = oper1.getEParameters();
		EList<EParameter> parms2 = oper2.getEParameters();
		int count = parms1.size();
		
		boolean result = count == parms2.size();
		
		if (result) {
			for (int i = 0; result && i < count; i++) {
				// for the predefined operations, it is enough to compare
				//    parameter names
				result = parms1.get(i).getName().equals(parms2.get(i).getName());
			}
		}
		
		return result;
	}
	
	public static EList<EObject> getOldAS(Environment env, List<? extends EObject> astNodes) {
		EList<EObject> result = new BasicEList<EObject>(astNodes.size());
		
		for (EObject astNode : astNodes) {
			result.add(getOldAS(env, astNode));
		}
		
		return result;
	}
	
	public static EList<EObject> getNewAS(Environment env, List<? extends EObject> astNodes) {
		EList<EObject> result = new BasicEList<EObject>(astNodes.size());
		
		for (EObject astNode : astNodes) {
			result.add(getNewAS(env, astNode));
		}
		
		return result;
	}
	
	public static EObject getOldAS(Environment env, EObject astNode) {
		if (astNode == null) {
			return null;
		}
		
		AbstractSyntaxBridge bridge = (AbstractSyntaxBridge) EcoreUtil.getExistingAdapter(
				astNode, AbstractSyntaxBridge.class);
		if (bridge != null) {
			return bridge.getOldAS();
		}
		
		EObject result;
		
		if (astNode instanceof Constraint) {
			result = (EObject) ToOldASVisitor.getInstance(env).visitConstraint(
					(Constraint) astNode);
		} else if (astNode instanceof org.eclipse.ocl.utilities.Visitable) {
			result = (EObject) ((org.eclipse.ocl.utilities.Visitable) astNode)
				.accept(ToOldASVisitor.getInstance(env));
		} else if (astNode instanceof CallOperationAction) {
			result = ToOldASVisitor.getInstance(env).visitCallOperationAction(
					(CallOperationAction) astNode);
		} else if (astNode instanceof SendSignalAction) {
			result = ToOldASVisitor.getInstance(env).visitSendSignalAction(
					(SendSignalAction) astNode);
		} else if (astNode instanceof org.eclipse.ocl.utilities.PredefinedType
				|| astNode instanceof org.eclipse.ocl.types.ElementType) {
            
            EClassifier type = (EClassifier) astNode;
            if (PrimitiveType.UNLIMITED_NATURAL_NAME.equals(type.getName())) {
                // return the Integer type directly, because we can't have
                //    two different new types adapting to the same old type
                return Types.OCL_INTEGER;
            }
            
			result = ToOldASVisitor.getInstance(env).visitPredefinedType(
					(EClassifier) astNode);
		} else if (astNode instanceof org.eclipse.ocl.expressions.CollectionItem) {
			result = ToOldASVisitor.getInstance(env).visitCollectionItem(
					(org.eclipse.ocl.expressions.CollectionItem<EClassifier>) astNode);
		} else if (astNode instanceof org.eclipse.ocl.expressions.CollectionRange) {
			result = ToOldASVisitor.getInstance(env).visitCollectionRange(
					(org.eclipse.ocl.expressions.CollectionRange<EClassifier>) astNode);
		} else {
			// all other elements represent themselves
			result = astNode;
		}
		
		if (result != astNode) {
			AbstractSyntaxBridge.link(result, astNode, env);
		}
		
		return result;
	}
	
	public static EObject getNewAS(Environment env, EObject astNode) {
		if (astNode == null) {
			return null;
		}
		
		AbstractSyntaxBridge bridge = (AbstractSyntaxBridge) EcoreUtil.getExistingAdapter(
				astNode, AbstractSyntaxBridge.class);
		if (bridge != null) {
			return bridge.getNewAS();
		}
		
		EObject result;
		
		if (astNode instanceof org.eclipse.emf.ocl.uml.Constraint) {
			result = (EObject) ToNewASVisitor.getInstance(env).visitConstraint(
					(org.eclipse.emf.ocl.uml.Constraint) astNode);
		} else if (astNode instanceof Visitable) {
			result = (EObject) ((Visitable) astNode).accept(ToNewASVisitor.getInstance(env));
		} else if (astNode instanceof org.eclipse.emf.ocl.uml.CallOperationAction) {
			result = ToNewASVisitor.getInstance(env).visitCallOperationAction(
					(org.eclipse.emf.ocl.uml.CallOperationAction) astNode);
		} else if (astNode instanceof org.eclipse.emf.ocl.uml.SendSignalAction) {
			result = ToNewASVisitor.getInstance(env).visitSendSignalAction(
					(org.eclipse.emf.ocl.uml.SendSignalAction) astNode);
		} else if (astNode instanceof PredefinedType || astNode instanceof ElementType) {
			result = ToNewASVisitor.getInstance(env).visitPredefinedType(
					(EClassifier) astNode);
		} else if (astNode instanceof CollectionItem) {
			result = ToNewASVisitor.getInstance(env).visitCollectionItem(
					(CollectionItem) astNode);
		} else if (astNode instanceof CollectionRange) {
			result = ToNewASVisitor.getInstance(env).visitCollectionRange(
					(CollectionRange) astNode);
		} else {
			// all other elements represent themselves
			result = astNode;
		}
		
		if (result != astNode) {
			AbstractSyntaxBridge.link(astNode, result, env);
		}
		
		return result;
	}
	
	private static class AbstractSyntaxBridge extends AdapterImpl {
		private EObject oldAS;
		private EObject newAS;
		private Environment env;
		
		@Override
		public boolean isAdapterForType(Object type) {
			return type == AbstractSyntaxBridge.class;
		}
		
		static void link(EObject oldAS, EObject newAS, Environment env) {
			AbstractSyntaxBridge bridge = new AbstractSyntaxBridge(oldAS, newAS, env);
			
			oldAS.eAdapters().add(bridge);
			newAS.eAdapters().add(bridge);
			
			if (newAS instanceof Constraint) {
				// listen for changes also on the new ExpressionInOCL object
				ExpressionInOCL specification = 
					(ExpressionInOCL) ((Constraint) newAS).getSpecification();
				if (specification != null) {
					specification.eAdapters().add(bridge);
				}
			}
		}
		
		private AbstractSyntaxBridge(EObject oldAS, EObject newAS, Environment env) {
			this.oldAS = oldAS;
			this.newAS = newAS;
			
			this.env = env;
		}
		
		EObject getOldAS() {
			return oldAS;
		}
		
		EObject getNewAS() {
			return newAS;
		}
		
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) {
				return;
			}
			
			Object feature = msg.getFeature();
			Object notifier = msg.getNotifier();
			
			if (notifier == getNewAS() &&
					(feature == EcorePackage.Literals.ETYPED_ELEMENT__ETYPE
					|| feature == EcorePackage.Literals.ENAMED_ELEMENT__NAME)) {
				// the inferred type of a Variable is set after the variable
				//   is created in the environment and copied to the old/new
				//   syntax
				ToOldASVisitor.getInstance(env).copyTypedElement(
						(org.eclipse.ocl.utilities.TypedElement<EClassifier>) getNewAS(),
						(TypedElement) getOldAS());
			} else if ((notifier instanceof TypedElement) && (notifier == getOldAS()) &&
					(feature == UMLPackage.Literals.TYPED_ELEMENT__TYPE
					|| feature == EcorePackage.Literals.ENAMED_ELEMENT__NAME)) {
				// the inverse case
				ToNewASVisitor.getInstance(env).copyTypedElement(
						(TypedElement) getOldAS(),
						(org.eclipse.ocl.utilities.TypedElement<EClassifier>) getNewAS());
			} else if (feature == TypesPackage.Literals.COLLECTION_TYPE__ELEMENT_TYPE) {
				// likewise, the element type of a collection literal is set to the
				//   common super type of its parts after it has already been
				//   assigned a collection type
				if (notifier == getNewAS()) {
					ToOldASVisitor.getInstance(env).copyCollectionType(
							(CollectionType) getNewAS(),
							(org.eclipse.emf.ocl.types.CollectionType) getOldAS());
				}
			} else if (feature == org.eclipse.emf.ocl.types.TypesPackage.Literals.COLLECTION_TYPE__ELEMENT_TYPE) {
				// the inverse case
				if (notifier == getOldAS()) {
					ToNewASVisitor.getInstance(env).copyCollectionType(
							(org.eclipse.emf.ocl.types.CollectionType) getOldAS(),
							(CollectionType) getNewAS());
				}
			} else if (feature == UtilitiesPackage.Literals.AST_NODE__END_POSITION
					|| feature == UtilitiesPackage.Literals.AST_NODE__START_POSITION) {
				ToOldASVisitor.getInstance(env).copyASTNode(
						(org.eclipse.ocl.utilities.ASTNode) getNewAS(),
						(ASTNode) getOldAS());
			} else if (feature == UtilitiesPackage.Literals.TYPED_AST_NODE__TYPE_END_POSITION
					|| feature == UtilitiesPackage.Literals.TYPED_AST_NODE__TYPE_START_POSITION) {
				ToOldASVisitor.getInstance(env).copyTypedASTNode(
						(org.eclipse.ocl.utilities.TypedASTNode) getNewAS(),
						(TypedASTNode) getOldAS());
			} else if (notifier instanceof Constraint && notifier == getNewAS()) {
				ToOldASVisitor.getInstance(env).copyConstraint(
						(Constraint) getNewAS(),
						(org.eclipse.emf.ocl.uml.Constraint) getOldAS());
			} else if (feature == UtilitiesPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION
					&& ((ExpressionInOCL) notifier).eContainer() == getNewAS()) {
				// definition constraints are constructed before their bodies
				//   are set, to support recursive definitions
				ToOldASVisitor.getInstance(env).copyConstraint(
						(Constraint) getNewAS(),
						(org.eclipse.emf.ocl.uml.Constraint) getOldAS());
			}
		}
	}
}
