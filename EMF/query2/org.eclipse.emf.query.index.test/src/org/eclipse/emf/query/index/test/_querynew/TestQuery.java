/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.test._querynew;

import static org.eclipse.emf.query.index.test._querynew.Query.eobject;
import static org.eclipse.emf.query.index.test._querynew.Query.eobjects;
import static org.eclipse.emf.query.index.test._querynew.Query.reference;
import static org.eclipse.emf.query.index.test._querynew.Query.references;
import static org.eclipse.emf.query.index.test._querynew.Query.resource;
import static org.eclipse.emf.query.index.test._querynew.Query.resources;
import static org.eclipse.emf.query.index.test._querynew.Query.select;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 * 
 */
@Ignore("Not working!")
public class TestQuery {

	@Test
	public void test() {
		select(resources("*").containing(eobject("f*").ofType("uri")));

		// select(resources("*").containing(eobject("f*").ofType("uri").in(resources().containing(eobject("*")))));

		select(resource("uri"));

		select(eobject("f*").ofType("uri"));

		select(eobjects().ofType("uri").in(resource("res")));

		select(references().from(resource("res")));

		select(reference("refUri").from(eobjects().ofType("uri")).to(resource("res")));
	}
}
