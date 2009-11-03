package com.sap.river.expressionpad.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class LaunchConfigTabGroup extends  AbstractLaunchConfigurationTabGroup {
    @Override
    public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
	ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
		new RunletMainTab(),
		new CommonTab() };
	setTabs(tabs);
    }
}
