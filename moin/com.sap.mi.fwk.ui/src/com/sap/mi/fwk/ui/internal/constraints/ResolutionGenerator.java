package com.sap.mi.fwk.ui.internal.constraints;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator2;

import com.sap.mi.fwk.MoinConstraintChecker;
import com.sap.mi.fwk.internal.tracing.MiLocations;

public class ResolutionGenerator implements IMarkerResolutionGenerator2 {

    private static final Logger sTracer = Logger.getLogger(MiLocations.MI_OCL);
	
	public boolean hasResolutions(IMarker marker) {
		String violationID = marker.getAttribute(MoinConstraintChecker.ATT_VIOLATION_ID, null);
		if (violationID != null) {
			return QuickfixManager.getInstance().hasQuickfix(violationID);
		}
		return false;
	}

	public  IMarkerResolution[] getResolutions(IMarker marker) {
		String violationID = marker.getAttribute(MoinConstraintChecker.ATT_VIOLATION_ID, null);
		if (violationID != null) {
			List<IMarkerResolution> result = new ArrayList<IMarkerResolution>();
			Set<IConfigurationElement> qfSet = QuickfixManager.getInstance().getQuickfixes(violationID);
			for (IConfigurationElement element : qfSet) {
				try {
					IMarkerResolution qf = (IMarkerResolution) element
							.createExecutableExtension(QuickfixManager.ATT_QUICKFIX_CLASS);
					result.add(qf);
				} catch (CoreException e) {
					sTracer.log(Level.SEVERE, "Could not instantiate class", e); //$NON-NLS-1$
				}
			}
			return result.toArray(new IMarkerResolution[result.size()]);
		}
		return null;
	}
}
