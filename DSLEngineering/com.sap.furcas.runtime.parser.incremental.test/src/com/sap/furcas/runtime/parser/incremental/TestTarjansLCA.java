package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.sap.ide.cts.parser.incremental.util.TarjansLCA;
import com.sap.ide.cts.parser.incremental.util.TarjansLCA.Node;
import com.sap.ide.cts.parser.incremental.util.TarjansLCA.SearchSet;


public class TestTarjansLCA {

	
	@SuppressWarnings("unchecked")
	@Test
	public void simpleLCA() {
		// create tree
		Node<Integer> p[] = new Node[24];
		p[0] = new Node<Integer>(0, null); // root
		p[1] = new Node<Integer>(1, p[0]);
		p[2] = new Node<Integer>(2, p[0]);
		p[3] = new Node<Integer>(3, p[2]);
		p[4] = new Node<Integer>(4, p[2]);


		// make lca query
		ArrayList<SearchSet<Integer>> q = new ArrayList<SearchSet<Integer>>();
		q.add(new SearchSet<Integer>(p[3].getArgumet(), p[4].getArgumet()));


		// lca
		TarjansLCA<Integer> lca = new TarjansLCA<Integer>(null);

		lca.lca(p[0], q);

		// dump results
		assertEquals(2, (int)q.get(0).result);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testLCA() {
		// create tree
		/*
		 *                               0
                         +--------------+--------------------+
                          |             |                    |
                         1              2                    3
                  +-----+------+     +---+       +-------+---------+
                  |     |      |     |   |       |       |         |
                  4     5      6     7   8       9       10        11
            +---+              +         +         	+--+------+     |
            |   |              |         |          |         |    23
          12   13              14       15         16         17
                        +--------+                       +----+----+
                        |        |                       |    |    |
                        18       19                      20   21   22 
		 */
		Node<Integer> p[] = new Node[24];
		p[0] = new Node<Integer>(0, null); // root
		p[1] = new Node<Integer>(1, p[0]);
		p[2] = new Node<Integer>(2, p[0]);
		p[3] = new Node<Integer>(3, p[0]);
		p[4] = new Node<Integer>(4, p[1]);
		p[5] = new Node<Integer>(5, p[1]);
		p[6] = new Node<Integer>(6, p[1]);
		p[7] = new Node<Integer>(7, p[2]);
		p[8] = new Node<Integer>(8, p[2]);
		p[9] = new Node<Integer>(9, p[3]);
		p[10] = new Node<Integer>(10, p[3]);
		p[11] = new Node<Integer>(11, p[3]);
		p[12] = new Node<Integer>(12, p[4]);
		p[13] = new Node<Integer>(13, p[4]);
		p[14] = new Node<Integer>(14, p[6]);
		p[15] = new Node<Integer>(15, p[8]);
		p[16] = new Node<Integer>(16, p[10]);
		p[17] = new Node<Integer>(17, p[10]);
		p[18] = new Node<Integer>(18, p[14]);
		p[19] = new Node<Integer>(19, p[14]);
		p[20] = new Node<Integer>(20, p[17]);
		p[21] = new Node<Integer>(21, p[17]);
		p[22] = new Node<Integer>(22, p[17]);
		p[23] = new Node<Integer>(23, p[11]);

		// make lca query
		ArrayList<SearchSet<Integer>> q = new ArrayList<SearchSet<Integer>>();
		q.add(new SearchSet<Integer>(p[15].getArgumet(), p[19].getArgumet()));
		q.add(new SearchSet<Integer>(p[21].getArgumet(), p[16].getArgumet()));
		q.add(new SearchSet<Integer>(p[14].getArgumet(), p[14].getArgumet()));
		q.add(new SearchSet<Integer>(p[4].getArgumet(), p[23].getArgumet()));
		q.add(new SearchSet<Integer>(p[23].getArgumet(), p[16].getArgumet()));

		// lca
		TarjansLCA<Integer> lca = new TarjansLCA<Integer>(null);

		lca.lca(p[0], q);
		
		// dump results
//		for (SearchSet<Integer> item : q) {
//			System.out.println(item.start + ":" + item.end + ": result is:"
//					+ item.result);
//		}

		Iterator<SearchSet<Integer>> it = q.iterator();
		assertEquals(0, (int)it.next().result);
		assertEquals(10, (int)it.next().result);
		assertEquals(14, (int)it.next().result);
		assertEquals(0, (int)it.next().result);
		assertEquals(3, (int)it.next().result);
	}
}
