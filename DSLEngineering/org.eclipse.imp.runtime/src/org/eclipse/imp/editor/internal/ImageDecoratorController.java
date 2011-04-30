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
package org.eclipse.imp.editor.internal;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.imp.editor.SourceEntityImageDescriptor;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.imp.services.DecorationDescriptor;
import org.eclipse.imp.services.IEntityImageDecorator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Point;

/**
 * This class manages the language's <code>IEntityImageDecorator</code> service, if any.
 * If none is defined, this controller provides support for error/warning decorations
 * for resources.
 * @author rfuhrer@watson.ibm.com
 */
public class ImageDecoratorController {
    /**
     * Flag to render the warning decoration. Must be distinct from all language-specific
     * decoration attribute values.
     */
    public final static int WARNING= 1 << 0;
    
    /**
     * Flag to render the error decoration. Must be distinct from all language-specific
     * decoration attribute values.
     */
    public final static int ERROR= 1 << 1;

    public final static DecorationDescriptor WARNING_DECORATION= new DecorationDescriptor(WARNING, RuntimePlugin.getInstance().getBundle(), "icons/warning_co.gif", DecorationDescriptor.Quadrant.BOTTOM_LEFT);

    public final static DecorationDescriptor ERROR_DECORATION= new DecorationDescriptor(ERROR, RuntimePlugin.getInstance().getBundle(), "icons/error_co.gif", DecorationDescriptor.Quadrant.BOTTOM_LEFT);

    private final IEntityImageDecorator fDecorator;

    private final List<DecorationDescriptor> topLeftDecorations= new LinkedList<DecorationDescriptor>();
    private final List<DecorationDescriptor> topRightDecorations= new LinkedList<DecorationDescriptor>();
    private final List<DecorationDescriptor> bottomLeftDecorations= new LinkedList<DecorationDescriptor>();
    private final List<DecorationDescriptor> bottomRightDecorations= new LinkedList<DecorationDescriptor>();

    public ImageDecoratorController(Language lang) {
        fDecorator= ServiceFactory.getInstance().getEntityImageDecorator(lang);

        if (fDecorator != null) {
            DecorationDescriptor[] allDescs= fDecorator.getAllDecorations();

            for(int i= 0; i < allDescs.length; i++) {
                DecorationDescriptor desc= allDescs[i];
                if (desc.quadrant == DecorationDescriptor.Quadrant.BOTTOM_LEFT) {
                    bottomLeftDecorations.add(desc);
                } else if (desc.quadrant == DecorationDescriptor.Quadrant.BOTTOM_RIGHT) {
                    bottomRightDecorations.add(desc);
                } else if (desc.quadrant == DecorationDescriptor.Quadrant.TOP_LEFT) {
                    topLeftDecorations.add(desc);
                } else if (desc.quadrant == DecorationDescriptor.Quadrant.TOP_RIGHT) {
                    topRightDecorations.add(desc);
                }
            }
        }
        bottomRightDecorations.add(WARNING_DECORATION);
        bottomRightDecorations.add(ERROR_DECORATION);
    }

    public SourceEntityImageDescriptor getImageDescriptor(ImageDescriptor baseImage, Object entity, Point size) {
        int attrs= fDecorator.getDecorationAttributes(entity);
        return new SourceEntityImageDescriptor(baseImage, attrs, size, this);
    }

    public List<DecorationDescriptor> getBottomLeftDecorations() {
        return bottomLeftDecorations;
    }

    public List<DecorationDescriptor> getBottomRightDecorations() {
        return bottomRightDecorations;
    }

    public List<DecorationDescriptor> getTopLeftDecorations() {
        return topLeftDecorations;
    }

    public List<DecorationDescriptor> getTopRightDecorations() {
        return topRightDecorations;
    }
}
