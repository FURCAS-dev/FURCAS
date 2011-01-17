/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.query.EObjectQuery;
import org.eclipse.emf.query.index.query.EReferenceQuery;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.QueryResult;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryClientScope;

public class IndexQueryService {

	/**
	 * Depending on the <code>mofClasses</code> parameter this method returns
	 * the following:
	 * <p>
	 * 1. <code>mofClasses</code> not empty (size!=0): Returns all direct
	 * {@link MRI} instances of the specified {@link MofClass MofClasses} in the
	 * defined scope <code>queryClientScope</code>. No instances of sub classes!
	 * <p>
	 * 2. <code>mofClasses</code> empty (size==0): Returns all elements of all
	 * types within a <b>inclusive</b> partition scope defined in
	 * <code>queryClientScope</code>
	 * <p>
	 * The result contains no duplicate {@link MRI MRIs} and no
	 * <code>null</code> values. The element order in the returned
	 * {@link Collection} is arbitrary.
	 * 
	 * @param queryClientScope
	 *            Defines the scope for the query (e.g. ClientSpecs,
	 *            Partitions); must not be <code>null</code>.
	 * @param mofClasses
	 *            Array of {@link MRI MRIs} of MofClasses for which all
	 *            instances have to be returned; must not be <code>null</code>.
	 * @return A Collection of {@link MRI MRIs} of the specified
	 *         {@link MofClass MofClasses}.
	 * @throws IllegalArgumentException
	 *             if <code>mofClasses</code> is empty and query scope
	 *             exclusive.
	 */
	public static List<URI> getInstances(Index index, SpiFacilityQueryClientScope queryClientScope, URI[] eClassUris) {
		assert queryClientScope != null;
		assert eClassUris != null;

		final Set<URI> result = new HashSet<URI>();
		final Set<URI> scope = queryClientScope.getPartitionsScope();
		assert scope != null;

		final boolean isInclusiveScope = queryClientScope.isPartitionScopeInclusive();

		if (scope.size() == 0 && isInclusiveScope) {
			return Collections.emptyList();
		}

		if (eClassUris.length == 0) { // query for EObject (i.e. reflect
			// element)
			if (!isInclusiveScope) {
				throw new IllegalArgumentException(Messages.IndexQueryService_EObjectWithoutInclusiveScope);
			}
			for (URI scopeURI : scope) {
				final EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
				eObjectQuery.resource().uri(scopeURI.toString());

				index.executeQueryCommand(new QueryCommand() {

					public void execute(QueryExecutor queryExecutor) {
						QueryResult<EObjectDescriptor> execute = queryExecutor.execute(eObjectQuery);
						for (EObjectDescriptor eODesc : execute) {
							result.add(eODesc.getResourceURI().appendFragment(eODesc.getFragment()));
						}
					}
				});
			}
		} else {
			// for each
			for (int i = 0; i < eClassUris.length; i++) {

				final EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
				eObjectQuery.eClassURI(eClassUris[i]);

				index.executeQueryCommand(new QueryCommand() {

					public void execute(QueryExecutor queryExecutor) {
						QueryResult<EObjectDescriptor> execute = queryExecutor.execute(eObjectQuery);
						for (EObjectDescriptor objDesc : execute) {

							URI candidateResourceUri = objDesc.getResourceURI();
							boolean isInScope = scope.contains(candidateResourceUri);

							if (isInclusiveScope == isInScope) {
								// add uri of instance to result
								result.add(candidateResourceUri.appendFragment(objDesc.getFragment()));
							}

						}
					}
				});
			}
		}

		return new ArrayList<URI>(result);
	}

	/**
	 * Returns all partitions that are linked from the given partitions
	 * <code>fromPri</code> by links of the given association
	 * <code>association</code> which are stored in the partition
	 * <code>fromPRI</code>.
	 * <p>
	 * The result set will never contain the <code>fromPRI</code> itself
	 * (regardless of intra-partition storage).
	 * <p>
	 * Note: <code>association</code> can also be the {@link MRI} of an object
	 * value attribute link type.
	 * 
	 * @param queryClientScope
	 *            Defines the scope for the query (e.g. ClientSpecs,
	 *            Partitions); must not be <code>null</code>.
	 * @param fromPRI
	 *            The partition where the links are stored; must not be
	 *            <code>null</code>.
	 * @param association
	 *            The type of the links to regard; must not be <code>null</code>
	 *            .
	 * @return A set of {@link PRI PRIs} or an empty set if nothing was found
	 */
	public static Set<URI> getLinkedPartitions(Index index, SpiFacilityQueryClientScope queryClientScope, URI fromResource, URI referenceUri) {

		final Set<URI> result = new HashSet<URI>();

		final EReferenceQuery<EReferenceDescriptor> eReferenceQuery = IndexQueryFactory.createEReferenceQuery();
		eReferenceQuery.sourceEObject().resource().uri(fromResource.toString());
		eReferenceQuery.eReferenceURI(referenceUri);

		index.executeQueryCommand(new QueryCommand() {

			public void execute(QueryExecutor queryExecutor) {
				QueryResult<EReferenceDescriptor> execute = queryExecutor.execute(eReferenceQuery);
				for (EReferenceDescriptor eReferenceDescriptor : execute) {
					URI targetResourceUri = eReferenceDescriptor.getTargetResourceURI();
					if (targetResourceUri != null) {
						result.add(targetResourceUri);
					}
				}
			}
		});

		return result;
	}

	/**
	 * Depending on the <code>mofClasess</code> parameter this method returns
	 * the following:
	 * <p>
	 * 1. <code>mofClasses</code> not empty (size!=0): Returns all direct
	 * {@link PRI} partitions of the specified {@link MofClass MofClasses} in
	 * the defined scope <code>queryClientScope</code>. No partitions for
	 * instances of sub classes!
	 * <p>
	 * 2. <code>mofClasses</code> empty (size==0): Returns all partitions of all
	 * types within an <b>inclusive</b> partition scope defined in
	 * <code>queryClientScope</code>
	 * <p>
	 * The result contains no duplicate {@link PRI PRIs} and no
	 * <code>null</code> values. The element order in the returned {@link Set}
	 * is arbitrary.
	 * 
	 * @param queryClientScope
	 *            Defines the scope for the query (e.g. ClientSpecs,
	 *            Partitions); must not be <code>null</code>.
	 * @param mofClasses
	 *            Array of {@link MRI MRIs} of MofClasses for which all
	 *            instances have to be returned; must not be <code>null</code>.
	 * @return A Set of {@link PRI PRIs} of the specified {@link MofClass
	 *         MofClasses}.
	 */
	public static Set<URI> getPartitionsOfInstances(Index index, SpiFacilityQueryClientScope queryClientScope, URI[] eClassUris) {

		assert queryClientScope != null;
		assert eClassUris != null;

		final Set<URI> result = new HashSet<URI>();
		final Set<URI> scope = queryClientScope.getPartitionsScope();
		final boolean isInclusiveScope = queryClientScope.isPartitionScopeInclusive();

		if (scope.size() == 0 && isInclusiveScope) {
			return Collections.emptySet();
		}

		if (eClassUris.length == 0) { // query for EObject (i.e. reflect
			// element)
			index.executeQueryCommand(new QueryCommand() {

				public void execute(QueryExecutor queryExecutor) {
					QueryResult<ResourceDescriptor> execute = queryExecutor.execute(IndexQueryFactory.createResourceQuery());
					URI uri;
					for (ResourceDescriptor resDesc : execute) {
						if (scope.contains(uri = resDesc.getURI()) == isInclusiveScope) {
							result.add(uri);
						}
					}
				}
			});
		} else {
			// for each
			for (int i = 0; i < eClassUris.length; i++) {
				// get class for type uri
				// EClass clazz = (EClass)
				// this.rs.getPackageRegistry().getEPackage(eClassUris[i].toString());

				// get instances from index
				final EObjectQuery<EObjectDescriptor> eObjectQuery = IndexQueryFactory.createEObjectQuery();
				eObjectQuery.eClassURI(eClassUris[i]);

				index.executeQueryCommand(new QueryCommand() {

					public void execute(QueryExecutor queryExecutor) {
						QueryResult<EObjectDescriptor> execute = queryExecutor.execute(eObjectQuery);
						for (EObjectDescriptor eObjectDescriptor : execute) {
							URI candidateResourceUri = eObjectDescriptor.getResourceURI();
							boolean isInScope = scope.contains(candidateResourceUri);

							if (isInclusiveScope && isInScope || !isInclusiveScope && !isInScope) {
								// add uri of instance to result
								result.add(candidateResourceUri);
							}
						}
					}
				});

			}
		}
		return result;
	}

	public static Collection<EClass> getAllSubtypes(Index index, EClass typeAsMofClass) {

		Set<EClass> result = new HashSet<EClass>();
		findSubtypesRecursive(index, typeAsMofClass, result);
		return result;
	}

	private static void findSubtypesRecursive(Index index, EClass superClass, Set<EClass> result) {

		List<EClass> subTypes = getSubTypes(index, superClass);
		result.addAll(subTypes);

		if (subTypes.isEmpty())
			return;
		else {
			for (EClass clazz : subTypes) {
				// recursion
				findSubtypesRecursive(index, clazz, result);
			}
		}
	}

	private static final URI SUPERTYPE_URI = EcoreUtil.getURI(EcorePackage.Literals.ECLASS__ESUPER_TYPES);

	private static List<EClass> getSubTypes(Index index, EClass superClass) {

		URI classUri = EcoreUtil.getURI(superClass);

		final EReferenceQuery<EReferenceDescriptor> eReferenceQuery = IndexQueryFactory.createEReferenceQuery();
		eReferenceQuery.eReferenceURI(SUPERTYPE_URI);
		eReferenceQuery.targetEObject().fragment(classUri.fragment());
		eReferenceQuery.targetEObject().resource().uri(classUri.trimFragment().toString());

		final List<EClass> subTypes = new ArrayList<EClass>(1);

		index.executeQueryCommand(new QueryCommand() {

			public void execute(QueryExecutor queryExecutor) {
				QueryResult<EReferenceDescriptor> execute = queryExecutor.execute(eReferenceQuery);
				Iterator<EReferenceDescriptor> iterator = execute.iterator();
				for (; iterator.hasNext();) {
					EReferenceDescriptor next = iterator.next();
					URI uri = next.getSourceResourceURI().appendFragment(next.getSourceFragment());
					subTypes.add(resolveClassUri(uri));
				}
			}
		});

		return subTypes;

	}

	private static EObject resolveUri(URI uri) {

		ResourceSet rs = new ResourceSetImpl();
		return rs.getEObject(uri, false);
	}

	private static EClass resolveClassUri(URI eClassUri) {

		EObject o = resolveUri(eClassUri);
		if (o instanceof EClass)
			return (EClass) o;
		else
			throw new IllegalArgumentException(Messages.getString(Messages.IndexQueryService_UnIdentifiableURI, new String[]{eClassUri.toString()}));
	}

}
