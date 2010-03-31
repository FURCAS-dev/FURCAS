package com.sap.mi.fwk.ui.test.unit.tree.nodes;

import junit.framework.TestCase;

import com.sap.mi.fwk.ui.internal.tree.TreeNodeMarkerSupport;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;

/**
 * Unit tests for class {@link TreeNode}
 * @author d022960
 *
 */
public class TreeNodeTest extends TestCase {

	final static String NODE_PARENT = "NodeParent";//$NON-NLS-N$
	final static String NODE_VALUE = "NodeValue";//$NON-NLS-N$
	final static String CHILDNODE_VALUE1 = "ChildNodeValue1";//$NON-NLS-N$
	final static String CHILDNODE_VALUE2 = "ChildNodeValue2";//$NON-NLS-N$
	
	public static void testConstructor() throws Exception {
		try {
			//throws exception, as null values are not allowed
			new TestNode(null);
			fail("NullPointer Exception not thrown");
		}
		catch(IllegalArgumentException e) {
			//correct 
		}
		
		{
			TestNode testNode = new TestNode(NODE_PARENT, NODE_VALUE);
			assertTrue("Invalid result for getValue()", testNode.getParent().equals(NODE_PARENT));
		}
		{
			TestNode testNode = new TestNode(NODE_VALUE);
			//parent is internally set to PARENT_NODE
			assertTrue("Invalid result for getParent()", testNode.getParent().equals(NODE_PARENT));
			assertTrue("Invalid result for getValue()", testNode.getValue().equals(NODE_VALUE));
		}
		{
			TestNode testNode = new TestNode(NODE_PARENT, NODE_VALUE);
			assertTrue("Invalid result for getParent()", testNode.getParent().equals(NODE_PARENT));
			assertTrue("Invalid result for getValue()", testNode.getValue().equals(NODE_VALUE));
		}
	}
	
	public static void testEquals() throws Exception {
		TestNode testNode = new TestNode(NODE_PARENT, NODE_VALUE);
		TestNode testNode2 = new TestNode(NODE_PARENT, NODE_VALUE);
		assertTrue("Two identical tree nodes must be equal", testNode.equals(testNode));
		assertTrue("Two tree nodes with identical tree node classes, identical values and identical parents must be equal", testNode.equals(testNode2));

		Object[] children = testNode.getChildren();
		assertFalse("Two identical tree nodes classes with identical parents and different values must not be equal", children[0].equals(children[1]));
		assertFalse("Two different tree nodes classes with identical parents and with identical values must not be equal", children[1].equals(children[2]));
		assertFalse("Two different tree nodes classes with identical parents and with identical values must not be equal", children[0].equals(children[2]));
		assertFalse("Two different tree nodes classes with identical parents and with different values must not be equal", children[1].equals(children[2]));
		
		Object[] subChildren = ((ITreeNode<?>)children[0]).getChildren();
		assertFalse("Two identical tree nodes classes with identical values and different parents must not be equal", subChildren[0].equals(children[0]));
		assertFalse("Two identical tree nodes classes with different values and different parents must not be equal", subChildren[0].equals(children[1]));
		assertFalse("Two different tree nodes classes with different values and different parents must not be equal", subChildren[0].equals(children[2]));
	}
	
	public static void testHashCode() throws Exception {
		TestNode testNode1 = new TestNode(NODE_PARENT, NODE_VALUE);
		TestNode testNode2 = new TestNode(NODE_PARENT, NODE_VALUE);
		assertTrue("Two identical tree nodes must have identical hash codes", testNode1.hashCode() == testNode1.hashCode());
		assertTrue("Two tree nodes with identical tree node classes, identical values and identical parents must have identical hash codes", testNode1.hashCode() == testNode2.hashCode());

		TestNode testNodeChild1 = new TestNode(testNode1, CHILDNODE_VALUE1);
		TestNode testNodeChild2 = new TestNode(testNode1, CHILDNODE_VALUE1);
		assertTrue("Two identical tree nodes classes with identical parents and identical values must be equal", testNodeChild1.equals(testNodeChild2));
		assertTrue("Two identical tree nodes classes with identical parents and identical values must have the same hash code", testNodeChild1.hashCode() == testNodeChild2.hashCode());
		
		NonChildAwareTestNode testNonChildAwareNode1 = new NonChildAwareTestNode(testNode1, CHILDNODE_VALUE1);
		NonChildAwareTestNode testNonChildAwareNode2 = new NonChildAwareTestNode(testNode1, CHILDNODE_VALUE1);
		assertTrue("Two identical tree nodes classes with identical parents and identical values must be equal", testNonChildAwareNode1.equals(testNonChildAwareNode2));
		assertTrue("Two identical tree nodes classes with identical parents and identical values must have the same hash code", testNonChildAwareNode1.hashCode() == testNonChildAwareNode2.hashCode());
	}

//	public static void testChildAware() throws Exception {
//		TestNode testNode = new TestNode(NODE_PARENT, NODE_VALUE);
//		assertTrue("Tree nodes by default have to be child aware", testNode.isChildAware());
//		NonChildAwareTestNode nonChildAwareTestNode = new NonChildAwareTestNode(NODE_PARENT, NODE_VALUE);
//		assertFalse("The method isChildAware has to return false for none child aware nodes", nonChildAwareTestNode.isChildAware());
//	}
	
	public static void testMarkerSupport() throws Exception {
		TestNode testNode = new TestNode(NODE_PARENT, NODE_VALUE);
		TreeNodeMarkerSupport markerSupport = (TreeNodeMarkerSupport) testNode.getAdapter(TreeNodeMarkerSupport.class);
		assertTrue("Tree nodes have to have built in marker support", markerSupport instanceof TreeNodeMarkerSupport);
		assertTrue("Initial value for sevirity has to be SEVERITY_UNKNOWN", markerSupport.getMaxSeverity() == TreeNodeMarkerSupport.SEVERITY_UNKNOWN);
	}
	
	static class TestNode extends TreeNode<String> {
		public TestNode(String value) {
			super(value);
			setParent(NODE_PARENT);
		}
		
		public TestNode(Object parent, String value) {
			super(parent, value);
		}
		
		public Object[] getChildren() {
			return new Object[] {new TestNode(this, CHILDNODE_VALUE1), new TestNode(this, CHILDNODE_VALUE2), new NonChildAwareTestNode(CHILDNODE_VALUE1)};
		}
		
		public boolean hasChildren() {
			return true;
		}
	}
	
	static class NonChildAwareTestNode extends TreeNode<String> {
		public NonChildAwareTestNode(String value) {
			this(null, value);
		}
		
		public NonChildAwareTestNode(Object parent, String value) {
			super(parent, value);
		}
		
		public Object[] getChildren() {
			return ITreeNode.EMPTY_ARRAY;
		}
		
		public boolean hasChildren() {
			return false;
		}
	}
}
