package com.sap.furcas.ide.projectwizard.test;

import static org.junit.Assert.fail;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.ide.projectwizard.util.CreateProject;
import com.sap.furcas.ide.projectwizard.util.ProjectInfo;
import com.sap.furcas.ide.projectwizard.wizards.FurcasWizard;

public class OverallWizardTest {


    @Ignore("Requires an UI test.")
    @Test
    public void wizardTest() {
        ProjectInfo pi = new ProjectInfo();
        GeneratedClassesTest.configureProjectInfo(pi);
        
        String capLangName = CreateProject.capitalizeFirstChar(pi.getLanguageName());
        pi.setModelPath("/" + pi.getProjectName() + ".metamodel/model/" + capLangName + ".ecore");
        pi.setFromWorkspace(true);
        
        FurcasWizard wizard = null;
        try {
            wizard = runWizard(pi);
            if (wizard.isHadError()) {
                fail("Wizard has ERRORs. See console output for details.");
            }
        } finally {
            if (wizard != null) {
                wizard.deleteJunk(pi, new NullProgressMonitor());
            }
        }
    }

    private FurcasWizard runWizard(ProjectInfo pi) {
        FurcasWizard wizard = new FurcasWizard();
        wizard.structuredProcess(pi, new NullProgressMonitor());
        return wizard;

    }

}
