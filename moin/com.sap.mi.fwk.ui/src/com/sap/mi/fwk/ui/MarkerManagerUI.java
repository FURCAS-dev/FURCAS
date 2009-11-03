package com.sap.mi.fwk.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMarkerHelpRegistry;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.ide.IDE;

import com.sap.mi.fwk.MoinConstraintChecker;
import com.sap.mi.fwk.ui.internal.MarkerSelectionDialog;
import com.sap.mi.fwk.ui.internal.QuickfixSelectionDialog;
import com.sap.mi.fwk.ui.internal.constraints.QuickfixManager;

public class MarkerManagerUI {

	private static MarkerManagerUI INSTANCE = null;

	/**
	 * Hide constructor
	 */
	private MarkerManagerUI() {
	}

	/**
	 * Returns a singleton instance
	 * 
	 * @return the instance of this class
	 */
	public static synchronized MarkerManagerUI getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MarkerManagerUI();
		}
		return INSTANCE;
	}

	/**
	 * Returns true if at least one quick fix for the given markers exist
	 * 
	 * @param markers
	 *            The markers to be searched
	 * @return True, if at least one quickfix exists, false otherwise or if
	 *         array was empty
	 */
	public boolean hasQuickfixes(IMarker[] markers) {
		IMarkerHelpRegistry helpRegistry = IDE.getMarkerHelpRegistry();
		for (IMarker marker : markers) {
			if (helpRegistry.hasResolutions(marker)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Presents a selection dialog to select a quickfix for a given marker
	 * 
	 * @param markers
	 *            The markers to select and run the quickfixes for
	 * @return True if user ran quickfixes
	 */
	public boolean runQuickfix(IMarker[] markers) {
		if (markers == null) {
			throw new IllegalArgumentException("marker parameter must not be null"); //$NON-NLS-1$
		}
		if (markers.length == 0) {
			return false;
		}
		IMarker selectedMarker = null;
		List<IMarker> resolvableMarkers = new ArrayList<IMarker>();
		IMarkerHelpRegistry helpRegistry = IDE.getMarkerHelpRegistry();
		for (IMarker marker : markers) {
			if (marker != null) {
				if (helpRegistry.hasResolutions(marker)) {
					resolvableMarkers.add(marker);
				} else {
					String violationID = marker.getAttribute(MoinConstraintChecker.ATT_VIOLATION_ID, ""); //$NON-NLS-1$
					if (QuickfixManager.getInstance().getQuickfixes(violationID).size() > 0) {
						resolvableMarkers.add(marker);
					}
				}
			}
		}

		if (resolvableMarkers.size() == 0) {
			return false;
		}
		if (resolvableMarkers.size() == 1) {
			selectedMarker = resolvableMarkers.get(0);
		} else {
			MarkerSelectionDialog msDlg = new MarkerSelectionDialog(Display.getCurrent().getActiveShell(), resolvableMarkers
					.toArray(new IMarker[resolvableMarkers.size()]));
			selectedMarker = msDlg.openDialog();
		}
		if (selectedMarker != null) {
			IMarkerResolution[] resolutions = IDE.getMarkerHelpRegistry().getResolutions(selectedMarker);

			if (resolutions.length == 1) {
				resolutions[0].run(selectedMarker);
				return true;
			}
			if (resolutions.length > 1) {
				QuickfixSelectionDialog dlg = new QuickfixSelectionDialog(Display.getDefault().getActiveShell(), resolutions);

				if (dlg.open() == Window.OK) {
					Object[] results = dlg.getResult();
					for (Object object : results) {
						((IMarkerResolution) object).run(selectedMarker);
					}
					return true;
				}
			}
		}
		return false;
	}
}