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
 * $Id: BaseLabelProvider.java,v 1.2 2010/05/22 19:02:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.ui.labeling;

import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
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

	protected void appendClass(StringBuffer s, Object object) {
		s.append("<");
		s.append(object != null ? object.getClass().getSimpleName() : "null");
		s.append(">");
	}

	protected void appendMultiplicity(StringBuffer s, TypedElementCS ele) {
		String multiplicity = ele.getMultiplicity();
		if (multiplicity != null) {
			s.append("[");
			s.append(multiplicity);
			s.append("]");
		}
		else {
			int lower = ele.getLower();
			int upper = ele.getUpper();
			if ((lower != 1) || (upper != 1)) {
				s.append("[");
				if (upper < 0) {
					if (lower == 1) {
						s.append("+");
					}
					else {
						if (lower != 0) {
							s.append(lower);
							s.append("..");
						}
						s.append("*");
					}
				}
				else if ((lower == 0) && (upper == 1)) {
					s.append("?");
				}
				else {
					s.append(lower);
					if (lower != upper) {
						s.append("..");
						s.append(upper);
					}
				}
				s.append("]");
			}
		}
	}

	protected void appendName(StringBuffer s, NamedElementCS csElement) {
		if (csElement != null) {
			if (csElement.eIsProxy()) {
				EcoreUtil.resolve(csElement, csElement);
			}
			appendString(s, csElement.getName());
		}	
	}

	protected void appendOptionalName(StringBuffer s, NamedElementCS csElement) {
		if (csElement != null) {
			appendOptionalString(s, csElement.getName());
		}	
	}

	protected void appendOptionalString(StringBuffer s, String string) {
		if (string != null) {
			s.append(string);
		}	
	}

	protected void appendParameters(StringBuffer s, List<ParameterCS> parameters) {
		s.append("(");
		String prefix = "";
		for (ParameterCS csParameter : parameters) {
			s.append(prefix);
			appendType(s, csParameter.getType());
			appendMultiplicity(s, csParameter);
			prefix = ", ";
		}
		s.append(")");
	}

	protected void appendString(StringBuffer s, String string) {
		if (string != null) {
			s.append(string);
		}	
		else {
			s.append("<null>");
		}	
	}

	protected void appendSuperTypes(StringBuffer s, List<TypedRefCS> superTypes) {
		if (!superTypes.isEmpty()) {
			String prefix = " -> ";
			for (TypedRefCS superType : superTypes) {
				s.append(prefix);
				appendType(s, superType);
				prefix = ", ";
			}
		}
	}

	protected void appendType(StringBuffer s, TypeRefCS type) {
		if (type instanceof PrimitiveTypeRefCS) {
			appendName(s, (PrimitiveTypeRefCS)type);
		}
		else if (type instanceof CollectionTypeRefCS) {
			appendName(s, (CollectionTypeRefCS)type);
			s.append("<");
			appendType(s, ((CollectionTypeRefCS)type).getTypeArguments());
			s.append(">");
		}
		else if (type instanceof QualifiedTypeRefCS) {
			appendType(s, ((QualifiedTypeRefCS)type).getElement());
		}
		else if (type instanceof TypedTypeRefCS) {
			appendType(s, ((TypedTypeRefCS)type).getType());
			List<TypeRefCS> typeArguments = ((TypedTypeRefCS)type).getTypeArguments();
			if (!typeArguments.isEmpty()) {
				s.append("<");
				String prefix = "";
				for (TypeRefCS typeArg : typeArguments) {
					s.append(prefix);
					appendType(s, typeArg);
					prefix = ", ";
				}
				s.append(">");
			}
		}
		else if (type instanceof WildcardTypeRefCS) {
			s.append("?");
		}	
	}

	protected void appendType(StringBuffer s, TypeCS type) {
		if (type instanceof NamedElementCS) {
			appendName(s, (NamedElementCS)type);
		}
		else if (type != null) {
			appendClass(s, type);
		}	
	}

	protected void appendTypeParameters(StringBuffer s, List<TypeParameterCS> typeParameters) {
		if (!typeParameters.isEmpty()) {
			s.append("<");
			String prefix = "";
			for (TypeParameterCS typeParameter : typeParameters) {
				s.append(prefix);
				appendType(s, typeParameter);
				prefix = ", ";
			}
			s.append(">");
		}
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

	protected String text(ElementCS ele) {
		return "<" + ele.getClass().getSimpleName() + ">";
	}

	protected String image(AnnotationElementCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Comment.gif";
	}

	protected String text(ClassCS ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		appendTypeParameters(s, ele.getTypeParameters());
		appendSuperTypes(s, ele.getSuperTypes());
		return s.toString();
	}

	protected String image(ClassifierCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Class.gif";
	}

	protected String text(ClassifierCS ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		appendTypeParameters(s, ele.getTypeParameters());
		return s.toString();
	}

	protected String image(DocumentCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Model.gif";
	}

	protected String image(EnumLiteralCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/EnumerationLiteral.gif";
	}

	protected String text(EnumLiteralCS ele) {
		return ele.getName();
	}

	protected String image(ImportCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/PackageImport.gif";
	}

	protected String text(ImportCS ele) {
		StringBuffer s = new StringBuffer();
		appendOptionalName(s, ele);
		s.append(" : ");
//		appendString(s, ele.getUri());
		return s.toString();
	}

	protected String image(OperationCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Operation.gif";
	}

	protected String text(OperationCS ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		appendTypeParameters(s, ele.getTypeParameters());
		appendParameters(s, ele.getParameters());
		s.append(" : ");
		appendType(s, ele.getType());
		appendMultiplicity(s, ele);
		return s.toString();
	}

	protected String image(PackageCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Package.gif";
	}

	protected String text(PackageCS ele) {
		return ele.getName();
	}

	protected String image(ParameterCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Parameter_in.gif";
	}

	protected String text(ParameterCS ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		s.append(" : ");
		appendType(s, ele.getType());
		appendMultiplicity(s, ele);
		return s.toString();
	}

	protected String image(PrimitiveTypeRefCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/PrimitiveType.gif";
	}

	protected String image(StructuralFeatureCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Property.gif";
	}

	protected String text(StructuralFeatureCS ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		s.append(" : ");
		appendType(s, ele.getType());
		appendMultiplicity(s, ele);
		return s.toString();
	}

	protected String text(TypeCS ele) {
		StringBuffer s = new StringBuffer();
		appendType(s, ele);
		return s.toString();
	}

	protected String image(TypeParameterCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/TemplateParameter.gif";
	}

	protected String text(TypeRefCS ele) {
		StringBuffer s = new StringBuffer();
		appendType(s, ele);
		return s.toString();
	}
}
