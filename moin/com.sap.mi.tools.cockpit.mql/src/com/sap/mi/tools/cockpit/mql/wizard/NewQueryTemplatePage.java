package com.sap.mi.tools.cockpit.mql.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.model.Model;

/**
 * @author d003456
 * 
 */
public class NewQueryTemplatePage extends WizardPage {

	private static final String LIFT_TEXT_WIDGET_NAME = "com.sap.mi.tools.cockpit.mql.wizard.queryTemplateNameText"; //$NON-NLS-1$

	private static final String LIFT_WIDGET_NAME_KEY = "name"; //$NON-NLS-1$

	private Text queryTemplateNameText;

	private Label templateLabel;

	private Composite queryTemplateNameComposite;

	/**
	 * Create the wizard
	 */
	public NewQueryTemplatePage() {

		super("wizardPage"); //$NON-NLS-1$
		setDescription(Messages.NewQueryTemplatePage_0_xtxt);
		setTitle(Messages.NewQueryTemplatePage_1_xhed);
	}

	/**
	 * Create contents of the wizard
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {

		final Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		container.setLayout(gridLayout);
		setControl(container);

		this.queryTemplateNameComposite = new Composite(container, SWT.NONE);
		this.queryTemplateNameComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 2;
		this.queryTemplateNameComposite.setLayout(gridLayout_1);

		this.templateLabel = new Label(this.queryTemplateNameComposite, SWT.NONE);
		this.templateLabel.setText(Messages.NewQueryTemplatePage_2_xfld);

		this.queryTemplateNameText = new Text(this.queryTemplateNameComposite, SWT.BORDER);
		this.queryTemplateNameText.setData(NewQueryTemplatePage.LIFT_WIDGET_NAME_KEY, NewQueryTemplatePage.LIFT_TEXT_WIDGET_NAME);
		this.queryTemplateNameText.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {

				setErrorMessage(null);
				setMessage(null);
				if (NewQueryTemplatePage.this.queryTemplateNameText.getText().equals("")) { //$NON-NLS-1$
					setErrorMessage(Messages.NewQueryTemplatePage_4_xmsg);
					setPageComplete(false);
				} else if (Model.getInstance().lookUp(NewQueryTemplatePage.this.queryTemplateNameText.getText())) {
					setErrorMessage(Messages.NewQueryTemplatePage_5_xmsg);
					setPageComplete(false);
				} else if (NewQueryTemplatePage.this.queryTemplateNameText.getText().length() > 0) {
					setMessage(Messages.NewQueryTemplatePage_6_xmsg);
					setPageComplete(true);
				}
			}
		});
		this.queryTemplateNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	/**
	 * @return the queryTemplateNameText
	 */
	public String getQueryTemplateNameText() {

		return this.queryTemplateNameText.getText();
	}

}
