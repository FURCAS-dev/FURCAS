/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: NavigatorLabelProvider.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline;

import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Messages;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * This Label Provider displays informations about model and diagrams. For the
 * model, this provider delegates informations computing to the model label
 * provider. <br>
 * creation : 7 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class NavigatorLabelProvider extends LabelProvider implements IFontProvider {

    private Font boldFont = null;
    
	/** The delegated model label provider */
	private ILabelProvider delegatedModelProvider;

	/**
	 * Constructor
	 * 
	 * @param delegatedProvider
	 *            the delegated label provider of the model
	 */
	public NavigatorLabelProvider(ILabelProvider delegatedProvider) {
		delegatedModelProvider = delegatedProvider;
	}

	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		if (element instanceof Diagram) {
			Diagram diag = (Diagram) element;

			return getDiagramIcon(diag);
		}

		return delegatedModelProvider.getImage(element);
	}

	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		if (element instanceof AdditionalResources) {
			return Messages.NavigatorLabelProvider_AdditionalResources;
		}
		if (element instanceof Diagram) {
			Diagram diag = (Diagram) element;

			return getDiagramText(diag);
		}

		return delegatedModelProvider.getText(element);
	}

	/**
	 * Compose the diagram label
	 * 
	 * @param d
	 *            the diagram
	 * @return the diagram label
	 */
	private String getDiagramText(Diagram d) {
		String name = d.getName();
		String id = d.getType();
		String diagramTypeName = Messages.NavigatorLabelProvider_DiagramDefaultName;
		if (id != null && !"".equals(id)) { //$NON-NLS-1$
			// TODO Change This !
			// DiagramDescriptor diagDesc =
			// DiagramsManager.getInstance().find(id);
			// if (diagDesc != null)
			// {
			// diagramTypeName = diagDesc.getName();
			// }
		}

		return name == null || name.length() == 0 ? diagramTypeName : diagramTypeName + " " + name; //$NON-NLS-1$
	}

	/**
	 * Get the diagram icon
	 * 
	 * @param d
	 *            the diagram
	 * @return the diagram label
	 */
	private Image getDiagramIcon(Diagram d) {
		String id = d.getType();
		if (id != null && !"".equals(id)) { //$NON-NLS-1$
			// TODO Change This !
			// DiagramDescriptor diagDesc =
			// DiagramsManager.getInstance().find(id);
			// if (diagDesc != null)
			// {
			// Image icon = diagDesc.getIcon();
			// if (icon != null)
			// {
			// return icon;
			// }
			// }
		}

		return delegatedModelProvider.getImage(d);
	}
	
    /**
     * @see org.eclipse.jface.viewers.IFontProvider#getFont(java.lang.Object)
     */
    public Font getFont(Object element)
    {
        if (element instanceof Diagram)
        {
            if (boldFont == null)
            {
                Font originalFont = Display.getDefault().getSystemFont();
                FontData[] fontData = originalFont.getFontData();
                // Adding the bold attribute
                for (int i = 0; i < fontData.length; i++)
                {
                    fontData[i].setStyle(fontData[i].getStyle() | SWT.BOLD);
                }
                boldFont = new Font(Display.getDefault(), fontData);
            }
            return boldFont;
        }
        return null;
    }

    /**
     * @see org.eclipse.jface.viewers.LabelProvider#dispose()
     */
    public void dispose()
    {
        super.dispose();
        if (boldFont != null)
        {
            boldFont.dispose();
        }
    }
}
