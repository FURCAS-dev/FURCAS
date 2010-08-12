package com.sap.mi.textual.parsing.textblocks;

import textblocks.TextBlock;

public class IllegalTextBlocksStateException extends IllegalStateException {

    /**
     * 
     */
    private static final long serialVersionUID = -982572891244684963L;
    private final TextBlock currentTextBlock;

    public IllegalTextBlocksStateException(String string, TextBlock currentTextBlock) {
	super(string);
	this.currentTextBlock = currentTextBlock;
    }

    @Override
    public String getMessage() {
	return super.getMessage() + "\n" + 
		"TextBlock was:\n" + TbDebugUtil.getTextBlockAsAnnotatedString(currentTextBlock);
    }

}
