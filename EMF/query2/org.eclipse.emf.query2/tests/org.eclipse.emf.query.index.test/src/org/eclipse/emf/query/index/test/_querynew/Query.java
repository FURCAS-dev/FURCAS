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

/**
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 * 
 */
public class Query {

	private interface List<T> {

	}

	private interface Single<T> {

	}

	private interface Resource {

	}

	private interface EObject {

	}

	private interface Reference {

	}

	private static interface IResource {

		public <T> IResource containing(Single<T> content);

		public <T> IResource containing(List<T> content);
	}

	public static class ResourceClass implements Single<Resource>, IResource {

		public <T> ResourceClass containing(Single<T> content) {
			// TODO Auto-generated method stub
			return null;
		}

		public <T> ResourceClass containing(List<T> content) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public static class ResourceClasses implements List<Resource>, IResource {

		public <T> ResourceClasses containing(Single<T> content) {
			// TODO Auto-generated method stub
			return null;
		}

		public <T> ResourceClasses containing(List<T> content) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public static class SimpleResourceClass extends ResourceClass {

	}

	public static class SimpleResourceClasses extends ResourceClasses {

	}

	private static interface IEObject {

		public IEObject ofType(String uri);

		public IEObject in(SimpleResourceClasses res);

		public IEObject in(SimpleResourceClass res);

	}

	public static class EObjectClass implements Single<EObject>, IEObject {

		public EObjectClass in(SimpleResourceClasses res) {
			// TODO Auto-generated method stub
			return null;
		}

		public EObjectClass in(SimpleResourceClass res) {
			// TODO Auto-generated method stub
			return null;
		}

		public EObjectClass ofType(String uri) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public static class EObjectClasses implements List<EObject>, IEObject {

		public EObjectClasses in(SimpleResourceClasses res) {
			// TODO Auto-generated method stub
			return null;
		}

		public EObjectClasses in(SimpleResourceClass res) {
			// TODO Auto-generated method stub
			return null;
		}

		public EObjectClasses ofType(String uri) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	private static interface IReference {

		public <T> IReference from(Single<T> from);

		public <T> IReference from(List<T> from);

		public <T> IReference to(Single<T> from);

		public <T> IReference to(List<T> from);
	}

	public static class ReferenceClass implements Single<Reference>, IReference {

		public <T> ReferenceClass from(Single<T> from) {
			// TODO Auto-generated method stub
			return this;
		}

		public <T> ReferenceClass from(List<T> from) {
			// TODO Auto-generated method stub
			return this;
		}

		public <T> ReferenceClass to(Single<T> from) {
			// TODO Auto-generated method stub
			return this;
		}

		public <T> ReferenceClass to(List<T> from) {
			// TODO Auto-generated method stub
			return this;
		}

	}

	public static class ReferenceClasses implements List<Reference>, IReference {

		public <T> ReferenceClasses from(Single<T> from) {
			// TODO Auto-generated method stub
			return this;
		}

		public <T> ReferenceClasses from(List<T> from) {
			// TODO Auto-generated method stub
			return this;
		}

		public <T> ReferenceClasses to(Single<T> from) {
			// TODO Auto-generated method stub
			return this;
		}

		public <T> ReferenceClasses to(List<T> from) {
			// TODO Auto-generated method stub
			return this;
		}

	}

	public static <T> Iterable<T> select(List<T> q) {
		return null;
	}

	public static <T> T select(Single<T> q) {
		return null;
	}

	public static SimpleResourceClasses resources() {
		return null;
	}

	public static SimpleResourceClass resource() {
		return null;
	}

	public static SimpleResourceClasses resources(String uri) {
		return null;
	}

	public static SimpleResourceClass resource(String uri) {
		return null;
	}

	public static EObjectClasses eobjects() {
		return null;
	}

	public static EObjectClass eobject() {
		return null;
	}

	public static EObjectClasses eobjects(String frag) {
		return null;
	}

	public static EObjectClass eobject(String frag) {
		return null;
	}

	public static ReferenceClasses references() {
		return null;
	}

	public static ReferenceClass reference() {
		return null;
	}

	public static ReferenceClasses references(String uri) {
		return null;
	}

	public static ReferenceClass reference(String uri) {
		return null;
	}

}
