/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: XMIUtils.java,v 1.2 2010/04/08 06:27:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

public class XMIUtils
{	
	public static interface IdCreator
	{
		/**
		 * Create the id for eObject avoiding any ids in knownIds, which may be null for no exclusions.
		 * 
		 * @param eObject
		 * @param knownIds
		 * @return
		 */
		public String createId(EObject eObject, Set<String> knownIds);
	}
	
	/**
	 * Create xmi:id's comprising a unique universal identifier
	 */
	public static class UUIDCreator implements IdCreator
	{
		public String createId(EObject eObject, Set<String> knownIds) {
			while (true) {
				String uuid = EcoreUtil.generateUUID();
                if ((knownIds == null) || !knownIds.contains(uuid))
                	return uuid;
			}
		}
	}
	
	/**
	 * Create short xmi:id's comprising a prefix and a small random count
	 */
	public static class ShortPrefixedIdCreator implements IdCreator
	{
		protected final String prefix;
		
		public ShortPrefixedIdCreator(String prefix) {
			this.prefix = prefix;
		}

		public String createId(EObject eObject, Set<String> knownIds) {
			int knownSize = knownIds != null ? knownIds.size() : 1;
	        for (int multiplier = Math.max(10, 10 * knownSize); true; multiplier *= 10) {
                for (int tries = 0; tries < 10; tries++) {
                	String id = prefix + (int)(Math.random() * multiplier);
                    if ((knownIds == null) || !knownIds.contains(id))
                    	return id;
                 }
            }
		}
	}
	
	/**
	 * Create short xmi:id's comprising a prefix and a linearly increasing count
	 */
	public static class LinearPrefixedIdCreator implements IdCreator
	{
		protected final String prefix;
		private int next;
		
		public LinearPrefixedIdCreator(String prefix) {
			this.prefix = prefix;
		}

		public String createId(EObject eObject, Set<String> knownIds) {
			while (true) {
                String id = prefix + ++next;
                if ((knownIds == null) || !knownIds.contains(id))
                    return id;
            }
		}
	}
	
	/**
	 * Create xmi:id's using the same hierarchical/URI fragment algorithm as EMOFResourceImpl
	 */
	public static class HierachicalENamedElementIdCreator implements IdCreator
	{
		public HierachicalENamedElementIdCreator() {}

		public String createId(EObject eObject, Set<String> knownIds) {
		    List<String> uriFragmentPath = new ArrayList<String>();
		    for (EObject container = eObject.eContainer(); container != null; container = eObject.eContainer()) {
		    	uriFragmentPath.add(((InternalEObject)container).eURIFragmentSegment(eObject.eContainmentFeature(), eObject));
		    	eObject = container;
		    }
		    StringBuffer result;
		    if (eObject instanceof ENamedElement)
		    	result = new StringBuffer(((ENamedElement)eObject).getName());
		    else
		    	result = new StringBuffer("_" + Integer.toString(eObject.eResource().getContents().indexOf(eObject)));
		    for (ListIterator<String> i = uriFragmentPath.listIterator(uriFragmentPath.size()); i.hasPrevious(); ) {
		    	result.append('.');
		    	result.append(i.previous());
		    }
		    return result.toString();
		}
	}
	
	public static interface IdFilter
	{
		public boolean createId(EObject eObject);
	}
	
	public static class ExcludedEClassIdFilter implements IdFilter
	{
		protected final Set<EClass> excludedClasses;
		
		public ExcludedEClassIdFilter(EClass[] excludedClasses) {
			this.excludedClasses = new HashSet<EClass>();
			for (EClass excludedClass : excludedClasses)
				this.excludedClasses.add(excludedClass);
		}
		
		public ExcludedEClassIdFilter(Set<EClass> excludedClasses) {
			this.excludedClasses = excludedClasses;
		}

		public boolean createId(EObject eObject) {
			EClass eClass = eObject.eClass();
			for (EClass excludedClass : excludedClasses)
				if (excludedClass.isSuperTypeOf(eClass))
					return false;
            return true;
		}
	}
		
	public static final UUIDCreator uuidCreator = new UUIDCreator();
	
	/**
	 * Assign an xmi:id to all objects in resource. A non-null idFilter may choose whether an xmi:id
	 * is assigned. The idCreator is responsible for providing a candidate xmi:id, which, if not unique
	 * will be suffixed until it is.
	 * 
	 * @param resource
	 * @param idCreator
	 * @param idFilter
	 */
	public static void assignIds(Resource resource, IdCreator idCreator, IdFilter idFilter) {
	    if (!(resource instanceof XMLResource))
	    	return;
	    XMLResource xmlResource = (XMLResource) resource;
       final Set<String> knownIds = new HashSet<String>(256);  // The XMLResource.getEObjectToIDMap() method is deprecated
                                                                // and the replacement slow since we need a total traversal
        final List<EObject> idLess = new ArrayList<EObject>(100);
        for (TreeIterator<EObject> iterator = resource.getAllContents(); iterator.hasNext(); ) {
            EObject eObject = iterator.next();
            String id = xmlResource.getID(eObject);
            if (id != null) {
            	knownIds.add(id);
//    	        if (eObject instanceof ENamedElement)
//    	        	System.out.println(id + " ==> " + eObject.eClass().getName() + "." + ((ENamedElement) eObject).getName());
//    	        else
//    	        	System.out.println(id + " ==> " + eObject.eClass().getName());
            }
            else if ((idFilter == null) || idFilter.createId(eObject))
                idLess.add(eObject);
        }
        for (EObject eObject : idLess) {
            String id = idCreator.createId(eObject, knownIds);
            if (id != null) {
            	String uniqueId = id;
    		    for (int i = 1; knownIds.contains(uniqueId); i++)
    		    	uniqueId = id + '_' + i;
    		    xmlResource.setID(eObject, uniqueId);
            	knownIds.add(uniqueId);
//    	        if (eObject instanceof ENamedElement)
//    	        	System.out.println(uniqueId + " --> " + eObject.eClass().getName() + "." + ((ENamedElement) eObject).getName());
//    	        else
//    	        	System.out.println(uniqueId + " --> " + eObject.eClass().getName());
            }
        }
    }

	public static void assignIds(Resource resource, String xmiIdPrefix) {
		if (xmiIdPrefix == null)
	        xmiIdPrefix = "_";
	    assignIds(resource,
	    		new ShortPrefixedIdCreator(xmiIdPrefix),
	    		new ExcludedEClassIdFilter(new EClass[]
	    		{
	    				XMLTypePackage.Literals.ANY_TYPE,
	    				EcorePackage.Literals.EGENERIC_TYPE/*,
	    				EcorePackage.Literals.EANNOTATION,
	    				EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY */
	    		}));
	}

	public static void assignLinearIds(Resource resource, String xmiIdPrefix) {
		if (xmiIdPrefix == null)
	        xmiIdPrefix = "_";
	    assignIds(resource,
	    		new LinearPrefixedIdCreator(xmiIdPrefix),
	    		new ExcludedEClassIdFilter(new EClass[]
	    		{
	    				XMLTypePackage.Literals.ANY_TYPE,
	    				EcorePackage.Literals.EGENERIC_TYPE/*,
	    				EcorePackage.Literals.EANNOTATION,
	    				EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY */
	    		}));
	}
}

