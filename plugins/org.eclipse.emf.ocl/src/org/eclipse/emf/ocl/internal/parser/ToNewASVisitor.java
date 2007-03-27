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
 * $Id: ToNewASVisitor.java,v 1.4 2007/03/27 18:46:40 cdamus Exp $
 */

package org.eclipse.emf.ocl.internal.parser;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CallExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.FeatureCallExp;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.InvalidLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.LiteralExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.MessageExp;
import org.eclipse.emf.ocl.expressions.NavigationCallExp;
import org.eclipse.emf.ocl.expressions.NullLiteralExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PrimitiveLiteralExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StateExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralPart;
import org.eclipse.emf.ocl.expressions.TypeExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.types.AnyType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.ElementType;
import org.eclipse.emf.ocl.types.InvalidType;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.PrimitiveInteger;
import org.eclipse.emf.ocl.types.PrimitiveReal;
import org.eclipse.emf.ocl.types.PrimitiveString;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypeType;
import org.eclipse.emf.ocl.types.VoidType;
import org.eclipse.emf.ocl.types.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.impl.CollectionTypeImpl;
import org.eclipse.emf.ocl.types.impl.TypeTypeImpl;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.types.util.TypesSwitch;
import org.eclipse.emf.ocl.uml.CallOperationAction;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.uml.SendSignalAction;
import org.eclipse.emf.ocl.uml.TypedElement;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.CallingASTNode;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.internal.OCLFactoryImpl;
import org.eclipse.ocl.types.OCLStandardLibrary;

/**
 * @author cdamus
 *
 */
final class ToNewASVisitor implements Visitor {
	private Environment env;
	
	private TypesSwitch<EClassifier> typesSwitch;
	
	private ToNewASVisitor(Environment env) {
		this.env = env;
	}
	
	static ToNewASVisitor getInstance(Environment env) {
		return new ToNewASVisitor(env);
	}
	
	private void copyASTNode(ASTNode src, org.eclipse.ocl.utilities.ASTNode dst) {
		dst.setStartPosition(src.getStartPosition());
		dst.setEndPosition(src.getEndPosition());
	}
	
	private void copyTypedASTNode(TypedASTNode src, org.eclipse.ocl.utilities.TypedASTNode dst) {
		dst.setTypeStartPosition(src.getTypeStartPosition());
		dst.setTypeEndPosition(src.getTypeEndPosition());
		
		copyASTNode(src, dst);
	}
	
	private void copyCallingASTNode(CallingASTNode src, org.eclipse.ocl.utilities.CallingASTNode dst) {
		dst.setPropertyStartPosition(src.getPropertyStartPosition());
		dst.setPropertyEndPosition(src.getPropertyEndPosition());
		
		copyASTNode(src, dst);
	}
	
	void copyTypedElement(TypedElement src, org.eclipse.ocl.utilities.TypedElement<EClassifier> dst) {
		ETypedElement element = (ETypedElement) dst;
		element.setName(src.getName());
		element.setEType((EClassifier) CompatibilityUtil.getNewAS(env, src.getType()));
	}
	
	void copyCollectionType(CollectionType src, org.eclipse.ocl.ecore.CollectionType dst) {
		dst.setElementType(
				(EClassifier) CompatibilityUtil.getNewAS(
						env, src.getElementType()));
	}
	
	void copyTupleLiteralPart(TupleLiteralPart src, org.eclipse.ocl.expressions.TupleLiteralPart<EClassifier, EStructuralFeature> dst) {
		EStructuralFeature attribute = src.getAttribute();
		
		org.eclipse.ocl.expressions.TupleLiteralExp<EClassifier, EStructuralFeature> tuple =
			(org.eclipse.ocl.expressions.TupleLiteralExp<EClassifier, EStructuralFeature>) dst.eContainer();
		org.eclipse.ocl.ecore.TupleType type =
			(org.eclipse.ocl.ecore.TupleType) tuple.getType();
		
		for (EStructuralFeature p : type.oclProperties()) {
			if (p.getName().equals(attribute.getName())) {
				dst.setAttribute(p);
				break;
			}
		}
	}
	
	private void copyNavigationCallExp(NavigationCallExp src, org.eclipse.ocl.expressions.NavigationCallExp<EClassifier, EStructuralFeature> dst) {
		dst.setNavigationSource(src.getNavigationSource());
		
		for (OCLExpression q : (EList<OCLExpression>) src.getQualifier()) {
			dst.getQualifier().add(
					(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
					CompatibilityUtil.getNewAS(env, q));
		}
		
		copyFeatureCallExp(src, dst);
	}
	
	private void copyFeatureCallExp(FeatureCallExp src, org.eclipse.ocl.expressions.FeatureCallExp<EClassifier> dst) {
		dst.setMarkedPre(src.isMarkedPre());
		
		copyCallExp(src, dst);
	}
	
	private void copyCallExp(CallExp src, org.eclipse.ocl.expressions.CallExp<EClassifier> dst) {
		dst.setSource((org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, src.getSource()));
		
		copyOCLExpression(src, dst);
		copyCallingASTNode(src, dst);
	}
	
	private void copyOCLExpression(OCLExpression src, org.eclipse.ocl.expressions.OCLExpression<EClassifier> dst) {
		copyTypedElement(src, dst);
		copyASTNode(src, dst);
	}
	
	private void copyPrimitiveLiteralExp(PrimitiveLiteralExp src, org.eclipse.ocl.expressions.PrimitiveLiteralExp<EClassifier> dst) {
		copyLiteralExp(src, dst);
	}
	
	private void copyLiteralExp(LiteralExp src, org.eclipse.ocl.expressions.LiteralExp<EClassifier> dst) {
		copyOCLExpression(src, dst);
	}
	
	private void copyLoopExp(LoopExp src, org.eclipse.ocl.expressions.LoopExp<EClassifier, EParameter> dst) {
		dst.setBody(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, src.getBody()));
		
		for (Object i : src.getIterator()) {
			dst.getIterator().add(
					(org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>)
					CompatibilityUtil.getNewAS(env, (Variable) i));
		}
		
		copyCallExp(src, dst);
	}
	
	public Object visitAssociationClassCallExp(AssociationClassCallExp ae) {
		org.eclipse.ocl.expressions.AssociationClassCallExp<EClassifier, EStructuralFeature> result =
			EcoreFactory.eINSTANCE.createAssociationClassCallExp();
		
		result.setReferredAssociationClass(ae.getReferredAssociationClass());
		
		for (Object q : ae.getQualifier()) {
			result.getQualifier().add(
					(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
					CompatibilityUtil.getNewAS(env, (OCLExpression) q));
		}
		
		copyNavigationCallExp(ae, result);
		
		return result;
	}

	public Object visitBooleanLiteralExp(BooleanLiteralExp bl) {
		org.eclipse.ocl.expressions.BooleanLiteralExp<EClassifier> result =
			EcoreFactory.eINSTANCE.createBooleanLiteralExp();
		
		result.setBooleanSymbol(bl.getBooleanSymbol());
		
		copyPrimitiveLiteralExp(bl, result);
		
		return result;
	}

	public Object visitCollectionLiteralExp(CollectionLiteralExp cl) {
		org.eclipse.ocl.expressions.CollectionLiteralExp<EClassifier> result =
			EcoreFactory.eINSTANCE.createCollectionLiteralExp();
		
		result.setKind(cl.getKind().asNewKind());
		
		for (Object p : cl.getPart()) {
			result.getPart().add(
					(org.eclipse.ocl.expressions.CollectionLiteralPart<EClassifier>)
					CompatibilityUtil.getNewAS(env, (CollectionLiteralPart) p));
		}
		
		copyLiteralExp(cl, result);
		
		return result;
	}
	
	public EObject visitCollectionItem(CollectionItem item) {
		org.eclipse.ocl.expressions.CollectionItem<EClassifier> result =
			EcoreFactory.eINSTANCE.createCollectionItem();
		
		result.setItem(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, item.getItem()));
		
		copyTypedElement(item, result);
		
		return result;
	}
	
	public EObject visitCollectionRange(CollectionRange range) {
		org.eclipse.ocl.expressions.CollectionRange<EClassifier> result =
			EcoreFactory.eINSTANCE.createCollectionRange();
		
		
		result.setFirst(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, range.getFirst()));
		result.setLast(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, range.getLast()));
		
		copyTypedElement(range, result);
		
		return result;
	}

	public Object visitConstraint(Constraint constraint) {
		org.eclipse.ocl.ecore.Constraint result =
			EcoreFactory.eINSTANCE.createConstraint();
		
		ExpressionInOCL specification = EcoreFactory.eINSTANCE.createExpressionInOCL();
		specification.setBodyExpression(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, constraint.getBody()));
		
		result.setSpecification(specification);
		
		result.setName(constraint.getName());
		result.setStereotype(constraint.getStereotype());
		
		ECollections.setEList(
				result.getConstrainedElements(),
				constraint.getConstrainedElement());
		
		return result;
	}

	public Object visitEnumLiteralExp(EnumLiteralExp el) {
		org.eclipse.ocl.expressions.EnumLiteralExp<EClassifier, EEnumLiteral> result =
			EcoreFactory.eINSTANCE.createEnumLiteralExp();
		
		result.setReferredEnumLiteral(el.getReferredEnumLiteral());
		
		copyLiteralExp(el, result);
		
		return result;
	}

	public Object visitIfExp(IfExp i) {
		org.eclipse.ocl.expressions.IfExp<EClassifier> result =
			EcoreFactory.eINSTANCE.createIfExp();
		
		result.setCondition(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, i.getCondition()));
		result.setThenExpression(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, i.getThenExpression()));
		result.setElseExpression(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, i.getElseExpression()));

		copyOCLExpression(i, result);
		
		return result;
	}

	public Object visitIntegerLiteralExp(IntegerLiteralExp il) {
		org.eclipse.ocl.expressions.IntegerLiteralExp<EClassifier> result =
			EcoreFactory.eINSTANCE.createIntegerLiteralExp();
		
		result.setIntegerSymbol(il.getIntegerSymbol());
		
		copyPrimitiveLiteralExp(il, result);
		
		return result;
	}

	public Object visitInvalidLiteralExp(InvalidLiteralExp il) {
		org.eclipse.ocl.expressions.InvalidLiteralExp<EClassifier> result =
			EcoreFactory.eINSTANCE.createInvalidLiteralExp();
		
		copyLiteralExp(il, result);
		
		return result;
	}

	public Object visitIterateExp(IterateExp ie) {
		org.eclipse.ocl.expressions.IterateExp<EClassifier, EParameter> result =
			EcoreFactory.eINSTANCE.createIterateExp();
		
		result.setResult(
				(org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>)
				CompatibilityUtil.getNewAS(env, ie.getResult()));
		
		copyLoopExp(ie, result);
		
		return result;
	}

	public Object visitIteratorExp(IteratorExp ie) {
		org.eclipse.ocl.expressions.IteratorExp<EClassifier, EParameter> result =
			EcoreFactory.eINSTANCE.createIteratorExp();
		
		copyLoopExp(ie, result);
		
		return result;
	}

	public Object visitLetExp(LetExp l) {
		org.eclipse.ocl.expressions.LetExp<EClassifier, EParameter> result =
			EcoreFactory.eINSTANCE.createLetExp();
		
		result.setVariable(
				(org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>)
				CompatibilityUtil.getNewAS(env, l.getVariable()));
		result.setIn(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, l.getIn()));
		
		copyOCLExpression(l, result);
		
		return result;
	}

	public Object visitMessageExp(MessageExp m) {
		org.eclipse.ocl.expressions.MessageExp<EClassifier, org.eclipse.ocl.ecore.CallOperationAction, org.eclipse.ocl.ecore.SendSignalAction> result =
			EcoreFactory.eINSTANCE.createMessageExp();
		
		result.setTarget(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, m.getTarget()));
		result.setCalledOperation(
				(org.eclipse.ocl.ecore.CallOperationAction)
				CompatibilityUtil.getNewAS(env, m.getCalledOperation()));
		result.setSentSignal(
				(org.eclipse.ocl.ecore.SendSignalAction)
				CompatibilityUtil.getNewAS(env, m.getSentSignal()));
		
		for (Object a : m.getArgument()) {
			result.getArgument().add(
					(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
					CompatibilityUtil.getNewAS(env, (OCLExpression) a));
		}
		
		copyOCLExpression(m, result);
		copyCallingASTNode(m, result);
		
		return result;
	}

	public Object visitNullLiteralExp(NullLiteralExp il) {
		org.eclipse.ocl.expressions.NullLiteralExp<EClassifier> result =
			EcoreFactory.eINSTANCE.createNullLiteralExp();
		
		copyLiteralExp(il, result);
		
		return result;
	}

	public Object visitOperationCallExp(OperationCallExp oc) {
		org.eclipse.ocl.expressions.OperationCallExp<EClassifier, EOperation> result =
			EcoreFactory.eINSTANCE.createOperationCallExp();
		
		for (Object a : oc.getArgument()) {
			result.getArgument().add(
					(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
					CompatibilityUtil.getNewAS(env, (OCLExpression) a));
		}
		
		copyFeatureCallExp(oc, result);
		
		EOperation refOperation = oc.getReferredOperation();
		
		// find corresponding pre-defined operation
		refOperation = CompatibilityUtil.getNewOperation(
				refOperation,
				result.getSource().getType(),
				oc.getSource().getType());
		
		
		result.setReferredOperation(refOperation);
		
		return result;
	}

	public Object visitPropertyCallExp(PropertyCallExp ae) {
		org.eclipse.ocl.expressions.PropertyCallExp<EClassifier, EStructuralFeature> result =
			EcoreFactory.eINSTANCE.createPropertyCallExp();
		
		copyNavigationCallExp(ae, result);
		
		EStructuralFeature refProperty = ae.getReferredProperty();
		
		if (ae.getSource() != null) {
			// source is null in the case of an association navigation qualifier
			EClassifier sourceType = ae.getSource().getType();
			if (sourceType instanceof MessageType) {
				// find corresponding pre-defined type's property
				for (EStructuralFeature p : ((org.eclipse.ocl.types.MessageType<EClassifier, EOperation, EStructuralFeature>) result.getSource().getType()).oclProperties()) {
					EStructuralFeature next = (EStructuralFeature) p;
					
					if (next.getName().equals(refProperty.getName())) {
						refProperty = next;
						break;
					}
				}
			} else if (sourceType instanceof TupleType) {
				// find corresponding pre-defined type's property
				for (EStructuralFeature p : ((org.eclipse.ocl.types.TupleType<EOperation, EStructuralFeature>) result.getSource().getType()).oclProperties()) {
					EStructuralFeature next = (EStructuralFeature) p;
					
					if (next.getName().equals(refProperty.getName())) {
						refProperty = next;
						break;
					}
				}
			}
		}
		
		result.setReferredProperty(refProperty);
		
		return result;
	}

	public Object visitRealLiteralExp(RealLiteralExp rl) {
		org.eclipse.ocl.expressions.RealLiteralExp<EClassifier> result =
			EcoreFactory.eINSTANCE.createRealLiteralExp();
		
		result.setRealSymbol(rl.getRealSymbol());
		
		copyPrimitiveLiteralExp(rl, result);
		
		return result;
	}

	public Object visitStateExp(StateExp s) {
		org.eclipse.ocl.expressions.StateExp<EClassifier, EObject> result =
			EcoreFactory.eINSTANCE.createStateExp();
		
		result.setReferredState(s.getReferredState());
		
		copyOCLExpression(s, result);
		
		return result;
	}

	public Object visitStringLiteralExp(StringLiteralExp sl) {
		org.eclipse.ocl.expressions.StringLiteralExp<EClassifier> result =
			EcoreFactory.eINSTANCE.createStringLiteralExp();
		
		result.setStringSymbol(sl.getStringSymbol());
		
		copyPrimitiveLiteralExp(sl, result);
		
		return result;
	}

	public Object visitTupleLiteralExp(TupleLiteralExp tl) {
		org.eclipse.ocl.expressions.TupleLiteralExp<EClassifier, EStructuralFeature> result =
			EcoreFactory.eINSTANCE.createTupleLiteralExp();
		
		// do this first so that we have the tuple type assigned before
		//   finding corresponding properties
		copyLiteralExp(tl, result);
		
		for (Object p : tl.getPart()) {
			TupleLiteralPart oldPart = (TupleLiteralPart) p;
			
			org.eclipse.ocl.expressions.TupleLiteralPart<EClassifier, EStructuralFeature>
			newPart = (org.eclipse.ocl.expressions.TupleLiteralPart<EClassifier, EStructuralFeature>)
				CompatibilityUtil.getNewAS(env, oldPart);
			
			result.getPart().add(newPart);
			
			copyTupleLiteralPart(oldPart, newPart);
		}
		
		return result;
	}

	public Object visitTupleLiteralPart(TupleLiteralPart tp) {
		org.eclipse.ocl.expressions.TupleLiteralPart<EClassifier, EStructuralFeature> result =
			EcoreFactory.eINSTANCE.createTupleLiteralPart();
		
		result.setAttribute(tp.getAttribute());
		result.setValue(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, tp.getValue()));
		
		copyTypedASTNode(tp, result);
		copyTypedElement(tp, result);
		
		return result;
	}

	public Object visitTypeExp(TypeExp t) {
		org.eclipse.ocl.expressions.TypeExp<EClassifier> result =
			EcoreFactory.eINSTANCE.createTypeExp();
		
		result.setReferredType(
				(EClassifier) CompatibilityUtil.getNewAS(env, t.getReferredType()));
		
		copyOCLExpression(t, result);
		
		return result;
	}

	public Object visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
		org.eclipse.ocl.expressions.UnspecifiedValueExp<EClassifier> result =
			EcoreFactory.eINSTANCE.createUnspecifiedValueExp();
		
		copyTypedASTNode(uv, result);
		copyOCLExpression(uv, result);
		
		return result;
	}

	public Object visitVariable(Variable vd) {
		org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> result =
			EcoreFactory.eINSTANCE.createVariable();
		
		result.setRepresentedParameter(vd.getRepresentedParameter());
		result.setInitExpression(
				(org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
				CompatibilityUtil.getNewAS(env, vd.getInitExpression()));
		
		copyTypedASTNode(vd, result);
		copyTypedElement(vd, result);
		
		return result;
	}

	public Object visitVariableExp(VariableExp v) {
		org.eclipse.ocl.expressions.VariableExp<EClassifier, EParameter> result =
			EcoreFactory.eINSTANCE.createVariableExp();
		
		result.setReferredVariable(
				(org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>)
				CompatibilityUtil.getNewAS(env, v.getReferredVariable()));
		
		copyOCLExpression(v, result);
		
		return result;
	}

	public org.eclipse.ocl.ecore.CallOperationAction visitCallOperationAction(CallOperationAction coa) {
		org.eclipse.ocl.ecore.CallOperationAction result =
			EcoreFactory.eINSTANCE.createCallOperationAction();
		
		result.setOperation(coa.getOperation());
		
		return result;
	}
	
	public org.eclipse.ocl.ecore.SendSignalAction visitSendSignalAction(SendSignalAction ssa) {
		org.eclipse.ocl.ecore.SendSignalAction result =
			EcoreFactory.eINSTANCE.createSendSignalAction();
		
		result.setSignal(ssa.getSignal());
		
		return result;
	}
	
	public EClassifier visitPredefinedType(EClassifier type) {
		if (typesSwitch == null) {
			typesSwitch = new TypesSwitch<EClassifier>() {
				OCLStandardLibrary<EClassifier> stdlib =
					EcoreEnvironmentFactory.INSTANCE.createEnvironment().getOCLStandardLibrary();
				
				@Override
				public EClassifier caseAnyType(
						AnyType object) {
                    if (object == Types.OCL_ANY_TYPE) {
                        return stdlib.getOclAny();
                    } else if (object == AnyTypeImpl.OCL_T) {
                        return stdlib.getT();
                    } else if (object == AnyTypeImpl.OCL_T2) {
                        return stdlib.getT2();
                    }
                    
                    return EcoreFactory.eINSTANCE.createAnyType();
				}
				
				@Override
				public EClassifier caseElementType(ElementType object) {
					if (object == Types.STATE) {
						return stdlib.getState();
					} else if (object == Types.OCL_ELEMENT) {
						return stdlib.getOclElement();
					}
					
					org.eclipse.ocl.ecore.ElementType result =
						EcoreFactory.eINSTANCE.createElementType();
					result.setName(object.getName());
					return result;
				}
				
				@Override
				public EClassifier caseInvalidType(InvalidType object) {
					return stdlib.getInvalid();
				}
				
				@Override
				public EClassifier caseVoidType(VoidType object) {
					return stdlib.getOclVoid();
				}
				
				@Override
				public EClassifier casePrimitiveBoolean(PrimitiveBoolean object) {
					return stdlib.getBoolean();
				}
				
				@Override
				public EClassifier casePrimitiveInteger(PrimitiveInteger object) {
					return stdlib.getInteger();
				}
				
				@Override
				public EClassifier casePrimitiveReal(PrimitiveReal object) {
					return stdlib.getReal();
				}
				
				@Override
				public EClassifier casePrimitiveString(PrimitiveString object) {
					return stdlib.getString();
				}
				
				@Override
				public EClassifier caseTypeType(TypeType object) {
                    if (object == Types.OCL_TYPE) {
                        return stdlib.getOclType();
                    }
                    
					return (EClassifier) OCLFactoryImpl.INSTANCE.createTypeType(
							(EClassifier) CompatibilityUtil.getNewAS(
									env, ((TypeTypeImpl) object).getReferredType()));
				}
				
				@Override
				public EClassifier caseCollectionType(CollectionType object) {
                    if (object == CollectionTypeImpl.OCL_SET) {
                        return stdlib.getSet();
                    } else if (object == CollectionTypeImpl.OCL_BAG) {
                        return stdlib.getBag();
                    } else if (object == CollectionTypeImpl.OCL_ORDERED_SET) {
                        return stdlib.getOrderedSet();
                    } else if (object == CollectionTypeImpl.OCL_SEQUENCE) {
                        return stdlib.getSequence();
                    } else if (object == CollectionTypeImpl.OCL_COLLECTION) {
                        return stdlib.getCollection();
                    }
                    
					return (EClassifier) OCLFactoryImpl.INSTANCE.createCollectionType(
							object.getKind().asNewKind(),
							(EClassifier) CompatibilityUtil.getNewAS(
									env, object.getElementType()));
				}
				
				@Override
				public EClassifier caseMessageType(MessageType object) {
					if (object == Types.OCL_MESSAGE) {
						return stdlib.getOclMessage();
					}
					
					if (object.getReferredOperation() != null) {
						return (EClassifier) OCLFactoryImpl.INSTANCE.createOperationMessageType(
								object.getReferredOperation());
					} else {
						return (EClassifier) OCLFactoryImpl.INSTANCE.createSignalMessageType(
								object.getReferredSignal());
					}
				}
				
				@Override
				public EClassifier caseTupleType(TupleType object) {
					EList<org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>> parts =
						new BasicEList<org.eclipse.ocl.expressions.Variable<EClassifier,EParameter>>(
								object.getEStructuralFeatures().size());
					for (EStructuralFeature p : object.getEStructuralFeatures()) {
						org.eclipse.ocl.ecore.Variable part =
							EcoreFactory.eINSTANCE.createVariable();
						
						part.setName(p.getName());
						part.setEType((EClassifier) CompatibilityUtil.getNewAS(
								env, p.getEType()));
						
						parts.add(part);
					}
					
					return (EClassifier) OCLFactoryImpl.INSTANCE.createTupleType(
							parts);
				}
				
				@Override
				public EClassifier defaultCase(EObject object) {
					if (object instanceof InvalidType) {
						return stdlib.getInvalid();
					}
					
					return null;
				}
			};
		}
		
		return typesSwitch.doSwitch(type);
	}
}
