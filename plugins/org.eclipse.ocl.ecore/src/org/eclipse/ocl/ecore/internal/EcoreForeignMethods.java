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
 * $Id: EcoreForeignMethods.java,v 1.1 2007/04/20 22:42:55 cdamus Exp $
 */

package org.eclipse.ocl.ecore.internal;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.internal.parser.OCLParser;


/**
 * A collection of <i>Foreign Methods</i> for the UML API.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class EcoreForeignMethods {
    /**
     * Not instantiable by clients.
     */
    private EcoreForeignMethods() {
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
    public static boolean isNamed(String name, ENamedElement element) {
        return OCLParser.equalName(name, element.getName());
    }
    
    /**
     * Foreign method for {@link EPackage#getEClassifier(String)}
     * that accounts for possibility of underscore-escaped names.
     * 
     * @param pkg a package
     * @param name a possibly underscore-escaped name of a nested classifier
     * 
     * @return the matching classifier, or <code>null</code> if none
     */
    public static EClassifier getEClassifier(EPackage pkg, String name) {
        EClassifier result = pkg.getEClassifier(name);
        
        if ((result == null) && OCLParser.isEscaped(name)) {
            // try the unescaped name
            result = pkg.getEClassifier(OCLParser.unescape(name));
        }
        
        return result;
    }
    
    /**
     * Foreign method for {@link EPackage#getESubpackages()} that searches by
     * name and accounts for possibility of underscore-escaped names.
     * 
     * @param pkg a package
     * @param name a possibly underscore-escaped name of a nested package
     * 
     * @return the matching sub-package, or <code>null</code> if none
     */
    public static EPackage getESubpackage(EPackage pkg, String name) {
        for (EPackage sub : pkg.getESubpackages()) {
            if (name.equals(sub.getName())) {
                return sub;
            }
        }
        
        if (OCLParser.isEscaped(name)) {
            // try the unescaped name
            name = OCLParser.unescape(name);
            
            for (EPackage sub : pkg.getESubpackages()) {
                if (name.equals(sub.getName())) {
                    return sub;
                }
            }
        }
        
        return null;
    }

}
