/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.List;

import com.sap.mi.textual.parsing.MofAnyStub;

/**
 *
 */
public class RefPackageStub implements RefPackage {

    public RefStruct createdStructureType;

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refAllAssociations()
     */
    public Collection<RefAssociation> refAllAssociations() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refAllClasses()
     */
    public Collection<RefClass> refAllClasses() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refAllPackages()
     */
    public Collection<RefPackage> refAllPackages() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refAssociation(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    public RefAssociation refAssociation(RefObject association) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refAssociation(java.lang.String)
     */
    public RefAssociation refAssociation(String associationName) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refClass(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    public RefClass refClass(RefObject type) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refClass(java.lang.String)
     */
    public RefClass refClass(String typeName) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refCreateStruct(com.sap.tc.moin.repository.mmi.reflect.RefObject, java.util.List)
     */
    public RefStruct refCreateStruct(RefObject struct,
            List<? extends Object> params) {
        return createdStructureType;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refCreateStruct(java.lang.String, java.util.List)
     */
    public RefStruct refCreateStruct(String structName,
            List<? extends Object> params) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refDelete()
     */
    public void refDelete() {
        fail("not implemented yet");

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refGetEnum(com.sap.tc.moin.repository.mmi.reflect.RefObject, java.lang.String)
     */
    public RefEnum refGetEnum(RefObject enumType, String name) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refGetEnum(java.lang.String, java.lang.String)
     */
    public RefEnum refGetEnum(String enumName, String name) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refPackage(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    public RefPackage refPackage(RefObject nestedPackage) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefPackage#refPackage(java.lang.String)
     */
    public RefPackage refPackage(String nestedPackageName) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refImmediatePackage()
     */
    public RefPackage refImmediatePackage() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refMetaObject()
     */
    public MofPackage refMetaObject() {
        MofAnyStub metaObject = new MofAnyStub() {
			private static final long serialVersionUID = 5704367395406897627L;};
        return metaObject;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refMofId()
     */
    public String refMofId() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refOutermostPackage()
     */
    public RefPackage refOutermostPackage() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refVerifyConstraints(boolean)
     */
    public Collection<JmiException> refVerifyConstraints(boolean deepVerify) {
        fail("not implemented yet");
        return null;
    }

	@Override
	public void assign___Partition(ModelPartition mp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assign___PartitionIncludingChildren(ModelPartition mp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Connection get___Connection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends RefBaseObject> Class<T> get___JmiInterface() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MRI get___Mri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelPartition get___Partition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean is___Alive() {
		// TODO Auto-generated method stub
		return false;
	}


}
