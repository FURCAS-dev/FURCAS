package com.sap.tc.moin.repository.core;

import java.util.Set;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;

public interface CompoundClientSpecWorkspace extends Workspace {

    public CompoundClientSpec getCompoundClientSpec( );

    public void privateCopyAdded( PRI pri );

    public void privateCopyRemoved( PRI pri );

    public boolean privateCopyExists( PRI pri );

    public Set<PRI> getPrivateCopies( );
}
