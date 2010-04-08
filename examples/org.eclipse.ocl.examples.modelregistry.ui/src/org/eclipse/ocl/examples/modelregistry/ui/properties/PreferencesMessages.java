/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: PreferencesMessages.java,v 1.2 2010/04/08 06:25:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.ui.properties;

import org.eclipse.osgi.util.NLS;

public final class PreferencesMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.ocl.examples.modelregistry.ui.properties.PreferencesMessages";//$NON-NLS-1$

	private PreferencesMessages() {
		// Do not instantiate
	}

	public static String ModelRegistryPreferencePage_title;
	public static String ModelRegistryPreferencePage_description;
	public static String ModelRegistryConfigurationBlock_markers_tasks_add_button;
	public static String ModelRegistryConfigurationBlock_markers_tasks_remove_button;
	public static String ModelRegistryConfigurationBlock_markers_tasks_edit_button;
	public static String ModelRegistryConfigurationBlock_accessor_name_column;
	public static String ModelRegistryConfigurationBlock_platform_resource_column;
	public static String ModelRegistryConfigurationBlock_container_column;
	public static String ModelRegistryConfigurationBlock_serialization_column;
	public static String ModelRegistryConfigurationBlock_accessor_label;

	public static String RegistrationDialog_new_title;
	public static String RegistrationDialog_edit_title;
	
	public static String RegistrationDialog_error_enterName;
	public static String RegistrationDialog_error_entryExists;
	public static String RegistrationDialog_error_noSpace;
	public static String RegistrationDialog_error_enterURI;
	public static String RegistrationDialog_error_validURI;
	public static String RegistrationDialog_error_resource_exists;
	public static String RegistrationDialog_warning_no_serialization;
	
	public static String ProjectSelectionDialog_title;
	public static String ProjectSelectionDialog_desciption;
	public static String ProjectSelectionDialog_filter;
	
	public static String PropertyAndPreferencePage_useworkspacesettings_change;
	public static String PropertyAndPreferencePage_showprojectspecificsettings_label;
	public static String PropertyAndPreferencePage_useprojectsettings_label;

	static {
		NLS.initializeMessages(BUNDLE_NAME, PreferencesMessages.class);
	}
}
