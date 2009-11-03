package com.sap.mi.fwk.ui.editor;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;

/**
 * Describes a {@link ModelEditor} registration
 * 
 * @author d031150
 * 
 * @deprecated Use the respective methods in {@link ModelEditorManager} with
 *             {@link IEditorDescriptor}
 */
@Deprecated
public final class ModelEditorDescription {

	private final IEditorDescriptor mEditorDesc;

	public ModelEditorDescription(String editorId, String displayName, IConfigurationElement configElement) {
		mEditorDesc = PlatformUI.getWorkbench().getEditorRegistry().findEditor(editorId);
		if (mEditorDesc == null)
			throw new IllegalArgumentException("No such editor " + editorId); //$NON-NLS-1$
	}

	IEditorDescriptor getEditorDescriptor() {
		return mEditorDesc;
	}

	public String getDisplayName() {
		return getEditorDescriptor().getLabel();
	}

	public String getEditorID() {
		return getEditorDescriptor().getId();
	}

	public String toString() {
		return mEditorDesc.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mEditorDesc == null) ? 0 : mEditorDesc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ModelEditorDescription other = (ModelEditorDescription) obj;
		if (mEditorDesc == null) {
			if (other.mEditorDesc != null)
				return false;
		} else if (!mEditorDesc.equals(other.mEditorDesc))
			return false;
		return true;
	}

}
