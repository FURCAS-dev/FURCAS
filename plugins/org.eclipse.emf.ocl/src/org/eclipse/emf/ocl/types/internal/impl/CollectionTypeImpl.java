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

package org.eclipse.emf.ocl.types.internal.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;
import org.eclipse.emf.ocl.internal.parser.OclParser;
import org.eclipse.emf.ocl.internal.utilities.AstNode;
import org.eclipse.emf.ocl.internal.utilities.TypedAstNode;
import org.eclipse.emf.ocl.internal.utilities.UtilitiesPackage;
import org.eclipse.emf.ocl.internal.utilities.impl.Bag;
import org.eclipse.emf.ocl.internal.utilities.impl.CollectionFactory;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.osgi.util.NLS;

import antlr.SemanticException;

/**
 * @generated
 */
public class CollectionTypeImpl extends EDataTypeImpl implements CollectionType {

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

    private static final String SumOperator_ERROR_ =
    	OclMessages.SumOperator_ERROR_;

    private static final String CollectionSuperType_ERROR_ =
    	OclMessages.CollectionSuperType_ERROR_;

    private static final String CollectionType_ERROR_ =
    	OclMessages.CollectionType_ERROR_;
    
    private static final String UnrecognizedCollectionOperation_ERROR_ =
        OclMessages.UnrecognizedCollectionOperation_ERROR_;
    

    // A <code>CollectionFactory</code> makes java collections given an ocl
    // collection type.
    private static CollectionFactory collFactory = CollectionFactory
            .getInstance();

    /*
     * Define Collection type instances for each of the stdlib collection types
     */
    public static SequenceType OCL_SEQUENCE = TypesPackage.eINSTANCE
            .getTypesFactory().createSequenceType();

    public static SetType OCL_SET = TypesPackage.eINSTANCE.getTypesFactory()
            .createSetType();

    public static OrderedSetType OCL_ORDERED_SET = TypesPackage.eINSTANCE
            .getTypesFactory().createOrderedSetType();

    public static BagType OCL_BAG = TypesPackage.eINSTANCE.getTypesFactory()
            .createBagType();

    public static CollectionType OCL_COLLECTION = TypesPackage.eINSTANCE
            .getTypesFactory().createCollectionType();

    /*
     * Collection type operation codes
     */
    public final static int COUNT = 140;

    public final static int EXCLUDES = 141;

    public final static int EXCLUDES_ALL = 142;

    public final static int INCLUDES = 143;

    public final static int INCLUDES_ALL = 144;

    public final static int IS_EMPTY = 145;

    public final static int NOT_EMPTY = 146;

    public final static int PRODUCT = 147;

    public final static int SIZE = 148;

    public final static int SUM = 149;

    public final static int AS_BAG = 150;

    public final static int AS_ORDERED_SET = 151;

    public final static int AS_SEQUENCE = 152;

    public final static int AS_SET = 153;

    public final static int EQUALS = 154;

    public final static int EXCLUDING = 155;

    public final static int FLATTEN = 156;

    public final static int INCLUDING = 157;

    public final static int INTERSECTION = 158;

    public final static int UNION = 159;

    public final static int AT = 160;

    public final static int FIRST = 161;

    public final static int INDEX_OF = 162;

    public final static int INSERT_AT = 163;

    public final static int LAST = 164;

    public final static int PREPEND = 165;

    public final static int SUB_SEQUENCE = 166;

    public final static int APPEND = 167;

    public final static int SUB_ORDERED_SET = 168;

    public final static int MINUS = 169;

    public final static int SYMMETRIC_DIFFERENCE = 170;

    public final static int NOT_EQUAL = 171;

    /*
     * Operations for Collections
     */
    private static EList operations = new BasicEList();

    /**
     * Returns the operation code from an operation name.
     * 
     * @param oper
     * @return the operation code
     */
    public int getOperationCode(String oper) throws antlr.SemanticException {

        if (oper.equals("count"))return COUNT;//$NON-NLS-1$
        if (oper.equals("excludes"))return EXCLUDES;//$NON-NLS-1$
        if (oper.equals("excludesAll"))return EXCLUDES_ALL;//$NON-NLS-1$
        if (oper.equals("includes"))return INCLUDES;//$NON-NLS-1$
        if (oper.equals("includesAll"))return INCLUDES_ALL;//$NON-NLS-1$
        if (oper.equals("isEmpty"))return IS_EMPTY;//$NON-NLS-1$
        if (oper.equals("notEmpty"))return NOT_EMPTY;//$NON-NLS-1$
        if (oper.equals("product"))return PRODUCT;//$NON-NLS-1$
        if (oper.equals("size"))return SIZE;//$NON-NLS-1$
        if (oper.equals("sum"))return SUM;//$NON-NLS-1$
        if (oper.equals("asBag"))return AS_BAG;//$NON-NLS-1$
        if (oper.equals("asOrderedSet"))return AS_ORDERED_SET;//$NON-NLS-1$
        if (oper.equals("asSequence"))return AS_SEQUENCE;//$NON-NLS-1$
        if (oper.equals("asSet"))return AS_SET;//$NON-NLS-1$
        if (oper.equals("oclEquals"))return EQUALS;//$NON-NLS-1$
        if (oper.equals("oclNotEquals"))return NOT_EQUAL;//$NON-NLS-1$
        if (oper.equals("excluding"))return EXCLUDING;//$NON-NLS-1$
        if (oper.equals("flatten"))return FLATTEN;//$NON-NLS-1$
        if (oper.equals("including"))return INCLUDING;//$NON-NLS-1$
        if (oper.equals("intersection"))return INTERSECTION;//$NON-NLS-1$
        if (oper.equals("union"))return UNION;//$NON-NLS-1$
        if (oper.equals("at"))return AT;//$NON-NLS-1$
        if (oper.equals("first"))return FIRST;//$NON-NLS-1$
        if (oper.equals("indexOf"))return INDEX_OF;//$NON-NLS-1$
        if (oper.equals("insertAt"))return INSERT_AT;//$NON-NLS-1$
        if (oper.equals("last"))return LAST;//$NON-NLS-1$
        if (oper.equals("prepend"))return PREPEND;//$NON-NLS-1$
        if (oper.equals("subSequence"))return SUB_SEQUENCE;//$NON-NLS-1$
        if (oper.equals("append"))return APPEND;//$NON-NLS-1$
        if (oper.equals("subOrderedSet"))return SUB_ORDERED_SET;//$NON-NLS-1$
        if (oper.equals("symmetricDifference"))return SYMMETRIC_DIFFERENCE;//$NON-NLS-1$
        if (oper.equals("oclEquals"))return NOT_EQUAL;//$NON-NLS-1$
        String message = NLS.bind(
                UnrecognizedCollectionOperation_ERROR_, new Object[] { oper });
        OclParser.ERR(message);
        return 0;
    }

    /**
     * Returns the String name of an operation.
     * 
     * @param opcode
     * @return the operation name
     */
    public static String getOperationNameFor(int opcode) {

        switch (opcode) {
        case COUNT:
            return "count";//$NON-NLS-1$
        case EXCLUDES:
            return "excludes";//$NON-NLS-1$
        case EXCLUDES_ALL:
            return "excludesAll";//$NON-NLS-1$
        case INCLUDES:
            return "includes";//$NON-NLS-1$
        case INCLUDES_ALL:
            return "includesAll";//$NON-NLS-1$
        case IS_EMPTY:
            return "isEmpty";//$NON-NLS-1$
        case NOT_EMPTY:
            return "notEmpty";//$NON-NLS-1$
        case PRODUCT:
            return "product";//$NON-NLS-1$
        case SIZE:
            return "size";//$NON-NLS-1$
        case SUM:
            return "sum";//$NON-NLS-1$
        case AS_BAG:
            return "asBag";//$NON-NLS-1$
        case AS_ORDERED_SET:
            return "asOrderedSet";//$NON-NLS-1$
        case AS_SEQUENCE:
            return "asSequence";//$NON-NLS-1$
        case AS_SET:
            return "asSet";//$NON-NLS-1$
        case EQUALS:
            return "oclEquals";//$NON-NLS-1$
        case NOT_EQUAL:
            return "oclNotEqual";//$NON-NLS-1$
        case EXCLUDING:
            return "excluding";//$NON-NLS-1$
        case FLATTEN:
            return "flatten";//$NON-NLS-1$
        case INCLUDING:
            return "including";//$NON-NLS-1$
        case INTERSECTION:
            return "intersection";//$NON-NLS-1$
        case UNION:
            return "union";//$NON-NLS-1$
        case AT:
            return "at";//$NON-NLS-1$
        case FIRST:
            return "first";//$NON-NLS-1$
        case INDEX_OF:
            return "indexOf";//$NON-NLS-1$
        case INSERT_AT:
            return "insertAt";//$NON-NLS-1$
        case LAST:
            return "last";//$NON-NLS-1$
        case PREPEND:
            return "prepend";//$NON-NLS-1$
        case SUB_SEQUENCE:
            return "subSequence";//$NON-NLS-1$
        case APPEND:
            return "append";//$NON-NLS-1$
        case SUB_ORDERED_SET:
            return "subOrderedSet";//$NON-NLS-1$
        case SYMMETRIC_DIFFERENCE:
            return "symmetricDifference"; //$NON-NLS-1$
        }
        return ""; //$NON-NLS-1$
    }

    /**
     * Initialiaze Operations defined on AnyType
     */
    protected EList initOperations() {

        operations.add(AnyTypeImpl.createBinaryOperation(
                PrimitiveTypeImpl.OCL_INTEGER,
                "count", AnyTypeImpl.OCL_ECLASSIFIER)); //$NON-NLS-1$
        operations.add(AnyTypeImpl.createBinaryOperation(
                PrimitiveTypeImpl.OCL_BOOLEAN,
                "excludes", AnyTypeImpl.OCL_ECLASSIFIER)); //$NON-NLS-1$
        operations.add(AnyTypeImpl.createBinaryOperation(
                PrimitiveTypeImpl.OCL_BOOLEAN, "excludesAll", OCL_COLLECTION));//$NON-NLS-1$
        operations.add(AnyTypeImpl.createBinaryOperation(
                PrimitiveTypeImpl.OCL_BOOLEAN,
                "includes", AnyTypeImpl.OCL_ECLASSIFIER)); //$NON-NLS-1$
        operations.add(AnyTypeImpl.createBinaryOperation(
                PrimitiveTypeImpl.OCL_BOOLEAN, "includesAll", OCL_COLLECTION));//$NON-NLS-1$
        operations.add(AnyTypeImpl.createUnaryOperation(
                PrimitiveTypeImpl.OCL_BOOLEAN, "isEmpty"));//$NON-NLS-1$
        operations.add(AnyTypeImpl.createUnaryOperation(
                PrimitiveTypeImpl.OCL_BOOLEAN, "notEmpty"));//$NON-NLS-1$
        operations.add(AnyTypeImpl.createBinaryOperation(OCL_SET,
                "product", OCL_COLLECTION));//$NON-NLS-1$
        operations.add(AnyTypeImpl.createUnaryOperation(
                PrimitiveTypeImpl.OCL_REAL, "sum"));//$NON-NLS-1$
        operations.add(AnyTypeImpl.createUnaryOperation(
                PrimitiveTypeImpl.OCL_INTEGER, "size"));//$NON-NLS-1$
        return operations;
    }

    public EList getOperations() {
        if (operations == null || operations.size() == 0)
            return initOperations();
        return operations;
    }

    /**
     * The cached value of the '{@link #getElementType() <em>Element Type</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getElementType()
     * @generated @ordered
     */
    protected EClassifier elementType = null;

    protected CollectionTypeImpl() {
        super();
    }

    protected CollectionTypeImpl(EClassifier elementType) {
        super();
        this.elementType = elementType;
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
    public EClassifier getResultType(int opcode, EList args)
            throws SemanticException {

        if (opcode == SIZE || opcode == COUNT) {
            return PrimitiveTypeImpl.OCL_INTEGER;
        } else if (opcode == INCLUDES || opcode == EXCLUDES
                || opcode == INCLUDES_ALL || opcode == EXCLUDES_ALL
                || opcode == IS_EMPTY || opcode == NOT_EMPTY) {
            return PrimitiveTypeImpl.OCL_BOOLEAN;
        } else if (opcode == SUM) {
            EClassifier type = getElementType();
            if (type != PrimitiveTypeImpl.OCL_REAL
                    && type != PrimitiveTypeImpl.OCL_INTEGER) {
                String message = NLS.bind(SumOperator_ERROR_,
                        new Object[] { type.getName() });
                OclParser.ERR(message);
            }
            return type;
        } else if (opcode == PRODUCT) {
            /*
             * The result type is: Set(Tuple(first:T, second:T2) where T is the
             * elementType of this, and T2 is the elementType of the argument.
             */
            EClassifier t = getElementType();
            OclExpression arg = (OclExpression) args.get(0);
            CollectionType argType = (CollectionType) arg.getType();
            EClassifier t2 = argType.getElementType();
            SetType resultType = TypesFactory.eINSTANCE.createSetType();
            BasicEList vdcls = new BasicEList();
            VariableDeclaration vdcl = ExpressionsFactory.eINSTANCE
                    .createVariableDeclaration();
            vdcl.setVarName("first");//$NON-NLS-1$
            vdcl.setType(t);
            vdcls.add(vdcl);
            vdcl = ExpressionsFactory.eINSTANCE.createVariableDeclaration();
            vdcl.setVarName("second");//$NON-NLS-1$
            vdcl.setType(t2);
            vdcls.add(vdcl);
            resultType.setElementType(TypesFactory.eINSTANCE
                    .createTupleType(vdcls));

        }
        String message = NLS.bind(CollectionType_ERROR_,
                new Object[] { this.getName(), getOperationNameFor(opcode) });
        OclParser.ERR(message);
        return null;
    }

    /**
     * Compute the common supertype of 2 collection types. Recursively computes
     * common supertype of element type.
     * 
     * @param type
     * @return @throws
     *         antlr.SemanticException
     */
    public EClassifier commonSuperType(EClassifier type)
            throws antlr.SemanticException {
        /* Collection Types */
        if (!(type instanceof CollectionType)) {
            String message = NLS.bind(CollectionSuperType_ERROR_,
                    new Object[] { this.getName(), type.getName() });
            OclParser.ERR(message);
        }

        if (this instanceof BagType) {
            if (!(type instanceof BagType)) {
                String message = NLS.bind(
                        CollectionSuperType_ERROR_, new Object[] {
                                this.getName(), type.getName() });
                OclParser.ERR(message);
            }
        } else if (this instanceof SetType) {
            if (!(type instanceof SetType)) {
                String message = NLS.bind(
                        CollectionSuperType_ERROR_, new Object[] {
                                this.getName(), type.getName() });
                OclParser.ERR(message);
            }
        } else if (this instanceof SequenceType) {
            if (!(type instanceof SequenceType)) {
                String message = NLS.bind(
                        CollectionSuperType_ERROR_, new Object[] {
                                this.getName(), type.getName() });
                OclParser.ERR(message);
            }
        } else if (this instanceof OrderedSetType) {
            if (!(type instanceof OrderedSetType)) {
                String message = NLS.bind(
                        CollectionSuperType_ERROR_, new Object[] {
                                this.getName(), type.getName() });
                OclParser.ERR(message);
            }
        }

        EClassifier resultElementType = AnyTypeImpl.commonSuperType(
                getElementType(), ((CollectionType) type).getElementType());

        if (this instanceof BagType) {
            return TypesFactory.eINSTANCE.createBagType(resultElementType);
        } else if (this instanceof SetType) {
            return TypesFactory.eINSTANCE.createSetType(resultElementType);
        } else if (this instanceof SequenceType) {
            return TypesFactory.eINSTANCE.createSequenceType(resultElementType);
        } else {
            return TypesFactory.eINSTANCE
                    .createOrderedSetType(resultElementType);
        }
    }

    /**
     * Compare 2 types. Returns 0 if types are exactly equal, -1 if type1
     * conforms to type2 (type1 is a subtype of type2) 1 if type2 conforms to
     * type1 (type2 is a subtype of type1)
     * 
     * @param type
     * @return @throws
     *         IllegalArgumentException if there is no type conformance.
     */
    public int typeCompare(EClassifier type) {

        if (!(type instanceof CollectionType)) {
            String message = NLS.bind(CollectionSuperType_ERROR_,
                    new Object[] { this.getName(), type.getName() });
            IllegalArgumentException error = new IllegalArgumentException(
                    message);
            OclEnginePlugin.throwing(getClass(), "typeCompare", error);//$NON-NLS-1$
            throw error;
        }
        if (this instanceof BagType) {
            if (!(type instanceof BagType)) {
                String message = NLS.bind(
                        CollectionSuperType_ERROR_, new Object[] {
                                this.getName(), type.getName() });
                IllegalArgumentException error = new IllegalArgumentException(
                        message);
                OclEnginePlugin.throwing(getClass(), "typeCompare", error);//$NON-NLS-1$
                throw error;
            }
        } else if (this instanceof SetType) {
            if (!(type instanceof SetType)) {
                String message = NLS.bind(
                        CollectionSuperType_ERROR_, new Object[] {
                                this.getName(), type.getName() });
                IllegalArgumentException error = new IllegalArgumentException(
                        message);
                OclEnginePlugin.throwing(getClass(), "typeCompare", error);//$NON-NLS-1$
                throw error;
            }
        } else if (this instanceof SequenceType) {
            if (!(type instanceof SequenceType)) {
                String message = NLS.bind(
                        CollectionSuperType_ERROR_, new Object[] {
                                this.getName(), type.getName() });
                IllegalArgumentException error = new IllegalArgumentException(
                        message);
                OclEnginePlugin.throwing(getClass(), "typeCompare", error);//$NON-NLS-1$
                throw error;
            }
        } else if (this instanceof OrderedSetType) {
            if (!(type instanceof OrderedSetType)) {
                String message = NLS.bind(
                        CollectionSuperType_ERROR_, new Object[] {
                                this.getName(), type.getName() });
                IllegalArgumentException error = new IllegalArgumentException(
                        message);
                OclEnginePlugin.throwing(getClass(), "typeCompare", error);//$NON-NLS-1$
                throw error;
            }
        }

        return AnyTypeImpl.typeCompare(getElementType(),
                ((CollectionType) type).getElementType());
    }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.COLLECTION_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case TypesPackage.COLLECTION_TYPE__EPACKAGE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, TypesPackage.COLLECTION_TYPE__EPACKAGE, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.COLLECTION_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case TypesPackage.COLLECTION_TYPE__EPACKAGE:
					return eBasicSetContainer(null, TypesPackage.COLLECTION_TYPE__EPACKAGE, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case TypesPackage.COLLECTION_TYPE__EPACKAGE:
					return eContainer.eInverseRemove(this, EcorePackage.EPACKAGE__ECLASSIFIERS, EPackage.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getCollectionType();
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
			EClassifier oldElementType = elementType;
			elementType = (EClassifier)eResolveProxy((InternalEObject)elementType);
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.COLLECTION_TYPE__EANNOTATIONS:
				return getEAnnotations();
			case TypesPackage.COLLECTION_TYPE__NAME:
				return getName();
			case TypesPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case TypesPackage.COLLECTION_TYPE__INSTANCE_CLASS:
				return getInstanceClass();
			case TypesPackage.COLLECTION_TYPE__DEFAULT_VALUE:
				return getDefaultValue();
			case TypesPackage.COLLECTION_TYPE__EPACKAGE:
				return getEPackage();
			case TypesPackage.COLLECTION_TYPE__SERIALIZABLE:
				return isSerializable() ? Boolean.TRUE : Boolean.FALSE;
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
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.COLLECTION_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case TypesPackage.COLLECTION_TYPE__NAME:
				setName((String)newValue);
				return;
			case TypesPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case TypesPackage.COLLECTION_TYPE__SERIALIZABLE:
				setSerializable(((Boolean)newValue).booleanValue());
				return;
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
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.COLLECTION_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case TypesPackage.COLLECTION_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case TypesPackage.COLLECTION_TYPE__SERIALIZABLE:
				setSerializable(SERIALIZABLE_EDEFAULT);
				return;
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
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.COLLECTION_TYPE__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case TypesPackage.COLLECTION_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypesPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case TypesPackage.COLLECTION_TYPE__INSTANCE_CLASS:
				return INSTANCE_CLASS_EDEFAULT == null ? getInstanceClass() != null : !INSTANCE_CLASS_EDEFAULT.equals(getInstanceClass());
			case TypesPackage.COLLECTION_TYPE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case TypesPackage.COLLECTION_TYPE__EPACKAGE:
				return getEPackage() != null;
			case TypesPackage.COLLECTION_TYPE__SERIALIZABLE:
				return ((eFlags & SERIALIZABLE_EFLAG) != 0) != SERIALIZABLE_EDEFAULT;
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
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == AstNode.class) {
			switch (derivedFeatureID) {
				case TypesPackage.COLLECTION_TYPE__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
				case TypesPackage.COLLECTION_TYPE__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == TypedAstNode.class) {
			switch (derivedFeatureID) {
				case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION;
				case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION;
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
		if (baseClass == AstNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.AST_NODE__START_POSITION: return TypesPackage.COLLECTION_TYPE__START_POSITION;
				case UtilitiesPackage.AST_NODE__END_POSITION: return TypesPackage.COLLECTION_TYPE__END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == TypedAstNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION: return TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION;
				case UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION: return TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION;
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
        return c.contains(o);
    }

    public static boolean excludes(Collection c, Object o) {
        return !c.contains(o);
    }

    public static int count(Collection c, Object o) {
        int count = 0;
        for (Iterator it = c.iterator(); it.hasNext();)
            if (it.next().equals(o))
                count++;
        return count;
    }

    public static boolean includesAll(Collection c1, Collection c2) {
        return c1.containsAll(c2);
    }

    public static boolean excludesAll(Collection c1, Collection c2) {
        for (Iterator it = c2.iterator(); it.hasNext();)
            if (c1.contains(it.next()))
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
            RuntimeException error = new RuntimeException(SumOperator_ERROR_);
            OclEnginePlugin.throwing(CollectionTypeImpl.class, "sum", error);//$NON-NLS-1$
            throw error;
        }
    }

    public static boolean equals(Collection c1, Collection c2) {
        if (c1 instanceof Set || c2 instanceof Set)
            return ((Set) c1).equals(c2);
        else if (c1 instanceof Bag || c2 instanceof Bag)
            return ((Bag) c1).equals(c2);
        else if (c1 instanceof List || c2 instanceof List)
            return ((List) c1).equals(c2);
        else {
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
        }
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
                if (c1.contains(o))
                    result.add(o);
            }
        } else
            for (Iterator it = c1.iterator(); it.hasNext();) {
                Object o = it.next();
                if (c2.contains(o))
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

    // TODO: Finish when tuples are implemented.
    public static Set product(Collection c1, Collection c2) {
        throw new UnsupportedOperationException();
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
        if (c instanceof LinkedHashSet)
            result = createNewOrderedSet(c);
        else
            result = createNewSequence(c);
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
     * @return the index of the object in the collection.
     */
    public static Integer indexOf(Collection c, Object o) {
        int index = 0;
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
