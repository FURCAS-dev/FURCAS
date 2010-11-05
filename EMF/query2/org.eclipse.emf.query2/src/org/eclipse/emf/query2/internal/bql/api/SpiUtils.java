/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.bql.api;

import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.internal.fql.SpiFqlComparisonOperation;


/**
 * Utilities
 */
public final class SpiUtils {

	protected static final String OPENING_PARENTHESES = "("; //$NON-NLS-1$

	protected static final String CLOSING_PARENTHESES = ")"; //$NON-NLS-1$

	protected static final String AND = "AND"; //$NON-NLS-1$

	protected static final String OR = "OR"; //$NON-NLS-1$

	protected static final String NOT = "NOT"; //$NON-NLS-1$

	protected static final String PRESENT = "PRESENT"; //$NON-NLS-1$

	protected static final String GREATER = ">"; //$NON-NLS-1$

	protected static final String GREATER_OR_EQUAL = ">="; //$NON-NLS-1$

	protected static final String EQUAL = "="; //$NON-NLS-1$

	protected static final String NOT_EQUAL = "<>"; //$NON-NLS-1$

	protected static final String LESS = "<"; //$NON-NLS-1$

	protected static final String LESS_OR_EQUAL = "<="; //$NON-NLS-1$

	protected static final String LIKE = "LIKE"; //$NON-NLS-1$

	protected static final String IS_LINKED = "is linked";//$NON-NLS-1$

	protected static final String NOT_LINKED = "is not linked";//$NON-NLS-1$

	protected static final String TYPE = "type"; //$NON-NLS-1$

	protected static final String LINK_TYPE = "link type";//$NON-NLS-1$

	protected static final String ASSOCIATION_END_LINKED_OBJ = "association end of linked object";//$NON-NLS-1$

	protected static final String STORAGE_END = "storage end";//$NON-NLS-1$

	protected static final String LINK_FROM = "link from";//$NON-NLS-1$

	protected static final String LINK_TO = "link to";//$NON-NLS-1$

	protected static final String MODEL_ELEMENT_EXPRESSION = "model element expression";//$NON-NLS-1$

	protected static final String MODEL_ELEMENT_CLUSTER_EXPRESSION = "model element cluster expression";//$NON-NLS-1$

	protected static final String PARTITIONS = "partitions"; //$NON-NLS-1$

	protected static final String INCLUDE_LIST = "include list";//$NON-NLS-1$

	protected static final String EXCLUDE_LIST = "exclude list";//$NON-NLS-1$

	protected static final String SELECT = "select"; //$NON-NLS-1$

	protected static final String ATTRIBUTES = "attributes"; //$NON-NLS-1$

	protected static final String SELECT_LIST = "select list";//$NON-NLS-1$

	protected static final String ALIAS = "alias"; //$NON-NLS-1$

	protected static final String TYPES = "types"; //$NON-NLS-1$

	protected static final String ELEMENTS = "elements"; //$NON-NLS-1$

	protected static final String HEADER_MODEL_ELEMENT_EXPRESSION = "header model element expression";//$NON-NLS-1$

	protected static final String ADDITION_MODEL_ELEMENT_EXPRESSIONS = "additional model element expressions";//$NON-NLS-1$

	protected static final String CLUSTER_INTERNAL_LINKS = "cluster internal links";//$NON-NLS-1$

	protected static final String CLUSTER_EXTERNAL_LINKS = "cluster external links";//$NON-NLS-1$

	protected static final String MRI_SET_LINKS = "MRI set links";//$NON-NLS-1$

	protected static HashMap<String, Integer> aliasCounters;

	private SpiUtils() {

		// don't bother with instances
	}

	public static String simpleComparisonOperatorToString(SpiFqlComparisonOperation operator) {

		switch (operator) {
		case EQUAL:
			return SpiUtils.EQUAL;
		case NOT_EQUAL:
			return SpiUtils.NOT_EQUAL;
		case GREATER:
			return SpiUtils.GREATER;
		case GREATER_OR_EQUAL:
			return SpiUtils.GREATER_OR_EQUAL;
		case LESS:
			return SpiUtils.LESS;
		case LESS_OR_EQUAL:
			return SpiUtils.LESS_OR_EQUAL;
		default:
			return "UNKNOWN_OPERATOR"; //$NON-NLS-1$
		}
	}

	//    public static String mriIdForPrinting( MRI mri ) {
	//
	//        if ( mri != null ) {
	//            return mri.toString( );
	//        } else {
	//            return "null"; //$NON-NLS-1$
	//        }
	//    }

	public static String uriIdForPrinting(URI mri) {

		if (mri != null) {
			return mri.toString();
		} else {
			return "null"; //$NON-NLS-1$
		}
	}

	//    public static String priIdForPrinting( PRI pri ) {
	//
	//        if ( pri != null ) {
	//            return pri.toString( );
	//        } else {
	//            return "null"; //$NON-NLS-1$
	//        }
	//    }

	/**
     *
     */
	//    public static void mriArrayForPrinting( StringBuffer sb, MRI[] mriArray ) {
	//
	//        sb.append( SpiUtils.OPENING_PARENTHESES );
	//        for ( int i = 0; i < mriArray.length - 1; i++ ) {
	//            MRI mri = mriArray[i];
	//            sb.append( SpiUtils.mriIdForPrinting( mri ) );
	//            sb.append( ',' );
	//        }
	//        if ( mriArray.length > 0 ) {
	//            MRI mri = mriArray[mriArray.length - 1];
	//            sb.append( SpiUtils.mriIdForPrinting( mri ) );
	//        }
	//        sb.append( SpiUtils.CLOSING_PARENTHESES );
	//    }
	public static void uriArrayForPrinting(StringBuffer sb, URI[] mriArray) {

		sb.append(SpiUtils.OPENING_PARENTHESES);
		for (int i = 0; i < mriArray.length - 1; i++) {
			URI mri = mriArray[i];
			sb.append(SpiUtils.uriIdForPrinting(mri));
			sb.append(',');
		}
		if (mriArray.length > 0) {
			URI mri = mriArray[mriArray.length - 1];
			sb.append(SpiUtils.uriIdForPrinting(mri));
		}
		sb.append(SpiUtils.CLOSING_PARENTHESES);
	}

	public static void toStringNewLine(StringBuffer sb, int ident) {

		sb.append("\n"); //$NON-NLS-1$
		int spaceChars = ident * 4;
		for (int i = 0; i < spaceChars; i++) {
			sb.append(' ');
		}
	}
}
