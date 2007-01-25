/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: ToOldASVisitor.java,v 1.1 2007/01/25 18:34:32 cdamus Exp $
 */

package org.eclipse.emf.ocl.internal.parser;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.PersistentEnvironment;
import org.eclipse.emf.ocl.parser.TypeResolver;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.impl.CollectionTypeImpl;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.UMLFactory;
import org.eclipse.ocl.ecore.AnyType;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.ElementType;
import org.eclipse.ocl.ecore.InvalidType;
import org.eclipse.ocl.ecore.MessageType;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.ecore.VoidType;
import org.eclipse.ocl.ecore.util.EcoreSwitch;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NavigationCallExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PrimitiveLiteralExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitor;

/**
 * @author cdamus
 *
 */
final class ToOldASVisitor implements Visitor<EObject, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
	private EcoreSwitch<EClassifier> typesSwitch;
	private Environment env;
	private TypeResolver resolver;
	
	private ToOldASVisitor(Environment env) {
		this.env = env;
		
		if (env instanceof PersistentEnvironment) {
			resolver = ((PersistentEnvironment) env).getTypeResolver();
		}
	}
	
	static ToOldASVisitor getInstance(Environment env) {
		return new ToOldASVisitor(env);
	}
	
	void copyASTNode(ASTNode src, org.eclipse.emf.ocl.utilities.ASTNode dst) {
		dst.setStartPosition(src.getStartPosition());
		dst.setEndPosition(src.getEndPosition());
	}
	
	void copyTypedASTNode(TypedASTNode src, org.eclipse.emf.ocl.utilities.TypedASTNode dst) {
		dst.setTypeStartPosition(src.getTypeStartPosition());
		dst.setTypeEndPosition(src.getTypeEndPosition());
		
		copyASTNode(src, dst);
	}
	
	private void copyCallingASTNode(CallingASTNode src, org.eclipse.emf.ocl.utilities.CallingASTNode dst) {
		dst.setPropertyStartPosition(src.getPropertyStartPosition());
		dst.setPropertyEndPosition(src.getPropertyEndPosition());
		
		copyASTNode(src, dst);
	}
	
	void copyTypedElement(TypedElement<EClassifier> src, org.eclipse.emf.ocl.uml.TypedElement dst) {
		dst.setName(src.getName());
		dst.setType((EClassifier) CompatibilityUtil.getOldAS(env, src.getType()));
	}
	
	void copyCollectionType(CollectionType src, org.eclipse.emf.ocl.types.CollectionType dst) {
		dst.setElementType(
				(EClassifier) CompatibilityUtil.getOldAS(
						env, src.getElementType()));
	}
	
	void copyTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> src, org.eclipse.emf.ocl.expressions.TupleLiteralPart dst) {
		EStructuralFeature attribute = src.getAttribute();
		
		org.eclipse.emf.ocl.expressions.TupleLiteralExp tuple =
			(org.eclipse.emf.ocl.expressions.TupleLiteralExp) dst.eContainer();
		org.eclipse.emf.ocl.types.TupleType type =
			(org.eclipse.emf.ocl.types.TupleType) tuple.getType();
		
		for (EStructuralFeature p : type.getEStructuralFeatures()) {
			if (p.getName().equals(attribute.getName())) {
				dst.setAttribute(p);
				break;
			}
		}
	}
	
	void copyConstraint(Constraint src, org.eclipse.emf.ocl.uml.Constraint dst) {
		dst.setBody(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env,
						src.getSpecification().getBodyExpression()));
		
		dst.setName(src.getName());
		dst.setStereotype(src.getStereotype());
		
		ECollections.setEList(
				dst.getConstrainedElement(),
				src.getConstrainedElements());
	}
	
	private void copyNavigationCallExp(NavigationCallExp<EClassifier, EStructuralFeature> src, org.eclipse.emf.ocl.expressions.NavigationCallExp dst) {
		dst.setNavigationSource(src.getNavigationSource());
		
		for (OCLExpression<EClassifier> q : src.getQualifier()) {
			dst.getQualifier().add(CompatibilityUtil.getOldAS(env, q));
		}
		
		copyFeatureCallExp(src, dst);
	}
	
	private void copyFeatureCallExp(FeatureCallExp<EClassifier> src, org.eclipse.emf.ocl.expressions.FeatureCallExp dst) {
		dst.setMarkedPre(src.isMarkedPre());
		
		copyCallExp(src, dst);
	}
	
	private void copyCallExp(CallExp<EClassifier> src, org.eclipse.emf.ocl.expressions.CallExp dst) {
		dst.setSource((org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, src.getSource()));
		
		copyOCLExpression(src, dst);
		copyCallingASTNode(src, dst);
	}
	
	private void copyOCLExpression(OCLExpression<EClassifier> src, org.eclipse.emf.ocl.expressions.OCLExpression dst) {
		copyTypedElement(src, dst);
		copyASTNode(src, dst);
	}
	
	private void copyPrimitiveLiteralExp(PrimitiveLiteralExp<EClassifier> src, org.eclipse.emf.ocl.expressions.PrimitiveLiteralExp dst) {
		copyLiteralExp(src, dst);
	}
	
	private void copyLiteralExp(LiteralExp<EClassifier> src, org.eclipse.emf.ocl.expressions.LiteralExp dst) {
		copyOCLExpression(src, dst);
	}
	
	private void copyLoopExp(LoopExp<EClassifier, EParameter> src, org.eclipse.emf.ocl.expressions.LoopExp dst) {
		dst.setBody(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, src.getBody()));
		
		for (Variable<EClassifier, EParameter> i : src.getIterator()) {
			dst.getIterator().add(
					(org.eclipse.emf.ocl.expressions.Variable)
					CompatibilityUtil.getOldAS(env, i));
		}
		
		copyCallExp(src, dst);
	}
	
	public EObject visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> ae) {
		org.eclipse.emf.ocl.expressions.AssociationClassCallExp result =
			ExpressionsFactory.eINSTANCE.createAssociationClassCallExp();
		
		result.setReferredAssociationClass((EClass) ae.getReferredAssociationClass());
		
		for (OCLExpression<EClassifier> q : ae.getQualifier()) {
			result.getQualifier().add(
					(org.eclipse.emf.ocl.expressions.OCLExpression)
					CompatibilityUtil.getOldAS(env, q));
		}
		
		copyNavigationCallExp(ae, result);
		
		return result;
	}

	public EObject visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> bl) {
		org.eclipse.emf.ocl.expressions.BooleanLiteralExp result =
			ExpressionsFactory.eINSTANCE.createBooleanLiteralExp();
		
		result.setBooleanSymbol(bl.getBooleanSymbol());
		
		copyPrimitiveLiteralExp(bl, result);
		
		return result;
	}

	public EObject visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> cl) {
		org.eclipse.emf.ocl.expressions.CollectionLiteralExp result =
			ExpressionsFactory.eINSTANCE.createCollectionLiteralExp();
		
		result.setKind(CollectionKind.getCompatibleKind(cl.getKind()));
		
		for (CollectionLiteralPart<EClassifier> p : cl.getPart()) {
			result.getPart().add(
					(org.eclipse.emf.ocl.expressions.CollectionLiteralPart)
					CompatibilityUtil.getOldAS(env, p));
		}
		
		copyLiteralExp(cl, result);
		
		return result;
	}
	
	public EObject visitCollectionItem(CollectionItem<EClassifier> item) {
		org.eclipse.emf.ocl.expressions.CollectionItem result =
			ExpressionsFactory.eINSTANCE.createCollectionItem();
		
		result.setItem(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, item.getItem()));
		
		copyTypedElement(item, result);
		
		return result;
	}
	
	public EObject visitCollectionRange(CollectionRange<EClassifier> range) {
		org.eclipse.emf.ocl.expressions.CollectionRange result =
			ExpressionsFactory.eINSTANCE.createCollectionRange();
		
		result.setFirst(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, range.getFirst()));
		result.setLast(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, range.getLast()));
		
		copyTypedElement(range, result);
		
		return result;
	}

	public EObject visitConstraint(Constraint constraint) {
		org.eclipse.emf.ocl.uml.Constraint result =
			UMLFactory.eINSTANCE.createConstraint();
		
		copyConstraint(constraint, result);
		
		return result;
	}

	public EObject visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> el) {
		org.eclipse.emf.ocl.expressions.EnumLiteralExp result =
			ExpressionsFactory.eINSTANCE.createEnumLiteralExp();
		
		result.setReferredEnumLiteral(el.getReferredEnumLiteral());
		
		copyLiteralExp(el, result);
		
		return result;
	}

	public EObject visitIfExp(IfExp<EClassifier> i) {
		org.eclipse.emf.ocl.expressions.IfExp result =
			ExpressionsFactory.eINSTANCE.createIfExp();
		
		result.setCondition(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, i.getCondition()));
		result.setThenExpression(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, i.getThenExpression()));
		result.setElseExpression(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, i.getElseExpression()));

		copyOCLExpression(i, result);
		
		return result;
	}

	public EObject visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> il) {
		org.eclipse.emf.ocl.expressions.IntegerLiteralExp result =
			ExpressionsFactory.eINSTANCE.createIntegerLiteralExp();
		
		result.setIntegerSymbol(il.getIntegerSymbol());
		
		copyPrimitiveLiteralExp(il, result);
		
		return result;
	}
    
    public EObject visitUnlimitedNaturalLiteralExp(
            UnlimitedNaturalLiteralExp<EClassifier> literalExp) {
        // didn't have UnlimitedNatural before 1.1, so use Integer instead
        org.eclipse.emf.ocl.expressions.IntegerLiteralExp result =
            ExpressionsFactory.eINSTANCE.createIntegerLiteralExp();
        
        result.setIntegerSymbol(literalExp.getIntegerSymbol());
        
        copyPrimitiveLiteralExp(literalExp, result);
        
        return result;
    }

	public EObject visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> il) {
		org.eclipse.emf.ocl.expressions.InvalidLiteralExp result =
			ExpressionsFactory.eINSTANCE.createInvalidLiteralExp();
		
		copyLiteralExp(il, result);
		
		return result;
	}

	public EObject visitIterateExp(IterateExp<EClassifier, EParameter> ie) {
		org.eclipse.emf.ocl.expressions.IterateExp result =
			ExpressionsFactory.eINSTANCE.createIterateExp();
		
		result.setResult(
				(org.eclipse.emf.ocl.expressions.Variable)
				CompatibilityUtil.getOldAS(env, ie.getResult()));
		
		copyLoopExp(ie, result);
		
		return result;
	}

	public EObject visitIteratorExp(IteratorExp<EClassifier, EParameter> ie) {
		org.eclipse.emf.ocl.expressions.IteratorExp result =
			ExpressionsFactory.eINSTANCE.createIteratorExp();
		
		copyLoopExp(ie, result);
		
		return result;
	}

	public EObject visitLetExp(LetExp<EClassifier, EParameter> l) {
		org.eclipse.emf.ocl.expressions.LetExp result =
			ExpressionsFactory.eINSTANCE.createLetExp();
		
		result.setVariable(
				(org.eclipse.emf.ocl.expressions.Variable)
				CompatibilityUtil.getOldAS(env, l.getVariable()));
		result.setIn(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, l.getIn()));
		
		copyOCLExpression(l, result);
		
		return result;
	}

	public EObject visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> m) {
		org.eclipse.emf.ocl.expressions.MessageExp result =
			ExpressionsFactory.eINSTANCE.createMessageExp();
		
		result.setTarget(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, m.getTarget()));
		result.setCalledOperation(
				(org.eclipse.emf.ocl.uml.CallOperationAction)
				CompatibilityUtil.getOldAS(env, m.getCalledOperation()));
		result.setSentSignal(
				(org.eclipse.emf.ocl.uml.SendSignalAction)
				CompatibilityUtil.getOldAS(env, m.getSentSignal()));
		
		for (OCLExpression<EClassifier> a : m.getArgument()) {
			result.getArgument().add(
					(org.eclipse.emf.ocl.expressions.OCLExpression)
					CompatibilityUtil.getOldAS(env, a));
		}
		
		copyOCLExpression(m, result);
		copyCallingASTNode(m, result);
		
		return result;
	}

	public EObject visitNullLiteralExp(NullLiteralExp<EClassifier> il) {
		org.eclipse.emf.ocl.expressions.NullLiteralExp result =
			ExpressionsFactory.eINSTANCE.createNullLiteralExp();
		
		copyLiteralExp(il, result);
		
		return result;
	}

	public EObject visitOperationCallExp(OperationCallExp<EClassifier, EOperation> oc) {
		org.eclipse.emf.ocl.expressions.OperationCallExp result =
			ExpressionsFactory.eINSTANCE.createOperationCallExp();
		
		for (OCLExpression<EClassifier> a : oc.getArgument()) {
			result.getArgument().add(
					(org.eclipse.emf.ocl.expressions.OCLExpression)
					CompatibilityUtil.getOldAS(env, a));
		}
		
		copyFeatureCallExp(oc, result);
		
		EOperation refOperation = oc.getReferredOperation();
		
		// find corresponding pre-defined operation
		refOperation = CompatibilityUtil.getOldOperation(
				refOperation,
				result.getSource().getType(),
				oc.getSource().getType());
		
		result.setReferredOperation(refOperation);
		
		return result;
	}

	public EObject visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> ae) {
		org.eclipse.emf.ocl.expressions.PropertyCallExp result =
			ExpressionsFactory.eINSTANCE.createPropertyCallExp();
		
		copyNavigationCallExp(ae, result);
		
		EStructuralFeature refProperty = ae.getReferredProperty();
		
		if (ae.getSource() != null) {
			// source is null in the case of an association navigation qualifier
			EClassifier sourceType = ae.getSource().getType();
			if (sourceType instanceof MessageType) {
				// find corresponding pre-defined type's property
				for (EStructuralFeature p : ((org.eclipse.emf.ocl.types.MessageType) result.getSource().getType()).getEStructuralFeatures()) {
					if (p.getName().equals(refProperty.getName())) {
						refProperty = p;
						break;
					}
				}
			} else if (sourceType instanceof TupleType) {
				// find corresponding pre-defined type's property
				for (EStructuralFeature p : ((org.eclipse.emf.ocl.types.TupleType) result.getSource().getType()).getEStructuralFeatures()) {
					if (p.getName().equals(refProperty.getName())) {
						refProperty = p;
						break;
					}
				}
			}
		}
		
		result.setReferredProperty(refProperty);
		
		return result;
	}

	public EObject visitRealLiteralExp(RealLiteralExp<EClassifier> rl) {
		org.eclipse.emf.ocl.expressions.RealLiteralExp result =
			ExpressionsFactory.eINSTANCE.createRealLiteralExp();
		
		result.setRealSymbol(rl.getRealSymbol());
		
		copyPrimitiveLiteralExp(rl, result);
		
		return result;
	}

	public EObject visitStateExp(StateExp<EClassifier, EObject> s) {
		org.eclipse.emf.ocl.expressions.StateExp result =
			ExpressionsFactory.eINSTANCE.createStateExp();
		
		result.setReferredState(s.getReferredState());
		
		copyOCLExpression(s, result);
		
		return result;
	}

	public EObject visitStringLiteralExp(StringLiteralExp<EClassifier> sl) {
		org.eclipse.emf.ocl.expressions.StringLiteralExp result =
			ExpressionsFactory.eINSTANCE.createStringLiteralExp();
		
		result.setStringSymbol(sl.getStringSymbol());
		
		copyPrimitiveLiteralExp(sl, result);
		
		return result;
	}

	public EObject visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> tl) {
		org.eclipse.emf.ocl.expressions.TupleLiteralExp result =
			ExpressionsFactory.eINSTANCE.createTupleLiteralExp();
		
		// do this first so that we have the tuple type assigned before
		//   finding corresponding properties
		copyLiteralExp(tl, result);
		
		for (TupleLiteralPart<EClassifier, EStructuralFeature> p : tl.getPart()) {
			org.eclipse.emf.ocl.expressions.TupleLiteralPart newPart =
				(org.eclipse.emf.ocl.expressions.TupleLiteralPart)
				CompatibilityUtil.getOldAS(env, p);
			
			result.getPart().add(newPart);
			
			copyTupleLiteralPart(p, newPart);
		}
		
		return result;
	}

	public EObject visitTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> tp) {
		org.eclipse.emf.ocl.expressions.TupleLiteralPart result =
			ExpressionsFactory.eINSTANCE.createTupleLiteralPart();
		
		result.setAttribute(tp.getAttribute());
		result.setValue(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, tp.getValue()));
		
		copyTypedASTNode(tp, result);
		copyTypedElement(tp, result);
		
		return result;
	}

	public EObject visitTypeExp(TypeExp<EClassifier> t) {
		org.eclipse.emf.ocl.expressions.TypeExp result =
			ExpressionsFactory.eINSTANCE.createTypeExp();
		
		result.setReferredType(
				(EClassifier) CompatibilityUtil.getOldAS(env, t.getReferredType()));
		
		copyOCLExpression(t, result);
		
		return result;
	}

	public EObject visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> uv) {
		org.eclipse.emf.ocl.expressions.UnspecifiedValueExp result =
			ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp();
		
		copyTypedASTNode(uv, result);
		copyOCLExpression(uv, result);
		
		return result;
	}

	public EObject visitVariable(Variable<EClassifier, EParameter> vd) {
		org.eclipse.emf.ocl.expressions.Variable result =
			ExpressionsFactory.eINSTANCE.createVariable();
		
		result.setRepresentedParameter(vd.getRepresentedParameter());
		result.setInitExpression(
				(org.eclipse.emf.ocl.expressions.OCLExpression)
				CompatibilityUtil.getOldAS(env, vd.getInitExpression()));
		
		copyTypedASTNode(vd, result);
		copyTypedElement(vd, result);
		
		return result;
	}

	public EObject visitVariableExp(VariableExp<EClassifier, EParameter> v) {
		org.eclipse.emf.ocl.expressions.VariableExp result =
			ExpressionsFactory.eINSTANCE.createVariableExp();
		
		result.setReferredVariable(
				(org.eclipse.emf.ocl.expressions.Variable)
				CompatibilityUtil.getOldAS(env, v.getReferredVariable()));
		
		copyOCLExpression(v, result);
		
		return result;
	}

	public org.eclipse.emf.ocl.uml.CallOperationAction visitCallOperationAction(CallOperationAction coa) {
		org.eclipse.emf.ocl.uml.CallOperationAction result =
			UMLFactory.eINSTANCE.createCallOperationAction();
		
		result.setOperation(coa.getOperation());
		
		return result;
	}
	
	public org.eclipse.emf.ocl.uml.SendSignalAction visitSendSignalAction(SendSignalAction ssa) {
		org.eclipse.emf.ocl.uml.SendSignalAction result =
			UMLFactory.eINSTANCE.createSendSignalAction();
		
		result.setSignal(ssa.getSignal());
		
		return result;
	}
    
    public EObject visitExpressionInOCL(
            ExpressionInOCL<EClassifier, EParameter> expression) {
        // never invoked, as the old API did not have the ExpressionInOCL
        throw new IllegalArgumentException("cannot convert ExpressionInOCL"); //$NON-NLS-1$
    }
	
	public EClassifier visitPredefinedType(EClassifier type) {
		if (typesSwitch == null) {
			typesSwitch = new EcoreSwitch<EClassifier>() {
				OCLStandardLibrary<EClassifier> stdlib =
					EcoreEnvironmentFactory.INSTANCE.createEnvironment().getOCLStandardLibrary();
				
				@Override
				public EClassifier caseAnyType(
						AnyType object) {
                    if (object == stdlib.getOclAny()) {
                        return Types.OCL_ANY_TYPE;
                    } else if (object == stdlib.getT()) {
                        return AnyTypeImpl.OCL_T;
                    } else if (object == stdlib.getT2()) {
                        return AnyTypeImpl.OCL_T2;
                    }
                    
                    return TypesFactory.eINSTANCE.createAnyType();
				}
				
				@Override
				public EClassifier caseElementType(ElementType object) {
					if (object == stdlib.getState()) {
						return Types.STATE;
					} else if (object == stdlib.getOclElement()) {
						return Types.OCL_ELEMENT;
					}
					
					org.eclipse.emf.ocl.types.ElementType result =
						TypesFactory.eINSTANCE.createElementType();
					result.setName(object.getName());
					return result;
				}
				
				@Override
				public EClassifier caseInvalidType(InvalidType object) {
					return Types.INVALID;
				}
				
				@Override
				public EClassifier caseVoidType(VoidType object) {
					return Types.OCL_VOID;
				}
				
				@Override
				public EClassifier casePrimitiveType(PrimitiveType object) {
                    if (object == stdlib.getBoolean()) {
                        return Types.OCL_BOOLEAN;
                    } else if (object == stdlib.getString()) {
                        return Types.OCL_STRING;
                    } else if (object == stdlib.getReal()) {
                        return Types.OCL_REAL;
                    } else {
                        return Types.OCL_INTEGER;
                    }
				}
				
				@Override
				public EClassifier caseTypeType(TypeType object) {
                    if (object == stdlib.getOclType()) {
                        return Types.OCL_TYPE;
                    }
                    
					if (resolver != null) {
						return resolver.resolveTypeType(
								(EClassifier) CompatibilityUtil.getOldAS(
									env, object.getReferredType()));
					}
					
					return (EClassifier) TypesFactory.eINSTANCE.createTypeType(
							(EClassifier) CompatibilityUtil.getOldAS(
									env, object.getReferredType()));
				}
				
				@Override
				public EClassifier caseCollectionType(CollectionType object) {
                    if (object == stdlib.getSet()) {
                        return CollectionTypeImpl.OCL_SET;
                    } else if (object == stdlib.getBag()) {
                        return CollectionTypeImpl.OCL_BAG;
                    } else if (object == stdlib.getOrderedSet()) {
                        return CollectionTypeImpl.OCL_ORDERED_SET;
                    } else if (object == stdlib.getSequence()) {
                        return CollectionTypeImpl.OCL_SEQUENCE;
                    } else if (object == stdlib.getCollection()) {
                        return CollectionTypeImpl.OCL_COLLECTION;
                    }
                    
					if (resolver != null) {
						return resolver.resolveCollectionType(
								CollectionKind.getCompatibleKind(object.getKind()),
								(EClassifier) CompatibilityUtil.getOldAS(
									env, (EClassifier) object.getElementType()));
					}
					
					return (EClassifier) TypesFactory.eINSTANCE.createCollectionType(
							CollectionKind.getCompatibleKind(object.getKind()),
							(EClassifier) CompatibilityUtil.getOldAS(
									env, (EClassifier) object.getElementType()));
				}
				
				@Override
				public EClassifier caseMessageType(MessageType object) {
					if (object == stdlib.getOclMessage()) {
						return Types.OCL_MESSAGE;
					}
					
					if (object.getReferredOperation() != null) {
						if (resolver != null) {
							return resolver.resolveMessageType(
									object.getReferredOperation());
						}
						
						return (EClassifier) TypesFactory.eINSTANCE.createMessageType(
								object.getReferredOperation());
					} else {
						if (resolver != null) {
							return resolver.resolveMessageType(
									(EClass) object.getReferredSignal());
						}
						
						return (EClassifier) TypesFactory.eINSTANCE.createMessageType(
								object.getReferredSignal());
					}
				}
				
				@Override
				public EClassifier caseTupleType(TupleType object) {
					EList<org.eclipse.emf.ocl.expressions.Variable> parts =
						new BasicEList<org.eclipse.emf.ocl.expressions.Variable>(
								object.getEStructuralFeatures().size());
					for (EStructuralFeature p : object.getEStructuralFeatures()) {
						org.eclipse.emf.ocl.expressions.Variable part =
							ExpressionsFactory.eINSTANCE.createVariable();
						
						part.setName(p.getName());
						part.setType((EClassifier) CompatibilityUtil.getOldAS(
								env, p.getEType()));
						
						parts.add(part);
					}
					
					if (resolver != null) {
						return resolver.resolveTupleType(parts);
					}
					
					return (EClassifier) TypesFactory.eINSTANCE.createTupleType(
							parts);
				}
				
				@Override
				public EClassifier defaultCase(EObject object) {
					if (object instanceof InvalidType) {
						return Types.INVALID;
					}
					
					return null;
				}
			};
		}
		
		return typesSwitch.doSwitch(type);
	}
}
