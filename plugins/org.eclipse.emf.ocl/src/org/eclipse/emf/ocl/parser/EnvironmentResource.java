/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EnvironmentResource.java,v 1.4 2007/10/11 23:05:16 cdamus Exp $
 */

package org.eclipse.emf.ocl.parser;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.ocl.AbstractEnvironment;

/**
 * A specialized resource implementation that stores the variables in an OCL
 * {@link Environment}.  This resource can dynamically re-construct
 * {@link Variable}s on resolution of proxies in OCL expressions.
 * 
 * @deprecated This class is obsolete with the introduction of the
 * {@link org.eclipse.ocl.Environment} API and the
 * {@link AbstractEnvironment}.
 * 
 * @author Christian W. Damus (cdamus)
 */
@Deprecated
class EnvironmentResource extends ResourceImpl {
	private static final Pattern FRAGMENT_PATTERN = Pattern.compile("var:([^:]+):(.*)"); //$NON-NLS-1$
	
	public EnvironmentResource() {
		super(URI.createURI("oclenv:///")); //$NON-NLS-1$
	}
	
	@Override
    public String getURIFragment(EObject eObject) {
		if (eObject instanceof Variable) {
			Variable var = (Variable) eObject;
			
			if (var.eResource() == this) {
				StringBuffer result = new StringBuffer();
				result.append("var:").append(var.getName()); //$NON-NLS-1$
				result.append(":").append(EcoreUtil.getURI(var.getType())); //$NON-NLS-1$
				
				return result.toString();
			}
		}
		
		return super.getURIFragment(eObject);
	}
	
	@Override
    public EObject getEObject(String uriFragment) {
		Matcher m = FRAGMENT_PATTERN.matcher(uriFragment);
		
		if (m.matches()) {
			String name = m.group(1);
			String uriString = m.group(2);
			
			Variable result = getVariable(name);
			if (result == null) {
				result = ExpressionsFactory.eINSTANCE.createVariable();
				result.setName(name);
				result.setType(
					(EClassifier) getResourceSet().getEObject(
						URI.createURI(uriString), true));
				
				getContents().add(result);
			}
			
			return result;
		}
		
		return super.getEObject(uriFragment);
	}
	
	@Override
    public void load(Map options)
		throws IOException {
		
		if (!isLoaded) {
			// we are never serialized to a persistent store
			setLoaded(true);
		}
	}
	
	private Variable getVariable(String name) {
		for (Iterator iter = getContents().iterator(); iter.hasNext();) {
			Object next = iter.next();
			
			if (next instanceof Variable) {
				Variable var = (Variable) next;
				
				if (name.equals(var.getName())) {
					return var;
				}
			}
		}
		
		return null;
	}
	
	public static class Factory implements Resource.Factory {
		public Resource createResource(URI uri) {
			return new EnvironmentResource();
		}
	}
}

