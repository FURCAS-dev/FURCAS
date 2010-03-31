package com.sap.junit;

import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;



public interface RunnerProxy {

    public abstract void realRun( RunNotifier notifier );

    public abstract Description getDescription( );

}