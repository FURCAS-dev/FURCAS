package com.sap.finex.expressionpad.views;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Block;
import behavior.actions.NamedValue;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.expressionpad.FinexEvaluator;
import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.runlet.abstractexpressionpad.views.ConsoleView;

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

public class FinexConsoleView
extends ConsoleView<Association, Field, FinexClass, Type, FinexClass,
Statement, Expression, SignatureImplementation, FinexStackFrame,
NativeImpl, FinexInterpreter, Block, NamedValue> {

    /**
     * The constructor.
     */
    public FinexConsoleView() {
	super(new FinexBlockService());
    }

    @Override
    protected void createEvaluator() {
	evaluator = new FinexEvaluator("finex.stdlib", //$NON-NLS-1$
	    com.sap.finex.interpreter.Activator.getDefault().getRunletDataStore());
    }

    @Override
    protected void shutdownHTTPServer() {
    }

    @Override
    protected void reloadHttp() {
    }

    @Override
    protected void initializeHTTPServer() {
    }

    @Override
    protected String getLanguageName() {
	return "Paradigm5";
    }
}