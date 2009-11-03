package com.sap.mi.fwk.dcfwk;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.ide.dii05.lib.api.modeledit.IMeDcMetadataState;
import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.ui.api.typefw.IDevelopmentComponentTypeDelegate;

/**
 * Protocol for a Dc type definition based on Moin. <p/> Clients may implement,
 * though subclassing {@link BasicMoinDcType} is recommended. For Dc types with
 * Java notion subclassing
 * <code>com.sap.ide.dii05.jdt.api.type.JavaDCType</code> may be appropriate.
 * 
 * @author d031150
 */
public interface IMoinDcType extends IDevelopmentComponentTypeDelegate {

	/**
	 * Returns settings relevant on DC creation (about natures, builders,
	 * folders, public parts to set). Provide a sublass of {@link MoinDcOptions}
	 * to customize them.
	 * 
	 * @param reset
	 *            if <code>true</code>, all state of the returned options
	 *            must be cleared (or a new options instance be created)
	 * 
	 * @return the settings, never <code>null</code>
	 */
	MoinDcOptions getOptions(boolean reset);

	/**
	 * Called during DC creation to give implementors the chance to do
	 * additional configuration of the given DC. Note that an Eclipse project
	 * for the DC may not be there in case the user created the DC without a
	 * project. Only modifications of the DC and its project metadata are
	 * permitted at this time using the supplied <code>editableState</code>,
	 * however, accessing the Moin model data is not possible. To do some
	 * Moin-related initializations, override
	 * {@link #init(IDevelopmentComponent, IProject, IProgressMonitor)} of this
	 * class.
	 * 
	 * @param dc
	 *            the DC
	 * @param editableState
	 *            DC state information that may be modified. Note that it is not
	 *            necessary to commit the changes as this is done by the caller.
	 * 
	 * @throws CoreException
	 *             if configuration fails
	 * 
	 * @see DiiResourceService#getProject(IDevelopmentComponent)
	 */
	void configure(IDevelopmentComponent dc, IMeDcMetadataState editableState) throws CoreException;

	/**
	 * Called after DC creation to give implementors the chance to do additional
	 * Moin-related initialization of the given DC. In opposition to the
	 * {@link #configure(IDevelopmentComponent, IMeDcMetadataState) DC configuration hook},
	 * the Moin model can be accessed, e.g. do load or create data. If the DC is
	 * created using a creation wizard, this method is called from the UI thread
	 * in order to allow e.g. version operations. However, if the creation is triggered
	 * programmatically, it may be called from a background thread.
	 * 
	 * @param dc
	 *            the DC
	 * @param project
	 *            the DC project
	 * @param monitor
	 *            a monitor to report progress with
	 * @throws CoreException
	 *             if initialization fails
	 */
	void init(IDevelopmentComponent dc, IProject project, IProgressMonitor monitor) throws CoreException;
	
	/**
	 * @return the DC type identifier containing id, vendor and subtype
	 */
	IComponentType getComponentType();

}
