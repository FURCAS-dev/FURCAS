package com.sap.ide.moftool.editor.core.ocl;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.omg.ocl.OclPackage;
import org.omg.ocl.attaching.OclConstraint;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.commands.ActivateConstraintCommand;
import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.ui.preferences.PreferenceConstants;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ProcessWarning;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;



public class OclConstraintActivator implements ChangeListener {

	private static final String NAME_PACKAGE_ATTACHING = "Attaching"; //$NON-NLS-1$
	private static final String NAME_CLASS_OCL_CONSTRAINT = "OclConstraint"; //$NON-NLS-1$
	
	public static final String ATT_VIOLATION_ID = "com.sap.ide.moftool.editor.OclConstraintActivator.violationID"; //$NON-NLS-1$

	public static final String MARKER_TYPE = "com.sap.ide.moftool.editor.oclactivatormarker"; //$NON-NLS-1$
	
	public static final String LINE = LocalizationMessages.OclConstraintActivator_0_XMSG;
	public static final String COLUMN = LocalizationMessages.OclConstraintActivator_1_XMSG;

	private static final Logger sTracer = Logger.getLogger(OclConstraintActivator.class.getName());

	private Connection mConnection = null;
	private boolean mConstraintChanged = false;
	private boolean mCurrentlyActivating = false;

	public OclConstraintActivator(Connection connection) {
		super();
		mConnection = connection;
	}
	
	public MofClass getOclConstraintRefClass() {
		OclPackage oclPackage = MofService.getOclPackage(mConnection);
		if (oclPackage == null) {
			MOFToolEditorPlugin.logError(new InternalErrorException("Could not get OCL package")); //$NON-NLS-1$
			return null;
		}
		RefPackage attachingPackage = oclPackage.refPackage(NAME_PACKAGE_ATTACHING);
		if (attachingPackage == null) {
			MOFToolEditorPlugin.logError(new InternalErrorException("Could not get attaching package")); //$NON-NLS-1$
			return null;
		}
		return (MofClass)attachingPackage.refClass(NAME_CLASS_OCL_CONSTRAINT).refMetaObject();
	}

	public void activate() {
		if (!mConstraintChanged) {
			return;
		}
		
		if (PreferenceConstants.VALUE_OCL_AUTO_ACTIVATION_OFF == PreferenceConstants.getOclAutoActivationSetting()) {
			// User setting is not to activate OCL constraint automatically
			return;
		}
		
		forcedActivate();
	}
	
	public void forcedActivate() {

		mCurrentlyActivating = true;
		
		try {
			Connection connection = mConnection;
			IProject project = ModelAdapter.getInstance().getProject(connection);
	
			// Clean old markers
			cleanMarkers(project, connection);
	
			// Do the activation
			if (sTracer.isLoggable(Level.FINE)) {
				sTracer.log(Level.FINE, "builder started at " + System.nanoTime()); //$NON-NLS-1$
			}
	
//			TODO do this in a different way
//			if (!MoinMetamodelDcService.isMetamodelProject(project)) {
//				sTracer.warning("MOIN constraint activator invoked on non-MOIN metamodel project '" + project.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$
//				return;
//			}
	
	
			// Ignore build kind since only full build is possible
			ActivateConstraintCommand command = new ActivateConstraintCommand(project, connection);
			if (!command.canExecute()) {
				sTracer.log(Level.SEVERE, "Cannot activate OCL constraint command"); //$NON-NLS-1$
				return;
			}
			command.execute();
	
			
			// Write new markers 
			Map<ProcessReport, MRI> list = command.getResult();
			if (list != null) {
				Iterator<ProcessReport> it = list.keySet().iterator();
				while (it.hasNext()) {
					ProcessReport report = it.next();
					RefBaseObject object = connection.getElement(list.get(report));
					OclConstraint constraint = null;
					if (object instanceof OclConstraint) {
						constraint = (OclConstraint)object;
					}
					else {
						sTracer.log(Level.SEVERE, "No OclConstraint found for marker: " + report.toString()); //$NON-NLS-1$
						continue;
					}
	
					// Errors
					Iterator<ProcessError> errorIt = report.getErrors().iterator();
					while (errorIt.hasNext()) {
						ProcessError error = errorIt.next();
	
						int severity = IMarker.SEVERITY_ERROR;						
						String msg = error.getMessage() + " (" + LINE + " " + error.getStartLine() + //$NON-NLS-1$ //$NON-NLS-2$
							", " + COLUMN + " " + error.getStartColumn() + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						MarkerManager.getInstance().createMarker(constraint, MARKER_TYPE, severity, msg);
					}
	
					// Warnings
					Iterator<ProcessWarning> warningIt = report.getWarnings().iterator();
					while (warningIt.hasNext()) {
						ProcessWarning warning = warningIt.next();
	
						int severity = IMarker.SEVERITY_WARNING;
						String msg = warning.getMessage() + " (" + LINE + " " + warning.getStartLine() + //$NON-NLS-1$ //$NON-NLS-2$
						", " + COLUMN + " " + warning.getStartColumn() + ")";						 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						MarkerManager.getInstance().createMarker(constraint, MARKER_TYPE, severity, msg);
					}
				}
			}
	
			if (sTracer.isLoggable(Level.FINE)) {
				sTracer.log(Level.FINE, "builder finished at " + System.nanoTime()); //$NON-NLS-1$
			}
			
			// Set constraint up to date
			mConstraintChanged = false;
		}
		finally {
			mCurrentlyActivating = false;
		}
	}

	private void cleanMarkers(IProject project, Connection connection) {
		try {
			project.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			sTracer.log(Level.SEVERE, "Could not delete markers for project '" + project.getName() + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	public void notify(ChangeEvent event) {
		if (!mCurrentlyActivating) {
			// Set constraints need update
			mConstraintChanged = true;
		}
	}
}