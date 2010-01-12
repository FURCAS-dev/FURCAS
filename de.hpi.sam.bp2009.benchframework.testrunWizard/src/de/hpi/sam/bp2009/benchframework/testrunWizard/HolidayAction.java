//package de.hpi.sam.bp2009.benchframework.testrunWizard;
//
//import org.eclipse.jface.action.IAction;
//import org.eclipse.jface.viewers.ISelection;
//import org.eclipse.jface.viewers.IStructuredSelection;
//import org.eclipse.jface.wizard.WizardDialog;
//import org.eclipse.ui.IObjectActionDelegate;
//import org.eclipse.ui.IWorkbenchPart;
//
//public class HolidayAction implements IObjectActionDelegate 
//{
//
//	IWorkbenchPart part;
//	ISelection selection;
//
//	/**
//	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
//	 */
//	public void setActivePart(IAction action, IWorkbenchPart part) {
//			this.part = part;
//	}
//
//	/**
//	 * @see IActionDelegate#run(IAction)
//	 * Instantiates the wizard and opens it in the wizard container
//	 */
//	public void run(IAction action) {
//
//		HolidayWizard wizard = new HolidayWizard();
//		if ((selection instanceof IStructuredSelection) || (selection == null))
//		wizard.init(part.getSite().getWorkbenchWindow().getWorkbench(), 
//			(IStructuredSelection)selection);
//
//		WizardDialog dialog = new WizardDialog( part.getSite().getShell(), wizard);
//		dialog.create();
//		dialog.open();
//	}
//
//	/**
//	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
//	 */
//	public void selectionChanged(IAction action, ISelection selection) {
//		this.selection = selection;
//	}
//
//}
