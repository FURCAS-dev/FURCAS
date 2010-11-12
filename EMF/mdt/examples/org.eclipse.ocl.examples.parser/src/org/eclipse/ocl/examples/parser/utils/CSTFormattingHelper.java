/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 Eclipse Modeling Project.
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
 * $Id: CSTFormattingHelper.java,v 1.2 2010/04/08 06:26:17 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.lpg.AbstractFormattingHelper;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.PrimitiveType;

public class CSTFormattingHelper extends AbstractFormattingHelper implements EValidator.SubstitutionLabelProvider
{
	public class SortKey<T> implements Comparable<SortKey<T>>
	{
		protected final String key;
		protected final T object;
		
		public SortKey(T object) {
			this.key = formatQualifiedName(object);
			this.object = object;
		}

		public int compareTo(SortKey<T> o) {
			return key.compareTo(o.key);
		}

		public T getObject() {
			return object;
		}
	}
	
	/**
	 * Shared instance implementing the default formatting algorithms.
	 */
    public static final CSTFormattingHelper INSTANCE = new CSTFormattingHelper();
	
	@Override
	public String formatName(Object object) {
		if (object == null) {
            return formatString(null);
        } else if (object instanceof ENamedElement) {
            return formatString(((ENamedElement) object).getName());
        } else if (object instanceof EObject) {
            return formatName(((EObject) object).eClass());
        } else {
            return object.getClass().getName();
        }
	}

	@Override public String formatQualifiedName(Object object) {
		if (object instanceof CollectionType<?, ?>)
			return formatName(object);
		if (object instanceof PrimitiveType<?>)
			return formatName(object);
		if (object instanceof EObject) {
			EObject eObject = (EObject)object;
			EObject container = eObject.eContainer();
			if (container != null)
				return formatQualifiedName(container) + getSeparator() + formatName(object);
			Resource resource = eObject.eResource();
			if (resource != null) {
				String resourceName = formatResource(resource);
				if (resourceName != null)
					return resourceName + getSeparator() + formatName(object);
			}
		}
		return formatName(object);
	}

	public String formatResource(Resource resource) {
		if (resource == null)
			return "<null-resource>";
		URI uri = resource.getURI();
		if (uri == null)
			return "<null-uri>";
		String s = uri.toString();
		int i = s.lastIndexOf("/");
		return i >= 0 ? s.substring(i+1) : s;
	}

	public String getFeatureLabel(EStructuralFeature structuralFeature) {
		return formatName(structuralFeature);
	}

	public String getObjectLabel(EObject object) {
	    return formatQualifiedName(object);
	}

	public String getValueLabel(EDataType dataType, Object value) {
	    return EcoreUtil.convertToString(dataType, value);
	}
	
	/**
	 * Return a list of objects ordered by their formatQualifiedName returns.
	 * <br>
	 * This is primarily intended to impose a deterministic ordering on
	 * ambiguous matches.
	 */
	public <T> List<T> sort(Collection<T> objects) {
		List<SortKey<T>> indexes = new ArrayList<SortKey<T>>(objects.size());
		for (T object : objects)
			indexes.add(new SortKey<T>(object));
		Collections.sort(indexes);
		List<T> list = new ArrayList<T>(objects.size());
		for (SortKey<T> index : indexes)
			list.add(index.getObject());
		return list;		
	}
}
