package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.awt.Composite;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.Engine;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;
import de.hpi.sam.bp2009.benchframework.UserInterface;

public class TestframeworkWizard extends Wizard implements INewWizard {

	private ListPage listPage = new ListPage("Module List");
	private ChooseModulePage chooseModulePage;
	
	protected IStructuredSelection selection;
	
	protected IWorkbench workbench;
	private WizardUserInterfaceImpl intImpl;
	
	public WizardUserInterfaceImpl getIntImpl() {
		return intImpl;
	}

	public void setIntImpl(WizardUserInterfaceImpl intImpl) {
		this.intImpl = intImpl;
	}

	
	public void addPages() {
        try {
			addPage(listPage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
        try {
			chooseModulePage = new ChooseModulePage("Add Module");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        addPage(chooseModulePage);
	}

	public IWizardPage getChooseModulePage(){
		return chooseModulePage;
	}
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
		this.workbench = workbench;
		this.selection = selection;
		this.intImpl= new WizardUserInterfaceImpl();
		this.intImpl.setEngine(BenchframeworkFactory.eINSTANCE.createEngine());
		
		
	}

}
