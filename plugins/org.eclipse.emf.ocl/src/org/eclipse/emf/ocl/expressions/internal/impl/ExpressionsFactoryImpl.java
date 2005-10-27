/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions.internal.impl;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.AssociationEndCallExp;
import org.eclipse.emf.ocl.expressions.AttributeCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OclMessageArg;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;
import org.eclipse.emf.ocl.internal.parser.OclLexer;
import org.eclipse.emf.ocl.internal.parser.OclParser;
import org.eclipse.emf.ocl.internal.parser.OclParserTokenTypes;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.osgi.util.NLS;

import antlr.Token;
import antlr.TokenStreamException;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory </b>. <!--
 * end-user-doc -->
 * @generated
 */
public class ExpressionsFactoryImpl extends EFactoryImpl implements
        ExpressionsFactory {
    private static final String InvalidClass_ERROR_ =
            OclMessages.InvalidClass_ERROR_;

    private static final String InvalidDatatype_ERROR_ =
            OclMessages.InvalidDatatype_ERROR_;
    
    /** @generated NOT */
	private static final String PRE = "pre";//$NON-NLS-1$

    /** @generated NOT */
	private static final String POST = "post";//$NON-NLS-1$

    /** @generated NOT */
	private static final char SPACE_CHAR = ' ';

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    public ExpressionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
    public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
        case ExpressionsPackage.ASSOCIATION_END_CALL_EXP:
            return createAssociationEndCallExp();
        case ExpressionsPackage.ATTRIBUTE_CALL_EXP:
            return createAttributeCallExp();
        case ExpressionsPackage.BOOLEAN_LITERAL_EXP:
            return createBooleanLiteralExp();
        case ExpressionsPackage.COLLECTION_ITEM:
            return createCollectionItem();
        case ExpressionsPackage.COLLECTION_LITERAL_EXP:
            return createCollectionLiteralExp();
        case ExpressionsPackage.COLLECTION_LITERAL_PART:
            return createCollectionLiteralPart();
        case ExpressionsPackage.COLLECTION_RANGE:
            return createCollectionRange();
        case ExpressionsPackage.ENUM_LITERAL_EXP:
            return createEnumLiteralExp();
        case ExpressionsPackage.IF_EXP:
            return createIfExp();
        case ExpressionsPackage.INTEGER_LITERAL_EXP:
            return createIntegerLiteralExp();
        case ExpressionsPackage.ITERATE_EXP:
            return createIterateExp();
        case ExpressionsPackage.ITERATOR_EXP:
            return createIteratorExp();
        case ExpressionsPackage.LET_EXP:
            return createLetExp();
        case ExpressionsPackage.LOOP_EXP:
            return createLoopExp();
        case ExpressionsPackage.OCL_MESSAGE_ARG:
            return createOclMessageArg();
        case ExpressionsPackage.OPERATION_CALL_EXP:
            return createOperationCallExp();
        case ExpressionsPackage.REAL_LITERAL_EXP:
            return createRealLiteralExp();
        case ExpressionsPackage.STRING_LITERAL_EXP:
            return createStringLiteralExp();
        case ExpressionsPackage.TUPLE_LITERAL_EXP:
            return createTupleLiteralExp();
        case ExpressionsPackage.UNSPECIFIED_VALUE_EXP:
            return createUnspecifiedValueExp();
        case ExpressionsPackage.VARIABLE_DECLARATION:
            return createVariableDeclaration();
        case ExpressionsPackage.VARIABLE_EXP:
            return createVariableExp();
        default:
            String message = NLS.bind(InvalidClass_ERROR_,
                    new Object[] { eClass.getName() });
            IllegalArgumentException error = new IllegalArgumentException(
                    message);
            OclEnginePlugin.throwing(getClass(), "create", error);//$NON-NLS-1$
            throw error;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
    public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
        case ExpressionsPackage.COLLECTION_KIND:
            return CollectionKind.get(initialValue);
        default: {
            String message = NLS.bind(InvalidDatatype_ERROR_,
                    new Object[] { eDataType.getName() });
            IllegalArgumentException error = new IllegalArgumentException(
                    message);
            OclEnginePlugin.throwing(getClass(), "createFromString", error);//$NON-NLS-1$
            throw error;
			}

		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionsPackage.COLLECTION_KIND:
				return instanceValue == null ? null : instanceValue.toString();
			case ExpressionsPackage.VISITOR:
				return convertVisitorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * @generated NOT
	 */
	public OclExpression createOclExpression(String text)
			throws antlr.SemanticException,
				antlr.TokenStreamException,
				antlr.RecognitionException {
		//-- remove pre/post stuff
		text = removePrePostKeyword(text);
		//
		OclLexer lexer = new OclLexer(new StringReader(text));
		OclParser parser = new OclParser(lexer);
		parser.setTraceFlag(false);

		EList constraints = new BasicEList();
		//parser.classifierContextDeclCS(null, constraints);
		//		parser.classifierContextDeclCS(null, constraints);
		parser.packageDeclarationCS(constraints);
		Constraint constraint = (Constraint) constraints.get(0);
		return constraint.getBody();
	}

	private String removePrePostKeyword(String txt) throws TokenStreamException {
		boolean modified = false;
		Token token = null;
		OclLexer lexer = new OclLexer(new StringReader(txt));
		List tokens = new ArrayList();
		do {
			token = lexer.nextToken();
			if ((token.getType() == OclParserTokenTypes.PRE)
				|| ((token.getType() == OclParserTokenTypes.NAME) && (token
					.getText().equals(PRE) || token.getText().equals(POST)))) {
				//check next token if it is a colon
				Token nextToken = lexer.nextToken();
				if (nextToken.getType() != OclParserTokenTypes.COLON) {
					//return them back
					tokens.add(token);
					tokens.add(nextToken);
				} else {
					//don't add these token to list and signal that we modified the txt
					modified = true;
				}
			} else {
				tokens.add(token);
			}
		} while (token.getType() != Token.EOF_TYPE);

		if (modified) {
			//build the new txt
			StringBuffer buffer = new StringBuffer();
			Iterator it = tokens.iterator();
			while (it.hasNext()) {
				token = (Token) it.next();
				if (token.getType() != Token.EOF_TYPE) {
					buffer.append(token.getText());
					buffer.append(SPACE_CHAR);
				}
			}
			return buffer.toString();
		} else {
			//no modification occured then just return the original txt
			return txt;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public AssociationEndCallExp createAssociationEndCallExp() {
		AssociationEndCallExpImpl associationEndCallExp = new AssociationEndCallExpImpl();
		return associationEndCallExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public AttributeCallExp createAttributeCallExp() {
		AttributeCallExpImpl attributeCallExp = new AttributeCallExpImpl();
		return attributeCallExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public BooleanLiteralExp createBooleanLiteralExp() {
		BooleanLiteralExpImpl booleanLiteralExp = new BooleanLiteralExpImpl();
		return booleanLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public CollectionItem createCollectionItem() {
		CollectionItemImpl collectionItem = new CollectionItemImpl();
		return collectionItem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public CollectionLiteralExp createCollectionLiteralExp() {
		CollectionLiteralExpImpl collectionLiteralExp = new CollectionLiteralExpImpl();
		return collectionLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public CollectionLiteralPart createCollectionLiteralPart() {
		CollectionLiteralPartImpl collectionLiteralPart = new CollectionLiteralPartImpl();
		return collectionLiteralPart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public CollectionRange createCollectionRange() {
		CollectionRangeImpl collectionRange = new CollectionRangeImpl();
		return collectionRange;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EnumLiteralExp createEnumLiteralExp() {
		EnumLiteralExpImpl enumLiteralExp = new EnumLiteralExpImpl();
		return enumLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public IfExp createIfExp() {
		IfExpImpl ifExp = new IfExpImpl();
		return ifExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public IntegerLiteralExp createIntegerLiteralExp() {
		IntegerLiteralExpImpl integerLiteralExp = new IntegerLiteralExpImpl();
		return integerLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public IterateExp createIterateExp() {
		IterateExpImpl iterateExp = new IterateExpImpl();
		return iterateExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public IteratorExp createIteratorExp() {
		IteratorExpImpl iteratorExp = new IteratorExpImpl();
		return iteratorExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public LetExp createLetExp() {
		LetExpImpl letExp = new LetExpImpl();
		return letExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public LoopExp createLoopExp() {
		LoopExpImpl loopExp = new LoopExpImpl();
		return loopExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public OclMessageArg createOclMessageArg() {
		OclMessageArgImpl oclMessageArg = new OclMessageArgImpl();
		return oclMessageArg;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public OperationCallExp createOperationCallExp() {
		OperationCallExpImpl operationCallExp = new OperationCallExpImpl();
		return operationCallExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public RealLiteralExp createRealLiteralExp() {
		RealLiteralExpImpl realLiteralExp = new RealLiteralExpImpl();
		return realLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public StringLiteralExp createStringLiteralExp() {
		StringLiteralExpImpl stringLiteralExp = new StringLiteralExpImpl();
		return stringLiteralExp;
	}

    public StringLiteralExp createStringLiteralExp(String s) {
        StringLiteralExp stringLiteralExp = new StringLiteralExpImpl(s);
        return stringLiteralExp;
    }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public TupleLiteralExp createTupleLiteralExp() {
		TupleLiteralExpImpl tupleLiteralExp = new TupleLiteralExpImpl();
		return tupleLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public UnspecifiedValueExp createUnspecifiedValueExp() {
		UnspecifiedValueExpImpl unspecifiedValueExp = new UnspecifiedValueExpImpl();
		return unspecifiedValueExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public VariableExp createVariableExp() {
		VariableExpImpl variableExp = new VariableExpImpl();
		return variableExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClassCallExp createAssociationClassCallExp() {
		AssociationClassCallExpImpl associationClassCallExp = new AssociationClassCallExpImpl();
		return associationClassCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visitor createVisitorFromString(EDataType eDataType, String initialValue) {
		return (Visitor)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisitorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ExpressionsPackage getExpressionsPackage() {
		return (ExpressionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
    public static ExpressionsPackage getPackage() {
		return ExpressionsPackage.eINSTANCE;
	}

} //ExpressionsFactoryImpl
