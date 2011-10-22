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
        return getDocumentNodeAsStringBuilder(currentNode).toString();
    }

    private static StringBuilder getDocumentNodeAsStringBuilder(DocumentNode currentNode) {
        StringBuilder result = new StringBuilder();
        if (currentNode instanceof AbstractToken) {
            result.append(getTokenValue((AbstractToken) currentNode));
        } else {
            for (DocumentNode node : ((TextBlock) currentNode).getSubNodes()) {
                result.append(getDocumentNodeAsStringBuilder(node));
            }
        }
        return result;
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
