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

package org.eclipse.imp.preferences;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;

/**
 * Initializes IMP framework-wide preferences to reasonable default values.
 * @author rfuhrer@watson.ibm.com
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {
    private static final int DEFAULT_SOURCE_FONT_STYLE= SWT.NORMAL;
    private static final int DEFAULT_SOURCE_FONT_HEIGHT= (Platform.getOS().equals("macosx")) ? 11 : 10;
    private static String[] sSourceFontNames= { "Monaco", "Courier New", "Monospace", "Courier" }; // try each of these in turn

    public void initializeDefaultPreferences() {
        if (Display.getCurrent() == null) {
        	// This isn't the UI thread, so schedule a job to do the initialization later.
        	UIJob job= new UIJob("IMP Preference Initializer") {
				@Override
				public IStatus runInUIThread(IProgressMonitor monitor) {
					if (Display.getCurrent() != null) { // this should never be false, but let's be safe
						new PreferenceInitializer().initializeDefaultPreferences();
					}
					return Status.OK_STATUS;
				}
			};
			job.schedule(0);
			return;
        }
        IPreferenceStore store= RuntimePlugin.getInstance().getPreferenceStore();
        FontData fontData= findSuitableFont();

        if (fontData != null) {
//          System.out.println("Using font " + fontData.getName() + " at height " + fontData.getHeight());
            PreferenceConverter.setDefault(store, PreferenceConstants.P_SOURCE_FONT, new FontData[] { fontData });
        }

        store.setDefault(PreferenceConstants.P_EMIT_MESSAGES, false);
        store.setDefault(PreferenceConstants.P_EMIT_BUILDER_DIAGNOSTICS, false);
        store.setDefault(PreferenceConstants.P_TAB_WIDTH, 8);
        store.setDefault(PreferenceConstants.P_SPACES_FOR_TABS, false);
        store.setDefault(PreferenceConstants.P_DUMP_TOKENS, false);
        store.setDefault(PreferenceConstants.EDITOR_MATCHING_BRACKETS, true);

        store.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH, 4);
        store.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SPACES_FOR_TABS, false);

        String colorKey= RuntimePlugin.IMP_RUNTIME + "." + PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR;
        ColorRegistry registry= null;
        
        if (PlatformUI.isWorkbenchRunning()) {
            registry= PlatformUI.getWorkbench().getThemeManager().getCurrentTheme().getColorRegistry();
        }
        PreferenceConverter.setDefault(store, PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR,
                    findRGB(registry, colorKey, new RGB(192, 192, 192)));
    }

    private FontData findSuitableFont() {
        FontData fontData= null;
        Display display= getDisplay();
        FontData[] scalableFonts= display.getFontList(null, true);

        fontData= searchFontList(scalableFonts, true);
        if (fontData == null) {
            FontData[] fixedWidthFonts= display.getFontList(null, false);
            fontData= searchFontList(fixedWidthFonts, false);
        }
        return fontData;
    }

    private FontData searchFontList(FontData[] fonts, boolean scalable) {
        FontData fontData= null;

        for(String fn: sSourceFontNames) {
//          System.out.println("*** Looking for font in family " + fn);
            for(FontData fd: fonts) {
//              System.out.println("Found a " + (scalable ? "scalable" : "non-scalable") + " font: " + fd.getName() + " with height " + fd.getHeight());
                if (fd.getName().equals(fn) && fd.getStyle() == DEFAULT_SOURCE_FONT_STYLE) {
//                	System.out.println(" *** Font family and style matches! ***");
                	if (fd.getHeight() != DEFAULT_SOURCE_FONT_HEIGHT) {
                		if (scalable) {
                			// RMF 2 Apr 2010: Oddly, at least on Windows, if you set the height of
                			// the FontData returned by getFontList(), the result looks very different
                			// than if you create a new FontData with the desired height.
//                			fd.setHeight(DEFAULT_SOURCE_FONT_HEIGHT);
                		} else {
//                        	System.out.println(" xxx Wrong font size, and font isn't scalable! xxx");
                			continue;
                		}
                	}
                    fontData= new FontData(fd.getName(), DEFAULT_SOURCE_FONT_HEIGHT, fd.getStyle());
                    break;
                }
            }
            if (fontData != null) {
                break;
            }
        }
        return fontData;
    }

    private Display getDisplay() {
        Display display= Display.getCurrent();
        // Don't call Display.getDefault() - that could cause this thread to become
        // the UI thread, which can cause other UI resource accesses to fail.
//        if (display == null) {
//            display = Display.getDefault();
//        }
        return display;
    }

    /**
     * Returns the RGB for the given key in the given color registry.
     * 
     * @param registry the color registry
     * @param key the key for the constant in the registry
     * @param defaultRGB the default RGB if no entry is found
     * @return RGB the RGB
     */
    private static RGB findRGB(ColorRegistry registry, String key, RGB defaultRGB) {
        if (registry == null)
            return defaultRGB;

        RGB rgb= registry.getRGB(key);
        if (rgb != null)
            return rgb;

        return defaultRGB;
    }
}
