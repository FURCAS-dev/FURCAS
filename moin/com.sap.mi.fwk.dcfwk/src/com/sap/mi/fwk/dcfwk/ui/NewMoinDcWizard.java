package com.sap.mi.fwk.dcfwk.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.ui.api.typefw.TypedDcNewWizard;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.dcfwk.internal.messages.DcFwkMessages;

/**
 * A "New" wizard for creating Moin DCs.  Subclasses must specify the DC type this wizard
 * should create DC for by overriding {@link #getDcTypeId()}, {@link #getDcTypeVendor()}, 
 * and {@link #getDcSubType()}.
 * 
 * @author d031150
 */
public abstract class NewMoinDcWizard extends TypedDcNewWizard {

    /**
     * Creates a new DC wizard.  Used by Eclipse extension instantiation.
     */
    public NewMoinDcWizard() {
		super();
	}
    
    /**
     * @return the DC type id this wizard is responsible for  
     */
    protected abstract String getDcTypeId();

    /**
     * @return the DC type vendor name this wizard is responsible for.  
     * 		Defaults to {@link MoinProject#VENDOR_SAP the SAP vendor}, if <code>null</code> is returned.
     */
    protected String getDcTypeVendor() {
    	return null;
    }
    
    /**
     * @return the DC sub type this wizard is responsible for.  May be <code>null</code>.  
     */
    protected String getDcSubType() {
    	return null;
    }
    
    /**
     * @return the title for the wizard.  Subclasses may override to provide a custom
     *      title giving a clearer hint on which type of project is to be created.  
     *      If <code>null</code> is returned, a default title is taken.
     */
    protected String getWizardTitle() {
        return null;
    }

    /**
     * Sets the wizard title according to {@link #getWizardTitle()}
     */
    @Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
        super.init(workbench, selection);
        String title = getWizardTitle();
        setWindowTitle(title != null ? title : DcFwkMessages.Wizard_title);
    }

    /**
     * Creates the type this wizard should handle according to the results of 
     * {@link #getDcTypeId()}, {@link #getDcTypeVendor()}, and {@link #getDcSubType()}
     */
	@Override
	public final IComponentType getDcType() {
		String id = getDcTypeId();
		String vendor = getDcTypeVendor();
		String subType = getDcSubType();
		
		IComponentType type = MoinProject.getDcType(id, vendor, subType);
		return type;
	}
    
}
