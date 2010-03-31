package com.sap.mi.tools.oclevalview.internal;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LComposite;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LText;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests the ocl evaluation view
 * 
 * @author d024127
 */
public class OCLEvalViewTest extends WebDynproProjectTest {

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/cmdmgr");

	private static final String ID_OCL_VIEW = "com.sap.mi.tools.oclevalview";

	private static final String DC_NAME = "TESTPROJECT-OCLEvalViewTest";

	private LFactory mAbbotFactory;

	private IViewPart mPart;

	private LShell mShell;

	private Display mDisplay;

	private Component component;

	public OCLEvalViewTest() {
		super(OCLEvalViewTest.class.getName());
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ActiveSWTTestSuite.requestScreenShotFor(this);

		PDEUtil.prepareWorkbench();

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);

		mDisplay = Display.getDefault();
		mShell = mAbbotFactory.getShell(mDisplay);

		// maximize view so all buttons can be found
		// will be removed once scrollto is available
		mPart = PDEUtil.showView(ID_OCL_VIEW);
		// PDEUtil.maximizeCurrentView();

		assertTrue("View part is not an OCLEvaluationView", mPart instanceof OCLEvaluationView);
		final OCLEvaluationView evalView = (OCLEvaluationView) mPart;
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				evalView.setObject(null);
				return null;
			}
		});

		Connection connection = createConnection();
		component = createComponent(connection, getProject(), "Component1");
		connection.save();
	}

	@Override
	protected void tearDown() throws Exception {
		// close menu in either case (could still be open in case of disabled menu entry)
		mShell.enter(mAbbotFactory.key().esc());

		// restore view to initial size to prevent side effects with other tests
		// will be removed once scrollto is available
		// PDEUtil.showView(ID_OCL_VIEW);
		// PDEUtil.restoreCurrentView();

		mPart = null;
		mAbbotFactory = null;
		mDisplay = null;
		mShell = null;

		super.tearDown();
	}

	public void testEvalButton() throws Exception {
		assertTrue("View part is not an OCLEvaluationView", mPart instanceof OCLEvaluationView);
		final OCLEvaluationView evalView = (OCLEvaluationView) mPart;

		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				evalView.setObject(null);
				return null;
			}
		});

		LButton button = mShell.button().withText("Evaluate");
		assertFalse("Evaluation button must be disabled", button.isEnabled());
	}

	public void testEvalExpression() throws Exception {
		assertTrue("View part is not an OCLEvaluationView", mPart instanceof OCLEvaluationView);
		final OCLEvaluationView evalView = (OCLEvaluationView) mPart;

		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				evalView.setObject(component);
				return null;
			}
		});

		final LText oclExpression = mShell.text().withSibling(mShell.label().withText("Expression:"), -1);
		oclExpression.setText("self");

		final LButton button = mShell.button().withText("Evaluate");
		assertTrue("Evaluation button must be enabled", button.isEnabled());

		LComposite comp = button.getParent();
		while (!(comp.getWidget() instanceof ScrolledForm)) {
			comp = comp.getParent();
		}

		comp.scrollToVisible(button);
		mShell.clickOn(button);

		LText evalResultText = mShell.text().withSibling(mShell.label().withText("/Result.*/"), -1);
		String evalResult = evalResultText.getText();
		assertTrue("Result does not match expected result", evalResult.contains(component.refMofId()));
	}

	private static Component createComponent(Connection connection, IProject project, String partitionName) {
		PRI pri = getPri(project, PARTITION_FOLDER.append(partitionName));

		ModelPartition partition = connection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(pri);
		assertNotNull("Partition creation failed", partition);

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage(CONTAINER_NAME_WEBDYNPRO, PACKAGE_NAME_COMPONENT);
		Component component = (Component) compPackage.getComponent().refCreateInstance( );
		component.setName("testComponent");
		assertNotNull(component);
		partition.assignElement((Partitionable) component);
		return component;
	}
}