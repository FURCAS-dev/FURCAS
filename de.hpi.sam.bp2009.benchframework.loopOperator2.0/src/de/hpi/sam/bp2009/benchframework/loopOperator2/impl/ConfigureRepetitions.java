package de.hpi.sam.bp2009.benchframework.loopOperator2.impl;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption;

public class ConfigureRepetitions extends WizardPage {
	private static final String PAGETITLE	=	"Loop Configuration";
	private static final String PAGEDESC	=	"Set the options for the Loop.";
	private static final String TEXTLABEL	=	"Loop Count:";

	private LoopOption option;
	private Text textarea;

	protected ConfigureRepetitions(String pageName) {
		super(pageName);
		setTitle(PAGETITLE);
		setDescription(PAGEDESC);
		setPageComplete(false);
	}

	public ConfigureRepetitions(LoopOption option) {
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
					if(times<1){
						option.setRepetitions(1);
						textarea.setText("1");
						textarea.setMessage("A Loop Body has to be executed");
						return;
					}
					option.setRepetitions(times-1);
				} catch (NumberFormatException e1) {
					option.setRepetitions(0);
					textarea.setText("1");
				}			
			}
		});
		setControl(composite);
	}
	@Override
	public boolean canFlipToNextPage() {
		return true;
	}
}
