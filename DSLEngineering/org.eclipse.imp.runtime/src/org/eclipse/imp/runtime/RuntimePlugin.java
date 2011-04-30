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

import java.io.PrintStream;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.imp.model.ISourceEntity;
import org.eclipse.imp.model.ModelFactory;
import org.eclipse.imp.model.ModelFactory.ModelException;
import org.eclipse.imp.preferences.PreferenceCache;
import org.eclipse.imp.preferences.PreferenceConstants;
import org.eclipse.imp.utils.ConsoleUtil;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The bundle activator class for the IMP runtime.
 */
public class RuntimePlugin extends PluginBase implements IStartup {
    /**
     * An IAdapterFactory implementation that adapts IResources to ISourceEntity's.
     * @author rfuhrer@watson.ibm.com
     */
    private static final class ResourceToSourceEntityAdapter implements IAdapterFactory {
        private Class[] fTypes= new Class[] { ISourceEntity.class };

        public Object getAdapter(Object adaptableObject, Class adapterType) {
            if (adaptableObject instanceof IResource && adapterType == ISourceEntity.class) {
                try {
                    return ModelFactory.open((IResource) adaptableObject);
                } catch (ModelException e) {
                    RuntimePlugin.getInstance().logException("Unable to adapt " + adaptableObject.getClass().getName() + " to " + adapterType.getName(), e);
                }
            }
            return null;
        }

        public Class[] getAdapterList() {
            return fTypes;
        }
    }

    private static final String CONSOLE_NAME= "IMP Runtime";

    public static final String IMP_RUNTIME= "org.eclipse.imp.runtime"; // must match plugin ID in MANIFEST.MF

    /**
     * The (unqualified) ID of the language descriptor extension point.
     */
    public static String LANGUAGE_DESCRIPTOR= "languageDescription";

    private FontRegistry fFontRegistry;

    private PrintStream sConsoleStream;

    // The singleton instance.
    private static RuntimePlugin sPlugin;

    private static boolean EMIT_TIMING_INFO= false;

    public static long PRE_STARTUP_TIME;

    public static long EDITOR_START_TIME;

    public RuntimePlugin() {
        sPlugin= this;
    }

    /**
     * Returns the singleton instance.
     */
    public static RuntimePlugin getInstance() {
        return sPlugin;
    }

    public String getID() {
        return IMP_RUNTIME;
    }

    @Override
    public String getLanguageID() {
        return "IMP"; // used only as a preference path prefix
    }

    public FontRegistry getFontRegistry() {
        // Hopefully this gets called late enough, i.e., after a Display has been
        // created on the current thread (see FontRegistry constructor).
        if (fFontRegistry == null) {
            fFontRegistry= new FontRegistry();
        }
        return fFontRegistry;
    }

    /**
     * This method is called upon plug-in activation
     */
    public void start(BundleContext context) throws Exception {
        PRE_STARTUP_TIME= System.currentTimeMillis();

        super.start(context);

        if (EMIT_TIMING_INFO) {
            getConsoleStream().println("Entered RuntimePlugin.start(); time is " + PRE_STARTUP_TIME);
        }

        // Initialize the Preferences fields with the preference store data.
        IPreferenceStore prefStore= getPreferenceStore();

        PreferenceCache.emitMessages= prefStore.getBoolean(PreferenceConstants.P_EMIT_MESSAGES);
        PreferenceCache.tabWidth= prefStore.getInt(PreferenceConstants.P_TAB_WIDTH);

//      PreferenceCache.sourceFont= new Font(PlatformUI.getWorkbench().getDisplay(), PreferenceConverter.getFontData(prefStore, PreferenceConstants.P_SOURCE_FONT));

        Platform.getAdapterManager().registerAdapters(new ResourceToSourceEntityAdapter(), IResource.class);
    }

    /**
     * This method is called when the plug-in is stopped
     */
    public void stop(BundleContext context) throws Exception {
        super.stop(context);
        sPlugin= null;
    }

    public PrintStream getConsoleStream() {
        if (sConsoleStream == null) {
            sConsoleStream= ConsoleUtil.findConsoleStream(CONSOLE_NAME);
        }
        return sConsoleStream;
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in relative path.
     * 
     * @param path the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(IMP_RUNTIME, path);
    }

    private ImageDescriptorRegistry fImageDescriptorRegistry;

    private synchronized ImageDescriptorRegistry internalGetImageDescriptorRegistry() {
        if (fImageDescriptorRegistry == null)
            fImageDescriptorRegistry= new ImageDescriptorRegistry();
        return fImageDescriptorRegistry;
    }

    public static ImageDescriptorRegistry getImageDescriptorRegistry() {
        return getInstance().internalGetImageDescriptorRegistry();
    }

    public void earlyStartup() {
        if (EMIT_TIMING_INFO) {
            final long curTime= System.currentTimeMillis();
            getConsoleStream().println("Entered RuntimePlugin.earlyStartup(); time is " + curTime);
        }
        LanguageRegistry.initializeRegistryAsNeeded();
    }
}
