package com.sap.furcas.runtime.textblocks;

import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getLevel;

import java.util.List;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;

public class TbDebugUtil {

    static public void printDebug(List<DocumentNode> list) {
        for (int i = 0; i < list.size(); i++) {
            DocumentNode node = list.get(i);
            if (node instanceof AbstractToken) {
                AbstractToken t = (AbstractToken) node;
                System.out.println("list entry " + i + " " + " is token: " + getTokenValue(t) + " at level " + getLevel(node));
            } else {
                TextBlock b = (TextBlock) node;
                System.out.println("list entry " + i + " " + " is textblock: " + b.getCachedString() + " at level "
                        + getLevel(node));
            }
        }
    }

    public static String getTextBlockAsAnnotatedString(TextBlock currentTextBlock) {
        String temp = "";
        for (DocumentNode node : TbNavigationUtil.getSubNodes(currentTextBlock)) {
            if (node instanceof TextBlock) {
                TextBlock tb = (TextBlock) node;
                temp += "tb[" + tb.getSubNodes().size() + "]:\"" + getTextBlockAsAnnotatedString(tb) + "\"";
            }
            if (node instanceof AbstractToken) {
                AbstractToken tok = (AbstractToken) node;
                temp += getTokenValue(tok);
            }
        }
        return temp + "[o:" + currentTextBlock.getOffset() + (currentTextBlock.isOffsetRelative() ? "r" : "a") + ",l:"
                + currentTextBlock.getLength() + "]<Version:" + currentTextBlock.getVersion() + ">";
    }

    public static String getDocumentNodeAsPlainString(DocumentNode currentNode) {
        String temp = "";
        if (currentNode instanceof AbstractToken) {
            AbstractToken tok = (AbstractToken) currentNode;
            temp += getTokenValue(tok);
        } else {
            for (DocumentNode node : TbNavigationUtil.getSubNodes((TextBlock) currentNode)) {
                temp += getDocumentNodeAsPlainString(node);
            }
        }
        return temp;
    }
    
    private static String getTokenValue(AbstractToken tok) {
        if (tok instanceof Bostoken) {
            return "BOS";
        } else if (tok instanceof Eostoken) {
            return "EOS";
        } else {
            return tok.getValue();
        }
    }

}
