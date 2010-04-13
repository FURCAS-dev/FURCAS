/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompleteOCLParser.java,v 1.1 2010/04/13 06:36:41 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess;

public class CompleteOCLParser extends AbstractContentAssistParser {
	
	@Inject
	private CompleteOCLGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.eclipse.ocl.examples.xtext.completeocl.ui.contentassist.antlr.internal.InternalCompleteOCLParser createParser() {
		org.eclipse.ocl.examples.xtext.completeocl.ui.contentassist.antlr.internal.InternalCompleteOCLParser result = new org.eclipse.ocl.examples.xtext.completeocl.ui.contentassist.antlr.internal.InternalCompleteOCLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getModelAccess().getAlternatives_1(), "rule__Model__Alternatives_1");
					put(grammarAccess.getContextDeclCSAccess().getAlternatives(), "rule__ContextDeclCS__Alternatives");
					put(grammarAccess.getPropertyContextDeclCSAccess().getAlternatives_4(), "rule__PropertyContextDeclCS__Alternatives_4");
					put(grammarAccess.getClassifierContextDeclCSAccess().getAlternatives_3(), "rule__ClassifierContextDeclCS__Alternatives_3");
					put(grammarAccess.getOperationContextDeclCSAccess().getAlternatives_7(), "rule__OperationContextDeclCS__Alternatives_7");
					put(grammarAccess.getConstraintCSAccess().getAlternatives(), "rule__ConstraintCS__Alternatives");
					put(grammarAccess.getNamedConstraintCSAccess().getAlternatives(), "rule__NamedConstraintCS__Alternatives");
					put(grammarAccess.getExtendedPrimaryExpCSAccess().getAlternatives(), "rule__ExtendedPrimaryExpCS__Alternatives");
					put(grammarAccess.getOclMessageExpCSAccess().getOpAlternatives_1_0(), "rule__OclMessageExpCS__OpAlternatives_1_0");
					put(grammarAccess.getOclMessageArgCSAccess().getAlternatives(), "rule__OclMessageArgCS__Alternatives");
					put(grammarAccess.getREAL_LITERALAccess().getAlternatives_1(), "rule__REAL_LITERAL__Alternatives_1");
					put(grammarAccess.getREAL_LITERALAccess().getAlternatives_1_1_1(), "rule__REAL_LITERAL__Alternatives_1_1_1");
					put(grammarAccess.getREAL_LITERALAccess().getAlternatives_1_1_2(), "rule__REAL_LITERAL__Alternatives_1_1_2");
					put(grammarAccess.getRestrictedKeywordCSAccess().getAlternatives(), "rule__RestrictedKeywordCS__Alternatives");
					put(grammarAccess.getUnreservedSimpleNameCSAccess().getAlternatives(), "rule__UnreservedSimpleNameCS__Alternatives");
					put(grammarAccess.getPrimitiveTypeCSAccess().getAlternatives(), "rule__PrimitiveTypeCS__Alternatives");
					put(grammarAccess.getCollectionTypeIdentifierCSAccess().getAlternatives(), "rule__CollectionTypeIdentifierCS__Alternatives");
					put(grammarAccess.getTypeCSAccess().getAlternatives(), "rule__TypeCS__Alternatives");
					put(grammarAccess.getLiteralExpCSAccess().getAlternatives(), "rule__LiteralExpCS__Alternatives");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getAlternatives_0(), "rule__CollectionLiteralExpCS__Alternatives_0");
					put(grammarAccess.getPrimitiveLiteralExpCSAccess().getAlternatives(), "rule__PrimitiveLiteralExpCS__Alternatives");
					put(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives(), "rule__BooleanLiteralExpCS__Alternatives");
					put(grammarAccess.getTypeLiteralExpCSAccess().getAlternatives(), "rule__TypeLiteralExpCS__Alternatives");
					put(grammarAccess.getOclExpressionCSAccess().getAlternatives(), "rule__OclExpressionCS__Alternatives");
					put(grammarAccess.getImpliesCSAccess().getRightAlternatives_1_2_0(), "rule__ImpliesCS__RightAlternatives_1_2_0");
					put(grammarAccess.getXorCSAccess().getRightAlternatives_1_2_0(), "rule__XorCS__RightAlternatives_1_2_0");
					put(grammarAccess.getOrCSAccess().getRightAlternatives_1_2_0(), "rule__OrCS__RightAlternatives_1_2_0");
					put(grammarAccess.getAndCSAccess().getRightAlternatives_1_2_0(), "rule__AndCS__RightAlternatives_1_2_0");
					put(grammarAccess.getEqualityCSAccess().getOpAlternatives_1_1_0(), "rule__EqualityCS__OpAlternatives_1_1_0");
					put(grammarAccess.getEqualityCSAccess().getRightAlternatives_1_2_0(), "rule__EqualityCS__RightAlternatives_1_2_0");
					put(grammarAccess.getRelationalCSAccess().getOpAlternatives_1_1_0(), "rule__RelationalCS__OpAlternatives_1_1_0");
					put(grammarAccess.getRelationalCSAccess().getRightAlternatives_1_2_0(), "rule__RelationalCS__RightAlternatives_1_2_0");
					put(grammarAccess.getAdditiveCSAccess().getOpAlternatives_1_1_0(), "rule__AdditiveCS__OpAlternatives_1_1_0");
					put(grammarAccess.getAdditiveCSAccess().getRightAlternatives_1_2_0(), "rule__AdditiveCS__RightAlternatives_1_2_0");
					put(grammarAccess.getMultiplicativeCSAccess().getOpAlternatives_1_1_0(), "rule__MultiplicativeCS__OpAlternatives_1_1_0");
					put(grammarAccess.getMultiplicativeCSAccess().getRightAlternatives_1_2_0(), "rule__MultiplicativeCS__RightAlternatives_1_2_0");
					put(grammarAccess.getUnaryCSAccess().getAlternatives(), "rule__UnaryCS__Alternatives");
					put(grammarAccess.getUnaryCSAccess().getOpAlternatives_1_1_0(), "rule__UnaryCS__OpAlternatives_1_1_0");
					put(grammarAccess.getCallArgumentsCSAccess().getAlternatives(), "rule__CallArgumentsCS__Alternatives");
					put(grammarAccess.getCallArgumentsCSAccess().getAlternatives_0_4(), "rule__CallArgumentsCS__Alternatives_0_4");
					put(grammarAccess.getCallArgumentsCSAccess().getAlternatives_0_4_0_1(), "rule__CallArgumentsCS__Alternatives_0_4_0_1");
					put(grammarAccess.getPrimaryExpCSAccess().getAlternatives(), "rule__PrimaryExpCS__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getImportCSAccess().getGroup(), "rule__ImportCS__Group__0");
					put(grammarAccess.getPackageDeclarationCSAccess().getGroup(), "rule__PackageDeclarationCS__Group__0");
					put(grammarAccess.getPropertyContextDeclCSAccess().getGroup(), "rule__PropertyContextDeclCS__Group__0");
					put(grammarAccess.getPropertyContextDeclCSAccess().getGroup_4_0(), "rule__PropertyContextDeclCS__Group_4_0__0");
					put(grammarAccess.getPropertyContextDeclCSAccess().getGroup_4_1(), "rule__PropertyContextDeclCS__Group_4_1__0");
					put(grammarAccess.getInitCSAccess().getGroup(), "rule__InitCS__Group__0");
					put(grammarAccess.getDerCSAccess().getGroup(), "rule__DerCS__Group__0");
					put(grammarAccess.getClassifierContextDeclCSAccess().getGroup(), "rule__ClassifierContextDeclCS__Group__0");
					put(grammarAccess.getClassifierContextDeclCSAccess().getGroup_1(), "rule__ClassifierContextDeclCS__Group_1__0");
					put(grammarAccess.getInvCSAccess().getGroup(), "rule__InvCS__Group__0");
					put(grammarAccess.getDefCSAccess().getGroup(), "rule__DefCS__Group__0");
					put(grammarAccess.getDefCSAccess().getGroup_5(), "rule__DefCS__Group_5__0");
					put(grammarAccess.getDefCSAccess().getGroup_5_1(), "rule__DefCS__Group_5_1__0");
					put(grammarAccess.getDefCSAccess().getGroup_5_1_1(), "rule__DefCS__Group_5_1_1__0");
					put(grammarAccess.getOperationContextDeclCSAccess().getGroup(), "rule__OperationContextDeclCS__Group__0");
					put(grammarAccess.getOperationContextDeclCSAccess().getGroup_3(), "rule__OperationContextDeclCS__Group_3__0");
					put(grammarAccess.getOperationContextDeclCSAccess().getGroup_3_1(), "rule__OperationContextDeclCS__Group_3_1__0");
					put(grammarAccess.getParameterCSAccess().getGroup(), "rule__ParameterCS__Group__0");
					put(grammarAccess.getParameterCSAccess().getGroup_1(), "rule__ParameterCS__Group_1__0");
					put(grammarAccess.getParameterCSAccess().getGroup_2(), "rule__ParameterCS__Group_2__0");
					put(grammarAccess.getPreCSAccess().getGroup(), "rule__PreCS__Group__0");
					put(grammarAccess.getPostCSAccess().getGroup(), "rule__PostCS__Group__0");
					put(grammarAccess.getBodyCSAccess().getGroup(), "rule__BodyCS__Group__0");
					put(grammarAccess.getOclMessageExpCSAccess().getGroup(), "rule__OclMessageExpCS__Group__0");
					put(grammarAccess.getOclMessageExpCSAccess().getGroup_4(), "rule__OclMessageExpCS__Group_4__0");
					put(grammarAccess.getOclMessageExpCSAccess().getGroup_4_1(), "rule__OclMessageExpCS__Group_4_1__0");
					put(grammarAccess.getOclMessageArgCSAccess().getGroup_0(), "rule__OclMessageArgCS__Group_0__0");
					put(grammarAccess.getOclMessageArgCSAccess().getGroup_0_2(), "rule__OclMessageArgCS__Group_0_2__0");
					put(grammarAccess.getREAL_LITERALAccess().getGroup(), "rule__REAL_LITERAL__Group__0");
					put(grammarAccess.getREAL_LITERALAccess().getGroup_1_0(), "rule__REAL_LITERAL__Group_1_0__0");
					put(grammarAccess.getREAL_LITERALAccess().getGroup_1_1(), "rule__REAL_LITERAL__Group_1_1__0");
					put(grammarAccess.getREAL_LITERALAccess().getGroup_1_1_0(), "rule__REAL_LITERAL__Group_1_1_0__0");
					put(grammarAccess.getPathNameCSAccess().getGroup(), "rule__PathNameCS__Group__0");
					put(grammarAccess.getPathNameCSAccess().getGroup_1(), "rule__PathNameCS__Group_1__0");
					put(grammarAccess.getCollectionTypeCSAccess().getGroup(), "rule__CollectionTypeCS__Group__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup(), "rule__TupleTypeCS__Group__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup_2(), "rule__TupleTypeCS__Group_2__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup_2_1(), "rule__TupleTypeCS__Group_2_1__0");
					put(grammarAccess.getTuplePartCSAccess().getGroup(), "rule__TuplePartCS__Group__0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup(), "rule__CollectionLiteralExpCS__Group__0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2(), "rule__CollectionLiteralExpCS__Group_2__0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2_1(), "rule__CollectionLiteralExpCS__Group_2_1__0");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getGroup(), "rule__CollectionLiteralPartCS__Group__0");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_1(), "rule__CollectionLiteralPartCS__Group_1__0");
					put(grammarAccess.getTupleLiteralExpCSAccess().getGroup(), "rule__TupleLiteralExpCS__Group__0");
					put(grammarAccess.getTupleLiteralExpCSAccess().getGroup_3(), "rule__TupleLiteralExpCS__Group_3__0");
					put(grammarAccess.getTupleLiteralPartCSAccess().getGroup(), "rule__TupleLiteralPartCS__Group__0");
					put(grammarAccess.getTupleLiteralPartCSAccess().getGroup_1(), "rule__TupleLiteralPartCS__Group_1__0");
					put(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getGroup(), "rule__UnlimitedNaturalLiteralExpCS__Group__0");
					put(grammarAccess.getInvalidLiteralExpCSAccess().getGroup(), "rule__InvalidLiteralExpCS__Group__0");
					put(grammarAccess.getNullLiteralExpCSAccess().getGroup(), "rule__NullLiteralExpCS__Group__0");
					put(grammarAccess.getImpliesCSAccess().getGroup(), "rule__ImpliesCS__Group__0");
					put(grammarAccess.getImpliesCSAccess().getGroup_1(), "rule__ImpliesCS__Group_1__0");
					put(grammarAccess.getXorCSAccess().getGroup(), "rule__XorCS__Group__0");
					put(grammarAccess.getXorCSAccess().getGroup_1(), "rule__XorCS__Group_1__0");
					put(grammarAccess.getOrCSAccess().getGroup(), "rule__OrCS__Group__0");
					put(grammarAccess.getOrCSAccess().getGroup_1(), "rule__OrCS__Group_1__0");
					put(grammarAccess.getAndCSAccess().getGroup(), "rule__AndCS__Group__0");
					put(grammarAccess.getAndCSAccess().getGroup_1(), "rule__AndCS__Group_1__0");
					put(grammarAccess.getEqualityCSAccess().getGroup(), "rule__EqualityCS__Group__0");
					put(grammarAccess.getEqualityCSAccess().getGroup_1(), "rule__EqualityCS__Group_1__0");
					put(grammarAccess.getRelationalCSAccess().getGroup(), "rule__RelationalCS__Group__0");
					put(grammarAccess.getRelationalCSAccess().getGroup_1(), "rule__RelationalCS__Group_1__0");
					put(grammarAccess.getAdditiveCSAccess().getGroup(), "rule__AdditiveCS__Group__0");
					put(grammarAccess.getAdditiveCSAccess().getGroup_1(), "rule__AdditiveCS__Group_1__0");
					put(grammarAccess.getMultiplicativeCSAccess().getGroup(), "rule__MultiplicativeCS__Group__0");
					put(grammarAccess.getMultiplicativeCSAccess().getGroup_1(), "rule__MultiplicativeCS__Group_1__0");
					put(grammarAccess.getUnaryCSAccess().getGroup_1(), "rule__UnaryCS__Group_1__0");
					put(grammarAccess.getCalledExpCSAccess().getGroup(), "rule__CalledExpCS__Group__0");
					put(grammarAccess.getCalledExpCSAccess().getGroup_1(), "rule__CalledExpCS__Group_1__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_0(), "rule__CallArgumentsCS__Group_0__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_0_4_0(), "rule__CallArgumentsCS__Group_0_4_0__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_0_4_0_1_0(), "rule__CallArgumentsCS__Group_0_4_0_1_0__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_0_4_0_1_1(), "rule__CallArgumentsCS__Group_0_4_0_1_1__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_0_4_1(), "rule__CallArgumentsCS__Group_0_4_1__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_0_4_1_1(), "rule__CallArgumentsCS__Group_0_4_1_1__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_1(), "rule__CallArgumentsCS__Group_1__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_1_3(), "rule__CallArgumentsCS__Group_1_3__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_1_3_2(), "rule__CallArgumentsCS__Group_1_3_2__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_1_5(), "rule__CallArgumentsCS__Group_1_5__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_1_5_1(), "rule__CallArgumentsCS__Group_1_5_1__0");
					put(grammarAccess.getCallArgumentsCSAccess().getGroup_1_5_1_1(), "rule__CallArgumentsCS__Group_1_5_1_1__0");
					put(grammarAccess.getIteratorVariableCSAccess().getGroup(), "rule__IteratorVariableCS__Group__0");
					put(grammarAccess.getIteratorVariableCSAccess().getGroup_1(), "rule__IteratorVariableCS__Group_1__0");
					put(grammarAccess.getIteratorAccumulatorCSAccess().getGroup(), "rule__IteratorAccumulatorCS__Group__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_3(), "rule__PrimaryExpCS__Group_3__0");
					put(grammarAccess.getIfExpCSAccess().getGroup(), "rule__IfExpCS__Group__0");
					put(grammarAccess.getLetExpCSAccess().getGroup(), "rule__LetExpCS__Group__0");
					put(grammarAccess.getLetExpCSAccess().getGroup_2(), "rule__LetExpCS__Group_2__0");
					put(grammarAccess.getLetVariableCSAccess().getGroup(), "rule__LetVariableCS__Group__0");
					put(grammarAccess.getModelAccess().getImportsAssignment_0(), "rule__Model__ImportsAssignment_0");
					put(grammarAccess.getModelAccess().getPackagesAssignment_1_0(), "rule__Model__PackagesAssignment_1_0");
					put(grammarAccess.getModelAccess().getContextsAssignment_1_1(), "rule__Model__ContextsAssignment_1_1");
					put(grammarAccess.getImportCSAccess().getImportedNamespaceAssignment_1(), "rule__ImportCS__ImportedNamespaceAssignment_1");
					put(grammarAccess.getPackageDeclarationCSAccess().getNameAssignment_1(), "rule__PackageDeclarationCS__NameAssignment_1");
					put(grammarAccess.getPackageDeclarationCSAccess().getContextsAssignment_2(), "rule__PackageDeclarationCS__ContextsAssignment_2");
					put(grammarAccess.getPropertyContextDeclCSAccess().getContextNameAssignment_1(), "rule__PropertyContextDeclCS__ContextNameAssignment_1");
					put(grammarAccess.getPropertyContextDeclCSAccess().getTypeAssignment_3(), "rule__PropertyContextDeclCS__TypeAssignment_3");
					put(grammarAccess.getPropertyContextDeclCSAccess().getInitAssignment_4_0_0(), "rule__PropertyContextDeclCS__InitAssignment_4_0_0");
					put(grammarAccess.getPropertyContextDeclCSAccess().getDerAssignment_4_0_1(), "rule__PropertyContextDeclCS__DerAssignment_4_0_1");
					put(grammarAccess.getPropertyContextDeclCSAccess().getDerAssignment_4_1_0(), "rule__PropertyContextDeclCS__DerAssignment_4_1_0");
					put(grammarAccess.getPropertyContextDeclCSAccess().getInitAssignment_4_1_1(), "rule__PropertyContextDeclCS__InitAssignment_4_1_1");
					put(grammarAccess.getInitCSAccess().getExpressionAssignment_2(), "rule__InitCS__ExpressionAssignment_2");
					put(grammarAccess.getDerCSAccess().getExpressionAssignment_2(), "rule__DerCS__ExpressionAssignment_2");
					put(grammarAccess.getClassifierContextDeclCSAccess().getSelfNameAssignment_1_0(), "rule__ClassifierContextDeclCS__SelfNameAssignment_1_0");
					put(grammarAccess.getClassifierContextDeclCSAccess().getContextNameAssignment_2(), "rule__ClassifierContextDeclCS__ContextNameAssignment_2");
					put(grammarAccess.getClassifierContextDeclCSAccess().getInvsAssignment_3_0(), "rule__ClassifierContextDeclCS__InvsAssignment_3_0");
					put(grammarAccess.getClassifierContextDeclCSAccess().getDefsAssignment_3_1(), "rule__ClassifierContextDeclCS__DefsAssignment_3_1");
					put(grammarAccess.getInvCSAccess().getConstraintNameAssignment_1(), "rule__InvCS__ConstraintNameAssignment_1");
					put(grammarAccess.getInvCSAccess().getExpressionAssignment_3(), "rule__InvCS__ExpressionAssignment_3");
					put(grammarAccess.getDefCSAccess().getStaticAssignment_0(), "rule__DefCS__StaticAssignment_0");
					put(grammarAccess.getDefCSAccess().getConstraintNameAssignment_2(), "rule__DefCS__ConstraintNameAssignment_2");
					put(grammarAccess.getDefCSAccess().getConstrainedNameAssignment_4(), "rule__DefCS__ConstrainedNameAssignment_4");
					put(grammarAccess.getDefCSAccess().getParametersAssignment_5_1_0(), "rule__DefCS__ParametersAssignment_5_1_0");
					put(grammarAccess.getDefCSAccess().getParametersAssignment_5_1_1_1(), "rule__DefCS__ParametersAssignment_5_1_1_1");
					put(grammarAccess.getDefCSAccess().getTypeAssignment_7(), "rule__DefCS__TypeAssignment_7");
					put(grammarAccess.getDefCSAccess().getExpressionAssignment_9(), "rule__DefCS__ExpressionAssignment_9");
					put(grammarAccess.getOperationContextDeclCSAccess().getContextNameAssignment_1(), "rule__OperationContextDeclCS__ContextNameAssignment_1");
					put(grammarAccess.getOperationContextDeclCSAccess().getParametersAssignment_3_0(), "rule__OperationContextDeclCS__ParametersAssignment_3_0");
					put(grammarAccess.getOperationContextDeclCSAccess().getParametersAssignment_3_1_1(), "rule__OperationContextDeclCS__ParametersAssignment_3_1_1");
					put(grammarAccess.getOperationContextDeclCSAccess().getTypeAssignment_6(), "rule__OperationContextDeclCS__TypeAssignment_6");
					put(grammarAccess.getOperationContextDeclCSAccess().getPresAssignment_7_0(), "rule__OperationContextDeclCS__PresAssignment_7_0");
					put(grammarAccess.getOperationContextDeclCSAccess().getPostsAssignment_7_1(), "rule__OperationContextDeclCS__PostsAssignment_7_1");
					put(grammarAccess.getOperationContextDeclCSAccess().getBodiesAssignment_7_2(), "rule__OperationContextDeclCS__BodiesAssignment_7_2");
					put(grammarAccess.getParameterCSAccess().getNameAssignment_0(), "rule__ParameterCS__NameAssignment_0");
					put(grammarAccess.getParameterCSAccess().getTypeAssignment_1_1(), "rule__ParameterCS__TypeAssignment_1_1");
					put(grammarAccess.getParameterCSAccess().getInitExpressionAssignment_2_1(), "rule__ParameterCS__InitExpressionAssignment_2_1");
					put(grammarAccess.getPreCSAccess().getConstraintNameAssignment_1(), "rule__PreCS__ConstraintNameAssignment_1");
					put(grammarAccess.getPreCSAccess().getExpressionAssignment_3(), "rule__PreCS__ExpressionAssignment_3");
					put(grammarAccess.getPostCSAccess().getConstraintNameAssignment_1(), "rule__PostCS__ConstraintNameAssignment_1");
					put(grammarAccess.getPostCSAccess().getExpressionAssignment_3(), "rule__PostCS__ExpressionAssignment_3");
					put(grammarAccess.getBodyCSAccess().getConstraintNameAssignment_1(), "rule__BodyCS__ConstraintNameAssignment_1");
					put(grammarAccess.getBodyCSAccess().getExpressionAssignment_3(), "rule__BodyCS__ExpressionAssignment_3");
					put(grammarAccess.getOclMessageExpCSAccess().getSourceAssignment_0(), "rule__OclMessageExpCS__SourceAssignment_0");
					put(grammarAccess.getOclMessageExpCSAccess().getOpAssignment_1(), "rule__OclMessageExpCS__OpAssignment_1");
					put(grammarAccess.getOclMessageExpCSAccess().getMessageNameAssignment_2(), "rule__OclMessageExpCS__MessageNameAssignment_2");
					put(grammarAccess.getOclMessageExpCSAccess().getArgumentsAssignment_4_0(), "rule__OclMessageExpCS__ArgumentsAssignment_4_0");
					put(grammarAccess.getOclMessageExpCSAccess().getArgumentsAssignment_4_1_1(), "rule__OclMessageExpCS__ArgumentsAssignment_4_1_1");
					put(grammarAccess.getOclMessageArgCSAccess().getTypeAssignment_0_2_1(), "rule__OclMessageArgCS__TypeAssignment_0_2_1");
					put(grammarAccess.getTupleKeywordCSAccess().getValueAssignment(), "rule__TupleKeywordCS__ValueAssignment");
					put(grammarAccess.getSelfKeywordCSAccess().getValueAssignment(), "rule__SelfKeywordCS__ValueAssignment");
					put(grammarAccess.getSimpleNameCSAccess().getValueAssignment(), "rule__SimpleNameCS__ValueAssignment");
					put(grammarAccess.getPathNameCSAccess().getSimpleNamesAssignment_0(), "rule__PathNameCS__SimpleNamesAssignment_0");
					put(grammarAccess.getPathNameCSAccess().getSimpleNamesAssignment_1_1(), "rule__PathNameCS__SimpleNamesAssignment_1_1");
					put(grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_0(), "rule__PrimitiveTypeCS__ValueAssignment_0");
					put(grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_1(), "rule__PrimitiveTypeCS__ValueAssignment_1");
					put(grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_2(), "rule__PrimitiveTypeCS__ValueAssignment_2");
					put(grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_3(), "rule__PrimitiveTypeCS__ValueAssignment_3");
					put(grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_4(), "rule__PrimitiveTypeCS__ValueAssignment_4");
					put(grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_5(), "rule__PrimitiveTypeCS__ValueAssignment_5");
					put(grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_6(), "rule__PrimitiveTypeCS__ValueAssignment_6");
					put(grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_7(), "rule__PrimitiveTypeCS__ValueAssignment_7");
					put(grammarAccess.getCollectionTypeIdentifierCSAccess().getValueAssignment_0(), "rule__CollectionTypeIdentifierCS__ValueAssignment_0");
					put(grammarAccess.getCollectionTypeIdentifierCSAccess().getValueAssignment_1(), "rule__CollectionTypeIdentifierCS__ValueAssignment_1");
					put(grammarAccess.getCollectionTypeIdentifierCSAccess().getValueAssignment_2(), "rule__CollectionTypeIdentifierCS__ValueAssignment_2");
					put(grammarAccess.getCollectionTypeIdentifierCSAccess().getValueAssignment_3(), "rule__CollectionTypeIdentifierCS__ValueAssignment_3");
					put(grammarAccess.getCollectionTypeIdentifierCSAccess().getValueAssignment_4(), "rule__CollectionTypeIdentifierCS__ValueAssignment_4");
					put(grammarAccess.getCollectionTypeCSAccess().getValueAssignment_0(), "rule__CollectionTypeCS__ValueAssignment_0");
					put(grammarAccess.getCollectionTypeCSAccess().getTypeCSAssignment_2(), "rule__CollectionTypeCS__TypeCSAssignment_2");
					put(grammarAccess.getTupleTypeCSAccess().getValueAssignment_0(), "rule__TupleTypeCS__ValueAssignment_0");
					put(grammarAccess.getTupleTypeCSAccess().getPartAssignment_2_0(), "rule__TupleTypeCS__PartAssignment_2_0");
					put(grammarAccess.getTupleTypeCSAccess().getPartAssignment_2_1_1(), "rule__TupleTypeCS__PartAssignment_2_1_1");
					put(grammarAccess.getTuplePartCSAccess().getNameAssignment_0(), "rule__TuplePartCS__NameAssignment_0");
					put(grammarAccess.getTuplePartCSAccess().getTypeAssignment_2(), "rule__TuplePartCS__TypeAssignment_2");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsAssignment_2_0(), "rule__CollectionLiteralExpCS__CollectionLiteralPartsAssignment_2_0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsAssignment_2_1_1(), "rule__CollectionLiteralExpCS__CollectionLiteralPartsAssignment_2_1_1");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSAssignment_0(), "rule__CollectionLiteralPartCS__ExpressionCSAssignment_0");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSAssignment_1_1(), "rule__CollectionLiteralPartCS__LastExpressionCSAssignment_1_1");
					put(grammarAccess.getTupleLiteralExpCSAccess().getPartAssignment_2(), "rule__TupleLiteralExpCS__PartAssignment_2");
					put(grammarAccess.getTupleLiteralExpCSAccess().getPartAssignment_3_1(), "rule__TupleLiteralExpCS__PartAssignment_3_1");
					put(grammarAccess.getTupleLiteralPartCSAccess().getNameAssignment_0(), "rule__TupleLiteralPartCS__NameAssignment_0");
					put(grammarAccess.getTupleLiteralPartCSAccess().getTypeAssignment_1_1(), "rule__TupleLiteralPartCS__TypeAssignment_1_1");
					put(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionAssignment_3(), "rule__TupleLiteralPartCS__InitExpressionAssignment_3");
					put(grammarAccess.getIntegerLiteralExpCSAccess().getIntegerSymbolAssignment(), "rule__IntegerLiteralExpCS__IntegerSymbolAssignment");
					put(grammarAccess.getRealLiteralExpCSAccess().getRealSymbolAssignment(), "rule__RealLiteralExpCS__RealSymbolAssignment");
					put(grammarAccess.getStringLiteralExpCSAccess().getStringSymbolAssignment(), "rule__StringLiteralExpCS__StringSymbolAssignment");
					put(grammarAccess.getBooleanLiteralExpCSAccess().getValueAssignment_0(), "rule__BooleanLiteralExpCS__ValueAssignment_0");
					put(grammarAccess.getBooleanLiteralExpCSAccess().getValueAssignment_1(), "rule__BooleanLiteralExpCS__ValueAssignment_1");
					put(grammarAccess.getImpliesCSAccess().getOpAssignment_1_1(), "rule__ImpliesCS__OpAssignment_1_1");
					put(grammarAccess.getImpliesCSAccess().getRightAssignment_1_2(), "rule__ImpliesCS__RightAssignment_1_2");
					put(grammarAccess.getXorCSAccess().getOpAssignment_1_1(), "rule__XorCS__OpAssignment_1_1");
					put(grammarAccess.getXorCSAccess().getRightAssignment_1_2(), "rule__XorCS__RightAssignment_1_2");
					put(grammarAccess.getOrCSAccess().getOpAssignment_1_1(), "rule__OrCS__OpAssignment_1_1");
					put(grammarAccess.getOrCSAccess().getRightAssignment_1_2(), "rule__OrCS__RightAssignment_1_2");
					put(grammarAccess.getAndCSAccess().getOpAssignment_1_1(), "rule__AndCS__OpAssignment_1_1");
					put(grammarAccess.getAndCSAccess().getRightAssignment_1_2(), "rule__AndCS__RightAssignment_1_2");
					put(grammarAccess.getEqualityCSAccess().getOpAssignment_1_1(), "rule__EqualityCS__OpAssignment_1_1");
					put(grammarAccess.getEqualityCSAccess().getRightAssignment_1_2(), "rule__EqualityCS__RightAssignment_1_2");
					put(grammarAccess.getRelationalCSAccess().getOpAssignment_1_1(), "rule__RelationalCS__OpAssignment_1_1");
					put(grammarAccess.getRelationalCSAccess().getRightAssignment_1_2(), "rule__RelationalCS__RightAssignment_1_2");
					put(grammarAccess.getAdditiveCSAccess().getOpAssignment_1_1(), "rule__AdditiveCS__OpAssignment_1_1");
					put(grammarAccess.getAdditiveCSAccess().getRightAssignment_1_2(), "rule__AdditiveCS__RightAssignment_1_2");
					put(grammarAccess.getMultiplicativeCSAccess().getOpAssignment_1_1(), "rule__MultiplicativeCS__OpAssignment_1_1");
					put(grammarAccess.getMultiplicativeCSAccess().getRightAssignment_1_2(), "rule__MultiplicativeCS__RightAssignment_1_2");
					put(grammarAccess.getUnaryCSAccess().getOpAssignment_1_1(), "rule__UnaryCS__OpAssignment_1_1");
					put(grammarAccess.getUnaryCSAccess().getSourceAssignment_1_2(), "rule__UnaryCS__SourceAssignment_1_2");
					put(grammarAccess.getCalledExpCSAccess().getCallArgumentsAssignment_1_1(), "rule__CalledExpCS__CallArgumentsAssignment_1_1");
					put(grammarAccess.getCallArgumentsCSAccess().getPathNameAssignment_0_2(), "rule__CallArgumentsCS__PathNameAssignment_0_2");
					put(grammarAccess.getCallArgumentsCSAccess().getVariable1Assignment_0_4_0_0(), "rule__CallArgumentsCS__Variable1Assignment_0_4_0_0");
					put(grammarAccess.getCallArgumentsCSAccess().getVariable2Assignment_0_4_0_1_0_1(), "rule__CallArgumentsCS__Variable2Assignment_0_4_0_1_0_1");
					put(grammarAccess.getCallArgumentsCSAccess().getVariable2Assignment_0_4_0_1_1_1(), "rule__CallArgumentsCS__Variable2Assignment_0_4_0_1_1_1");
					put(grammarAccess.getCallArgumentsCSAccess().getBodyAssignment_0_4_0_3(), "rule__CallArgumentsCS__BodyAssignment_0_4_0_3");
					put(grammarAccess.getCallArgumentsCSAccess().getArgumentsAssignment_0_4_1_0(), "rule__CallArgumentsCS__ArgumentsAssignment_0_4_1_0");
					put(grammarAccess.getCallArgumentsCSAccess().getArgumentsAssignment_0_4_1_1_1(), "rule__CallArgumentsCS__ArgumentsAssignment_0_4_1_1_1");
					put(grammarAccess.getCallArgumentsCSAccess().getPathNameAssignment_1_2(), "rule__CallArgumentsCS__PathNameAssignment_1_2");
					put(grammarAccess.getCallArgumentsCSAccess().getIndexesAssignment_1_3_1(), "rule__CallArgumentsCS__IndexesAssignment_1_3_1");
					put(grammarAccess.getCallArgumentsCSAccess().getIndexesAssignment_1_3_2_1(), "rule__CallArgumentsCS__IndexesAssignment_1_3_2_1");
					put(grammarAccess.getCallArgumentsCSAccess().getIsPreAssignment_1_4(), "rule__CallArgumentsCS__IsPreAssignment_1_4");
					put(grammarAccess.getCallArgumentsCSAccess().getArgumentsAssignment_1_5_1_0(), "rule__CallArgumentsCS__ArgumentsAssignment_1_5_1_0");
					put(grammarAccess.getCallArgumentsCSAccess().getArgumentsAssignment_1_5_1_1_1(), "rule__CallArgumentsCS__ArgumentsAssignment_1_5_1_1_1");
					put(grammarAccess.getIteratorVariableCSAccess().getNameAssignment_0(), "rule__IteratorVariableCS__NameAssignment_0");
					put(grammarAccess.getIteratorVariableCSAccess().getTypeAssignment_1_1(), "rule__IteratorVariableCS__TypeAssignment_1_1");
					put(grammarAccess.getIteratorAccumulatorCSAccess().getNameAssignment_0(), "rule__IteratorAccumulatorCS__NameAssignment_0");
					put(grammarAccess.getIteratorAccumulatorCSAccess().getTypeAssignment_2(), "rule__IteratorAccumulatorCS__TypeAssignment_2");
					put(grammarAccess.getIteratorAccumulatorCSAccess().getInitExpressionAssignment_4(), "rule__IteratorAccumulatorCS__InitExpressionAssignment_4");
					put(grammarAccess.getIfExpCSAccess().getConditionAssignment_1(), "rule__IfExpCS__ConditionAssignment_1");
					put(grammarAccess.getIfExpCSAccess().getThenExpressionAssignment_3(), "rule__IfExpCS__ThenExpressionAssignment_3");
					put(grammarAccess.getIfExpCSAccess().getElseExpressionAssignment_5(), "rule__IfExpCS__ElseExpressionAssignment_5");
					put(grammarAccess.getLetExpCSAccess().getVariableAssignment_1(), "rule__LetExpCS__VariableAssignment_1");
					put(grammarAccess.getLetExpCSAccess().getVariableAssignment_2_1(), "rule__LetExpCS__VariableAssignment_2_1");
					put(grammarAccess.getLetExpCSAccess().getInAssignment_4(), "rule__LetExpCS__InAssignment_4");
					put(grammarAccess.getLetVariableCSAccess().getNameAssignment_0(), "rule__LetVariableCS__NameAssignment_0");
					put(grammarAccess.getLetVariableCSAccess().getTypeAssignment_2(), "rule__LetVariableCS__TypeAssignment_2");
					put(grammarAccess.getLetVariableCSAccess().getInitExpressionAssignment_4(), "rule__LetVariableCS__InitExpressionAssignment_4");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.ocl.examples.xtext.completeocl.ui.contentassist.antlr.internal.InternalCompleteOCLParser typedParser = (org.eclipse.ocl.examples.xtext.completeocl.ui.contentassist.antlr.internal.InternalCompleteOCLParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public CompleteOCLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CompleteOCLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
