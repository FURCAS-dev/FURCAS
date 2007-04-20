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
 * $Id: UMLForeignMethods.java,v 1.1 2007/04/20 22:42:59 cdamus Exp $
 */

package org.eclipse.ocl.uml.internal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.internal.parser.OCLParser;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Vertex;


/**
 * A collection of <i>Foreign Methods</i> for the UML API.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class UMLForeignMethods {
    /**
     * Not instantiable by clients.
     */
    private UMLForeignMethods() {
        super();
    }
    
    /**
     * Checks whether the specified element has the given name, accounting for
     * possibility of underscore-escaped names.
     * 
     * @param name a possibly underscore-escaped name of an element
     * @param element a named element
     * 
     * @return whether the element has this name
     */
    public static boolean isNamed(String name, NamedElement element) {
        return OCLParser.equalName(name, element.getName());
    }
    
    /**
     * Foreign method for {@link Package#getNestedPackage(String)} that accounts
     * for possibility of underscore-escaped names.
     * 
     * @param pkg a package
     * @param name a possibly underscore-escaped name of a nested package
     * 
     * @return the matching package, or <code>null</code> if none
     */
    public static Package getNestedPackage(Package pkg, String name) {
        Package result = pkg.getNestedPackage(name);
        
        if ((result == null) && OCLParser.isEscaped(name)) {
            // try the unescaped name
            result = pkg.getNestedPackage(OCLParser.unescape(name));
        }
        
        return result;
    }
    
    /**
     * Foreign method for {@link Namespace#getMember(String, boolean, EClass)}
     * that accounts for possibility of underscore-escaped names.
     * 
     * @param ns a namespace
     * @param name a possibly underscore-escaped name of a member
     * @param type the type of member to look for
     * 
     * @return the matching member, or <code>null</code> if none
     */
    public static NamedElement getMember(Namespace ns, String name, EClass type) {
        NamedElement result = ns.getMember(name, false, type);
        
        if ((result == null) && OCLParser.isEscaped(name)) {
            // try the unescaped name
            result = (Namespace) ns.getMember(OCLParser.unescape(name), false, type);
        }
        
        return result;
    }
    
    /**
     * Foreign method for {@link Region#getSubvertex(String)} that accounts for
     * possibility of underscore-escaped names.
     * 
     * @param region a region
     * @param name a possibly underscore-escaped name of a vertex
     * 
     * @return the matching vertex, or <code>null</code> if none
     */
    public static Vertex getSubvertex(Region region, String name) {
        Vertex result = region.getSubvertex(name);
        
        if ((result == null) && OCLParser.isEscaped(name)) {
            // try the unescaped name
            result = region.getSubvertex(OCLParser.unescape(name));
        }
        
        return result;
    }
}
