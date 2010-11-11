package com.sap.ide.cts.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class ChoosePrettyPrintModeDialog extends Dialog
{
	private String title;
	private PrettyPrintingModes selectedMode;
	
	public ChoosePrettyPrintModeDialog()
	{
		super(Display.getCurrent().getActiveShell(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE);
		this.title = "Choose Pretty Printing Mode";
	}
	
	public boolean open()
	{
		Shell shell = new Shell(getParent(), getStyle());
	    shell.setText(this.title);
	    createContents(shell);
	    shell.pack();
	    shell.open();
	    Display display = getParent().getDisplay();
	    while (!shell.isDisposed()) 
	    {
	      if (!display.readAndDispatch()) 
	      {
	        display.sleep();
	      }
	    }
		return true;
	}
	
	private void createContents(final Shell shell)
	{
		shell.setLayout(new GridLayout());
		
		Group buttonGroup = new Group(shell, SWT.SHADOW_IN);
		buttonGroup.setText(this.title);
		buttonGroup.setLayout(new RowLayout(SWT.VERTICAL));
		SelectionListener selectionListener = new SelectionAdapter() 
		{
            public void widgetSelected(SelectionEvent e) 
            {
                selectedMode = (PrettyPrintingModes) ((Button) e.getSource()).getData();
            }
        };
		for(PrettyPrintingModes ppm : PrettyPrintingModes.values())
		{
			Button b = new Button(buttonGroup, SWT.RADIO);
			b.setText(ppm.getValue());
			b.setData(ppm);
			b.addSelectionListener(selectionListener);
		}
		
		Button buttonOK = new Button(shell, SWT.PUSH);
		buttonOK.setText("OK");
		buttonOK.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false));
		buttonOK.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent e)
			{
				shell.close();
			}
		});
	}
	
	public PrettyPrintingModes getSelectedMode()
	{
		return this.selectedMode;
	}
}

//public class ChoosePrettyPrintModeDialog extends AbstractHandler
//{
//
//	@Override
//	public Object execute(ExecutionEvent event) throws ExecutionException
//	{
//		ElementListSelectionDialog dialog = new ElementListSelectionDialog(Display.getCurrent().getActiveShell(), new LabelProvider());
//		Object[] ppModes = PrettyPrintingModes.values();
//		dialog.setTitle("Select Pretty Printing Mode");
//		dialog.setMessage("Select a Mode:");
//		dialog.setElements(ppModes);
//		dialog.open();
//		return dialog.getFirstResult();
//	}
//
//}
