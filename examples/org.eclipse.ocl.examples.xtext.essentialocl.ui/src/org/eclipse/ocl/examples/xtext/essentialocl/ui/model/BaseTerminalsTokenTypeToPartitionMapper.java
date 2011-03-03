/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: BaseTerminalsTokenTypeToPartitionMapper.java,v 1.1 2011/03/03 20:05:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.model;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

import com.google.inject.Singleton;

@Singleton
public class BaseTerminalsTokenTypeToPartitionMapper extends TerminalsTokenTypeToPartitionMapper
{	
	public final static String STRING_LITERAL_PARTITION1 = "__string1";
	public final static String STRING_LITERAL_PARTITION2 = "__string2";
	public final static String ML_STRING_LITERAL_PARTITION = "__ml_string";
	public final static String DOCUMENTATION_PARTITION = "__documentation";
	public final static String ESCAPED_ID_PARTITION = "__escaped_id";
	
	protected static final String[] BASE_SUPPORTED_PARTITIONS = new String[]{
		COMMENT_PARTITION,
		STRING_LITERAL_PARTITION1,
		STRING_LITERAL_PARTITION2,
		ML_STRING_LITERAL_PARTITION,
		DOCUMENTATION_PARTITION,
		ESCAPED_ID_PARTITION,
		IDocument.DEFAULT_CONTENT_TYPE
	};
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		String internalCalculateId = internalCalculateId(tokenName);
		System.out.println(tokenName + " -> " + internalCalculateId);
		return internalCalculateId;
	}

	protected String internalCalculateId(String tokenName) {
		if ("RULE_DOCUMENTATION".equals(tokenName)) {
			return DOCUMENTATION_PARTITION;
		} else if ("RULE_ML_COMMENT".equals(tokenName)) {
			return COMMENT_PARTITION;
		} else if ("RULE_SL_COMMENT".equals(tokenName)) {
			return COMMENT_PARTITION;
		} else if ("RULE_DOUBLE_QUOTED_STRING".equals(tokenName)) {
			return STRING_LITERAL_PARTITION1;
		} else if ("RULE_SINGLE_QUOTED_STRING".equals(tokenName)) {
			return STRING_LITERAL_PARTITION2;
		} else if ("RULE_ML_SINGLE_QUOTED_STRING".equals(tokenName)) {
			return ML_STRING_LITERAL_PARTITION;
		} else if ("RULE_ESCAPED_ID".equals(tokenName)) {
			return ESCAPED_ID_PARTITION;
		}
		return IDocument.DEFAULT_CONTENT_TYPE;
	}

	@Override
	public String[] getSupportedPartitionTypes() {
		return BASE_SUPPORTED_PARTITIONS;
	}
}