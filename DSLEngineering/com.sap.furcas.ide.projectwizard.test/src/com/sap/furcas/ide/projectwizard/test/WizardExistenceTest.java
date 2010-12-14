package com.sap.furcas.ide.projectwizard.test;

import static org.junit.Assert.fail;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.junit.Ignore;
import org.junit.Test;

public class WizardExistenceTest {

    /**
     * Note: This test will not work in non headless mode!!
     * It checks the target eclipse workbench wizard registry for the furcas wizard.
     */
    @Ignore
    @Test
    public void checkWizardExistence() {
        String id = "com.sap.furcas.ide.projectwizard.wizards.FurcasWizard";
        if (!checkWizard(id)) {
            fail("The Furcas Project Wizard is not registered in the target eclipse.");
        }
    }

    public boolean checkWizard(String id) {
        // First see if this is a "new wizard".
        IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(id);
        if (descriptor == null) {
            return false;
        }
        return true;

    }

}
