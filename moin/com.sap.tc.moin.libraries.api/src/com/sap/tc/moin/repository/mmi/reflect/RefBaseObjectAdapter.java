package com.sap.tc.moin.repository.mmi.reflect;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;

/**
 * An adapter for {@link RefBaseObject}, but this adapter is NOT intended for
 * productive use (only for tests etc). The "real" MOIN objects that are
 * instance of {@link RefBaseObject} are NOT instance of
 * {@link RefBaseObjectAdapter}. The methods in this class are empty and return
 * the java default values for methods that have a return type (e.g.
 * <code>null</code> for objects, <code>false</code> for boolean etc.). This
 * class exists mainly as convenience for tests (mock objects). Nobody should
 * directly implement the {@link RefBaseObject} interface as the interface is
 * subject to change and might be extended over time. Therefore, clients
 * directly implementing the {@link RefBaseObject} interface would break. Such
 * clients should rather extend this class instead so they don't have to adjust
 * their implementation if the {@link RefBaseObject} is extended. Using this
 * adapter in "real" MOIN scenarios is not supported and the behavior of MOIN
 * methods working with {@link RefBaseObject}s is undefined if the underlying
 * implementation is this adapter.
 */
public class RefBaseObjectAdapter implements RefBaseObject, Partitionable {

    public RefPackage refImmediatePackage( ) {

        return null;
    }

    public RefObject refMetaObject( ) {

        return null;
    }

    public String refMofId( ) {

        return null;
    }

    public RefPackage refOutermostPackage( ) {

        return null;
    }

    public Collection<JmiException> refVerifyConstraints( boolean deepVerify ) {

        return null;
    }

    public void assign___Partition( ModelPartition mp ) {

    }

    public void assign___PartitionIncludingChildren( ModelPartition mp ) {

    }

    public Connection get___Connection( ) {

        return null;
    }

    public <T extends RefBaseObject> Class<T> get___JmiInterface( ) {

        return null;
    }

    public MRI get___Mri( ) {

        return null;
    }

    public ModelPartition get___Partition( ) {

        return null;
    }

    public boolean is___Alive( ) {

        return false;
    }

}
