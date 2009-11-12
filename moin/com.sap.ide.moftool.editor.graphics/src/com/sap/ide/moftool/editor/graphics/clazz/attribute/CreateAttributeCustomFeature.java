package com.sap.ide.moftool.editor.graphics.clazz.attribute;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.commands.CreateAttributeCommand;
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

public class CreateAttributeCustomFeature extends AbstractCustomFeature {

	private static final String NAME = Messages.CreateAttributeCustomFeature_0_xbut;

	private static final String DESCRIPTION = Messages.CreateAttributeCustomFeature_1_xmsg;

	public CreateAttributeCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// allow add attribute to a selected class
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
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof MofClass) {
				MofClass mofClass = (MofClass)bo;
				// Create the name for the new attribute
				String name = NamespaceService.getValidNameForNewSubobject(mofClass,
						ExecMOFToolDefaultImpl.NEW_ATTRIBUTE_NAME);

				// Create the new attribute
				CreateAttributeCommand command = new CreateAttributeCommand(name, mofClass,
						getConnection());
				command.execute();

				// Update graphical representation of class
				getFeatureProvider().updateIfPossible(new UpdateContext(firstPE));
				
				// expand class node after creating a new attribute
				ExpandCompartmentsCustomFeature expandFeature = new ExpandCompartmentsCustomFeature(getFeatureProvider());
				expandFeature.execute(context); 


				// Switch to direct editing
				if (getFeatureProvider() instanceof DefaultJamFeatureProviderWithPatterns) {
					DefaultJamFeatureProviderWithPatterns fp = (DefaultJamFeatureProviderWithPatterns)getFeatureProvider();
					fp.activateDirectEditingForPatterns(firstPE, command.getAttribute());
				}
			}
		}
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

	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
