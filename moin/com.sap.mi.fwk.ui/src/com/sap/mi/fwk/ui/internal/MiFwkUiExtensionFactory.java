package com.sap.mi.fwk.ui.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.views.properties.IPropertySource;

import com.sap.mi.fwk.commands.ICommandExecutor;
import com.sap.mi.fwk.internal.uihook.IMiFwkOperationExecutor;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.fwk.ui.properties.RefObjectPropertySourceManager;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Creates extensions for the UI plugin. Currently used to create
 * <ul>
 * <li>the {@link ICommandExecutor} implementation, which is
 * {@link CommandManager}. Is supposed to exist as a singleton, that is why we
 * need to delegate instantiation an extension factory.</li>
 * <li>the {@link IMiFwkOperationExecutor} implementation, which is
 * {@link MiFwkOperationExecutor}. Is supposed to exist as a singleton, that is why
 * we need to delegate instantiation an extension factory.</li>
 * <li> {@link IPropertySource property sources} for
 * {@link RefObject RefObjects}</li>
 * </ul>
 * 
 * @author d031150
 */
public final class MiFwkUiExtensionFactory implements IExecutableExtensionFactory, IExecutableExtension,
		IAdapterFactory {

	private String mId;
	private String mPropertyName;
	private IConfigurationElement mConfig;

	public MiFwkUiExtensionFactory() {
		// needed by extension instantiation
	}

	public Object create() throws CoreException {
		if (ICommandExecutor.class.getName().equals(mId)) {
			ICommandExecutor exec = configure(CommandManager.getInstance());
			return exec;
		} else if (IMiFwkOperationExecutor.class.getName().equals(mId)) {
			IMiFwkOperationExecutor exec = configure(MiFwkOperationExecutor.getInstance());
			return exec;
		}

		IStatus status = MiFwkUIPlugin.createStatus(IStatus.ERROR, "Unknown id in data argument: " + mId, null); //$NON-NLS-1$
		throw new CoreException(status);
	}

	private <T> T configure(T obj) throws CoreException {
		if (obj instanceof IExecutableExtension)
			((IExecutableExtension) obj).setInitializationData(mConfig, mPropertyName, null);
		return obj;
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		if (data instanceof String) {
			mId = (String) data;
		} else {
			IStatus status = MiFwkUIPlugin.createStatus(IStatus.ERROR, "Data argument must be a string: " + data, null); //$NON-NLS-1$
			throw new CoreException(status);
		}
		mConfig = config;
		mPropertyName = propertyName;
	}

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IPropertySource.class) {
			return new RefObjectPropertySourceManager().getPropertySource(adaptableObject);
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { IPropertySource.class };
	}

}
