/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: UMLFormattingHelper.java,v 1.1 2007/12/03 18:44:36 cdamus Exp $
 */

package org.eclipse.ocl.uml;

import java.util.Collections;
import java.util.List;

import org.eclipse.ocl.lpg.AbstractFormattingHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;


/**
 * Object formatting helper for the UML metamodel.
 * 
 * @author Christian W. Damus (cdamus)
 */
class UMLFormattingHelper
    extends AbstractFormattingHelper {

    /**
     * Shared instance for UML metamodel.
     */
    public static final UMLFormattingHelper INSTANCE = new UMLFormattingHelper();

    /**
     * Initializes me.
     */
    protected UMLFormattingHelper() {
        super();
    }

    @Override
    public String formatName(Object object) {
        if (object instanceof Element) {
            String name = null;
            
            if (object instanceof NamedElement) {
                name = ((NamedElement) object).getName();
            }
            
            if (name == null) {
                name = "<" + formatEClassName((Element) object) + ">"; //$NON-NLS-1$ //$NON-NLS-2$
            }
            
            return formatString(name);
        }
        
        return super.formatName(object);
    }
    
    /**
     * Obtains the name of the separator between namespaces in a qualified name.
     * The default separator is <tt>"::"</tt>.
     * 
     * @return the namespace separator
     */
    @Override
    protected String getSeparator() {
        return "::"; //$NON-NLS-1$
    }
    
    @Override
    public String formatQualifiedName(Object object) {
        if (object instanceof NamedElement) {
            NamedElement named = (NamedElement) object;
            String qualifiedName = named.getQualifiedName();
            
            if (qualifiedName != null) {
                return formatString(qualifiedName);
            }
            
            // construct a path
            List<String> path = new java.util.ArrayList<String>();
            for (Element element = named; element != null; element = element.getOwner()) {
                path.add(formatName(element));
            }
            
            Collections.reverse(path);
            return formatPath(path);
        }
        
        return super.formatQualifiedName(object);
    }

    @Override
    public String formatPath(List<String> pathName, String name) {
        StringBuffer s = new StringBuffer();
        
        if (pathName != null) {
            int iMax = pathName.size();
            for (int i = 0; i < iMax; i++) {
                s.append(formatString(pathName.get(i)));
                s.append(getSeparator());
            }
        }
        
        s.append(formatString(name));
        
        return s.toString();
    }
}
