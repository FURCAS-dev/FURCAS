package com.sap.ide.cts.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class PrettyPrintPreviewDialog extends Dialog
{
	private boolean startPrettyPrinter;
	private String title;
	private String error;
	private String oldVersionOfClass;
	private String newVersionOfClass;
	
	public PrettyPrintPreviewDialog(String title, String error, String oldVersionOfClass, String newVersionOfClass)
	{
		super(Display.getCurrent().getActiveShell(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE);
		this.title = (title != null) ? title : "";
		this.startPrettyPrinter = false;
		this.error = (error != null) ? error : "";
		this.oldVersionOfClass = (oldVersionOfClass != null) ? oldVersionOfClass : "";
		this.newVersionOfClass = (newVersionOfClass != null) ? newVersionOfClass : "";
	}
	
	public boolean open()
	{
		Shell shell = new Shell(getParent(), getStyle());
	    shell.setText(this.title);
	    createContents(shell);
	    shell.pack();
	    shell.open();
	    Display display = getParent().getDisplay();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
		return this.startPrettyPrinter;
	}
	
	private void createContents(final Shell shell)
	{
		shell.setLayout(new GridLayout(2, false));
		
		Text errorField = new Text(shell, SWT.ERROR | SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		errorField.setText(this.error);
		GridData g1 = new GridData(SWT.FILL, SWT.TOP, true, false);
		g1.horizontalSpan = 2;
		errorField.setLayoutData(g1);
		
		Label oldVersionLabel = new Label(shell, SWT.NONE);
		oldVersionLabel.setText("Old Version of Class: ");
		oldVersionLabel.setLayoutData(new GridData(SWT.FILL, SWT.LEFT, true, false));
		
		Label newVersionLabel = new Label(shell, SWT.NONE);
		newVersionLabel.setText("New Version of Class: ");
		newVersionLabel.setLayoutData(new GridData(SWT.FILL, SWT.LEFT, true, false));
		
		Text oldVersionField = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		oldVersionField.setText(this.oldVersionOfClass);
		oldVersionField.setEditable(true);
		oldVersionField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		Text newVersionField = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		newVersionField.setText(this.newVersionOfClass);
		newVersionField.setEditable(true);
		newVersionField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		Label prettyPrintLabel = new Label(shell, SWT.NONE);
		prettyPrintLabel.setText("Do you want to start the pretty printer?");
		GridData g2 = new GridData(SWT.CENTER, SWT.CENTER, true, false);
		g2.horizontalSpan = 2;
		prettyPrintLabel.setLayoutData(g2);
		
		Button buttonOK = new Button(shell, SWT.PUSH);
		buttonOK.setText("OK");
		buttonOK.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false));
		if(this.newVersionOfClass.startsWith("Error"))
		{
			buttonOK.setEnabled(false);
		}
		buttonOK.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent e)
			{
				startPrettyPrinter = true;
				shell.close();
			}
		});
		
		Button buttonCancel = new Button(shell, SWT.PUSH);
		buttonCancel.setText("Cancel");
		buttonCancel.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false));
		buttonCancel.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent e)
			{
				shell.close();
			}
		});
		
		shell.setDefaultButton(buttonOK);
	}
}
