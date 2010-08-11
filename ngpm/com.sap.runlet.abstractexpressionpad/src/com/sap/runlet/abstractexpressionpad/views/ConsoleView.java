package com.sap.runlet.abstractexpressionpad.views;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.sap.runlet.abstractexpressionpad.Evaluator;
import com.sap.runlet.abstractexpressionpad.Evaluator.ExecuteResult;
import com.sap.runlet.abstractinterpreter.AbstractRunletInterpreter;
import com.sap.runlet.abstractinterpreter.StackFrame;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public abstract class ConsoleView<LinkMetaObject extends EObject,
LinkEndMetaObject extends EObject, MetaClass extends EObject,
TypeUsage extends EObject, ClassUsage extends TypeUsage,
StatementType extends EObject, ExpressionType extends EObject,
SignatureImplementationType extends EObject,
StackFrameType extends StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType>, 
NativeType extends SignatureImplementationType, 
InterpreterType extends AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>,
BlockType extends SignatureImplementationType,
VariableType extends EObject> extends ViewPart {

    protected Text output;
    private Text errorOutput;
    private Text input;
    private Button evaluateButton;
    
    private final BlockService<BlockType, VariableType, StatementType, TypeUsage> blockService;

    protected Evaluator<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType,
    		SignatureImplementationType, StackFrameType, NativeType, InterpreterType, BlockType> evaluator;

    private FontRegistry fontRegistry;

    protected LinkedList<String> history;
    private int historyPosition = 0;

    Clipboard clipboard;
    private boolean errorOutputShown;
    private int sashPos;

    /*
     * The content provider class is responsible for providing objects to the
     * view. It can wrap existing objects in adapters or simply return objects
     * as-is. These objects may be sensitive to the current input of the view,
     * or ignore it and always show the same content (like Task List, for
     * example).
     */

    /**
     * The constructor.
     * @param blockService TODO
     */
    public ConsoleView(BlockService<BlockType, VariableType, StatementType, TypeUsage> blockService) {
	this.blockService = blockService;
	history = new LinkedList<String>();
    }

    private BlockService<BlockType, VariableType, StatementType, TypeUsage> getBlockService() {
        return blockService;
    }

    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    public void createPartControl(final Composite parent) {

	fontRegistry = new FontRegistry(parent.getDisplay());
	fontRegistry.put("code", new FontData[] { new FontData("Courier New", 10, SWT.NORMAL) }); //$NON-NLS-1$ //$NON-NLS-2$

	clipboard = new Clipboard(parent.getDisplay());

	errorOutputShown = true;

	sashPos = 0;

	// set the layout to a FormLayout
	FormLayout formLayout = new FormLayout();
	parent.setLayout(formLayout);

	output = new Text(parent, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
	output.setEditable(false);
	output.setFont(fontRegistry.get("code")); //$NON-NLS-1$
	output.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_BLACK));
	output.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));
	output.setText(NLS.bind(Messages.RunletConsoleView_3, getLanguageName()));

	output.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.keyCode == SWT.PAUSE) {
		    createJUnitTestCaseInClipboard();
		} else if (e.keyCode == SWT.ESC) {
		    resetConsole();
		}
	    }
	});
	final Sash sash = new Sash(parent, SWT.BORDER | SWT.HORIZONTAL);

	FormData layoutData = new FormData();
	layoutData.left = new FormAttachment(0, 0);
	layoutData.right = new FormAttachment(100, 0);
	layoutData.top = new FormAttachment(0, 0);
	layoutData.bottom = new FormAttachment(sash, 0);
	output.setLayoutData(layoutData);

	final int limit = 50;
	final FormData sashData = new FormData();
	sashData.left = new FormAttachment(0, 0);
	sashData.top = new FormAttachment(50, 0);
	sashData.right = new FormAttachment(100, 0);
	sash.setLayoutData(sashData);

	sash.addListener(SWT.Selection, new Listener() {
	    public void handleEvent(Event e) {
		Rectangle sashRect = sash.getBounds();
		Rectangle shellRect = parent.getClientArea();
		int right = shellRect.height - sashRect.height - limit;
		e.y = Math.max(Math.min(e.y, right), limit);
		if (e.y != sashRect.y) {
		    sashData.top = new FormAttachment(0, e.y);
		    sashPos = e.y;
		    parent.layout();
		}
	    }
	});

	errorOutput = new Text(parent, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
	errorOutput.setEditable(false);
	errorOutput.setFont(fontRegistry.get("code")); //$NON-NLS-1$
	errorOutput.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_BLACK));
	errorOutput.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));

	layoutData = new FormData();
	layoutData.left = new FormAttachment(0, 0);
	layoutData.right = new FormAttachment(100, 0);
	layoutData.top = new FormAttachment(sash, 0);
	layoutData.bottom = new FormAttachment(90, 0);
	errorOutput.setLayoutData(layoutData);

	input = new Text(parent, SWT.SINGLE);
	input.setEditable(true);
	input.setFont(fontRegistry.get("code")); //$NON-NLS-1$
	input.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_BLACK));
	input.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));

	layoutData = new FormData();
	layoutData.left = new FormAttachment(0, 0);
	layoutData.right = new FormAttachment(90, 0);
	layoutData.top = new FormAttachment(errorOutput, 0);
	layoutData.bottom = new FormAttachment(100, 0);
	input.setLayoutData(layoutData);

	input.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.keyCode == SWT.ARROW_UP) {
		    historyPosition++;
		    if (historyPosition >= history.size()) {
			historyPosition = history.size() - 1;
		    } else {
			input.setText(history.get(historyPosition));
		    }
		} else if (e.keyCode == SWT.ARROW_DOWN) {
		    historyPosition--;
		    if (historyPosition < 0) {
			historyPosition = 0;
		    } else {
			input.setText(history.get(historyPosition));
		    }
		} else if (e.keyCode == SWT.Selection) {
		    if (evaluator != null) {
			evaluateStatement();
		    }
		} else if (e.keyCode == SWT.PAGE_UP) {
		    for (Iterator<String> iterator = history.iterator(); iterator.hasNext();) {
			String statement = iterator.next();
			if (statement.startsWith(input.getText().trim())) {
			    input.setText(statement);
			}
		    }
		} else if (e.keyCode == SWT.PAUSE) {
		    createJUnitTestCaseInClipboard();
		} else if (e.keyCode == SWT.ESC) {
		    resetConsole();
		} else if (e.keyCode == SWT.PAGE_DOWN) {
		    FormData errorFD = (FormData) errorOutput.getLayoutData();
		    FormData inputFD = (FormData) input.getLayoutData();
		    FormData evalFD = (FormData) evaluateButton.getLayoutData();
		    FormData sashFD = (FormData) sash.getLayoutData();
		    FormData outputFD = (FormData) output.getLayoutData();
		    if (errorOutputShown) {

			errorFD.bottom = new FormAttachment(0, 0);
			errorOutput.setLayoutData(errorFD);

			inputFD.top = new FormAttachment(output, 0);
			input.setLayoutData(inputFD);

			evalFD.top = new FormAttachment(output, 0);
			evaluateButton.setLayoutData(evalFD);

			outputFD.bottom = new FormAttachment(90, 0);
			output.setLayoutData(outputFD);

			sashFD.top = new FormAttachment(0, 0);
			sash.setLayoutData(sashFD);
		    } else {

			errorFD.bottom = new FormAttachment(90, 0);
			errorOutput.setLayoutData(errorFD);

			inputFD.top = new FormAttachment(errorOutput, 0);
			input.setLayoutData(inputFD);

			evalFD.top = new FormAttachment(errorOutput, 0);
			evaluateButton.setLayoutData(evalFD);

			outputFD.bottom = new FormAttachment(sash, 0);
			output.setLayoutData(outputFD);

			if (sashPos == 0)
			    sashFD.top = new FormAttachment(50, 0);
			else
			    sashFD.top = new FormAttachment(0, sashPos);
			sash.setLayoutData(sashFD);
		    }
		    errorOutputShown = !errorOutputShown;
		    errorOutput.getParent().layout();

		}
	    }
	});

	evaluateButton = new Button(parent, 0);
	evaluateButton.setText(Messages.RunletConsoleView_5);
	evaluateButton.setEnabled(false);

	layoutData = new FormData();
	layoutData.left = new FormAttachment(input, 0);
	layoutData.right = new FormAttachment(100, 0);
	layoutData.top = new FormAttachment(errorOutput, 0);
	layoutData.bottom = new FormAttachment(100, 0);
	layoutData.height = 15;
	evaluateButton.setLayoutData(layoutData);

	hookActions();

	parent.getDisplay().asyncExec(new Runnable() {
	    public void run() {
		try {
		    createEvaluator();
		    initializeHTTPServer();
		    evaluateButton.setEnabled(true);
		    output.setText(NLS.bind(Messages.RunletConsoleView_7, getLanguageName()));
		} catch (Exception e) {
		    output.setText(NLS.bind(Messages.RunletConsoleView_8, getLanguageName()));
		    StringWriter stackTrace = new StringWriter();
		    e.printStackTrace(new PrintWriter(stackTrace));
		    output.append(stackTrace.getBuffer().toString());
		}
	    }

	});

    }

    protected abstract void createEvaluator();
    
    public void dispose() {
	super.dispose();
	shutdownHTTPServer();
	clipboard.dispose();
    }

    protected abstract void shutdownHTTPServer();

    protected abstract void initializeHTTPServer();

    private void hookActions() {
	evaluateButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseUp(MouseEvent e) {
		evaluateStatement();
	    }
	});
    }

    /**
     * Passing the focus request to the viewer's control.
     */
    public void setFocus() {
	input.setFocus();
    }

    private void evaluateStatement() {
	assert evaluator != null;
	String statement = input.getText().trim();
	if (statement.length() > 0) {
	    historyPosition = 0;
	    if (history.size() == 0) {
		history.add(statement);
	    } else if (!history.peek().equals(statement)) {
		history.add(0, statement);
	    }
	    output.append(statement + "\n"); //$NON-NLS-1$
	    try {
		if (statement.charAt(0) == '!') {
		    doEnvironmentInspection(statement);
		} else {
		    doRiverEvaluation(statement);
		}
	    } catch (Exception e1) {
		// TODO can you change to a different color here?
		StringWriter stackTrace = new StringWriter();
		e1.printStackTrace(new PrintWriter(stackTrace));
		output.append(stackTrace.getBuffer().toString());
	    }
	    output.append("> "); //$NON-NLS-1$
	    input.selectAll();
	}
    }

    private void doEnvironmentInspection(String statement) {
	if (statement.equals("!context")) { //$NON-NLS-1$
	    BlockType block = evaluator.getInterpreterOutermostBlockWrapper();
	    output.append(Messages.RunletConsoleView_2);
	    for (VariableType variable : getBlockService().getVariables(block)) {
		output.append(getBlockService().getVariableName(variable));
		output.append(" <" + getBlockService().getVariableType(variable).toString() + ">\n"); //$NON-NLS-1$ //$NON-NLS-2$
	    }
	    output.append(Messages.RunletConsoleView_16);
	    for (StatementType stmnt : getBlockService().getStatements(block)) {
		output.append(stmnt.getClass().toString() + "\n"); //$NON-NLS-1$
	    }
	} else if (statement.equals("!stack")) { //$NON-NLS-1$
	    output.append(Messages.RunletConsoleView_1);
	    output.append(evaluator.getStackFrame().renderAsString());
	} else if (statement.equals("!http_reload")) { //$NON-NLS-1$
	    reloadHttp();
	} else if (statement.equals("!help")) { //$NON-NLS-1$
	    output.append(Messages.RunletConsoleView_23);
	    output.append(Messages.RunletConsoleView_24);
	    output.append(Messages.RunletConsoleView_25);
	    output.append(Messages.RunletConsoleView_26);
	    output.append(Messages.RunletConsoleView_27);
	    output.append(Messages.RunletConsoleView_28);
	    output.append(Messages.RunletConsoleView_29);
	    output.append(Messages.RunletConsoleView_30);
	    output.append(Messages.RunletConsoleView_42);
	} else {
	    output.append(Messages.RunletConsoleView_31 + statement + Messages.RunletConsoleView_32);
	}
	output.append(Messages.RunletConsoleView_33);
    }

    protected abstract void reloadHttp();

    private void doRiverEvaluation(String statement) throws Exception {
	ExecuteResult<LinkEndMetaObject, TypeUsage, ClassUsage> result = evaluator.execute(statement);
	if (result.getErrors().length > 0) {
	    StringBuilder errorString = new StringBuilder(result.getErrors().length * 100);
	    for (String errorMessage : result.getErrors()) {
		errorString.append("  "); //$NON-NLS-1$
		errorString.append(errorMessage);
		errorString.append('\n');
	    }
	    errorOutput.append(errorString.toString());
	}
	for (RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> riverObject : result.getResult()) {
	    StringBuilder resultString = new StringBuilder(result.getResult().length * 30);
	    if (riverObject == null) {
		resultString.append("<null>\n"); //$NON-NLS-1$
	    } else {
		resultString.append(riverObject.toString()).append("\n"); //$NON-NLS-1$
	    }
	    output.append(resultString.toString());
	}
    }

    private void createJUnitTestCaseInClipboard() {
	// 'Pause' Key - Copy JUnit test method to clipboard
	TextTransfer textTransfer = TextTransfer.getInstance();
	Transfer[] transfers = new Transfer[] { textTransfer };
	Object[] data = new Object[] { JavaTestCaseBuilder.buildTestCase(history) };
	clipboard.setContents(data, transfers);
	output.append(Messages.RunletConsoleView_38);
    }

    protected void resetConsole() {
	// 'POS1' Key - Clear history
	evaluateButton.setEnabled(false);
	history.clear();
	shutdownHTTPServer();
	createEvaluator();
	initializeHTTPServer();
	evaluateButton.setEnabled(true);
	output.append(Messages.RunletConsoleView_40);
	evaluateButton.setEnabled(true);
	errorOutput.setText("");
    }

    protected abstract String getLanguageName();
}