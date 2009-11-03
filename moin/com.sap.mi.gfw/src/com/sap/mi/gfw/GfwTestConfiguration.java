package com.sap.mi.gfw;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * The Class GfwTestConfiguration.
 */
public class GfwTestConfiguration {

	public static final String CPU_PROFILING_TRACE_ACTIVE = "CPU_PROFILING_TRACE_ACTIVE"; //$NON-NLS-1$
	public static final String RECURSIVE_CHECK_FOR_UPDATE_ACTIVE = "RECURSIVE_CHECK_FOR_UPDATE_ACTIVE"; //$NON-NLS-1$
	public static final String MULTIPLE_REFRESH_SUPPRESSION_ACTIVE = "MULTIPLE_REFRESH_SUPPRESSION_ACTIVE"; //$NON-NLS-1$
	public static final String INVISIBLE_RECTANGLES_SHOWN = "INVISIBLE_RECTANGLES_SHOWN"; //$NON-NLS-1$
	public static final String VISUAL_STATE_RENDERING = "VISUAL_STATE_RENDERING"; //$NON-NLS-1$
	public static final String PROGRESS_DIALOG_ACTIVE = "PROGRESS_DIALOG_ACTIVE"; //$NON-NLS-1$
	public static final String CONTEXT_BUTTON_PAD_DECLARATION = "CONTEXT_BUTTON_PAD_DECLARATION"; //$NON-NLS-1$
	public static final String ZOOM_ANIMATION_STEPS = "ZOOM_ANIMATION_STEPS"; //$NON-NLS-1$
	public static final String DEBUG_ACTIONS_ACTIVE = "DEBUG_ACTIONS_ACTIVE"; //$NON-NLS-1$
	public static final String MOF_EXAMPLE_SHOWING_ALL_PROPERTIES = "MOF_EXAMPLE_SHOWING_ALL_PROPERTIES"; //$NON-NLS-1$
	public static final String GENERIC_PROPERTY_SHEET_ACTIVE = "GENERIC_PROPERTY_SHEET_ACTIVE"; //$NON-NLS-1$
	public static final String GENERIC_OUTLINE_ACTIVE = "GENERIC_OUTLINE_ACTIVE"; //$NON-NLS-1$
	public static final String POLYLINE_ROUNDING = "POLYLINE_ROUNDING"; //$NON-NLS-1$

	/**
	 * The transient preference store does not save the values.
	 */
	private static IPreferenceStore TRANSIENT_PREFERENCE_STORE = new PreferenceStore() {
		@Override
		public boolean needsSaving() {
			return false;
		}
	};

	/**
	 * The qualifier of the persistent preference store.
	 */
	private static String PERSISTENT_PREFERENCE_STORE = "com.sap.mi.gfw.test.configuration"; //$NON-NLS-1$

	/**
	 * The current preference store.
	 */
	private static IPreferenceStore preferenceStore;

	/**
	 * Return true, if the CPU profiling trace is active. This will write CPU durations into the log-file.
	 * 
	 * @return true, if the CPU profiling trace is active.
	 */
	public static boolean isCPUProfilingTraceActive() {
		return getStaticPreferenceStore().getBoolean(CPU_PROFILING_TRACE_ACTIVE);
	}

	/**
	 * Returns true, if the check for a needed update is done recursively.
	 * 
	 * @return true, if the check for a needed update is done recursively.
	 */
	public static boolean isRecursiveCheckForUpdateActive() {
		return getStaticPreferenceStore().getBoolean(RECURSIVE_CHECK_FOR_UPDATE_ACTIVE);
	}

	/**
	 * Returns true, if multiple refresh is suppressed to improve performance. This was an improvement from Diego.
	 * 
	 * @return true, if multiple refresh is suppressed to improve performance. This was an improvement from Diego.
	 */
	public static boolean isMultipleRefreshSupressionActive() {
		return getStaticPreferenceStore().getBoolean(MULTIPLE_REFRESH_SUPPRESSION_ACTIVE);
	}

	/**
	 * Returns true, if invisible rectangles are shown (so that they are no longer invisible).
	 * 
	 * @return true, if invisible rectangles are shown (so that they are no longer invisible).
	 */
	public static boolean areInvisibleRectanglesShown() {
		return getStaticPreferenceStore().getBoolean(INVISIBLE_RECTANGLES_SHOWN);
	}

	/**
	 * Returns the visual state rendering method to use. Currently the following declarations are supported: 0=default, 1=special.
	 * 
	 * @return The visual state rendering method to use.
	 */
	public static int getVisualStateRendering() {
		return getStaticPreferenceStore().getInt(VISUAL_STATE_RENDERING);
	}

	/**
	 * Returns true, if the progress dialog is shown when commands are executed.
	 * 
	 * @return true, if the progress dialog is shown when commands are executed.
	 */
	public static boolean isProgressDialogActive() {
		return getStaticPreferenceStore().getBoolean(PROGRESS_DIALOG_ACTIVE);
	}

	/**
	 * Returns the context button pad declaration to use. This changes the visualization of the context buttons. Currently the following
	 * declarations are supported: 0=default, 1=special.
	 * 
	 * @return The context button pad declaration to use.
	 */
	public static int getContextButtonPadDeclaration() {
		return getStaticPreferenceStore().getInt(CONTEXT_BUTTON_PAD_DECLARATION);
	}

	/**
	 * Returns the number of intermediate visual steps to perform when zooming, which results in an animated zoom.
	 * 
	 * @return The number of intermediate visual steps to perform when zooming, which results in an animated zoom.
	 */
	public static int getZoomAnimationSteps() {
		return getStaticPreferenceStore().getInt(ZOOM_ANIMATION_STEPS);
	}

	/**
	 * Returns true, if debug actions shall be added to the context-menu of each shape. They allow to dump the shape to console.
	 * 
	 * @return true, if debug actions shall be added to the context-menu of each shape.
	 */
	public static boolean areDebugActionsActive() {
		return getStaticPreferenceStore().getBoolean(DEBUG_ACTIONS_ACTIVE);
	}

	/**
	 * Returns true, if the generic outline of the samples plug-in is active.
	 * 
	 * @return true, if the generic outline of the samples plug-in is active.
	 */
	public static boolean isGenericOutlineActive() {
		return getStaticPreferenceStore().getBoolean(GENERIC_OUTLINE_ACTIVE);
	}

	/**
	 * Returns true, if the generic property sheet of the samples plug-in is active.
	 * 
	 * @return true, if the generic property sheet of the samples plug-in is active.
	 */
	public static boolean isGenericPropertySheetActive() {
		return getStaticPreferenceStore().getBoolean(GENERIC_PROPERTY_SHEET_ACTIVE);
	}

	/**
	 * Returns true, if the MOF example shows all properties in the property sheet (needs the generic property sheet).
	 * 
	 * @return true, if the MOF example shows all properties in the property sheet (needs the generic property sheet).
	 */
	public static boolean isMofExampleShowingAllProperties() {
		return getStaticPreferenceStore().getBoolean(MOF_EXAMPLE_SHOWING_ALL_PROPERTIES);
	}

	/**
	 * Returns the polyline rounding to use. Currently the following roundings are supported: 0=on, 1=never, 2=always.
	 * 
	 * @return The polyline rounding to use.
	 */
	public static int getPolylineRounding() {
		return getStaticPreferenceStore().getInt(POLYLINE_ROUNDING);
	}

	/**
	 * Returns the (static) IPreferenceStore, which is used by all instanced of this PreferencePage. This can be used to access the
	 * preferences everywhere.
	 * 
	 * @return The (static) IPreferenceStore.
	 */
	public static IPreferenceStore getStaticPreferenceStore() {
		if (preferenceStore == null) {
			// only use static preference store, if samples plugin to maintain it is available
			boolean usePersistentPreferenceStore = Platform.getBundle("com.sap.mi.gfw.samples") != null; //$NON-NLS-1$
			if (usePersistentPreferenceStore) {
				preferenceStore = new ScopedPreferenceStore(new InstanceScope(), PERSISTENT_PREFERENCE_STORE);
			} else {
				preferenceStore = TRANSIENT_PREFERENCE_STORE;
			}

			preferenceStore.setDefault(CPU_PROFILING_TRACE_ACTIVE, false);
			preferenceStore.setDefault(RECURSIVE_CHECK_FOR_UPDATE_ACTIVE, false);
			preferenceStore.setDefault(MULTIPLE_REFRESH_SUPPRESSION_ACTIVE, true);
			preferenceStore.setDefault(INVISIBLE_RECTANGLES_SHOWN, false);
			preferenceStore.setDefault(VISUAL_STATE_RENDERING, 0);
			preferenceStore.setDefault(PROGRESS_DIALOG_ACTIVE, false);
			preferenceStore.setDefault(CONTEXT_BUTTON_PAD_DECLARATION, 0);
			preferenceStore.setDefault(ZOOM_ANIMATION_STEPS, 0);
			preferenceStore.setDefault(DEBUG_ACTIONS_ACTIVE, false);
			preferenceStore.setDefault(GENERIC_OUTLINE_ACTIVE, false);
			preferenceStore.setDefault(GENERIC_PROPERTY_SHEET_ACTIVE, false);
			preferenceStore.setDefault(MOF_EXAMPLE_SHOWING_ALL_PROPERTIES, false);
			preferenceStore.setDefault(POLYLINE_ROUNDING, 0);
		}

		return preferenceStore;
	}
}
