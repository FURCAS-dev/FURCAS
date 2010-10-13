/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.eclipse.emf.common.command.CommandStack;

/**
 *
 */
public class ConnectionStub implements Connection {

    public MQLProcessor mqlProcessor;
    public OclRegistryService oclRegistry;
    private SessionStub sessionStub = new SessionStub() {};

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#close()
     */
    public void close() {
        fail("not implemented yet");

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#createElementInPartition(com.sap.tc.moin.repository.jmi.descriptors.ClassDescriptor, com.sap.tc.moin.repository.ModelPartition)
     */
    public <T extends RefObject> T createElementInPartition(
            ClassDescriptor<? extends RefClass, T> classDescriptor,
            ModelPartition partition) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#createElementInPartition(java.lang.Class, com.sap.tc.moin.repository.ModelPartition)
     */
    public <T extends RefObject> T createElementInPartition(Class<T> clazz,
            ModelPartition partition) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#createPartition(com.sap.tc.moin.repository.PRI)
     */
    public ModelPartition createPartition(PRI pri)
            throws InvalidResourceIdentifierException,
            PartitionCreatingNotPossibleException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#deepCopy(java.util.Collection, com.sap.tc.moin.repository.DeepCopyPolicyHandler, boolean)
     */
    public DeepCopyResultSet deepCopy(Collection<RefObject> elementsToBeCopied,
            DeepCopyPolicyHandler policyHandler,
            boolean includeExternalCompositeParents) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#elementExists(com.sap.tc.moin.repository.MRI)
     */
    public boolean elementExists(MRI mri) {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#elementExists(com.sap.tc.moin.repository.LRI)
     */
    public boolean elementExists(LRI lri) {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getAssociation(com.sap.tc.moin.repository.jmi.descriptors.AssociationDescriptor)
     */
    public <T extends RefAssociation> T getAssociation(
            AssociationDescriptor<T> associationDescriptor) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getClass(com.sap.tc.moin.repository.jmi.descriptors.ClassDescriptor)
     */
    public <T extends RefClass> T getClass(
            ClassDescriptor<T, ? extends RefObject> classDescriptor) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getCommandStack()
     */
    public CommandStack getCommandStack() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getConsistencyViolationListenerRegistry()
     */
    public ConsistencyViolationListenerRegistry getConsistencyViolationListenerRegistry() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getElement(com.sap.tc.moin.repository.MRI)
     */
    public RefBaseObject getElement(MRI mri) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getElement(com.sap.tc.moin.repository.LRI)
     */
    public RefBaseObject getElement(LRI lri) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getEventRegistry()
     */
    public EventRegistry getEventRegistry() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getId()
     */
    public String getId() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getJmiHelper()
     */
    public JmiHelper getJmiHelper() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getLabel()
     */
    public String getLabel() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getMQLProcessor()
     */
    public MQLProcessor getMQLProcessor() {
        return mqlProcessor;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getNullPartition()
     */
    public ModelPartition getNullPartition() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getOclRegistryService()
     */
    public OclRegistryService getOclRegistryService() {
        return oclRegistry;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getOrCreateTransientPartition(java.lang.String)
     */
    public ModelPartition getOrCreateTransientPartition(String partitionName)
            throws IllegalArgumentException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getPackage(com.sap.tc.moin.repository.jmi.descriptors.PackageDescriptor)
     */
    public <T extends RefPackage> T getPackage(
            PackageDescriptor<T> packageDescriptor) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getPackage(java.lang.String, java.lang.String[])
     */
    public RefPackage getPackage(String modelContainerName,
            String... qualifiedName) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getPartition(com.sap.tc.moin.repository.PRI)
     */
    public ModelPartition getPartition(PRI pri) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getPartitionsToBeSaved()
     */
    public Collection<ModelPartition> getPartitionsToBeSaved() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getReferencedTransientElements()
     */
    public Collection<MRI> getReferencedTransientElements() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getSession()
     */
    public Session getSession() {
        return sessionStub;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getTransientPartitions()
     */
    public Collection<ModelPartition> getTransientPartitions() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getXmiReader()
     */
    public XmiReader getXmiReader() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getXmiWriter()
     */
    public XmiWriter getXmiWriter() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#hasReferencedTransientElements()
     */
    public boolean hasReferencedTransientElements() {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#isAlive()
     */
    public boolean isAlive() {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#isDirty()
     */
    public boolean isDirty() {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#isLegalNameForTransientPartition(java.lang.String)
     */
    public boolean isLegalNameForTransientPartition(String partitionName) {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#partitionExists(com.sap.tc.moin.repository.PRI)
     */
    public boolean partitionExists(PRI pri) {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#revert()
     */
    public void revert() {
        fail("not implemented yet");

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#save()
     */
    public void save() throws PartitionsNotSavedException,
            NullPartitionNotEmptyException,
            ReferencedTransientElementsException {
        fail("not implemented yet");
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#setLabel(java.lang.String)
     */
    public void setLabel(String label) {
        fail("not implemented yet");

    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#hasCrossPartitionLinks(com.sap.tc.moin.repository.PRI, com.sap.tc.moin.repository.PRI[])
     */
    public boolean hasCrossPartitionLinks(PRI priOne, PRI... otherPris) {
        fail("not implemented yet");
        return false;
    }

	@Override
	public <T extends RefObject> T createElement(
			com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor<? extends RefClass, T> classDescriptor) {
        fail("not implemented yet");
        return null;
	}

	@Override
	public <T extends RefObject> T createElement(Class<T> clazz) {
        fail("not implemented yet");
        return null;
	}


	@Override
	public ModelExporter createModelExporter(
			XmSerializerConfiguration configuration) {
        fail("not implemented yet");
		return null;
	}

	@Override
	public ModelImporter createModelImporter(XmParserConfiguration configuration) {
        fail("not implemented yet");
		return null;
	}

	@Override
	public void enableMemoryChangeOnly() {
        fail("not implemented yet");
	}

	@Override
	public <T extends RefBaseObject> T getMetamodelElement(
			MetamodelElementDescriptor<T> metamodelElementDescriptor) {
        fail("not implemented yet");
		return null;
	}

	@Override
	public boolean isMemoryChangeOnlyEnabled() {
        fail("not implemented yet");
		return false;
	}


}
