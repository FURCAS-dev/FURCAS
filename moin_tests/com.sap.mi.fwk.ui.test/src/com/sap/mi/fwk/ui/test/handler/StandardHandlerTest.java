package com.sap.mi.fwk.ui.test.handler;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.HashMap;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISources;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.fwk.ui.handler.DeleteElementsHandler;
import com.sap.tc.moin.repository.Connection;

public class StandardHandlerTest extends ProjectBasedTest {

	/**
	 * @param name
	 */
	public StandardHandlerTest(final String name) {
		super(name);
	}

	private Display display;
	private LShell mShell;
	private LFactory mAbbotFactory;

	final boolean saved[] = new boolean[] { false };

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.mAbbotFactory = FactoryBuilder.newAbbotFactory();
		this.mAbbotFactory.setWaitTimeout(3000);
		this.display = Display.getDefault();
		this.mShell = this.mAbbotFactory.getShell(this.display);

		PDEUtil.prepareWorkbench();
	}

	@SuppressWarnings("unchecked")
	public void testElementsDeleteHandler() {
		Connection con = createConnection();
		RefObject ro = createMock(RefObject.class);
		ro.refDelete();
		expect(ro.get___Connection()).andReturn(con).anyTimes();

		replay(ro);
		final ISelection sel = new StructuredSelection(ro);
		final IEvaluationContext context = new EvaluationContext(null, sel);
		context.addVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME, sel);
		context.addVariable(ISources.ACTIVE_SHELL_NAME, this.mShell.getWidget());
		final ExecutionEvent event = new ExecutionEvent(null, new HashMap(), this, context);

		final AbstractHandler handler = new DeleteElementsHandler();
		final LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				handler.execute(event);
				return null;
			}
		};

		try {
			this.mShell.asyncExec(runnable);
		} catch (final WidgetException e) {
			fail(e);
		}

		LShell dialogShell;
		try {
			dialogShell = waitForDeleteSaveConfirmation(this.mShell);
			pressYes(dialogShell);
		} catch (final Exception e) {
			fail(e);
		}
	}

	protected static final LShell waitForDeleteSaveConfirmation(final LShell parent) throws WidgetException {
		final LShell dialogShell = parent.waitForShowing(parent.childShell().withText("/.*Delete/"));
		assertNotNull("No Dialog shell found", dialogShell);
		return dialogShell;
	}

	protected static final void pressYes(final LShell dialog) throws Exception {
		final LButton button = dialog.button().yes();
		assertNotNull("No Ok button found", button);
		dialog.clickOn(button);
		dialog.waitForClosed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#getDcName()
	 */
	@Override
	protected String getDcName() {
		return "test/" + getClass().getName();
	}
}