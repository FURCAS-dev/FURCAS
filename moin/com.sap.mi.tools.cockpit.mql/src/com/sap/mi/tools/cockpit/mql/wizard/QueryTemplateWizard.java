package com.sap.mi.tools.cockpit.mql.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.model.Model;
import com.sap.mi.tools.cockpit.mql.model.QueryTemplateNode;
import com.sap.mi.tools.cockpit.mql.model.TEMPLATE_TYPE;

/**
 * @author d003456
 * 
 */
public class QueryTemplateWizard extends Wizard implements INewWizard {

	private final static String CREATE_TEMPLATE_DIALOG_TITLE = Messages.QueryTemplateWizard_0_xhed;

	private NewQueryTemplatePage queryTemplatePage;

	private final Model model;

	/**
	 * Constructor
	 */
	public QueryTemplateWizard() {

		super();
		this.model = Model.getInstance();
		setWindowTitle(QueryTemplateWizard.CREATE_TEMPLATE_DIALOG_TITLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {

		this.queryTemplatePage = new NewQueryTemplatePage();
		addPage(this.queryTemplatePage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {

		final QueryTemplateNode template = new QueryTemplateNode(this.queryTemplatePage.getQueryTemplateNameText(), "?????", //$NON-NLS-1$
				TEMPLATE_TYPE.USER_DEFINED);
		template.setParent(this.model.getRoot());
		this.model.getRoot().addChildren(template);
		return true;
	}
}
