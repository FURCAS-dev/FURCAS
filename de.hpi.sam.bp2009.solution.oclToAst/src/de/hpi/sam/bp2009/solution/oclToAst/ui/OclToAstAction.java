package de.hpi.sam.bp2009.solution.oclToAst.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

public class OclToAstAction implements org.eclipse.ui.IEditorActionDelegate{

	private IFile selectedFile=null;

	@Override
	public void run(IAction action) {
		System.out.println("Execute" + selectedFile);
		if(selectedFile!=null){
			EAnnotationOCLParser p = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
			p.convertAnnotations(URI.createURI(
					selectedFile.getLocationURI()==null ?
							 "":selectedFile.getLocationURI().toString()));
			Shell shell = new Shell();
	  		MessageDialog.openInformation(shell, "EAnnotation Parsing Complete",
	 				"Succesfully parsed "+selectedFile.getLocationURI().toString());
		}else{
			
		}
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		selectedFile = null;
		System.out.println("selectionChanged");
		if (selection instanceof IStructuredSelection) {
	 		 IStructuredSelection structuredSelection = (IStructuredSelection) selection;
	  		 selectedFile = (IFile)structuredSelection.getFirstElement();

		}
	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		// TODO Auto-generated methodsetActiveEditor stub
		System.out.println("setActiveEditor");
		
	}


}
