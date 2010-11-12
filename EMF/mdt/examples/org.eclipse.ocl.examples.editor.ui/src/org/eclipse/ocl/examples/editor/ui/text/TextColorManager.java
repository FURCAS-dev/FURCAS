/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.text;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;

@Deprecated // Use UniversalTextEditor
public class TextColorManager extends ColorManager {

    private IToken defaultContextToken = null;
    private IToken doubleQuotedStringToken = null;
    private IToken keywordToken = null;
    private TextAttribute multiLineCommentTextAttribute = null;
    private IToken multiLineCommentToken = null;
    private IToken processingInstructionToken = null;
    private IToken singleLineCommentToken = null;
	private IToken singleQuotedStringToken = null;
	private IToken unterminatedStringToken = null;
    
    public IToken getDefaultContextToken() {
        if (defaultContextToken == null)
            defaultContextToken = new Token(new TextAttribute(
                getColor(ITextColorConstants.DEFAULT)));
        return defaultContextToken;
    }
    
    public IToken getDoubleQuotedStringToken() {
        if (doubleQuotedStringToken == null)
            doubleQuotedStringToken = new Token(new TextAttribute(
                getColor(ITextColorConstants.DOUBLE_QUOTED_STRING)));
        return doubleQuotedStringToken;
    }
   
    public IToken getKeywordToken() {
        if (keywordToken == null)
            keywordToken = new Token(new TextAttribute(
                getColor(ITextColorConstants.KEYWORD), null, SWT.BOLD));
        return keywordToken;
    }
   
    public TextAttribute getMultiLineCommentTextAttribute() {
        if (multiLineCommentTextAttribute == null)
            multiLineCommentTextAttribute = new TextAttribute(
                getColor(ITextColorConstants.MULTI_LINE_COMMENT));
        return multiLineCommentTextAttribute;
    }   
   
    public IToken getMultiLineCommentToken() {
        if (multiLineCommentToken == null)
            multiLineCommentToken = new Token(getMultiLineCommentTextAttribute());
        return multiLineCommentToken;
    }   
    
    public IToken getProcessingInstructionToken() {
        if (processingInstructionToken == null)
            processingInstructionToken = new Token(new TextAttribute(
                getColor(ITextColorConstants.PROCESSING_INSTRUCTION)));
        return processingInstructionToken;
    }
   
    public IToken getSingleLineCommentToken() {
        if (singleLineCommentToken == null)
            singleLineCommentToken = new Token(new TextAttribute(
                getColor(ITextColorConstants.SINGLE_LINE_COMMENT)));
        return singleLineCommentToken;
    }
       
    public IToken getSingleQuotedStringToken() {
        if (singleQuotedStringToken == null)
            singleQuotedStringToken = new Token(new TextAttribute(
                getColor(ITextColorConstants.SINGLE_QUOTED_STRING)));
        return singleQuotedStringToken;
    }
   
	public IToken getUnterminatedStringToken() {
		if (unterminatedStringToken == null)
			unterminatedStringToken = new Token(new TextAttribute(
				getColor(ITextColorConstants.UNTERMINATED_STRING)));
		return unterminatedStringToken;
	}
}
