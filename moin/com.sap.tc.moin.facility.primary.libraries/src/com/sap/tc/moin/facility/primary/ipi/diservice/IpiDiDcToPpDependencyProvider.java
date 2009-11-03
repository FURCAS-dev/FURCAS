package com.sap.tc.moin.facility.primary.ipi.diservice;

public interface IpiDiDcToPpDependencyProvider {

    boolean isVisibleForBuildTime( );

    IpiDiPublicPartProvider getPublicPart( );

}
