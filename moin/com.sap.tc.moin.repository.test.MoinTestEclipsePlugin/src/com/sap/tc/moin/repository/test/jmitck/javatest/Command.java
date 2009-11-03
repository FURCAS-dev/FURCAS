// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Command.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.PrintWriter;

// Referenced classes of package com.sun.javatest:
//            Status

public abstract class Command {

    public Command( ) {

    }

    public abstract Status run( String as[], PrintWriter printwriter, PrintWriter printwriter1 );

    public void setClassLoader( ClassLoader classloader ) {

        loader = classloader;
    }

    public ClassLoader getClassLoader( ) {

        return loader;
    }

    private ClassLoader loader;
}
