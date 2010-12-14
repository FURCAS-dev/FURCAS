package com.sap.furcas.ide.projectwizard.test;

import static org.junit.Assert.fail;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Test;

import com.sap.furcas.ide.projectwizard.util.ProjectInfo;
import com.sap.furcas.ide.projectwizard.wizards.FurcasWizard;

public class OverallWizardTest {

    @Test
    public void wizardTest() {
        ProjectInfo pi = new ProjectInfo();
        GeneratedClassesTest.configureProjectInfo(pi);
        try {
            runWizard(pi);
        } catch (Exception e) {
            fail("Test failed due to: " + e.getMessage());
        }
    }

    private void runWizard(ProjectInfo pi) {
        FurcasWizard wizard = new FurcasWizard();
        NullProgressMonitor monitor = new NullProgressMonitor();
        wizard.doFinish(pi, monitor);

    }

}
