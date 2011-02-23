/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.impl;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin.EclipsePlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.osgi.framework.BundleContext;

public class ImpactAnalyzerPlugin extends EclipsePlugin {
    private static ImpactAnalyzerPlugin plugin;

    public static final String DEBUG = getPluginId() + "/debug"; //$NON-NLS-1$

    public static final String EXCEPTIONS_CATCHING = DEBUG + "/exceptions/catching"; //$NON-NLS-1$

    public static final String EMPTY_STRING = ""; //$NON-NLS-1$

    private static final String SEPARATOR_SPACE = " "; //$NON-NLS-1$

    private static final String PARENTHESIS_OPEN = "("; //$NON-NLS-1$

    private static final String PARENTHESIS_CLOSE = ")"; //$NON-NLS-1$

    private static final String SEPARATOR_METHOD = "#"; //$NON-NLS-1$

    private static final String PREFIX_CATCHING = "CAUGHT "; //$NON-NLS-1$

    public static final int IGNORED_EXCEPTION_WARNING = 10;

    /**
     * In stand-alone use, whether all tracing is turned on. This is compatible with the usage of 1.2 and earlier.
     * 
     * @since 1.3
     */
    private static boolean traceAll = Boolean.getBoolean("org.eclipse.ocl.examples.impactanalyzer.debug"); //$NON-NLS-1$;

    /**
     * Initializes me with my Eclipse plug-in descriptor.
     */
    public ImpactAnalyzerPlugin() {
        super();
        // Remember the static instance.
        plugin = this;
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
    }

    public static ImpactAnalyzerPlugin getPlugin() {
        return plugin;
    }

    public static String getPluginId() {
        return (getPlugin() != null) ? getPlugin().getBundle().getSymbolicName() : "de.hpi.sam.bp2009.solution.impactAnalyzer"; // last known bundle ID //$NON-NLS-1$
    }

    public static void log(int severity, int code, String message, Throwable throwable) {
        //
        // Status ctor requires a non-null message
        String msg = message == null ? "" //$NON-NLS-1$
                : message;

        try {
            if (getPlugin() != null) {
                // Eclipse environment
                getPlugin().log(new Status(severity, getPluginId(), code, msg, throwable));
            } else {
                // not in the Eclipse environment
                if (shouldTrace(DEBUG)) {
                    switch (code) {
                    case Diagnostic.WARNING:
                        System.err.print("WARNING "); //$NON-NLS-1$
                        break;
                    case Diagnostic.ERROR:
                    case Diagnostic.CANCEL:
                        System.err.print("ERROR "); //$NON-NLS-1$
                        break;
                    default:
                        // don't output INFO or OK messages
                        return;
                    }

                    System.err.print(code);
                    System.err.print(": "); //$NON-NLS-1$
                    System.err.println(message);

                    if (throwable != null) {
                        throwable.printStackTrace(System.err);
                    }
                }
            }
        } catch (IllegalArgumentException iae) {
            catching(ImpactAnalyzerPlugin.class, "log", iae);//$NON-NLS-1$
        }
    }

    /**
     * Traces the catching of the specified throwable in the specified method of the specified class.
     * 
     * @param clazz
     *            The class in which the throwable is being caught.
     * @param methodName
     *            The name of the method in which the throwable is being caught.
     * @param throwable
     *            The throwable that is being caught.
     * 
     */
    public static void catching(Class<?> clazz, String methodName, Throwable throwable) {
        if (shouldTrace(EXCEPTIONS_CATCHING)) {
            trace(PREFIX_CATCHING + throwable.getMessage() + SEPARATOR_SPACE + PARENTHESIS_OPEN + clazz.getName()
                    + SEPARATOR_METHOD + methodName + PARENTHESIS_CLOSE);
            throwable.printStackTrace(System.err);
        }
    }

    public static boolean shouldTrace(String option) {
        if (getPlugin() != null) {
            if (getPlugin().isDebugging()) {
                return Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(option));
            }

            return false;
        }

        return traceAll || Boolean.getBoolean(option);
    }

    /**
     * Emits the specified message to the trace log. It is the caller's responsibility to ensure that the appropriate tracing
     * option is enabled.
     * 
     * @param message
     *            a message
     * 
     * @see #shouldTrace(String)
     */
    public static void trace(String message) {
        System.out.println("[OCL] " + message); //$NON-NLS-1$
    }
}
