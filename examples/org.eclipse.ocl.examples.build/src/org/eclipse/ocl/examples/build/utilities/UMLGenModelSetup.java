/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: UMLGenModelSetup.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.uml2.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.uml2.codegen.ecore.genmodel.generator.UML2GenModelGeneratorAdapterFactory;
import org.eclipse.uml2.uml.ecore.importer.UMLImporter;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * Initializes UML genmodel support.
 */
public class UMLGenModelSetup
{
	public static final GeneratorAdapterFactory.Descriptor UML_DESCRIPTOR1 = new GeneratorAdapterFactory.Descriptor() {
		public GeneratorAdapterFactory createAdapterFactory() {
			return new GenModelGeneratorAdapterFactory();
		}
	};

	public static final GeneratorAdapterFactory.Descriptor UML_DESCRIPTOR2 = new GeneratorAdapterFactory.Descriptor() {
		public GeneratorAdapterFactory createAdapterFactory() {
			return new UML2GenModelGeneratorAdapterFactory();
		}
	};

	private ResourceSet resourceSet = null;
	
	public UMLGenModelSetup() {
		UMLImporter.class.getClass();		// Dummy reference to enforce class path
	}

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}
	
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor
	     (GenModelPackage.eNS_URI, UML_DESCRIPTOR1);
		GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor
	     (GenModelPackage.eNS_URI, UML_DESCRIPTOR2);
	}
}
