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
 * $Id: BaseLabelProvider.java,v 1.1 2010/05/17 09:18:04 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.ui.labeling;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.osgi.framework.Bundle;

import com.google.inject.Inject;

/**
 * Provides labels for BaseCST objects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class BaseLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public BaseLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
	
	@Override
	protected Image convertToImage(Object imageDescription) {
		if (imageDescription instanceof String) {
			String imagePath = (String)imageDescription;
			if (imagePath.startsWith("/")) {	
				int index = imagePath.indexOf('/', 1);
				if (index > 1) {
					String bundlePath = imagePath.substring(1, index);
					Bundle bundle = Platform.getBundle(bundlePath);
					if (bundle != null) {
						String imageFile = imagePath.substring(index+1);
						Path path = new Path(imageFile);
						URL imgUrl = FileLocator.find(bundle, path, null);
						if (imgUrl != null) {
							return super.convertToImage(ImageDescriptor.createFromURL(imgUrl));
						}
					}
				}
			}				
		}
		return super.convertToImage(imageDescription);
	}
	 
	@Override
	protected Object doGetText(Object element) {
		Object object = super.doGetText(element);
		if (object instanceof String) {
			String text = (String)object;
			int index = text.indexOf('\n');
			if (index >= 0) {
				text = text.substring(0, index);
			}
			object = text.trim();
		}
		return object;
	}

	protected String image(AnnotationElementCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Comment.gif";
	}

	protected String image(ClassifierCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Class.gif";
	}

	protected String image(DocumentCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Model.gif";
	}

	protected String image(EnumLiteralCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/EnumerationLiteral.gif";
	}

	protected String image(ImportCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/PackageImport.gif";
	}

	protected String image(OperationCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Operation.gif";
	}

	protected String image(PackageCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Package.gif";
	}

	protected String image(ParameterCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Parameter_in.gif";
	}

	protected String image(PrimitiveTypeRefCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/PrimitiveType.gif";
	}

	protected String image(StructuralFeatureCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Property.gif";
	}

	protected String image(TypeParameterCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/TemplateParameter.gif";
	}
}
