package com.sap.tc.moin.repository.core.mofrom;



public interface MofRomPhase {

    public void setMoinMofRomServicesImpl( MoinMofRomServicesImpl srv );

    public void createInstances( );

    public void setAttributes( );

    public void loadLinks( );

    public int getNumberOfInstances( );

    public int getNumberOfAssociations( );

    public int getNumberOfLinks( );
}
