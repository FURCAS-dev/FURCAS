package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import de.hpi.sam.bp2009.benchframework.Operator;

public class ChooseModulePage extends WizardPage {
	private static final String OPERATORID	=	"de.hpi.sam.bp2009.benchframework.operatorExtensionPointID";

	protected ChooseModulePage(String pageName) {
		super(pageName);
		setTitle("Add Module");
        setDescription("Choose the module to add.");
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

	}

	private ArrayList<Operator> getRegisteredOperators() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElement = extensionRegistry.getConfigurationElementsFor(OPERATORID);
		ArrayList<Operator> operators=new ArrayList<Operator>();
		
		for(IConfigurationElement element:configurationElement){
		
				Object obj=null;
				try {
					obj = element.createExecutableExtension("operatorClass");
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(obj instanceof Operator)
					operators.add((Operator) obj);
		}
		return operators;
	}
}
