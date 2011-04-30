/*******************************************************************************
* Copyright (c) 2009 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
*******************************************************************************/
package org.eclipse.imp.services;

import org.eclipse.imp.language.LanguageRegistry.BundleImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.Bundle;

public class DecorationDescriptor {
    public static enum Quadrant {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    /**
     * the integer attribute value that selects this decoration
     */
    public final int mask;

    /**
     * the bundle containing the image file for this decoration
     */
    public final Bundle bundle;

    /**
     * the Bundle-relative path to the decoration image file
     */
    public final String path;

    /**
     * the quadrant of the base icon image in which the given decoration should be displayed
     */
    public final DecorationDescriptor.Quadrant quadrant;

    private ImageDescriptor fImageDesc;

    public DecorationDescriptor(int mask, Bundle bundle, String path, DecorationDescriptor.Quadrant quadrant) {
        this.mask= mask;
        this.bundle= bundle;
        this.path= path;
        this.quadrant= quadrant;
    }

    public ImageDescriptor getImageDescriptor() {
        if (fImageDesc == null) {
            fImageDesc= new BundleImageDescriptor(path, bundle, "");
        }
        return fImageDesc;
    }
}