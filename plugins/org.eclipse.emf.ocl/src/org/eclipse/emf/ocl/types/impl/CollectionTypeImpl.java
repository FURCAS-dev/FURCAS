/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: CollectionTypeImpl.java,v 1.10 2007/01/29 20:31:18 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.internal.parser.CompatibilityParser;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.emf.ocl.utilities.UtilitiesPackage;
import org.eclipse.emf.ocl.utilities.impl.Bag;
import org.eclipse.emf.ocl.utilities.impl.CollectionFactory;
import org.eclipse.ocl.internal.l10n.OCLMessages;

/**
 * @generated
 */
public class CollectionTypeImpl extends EDataTypeImpl implements CollectionType {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int START_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartPosition()
	 * @generated
	 * @ordered
	 */
	protected int startPosition = START_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int END_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPosition()
	 * @generated
	 * @ordered
	 */
	protected int endPosition = END_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeStartPosition() <em>Type Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeStartPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int TYPE_START_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getTypeStartPosition() <em>Type Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeStartPosition()
	 * @generated
	 * @ordered
	 */
	protected int typeStartPosition = TYPE_START_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeEndPosition() <em>Type End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeEndPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int TYPE_END_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getTypeEndPosition() <em>Type End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeEndPosition()
	 * @generated
	 * @ordered
	 */
	protected int typeEndPosition = TYPE_END_POSITION_EDEFAULT;
    

    // A <code>CollectionFactory</code> makes java collections given an ocl
    // collection type.
    private static CollectionFactory collFactory = CollectionFactory
            .getInstance();

    /*
     * Define Collection type instances for each of the stdlib collection types
     */
    public static SequenceType OCL_SEQUENCE = TypesPackage.eINSTANCE
            .getTypesFactory().createSequenceType(AnyTypeImpl.OCL_T);

    public static SetType OCL_SET = TypesPackage.eINSTANCE.getTypesFactory()
            .createSetType(AnyTypeImpl.OCL_T);

    public static OrderedSetType OCL_ORDERED_SET = TypesPackage.eINSTANCE
            .getTypesFactory().createOrderedSetType(AnyTypeImpl.OCL_T);

    public static BagType OCL_BAG = TypesPackage.eINSTANCE.getTypesFactory()
            .createBagType(AnyTypeImpl.OCL_T);

    public static CollectionType OCL_COLLECTION = TypesPackage.eINSTANCE
            .getTypesFactory().createCollectionType(AnyTypeImpl.OCL_T);

    /** Name of the "first" property of a product tuple. */
    private static final String PRODUCT_FIRST = "first"; //$NON-NLS-1$
    
    /** Name of the "second" property of a product tuple. */
    private static final String PRODUCT_SECOND = "second"; //$NON-NLS-1$
    
    /**
     * Operations for Collections
     */
    private static EList operations;

    /**
     * Iterator operations.
     */
    private static EList iterators;
    
    /**
     * Returns the operation code from an operation name.
     * 
     * @param oper
     * @return the operation code
     */
    public int getOperationCodeFor(String oper) {

        if (oper.equals(COUNT_NAME))return COUNT;
        if (oper.equals(SIZE_NAME))return SIZE;
        if (oper.equals(EQUAL_NAME))return EQUAL;
        if (oper.equals(NOT_EQUAL_NAME))return NOT_EQUAL;
        if (oper.equals(EXCLUDES_NAME))return EXCLUDES;
        if (oper.equals(EXCLUDES_ALL_NAME))return EXCLUDES_ALL;
        if (oper.equals(INCLUDES_NAME))return INCLUDES;
        if (oper.equals(INCLUDES_ALL_NAME))return INCLUDES_ALL;
        if (oper.equals(IS_EMPTY_NAME))return IS_EMPTY;
        if (oper.equals(NOT_EMPTY_NAME))return NOT_EMPTY;
        if (oper.equals(PRODUCT_NAME))return PRODUCT;
        if (oper.equals(SUM_NAME))return SUM;
        if (oper.equals(AS_BAG_NAME))return AS_BAG;
        if (oper.equals(AS_ORDERED_SET_NAME))return AS_ORDERED_SET;
        if (oper.equals(AS_SEQUENCE_NAME))return AS_SEQUENCE;
        if (oper.equals(AS_SET_NAME))return AS_SET;
        if (oper.equals(EXCLUDING_NAME))return EXCLUDING;
        if (oper.equals(FLATTEN_NAME))return FLATTEN;
        if (oper.equals(INCLUDING_NAME))return INCLUDING;
        if (oper.equals(INTERSECTION_NAME))return INTERSECTION;
        if (oper.equals(UNION_NAME))return UNION;
        if (oper.equals(AT_NAME))return AT;
        if (oper.equals(FIRST_NAME))return FIRST;
        if (oper.equals(INDEX_OF_NAME))return INDEX_OF;
        if (oper.equals(INSERT_AT_NAME))return INSERT_AT;
        if (oper.equals(LAST_NAME))return LAST;
        if (oper.equals(PREPEND_NAME))return PREPEND;
        if (oper.equals(SUB_SEQUENCE_NAME))return SUB_SEQUENCE;
        if (oper.equals(APPEND_NAME))return APPEND;
        if (oper.equals(SUB_ORDERED_SET_NAME))return SUB_ORDERED_SET;
        if (oper.equals(MINUS_NAME))return MINUS;
        if (oper.equals(SYMMETRIC_DIFFERENCE_NAME))return SYMMETRIC_DIFFERENCE;
        if (oper.equals(EXISTS_NAME))return EXISTS;
        if (oper.equals(FOR_ALL_NAME))return FOR_ALL;
        if (oper.equals(IS_UNIQUE_NAME))return IS_UNIQUE;
        if (oper.equals(ONE_NAME))return ONE;
        if (oper.equals(ANY_NAME))return ANY;
        if (oper.equals(COLLECT_NAME))return COLLECT;
        if (oper.equals(COLLECT_NESTED_NAME))return COLLECT_NESTED;
        if (oper.equals(CLOSURE_NAME))return CLOSURE;
        if (oper.equals(SELECT_NAME))return SELECT;
        if (oper.equals(REJECT_NAME))return REJECT;
        if (oper.equals(SORTED_BY_NAME))return SORTED_BY;
        
        return 0;
    }

    /**
     * Returns the String name of an operation.
     * 
     * @param opcode
     * @return the operation name
     */
    public String getOperationNameFor(int opcode) {

        switch (opcode) {
        case COUNT:
            return COUNT_NAME;
        case SIZE:
            return SIZE_NAME;
        case EQUAL:
        	return EQUAL_NAME;
        case NOT_EQUAL:
        	return NOT_EQUAL_NAME;
        case EXCLUDES:
            return EXCLUDES_NAME;
        case EXCLUDES_ALL:
            return EXCLUDES_ALL_NAME;
        case INCLUDES:
            return INCLUDES_NAME;
        case INCLUDES_ALL:
            return INCLUDES_ALL_NAME;
        case IS_EMPTY:
            return IS_EMPTY_NAME;
        case NOT_EMPTY:
            return NOT_EMPTY_NAME;
        case PRODUCT:
            return PRODUCT_NAME;
        case SUM:
            return SUM_NAME;
        case AS_BAG:
            return AS_BAG_NAME;
        case AS_ORDERED_SET:
            return AS_ORDERED_SET_NAME;
        case AS_SEQUENCE:
            return AS_SEQUENCE_NAME;
        case AS_SET:
            return AS_SET_NAME;
        case EXCLUDING:
            return EXCLUDING_NAME;
        case FLATTEN:
            return FLATTEN_NAME;
        case INCLUDING:
            return INCLUDING_NAME;
        case INTERSECTION:
            return INTERSECTION_NAME;
        case UNION:
            return UNION_NAME;
        case AT:
            return AT_NAME;
        case FIRST:
            return FIRST_NAME;
        case INDEX_OF:
            return INDEX_OF_NAME;
        case INSERT_AT:
            return INSERT_AT_NAME;
        case LAST:
            return LAST_NAME;
        case PREPEND:
            return PREPEND_NAME;
        case SUB_SEQUENCE:
            return SUB_SEQUENCE_NAME;
        case APPEND:
            return APPEND_NAME;
        case SUB_ORDERED_SET:
            return SUB_ORDERED_SET_NAME;
        case MINUS:
        	return MINUS_NAME;
        case SYMMETRIC_DIFFERENCE:
            return SYMMETRIC_DIFFERENCE_NAME; 
        case EXISTS:
        	return EXISTS_NAME;
        case FOR_ALL:
        	return FOR_ALL_NAME;
        case IS_UNIQUE:
        	return IS_UNIQUE_NAME;
        case ONE:
        	return ONE_NAME;
        case ANY:
        	return ANY_NAME;
        case COLLECT:
        	return COLLECT_NAME;
        case COLLECT_NESTED:
        	return COLLECT_NESTED_NAME;
        case CLOSURE:
        	return CLOSURE_NAME;
        case SELECT:
        	return SELECT_NAME;
        case REJECT:
        	return REJECT_NAME;
        case SORTED_BY:
        	return SORTED_BY_NAME;
        }
        return ""; //$NON-NLS-1$
    }

    /**
     * Initialiaze Operations defined on AnyType
     */
    protected static EList createOperations() {
    	EList result = new BasicEList();
    	
    	result.add(TypeUtil.createBinaryOperation(
                Types.OCL_INTEGER,
                COUNT_NAME, AnyTypeImpl.OCL_T, "object")); //$NON-NLS-1$
    	result.add(TypeUtil.createBinaryOperation(
                Types.OCL_BOOLEAN,
                EXCLUDES_NAME, AnyTypeImpl.OCL_T, "object")); //$NON-NLS-1$
    	result.add(TypeUtil.createBinaryOperation(
                Types.OCL_BOOLEAN,
                EXCLUDES_ALL_NAME, OCL_COLLECTION, "c2"));//$NON-NLS-1$
    	result.add(TypeUtil.createBinaryOperation(
                Types.OCL_BOOLEAN,
                INCLUDES_NAME, AnyTypeImpl.OCL_T, "object")); //$NON-NLS-1$
    	result.add(TypeUtil.createBinaryOperation(
                Types.OCL_BOOLEAN,
                INCLUDES_ALL_NAME, OCL_COLLECTION, "c2"));//$NON-NLS-1$
    	result.add(TypeUtil.createUnaryOperation(
                Types.OCL_BOOLEAN,
                IS_EMPTY_NAME));
    	result.add(TypeUtil.createUnaryOperation(
                Types.OCL_BOOLEAN,
                NOT_EMPTY_NAME));
    	result.add(TypeUtil.createBinaryOperation(
        		new SetTypeImpl(TypesFactory.eINSTANCE.createTupleType(
        			createTupleParts(
        				new String[] {PRODUCT_FIRST, PRODUCT_SECOND},
        				new EClassifier[] {AnyTypeImpl.OCL_T, AnyTypeImpl.OCL_T2}))),
                PRODUCT_NAME, new CollectionTypeImpl(AnyTypeImpl.OCL_T2), "c2"));//$NON-NLS-1$
    	result.add(TypeUtil.createUnaryOperation(
                Types.OCL_REAL,
                SUM_NAME));
    	result.add(TypeUtil.createUnaryOperation(
                Types.OCL_INTEGER,
                SIZE_NAME));
    	
        return result;
    }
    
    protected static EList createIterators() {
    	EList result = new BasicEList();
    	
    	result.add(TypeUtil.createBinaryOperation(
                Types.OCL_BOOLEAN,
                EXISTS_NAME,
                ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                Types.OCL_BOOLEAN,
                FOR_ALL_NAME,
                ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                Types.OCL_BOOLEAN,
                IS_UNIQUE_NAME,
                ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                Types.OCL_BOOLEAN,
                ONE_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                AnyTypeImpl.OCL_T,
                ANY_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                TypesFactory.eINSTANCE.createCollectionType(AnyTypeImpl.OCL_T2),
                COLLECT_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
    			TypesFactory.eINSTANCE.createSetType(AnyTypeImpl.OCL_T2),
                CLOSURE_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	return result;
    }

    public EList getOperations() {
        if (operations == null)
            operations = createOperations();
        return operations;
    }
    
    public EList getIterators() {
    	if (iterators == null) {
    		iterators = createIterators();
    	}
    	
    	return iterators;
    }

	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
    protected EClassifier elementType = null;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final CollectionKind KIND_EDEFAULT = CollectionKind.COLLECTION_LITERAL;

    protected CollectionTypeImpl() {
        super();
    }

    protected CollectionTypeImpl(EClassifier elementType) {
        super();
        this.elementType = elementType;
    }
	
	public String getName() {
		if (name == null) {
			if (elementType != null) {
				name = "Collection(" + elementType.getName() + ')'; //$NON-NLS-1$
			} else {
				name = "Collection(?)"; //$NON-NLS-1$
			}
		}
		
		return super.getName();
	}

    /**
     * Obtain the result type on a collection type operation. A conformance test
     * is performed, and the result type may be the common supertype of the
     * source and argument types, depending on the operation.
     * 
     * @param opcode
     * @param args
     * @return the result type
     */
    public EClassifier getResultTypeFor(EClassifier ownerType, int opcode, EList args)
            throws SemanticException {

        switch (opcode) {
        case SIZE:
        case COUNT:
            return Types.OCL_INTEGER;
        case INCLUDES:
        case EXCLUDES:
        case INCLUDES_ALL:
        case EXCLUDES_ALL:
        case IS_EMPTY:
        case NOT_EMPTY:
        case EQUAL:
        case NOT_EQUAL:
            return Types.OCL_BOOLEAN;
        case SUM:
            EClassifier type = getElementType();
            if (type != Types.OCL_REAL
                    && type != Types.OCL_INTEGER) {
                String message = OCLMessages.SumOperator_ERROR_;
                CompatibilityParser.ERR(message);
            }
            return type;
        case PRODUCT:
            /*
             * The result type is: Set(Tuple(first:T, second:T2) where T is the
             * elementType of this, and T2 is the elementType of the argument.
             */
            EClassifier t = getElementType();
            OCLExpression arg = (OCLExpression) args.get(0);
            CollectionType argType = (CollectionType) arg.getType();
            EClassifier t2 = argType.getElementType();
            SetType resultType = TypesFactory.eINSTANCE.createSetType();
            resultType.setElementType(TypesFactory.eINSTANCE.createTupleType(
            	createTupleParts(
            		new String[] {PRODUCT_FIRST, PRODUCT_SECOND},
            		new EClassifier[] {t, t2})));
            return resultType;
        case EXISTS:
        case FOR_ALL:
        case IS_UNIQUE:
        case ONE:
        	return Types.OCL_BOOLEAN;
        case ANY:
        	return getElementType();
        case COLLECT:
        	return TypesFactory.eINSTANCE.createCollectionType(AnyTypeImpl.OCL_T2);
        case CLOSURE:
        	return TypesFactory.eINSTANCE.createSetType(AnyTypeImpl.OCL_T2);
        }
        String message = OCLMessages.bind(
        		OCLMessages.CollectionType_ERROR_,
                this.getName(),
                getOperationNameFor(opcode));
        CompatibilityParser.ERR(message);
        return null;
    }
    
    private static List createTupleParts(String[] names, EClassifier[] types) {
    	List result = new java.util.ArrayList();
    	
    	for (int i = 0; i < names.length; i++) {
    		Variable var = ExpressionsFactory.eINSTANCE.createVariable();
    		var.setName(names[i]);
    		var.setType(types[i]);
    		result.add(var);
    	}
    	
    	return result;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getRelationshipTo(EClassifier type) {
		if (!(type instanceof CollectionType)) {
            return UNRELATED_TYPE;
        }
        
        CollectionType other = (CollectionType) type;
        
        int kindRelationship = getRelationship(getKind(), other.getKind());
        
        if (kindRelationship == UNRELATED_TYPE) {
        	return kindRelationship;
        }

        int elementRelationship = TypeUtil.getRelationship(
        		getElementType(),
                other.getElementType());
        
        switch (kindRelationship) {
        case SAME_TYPE:
        	return elementRelationship;
        case STRICT_SUBTYPE:
        	switch (elementRelationship) {
        	case SAME_TYPE:
        	case STRICT_SUBTYPE:
        		return STRICT_SUBTYPE;
        	default:
        		return UNRELATED_TYPE;
        	}
        case STRICT_SUPERTYPE:
        	switch (elementRelationship) {
        	case SAME_TYPE:
        	case STRICT_SUPERTYPE:
        		return STRICT_SUPERTYPE;
        	default:
        		return UNRELATED_TYPE;
        	}
        default:
        	return UNRELATED_TYPE;
        }
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier getCommonSupertype(EClassifier type) throws SemanticException {
        /* Collection Types */
        if (!(type instanceof CollectionType)) {
            String message = OCLMessages.bind(
            		OCLMessages.TypeMismatch_ERROR_,
                    this.getName(),
                    TypeUtil.getName(type));
            CompatibilityParser.ERR(message);
        }

        CollectionType other = (CollectionType) type;
        CollectionKind commonKind = commonSuperType(getKind(), other.getKind());
        
        EClassifier resultElementType = TypeUtil.commonSuperType(
                getElementType(), other.getElementType());

        return TypesFactory.eINSTANCE.createCollectionType(
        		commonKind, resultElementType);
	}
    
    public static CollectionKind commonSuperType(CollectionKind kind1, CollectionKind kind2) {
    	switch (kind1.getValue()) {
    	case CollectionKind.BAG:
    		switch (kind2.getValue()) {
    		case CollectionKind.BAG:
    			return CollectionKind.BAG_LITERAL;
    		default:
       			return CollectionKind.COLLECTION_LITERAL;
    		}
    	case CollectionKind.SEQUENCE:
    		switch (kind2.getValue()) {
    		case CollectionKind.SEQUENCE:
    			return CollectionKind.SEQUENCE_LITERAL;
    		default:
       			return CollectionKind.COLLECTION_LITERAL;
    		}
    	case CollectionKind.SET:
    		switch (kind2.getValue()) {
    		case CollectionKind.ORDERED_SET:
    		case CollectionKind.SET:
    			return CollectionKind.SET_LITERAL;
    		default:
       			return CollectionKind.COLLECTION_LITERAL;
    		}
    	case CollectionKind.ORDERED_SET:
    		switch (kind2.getValue()) {
    		case CollectionKind.ORDERED_SET:
    			return CollectionKind.ORDERED_SET_LITERAL;
    		case CollectionKind.SET:
    			return CollectionKind.SET_LITERAL;
    		default:
       			return CollectionKind.COLLECTION_LITERAL;
    		}
    	default:
   			return CollectionKind.COLLECTION_LITERAL;
    	}
    }
    
    public static int getRelationship(CollectionKind kind1, CollectionKind kind2) {
    	switch (kind1.getValue()) {
    	case CollectionKind.BAG:
    		switch (kind2.getValue()) {
    		case CollectionKind.BAG:
    			return SAME_TYPE;
    		case CollectionKind.COLLECTION:
    			return STRICT_SUBTYPE;
    		default:
    			return UNRELATED_TYPE;
    		}
    	case CollectionKind.SET:
    		switch (kind2.getValue()) {
    		case CollectionKind.SET:
    			return SAME_TYPE;
    		case CollectionKind.ORDERED_SET:
    			return STRICT_SUPERTYPE;
    		case CollectionKind.COLLECTION:
    			return STRICT_SUBTYPE;
    		default:
    			return UNRELATED_TYPE;
    		}
	   	case CollectionKind.ORDERED_SET:
    		switch (kind2.getValue()) {
    		case CollectionKind.ORDERED_SET:
    			return SAME_TYPE;
    		case CollectionKind.SET:
    		case CollectionKind.COLLECTION:
    			return STRICT_SUBTYPE;
    		default:
    			return UNRELATED_TYPE;
    		}
	   	case CollectionKind.SEQUENCE:
    		switch (kind2.getValue()) {
    		case CollectionKind.SEQUENCE:
    			return SAME_TYPE;
    		case CollectionKind.COLLECTION:
    			return STRICT_SUBTYPE;
    		default:
    			return UNRELATED_TYPE;
    		}
	   	default:
    		switch (kind2.getValue()) {
    		case CollectionKind.COLLECTION:
    			return SAME_TYPE;
    		default:
    			return STRICT_SUPERTYPE;
    		}
    	}
    }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return TypesPackage.Literals.COLLECTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartPosition() {
		return startPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartPosition(int newStartPosition) {
		int oldStartPosition = startPosition;
		startPosition = newStartPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COLLECTION_TYPE__START_POSITION, oldStartPosition, startPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndPosition() {
		return endPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndPosition(int newEndPosition) {
		int oldEndPosition = endPosition;
		endPosition = newEndPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COLLECTION_TYPE__END_POSITION, oldEndPosition, endPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTypeStartPosition() {
		return typeStartPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeStartPosition(int newTypeStartPosition) {
		int oldTypeStartPosition = typeStartPosition;
		typeStartPosition = newTypeStartPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION, oldTypeStartPosition, typeStartPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTypeEndPosition() {
		return typeEndPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeEndPosition(int newTypeEndPosition) {
		int oldTypeEndPosition = typeEndPosition;
		typeEndPosition = newTypeEndPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION, oldTypeEndPosition, typeEndPosition));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClassifier getElementType() {
		if (elementType != null && elementType.eIsProxy()) {
			InternalEObject oldElementType = (InternalEObject)elementType;
			elementType = (EClassifier)eResolveProxy(oldElementType);
			if (elementType != oldElementType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE, oldElementType, elementType));
			}
		}
		return elementType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClassifier basicGetElementType() {
		return elementType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setElementType(EClassifier newElementType) {
		EClassifier oldElementType = elementType;
		elementType = newElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE, oldElementType, elementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CollectionKind getKind() {
		return CollectionKind.COLLECTION_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.COLLECTION_TYPE__START_POSITION:
				return new Integer(getStartPosition());
			case TypesPackage.COLLECTION_TYPE__END_POSITION:
				return new Integer(getEndPosition());
			case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION:
				return new Integer(getTypeStartPosition());
			case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION:
				return new Integer(getTypeEndPosition());
			case TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				if (resolve) return getElementType();
				return basicGetElementType();
			case TypesPackage.COLLECTION_TYPE__KIND:
				return getKind();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.COLLECTION_TYPE__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.COLLECTION_TYPE__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION:
				setTypeStartPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION:
				setTypeEndPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				setElementType((EClassifier)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case TypesPackage.COLLECTION_TYPE__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case TypesPackage.COLLECTION_TYPE__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION:
				setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
				return;
			case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION:
				setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
				return;
			case TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				setElementType((EClassifier)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TypesPackage.COLLECTION_TYPE__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case TypesPackage.COLLECTION_TYPE__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION:
				return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
			case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION:
				return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
			case TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				return elementType != null;
			case TypesPackage.COLLECTION_TYPE__KIND:
				return getKind() != KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == ASTNode.class) {
			switch (derivedFeatureID) {
				case TypesPackage.COLLECTION_TYPE__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
				case TypesPackage.COLLECTION_TYPE__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == TypedASTNode.class) {
			switch (derivedFeatureID) {
				case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION;
				case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == PredefinedType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == ASTNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.AST_NODE__START_POSITION: return TypesPackage.COLLECTION_TYPE__START_POSITION;
				case UtilitiesPackage.AST_NODE__END_POSITION: return TypesPackage.COLLECTION_TYPE__END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == TypedASTNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION: return TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION;
				case UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION: return TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == PredefinedType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (startPosition: "); //$NON-NLS-1$
		result.append(startPosition);
		result.append(", endPosition: "); //$NON-NLS-1$
		result.append(endPosition);
		result.append(", typeStartPosition: "); //$NON-NLS-1$
		result.append(typeStartPosition);
		result.append(", typeEndPosition: "); //$NON-NLS-1$
		result.append(typeEndPosition);
		result.append(')');
		return result.toString();
	}

    public static int size(Set s) {
        return s.size();
    }

    public static boolean includes(Collection c, Object o) {
    	for (Iterator iter = c.iterator(); iter.hasNext();) {
    		if (AnyTypeImpl.equal(iter.next(), o)) {
    			return true;
    		}
    	}
    	
        return false;
    }

    public static boolean excludes(Collection c, Object o) {
        return !includes(c, o);
    }

    public static int count(Collection c, Object o) {
        int count = 0;
        for (Iterator it = c.iterator(); it.hasNext();)
            if (AnyTypeImpl.equal(it.next(), o))
                count++;
        return count;
    }

    public static boolean includesAll(Collection c1, Collection c2) {
    	for (Iterator iter = c2.iterator(); iter.hasNext();) {
    		if (!includes(c1, iter.next())) {
    			return false;
    		}
    	}
    	
        return true;
    }

    public static boolean excludesAll(Collection c1, Collection c2) {
        for (Iterator it = c2.iterator(); it.hasNext();)
            if (includes(c1, it.next()))
                return false;
        return true;
    }

    public static boolean isEmpty(Collection c) {
        return c.isEmpty();
    }

    public static boolean notEmpty(Collection c) {
        return !c.isEmpty();
    }

    // Assumes the elements of the collection are all Integer or
    // all Double.
    public static Object sum(Collection c) {

        if (c.isEmpty())
            return null; // undefined

        Iterator it = c.iterator();
        Object o = it.next();

        // two cases: Integer and Double
        if (o instanceof Integer) {
            int currVal = 0;
            for (it = c.iterator(); it.hasNext();)
                currVal += ((Integer) it.next()).intValue();
            return new Integer(currVal);
        } else if (o instanceof Double) {
            double currVal = 0.0;
            for (it = c.iterator(); it.hasNext();)
                currVal += ((Double) it.next()).doubleValue();
            return new Double(currVal);
        } else {
            RuntimeException error = new RuntimeException(OCLMessages.SumOperator_ERROR_);
            OCLPlugin.throwing(CollectionTypeImpl.class, "sum", error);//$NON-NLS-1$
            throw error;
        }
    }

    /**
     * Computes the equivalence of two collections, accounting for the
     * equivalence of primitive numeric values that OCL considers equal but Java
     * does not.
     * 
     * @param c1 a collection
     * @param c2 another collection
     * 
     * @return whether they are equivalent as far as OCL is concerned
     */
    public static boolean equals(Collection c1, Collection c2) {
    	if (c1.size() != c2.size()) {
    		// collections of different sizes cannot be equal
    		return false;
    	} else if (c1 instanceof Bag && c2 instanceof Bag) {
            return ((Bag) c1).equals(c2);
    	} else if (c1 instanceof List && c2 instanceof List) {
            return ((List) c1).equals(c2);
    	} else if (c1 instanceof LinkedHashSet && c2 instanceof LinkedHashSet) {
            // OrderedSet

            // LinkedHashSet.equals() doesn't care about order but we do
            int size1 = c1.size();
            int size2 = c2.size();
            if (size1 != size2)
                return false;
            Iterator it1 = c1.iterator();
            Iterator it2 = c2.iterator();
            while (it1.hasNext()) {
                Object o1 = it1.next();
                Object o2 = it2.next();
                if (!o1.equals(o2))
                    return false;
            }
            
            return true;
        } else if (c1 instanceof Set && c2 instanceof Set) {
        	return ((Set) c1).equals(c2);
        } else {
        	// incompatible OCL types
        	return false;
        }
    }
    
    /**
     * Computes the hash of a collection, accounting for the similar hashing of
     * primitive numeric values that OCL considers equal but Java does not.
     * 
     * @param c a collection
     * 
     * @return its hash
     */
    public static int hashCode(Collection c) {
    	int result = 1;
    	
    	for (Iterator iter = c.iterator(); iter.hasNext();) {
    		result = 37 * AnyTypeImpl.hashCode(iter.next());
    	}
    	
    	return result;
    }

    /**
     * Returns the collection containing just those elements that are in both
     * the supplied collections.
     * 
     * @param c1
     *            the collection.
     * @param c2
     *            the other collection.
     * @return the collection: c1 intersection c2.
     */
    public static Collection intersection(Collection c1, Collection c2) {
        int size1 = c1.size();
        int size2 = c2.size();
        Collection result = null;

        if (c1 instanceof Set || c2 instanceof Set) {
            // if either argument is a set, so is the result
            if (size1 == 0 || size2 == 0)
                return Collections.EMPTY_SET;
            result = createNewSet();
        } else {
            // both arguments are bags, so is the result
            if (size1 == 0 || size2 == 0)
                return Bag.EMPTY_BAG;
            result = createNewBag();
        }

        // loop over the smaller collection and add only elements
        // that are in the larger collection
        if (c1.size() > c2.size()) {
            for (Iterator it = c2.iterator(); it.hasNext();) {
                Object o = it.next();
                if (includes(c1, o))
                    result.add(o);
            }
        } else
            for (Iterator it = c1.iterator(); it.hasNext();) {
                Object o = it.next();
                if (includes(c2, o))
                    result.add(o);
            }

        return result;
    }

    /**
     * Returns the collection containing all elements from both supplied
     * collections
     * 
     * @param c1
     *            one collection.
     * @param c2
     *            the other collection.
     * @return the collection: c1 union c2.
     */
    public static Collection union(Collection c1, Collection c2) {
        // if either collection is empty the result is the other collection.
        if (c1.isEmpty())
            return c2;
        if (c2.isEmpty())
            return c1;

        Collection result = null;
        if (c1 instanceof Bag || c2 instanceof Bag)
            result = createNewBag(c1);
        else if (c1 instanceof List || c2 instanceof List)
            result = createNewSequence(c1);
        else
            result = createNewSet(c1);
        result.addAll(c2);

        return result;
    }

    /**
     * Flattens a collection by taking the union of each of its constituent
     * collections, if they are a collection type, or just returns the supplied
     * collection if they are not.
     * 
     * @param c
     *            the collection to flatten
     * @return the flattened collection
     */
    public static Collection flatten(Collection c) {
        if (c.isEmpty())
            return c;

        Iterator it = c.iterator();
        Object o = it.next();

        // if the element type is not a collection type, the result is the
        // supplied collection.
        if (!(o instanceof Collection))
            return c;

        Collection result = null;
        if (c instanceof Bag)
            result = createNewBag();
        else if (c instanceof Set)
            result = createNewSet();
        else
            // Sequence
            result = createNewSequence();

        // the element type is a collection type -- flatten
        for (it = c.iterator(); it.hasNext();)
            result.addAll((Collection) it.next());

        return result;
    }

    /**
     * Returns all the elements in the first supplied set that are not in the
     * second supplied set.
     * 
     * @param s1
     *            the first set.
     * @param s2
     *            the second set.
     * @return the collection c1-c2.
     */
    public static Set minus(Set s1, Set s2) {
        Set result = (Set) createNewSet(s1);
        result.removeAll(s2);
        return result;
    }

    /**
     * Returns all but the supplied element from the supplied collection. For
     * collections in which an element may appear more than once, all elements
     * with that value are removed.
     * 
     * @param c
     *            the collection
     * @param o
     *            the element
     * @return the collection without the element
     */
    public static Collection excluding(Collection c, Object o) {
        Collection result = null;
        if (c instanceof Set)
            result = createNewSet(c);
        else if (c instanceof Bag)
            result = createNewBag(c);
        else if (c instanceof List) {
            List resultSeq = (List) createNewSequence(c);
            while (resultSeq.remove(o))
                ; // for sequences we need to remove all the matching elements
            return resultSeq;
        } else
            result = createNewOrderedSet(c);

        // non-sequences
        result.remove(o);
        return result;
    }

    /**
     * Returns the set of all elements in one or the other of the supplied sets
     * that are not in their intersection.
     * 
     * @param s1
     *            one set
     * @param s2
     *            the other set
     * @return the symmetric difference (i.e. (s1 union s2) - (s1 intersection
     *         s2))
     */
    public static Set symmetricDifference(Set s1, Set s2) {
        Set result = (Set) createNewSet(s1);
        for (Iterator it = s2.iterator(); it.hasNext();) {
            Object o = it.next();
            if (result.contains(o))
                result.remove(o);
            else
                result.add(o);
        }
        return result;
    }

    /**
     * Returns the supplied collection with the supplied element added
     * 
     * @param c
     *            the collection
     * @param element
     *            the element
     * @return the collection with the element
     */
    public static Collection including(Collection c, Object element) {
        Collection result = null;
        if (c instanceof Set)
            result = createNewSet(c);
        else if (c instanceof Bag)
            result = createNewBag(c);
        else
            result = createNewSequence(c);

        result.add(element);
        return result;
    }

    /**
     * Returns the supplied collection as a Set
     * 
     * @param c
     *            the collection
     * @return a set with each element of the supplied collection added to it.
     */
    public static Collection asSet(Collection c) {
        if (c instanceof Set)
            return c;
        return createNewSet(c);
    }

    /**
     * Returns the supplied collection as a Bag
     * 
     * @param c
     *            the collection
     * @return a bag with each element of the supplied collection added to it.
     */
    public static Collection asBag(Collection c) {
        if (c instanceof Bag)
            return c;
        return createNewBag(c);
    }

    /**
     * Returns the supplied collection as a Sequence
     * 
     * @param c
     *            the collection
     * @return a sequence with each element of the supplied collection added to
     *         it.
     */
    public static Collection asSequence(Collection c) {
        if (c instanceof List)
            return c;
        return createNewSequence(c);
    }

    /**
     * Returns the supplied collection as an OrderedSet
     * 
     * @param c
     *            the collection
     * @return an orderedset with each element of the supplied collection added
     *         to it.
     */
    public static Collection asOrderedSet(Collection c) {
        // TODO: create an interface for OrderedSet
        if (c instanceof LinkedHashSet)
            return c;
        return createNewOrderedSet(c);
    }

    /**
     * Computes the product of two collections, returning a set of tuples of
     * the resulting type.
     * 
     * @param c1 a collection
     * @param c2 another collection
     * @param resultType the resulting tuple type
     * 
     * @return the set of tuples
     */
    public static Set product(Collection c1, Collection c2, EClass resultType) {
    	EStructuralFeature first = resultType.getEStructuralFeature(PRODUCT_FIRST);
    	EStructuralFeature second = resultType.getEStructuralFeature(PRODUCT_SECOND);
    	EFactory factory = resultType.getEPackage().getEFactoryInstance();
    	
        Set result = (Set) createNewSet();
        
        for (Iterator i1 = c1.iterator(); i1.hasNext();) {
        	Object next1 = i1.next();
        	
        	for (Iterator i2 = c2.iterator(); i2.hasNext();) {
        		Object next2 = i2.next();
        		
        		EObject tuple = factory.create(resultType);
        		tuple.eSet(first, next1);
        		tuple.eSet(second, next2);
        		result.add(tuple);
        	}
        }
        
        return result;
    }

    /**
     * Appends the supplied object to the supplied ordered collection
     * 
     * @param c
     *            the collection
     * @param o
     *            the object
     * @return the supplied ordered collection with the new element at the end
     */
    public static Collection append(Collection c, Object o) {
        Collection result = null;
        // TODO: make an interface for OrderedSet
        if (c instanceof LinkedHashSet) {
            result = createNewOrderedSet(c);
            result.remove(o);  // appended object must be last
        } else {
            result = createNewSequence(c);
        }
        
        result.add(o);
        return result;
    }

    /**
     * Prepends the supplied object to the supplied ordered collection
     * 
     * @param c
     *            the collection
     * @param o
     *            the object
     * @return the supplied ordered collection with the new element at the
     *         beginning
     */
    public static Collection prepend(Collection c, Object o) {
        Collection result = null;
        if (c instanceof LinkedHashSet)
            result = createNewOrderedSet();
        else
            result = createNewSequence();
        result.add(o);
        result.addAll(c);
        return result;
    }

    /**
     * Inserts the supplied object at the supplied position of the supplied
     * ordered collection
     * <p>
     * <b>Note:</b> OCL is 1-indexed!
     * </p>
     * 
     * @param c
     *            the collection.
     * @param oclIndex
     *            the position to insert at.
     * @param o
     *            the object to insert.
     * @return the ordered collection with the object inserted at the position.
     */
    public static Collection insertAt(Collection c, int oclIndex, Object o) {
        int index = oclIndex - 1;
        Collection result = null;
        if (c instanceof LinkedHashSet)
            result = createNewOrderedSet();
        else
            result = createNewSequence();
        if (index - 1 < 0 || index > c.size())
            return null; // undefined
        int curr = 0;
        for (Iterator it = c.iterator(); it.hasNext();) {
            if (curr == index)
                result.add(o);
            result.add(it.next());
            curr++;
        }
        return result;
    }

    /**
     * Returns the subset of the supplied ordered collection whose elements have
     * indices between the supplied lower and upper bounds (inclusive).
     * 
     * @param c
     *            the collection
     * @param oclLower
     *            the lower bound.
     * @param oclUpper
     *            the upper bound.
     * @return the ordered sub-collection between the lower and upper bounds.
     */
    public static Collection subOrderedSet(Collection c, int oclLower,
            int oclUpper) {
        int lower = oclLower - 1;
        int upper = oclUpper - 1;
        if (lower < 0 || upper >= c.size())
            return null; // undefined
        Collection result = null;
        if (c instanceof LinkedHashSet)
            result = createNewOrderedSet();
        else
            result = createNewSequence();
        int curr = 0;
        for (Iterator it = c.iterator(); it.hasNext();) {
            Object o = it.next();
            if (curr >= lower && curr <= upper)
                result.add(o);
            curr++;
        }
        return result;
    }

    /**
     * Returns the subsequence of the supplied ordered collection whose elements
     * have indices between the supplied lower and upper bounds (inclusive).
     * 
     * @param c
     *            the collection
     * @param oclLower
     *            the lower bound.
     * @param oclUpper
     *            the upper bound.
     * @return the subsequence between the lower and upper bounds.
     */
    public static Collection subSequence(Collection c, int oclLower,
            int oclUpper) {
        int lower = oclLower - 1;
        int upper = oclUpper - 1;
        if (lower < 0 || upper >= c.size())
            return null; // undefined
        Collection result = createNewSequence();
        int curr = 0;
        for (Iterator it = c.iterator(); it.hasNext();) {
            Object o = it.next();
            if (curr >= lower && curr <= upper)
                result.add(o);
            curr++;
        }
        return result;
    }

    /**
     * Returns the object at the supplied position of the supplied ordered
     * collection
     * 
     * @param c
     *            the collection
     * @param i
     *            the position.
     * @return the object in s at position i (or null if there is no object at
     *         that position).
     * 
     * Note: OCL is 1-indexed!
     */
    public static Object at(Collection c, int i) {
        int curr = 0;
        for (Iterator it = c.iterator(); it.hasNext();) {
            Object o = it.next();
            if (curr++ == i - 1)
                return o;
        }
        return null; // undefined
    }

    /**
     * Returns the first element of the supplied ordered collection if the
     * ordered collection is not empty, null otherwise.
     * 
     * @param c
     *            the collection
     * @return the first element of the collection or null.
     */
    public static Object first(Collection c) {
        if (c.isEmpty())
            return null; // undefined
        return c.iterator().next();
    }

    /**
     * Returns the last element of the supplied collection if the collection is
     * not empty, null otherwise.
     * 
     * @param c
     *            the collection
     * @return the last element of the collection or null.
     */
    public static Object last(Collection c) {
        if (c.isEmpty())
            return null; // undefined
        Object result = null;
        for (Iterator it = c.iterator(); it.hasNext();)
            result = it.next();
        return result;
    }

    /**
     * Returns the index in the supplied collection of the supplied object or
     * null if the object is not in the collection.
     * 
     * @param c
     *            the collection.
     * @param o
     *            the object.
     * @return the index (1-based) of the object in the collection.
     */
    public static Integer indexOf(Collection c, Object o) {
        int index = 1;
        for (Iterator it = c.iterator(); it.hasNext();) {
            if (o.equals(it.next()))
                return new Integer(index);
            index++;
        }
        return null; // undefined
    }

    /**
     * Creates a new java set
     */
    public static Collection createNewSet() {
        return collFactory.createCollection(CollectionKind.SET);
    }

    /**
     * Creates a new java set with initial collection supplied
     */
    public static Collection createNewSet(Collection c) {
        return collFactory.createCollection(CollectionKind.SET, c);
    }

    /**
     * Creates a new bag
     */
    public static Collection createNewBag() {
        return collFactory.createCollection(CollectionKind.BAG);
    }

    /**
     * Creates a new bag with initial collection supplied
     */
    public static Collection createNewBag(Collection c) {
        return collFactory.createCollection(CollectionKind.BAG, c);
    }

    /**
     * Creates a new java ordered set
     */
    public static Collection createNewOrderedSet() {
        return collFactory.createCollection(CollectionKind.ORDERED_SET);
    }

    /**
     * Creates a new ordered set with initial collection supplied
     */
    public static Collection createNewOrderedSet(Collection c) {
        return collFactory.createCollection(CollectionKind.ORDERED_SET, c);
    }

    /**
     * Creates a new sequence
     */
    public static Collection createNewSequence() {
        return collFactory.createCollection(CollectionKind.SEQUENCE);
    }

    /**
     * Creates a new sequence with initial collection supplied
     */
    public static Collection createNewSequence(Collection c) {
        return collFactory.createCollection(CollectionKind.SEQUENCE, c);
    }

} //CollectionTypeImpl
