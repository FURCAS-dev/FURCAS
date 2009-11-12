package com.sap.ide.moftool.editor.fwk;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.mi.fwk.ui.databinding.validation.BindingScopedMultiValidator;

public class MoinValidator extends BindingScopedMultiValidator {

	private RefBaseObject object;
	public MoinValidator(RefBaseObject object, IObservableCollection bindings) {
		super(bindings);
		this.object = object;
	}


	@Override
	protected IStatus validate() {
		return NamespaceService.validate(object, ""); //$NON-NLS-1$
	}

}
