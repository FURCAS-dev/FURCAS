package com.sap.junit;

import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import com.sap.junit.Staged.StageLevel;

public class MoinStatement extends Statement {
    
    private final FrameworkMethod fTestMethod;
    private Object fTarget;
    private final RunNotifier runNotifier;
    private final Description description;

    public MoinStatement(FrameworkMethod method, Object test,
            RunNotifier notifier, Description desc) {
                fTestMethod = method;
                fTarget = test;
                this.runNotifier = notifier;
                this.description = desc;
    }

    @Override
    public void evaluate() throws Throwable {
        boolean doExecute = true;

        StageLevel paramStageType = MoinRunner.MoinClassMethodRunner.getStageTypeParameterValue( );
        Staged staged = fTestMethod.getAnnotation( Staged.class );
        StageLevel annotStageType = ( staged == null ) ? StageLevel.CENTRAL : staged.value( );

        // check method should be invoked
        if ( paramStageType != StageLevel.ALL ) {
            if ( annotStageType != paramStageType ) {
                doExecute = false;
            }
        }

        CheckPropertyFile usePropertyFile = fTestMethod.getAnnotation( CheckPropertyFile.class );

        if ( usePropertyFile == null ) {
            // ignore it
        } else if ( !MoinRunner.MoinClassMethodRunner.loadPropertyFile( usePropertyFile ) ) {
            // file has been required but could not be found
            doExecute = false;
        }

        if ( doExecute ) {
            fTestMethod.invokeExplosively(fTarget);
        } else {
            runNotifier.fireTestIgnored( description );
        }
    }

}
