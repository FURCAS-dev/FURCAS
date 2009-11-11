package com.sap.ide.moftool.editor.composites;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.fwk.BrowseReturnTypeControl;
import com.sap.ide.moftool.editor.fwk.MultiplicityTypeControl;
import com.sap.ide.moftool.editor.gen.composites.OperationReturnParameterCompositeBase;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.InstanceFilter;

public class OperationReturnParameterComposite extends OperationReturnParameterCompositeBase {

	private UpdateListener mListener = null;

	public OperationReturnParameterComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	protected void bindMultiplicity(MoinDataBindingContext dbc, Operation component,
			MultiplicityTypeControl multiplicity) {

		Parameter retParam = getReturnParameter(component);
		multiplicity.setInput(retParam, com.sap.tc.moin.repository.mmi.model.Parameter.DESCRIPTORS.MULTIPLICITY(), dbc);

	}

	@Override
	protected void bindType(final MoinDataBindingContext dbc, final Operation refObject, Control type) {
		BrowseReturnTypeControl returnTypeControl = null;

		if (type instanceof BrowseReturnTypeControl) {
			returnTypeControl = (BrowseReturnTypeControl) type;
		} else {
			return;
		}
		
		if (ModelElementService.isForeignObject(refObject)) {
			returnTypeControl.setEnabled(false); 
		}
		
		Parameter retParam = getReturnParameter(refObject);
		returnTypeControl.setInput(refObject, retParam, com.sap.ide.moftool.editor.gen.composites.Messages.AttributeComposite_Type,
				com.sap.tc.moin.repository.mmi.model.Parameter.DESCRIPTORS.TYPE(), dbc);

		// register update listener for operation
		Connection connection = ((Partitionable) refObject).get___Connection();
		EventRegistry er = connection.getEventRegistry();
		InstanceFilter instFilter = new InstanceFilter(refObject);
		// TODO define PartitionChangeEvent Listener at different place
		// OrFilter orFilter = new OrFilter(etFilter,
		// new EventTypeFilter(PartitionChangeEvent.class));
		if (mListener != null) {
			er.deregister(mListener);
		}
		mListener = new UpdateListener() {
			public void notifyUpdate(EventChain events) {
				refresh(true);
			}
		};
		er.registerUpdateListener(mListener, instFilter);
	}

	@Override
	public void setInput(final Object input) {
		// if current thread is not the UI Thread --> pass to UI Thread
		if (Display.getCurrent() == null) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					OperationReturnParameterComposite.super.setInput(input);

				}
			});
		} else {
			super.setInput(input);
		}
	}

	@Override
	protected Control createType(Composite rootComposite, FormToolkit formToolkit) {
		createLabel(com.sap.ide.moftool.editor.gen.composites.Messages.AttributeComposite_Type, rootComposite, formToolkit);
		BrowseReturnTypeControl type = new BrowseReturnTypeControl(formToolkit, rootComposite, SWT.NONE);
		type.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		return type;
	}

	private Parameter getReturnParameter(Operation op) {
		Parameter retParam = null;
		Parameter param = null;
		List<ModelElement> contents = op.getContents();
		for (ModelElement obj : contents) {
			if (obj instanceof Parameter) {
				param = (Parameter) obj;
				if (param.getDirection().equals(DirectionKindEnum.RETURN_DIR)) {
					retParam = param;
					break;
				}
			}
		}
		return retParam;
	}

}
