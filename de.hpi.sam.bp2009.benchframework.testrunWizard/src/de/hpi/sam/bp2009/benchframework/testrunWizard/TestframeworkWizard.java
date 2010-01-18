package de.hpi.sam.bp2009.benchframework.testrunWizard;

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
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.hpi.sam.bp2009.benchframework.Engine;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;
import de.hpi.sam.bp2009.benchframework.UserInterface;

public class TestframeworkWizard extends Wizard implements INewWizard, UserInterface {

	ListPage listPage;
	ChooseModulePage chooseModulePage;
	
	public void addPages() {
        listPage = new ListPage("Module List");
        addPage(listPage);
        chooseModulePage = new ChooseModulePage("Add Module");
        addPage(chooseModulePage);
	}
	@Override
	public boolean performFinish() {

		return false;
	}
	public boolean canFinish() {
		return false;		
	}
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
		
	}
	@Override
	public Operator getAvailableOperators() {
		
		return null;
	}
	@Override
	public Engine getEngine() {
		
		return null;
	}
	@Override
	public ResultProcessor getResultProcessor() {
		
		return null;
	}
	@Override
	public void setAvailableOperators(Operator value) {
		
		
	}
	@Override
	public void setEngine(Engine value) {
		
		
	}
	@Override
	public void setResultProcessor(ResultProcessor value) {
		
		
	}
	@Override
	public TreeIterator<EObject> eAllContents() {
		
		return null;
	}
	@Override
	public EClass eClass() {
		
		return null;
	}
	@Override
	public EObject eContainer() {
		
		return null;
	}
	@Override
	public EStructuralFeature eContainingFeature() {
		
		return null;
	}
	@Override
	public EReference eContainmentFeature() {
		
		return null;
	}
	@Override
	public EList<EObject> eContents() {
		
		return null;
	}
	@Override
	public EList<EObject> eCrossReferences() {
		
		return null;
	}
	@Override
	public Object eGet(EStructuralFeature feature) {
		
		return null;
	}
	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		
		return null;
	}
	@Override
	public boolean eIsProxy() {
		
		return false;
	}
	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		
		return false;
	}
	@Override
	public Resource eResource() {
		
		return null;
	}
	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		
		
	}
	@Override
	public void eUnset(EStructuralFeature feature) {
		
		
	}
	@Override
	public EList<Adapter> eAdapters() {
		
		return null;
	}
	@Override
	public boolean eDeliver() {
		
		return false;
	}
	@Override
	public void eNotify(Notification notification) {

		
	}
	@Override
	public void eSetDeliver(boolean deliver) {
	
		
	}
}
