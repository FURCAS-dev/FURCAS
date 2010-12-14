package com.sap.furcas.ide.projectwizard.test;

import static org.junit.Assert.fail;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.ide.projectwizard.util.CreateProject;
import com.sap.furcas.ide.projectwizard.util.ProjectInfo;
import com.sap.furcas.ide.projectwizard.wizards.FurcasWizard;

public class OverallWizardTest {


    @Ignore
    @Test
    public void wizardTest() {
        FurcasWizard wizard = null;
        ProjectInfo pi = new ProjectInfo();
        GeneratedClassesTest.configureProjectInfo(pi);
        String capLangName = CreateProject.capitalizeFirstChar(pi.getLanguageName());
        pi.setModelPath("/" + pi.getProjectName() + ".metamodel/model/" + capLangName + ".ecore");
        pi.setFromWorkspace(true);
        wizard = runWizard(pi);
        if (wizard.isHadError()) {
            fail("Wizard has ERRORs. See console output for details.");
        }
        

    }

    private FurcasWizard runWizard(ProjectInfo pi) {
        FurcasWizard wizard = new FurcasWizard();
        NullProgressMonitor monitor = new NullProgressMonitor();
        wizard.structuredProcess(pi, monitor);
        return wizard;

    }

}
