package com.sap.mi.fwk.ui.test.wizards;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.commands.NavigationCommand;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.wizard.CommandGroupWizard;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * Tests implementation of a {@link CommandGroupWizard}
 */
public class TestCommandGroupWizard extends CommandGroupWizard {

	private TestWizardPage mPage;
	private boolean mUseFailingCommand;
	private boolean mUseNoCommand;

	public TestCommandGroupWizard() {
	}

	@Override
	public void addPages() {
		mPage = new TestWizardPage(getView());
		addPage(mPage);
	}

	public void setUseFailingCommand(boolean useFailingCommand) {
		mUseFailingCommand = useFailingCommand;
	}

	public void setUseNoCommand(boolean useNoCommand) {
		mUseNoCommand = useNoCommand;
	}

	@Override
	public String getDescription() {
		return "Test CommandGroup Wizard";
	}

	@Override
	protected Command getFinishCommand() {
		if (mUseNoCommand)
			return null;
		if (mUseFailingCommand) {
			return new FailingCommand(getConnection());
		}
		// use original connection stored in the selection
		// since wizard connection is closed, which causes troubles
		// in asychronous GotoViewCommand below
		View view = (View) ModelAdapterUI.getInstance().getRefObject(getSelection());
		return new GotoViewCommand(view);
	}

	@Override
	public Connection getConnection() {
		return super.getConnection();
	}

	private View getView() {
		Object element = getSelection().getFirstElement();
		View view = ModelAdapterUI.getInstance().resolveInConnection((View) element, getConnection());
		return view;
	}

	private static final class TestWizardPage extends WizardPage {
		private final View mView;

		protected TestWizardPage(View view) {
			super("Test page");
			mView = view;
		}

		public void createControl(Composite parent) {
			setControl(parent);

			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			Composite pane = new Composite(parent, SWT.NONE);
			pane.setLayout(gridLayout);

			Label label = null;
			GridData labelGridData = new GridData();
			labelGridData.verticalAlignment = GridData.BEGINNING;

			label = new Label(pane, SWT.NONE);
			label.setLayoutData(labelGridData);
			label.setText("&View name");

			GridData gridData = new GridData();
			gridData.horizontalAlignment = GridData.FILL;
			gridData.grabExcessHorizontalSpace = true;

			Text nameText = new Text(pane, SWT.BORDER | SWT.FILL);
			nameText.setLayoutData(gridData);
			nameText.setData("name", "TestWizardPage.name");
			nameText.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					String text = ((Text) e.widget).getText();
					mView.setName(text);
				}
			});
			nameText.setFocus();
		}
	}

	private static final class FailingCommand extends Command {
		private FailingCommand(Connection connection) {
			super(connection, "A Command that always fails");
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			throw new RuntimeException("Intentionally fails");
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			return null;
		}
	}

	private static final class GotoViewCommand extends NavigationCommand {
		private final View mView;

		private GotoViewCommand(View view) {
			super(((Partitionable) view).get___Connection());
			this.mView = view;
		}

		@Override
		public void doExecute() {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {
					try {
						ModelEditorManager.getInstance().openEditor(getNavigationObject());
					} catch (PartInitException e) {
						throw new RuntimeException(e);
					}
				}
			});
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			return null;
		}

		@Override
		public RefBaseObject getNavigationObject() {
			return mView;
		}
	}

}
