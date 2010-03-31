package com.sap.mi.fwk.ui.test.quickfix;

import com.sap.mi.fwk.ui.resolution.QuickfixCommand;
import com.sap.mi.fwk.ui.test.commands.TestMoinCommand;
import com.sap.tc.moin.repository.commands.Command;

public class Quickfix1 extends QuickfixCommand {

    public String getLabel() {
        return "Test Command";
    }

    public Command getCommand() {
        return new TestMoinCommand(1, getConnection(), "Test Command");
    }
}
