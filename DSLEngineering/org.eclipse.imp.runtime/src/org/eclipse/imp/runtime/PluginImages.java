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

package org.eclipse.imp.runtime;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.osgi.framework.Bundle;

public class PluginImages {
    // The plug-in registry
    private static ImageRegistry fgImageRegistry= null;

    private static Map<String,ImageDescriptor> fgAvoidSWTErrorMap= null;

    public static final IPath ICONS_PATH= new Path("/icons"); //$NON-NLS-1$

    private static final String NAME_PREFIX= ""; //$NON-NLS-1$
    private static final int NAME_PREFIX_LENGTH= NAME_PREFIX.length();

    public static final String VIEW_MENU_IMAGE= NAME_PREFIX + "view_menu.gif"; //$NON-NLS-1$

    public static final ImageDescriptor viewMenuImageDesc= createManaged(NAME_PREFIX, VIEW_MENU_IMAGE);

    public static final String FILE_IMAGE= NAME_PREFIX + "file.gif"; //$NON-NLS-1$

    public static final ImageDescriptor fileImageDesc= createManaged(NAME_PREFIX, FILE_IMAGE);

    public static final String FOLDER_IMAGE= NAME_PREFIX + "folder.gif"; //$NON-NLS-1$

    public static final ImageDescriptor folderImageDesc= createManaged(NAME_PREFIX, FOLDER_IMAGE);

    public static final String PROJECT_IMAGE= NAME_PREFIX + "project.gif"; //$NON-NLS-1$

    public static final ImageDescriptor projectImageDesc= createManaged(NAME_PREFIX, PROJECT_IMAGE);

    public static final ImageDescriptor DESC_OVR_WARNING= createUnManagedCached(NAME_PREFIX, "warning_co.gif"); //$NON-NLS-1$

    public static final ImageDescriptor DESC_OVR_ERROR= createUnManagedCached(NAME_PREFIX, "error_co.gif"); //$NON-NLS-1$

    private static final class CachedImageDescriptor extends ImageDescriptor {
        private ImageDescriptor fDescriptor;
        private ImageData fData;

        public CachedImageDescriptor(ImageDescriptor descriptor) {
            fDescriptor = descriptor;
        }

        public ImageData getImageData() {
            if (fData == null) {
                fData= fDescriptor.getImageData();
            }
            return fData;
        }
    }

    /**
     * Returns the image managed under the given key in this registry.
     * 
     * @param key the image's key
     * @return the image managed under the given key
     */
    public static Image get(String key) {
        return getImageRegistry().get(key);
    }

    /**
     * Returns the image descriptor for the given key in this registry. Might be called in a non-UI thread.
     * 
     * @param key the image's key
     * @return the image descriptor for the given key
     */
    public static ImageDescriptor getDescriptor(String key) {
        if (fgImageRegistry == null) {
            return fgAvoidSWTErrorMap.get(key);
        }
        return getImageRegistry().getDescriptor(key);
    }

    /**
     * Sets the three image descriptors for enabled, disabled, and hovered to an action. The actions
     * are retrieved from the *tool16 folders.
     * 
     * @param action	the action
     * @param iconName	the icon name
     */
    public static void setToolImageDescriptors(IAction action, String iconName) {
        setImageDescriptors(action, "tool16", iconName); //$NON-NLS-1$
    }

    /**
     * Sets the three image descriptors for enabled, disabled, and hovered to an action. The actions
     * are retrieved from the *lcl16 folders.
     * 
     * @param action	the action
     * @param iconName	the icon name
     */
    public static void setLocalImageDescriptors(IAction action, String iconName) {
        setImageDescriptors(action, "lcl16", iconName); //$NON-NLS-1$
    }

    /*
     * Helper method to access the image registry from the JavaPlugin class.
     */
    /* package */static ImageRegistry getImageRegistry() {
        if (fgImageRegistry == null) {
            fgImageRegistry= new ImageRegistry();
            for(String key: fgAvoidSWTErrorMap.keySet()) {
                fgImageRegistry.put(key, fgAvoidSWTErrorMap.get(key));
            }
            fgAvoidSWTErrorMap= null;
        }
        return fgImageRegistry;
    }

    //---- Helper methods to access icons on the file system --------------------------------------
    private static void setImageDescriptors(IAction action, String type, String relPath) {
        ImageDescriptor id= create("d" + type, relPath, false); //$NON-NLS-1$
        if (id != null)
            action.setDisabledImageDescriptor(id);
        /*
         * id= create("c" + type, relPath, false); //$NON-NLS-1$
         * if (id != null)
         * 		action.setHoverImageDescriptor(id);
         */
        ImageDescriptor descriptor= create("e" + type, relPath); //$NON-NLS-1$
        action.setHoverImageDescriptor(descriptor);
        action.setImageDescriptor(descriptor);
    }

    private static ImageDescriptor createManaged(String prefix, String name) {
        ImageDescriptor result= create(prefix, name.substring(NAME_PREFIX_LENGTH), true);
        if (fgAvoidSWTErrorMap == null) {
            fgAvoidSWTErrorMap= new HashMap<String,ImageDescriptor>();
        }
        fgAvoidSWTErrorMap.put(name, result);
        if (fgImageRegistry != null) {
            RuntimePlugin.getInstance().writeErrorMsg("Image registry already defined"); //$NON-NLS-1$
        }
        return result;
    }

    private static ImageDescriptor createManaged(String prefix, String name, String key) {
        ImageDescriptor result= create(prefix, name.substring(NAME_PREFIX_LENGTH), true);
        if (fgAvoidSWTErrorMap == null) {
            fgAvoidSWTErrorMap= new HashMap<String,ImageDescriptor>();
        }
        fgAvoidSWTErrorMap.put(key, result);
        if (fgImageRegistry != null) {
            RuntimePlugin.getInstance().writeErrorMsg("Image registry already defined"); //$NON-NLS-1$
        }
        return result;
    }

    /*
     * Creates an image descriptor for the given prefix and name in the JDT UI bundle and let tye descriptor cache the image data.
     * If no image could be found, the 'missing image descriptor' is returned.
     */
    private static ImageDescriptor createUnManagedCached(String prefix, String name) {
        return new CachedImageDescriptor(create(prefix, name, true));
    }

    /*
     * Creates an image descriptor for the given prefix and name in the JDT UI bundle. The path can
     * contain variables like $NL$.
     * If no image could be found, <code>useMissingImageDescriptor</code> decides if either
     * the 'missing image descriptor' is returned or <code>null</code>.
     * or <code>null</code>.
     */
    private static ImageDescriptor create(String prefix, String name, boolean useMissingImageDescriptor) {
        IPath path= ICONS_PATH.append(prefix).append(name);
        return createImageDescriptor(RuntimePlugin.getInstance().getBundle(), path, useMissingImageDescriptor);
    }

    /*
     * Creates an image descriptor for the given prefix and name in the JDT UI bundle. The path can
     * contain variables like $NL$.
     * If no image could be found, the 'missing image descriptor' is returned.
     */
    private static ImageDescriptor create(String prefix, String name) {
        return create(prefix, name, true);
    }

    /*
     * Creates an image descriptor for the given path in a bundle. The path can contain variables
     * like $NL$.
     * If no image could be found, <code>useMissingImageDescriptor</code> decides if either
     * the 'missing image descriptor' is returned or <code>null</code>.
     * Added for 3.1.1.
     */
    public static ImageDescriptor createImageDescriptor(Bundle bundle, IPath path, boolean useMissingImageDescriptor) {
        URL url= FileLocator.find(bundle, path, null);
        if (url != null) {
            return ImageDescriptor.createFromURL(url);
        }
        if (useMissingImageDescriptor) {
            return ImageDescriptor.getMissingImageDescriptor();
        }
        return null;
    }
}
