package com.sap.ide.moftool.editor.graphics.clazz.operation;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.commands.CreateOperationCommand;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.exec.ExecMOFToolDefaultImpl;
import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.compartment.ExpandCompartmentsCustomFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.pattern.DefaultJamFeatureProviderWithPatterns;

public class CreateOperationCustomFeature  extends AbstractCustomFeature{

	private static final String NAME = Messages.CreateOperationCustomFeature_0_xbut;
	private static final String DESCRIPTION = Messages.CreateOperationCustomFeature_1_xmsg;


	public CreateOperationCustomFeature(IFeatureProvider fp) {
		super(fp);        
	}


	@Override
	public boolean canExecute(ICustomContext context) {
		// allow to add operation to a selected class
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof MofClass) {     
				ret = !ModelElementService.isForeignObject(getDiagram(), (MofClass)bo);
			}
		}
		return ret;
	}

	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof MofClass) {
				MofClass mofClass = (MofClass) bo;

				// Create the name for the new operation
				String name = NamespaceService.getValidNameForNewSubobject(mofClass,
						ExecMOFToolDefaultImpl.NEW_OPERATION_NAME);

				// Create the new operation
				CreateOperationCommand command = new CreateOperationCommand(name, mofClass,
						getConnection());
				command.execute();

				// Update graphical representation of class
				getFeatureProvider().updateIfPossible(new UpdateContext(firstPE));
				
				// expand class node after creating a new operation
				ExpandCompartmentsCustomFeature expandFeature = new ExpandCompartmentsCustomFeature(getFeatureProvider());
				expandFeature.execute(context); 

				// Switch to direct editing
				if (getFeatureProvider() instanceof DefaultJamFeatureProviderWithPatterns) {
					DefaultJamFeatureProviderWithPatterns fp = (DefaultJamFeatureProviderWithPatterns)getFeatureProvider();
					fp.activateDirectEditingForPatterns(firstPE, command.getOperation());
				}
			}
		}
	}

	public String getName() {     
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public boolean isAvailable(IContext context) {     
		boolean ret = false;
		if (context instanceof ICustomContext) {
			PictogramElement[] pes = ((ICustomContext) context).getPictogramElements();
			if (pes != null && pes.length == 1) {
				PictogramElement pe = pes[0];
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof MofClass) {
					return true;
				}
			}
		}
		return ret;
	}
}
