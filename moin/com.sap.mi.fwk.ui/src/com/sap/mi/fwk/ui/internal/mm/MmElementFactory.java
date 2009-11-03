package com.sap.mi.fwk.ui.internal.mm;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

/**
 * Factory for {@link MmAdaptable metamodel adaptables}
 * 
 * @author d031150
 */
public final class MmElementFactory implements IElementFactory {
	
	static final String ID = "com.sap.mi.fwk.ui.metamodelFactory"; //$NON-NLS-1$
	static final String KEY_CONTAINER_NAME = "containerName"; //$NON-NLS-1$
	
	public MmElementFactory() {
	}

	public IAdaptable createElement(IMemento memento) {
		String string = memento.getString(KEY_CONTAINER_NAME);
		if (string != null) {
			// Note: we do not yet fetch the concrete metamodel here since this is a potentially
			// long-running operation, instead MmAdaptable is fine with just our stored container name.
			return createMmAdaptable(string);
		}
		return null;
	}

	/**
	 * Creates an adaptable for the given metamodel name 
	 */
	public static IAdaptable createMmAdaptable(String containerName) {
		IAdaptable adaptable = new MmAdaptable(containerName);
		return adaptable;
	}

}
