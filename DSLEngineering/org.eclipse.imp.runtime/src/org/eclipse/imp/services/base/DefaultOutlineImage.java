/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.services.base;

import org.eclipse.imp.services.IOutlineImage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;



public class DefaultOutlineImage implements IOutlineImage
{
	private DefaultOutlineImage() { }
	
	private static IOutlineImage image = null;
	
	public static IOutlineImage getDefaultOutlineImage() {
		if (image == null) {
			image = new DefaultOutlineImage();
		}
		return image;
	}
	

	private static final String IMAGE_ROOT= "icons";

	private static ImageDescriptor OUTLINE_ITEM_DESC= AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.imp.runtime", IMAGE_ROOT + "/outline_item.gif");

	private static Image OUTLINE_ITEM_IMAGE= OUTLINE_ITEM_DESC.createImage();

	
	public String getImageRoot() {
		return IMAGE_ROOT;
	}

	public ImageDescriptor getOutlineItemDesc() {
		return OUTLINE_ITEM_DESC;
	}

	public Image getOutlineItemImage() {
		return OUTLINE_ITEM_IMAGE;
	}

}

