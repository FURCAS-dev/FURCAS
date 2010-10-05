package com.sap.furcas.textual.textblocks;

import static com.sap.furcas.textual.textblocks.TbNavigationUtil.getLevel;

import java.util.List;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.TextBlock;

public class TbDebugUtil {

	static public void printDebug(List<DocumentNode> list) {
		for (int i = 0; i < list.size(); i++) {
			DocumentNode node = list.get(i);
			if (node instanceof AbstractToken) {
				AbstractToken t = (AbstractToken) node;
				System.out.println("list entry " + i + " " + " is token: "
						+ t.getValue() + " at level " + getLevel(node));
			} else {
				TextBlock b = (TextBlock) node;
				System.out.println("list entry " + i + " " + " is textblock: "
						+ b.getCachedString() + " at level " + getLevel(node));
			}
		}
	}

}
