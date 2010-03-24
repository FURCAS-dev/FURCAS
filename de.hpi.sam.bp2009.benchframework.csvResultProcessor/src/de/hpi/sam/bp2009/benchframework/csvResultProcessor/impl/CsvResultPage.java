package de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class CsvResultPage extends WizardPage {
	private static final String PAGENAME = "CSV Result Page";
	private static final String PAGETITLE = "CSV Result Page";
	private static final String PAGEDESCRIPTION = "Save results to a .csv file";
	private static final String TEXTLABEL = "File Name:";
	private static final String BUTTONLABEL = "Browse";
	
	String filePath;
	Text textarea;

	public CsvResultPage(){
		super(PAGENAME);
		setTitle(PAGETITLE);
		setDescription(PAGEDESCRIPTION);
	}

	protected CsvResultPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.None);
		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);
		Label txtlabel = new Label(composite, SWT.NONE);
		txtlabel.setText(TEXTLABEL);
		
		textarea = new Text(composite, SWT.RESIZE);
		//TODO initial resizing would be a nice feature
		textarea.setSize(300, 15);

		textarea.addModifyListener(new ModifyListener() {	
			@Override
			public void modifyText(ModifyEvent e) {
				// update filePath on change
				filePath = textarea.getText();
			}
		});
		
		Button loadButton = new Button(composite, SWT.NONE);
		loadButton.setText(BUTTONLABEL);
		loadButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// open a file dialog
				FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
				String[] filterNames = new String[] {"CSV Files", "All Files (*)"};
				String[] filterExtensions = new String[] {"*.csv", "*"};
				String filterPath = "/";
				String platform = SWT.getPlatform();
				if (platform.equals("win32") || platform.equals("wpf")) {
					filterNames = new String[] {"CSV Files", "All Files (*.*)"};
					filterExtensions = new String[] {"*.csv", "*.*"};
					filterPath = "c:\\";
				}
				dialog.setFilterNames(filterNames);
				dialog.setFilterExtensions(filterExtensions);
				dialog.setFilterPath(filterPath);
				dialog.setFileName("testrun_results");
				textarea.setText(dialog.open());
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});	
		setControl(composite);		
	}
	
	public boolean performFinish() {
		return true;
	}
}
