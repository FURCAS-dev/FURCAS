package de.hpi.sam.bp2009.randomModelModifier.impl;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject;
import de.hpi.sam.bp2009.randomModelModifier.tasks;

public class RandomModelModifierWizardPage extends WizardPage {
	private static final String PAGETITLE	=	"Random Model Modifier Configuration";
	private static final String PAGEDESC	=	"Set the options for the Random Model Modifier.";
	private static final String TEXTLABEL	=	"Loop Count:";
	private static final String COMBOLABEL	=	"Action:";

	private RandomModelModifierOptionObject option;
	private Text textarea;
	private Combo combo;
	
	protected RandomModelModifierWizardPage(String pageName) {
		super(pageName);
		setTitle(PAGETITLE);
		setDescription(PAGEDESC);
		setPageComplete(false);
	}
	
	public RandomModelModifierWizardPage(String pageName, RandomModelModifierOptionObject option) {
		this(pageName);
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
					option.setTimes(times);
				} catch (NumberFormatException e1) {
					option.setTimes(0);
					textarea.setText("0");
				}			
			}
		});
		
		Label cmblabel = new Label(composite, SWT.NONE);
		cmblabel.setText(COMBOLABEL);
		combo = new Combo(composite, SWT.NONE);
		for (tasks tsk : tasks.VALUES){
			combo.add(tsk.toString());
		}
		combo.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				option.setTask(tasks.get(combo.getSelectionIndex()));	
			}
		});
		setControl(composite);
	}

}
