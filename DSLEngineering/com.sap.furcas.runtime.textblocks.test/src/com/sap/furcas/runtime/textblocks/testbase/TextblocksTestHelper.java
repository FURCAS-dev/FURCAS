package com.sap.furcas.runtime.textblocks.testbase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;

public class TextblocksTestHelper {

    /**
     * Asserts, that the offset is the sum of the lenghts of all left siblings.
     * 
     * @param node
     *            the DocumentNode to check
     */
    public static void assertNodeOffset(DocumentNode node) {
	TextBlock parent = node.getParent();
	if (parent == null) {
	    assertEquals(0, node.getOffset());
	    return;
	}

	int sum = 0;
	int index = 0;
	// TODO: Replace both TbNavigationUtil.getSubNodeAt() calls with
	// node.getSubNodes().get(), once OCL has been adapted to sort
	// result list by offset correctly
	DocumentNode curNode = TbNavigationUtil.getSubNodeAt(parent, index);
	while (!curNode.equals(node)) {
	    sum += curNode.getLength();
	    index++;
	    curNode = TbNavigationUtil.getSubNodeAt(parent, index);
	}

	assertEquals(sum, node.getOffset());
    }

    /**
     * Asserts, that a lexedtoken's length equals it's value string's length,
     * and that a textblock's length equals the sum of it's subnodes.
     * 
     * @param node
     *            the DocumentNode to check
     */
    public static void assertNodeLength(DocumentNode node) {
	if (node instanceof LexedToken) {
	    LexedToken t = (LexedToken) node;
	    assertEquals(t.getLength(), t.getValue().length());
	}

	if (node instanceof TextBlock) {
	    TextBlock b = (TextBlock) node;
	    int sum = 0;
	    for (DocumentNode subNode : b.getSubNodes()) {
		sum += subNode.getLength();
	    }

	    assertEquals(sum, b.getLength());
	}
    }

    public static void assertTextBlockAndChildren(TextBlock block) {

	assertTextBlockChildrenSortedByOffset(block);

	assertNodeLength(block);
	assertNodeOffset(block);

	for (DocumentNode node : block.getSubNodes()) {
	    if (node instanceof AbstractToken) {
	        if (!(node instanceof Bostoken) && !(node instanceof Eostoken)) {
	            assertNodeLength(node);
	            assertNodeOffset(node);
	        }
	    } else {
	        assertTextBlockAndChildren((TextBlock) node);
	    }
	}

    }

    public static void assertTextBlockChildrenSortedByOffset(TextBlock block) {
	int curOffset = -1;
	int curAbsOffset = -1;
	for (DocumentNode node : block.getSubNodes()) {
	    if (!(node instanceof Bostoken) && !(node instanceof Eostoken)) {
		assertTrue(curOffset < node.getOffset());
		int absOffset = TbUtil.getAbsoluteOffset(node);
		assertTrue(curAbsOffset < absOffset);
		curOffset = node.getOffset();
		curAbsOffset = absOffset;
	    }
	}
    }

    /**
     * Assert, that the cached string of a block equals the concatenated string
     * of it's children.
     * 
     * @param block
     *            TextBlock to check
     */
    public static void assertCachedString(TextBlock block) {
	String complete = "";
	// TODO: replace TbNavigationUtil.getSubNodes(),
	// once OCL of DocumentNode.getSubNodes() sorts correctly
	for (DocumentNode subNode : TbNavigationUtil.getSubNodes(block)) {
	    if (subNode instanceof AbstractToken) {
		AbstractToken t = (AbstractToken) subNode;
		// catch null value of eos and bos token
		if (t.getValue() != null) {
		    complete += t.getValue();
		}
	    } else {
		TextBlock b = (TextBlock) subNode;
		complete += b.getCachedString();
	    }
	}

	assertEquals(complete, block.getCachedString());
    }
    
    /**
     * @return true, if RefObject was deleted, false otherwise
     */
    public static boolean isDeleted(EObject eObject) {
	return EcoreUtil.getRootContainer(eObject).eResource() == null;
    }
    
    public static Resource createTransientResource() {
	ResourceSet resourceSet = new ResourceSetImpl();
	return resourceSet.createResource(URI.createURI("http://some_uri.xmi"));
    }

}
