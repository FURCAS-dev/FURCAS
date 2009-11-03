package com.sap.mi.fwk.ui.test.tree;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.sap.tc.moin.repository.Connection;

public class ViewerTestDialog extends TitleAreaDialog {

	private String msg = "";

	private Object inputElement;

	private Connection connection;
	private IRefreshMonitor monitor;
	private TestViewer viewer;
	private ITreeContentProvider contentProvider;
	private ILabelProvider labelProvider;

	public ViewerTestDialog(Shell s, String msg, Connection connection, IRefreshMonitor monitor,
			ITreeContentProvider contentProvider, ILabelProvider labelProvider) {
		super(s);
		this.msg = msg;
		this.connection = connection;
		this.monitor = monitor;
		this.contentProvider = contentProvider;
		this.labelProvider = labelProvider;
		setShellStyle(getShellStyle() | SWT.RESIZE | SWT.TITLE);
	}

	@Override
	protected Point getInitialSize() {
		Point size = super.getInitialSize();
		size.y += 100;
		return size;
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent
	 *            the parent composite
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Creates the dialog's contents
	 * 
	 * @param parent
	 *            the parent composite
	 * @return Control
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		parent.setData("name", ViewerTestDialog.class.getName());

		// Set the title
		setTitle("Test Dialog");
		// Set the message (if wanted)
		String str = "null";
		if (this.inputElement instanceof RefPackage) {
			str = ((MofPackage) ((RefPackage) this.inputElement).refMetaObject()).getName();
		} else if (this.inputElement instanceof RefObject) {
			str = ((MofClass) ((RefObject) this.inputElement).refMetaObject()).getName();
		} else {
			str = String.valueOf(this.inputElement);
		}

		setMessage("Viewer " + msg + "\nObject :" + str, IMessageProvider.INFORMATION);
		// Set an image if required // if (image != null)
		// setTitleImage(image);
		return contents;
	}

	/**
	 * Creates the gray area
	 * 
	 * @param parent
	 *            the parent composite
	 * @return Control
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridData gdx = new GridData(SWT.FILL, SWT.FILL, true, true);
		composite.setLayoutData(gdx);
		viewer = new TestViewer(composite, this.connection, this.monitor);
		viewer.setContentProvider(this.contentProvider);
		viewer.setLabelProvider(this.labelProvider);
		viewer.setInput(this.inputElement);
		viewer.expandAll();
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.minimumWidth = 200;
		gd.minimumHeight = 300;
		viewer.getTree().setLayoutData(gd);
		return composite;
	}

	/**
	 * Show the dialog modal, return Selected Object or null ( cancel / nothing
	 * selected )
	 * 
	 * @return
	 */
	public Object show() {
		if (this.open() == IDialogConstants.OK_ID) {
			return this.inputElement;
		}
		return null; // cancel;
	}

	public void setInput(Object input) {
		if (viewer != null) {
			viewer.setInput(input);
		}
		inputElement = input;
	}

	private static class TestViewer extends TreeViewer {
		private IRefreshMonitor monitor = null;

		TestViewer(Composite parent, Connection connection, IRefreshMonitor cb) {
			super(parent);
			monitor = cb;
		}

		@Override
		public void refresh() {
			monitor.refresh(null, false);
			super.refresh();
		}

		@Override
		public void refresh(Object element) {
			monitor.refresh(element, false);
			super.refresh(element);
		}

		@Override
		public void refresh(Object element, boolean updateLabels) {
			monitor.refresh(element, updateLabels);
			super.refresh(element, updateLabels);
		}
	}

	public static interface IRefreshMonitor {
		void refresh(Object element, boolean updateLabels);
	}
}
