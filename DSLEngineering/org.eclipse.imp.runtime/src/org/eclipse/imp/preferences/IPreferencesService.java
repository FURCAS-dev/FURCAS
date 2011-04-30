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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * This interface is for use by IMP IDE clients that wish to access preference settings.
 * This can be used both for global settings that affect all IMP-based IDEs (using the
 * pseudo-language ID "IMP"), as well as language-specific settings that apply only to
 * one particular IDE.
 * <p>Miscellaneous notes:
 * <ul>
 *   <li>Assumes that there is a "current language" that is an implicit
 *       qualifier for all preferences.
 *   <li>Assumes that there is a "current project" with respect to which
 *       project-level preferences are evaluated.
 *   <li>Does not include various features of the Eclipse PreferencesService:
 *   <ul>
 *     <li>Call site default values (deemed not useful)
 *     <li>Call site specifications of priority contexts (deemed not useful)
 *     <li>Missing "untyped" get/set operations (which work on strings)
 *   </ul>
 *   <li>Implementations may restrict the levels at which some operations
 *       are effective.
 * </ul>
 *<p>This interface is not intended to be implemented by clients.
 * @see PreferencesService
 * @author sutton
 */
public interface IPreferencesService {
	/*	
	 * Levels at which preferences are supported
	 */
	public final String PROJECT_LEVEL  		= "project";
	public final String INSTANCE_LEVEL 		= "instance";
	public final String CONFIGURATION_LEVEL	= "configuration";
	public final String DEFAULT_LEVEL		= "default";
	
	public final int PROJECT_INDEX  		= 0;
	public final int INSTANCE_INDEX 		= 1;
	public final int CONFIGURATION_INDEX	= 2;
	public final int DEFAULT_INDEX			= 3;
	
	public final static String[] levels = { PROJECT_LEVEL, INSTANCE_LEVEL, CONFIGURATION_LEVEL, DEFAULT_LEVEL };
	
	public int indexForLevel(String levelName);
	
	public boolean isaPreferencesLevel(String possibleLevel);	
	
	/*
	 * The service applies to a particular language in a
	 * particular project, both which can be set dynamically
	 */
		
	public void setLanguageName(String languageName);
	public String getLanguageName();
	
	public void setProjectName(String projectName);
	public String getProjectName();
	
	public void setProject(IProject project);
	public IProject getProject();
	

	/*
	 * Get and set preferences by batch by level
	 */
	public IEclipsePreferences getPreferences(String level);
	public void setPreferences(String level, IEclipsePreferences preferences);
	
	
	/*
	 * Get applicable preferences by type
	 * 
	 * Requests are evaluated relative to an implicit "current project"
	 * and an implicit "current language."
	 * 
	 * It is an error to request a preference when the current langauge is
	 * not defined, because all preferences are assumed to be defined relative
	 * to some language.
	 * 
	 * It is not an error to request a preference when the current project
	 * is not set.  That is because a preference may not be defined on the
	 * project level even when the project is set, and preferences are
	 * returned from the lowest level at which set in any case, so that a
	 * value can be returned from some higher level when the project is
	 * undefined. 
	 * 
	 * Preferences are returned from the lowest level at which set.  If no
	 * preference is defined for a given key at all levels, then an apporpriate
	 * default value is returned.  This is 0 for the numeric preferences,
	 * false for boolean preferences, the empty string for String preferences,
	 * and the empty array for byte[].
	 */
	public boolean getBooleanPreference(String key);
	public byte[]  getByteArrayPreference(String key);
	public double  getDoublePreference(String key);
	public float   getFloatPreference(String key);
	public int     getIntPreference(String key);
	public long    getLongPreference(String key);
	public String  getStringPreference(String key);
	public String  getRawStringPreference(String key);

	
	/*
	 * Get applicable preferences by project and type
	 * 
	 * Requests are evaluated relative to an implicit "current language."
	 * It is an error to request a preference when the current langauge is
	 * not defined, because all preferences are assumed to be defined relative
	 * to some language.
	 * 
	 * Requests are evaluated relative to a given project, regardless of
	 * whether there is a "current project" defined.
	 * 
	 * Preferences are returned from the lowest level at which set.  If no
	 * preference is defined for a given key at all levels, then an apporpriate
	 * default value is returned.  This is 0 for the numeric preferences,
	 * false for boolean preferences, the empty string for String preferences,
	 * and the empty array for byte[].
	 */
	// TODO Remove these - the prefs service should use the project that the client configured it to use
	public boolean getBooleanPreference(IProject project, String key);
	public byte[]  getByteArrayPreference(IProject project, String key);
	public double  getDoublePreference(IProject project, String key);
	public float   getFloatPreference(IProject project, String key);
	public int     getIntPreference(IProject project, String key);
	public long    getLongPreference(IProject project, String key);
	public String  getStringPreference(IProject project, String key);
	public String  getRawStringPreference(IProject project, String key);
	
	
	/*
	 * Get preferences for a given level by type
	 * 
	 * Requests are evaluated relative to an implicit "current language."
	 * It is an error to request a preference when the current langauge is
	 * not defined, because all preferences are assumed to be defined relative
	 * to some language.
	 * 
	 * Requests are evaluated relative to the given level only.
	 * If a preference for the given key is defined at that level, then
	 * the associated value is returned.  If no preferences is defined
	 * for the given key at that level, then a suitable default value
	 * is returned.  This is 0 for the numeric preferences, false for
	 * boolean preferences, the empty string for String preferences,
	 * and the empty array for byte[].
	 * 
	 * If the given level is the project level, then requests are
	 * evaluated relative to an implicit "current project."  It is
	 * an error to request a preference from the project level when
	 * no current project is defined.
	 */
	public boolean getBooleanPreference(String level, String key);
	public byte[]  getByteArrayPreference(String level, String key);
	public double  getDoublePreference(String level, String key);
	public float   getFloatPreference(String level, String key);
	public int     getIntPreference(String level, String key);
	public long    getLongPreference(String level, String key);
	public String  getStringPreference(String level, String key);
	public String  getRawStringPreference(String level, String key);
	
	
	/*
	 * Get preferences for a given project by type
	 * 
	 * Requests are evaluated relative to an implicit "current language."
	 * It is an error to request a preference when the current langauge is
	 * not defined, because all preferences are assumed to be defined relative
	 * to some language.
	 * 
	 * Requests are evaluated relative to the given project only.  If a
	 * preference for the given key is defined for that project, then the
	 * associated value is returned.  If no preferences is defined
	 * for the given key in the given project, then a suitable default value
	 * is returned.  This is 0 for the numeric preferences, false for boolean
	 * preferences, the empty string for String preferences, and the empty
	 * array for byte[].
	 */
	// TODO Remove these - the prefs svc should use the project the client configured it to use
	public boolean getBooleanPreferenceForProject(IProject project, String key);
	public byte[]  getByteArrayPreferenceForProject(IProject project, String key);
	public double  getDoublePreferenceForProject(IProject project, String key);
	public float   getFloatPreferenceForProject(IProject project, String key);
	public int     getIntPreferenceForProject(IProject project, String key);
	public long    getLongPreferenceForProject(IProject project, String key);	
	public String  getStringPreferenceForProject(IProject project, String key);
	public String  getRawStringPreferenceForProject(IProject project, String key);
	
	
	/*
	 * Set preferences for a given level by type
	 */
	public void setBooleanPreference(String level, String key, boolean value);
	public void setByteArrayPreference(String level, String key, byte[] value);
	public void setDoublePreference(String level, String key, double value);
	public void setFloatPreference(String level, String key, float value);
	public void setIntPreference(String level, String key, int value);
	public void setLongPreference(String level, String key, long value);
	public void setStringPreference(String level, String key, String value);

	
	/*
	 * Get preferences for a given level, language, and project by type
	 */
    // TODO Remove these - the prefs svc should use the language the client configured it to use
	public boolean getBooleanPreference(String languageName, String projectName, String level, String key, boolean def);
	public byte[]  getByteArrayPreference(String languageName, String projectName, String level, String key, byte[] def);
	public double  getDoublePreference(String languageName, String projectName, String level, String key, double def);
	public float   getFloatPreference(String languageName, String projectName, String level, String key, float def);
	public int     getIntPreference(String languageName, String projectName, String level, String key, int def);
	public long    getLongPreference(String languageName, String projectName, String level, String key, long def);
	public String  getStringPreference(String languageName, String projectName, String level, String key, String def);
	public String  getRawStringPreference(String languageName, String projectName, String level, String key, String def);	
	
	/*
	 * Set preferences for a given level, language, and project by type
	 */
    // TODO Remove these - the prefs svc should use the language the client configured it to use
	public void setBooleanPreference(String languageName, String projectName, String level, String key, boolean value);
	public void setByteArrayPreference(String languageName, String projectName, String level, String key, byte[] value);
	public void setDoublePreference(String languageName, String projectName, String level, String key, double value);
	public void setFloatPreference(String languageName, String projectName, String level, String key, float value);
	public void setIntPreference(String languageName, String projectName, String level, String key, int value);
	public void setLongPreference(String languageName, String projectName, String level, String key, long value);
	public void setStringPreference(String languageName, String projectName, String level, String key, String value);

    /**
     * @return the result of performing all preference substitutions on the
     * given value, which can include references of the form "${prefKey}" or
     * "${pluginLoc:pluginID}". The values of any preference references are
     * obtained in the context of the project associated with this
     * {@link IPreferencesService}, if any.
     */
    public String performSubstitutions(String value);

    /**
     * @return the result of performing all preference substitutions on the
     * given value, which can include references of the form "${prefKey}" or
     * "${pluginLoc:pluginID}". Use the given project as the context for
     * obtaining the values of referenced preferences.
     */
    public String performSubstitutions(String value, IProject project);
	
	/*
	 * Clear preferences at a given level
	 * 
	 * The first two methods operate relative to an implicit "current project."
	 * It is an error to invoke these methods for the project level when there is
	 * no currently defined project.
	 * 
	 * The second two meethods operate relative to a given project, regardless of
	 * whether a current project is set.  These are intended to address the clearing
	 * of preferences on the project level, but it is not an error (if nevertheless
	 * pointless) to use them to clear preferences on another level.
	 * 
	 * The "clear preferences" methods clear all preferences on the given level.
	 * The "clear preference" methods clear the given preference on the given
	 * level; if the preference is not defined on that level then these methods
	 * should have no effect.
	 */
	public IEclipsePreferences clearPreferencesAtLevel(String level);
	public String clearPreferenceAtLevel(String level, String key);
	public IEclipsePreferences clearPreferencesAtLevel(IProject project, String level);
	public String clearPreferenceAtLevel(IProject project, String level, String key);
	
	
	
	/*
	 * Regarding where and whether a preference is defined
	 * 
	 * The first three methods operate relative to an implicit "current project."
	 * It is an error to invoke the first two of these methods for the project level
	 * when there is no currently defined project.
	 * 
	 * The second three methods operate relative to a given project, regardless of
	 * whether a current project is set.  For those methods that take a preferences
	 * level, it is not an error (if nevertheless pointless) to invoke these methods
	 * with a levels other than the project level.
	 * 
	 * The getApplicableLevel(..) methods get the preferences level, at or above a
	 * given level, at which a preference is defined for a given key.  They return
	 * null if no such level is found.
	 * 
	 * The isDefault(..) methods indicate for a given key whether the value that
	 * applies at a given level is the default value (that is, the value associated
	 * with the given key on the default preference level).
	 * 
	 * The isDefined(..) methods indicate for a given key whether a value is defined
	 * for that key at some level.
	 */
	public String getApplicableLevel(String key, String level);
	public boolean isDefault(String key, String level);
	public boolean isDefined(String key);
	public String getApplicableLevel(IProject project, String key, String level);
	public boolean isDefault(IProject project, String key, String level);
	public boolean isDefined(IProject project, String key);
	
	
	/*
	 * Regarding contexts and nodes
	 */
	
	/**
	 * Return the preferences root node (its children are
	 * the nodes for the various preferences levels)
	 */
	public IEclipsePreferences getRootNode();
	
	/**
	 * Return the preferences node for a given preferences level.
	 * 
	 * @param level		The String name of a preferences level
	 * @return			The preferences node for that level
	 * @throws			IllegalArgumentException if level is null of
	 * 					is not a recognized preferences level name;
	 * 					IllegalStateException if level designates the
	 * 					project level and the current project is not
	 * 					defined
	 */
	public IEclipsePreferences getNodeForLevel(String level);
	
	
	/**
	 * Return the preferences node for a given project, regardless
	 * of whether this is the curently defined project.
	 * 
	 * @param project	An IProject indicating the project for which
	 * 					preferences are sought
	 * @return			The preferences node for the given project
	 * @throws			IllegalArgumentException if the given project
	 * 					is null
	 */
	public IEclipsePreferences getNodeForProject(IProject project);
	
	
	/**
	 * Return an array of preferences nodes, one for each of the
	 * four (main) preferences levels:  project, (workspace) instance,
	 * (workspace) configuration, and default.  If there is no
	 * current project defined, then the project preferences node
	 * will be null.
	 * 
	 * @return			An array of preferences nodes, in order
	 * 					from lowest (project) to highest (default)
	 */
	public IEclipsePreferences[] getNodesForLevels();
	
		
	/**
	 * Return an array of preferences nodes, one for each of the
	 * four (main) preferences levels:  project, (workspace) instance,
	 * (workspace) configuration, and default.  Use a given project
	 * 
	 * @param project
	 * @return
	 */
	public IEclipsePreferences[] getNodesForLevels(IProject project);
	public IScopeContext getScopeForLevel(String level);
	public IScopeContext getScopeForProject(IProject project);
	public int getIndexForLevel(String level);
	
	
    public abstract class PreferenceServiceListener implements IPreferenceChangeListener {
        private final String fKey;
        private final IEclipsePreferences fConfigLevel;
        private final IEclipsePreferences fWSLevel;
        private final IEclipsePreferences fProjLevel;

        PreferenceServiceListener(IPreferencesService service, String key) {
            fKey= key;
            fConfigLevel= service.getPreferences(IPreferencesService.CONFIGURATION_LEVEL);
            fWSLevel= service.getPreferences(IPreferencesService.INSTANCE_LEVEL);
            fProjLevel= service.getPreferences(IPreferencesService.PROJECT_LEVEL);

            fConfigLevel.addPreferenceChangeListener(this);
            fWSLevel.addPreferenceChangeListener(this);
            if (fProjLevel != null) {
                fProjLevel.addPreferenceChangeListener(this);
            }
        }

        public void preferenceChange(PreferenceChangeEvent event) {
            if (!event.getKey().equals(fKey))
                return;
            handleChange(event.getOldValue(), event.getNewValue());
        }

        public void dispose() {
        	// RMF Fix for bug #297603: check that the pref nodes exist before attempting to unregister
        	try {
	        	if (fConfigLevel.nodeExists("")) {
	        		fConfigLevel.removePreferenceChangeListener(this);
	        	}
	        	if (fWSLevel.nodeExists("")) {
	        		fWSLevel.removePreferenceChangeListener(this);
	        	}
	        	if (fProjLevel != null && fProjLevel.nodeExists("")) {
	        		fProjLevel.removePreferenceChangeListener(this);
	        	}
        	} catch (BackingStoreException e) {
        		RuntimePlugin.getInstance().logException(e.getMessage(), e);
        	}
        }

        protected abstract void handleChange(Object oldValue, Object newValue);
    }

    public abstract class StringPreferenceListener extends PreferenceServiceListener {
        public StringPreferenceListener(IPreferencesService service, String key) {
            super(service, key);
        }
        @Override
        protected final void handleChange(Object oldValue, Object newValue) {
            changed((String) oldValue, (String) newValue);
        }
        public abstract void changed(String oldValue, String newValue);
    }

    public abstract class BooleanPreferenceListener extends PreferenceServiceListener {
        public BooleanPreferenceListener(IPreferencesService service, String key) {
            super(service, key);
        }
        @Override
        protected final void handleChange(Object oldValue, Object newValue) {
            changed(Boolean.parseBoolean((String) oldValue), Boolean.parseBoolean((String) newValue));
        }
        public abstract void changed(boolean oldValue, boolean newValue);
    }

    public abstract class IntegerPreferenceListener extends PreferenceServiceListener {
        public IntegerPreferenceListener(IPreferencesService service, String key) {
            super(service, key);
        }
        protected final void handleChange(Object oldValue, Object newValue) {
            changed(Integer.parseInt((String) oldValue), Integer.parseInt((String) newValue));
        }
        public abstract void changed(int oldValue, int newValue);
    }

	
	/*
	 * For monitoring changes in the selected project
	 */

	public void addProjectSelectionListener(IProjectSelectionListener listener);
	public void removeProjectSelectionListener(IProjectSelectionListener listener);
	
	
	public final class ProjectSelectionEvent {	//extends EventObject {
		/**
		 * All serializable objects should have a stable serialVersionUID
		 */
		private static final long serialVersionUID = 1L;

		private Preferences previous;
		private Preferences neww;

		/**
		 * Constructor for a new node change event object.
		 * 
		 * @param parent the parent node
		 * @param child the child node
		 */
		public ProjectSelectionEvent(Preferences previous, Preferences neww) {
			//super(neww);
			this.previous = previous;
			this.neww = neww;
		}

		/**
		 * Return the preferences node for the previously selected project.
		 * May be null if there was no previously selected project.
		 * 
		 * @return the previous node
		 */
		public Preferences getPrevious() {
			return previous;
		}

		/**
		 * Return the preferences node for the newly selected project.
		 * May be null if somehow the selection is nullified.
		 * </p>
		 * @return the new node
		 */
		public Preferences getNew() {
			return neww;
		}
	}
	
	

	/**
	 * A listener to be used to receive events that signal the selection
	 * of a project as the focus for project preferences.
	 * <p>
	 * Clients may implement this interface.
	 * </p>
	 * 
	 * @since 3.0
	 */
	public interface IProjectSelectionListener {

		/**
		 * Notification that a project was selected
		 * The given event must not be <code>null</code>.
		 * 
		 * @param event an event specifying the details about the new node
		 */
		public void selection(ProjectSelectionEvent event);

	}
}
