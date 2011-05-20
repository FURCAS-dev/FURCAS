/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: BaseCS2Pivot.java,v 1.4 2011/05/20 15:27:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ImportScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.LibraryScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.osgi.util.NLS;

/**
 * BaseCST2Pivot provides an extensible conversion from CS models to the pivot model.
 * <p>
 * Conversion/update occurs in five passes.
 * <p>
 * Pass 1: updateDeclarers()
 * <br>the package/class/property/template parameter CS composition hierarchy is replicated in the pivot hierarchy
 * <br>requests for unreferable declarations are accumulated in <tt>queuedDefiners</tt>. 
 * <br>requests for specialization are accumulated in <tt>queuedBindings</tt>. 
 * <br>requests for references are accumulated in <tt>queuedReferencers</tt>. 
 * <br>all unspecialized pivot elements have correct attributes and composed children
 * <br>all unspecialized pivot nameable elements appear in moniker2pivotMap.
 * <p>
 * Pass 2: updateDefiners()
 * <br>the feature/annotation/detail CS composition hierarchy is replicated in the pivot hierarchy
 * <br>requests for specialization are accumulated in <tt>queuedBindings</tt>. 
 * <br>requests for references are accumulated in <tt>queuedReferencers</tt>. 
 * <br>all unspecialized pivot elements have correct attributes and composed children
 * <br>all unspecialized pivot nameable elements appear in moniker2pivotMap.
 * <p>
 * Pass 3: updateReferencers()
 * <br>the expression CS composition hierarchy is replicated in the pivot hierarchy
 * <br>requests for resolvers are accumulated in <tt>queuedResolvers</tt>. 
 * <p>
 * Pass 4: updateSpecializations()
 * <br>a unique pivot specialization is created/updated from each distinct CS specialization. 
 * <br>further requests for references are accumulated in <tt>queuedReferencers</tt>. 
 * <br>all pivot elements have correct attributes and composed children
 * <br>all pivot nameable elements appear in moniker2pivotMap.
 * <br>all specialized elements have correct signature, formal references
 * <p>
 * Pass 5: updateResolvers()
 * <br>cross-tree references are resolved in the pivot model.
 * <br>- pivot specialization actual arguments
 * <br>- TypedElementCS.type, TypedTypeRefCS.type, ...
 * <p>
 * Correlation between the CS and pivot is achieved by monikers which are unique for all
 * NameableElements. The old pivot model's monikers initialize the moniker2PivotMap so
 * the the subsequent refresh can discover a pre-existing pivot element for each
 * required CS element. The moniker2PivotMap is updated as pivot elements are created.
 * pivot monikers are not used during conversion since it may not be possible to
 * create the correct moniker for a partially converted specialization.
 */
public class BaseCS2Pivot extends CS2Pivot
{	
	private static final class Factory implements CS2Pivot.Factory
	{
		private Factory() {
			CS2Pivot.addFactory(this);
			addUnresolvedProxyMessageProvider(new TypedTypeRefCSTypeUnresolvedProxyMessageProvider());			
			addUnresolvedProxyMessageProvider(new ImportCSNamespaceUnresolvedProxyMessageProvider());			
			addUnresolvedProxyMessageProvider(new LibraryCSPackageUnresolvedProxyMessageProvider());			
		}

		public BaseLeft2RightVisitor createLeft2RightVisitor(CS2PivotConversion converter) {
			return new BaseLeft2RightVisitor(converter);
		}

		public BasePostOrderVisitor createPostOrderVisitor(CS2PivotConversion converter) {
			return new BasePostOrderVisitor(converter);
		}

		public BasePreOrderVisitor createPreOrderVisitor(CS2PivotConversion converter) {
			return new BasePreOrderVisitor(converter);
		}

		public BaseCSVisitor<ScopeCSAdapter, TypeManager> createScopeVisitor(TypeManager typeManager) {
			return new BaseScopeVisitor(typeManager);
		}

		public EPackage getEPackage() {
			return BaseCSTPackage.eINSTANCE;
		}
	}
	
	private static final class ImportCSNamespaceUnresolvedProxyMessageProvider extends UnresolvedProxyMessageProvider
	{		
		private ImportCSNamespaceUnresolvedProxyMessageProvider() {
			super(BaseCSTPackage.Literals.IMPORT_CS__NAMESPACE);
		}
		
		@Override
		public String getMessage(EObject context, String linkText) {
			if (context instanceof ElementCS) {
				ScopeCSAdapter scopeCSAdapter = AbstractScopeAdapter.getScopeCSAdapter((ElementCS) context);
				if (scopeCSAdapter instanceof ImportScopeAdapter) {
					String message = ((ImportScopeAdapter)scopeCSAdapter).getMessage();
					return NLS.bind(OCLMessages.UnresolvedImport_ERROR_, linkText, message);
				}
			}
			return null;
		}
	}
	
	private static final class LibraryCSPackageUnresolvedProxyMessageProvider extends UnresolvedProxyMessageProvider
	{		
		private LibraryCSPackageUnresolvedProxyMessageProvider() {
			super(BaseCSTPackage.Literals.LIBRARY_CS__PACKAGE);
		}
		
		@Override
		public String getMessage(EObject context, String linkText) {
			if (context instanceof ElementCS) {
				ScopeCSAdapter scopeCSAdapter = AbstractScopeAdapter.getScopeCSAdapter((ElementCS) context);
				if (scopeCSAdapter instanceof LibraryScopeAdapter) {
					String message = ((LibraryScopeAdapter)scopeCSAdapter).getMessage();
					return NLS.bind(OCLMessages.UnresolvedLibrary_ERROR_, linkText, message);
				}
			}
			return null;
		}
	}
	
	private static final class TypedTypeRefCSTypeUnresolvedProxyMessageProvider extends UnresolvedProxyMessageProvider
	{		
		private TypedTypeRefCSTypeUnresolvedProxyMessageProvider() {
			super(BaseCSTPackage.Literals.TYPED_TYPE_REF_CS__TYPE);
		}
		
		@Override
		public String getMessage(EObject context, String linkText) {
			return NLS.bind(OCLMessages.UnresolvedType_ERROR_, linkText);
		}
	}

	public static CS2Pivot.Factory FACTORY = new Factory();

	public BaseCS2Pivot(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			TypeManager typeManager) {
		super(cs2pivotResourceMap, typeManager);
	}
}