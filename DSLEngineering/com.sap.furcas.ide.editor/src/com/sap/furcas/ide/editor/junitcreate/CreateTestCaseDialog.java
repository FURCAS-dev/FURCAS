package com.sap.furcas.ide.editor.junitcreate;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.sap.furcas.ide.editor.CtsActivator;

/**
 * Create TestCase UI component.
 * 
 * @see com.sap.furcas.ide.editor.junitcreate
 * @see com.sap.furcas.ide.editor.action.CreateTestCaseAction
 * 
 * @author D049157
 * 
 */
public class CreateTestCaseDialog extends Dialog {

    private Text descTextBox;
    private Text nameTextBox;
    private String testCaseName;
    private String testDescription;
    
    private Button currentRadio;
    private Button completedRadio;
    private SnapshotVersion version;

    protected CreateTestCaseDialog(IShellProvider parentShell) {
	super(parentShell);
    }

    protected CreateTestCaseDialog(Shell parentShell) {
	super(parentShell);
    }

    public static CreateTestCaseDialog createDialog() {
	Shell shell = CtsActivator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
	CreateTestCaseDialog diag = new CreateTestCaseDialog(shell);
	diag.setShellStyle(SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.RESIZE);
	diag.setBlockOnOpen(true);
	return diag;
    }

    @Override
    protected void configureShell(Shell newShell) {
	super.configureShell(newShell);
	newShell.setText("Create JUnit TestCase");
	newShell.setSize(450, 350);
	Rectangle displayBounds = Display.getCurrent().getBounds();
	newShell.setLocation((displayBounds.width - newShell.getSize().x) / 2, (displayBounds.height - newShell.getSize().y) / 2);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
	Composite composite = (Composite) super.createDialogArea(parent);
	GridLayout gridLayout = new GridLayout(1, false);
	composite.setLayout(gridLayout);

	// Explanation
	Label explanationLabel = new Label(composite, SWT.WRAP);
	explanationLabel.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
	explanationLabel.setText("Confirm this dialog to copy model and textblock elements"
		+ " of this document to new partitions and to place a generated TestCase in your clipboard.\n\n");

	// Name
	Label nameLabel = new Label(composite, SWT.NULL);
	nameLabel.setText("TestCase Name");
	nameTextBox = new Text(composite, SWT.SINGLE | SWT.BORDER);
	nameTextBox.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
	nameTextBox.setText("myTestCase");
	
	// Snapshot Version
	Label snapshotLabel = new Label(composite, SWT.NULL);
	snapshotLabel.setText("History/Snapshot Version");
	currentRadio = new Button(composite, SWT.RADIO);
	currentRadio.setText("Problematic state is not yet saved.");
	currentRadio.setToolTipText("Create TestCase based on the input since the last savepoint. " +
		"Running the test will lead to a state as you see it right now in your editor.");
	completedRadio = new Button(composite, SWT.RADIO);
	completedRadio.setText("Problematic state is alread saved.");
	completedRadio.setToolTipText("Create TestCase based on the input between the last two savepoints. " +
		"The generated code contains all actions done before the latest, successfull save.");
	completedRadio.setSelection(true);

	// Description
	Label sysNrLabel = new Label(composite, SWT.NULL);
	sysNrLabel.setText("Describe your problem");
	descTextBox = new Text(composite, SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
	descTextBox.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
	return composite;
    }

    @Override
    protected void okPressed() {
	testCaseName = nameTextBox.getText();
	testDescription = descTextBox.getText();
	
	if (completedRadio.getSelection()) {
		version = SnapshotVersion.COMPLETED;
	} else {
		version = SnapshotVersion.CURRENT;
	}

	super.okPressed();
    }

    public String getName() {
	return testCaseName;
    }

    public String getDescription() {
	return testDescription;
    }
    
    public SnapshotVersion getVersion() {
	return version;
    }

}
