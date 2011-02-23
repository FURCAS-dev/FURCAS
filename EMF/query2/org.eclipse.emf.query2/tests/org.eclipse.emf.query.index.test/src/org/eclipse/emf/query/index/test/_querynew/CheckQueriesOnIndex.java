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
		SimpleResourceClasses resources = resources("*"); //$NON-NLS-1$
		EObjectClass ofTypeURI = eobject("f*").ofType("uri"); //$NON-NLS-1$ //$NON-NLS-2$
		select(resources.containing(ofTypeURI));

		// select(resources("*").containing(eobject("f*").ofType("uri").in(resources().containing(eobject("*")))));

		select(resource("uri")); //$NON-NLS-1$

		select(ofTypeURI);

		select(eobjects().ofType("uri").in(resource("res"))); //$NON-NLS-1$ //$NON-NLS-2$

		select(references().from(resource("res"))); //$NON-NLS-1$

		select(reference("refUri").from(eobjects().ofType("uri")).to(resource("res")));  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
	}
}
