package com.sap.ide.refactoring.op.rename;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class RenameInputPage extends UserInputWizardPage {

    private Text textField;

    public RenameInputPage(String name) {
	super(name);
    }

    @Override
    protected RenameRefactoring getRefactoring() {
	return (RenameRefactoring) super.getRefactoring();
    }

    @Override
    public void createControl(Composite parent) {
	Composite superComposite = new Composite(parent, SWT.NONE);
	setControl(superComposite);
	initializeDialogUnits(superComposite);
	superComposite.setLayout(new GridLayout());
	Composite composite = new Composite(superComposite, SWT.NONE);
	composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	layout.marginHeight = 0;
	layout.marginWidth = 0;

	composite.setLayout(layout);

	Label label = new Label(composite, SWT.NONE);
	label.setText("New Name:");

	Text textField = createTextInputField(composite);
	textField.setText(getRefactoring().getOldModelElementName());
	
	GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	gd.widthHint = convertWidthInCharsToPixels(25);
	textField.setLayoutData(gd);
	
	textField.setFocus();
	textField.selectAll();
    }

    protected Text createTextInputField(Composite parent) {
	textField = new Text(parent, SWT.BORDER);
	textField.addModifyListener(new ModifyListener() {
	    public void modifyText(ModifyEvent e) {
		textModifiedCallback(textField.getText().trim());
	    }
	});
	return textField;
    }
    
    protected RefactoringStatus validateTextField(String text) {
	return getRefactoring().setNewModelElementName(text);
    }

    protected void textModifiedCallback(String text) {
	RefactoringStatus status = validateTextField(text);
	setPageComplete(status);
    }

}
