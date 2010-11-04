	package com.sap.furcas.ide.projectwizard.wizards;

    import org.eclipse.jface.viewers.ISelection;
	import org.eclipse.jface.wizard.IWizardPage;
	import org.eclipse.jface.wizard.WizardPage;
	import org.eclipse.swt.SWT;
    import org.eclipse.swt.events.MouseEvent;
    import org.eclipse.swt.events.MouseListener;
	import org.eclipse.swt.layout.GridData;
	import org.eclipse.swt.layout.GridLayout;
    import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;


	public class FurcasWizardMMSelectionPage extends WizardPage {
        Button selectmm1;
        Button selectmm2;
        private WizardNewProjectCreationPage page4;
        private MMLoadPage page3;
        FurcasWizard wiz;
        
		public FurcasWizardMMSelectionPage(ISelection selection, FurcasWizard w) {
	        super("Metamodel");
	        page3=null;
	        page4=null;
			wiz = w;
	        setTitle("Metamodelselection");
	        setDescription("Choose an existing Metamodel or create a new one");
			setPageComplete(false);
	    }

		@Override
		public void createControl(Composite parent) {
			Composite container = new Composite(parent, SWT.NULL);
	        GridLayout layout = new GridLayout();
	        container.setLayout(layout);
	        layout.numColumns = 2;
	        layout.verticalSpacing = 9;
	        
	       //First option
	        selectmm1 = new Button(container, SWT.RADIO);
	        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	        selectmm1.setText("Create new METAMODEL-project");
	        selectmm1.setLayoutData(gd);
	        selectmm1.addMouseListener(new MouseListener() {
				public void mouseDoubleClick(MouseEvent e) {}
				public void mouseDown(MouseEvent e) {
					if (!selectmm1.getSelection()){
					  selectmm1.setSelection(true);
					  selectmm2.setSelection(false);
					}
					  getNextPage();
				}
				public void mouseUp(MouseEvent e) {}
	        });
	       // second option
	        selectmm2 = new Button(container, SWT.RADIO);
	        GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
	        selectmm2.setText("Use existing METAMODEL");
	        selectmm2.setLayoutData(gd2);
	        selectmm2.addMouseListener(new MouseListener() {
				public void mouseDoubleClick(MouseEvent e) {}
				public void mouseDown(MouseEvent e) {
					if (!selectmm2.getSelection())
					{
						  selectmm1.setSelection(false);
						  selectmm2.setSelection(true);
						}
					  getNextPage();
				}
				public void mouseUp(MouseEvent e) {}
	        });
	        
	        
	        setErrorMessage(null);
	        setControl(container);
	        

		}
        public Integer getSel() {
        	Integer sel = null;
        	  if (selectmm1.getSelection()==true)
        		  sel=1;
        	  else if (selectmm2.getSelection()==true)
        		  sel=2;
        	  return sel;
        }
        @Override
        public IWizardPage getNextPage(){
        	if (getSel()==2){
        		if (page3 == null){
        		page3 = new MMLoadPage("LoadPage", wiz);
        		wiz.addPage(page3);
        		page3.setPageComplete(false);
        		this.setPageComplete(true);
        		}
        		if (wiz.createmm){
            		wiz.createmm=false;
        		}
        		return page3;
        		
        	}
        	else if (getSel()==1){
        		if (page4 == null){
        		page4 = wiz.addMMP();
        		page4.setPageComplete(false);
        		this.setPageComplete(true);
        		}
        		return page4;
        	}
            return null;
        	}
	}

			//Code snippet for starting a wizard
			
/*			String id = "org.eclipse.emf.importer.ui.EMFProjectWizard";
				 IWizardDescriptor descriptor = PlatformUI.getWorkbench()
				   .getNewWizardRegistry().findWizard(id);
				 // If not check if it is an "import wizard".
				 if  (descriptor == null) {
				   descriptor = PlatformUI.getWorkbench().getImportWizardRegistry()
				   .findWizard(id);
				 }
				 // Or maybe an export wizard
				 if  (descriptor == null) {
				   descriptor = PlatformUI.getWorkbench().getExportWizardRegistry()
				   .findWizard(id);
				 }
				 try  {
				   // Then if we have a wizard, open it.
				   if  (descriptor != null) {
				     IWizard wizard = descriptor.createWizard();
				     WizardDialog wd = new  WizardDialog(getShell(), wizard);
				     wd.setTitle(wizard.getWindowTitle());
				     wd.open();
				   }
				 } catch  (CoreException e) {
				   e.printStackTrace();
				 }*/

	


