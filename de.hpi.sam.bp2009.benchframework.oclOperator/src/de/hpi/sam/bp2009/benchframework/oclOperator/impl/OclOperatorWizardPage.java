package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject;

public class OclOperatorWizardPage extends WizardPage {
	private static final String PAGETITEL	=	"OCL Operator Configuration";
	private static final String PAGEDESC	=	"Set the options for the OCL Operator.";
	private static final String LABELTEXT 	= 	"Enter the Constraint in OCL";
	
	private OclOptionObject option;
	ArrayList<Text> textareas= new ArrayList<Text>();
	private Composite composite;
	private Composite textareacomposite;
	private Text textarea;
	
	protected OclOperatorWizardPage(String pageName) {
		super(pageName);
		setTitle(PAGETITEL);
		setDescription(PAGEDESC);
		
		setPageComplete(false);
	}
	protected OclOperatorWizardPage(String pageName, OclOptionObject option) {
		this(pageName);
		this.option = option;
	}
	public void createControl(Composite parent) {
		//create the widgets for the page
		composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		
		Label label = new Label(composite, SWT.CENTER);
		label.setText(LABELTEXT);
		
		textarea = new Text(composite, SWT.NONE);
		textarea.setSize(400, 10);
	
		Button addButton = new Button(composite, SWT.PUSH);
		addButton.setText("+");
		addButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// add another textarea to the page
				if (textarea.getText() != "") {
					Text txt = new Text(textareacomposite, SWT.UP);
					txt.setText(textarea.getText());
					textarea.setText("");		
					textareas.add(txt);
					textareacomposite.layout();
					composite.layout();
				}
			}
		});
		
		textareacomposite = new Composite(composite, SWT.NONE);
		GridLayout textlayout = new GridLayout(1,false);
		textareacomposite.setLayout(textlayout);
		textareacomposite.setSize(400, 10);
	    setControl(composite);
	    
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return true;
	}
	
	@Override
	public IWizardPage getNextPage() {
		// TODO create an EList with all constraints and pass it to the option object
		EList<String> constraints = new BasicEList<String>();
		for (Text tb: textareas){
			constraints.add(tb.getText());
		}
		if (option==null)
			return super.getNextPage();
		else
			option.setConstraints(constraints);
		return super.getNextPage();
	}
}
