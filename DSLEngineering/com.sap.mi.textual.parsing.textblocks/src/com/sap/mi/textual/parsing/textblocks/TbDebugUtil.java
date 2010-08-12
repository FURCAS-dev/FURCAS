package com.sap.mi.textual.parsing.textblocks;

import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.getLevel;

import java.util.List;

import textblocks.AbstractToken;
import textblocks.DocumentNode;
import textblocks.TextBlock;

public class TbDebugUtil {

    static public void printDebug(List<DocumentNode> list) {
	for (int i = 0; i < list.size(); i++) {
	    DocumentNode node = list.get(i);
	    if (node instanceof AbstractToken) {
		AbstractToken t = (AbstractToken) node;
		System.out.println("list entry " + i + " " + " is token: " + t.getValue() + " at level " + getLevel(node));
	    } else {
		TextBlock b = (TextBlock) node;
		System.out.println("list entry " + i + " " + " is textblock: " + b.getCachedString() + " at level "
			+ getLevel(node));
	    }
	}
    }

    static public String getTextBlockAsAnnotatedString(TextBlock currentTextBlock) {
	String temp = "";
	if (!currentTextBlock.is___Alive())
	    return "<deleted>";
	for (DocumentNode node : TbNavigationUtil.getSubNodes(currentTextBlock)) {
	    if (node instanceof TextBlock) {
		TextBlock tb = (TextBlock) node;
		temp += "tb[" + tb.getSubNodes().size() + "]:\"" + getTextBlockAsAnnotatedString(tb) + "\"";
	    }
	    if (node instanceof AbstractToken) {
		AbstractToken tok = (AbstractToken) node;
		temp += tok.getValue();
	    }
	}
	return temp + "[o:" + currentTextBlock.getOffset() + (currentTextBlock.isOffsetRelative() ? "r" : "a") + ",l:"
		+ currentTextBlock.getLength() + "]<Version:" + currentTextBlock.getVersion() + ">";
    }

    static public String getDocumentNodeAsPlainString(DocumentNode currentNode) {
	String temp = "";
	if (!currentNode.is___Alive())
	    return "<deleted>";

	if (currentNode instanceof AbstractToken) {
	    AbstractToken tok = (AbstractToken) currentNode;
	    temp += tok.getValue();
	} else {
	    for (DocumentNode node : TbNavigationUtil.getSubNodes((TextBlock) currentNode)) {
		temp += getDocumentNodeAsPlainString(node);
	    }
	}
	return temp;
    }

}
