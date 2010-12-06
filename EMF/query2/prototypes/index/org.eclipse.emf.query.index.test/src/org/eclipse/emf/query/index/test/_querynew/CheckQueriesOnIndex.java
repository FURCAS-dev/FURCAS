package org.eclipse.emf.query.index.test._querynew;

import static org.eclipse.emf.query.index.test._querynew.Query.eobject;
import static org.eclipse.emf.query.index.test._querynew.Query.eobjects;
import static org.eclipse.emf.query.index.test._querynew.Query.reference;
import static org.eclipse.emf.query.index.test._querynew.Query.references;
import static org.eclipse.emf.query.index.test._querynew.Query.resource;
import static org.eclipse.emf.query.index.test._querynew.Query.resources;
import static org.eclipse.emf.query.index.test._querynew.Query.select;

import org.eclipse.emf.query.index.test._querynew.Query.EObjectClass;
import org.eclipse.emf.query.index.test._querynew.Query.SimpleResourceClasses;

public class CheckQueriesOnIndex {

	public void test() {
		SimpleResourceClasses resources = resources("*");
		EObjectClass ofTypeURI = eobject("f*").ofType("uri");
		select(resources.containing(ofTypeURI));

		// select(resources("*").containing(eobject("f*").ofType("uri").in(resources().containing(eobject("*")))));

		select(resource("uri"));

		select(ofTypeURI);

		select(eobjects().ofType("uri").in(resource("res")));

		select(references().from(resource("res")));

		select(reference("refUri").from(eobjects().ofType("uri")).to(resource("res")));
	}
}
