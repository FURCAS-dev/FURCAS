package de.hpi.sam.bp2009.solution.oclToAst.ui;

import java.awt.Dialog;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.ErrorMessage;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;


/**
 * Adds a context entry to ecore file, to offer the EAnnotationParser Functionality
 * @author Philipp
 *
 */
public class OclToAstAction implements org.eclipse.ui.IEditorActionDelegate{

    private ArrayList<IFile> selectedFiles= new ArrayList<IFile>();

    /* (non-Javadoc)
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    @Override
    public void run(IAction action) {
        StringBuilder bld = new StringBuilder();
        bld.append("--");
        boolean onePassed=false;
        /*
         * activate for all selected files
         */
        for(IFile selectedFile : selectedFiles){
            EAnnotationOCLParser p = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
            p.convertAnnotations(URI.createURI(selectedFile.getLocationURI()==null ?
                    "": selectedFile.getLocationURI().toString()));
            String locString = selectedFile.getLocationURI().toString();
            /*
             * show error windows if necessary
             */
            try{
                boolean last = selectedFiles.indexOf(selectedFile)==selectedFiles.size()-1;
                if(showErrorMessageIfNeeded(p, locString, last )){
                    bld.append(locString);
                    bld.append("--");
                    onePassed=true;
                }
            }catch(CancellationException e){
                return;
            }
            /*
             * refresh all selected resources
             */
            try {
                selectedFile.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
            } catch (CoreException e) {
                //ignore
            }


        }
        /*
         * show for all passed the passed message
         */
        if(onePassed){
            Shell shell = new Shell();
            MessageDialog.openInformation(shell, "EAnnotation Parsing Complete",
                    "Succesfully parsed "+bld.toString());
        }

    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            /*
             * clear old selection
             */
            selectedFiles.clear();
            /*
             * add all selected to selection
             */
            for(Object s: ((IStructuredSelection) selection).toArray()){
                if(s instanceof IFile){
                    selectedFiles.add((IFile)s);
                }
            }

        }
    }

    @Override
    public void setActiveEditor(IAction action, IEditorPart targetEditor) {
        // do nothing

    }

    /**
     * Show an Error window for the given parser and location
     * @param p the given EAnnotationParser, which hold all ErrorMessages
     * @param location the location of the traversed resource
     * @param last is this the last one?
     * @return if error window was shown
     * @throws CancellationException if the user cancels the parsing
     */
    private boolean showErrorMessageIfNeeded(final EAnnotationOCLParser p, final String location, final boolean last) throws CancellationException {
        if(p.getAllOccurredErrorMessages().size()>0){
            org.eclipse.jface.dialogs.TitleAreaDialog dialog = new TitleAreaDialog(new Shell()){
                @Override
                protected Control createDialogArea(Composite parent) {
                    setTitle("EAnnotation Parsing Complete");
                    if(last){
                        setErrorMessage("Error occured during parsing of " + location);
                    }else{
                        setErrorMessage("Error occured during parsing of " + location +"\n Should the parsing process continue?");

                    }
                    Composite par=(Composite) super.createDialogArea(parent);
                    GridLayout lay = new GridLayout(3, false);
                    par.setLayout(lay);
                    parent.setSize(400, 400);
                    /*
                     * remove standard line
                     */
                    par.getChildren()[0].dispose();
                    for(ErrorMessage e: p.getAllOccurredErrorMessages()){
                        Text l = new Text(par, SWT.READ_ONLY |SWT.WRAP);
                        GridData g= new GridData(SWT.BORDER);
                        g.widthHint=200;
                        l.setLayoutData(g);
                        if(e.getMessageString()!=null)
                            l.setText(e.getMessageString());
                        Text l1 = new Text(par, SWT.READ_ONLY|SWT.WRAP);
                        GridData g1= new GridData(SWT.BORDER);
                        g1.widthHint=200;
                        l1.setLayoutData(g1);						
                        if(e.getException()!=null)
                            l1.setText(e.getException().toString());
                        Text l2 = new Text(par, SWT.READ_ONLY|SWT.WRAP);
                        GridData g2= new GridData(SWT.BORDER);
                        g2.widthHint=200;
                        l2.setLayoutData(g2);
                        if(e.getAffectedObject()!=null)
                            l2.setText(e.getAffectedObject().toString());

                    }
                    p.getAllOccurredErrorMessages().clear();
                    setDialogHelpAvailable(false);
                    par.update();
                    return par;
                }

            };
            if(dialog.open()==Dialog.ABORT)
                throw new CancellationException("User canceled parsing");
            return false;
        }else{
            return true;
        }
    }


}
