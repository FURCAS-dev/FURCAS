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

package org.eclipse.imp.language;

import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.imp.core.ErrorHandler;

/**
 * API representation for org.eclipse.imp.runtime.languageDescription
 * contributor. Used by org.eclipse.imp.language.LanguageRegistry to discover and
 * manage a language registry.
 * @author Claffra
 * @author jurgen@vinju.org
 */
public class Language {
	/**
	 * Extension element attribute ID for the language ID associated with a
	 * given language descriptor.
	 */
	public static final String LANGUAGE_ID_ATTR = "language";

	private String fLanguage;

	/**
	 * Extension element attribute ID for the base language ID associated with a
	 * given language descriptor.
	 */
	public static final String DERIVED_FROM_ATTR = "derivedFrom";

	private String fDerivedFrom;

	/**
	 * Extension element attribute ID for the list of file-name extensions
	 * associated with a given language descriptor.
	 */
	public static final String EXTENSIONS_ATTR = "extensions";

	private Collection<String> fFilenameExtensions;

	/**
	 * Extension element attribute ID for the validator associated with a given
	 * language descriptor.
	 */
	public static final String VALIDATOR_ATTR = "validator";

	private LanguageValidator fValidator;

	/**
	 * Extension element attribute ID for the user-readable description of a
	 * given language descriptor.
	 */
	public static final String DESCRIPTION_ATTR = "description";

	private String fDescription;

	/**
	 * Extension element attribute ID for the optional nature ID associated with
	 * a given language descriptor.
	 */
	public static final String NATURE_ID_ATTR = "natureID";

	private String fNatureId;

	/**
	 * Extension element attribute ID for the optional list of synonyms
	 * associated with a given language descriptor.
	 */
	public static final String SYNONYMS_ATTR = "synonyms";

	private Collection<String> fSynonyms;

    /**
     * Extension element attribute ID for the optional icon associated with a
     * given language descriptor.
     */
    public static final String ICON_ATTR = "icon";

    private String fIconPath;

	/**
	 * Extension element attribute ID for the optional URL associated with a
	 * given language descriptor.
	 */
	public static final String URL_ATTR = "url";

	private String fURL;

	private String fBundleID;

	/**
	 * Creates a language from an extension point contribution
	 * 
	 * @param element the extension point contribution this language belongs to
	 */
	Language(IConfigurationElement element) {
		try {
			fLanguage = element.getAttribute(LANGUAGE_ID_ATTR);
			fNatureId = element.getAttribute(NATURE_ID_ATTR);
			fDescription = element.getAttribute(DESCRIPTION_ATTR);
			fDerivedFrom = element.getAttribute(DERIVED_FROM_ATTR);
            fIconPath = element.getAttribute(ICON_ATTR);
            fBundleID = element.getNamespaceIdentifier();
			fURL = element.getAttribute(URL_ATTR);
			fFilenameExtensions = parseList(element.getAttribute(EXTENSIONS_ATTR));
			fSynonyms = parseList(element.getAttribute(SYNONYMS_ATTR));
			fValidator = (LanguageValidator) element.createExecutableExtension(VALIDATOR_ATTR);
		} catch (CoreException e) {
			fValidator = null;
		}
	}

	public Language(String language, String natureId, String description,
			String derivedFrom, String iconPath, String url, String bundleID, String fileNameExtensions,
			String synonyms, LanguageValidator validator) {
		this.fLanguage = language;
		this.fNatureId = natureId;
		this.fDescription = description;
		this.fDerivedFrom = derivedFrom;
		this.fIconPath = iconPath;
		this.fBundleID = bundleID;
		this.fURL = url;
		this.fFilenameExtensions = parseList(fileNameExtensions);
		this.fSynonyms = parseList(synonyms);
		this.fValidator = validator;
	}

	/**
	 * Gets the canonical name for this language
	 * 
	 * @return the canonical language name
	 */
	public String getName() {
		return fLanguage;
	}

	public String getNatureID() {
		return fNatureId;
	}

	/**
	 * Gets a human-readable description of the language. Not used for
	 * discovery.
	 * 
	 * @return a description for this language
	 */
	public String getDescription() {
		return fDescription;
	}

	/**
	 * Returns the language this language is derived from. For example, HTML is
	 * derived from XML.
	 * 
	 * @return the canonical language name this language is derived from
	 */
	public String getDerivedFrom() {
		return fDerivedFrom;
	}

    /**
     * Returns the file path to the icon to be used for source files in this language
     * 
     * @return the file path to the icon for this language
     */
    public String getIconPath() {
        return fIconPath;
    }

    /**
     * @return the ID of the bundle containing the language descriptor and icon for this language
     */
    public String getBundleID() {
        return fBundleID;
    }

    /**
	 * Returns the website with more information about this language
	 * 
	 * @return something like http://www.php.org
	 */
	public String getUrl() {
		return fURL;
	}

	/**
	 * Returns whether this language supports a given file extension. If the
	 * language is "Java", hasExtension("java") yields true.
	 * 
	 * @param extension
	 *            the file extension (excluding the '.')
	 * @return
	 */
	public boolean hasExtension(String extension) {
		return fFilenameExtensions.contains(extension);
	}

	/**
	 * Returns the file extensions that are customary for this language.
	 * 
	 */
	public Collection<String> getFilenameExtensions() {
		return fFilenameExtensions;
	}

	/**
	 * Returns the synonyms for the canonical name of this language. If the
	 * language is "Pascal", its synonyms could be "PASCAL,pascal"
	 * 
	 * @return comma-separated list of synonyms
	 */
	@Deprecated public Collection<String> getSynonyms() {
		return fSynonyms;
	}

	/**
	 * A convenience method for
	 * LanguageRegistry.findLanguage(lang.getDerivedFrom()).
	 * 
	 * @return the base Language, if known to the LanguageRegistry; otherwise,
	 *         null
	 */
	public Language getBaseLanguage() {
		String baseLangName = getDerivedFrom();
		if (baseLangName != null) {
			return LanguageRegistry.findLanguage(baseLangName);
		}

		return null;
	}

	/**
	 * Returns an instance of a class that can validate a given IFile to ensure
	 * its contents is really for this language. For instance, Ant build files
	 * have extension "xml". However, when opening any XML file, possible
	 * candidates need to be consulted to verify the actual content before
	 * activating the corresponding language services.
	 * 
	 * @return the language validator instance, if declared by the contributor
	 * @return null if no validator was specified
	 */
	public LanguageValidator getValidator() {
		return fValidator;
	}

	/*
	 * Convert "cxx, cpp,hxx, hpp " into ["cxx", "cpp", "hxx", "hpp"]
	 */
	protected Collection<String> parseList(String list) {
		Collection<String> result = new ArrayList<String>();

		if (list != null) {
            StringTokenizer st = new StringTokenizer(list, ",");

			for (int n = 0; st.hasMoreElements(); n++) {
				String exten = st.nextToken().trim();

				if (exten.startsWith(".")) {
					ErrorHandler.logMessage("Ignoring leading '.' in file-name extension "
									+ exten + " for language '" + getName() + "'.", null);
					exten = exten.substring(1);
				}
				result.add(exten);
			}
		}
		return result;
	}

	public String toString() {
		return "Language[name=" + getName() + ",description="
				+ getDescription() + ",filename extensions="
				+ getFilenameExtensions() + "]";
	}
}
