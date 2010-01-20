package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import de.hpi.sam.bp2009.benchframework.Operator;

public class ChooseModulePage extends WizardPage {
	private static final String OPERATORID	=	"de.hpi.sam.bp2009.benchframework.operatorExtensionPointID";
	private EList<Operator> ops;

	protected ChooseModulePage(String pageName) {
		super(pageName);
		setTitle("Add Module");
        setDescription("Choose the module to add.");
        if(super.getWizard() instanceof TestframeworkWizard){
        	TestframeworkWizard wiz=(TestframeworkWizard) super.getWizard();
        	this.ops=wiz.getIntImpl().getAvailableOperators();
        }
        
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

	}
}
