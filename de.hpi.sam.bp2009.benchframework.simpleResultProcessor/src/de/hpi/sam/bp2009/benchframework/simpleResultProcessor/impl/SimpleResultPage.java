/**
 * 
 */
package de.hpi.sam.bp2009.benchframework.simpleResultProcessor.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultObject;

/**
 * @author Philipp
 *
 */
public class SimpleResultPage extends WizardPage {
	private static final String PAGENAME = "Simple Result View";
	private static final String PAGETITLE	=	"Simple Result View";
	private static final String PAGEDESC	=	"All Results generated";

	private EList<Operator> ops;
	private Composite composite;

	/**
	 * @return the ops
	 */
	public EList<Operator> getOps() {
		return ops;
	}
	/**
	 * @param ops the ops to set
	 */
	public void setOps(EList<Operator> ops) {
		this.ops = ops;
		composite.layout(true, true);
	}
	/**
	 * @param pageName
	 */
	public SimpleResultPage(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
	}
	public SimpleResultPage( EList<Operator> ops){
		super(PAGENAME);
		setTitle(PAGETITLE);
		setDescription(PAGEDESC);
		this.ops=ops;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		//create the widgets for the page
		composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		for(Operator o:ops){
			ResultObject r = o.getResult();
			Label label1 = new Label(composite, SWT.CENTER);
			label1.setText(o.getName());
			r.getComposite(composite).layout();
		}

		setControl(composite);
		composite.layout();
	}

}
