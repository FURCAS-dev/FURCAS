package de.hpi.sam.bp2009.benchframework.loopOperator.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.StartOperator;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject;
import de.hpi.sam.bp2009.benchframework.testrunWizard.TestframeworkWizard;

public class LoopOperatorEndWizardPage extends WizardPage {
	private static final String PAGETITLE	=	"Loop Configuration";
	private static final String PAGEDESC	=	"Set the options for the Loop.";
	private static final String TEXTLABEL	=	"Loop Count:";
	private static final String COMBOLABEL	= 	"Associated Start Operator:";

	private LoopOperatorOptionObject option;
	private Text textarea;
	private Combo combo;

	protected LoopOperatorEndWizardPage(String pageName) {
		super(pageName);
		setTitle(PAGETITLE);
		setDescription(PAGEDESC);
		setPageComplete(false);
	}

	public LoopOperatorEndWizardPage(LoopOperatorOptionObject option) {
		this(PAGETITLE);
		this.option = option;
	}

	@Override
	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		Label txtlabel = new Label(composite, SWT.NONE);
		txtlabel.setText(TEXTLABEL);
		textarea = new Text(composite, SWT.NONE);
		textarea.setSize(80, 10);
		textarea.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				int times;
				try {
					times = Integer.parseInt(textarea.getText());
					option.setLoopCount(times);
				} catch (NumberFormatException e1) {
					option.setLoopCount(0);
					textarea.setText("0");
				}			
			}
		});
		Label cmblabel = new Label(composite, SWT.NONE);
		cmblabel.setText(COMBOLABEL);
		combo = new Combo(composite, SWT.NONE);
		final EList<StartOperator> startOperatorList = ((TestframeworkWizard)getWizard()).getRun().getStartOperators();
		for (Operator op : startOperatorList){
			combo.add(op.getName());
		}
		combo.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				option.setOtherEnd(startOperatorList.get(combo.getSelectionIndex()));
				((LoopOperatorOptionObject)(option.getOtherEnd().getOption())).setOtherEnd(option.getOperator());
			}
		});
		setControl(composite);
	}
	@Override
	public boolean canFlipToNextPage() {
		return true;
	}
}
