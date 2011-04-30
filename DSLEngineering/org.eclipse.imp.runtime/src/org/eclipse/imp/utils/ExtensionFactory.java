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

package org.eclipse.imp.utils;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.osgi.framework.Bundle;

/*
 * Licensed Materials - Property of IBM, (c) Copyright IBM Corp. 2005 All Rights
 * Reserved
 */

/**
 * @author Claffra
 * @author rfuhrer@watson.ibm.com
 * @author jurgen@vinju.org
 */
public class ExtensionFactory {
    
    /**
     * Locate the first extension that matches this language and extension point id,
     * and load the class that implements it and return a handle to an object of that class.
     * 
     * @param language
     * @param extensionPointID
     * @return
     * @throws ExtensionException
     */
    public static ILanguageService createServiceExtension(Language language,
            String extensionPointID) throws ExtensionException {
        return createServiceExtensionForPlugin(language, RuntimePlugin.IMP_RUNTIME,
                extensionPointID);
    }

    /**
     * Locate all extensions that match the language and extension point id, load their
     * classes and collect handles to objects of that class in a set.
     * @param language
     * @param extensionPointID
     * @return
     * @throws ExtensionException
     */
    public static Set<ILanguageService> createServiceExtensionSet(Language language,
            String extensionPointID) throws ExtensionException {
        return createServiceExtensionSetForPlugin(language, RuntimePlugin.IMP_RUNTIME,
                extensionPointID);
    }

    /**
     * Find a language name in a language descriptor extension.
     * 
     * @param pluginID
     * @return
     */
    public static String retrieveLanguageIdFromPlugin(String pluginID) {
        IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
                .getExtensionPoint(RuntimePlugin.IMP_RUNTIME,
                        RuntimePlugin.LANGUAGE_DESCRIPTOR);
        IConfigurationElement[] configElements = extensionPoint
                .getConfigurationElements();

        for (int i = 0; i < configElements.length; i++) {
            IContributor contrib = configElements[i].getContributor();

            if (contrib.getName().equals(pluginID)) {
                return configElements[i]
                        .getAttribute(Language.LANGUAGE_ID_ATTR);
            }
        }

        return null;
    }

    /**
     * Locate the first extension that matches this language, plugin, and extension point id,
     * then load a class from the element named 'elementName', and return a handle to an
     * object of this class.
     * 
     * @param language
     * @param pluginID
     * @param extensionPointId
     * @param elementName
     * @return
     * @throws ExtensionException
     */
    public static ILanguageService createServiceExtensionForPlugin(
            Language language, String pluginID, String extensionPointId,
            String elementName) throws ExtensionException {
        IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
                .getExtensionPoint(pluginID, extensionPointId);

        if (extensionPoint == null) {
            throw new ExtensionException(
                    "No such language service extension point defined: "
                            + pluginID + "." + extensionPointId);
        }

        ILanguageService service = getLanguageServiceForElement(
                extensionPoint, language.getName(), elementName);

        if (service == null && languageIsDerived(language)) {
            service = createServiceExtensionForPlugin(LanguageRegistry
                    .findLanguage(language.getDerivedFrom()), pluginID,
                    extensionPointId, elementName);
        }

        return service;
    }

    /**
     * Determine whether a language was declared to be derived from another language,
     * and whether this other language actually is registered.
     * @param language
     * @return
     */
    private static boolean languageIsDerived(Language language) {
        final boolean hasParent = language.getDerivedFrom() != null
                && LanguageRegistry.findLanguage(language.getDerivedFrom()) != null;
        return hasParent;
    }

    /**
     * Finds the first extension that matches this language, plugin and extension point id,
     * and then loads the class that implements this extension and returns a handle to it.
     * 
     * @param language
     * @param pluginID
     * @param extensionPointId
     * @return
     * @throws ExtensionException
     */
    public static ILanguageService createServiceExtensionForPlugin(Language language,
            String pluginID, String extensionPointId) throws ExtensionException {
        return createServiceExtensionForPlugin(language, pluginID,
                extensionPointId, "class");
    }

    /**
     * Find all extensions that match this pluginId, language and extension point id,
     * then loads the classes that implement these extensions and returns them as 
     * a set of ILanguageServices.
     * 
     * @param language
     * @param pluginID
     * @param extensionPointId
     * @return
     * @throws ExtensionException
     */
    public static Set<ILanguageService> createServiceExtensionSetForPlugin(Language language,
            String pluginID, String extensionPointId) throws ExtensionException {
        IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
                .getExtensionPoint(pluginID, extensionPointId);

        if (extensionPoint == null) {
            throw new ExtensionException(
                    "No such language service extension point defined: "
                            + pluginID + "." + extensionPointId);
        }

        Set<ILanguageService> services = getLanguageServiceSet(
                extensionPoint, language.getName());

        if (services.isEmpty() && languageIsDerived(language)) {
            final ILanguageService baseServiceImpl = createServiceExtensionForPlugin(
                    LanguageRegistry.findLanguage(language.getDerivedFrom()),
                    pluginID, extensionPointId);
            if (baseServiceImpl != null) {
                services.add(baseServiceImpl);
            }
        }

        return services;
    }

    /**
     * detect whether a certain plugin defines a certain extension for a certain language
     * @param pluginID
     * @param extensionPointID
     * @param language
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean languageServiceExists(String pluginID,
            String extensionPointID, Language language) {
        if (language == null)
            return false;

        IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
                .getExtensionPoint(pluginID, extensionPointID);
        IConfigurationElement[] elements = extensionPoint
                .getConfigurationElements();
        String lowerLang = language.getName().toLowerCase();

        if (elements != null) {
            for (int n = 0; n < elements.length; n++) {
                IConfigurationElement element = elements[n];
                Bundle bundle = Platform.getBundle(element
                        .getDeclaringExtension().getNamespace());

                if (bundle != null) {
                    final String attrValue = element
                            .getAttribute(Language.LANGUAGE_ID_ATTR);

                    if (attrValue != null
                            && lowerLang.equals(attrValue.toLowerCase())) {
                        return true;
                    }
                }
            }
        }

        if (languageIsDerived(language)) {
            return languageServiceExists(pluginID, extensionPointID,
                    LanguageRegistry.findLanguage(language.getDerivedFrom()));
        }

        return false;
    }

    /**
     * Locates all elements that match the language and the particular extension point id,
     * and returns a set of loaded ILanguageServices using these elements.
     * @param extensionPoint
     * @param language
     * @return
     * @throws ExtensionException
     */
    private static Set<ILanguageService> getLanguageServiceSet(
            IExtensionPoint extensionPoint, String language)
            throws ExtensionException {
        IConfigurationElement[] elements = extensionPoint
                .getConfigurationElements();
        Set<ILanguageService> result = new HashSet<ILanguageService>();

        if (elements != null) {
            for (int n = 0; n < elements.length; n++) {
                IConfigurationElement element = elements[n];
                ILanguageService service = loadLanguageService(extensionPoint, language, "class", element);
                
                if (service != null) {
                    result.add(service);
                }
            }
        }

        return result;
    }

    /**
     * Locates the first element that matches the language and the elementName, 
     * and tries to load a language service from it.
     * 
     * @param extensionPoint
     * @param language
     * @param elementName
     * @return
     * @throws ExtensionException
     */
    private static ILanguageService getLanguageServiceForElement(
            IExtensionPoint extensionPoint, String language, String elementName)
            throws ExtensionException {
        IConfigurationElement[] elements = extensionPoint
                .getConfigurationElements();
       
        if (elements != null) {
            for (int n = 0; n < elements.length; n++) {
                IConfigurationElement element = elements[n];
                ILanguageService service = loadLanguageService(extensionPoint, language, elementName, element);
                if (service != null) {
                    return service;
                }
            }
        }

        return null;
    }

    /**
     * Convenience method for actually creating an object from an element in an
     * extension point. Catches common exceptions that may be thrown and tries to
     * translate them into ServiceExceptions.
     * 
     * @param extensionPoint
     * @param language
     * @param elementName
     * @param element
     * @return
     * @throws ExtensionException
     */
    private static ILanguageService loadLanguageService(IExtensionPoint extensionPoint, String language, String elementName, IConfigurationElement element) throws ExtensionException {
        Bundle bundle = Platform.getBundle(element.getDeclaringExtension().getContributor().getName());
//        Bundle bundle = Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier());
        
        String lowerLang = language.toLowerCase();

        if (bundle != null) {
            final String attrValue = element.getAttribute(Language.LANGUAGE_ID_ATTR);

            if (attrValue != null && lowerLang.equals(attrValue.toLowerCase())) {
                try {
                    return (ILanguageService) element.createExecutableExtension(elementName);
                } catch (ClassCastException e) {
                    logException(new ExtensionException(
                            "Extension does not point to a class that implements an ILanguageService:"
                                    + element, e));
                } catch (IncompatibleClassChangeError e) {
                    logException(new ExtensionException("Unable to instantiate implementation of "
                            + extensionPoint.getLabel()
                            + " plugin for language '"
                            + language
                            + "' because some class in the plugin is incompatible (out-of-date)", e));
                } catch (CoreException e) {
                    logException(new ExtensionException(
                            "Unable to instantiate implementation of "
                                    + extensionPoint.getLabel()
                                    + " plugin for language '"
                                    + language
                                    + "' because of the following low level exception: "
                                    + e.getStatus().getException(), e));
                } catch (NoClassDefFoundError e) {
                    logException(new ExtensionException(
                            "Unable to instantiate implementation of "
                                    + extensionPoint.getLabel()
                                    + " plugin for language '"
                                    + language
                                    + "' because it may not have a public zero argument constructor, or some class referenced by the plugin could not be found in the class path.",
                            e));
                }
            }
        }
        
        return null;
    }

    private static void logException(ExtensionException extensionException) {
        RuntimePlugin.getInstance().logException(extensionException.getMessage(), extensionException);
    }

    /**
     * Retrieves from an extension an attribute that represents a resource URL
     * @param language language that the extension is for
     * @param extensionPoint extension point identifier
     * @param the label of the attribute that contains the resource URL
     */
    @SuppressWarnings("deprecation")
    public static URL createResourceURL(String language,
            IExtensionPoint extensionPoint, String label) {
        IConfigurationElement[] elements = extensionPoint
                .getConfigurationElements();
        String lowerLabel = label.toLowerCase();
        String lowerLang = language.toLowerCase();

        if (elements != null) {
            for (int n = 0; n < elements.length; n++) {
                IConfigurationElement element = elements[n];
                Bundle bundle = Platform.getBundle(element
                        .getDeclaringExtension().getNamespace());

                if (bundle != null) {
                    final String attrValue = element
                            .getAttribute(Language.LANGUAGE_ID_ATTR);

                    if (attrValue != null
                            && lowerLang.equals(attrValue.toLowerCase())) {
                        String resourceName = element.getAttribute(lowerLabel);
                        return bundle.getResource(resourceName);
                    }
                }
            }
        }

        return null;
    }
}
