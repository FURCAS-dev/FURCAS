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

package org.eclipse.imp.services;


import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public interface IOutlineImage {

	public String getImageRoot();
	//public static final String IMAGE_ROOT= "icons";

	public ImageDescriptor getOutlineItemDesc();
	//public static ImageDescriptor OUTLINE_ITEM_DESC= AbstractUIPlugin.imageDescriptorFromPlugin("leg", IMAGE_ROOT + "/outline_item.gif");

	public Image getOutlineItemImage();
	//public static Image OUTLINE_ITEM_IMAGE= OUTLINE_ITEM_DESC.createImage();
	
}
