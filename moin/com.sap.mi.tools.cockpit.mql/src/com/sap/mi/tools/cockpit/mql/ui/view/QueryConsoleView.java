package com.sap.mi.tools.cockpit.mql.ui.view;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;

import com.sap.mi.tools.cockpit.mql.ui.form.QueryMasterDetailPart;

/**
 * @author d003456
 * 
 */
public class QueryConsoleView extends ViewPart {

	private QueryMasterDetailPart block = null;

	private FormToolkit toolkit = null;

	private IManagedForm managedForm = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {

		@SuppressWarnings("unused")
		final Composite body;
		this.toolkit = new FormToolkit(parent.getDisplay());
		final ScrolledForm form = this.toolkit.createScrolledForm(parent);
		body = form.getBody();
		form.setAlwaysShowScrollBars(false);
		form.setText(null);
		this.managedForm = new ManagedForm(this.toolkit, form);

		form.getShell().addControlListener(new ControlAdapter() {

			@Override
			public void controlResized(ControlEvent e) {

				form.layout(true);
			}
		});

		form.addControlListener(new ControlAdapter() {

			@Override
			public void controlResized(ControlEvent e) {

				form.layout(true);
			}
		});

		this.block = new QueryMasterDetailPart();
		this.block.createContent(this.managedForm);
		initializeToolBar();
		this.block.getTemplatesViewPart().setFormInput(null);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.ViewPart#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {

		this.block.saveModel();
		super.saveState(memento);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {

		this.block.setFocus();

	}

	private void initializeToolBar() {

		@SuppressWarnings("unused")
		final IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
	}

}
