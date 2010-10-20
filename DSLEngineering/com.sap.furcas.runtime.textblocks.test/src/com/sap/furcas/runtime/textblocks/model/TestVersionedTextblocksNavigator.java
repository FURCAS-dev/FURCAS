package com.sap.furcas.runtime.textblocks.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.textblocks.testutils.FixtureProvidingTextBlockTest;

public class TestVersionedTextblocksNavigator extends FixtureProvidingTextBlockTest{
	
	private final VersionedTextBlockNavigator nav = new VersionedTextBlockNavigator(Version.REFERENCE);
	@Test
	public void testFloorSearchByOffset() {
		LexedToken t1 = modelFactory.createLexedToken();
		LexedToken t2 = modelFactory.createLexedToken();
		LexedToken t3 = modelFactory.createLexedToken();
		LexedToken t4 = modelFactory.createLexedToken();
		LexedToken t5 = modelFactory.createLexedToken();

		List<DocumentNode> nodes = new ArrayList<DocumentNode>();
		nodes.add(t1);
		nodes.add(t2);
		nodes.add(t3);
		nodes.add(t4);
		nodes.add(t5);

		t1.setOffset(0);
		t2.setOffset(5);
		t3.setOffset(6);
		t4.setOffset(10);
		t5.setOffset(20);

		assertEquals(t1, nav.floorSearchByOffset(nodes, 0));
		assertEquals(t1, nav.floorSearchByOffset(nodes, 1));
		assertEquals(t1, nav.floorSearchByOffset(nodes, 4));
		assertEquals(t2, nav.floorSearchByOffset(nodes, 5));
		assertEquals(t3, nav.floorSearchByOffset(nodes, 6));
		assertEquals(t3, nav.floorSearchByOffset(nodes, 9));
		assertEquals(t4, nav.floorSearchByOffset(nodes, 10));
		assertEquals(t4, nav.floorSearchByOffset(nodes, 19));
		assertEquals(t5, nav.floorSearchByOffset(nodes, 20));
		assertEquals(t5, nav.floorSearchByOffset(nodes, 21));

		t1.setOffset(3);
		assertEquals(null, nav.floorSearchByOffset(nodes, 0));
		assertEquals(null, nav.floorSearchByOffset(nodes, 1));
		assertEquals(null, nav.floorSearchByOffset(nodes, 2));
	}
	
	@Test
	public void testGetFloorToken() {
		assertEquals(lexed1, nav.getFloorToken(main, 0));
		assertEquals(lexed1, nav.getFloorToken(main, 1));
		assertEquals(lexed1, nav.getFloorToken(main, 4));
		assertEquals(lexed2, nav.getFloorToken(main, 5));
		assertEquals(lexed3, nav.getFloorToken(main, 6));
		assertEquals(lexed3, nav.getFloorToken(main, 8));
		assertEquals(lexed3, nav.getFloorToken(main, 13));
		assertEquals(subToken, nav.getFloorToken(main, 14));
		assertEquals(lexed4, nav.getFloorToken(main, 15));
		assertEquals(lexed4, nav.getFloorToken(main, 16));
		assertEquals(lexed4, nav.getFloorToken(main, 19));
		assertEquals(lexed4, nav.getFloorToken(main, 20));

		main.getSubNodes().clear();
		main.getSubNodes().add(bos);
		main.getSubNodes().add(eos);

		assertEquals(null, nav.getFloorToken(main, 0));
	}

	
}
