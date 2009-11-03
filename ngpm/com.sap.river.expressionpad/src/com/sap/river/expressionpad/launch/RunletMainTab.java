package com.sap.river.expressionpad.launch;

import java.util.Iterator;
import java.util.logging.Logger;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sap.river.expressionpad.Main;
import com.sap.river.expressionpad.Main.ParseResult;

public class RunletMainTab extends AbstractLaunchConfigurationTab {
    private static Logger log = Logger.getLogger(RunletMainTab.class.getName());
    protected static final String NGPM_STDLIB = "ngpm.stdlib"; //$NON-NLS-1$
    protected static final String EXPRESSION_ATTRIBUTE = "expression"; //$NON-NLS-1$
    protected static final String PROJECT_ATTRIBUTE = "project"; //$NON-NLS-1$
    private Text expression;
    private Text project;
    /**
     * Modify listener that simply updates the owning launch configuration dialog.
     */
    private ModifyListener modifyListener = new ModifyListener() {
	public void modifyText(ModifyEvent evt) {
	    getStandardDisplay().asyncExec(new Runnable() {
		public void run() {
		    updateLaunchConfigurationDialog();
		}
	    });
	}
    };

    @Override
    public void createControl(Composite parent) {
	Composite comp = new Composite(parent, SWT.NONE);
	setControl(comp);
	comp.setLayout(new GridLayout(1, true));
	comp.setFont(parent.getFont());
    	
    	Label projectLabel = new Label(comp, SWT.NONE);
	projectLabel.setText(Messages.RunletMainTab_4);
    	project = new Text(comp, SWT.BORDER);
    	project.setFont(parent.getFont());
    	project.addModifyListener(modifyListener);
    	GridData gd = new GridData(SWT.FILL, SWT.NORMAL, /* grab horizontal */ true, /* grab vertical */ false);
	project.setLayoutData(gd);

	Label heading = new Label(comp, SWT.NONE);
	heading.setText(Messages.RunletMainTab_0);
    	gd = new GridData(SWT.FILL, SWT.NORMAL, /* grab horizontal */ true, /* grab vertical */ false);
	heading.setLayoutData(gd);

	expression = new Text(comp, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
	expression.setFont(parent.getFont());
	expression.addModifyListener(modifyListener);
	gd = new GridData(SWT.FILL, SWT.FILL, /* grab horizontal */ true, /* grab vertical */ true);
    	expression.setLayoutData(gd);

    }

    @Override
    public Image getImage() {
	return new Image(getStandardDisplay(), getClass().getResourceAsStream(
		"/icons/LittleRiver.jpg")); //$NON-NLS-1$
    }

    private static Display getStandardDisplay() {
	Display display = Display.getCurrent();
	if (display == null) {
	    display = Display.getDefault();
	}
	return display;
    }

    @Override
    public String getName() {
	return Messages.RunletMainTab_1; 
    }

    @Override
    public void initializeFrom(ILaunchConfiguration configuration) {
	try {
	    expression.setText(configuration.getAttribute(EXPRESSION_ATTRIBUTE, "")); //$NON-NLS-1$
	    project.setText(configuration.getAttribute(PROJECT_ATTRIBUTE, NGPM_STDLIB)); //$NON-NLS-1$
	} catch (CoreException e) {
	    log.throwing(getClass().getName(), "initializeFrom", e); //$NON-NLS-1$
	}
    }

    @Override
    public void performApply(ILaunchConfigurationWorkingCopy configuration) {
	configuration.setAttribute(EXPRESSION_ATTRIBUTE, expression.getText());
	configuration.setAttribute(PROJECT_ATTRIBUTE, project.getText());
    }

    @Override
    public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	configuration.setAttribute(EXPRESSION_ATTRIBUTE, "");
	configuration.setAttribute(PROJECT_ATTRIBUTE, NGPM_STDLIB);
    }

    @Override
    public boolean isValid(ILaunchConfiguration launchConfig) {
	boolean result = true;
	try {
	    String projectName = launchConfig.getAttribute(PROJECT_ATTRIBUTE, project.getText());
	    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
	    if (project == null || !project.exists()) {
		setErrorMessage(Messages.bind(Messages.RunletMainTab_6, projectName));
		result = false;
	    } else {
		Main main = new Main(projectName);
		ParseResult parseResult = main.parse(launchConfig.getAttribute(EXPRESSION_ATTRIBUTE, expression.getText()));
		if (parseResult.getErrors() != null && parseResult.getErrors().size()>0) {
		    setErrorMessage(parseResult.getErrors().get(0) +
			    ((parseResult.getErrors().size()>1 || (parseResult.getConstraintViolations() != null &&
				    parseResult.getConstraintViolations().size()>0)) ? Messages.RunletMainTab_8 : "")); //$NON-NLS-2$
		    result = false;
		} else if (parseResult.getConstraintViolations() != null && parseResult.getConstraintViolations().size()>0) {
		    Iterator<JmiException> i = parseResult.getConstraintViolations().iterator();
		    setErrorMessage(i.next().getLocalizedMessage()+(i.hasNext() ? Messages.RunletMainTab_10 : "")); //$NON-NLS-2$
		    result = false;
		} else {
		    setMessage(Messages.RunletMainTab_7); // fine
		}
	    }
	} catch (Exception e) {
	    setErrorMessage(e.getLocalizedMessage());
	    result = false;
	}
	result = result && super.isValid(launchConfig);
	if (result) {
	    setErrorMessage(null);
	}
	return result;
    }
}
