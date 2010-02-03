package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @author Philipp
 * This class is used to add more control to the order of pages of a wizard
 */
public abstract class  AdvancedWizard extends Wizard implements INewWizard{

	protected List<IWizardPage> pagesInOrder= new ArrayList<IWizardPage>();
	protected IStructuredSelection selection;
	
	protected IWorkbench workbench;
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {		
		this.workbench = workbench;
		this.selection = selection;
			}
	
	public void addPage( int index, IWizardPage page){
		if(pagesInOrder.contains(page)){
			int i= pagesInOrder.indexOf(page);
			if(i==index)
				return;
			//element exists before index, on removing list will reduce and index can be out of bounds
			if(i<index)
				index--;
			pagesInOrder.remove(i);

		}
		pagesInOrder.add(index, page);
        page.setWizard(this);
	}
	public boolean removePage(IWizardPage page){
		page.dispose();
		page.setWizard(null);
		return pagesInOrder.remove(page);
	}
	public void flushInnerPages(){
		for(IWizardPage page:pagesInOrder){
			page.dispose();
			page.setWizard(null);
		}
		pagesInOrder.clear();
	}
	
	@Override
	public void addPage(IWizardPage page) {
		pagesInOrder.add(page);
        page.setWizard(this);
	}
	@Override
	public boolean canFinish() {
        // Default implementation is to check if all pages are complete.
        for (int i = 0; i < pagesInOrder.size(); i++) {
            if (!((IWizardPage) pagesInOrder.get(i)).isPageComplete()) {
				return false;
			}
        }
        return true;
    }
	@Override
	public void createPageControls(Composite pageContainer) {
        // the default behavior is to create all the pages controls
        for (int i = 0; i < pagesInOrder.size(); i++) {
            IWizardPage page = (IWizardPage) pagesInOrder.get(i);
            page.createControl(pageContainer);
            // page is responsible for ensuring the created control is
            // accessable
            // via getControl.
            Assert.isNotNull(page.getControl());
        }
    }
	@Override
    public void dispose() {
        // notify pages
        for (int i = 0; i < pagesInOrder.size(); i++) {
            ((IWizardPage) pagesInOrder.get(i)).dispose();
        }
        super.dispose();
    }
	@Override
	public boolean isHelpAvailable() {
		return false;
	}
    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        int index = pagesInOrder.indexOf(page);
        if(index == -1){
        	if(page.equals(getLastPage()))
        		return getLeastPage();
        	if(page.equals(getStartingPage())&&pagesInOrder.size()>0)
        			return pagesInOrder.get(0);
        	return null;
        	}
        if (index == pagesInOrder.size() - 1) {
        	return getLastPage();
			// last page or page not found
		}
        return (IWizardPage) pagesInOrder.get(index + 1);
    }
    public abstract IWizardPage getLeastPage();
	public abstract IWizardPage getLastPage();
	@Override
    public IWizardPage getPage(String name) {
        for (int i = 0; i < pagesInOrder.size(); i++) {
            IWizardPage page = (IWizardPage) pagesInOrder.get(i);
            String pageName = page.getName();
            if (pageName.equals(name)) {
				return page;
			}
        }
        return null;
    }
    @Override
    public int getPageCount() {
        return pagesInOrder.size();
    }
    @Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		int i=pagesInOrder.indexOf(page);
		if(i!=-1 && i>0)
			return pagesInOrder.get(i-1);
		return null;
	}
    @Override
    public abstract IWizardPage getStartingPage();
    
    @Override
    public boolean needsPreviousAndNextButtons() {
        return super.needsPreviousAndNextButtons() || pagesInOrder.size() > 1;
    }
}
