package com.sap.tc.moin.repository;

/**
 * ModelElement resource-identifier. <br>
 * <p>
 * MOIN uses four related types of resource identifiers:
 * </p>
 * <ul>
 * <li>MRI (pronounced like &quot;Mary&quot;)</li>
 * <li>LRI (pronounced like &quot;Larry&quot;)</li>
 * <li>PRI (pronounced like &quot;Perry&quot;)</li>
 * <li>CRI (pronounced like &quot;Cary&quot;)</li>
 * </ul>
 * <p>
 * Why does MOIN use four different identifiers, and how are they related to the
 * Mof-Id, which is supposed to identify a model element uniquely in a MOF
 * repository?
 * </p>
 * <p>
 * The universe of data that a client sees in MOIN is made up of data areas (see
 * {@link com.sap.tc.moin.repository.cdam.CompoundDataArea} for more details).
 * Each data area is identified by its {@link DataAreaDescriptor data area
 * descriptor}, which consists of the name of the facility that hosts the data
 * area and the name of the data area:
 * <p>
 * <b>Data-area Descriptor</b>
 * </p>
 * <ul>
 * <li>facility id</li>
 * <li>data area name</li>
 * </ul>
 * <p>
 * Within one data area, each Mof-Id is normally unique - deviations from this
 * are seen as inconsistencies that have to be resolved somehow.
 * </p>
 * <p>
 * A compound data area may contain two or more data areas that represent e.g.
 * different versions of the same models. In this case, duplicate MofIds will be
 * normal, rather than an inconsistency. For that reason, only the combination
 * of the data area descriptor and the Mof-Id are supposed to be unique. This
 * combination of data area descriptor and Mof-Id is called a LRI:
 * </p>
 * <p>
 * <b>LRI</b>
 * </p>
 * <ul>
 * <li><b>Data-area Descriptor</b></li>
 * <li>Mof-Id</li>
 * </ul>
 * </p>
 * <p>
 * Model data are stored in partitions, which can be edited by different
 * developers individually (in a filesystem-based persistence, a partition is
 * typically mapped to a single file). Each partition belongs to exactly one
 * data area. Further, in order to support dependency management, partitions are
 * grouped into containers; dependencies are managed between the containers
 * only. A container is thus identified by a data area descriptor and its own
 * name, which is realized with the CRI:
 * <p>
 * <b>CRI</b>
 * </p>
 * </p>
 * <ul>
 * <li><b>Data-area Descriptor</b></li>
 * <li>container name</li>
 * </ul>
 * </p> Finally, a partition is identified by the data area descriptor, the
 * container name, and the partition name (which is local to the container).
 * This combination is called PRI.
 * <p>
 * <b>PRI</b>
 * </p>
 * </p>
 * <ul>
 * <li><b>Data-area Descriptor</b></li>
 * <li>container name</li>
 * <li>partition name</li> </li>
 * </ul>
 * </p>
 * <p>
 * Inconsistencies left aside, each model element can be identified by a LRI,
 * and belongs to a partition which is identified by a PRI. Under various
 * conditions it can happen however, that a LRI identifies two or more model
 * elements which have the same Mof-Id and live in different partitions of the
 * same data area. In this case, only the combined information of LRI and PRI
 * identifies the model elements really. This combination is called MRI.
 * </p>
 * <p>
 * <b>MRI</b>
 * </p>
 * <ul>
 * <li><b>Data-area Descriptor</b></li>
 * <li>container name</li>
 * <li>partition name</li>
 * <li>Mof-Id</li>
 * </ul>
 * </p>
 * <p>
 * <b>Class diagram for the Resource Identifiers</b>
 * </p>
 * <p>
 * <img src="doc-files/TAM-API-ResourceIdentifiers.png"/>
 * </p>
 * <p>
 * <b>Serialization format of the Resource Identifiers</b>
 * </p>
 * <p>
 * Data area descriptor: <i>&lt;facility id&gt;</i><b>.</b><i>&lt;data area
 * name&gt;</i>
 * </p>
 * <p>
 * LRI: <i>&lt;</i><i>data area descriptor&gt;</i><b>:</b><i>&lt;Mof-Id&gt;</i>
 * </p>
 * <p>
 * CRI: <i>&lt;</i><i>data area descriptor&gt;</i><b>:</b><i>&lt;container
 * name&gt;</i>
 * </p>
 * <p>
 * PRI: <i>&lt;</i><i>data area descriptor&gt;</i><b>:</b><i>&lt;container
 * name&gt;</i><i>&lt;c_p_separator&gt;</i><i>&lt;partition name&gt;</i>
 * </p>
 * <p>
 * MRI: <i>&lt;</i><i>data area descriptor&gt;</i><b>:</b><i>&lt;container
 * name&gt;</i><i>&lt;c_p_separator&gt;</i><i>&lt;partition
 * name&gt;</i>#<i>&lt;Mof-Id&gt;</i>
 * </p>
 * <b>Example for MRI</b>
 * <p>
 * The primary facility uses <code>/_comp/</code> as separator between the
 * container name and the partition name. Here is an example for a MRI of the
 * Primary Facility:
 * </p>
 * 
 * <pre>
 * PF.DataArea:DCs/sap.com/tc/moin/model/_comp/moin/meta/MyModel#CCE171AF-0F27-155B-B32D-66DE8504
 * </pre>
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface MRI {

    /**
     * Returns a data area descriptor, consisting of a facility type and data
     * area name.
     * 
     * @return the data area descriptor
     */
    public DataAreaDescriptor getDataAreaDescriptor( );

    /**
     * @return the name of the container to which this partition belongs.
     */
    public String getContainerName( );

    /**
     * @return the name of the partition relative to the containing container.
     */
    public String getPartitionName( );

    /**
     * Returns the MOF-id. Returns the MOF-id if the MRI identifies an element
     * within a model partition.
     * <p>
     * Examples (see <a href="#examples">above</a>)
     * <ol>
     * <li><i>null</i></li>
     * <li>CCE171AF-0F27-155B-B32D-66DE8504</li>
     * </ol>
     * 
     * @return MOF id.
     */
    public String getMofId( );

    /**
     * Returns partition resource identifier. Copies all content of the MRI
     * except the MOF id.
     * 
     * @return the partition resource identifier
     */
    public PRI getPri( );

    /**
     * Returns a resource identifier for the container to which this PRI
     * belongs.
     * 
     * @return the container resource identifier.
     */
    public CRI getCri( );

    /**
     * Returns link resource identifier. Copies the data area and MOF id.
     * 
     * @return the link resource identifier
     */
    public LRI getLri( );

    /**
     * <code>mri1.equals(mri2)</code> returns true if
     * 
     * <pre>
     * mri1.toString().equals(mri2.toString)
     * </pre>
     * 
     * (also see {@link java.lang.Object#equals(java.lang.Object)}
     * 
     * @param obj MRI to compare.
     * @return true if MRIs are equal.
     */
    public boolean equals( Object obj );

    /**
     * @return the hashcode
     */
    public int hashCode( );

}
