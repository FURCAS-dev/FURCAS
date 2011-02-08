package com.sap.furcas.runtime.textblocks.validation;

import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodes;
import static com.sap.furcas.runtime.textblocks.TbUtil.getAbsoluteOffset;

import java.util.Iterator;
import java.util.List;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;

public class TbValidationUtil {

	public static void assertTextBlockConsistency(TextBlock currentTextBlock) {
	    if (currentTextBlock.getOffset() < 0) {
	        throw new IllegalTextBlocksStateException("TextBlock offset is negative: " +  currentTextBlock.getOffset(), currentTextBlock);
	    }
	    if (currentTextBlock.getLength() < 0) {
	        throw new IllegalTextBlocksStateException("TextBlock length is negative: " +  currentTextBlock.getOffset(), currentTextBlock);
	    }
	    List<? extends DocumentNode> subnodes = getSubNodes(currentTextBlock);
	    int lastEnd = getAbsoluteOffset(currentTextBlock); // implicitly checks for offset < 0
	    int tokenLengthSum = 0;
	    for (Iterator<? extends DocumentNode> iterator = subnodes.iterator(); iterator.hasNext();) {
	        DocumentNode documentNode = iterator.next();
	        int nodeOffSet = getAbsoluteOffset(documentNode);
	        tokenLengthSum += documentNode.getLength();
	        if (documentNode.getLength() < 0 ) {
	            if (! (documentNode instanceof Bostoken) && ! (documentNode instanceof Eostoken) ) {
	                throw new IllegalTextBlocksStateException("Subnode of length < 0 in block: " + documentNode, currentTextBlock);
	            }
	        }
	        if ( nodeOffSet > lastEnd ) {
//	        	if(! (documentNode instanceof Eostoken) ) {
	        		throw new IllegalTextBlocksStateException("TextBlock with gap between subnodes created : " + nodeOffSet +" after " + lastEnd, currentTextBlock);
//	        	}
	        }
	        if (nodeOffSet < lastEnd ) {
//	            if (! (documentNode instanceof Eostoken) ) {
	                throw new IllegalTextBlocksStateException("TextBlock with overlapping subnodes created :  " + nodeOffSet +" before " + lastEnd, currentTextBlock);
//	            }
	        }
	        lastEnd = nodeOffSet + documentNode.getLength();
	    }
	    if (tokenLengthSum != currentTextBlock.getLength()) {
	        throw new IllegalTextBlocksStateException("TextBlock length " + currentTextBlock.getLength() + " != "+ tokenLengthSum, currentTextBlock);
	    }
	    
	}
	
	public static void assertTextBlockConsistencyRecursive(TextBlock currentTextBlock) {
		for(TextBlock subBlock : currentTextBlock.getSubBlocks()) {
			assertTextBlockConsistencyRecursive(subBlock);
		}
		assertTextBlockConsistency(currentTextBlock);
	}
	
	public static void assertCacheIsUpToDate(TextBlock rootBlock) {
	    TextBlocksModel model = new TextBlocksModel(rootBlock, /*modelAdapter*/ null);
	    model.setUsecache(false);
	    String uncached = model.get(0, model.getLength());
	    model.setUsecache(true);
	    String cached = model.get(0, model.getLength());
	    if (!cached.equals(uncached)) {
		System.out.println("Uncached");
		System.out.println(uncached);
		System.out.println("Cached");
		System.out.println(cached);
		throw new IllegalTextBlocksStateException("TextBlock and its cache are not in Sync", rootBlock);
	    }
	}

	public static boolean hasGap(AbstractToken abstractToken, TextBlock currentTextBlock) {
		return (TbUtil.getAbsoluteOffset(abstractToken) + abstractToken.getLength()) != TbUtil.getAbsoluteOffset(currentTextBlock); 
	}

}
