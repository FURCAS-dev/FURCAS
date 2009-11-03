package com.sap.ide.cts.editor;

import org.eclipse.jface.text.rules.*;

public class CtsPartitionScanner extends RuleBasedPartitionScanner {
	public static final String SINLGE_LINE_COMMENT = "singleComment";
	public static final String MULTI_LINE_COMMENT = "multiComment";
	public static final String[] PARTITION_TYPES = {SINLGE_LINE_COMMENT,
			MULTI_LINE_COMMENT};
	
	public CtsPartitionScanner() {
		IToken singleLineCommentToken = new Token(CtsPartitionScanner.SINLGE_LINE_COMMENT);
		IToken multiLineCommentToken = new Token(CtsPartitionScanner.MULTI_LINE_COMMENT);
		IPredicateRule[] rules = new IPredicateRule[2];
		rules[0] = new EndOfLineRule("#",singleLineCommentToken); 
		rules[1] = new MultiLineRule("/*","*/",multiLineCommentToken);
		setPredicateRules(rules);
	}

		
}
