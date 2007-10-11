/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: PredefinedType.java,v 1.3 2007/10/11 23:05:05 cdamus Exp $
 */
package org.eclipse.ocl.utilities;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predefined Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.utilities.UtilitiesPackage#getPredefinedType()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PredefinedType<O> extends EObject {
	/*
	 * Primitive type operation codes
	 */
	int PLUS = 1;
	String PLUS_NAME = "+"; //$NON-NLS-1$
	int MINUS = 2;
	String MINUS_NAME = "-"; //$NON-NLS-1$
	int TIMES = 3;
	String TIMES_NAME = "*"; //$NON-NLS-1$
	int DIVIDE = 4;
	String DIVIDE_NAME = "/"; //$NON-NLS-1$
	int AND = 10;
	String AND_NAME = "and"; //$NON-NLS-1$
	int NOT = 11;
	String NOT_NAME = "not"; //$NON-NLS-1$
	int OR = 12;
	String OR_NAME = "or"; //$NON-NLS-1$
	int IMPLIES = 13;
	String IMPLIES_NAME = "implies"; //$NON-NLS-1$
	int ABS = 15;
	String ABS_NAME = "abs"; //$NON-NLS-1$
	int DIV = 16;
	String DIV_NAME = "div"; //$NON-NLS-1$
	int MOD = 17;
	String MOD_NAME = "mod"; //$NON-NLS-1$
	int MAX = 18;
	String MAX_NAME = "max"; //$NON-NLS-1$
	int MIN = 19;
	String MIN_NAME = "min"; //$NON-NLS-1$
	int SIZE = 20;
	String SIZE_NAME = "size"; //$NON-NLS-1$
	int CONCAT = 21;
	String CONCAT_NAME = "concat"; //$NON-NLS-1$
	int SUBSTRING = 22;
	String SUBSTRING_NAME = "substring"; //$NON-NLS-1$
	int TO_INTEGER = 23;
	String TO_INTEGER_NAME = "toInteger"; //$NON-NLS-1$
	int TO_REAL = 24;
	String TO_REAL_NAME = "toReal"; //$NON-NLS-1$
	int XOR = 25;
	String XOR_NAME = "xor"; //$NON-NLS-1$
	int FLOOR = 26;
	String FLOOR_NAME = "floor"; //$NON-NLS-1$
	int ROUND = 27;
	String ROUND_NAME = "round"; //$NON-NLS-1$
	int TO_LOWER = 28;
	String TO_LOWER_NAME = "toLower"; //$NON-NLS-1$
	int TO_UPPER = 29;
	String TO_UPPER_NAME = "toUpper"; //$NON-NLS-1$

	/*
	 * OclType operations.
	 */
	int ALL_INSTANCES = 40;
	String ALL_INSTANCES_NAME = "allInstances"; //$NON-NLS-1$
	
	/*
	 * OclAny operations.
	 */
	int EQUAL = 60;
	String EQUAL_NAME = "="; //$NON-NLS-1$
	int NOT_EQUAL = 61;
	String NOT_EQUAL_NAME = "<>"; //$NON-NLS-1$
	int OCL_AS_TYPE = 62;
	String OCL_AS_TYPE_NAME = "oclAsType"; //$NON-NLS-1$
	int OCL_IS_KIND_OF = 63;
	String OCL_IS_KIND_OF_NAME = "oclIsKindOf"; //$NON-NLS-1$
	int OCL_IS_TYPE_OF = 64;
	String OCL_IS_TYPE_OF_NAME = "oclIsTypeOf"; //$NON-NLS-1$
	int OCL_IS_UNDEFINED = 65;
	String OCL_IS_UNDEFINED_NAME = "oclIsUndefined"; //$NON-NLS-1$
	int OCL_IS_INVALID = 66;
	String OCL_IS_INVALID_NAME = "oclIsInvalid"; //$NON-NLS-1$
	int LESS_THAN = 67;
	String LESS_THAN_NAME = "<"; //$NON-NLS-1$
	int GREATER_THAN = 68;
	String GREATER_THAN_NAME = ">"; //$NON-NLS-1$
	int LESS_THAN_EQUAL = 69;
	String LESS_THAN_EQUAL_NAME = "<="; //$NON-NLS-1$
	int GREATER_THAN_EQUAL = 70;
	String GREATER_THAN_EQUAL_NAME = ">="; //$NON-NLS-1$
	int OCL_IS_NEW = 71;
	String OCL_IS_NEW_NAME = "oclIsNew"; //$NON-NLS-1$
	int OCL_IS_IN_STATE = 72;
	String OCL_IS_IN_STATE_NAME = "oclIsInState"; //$NON-NLS-1$
	
	/*
	 * OclMessage operations
	 */
	int HAS_RETURNED = 100;
	String HAS_RETURNED_NAME = "hasReturned"; //$NON-NLS-1$
	int RESULT = 101;
	String RESULT_NAME = Environment.RESULT_VARIABLE_NAME;
	int IS_SIGNAL_SENT = 102;
	String IS_SIGNAL_SENT_NAME = "isSignalSent"; //$NON-NLS-1$
	int IS_OPERATION_CALL = 103;
	String IS_OPERATION_CALL_NAME = "isOperationCall"; //$NON-NLS-1$
	
    /*
     * Collection type operation codes
     */
    int COUNT = 140;
    String COUNT_NAME = "count"; //$NON-NLS-1$
    int EXCLUDES = 141;
    String EXCLUDES_NAME = "excludes"; //$NON-NLS-1$
    int EXCLUDES_ALL = 142;
    String EXCLUDES_ALL_NAME = "excludesAll"; //$NON-NLS-1$
    int INCLUDES = 143;
    String INCLUDES_NAME = "includes"; //$NON-NLS-1$
    int INCLUDES_ALL = 144;
    String INCLUDES_ALL_NAME = "includesAll"; //$NON-NLS-1$
    int IS_EMPTY = 145;
    String IS_EMPTY_NAME = "isEmpty"; //$NON-NLS-1$
    int NOT_EMPTY = 146;
    String NOT_EMPTY_NAME = "notEmpty"; //$NON-NLS-1$
    int PRODUCT = 147;
    String PRODUCT_NAME = "product"; //$NON-NLS-1$
    int SUM = 148;
    String SUM_NAME = "sum"; //$NON-NLS-1$
    int AS_BAG = 149;
    String AS_BAG_NAME = "asBag"; //$NON-NLS-1$
    int AS_ORDERED_SET = 150;
    String AS_ORDERED_SET_NAME = "asOrderedSet"; //$NON-NLS-1$
    int AS_SEQUENCE = 151;
    String AS_SEQUENCE_NAME = "asSequence"; //$NON-NLS-1$
    int AS_SET = 152;
    String AS_SET_NAME = "asSet"; //$NON-NLS-1$
    int EXCLUDING = 153;
    String EXCLUDING_NAME = "excluding"; //$NON-NLS-1$
    int FLATTEN = 154;
    String FLATTEN_NAME = "flatten"; //$NON-NLS-1$
    int INCLUDING = 155;
    String INCLUDING_NAME = "including"; //$NON-NLS-1$
    int INTERSECTION = 156;
    String INTERSECTION_NAME = "intersection"; //$NON-NLS-1$
    int UNION = 157;
    String UNION_NAME = "union"; //$NON-NLS-1$
    int AT = 158;
    String AT_NAME = "at"; //$NON-NLS-1$
    int FIRST = 159;
    String FIRST_NAME = "first"; //$NON-NLS-1$
    int INDEX_OF = 160;
    String INDEX_OF_NAME = "indexOf"; //$NON-NLS-1$
    int INSERT_AT = 161;
    String INSERT_AT_NAME = "insertAt"; //$NON-NLS-1$
    int LAST = 162;
    String LAST_NAME = "last"; //$NON-NLS-1$
    int PREPEND = 163;
    String PREPEND_NAME = "prepend"; //$NON-NLS-1$
    int SUB_SEQUENCE = 164;
    String SUB_SEQUENCE_NAME = "subSequence"; //$NON-NLS-1$
    int APPEND = 165;
    String APPEND_NAME = "append"; //$NON-NLS-1$
    int SUB_ORDERED_SET = 166;
    String SUB_ORDERED_SET_NAME = "subOrderedSet"; //$NON-NLS-1$
    int SYMMETRIC_DIFFERENCE = 167;
    String SYMMETRIC_DIFFERENCE_NAME = "symmetricDifference"; //$NON-NLS-1$

    /*
     * Collection iterators.
     */
	int EXISTS = 201;
	String EXISTS_NAME = "exists"; //$NON-NLS-1$
	int FOR_ALL = 202;
	String FOR_ALL_NAME = "forAll"; //$NON-NLS-1$
	int IS_UNIQUE = 203;
	String IS_UNIQUE_NAME = "isUnique"; //$NON-NLS-1$
	int ONE = 204;
	String ONE_NAME = "one"; //$NON-NLS-1$
	int ANY = 205;
	String ANY_NAME = "any"; //$NON-NLS-1$
	int COLLECT = 206;
	String COLLECT_NAME = "collect"; //$NON-NLS-1$
	int COLLECT_NESTED = 207;
	String COLLECT_NESTED_NAME = "collectNested"; //$NON-NLS-1$
	int CLOSURE = 208;
	String CLOSURE_NAME = "closure"; //$NON-NLS-1$
	int SELECT = 209;
	String SELECT_NAME = "select"; //$NON-NLS-1$
	int REJECT = 210;
	String REJECT_NAME = "reject"; //$NON-NLS-1$
	int SORTED_BY = 211;
	String SORTED_BY_NAME = "sortedBy"; //$NON-NLS-1$

	/**
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     * @generated
     */
	String getName();

	/**
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @model
     * @generated
     */
	EList<O> oclOperations();

} // PredefinedType
