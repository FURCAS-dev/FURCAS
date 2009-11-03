package com.sap.mi.fwk.ui.internal.constraints;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;

public class QuickfixManager {

	protected static final String ATT_QUICKFIX_CLASS = "quickfixClass"; //$NON-NLS-1$

	private static final String EXT_POINT = "com.sap.mi.fwk.ui.oclQuickfix"; //$NON-NLS-1$
	private static final String ATT_VIOLATION = "violationID"; //$NON-NLS-1$
	private static final String ATT_QUICKFIX = "quickfix"; //$NON-NLS-1$

	private static final Set<IConfigurationElement> EMPTY_SET = new HashSet<IConfigurationElement>();

	private static QuickfixManager INSTANCE;

	private Map<String, Set<IConfigurationElement>> quickfixMap;

	private QuickfixManager() {
		quickfixMap = new HashMap<String, Set<IConfigurationElement>>();
		init();
	}

	/**
	 * @return the instance of this class
	 */
	public static synchronized QuickfixManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new QuickfixManager();
		return INSTANCE;
	}

	/**
	 * Return true if quickfixes for a given violation id exist. Quickfixes can
	 * be registered by implementing extension point
	 * com.sap.mi.fwk.ui.oclQuickfix
	 * 
	 * @param violationID
	 *            the violoationID
	 * @return True, if quickfixes are registered, false otherwise
	 */
	public boolean hasQuickfix(String violationID) {
		return quickfixMap.containsKey(violationID);
	}

	public Set<IConfigurationElement> getQuickfixes(String violationID) {
		if (!hasQuickfix(violationID)) {
			return EMPTY_SET;
		}
		return Collections.unmodifiableSet(quickfixMap.get(violationID));
	}

	/**
	 * Fills the internal hashtable with all extension points referencing the
	 * editor registry. The editor id is taken from the extension point
	 * implementation. Another approach was to use the editor class directly so
	 * during extension point implementation a class browsing dialog could be
	 * presented. This was discarded since using the class would imply to
	 * instantiate the class in order to get the editor id which is needed to
	 * start the editor later on.
	 */
	protected void init() {

		quickfixMap.clear();
		IExtension[] extensions = Platform.getExtensionRegistry()
				.getExtensionPoint(EXT_POINT).getExtensions();
		for (IExtension ext : extensions) {
			IConfigurationElement[] elems = ext.getConfigurationElements();
			for (IConfigurationElement element : elems) {
				String violationID = element.getAttribute(ATT_VIOLATION);
				Set<IConfigurationElement> quickfixes = quickfixMap
						.get(violationID);
				if (quickfixes == null) {
					quickfixes = new HashSet<IConfigurationElement>();
					quickfixMap.put(violationID, quickfixes);
				}
				IConfigurationElement[] newQuickfixes = element
						.getChildren(ATT_QUICKFIX);
				for (IConfigurationElement element2 : newQuickfixes) {
					quickfixes.add(element2);
				}
			}
		}
	}
}
