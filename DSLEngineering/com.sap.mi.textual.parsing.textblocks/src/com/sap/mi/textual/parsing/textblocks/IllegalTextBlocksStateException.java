package com.sap.mi.textual.parsing.textblocks;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.TextBlock;

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
		"TextBlock was:\n" + getTextBlockAsString(currentTextBlock);
    }

    private String getTextBlockAsString(TextBlock currentTextBlock) {
	String temp = "";
//	if(!currentTextBlock.is___Alive())
//	    return "<deleted>";
	for (DocumentNode node : TbNavigationUtil.getSubNodes(currentTextBlock)) {
	    if (node instanceof TextBlock) {
		TextBlock tb = (TextBlock) node;
		 temp += "tb["+tb.getSubNodes().size()+"]:\"" + getTextBlockAsString(tb) + "\"";
	    } 
	    if (node instanceof AbstractToken) {
		AbstractToken tok = (AbstractToken) node;
		temp += tok.getValue();
	    }
	}
	return temp+ "[o:"+ currentTextBlock.getOffset() +
		(currentTextBlock.isOffsetRelative() ? "r":"a") +
		",l:" + currentTextBlock.getLength() + "]<Version:"+
		currentTextBlock.getVersion()+">";
    }
}
