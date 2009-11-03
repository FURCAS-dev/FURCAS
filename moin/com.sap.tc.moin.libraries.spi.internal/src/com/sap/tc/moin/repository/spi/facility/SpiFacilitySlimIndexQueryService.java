package com.sap.tc.moin.repository.spi.facility;

import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;

/**
 * The Slim Index Query Service is a minimal query service, which a facility
 * needs to implement. MQL queries are simulated with by means of the
 * functionality provided by this interface.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 */
public interface SpiFacilitySlimIndexQueryService extends SpiMQLQueryService {

    /**
     * Returns all partitions that are linked from the given partition
     * <code>fromPri</code> by links of the given association
     * <code>association</code> which are stored in the partition
     * <code>fromPRI</code>.
     * <p>
     * The result set will never contain the <code>fromPRI</code> itself
     * (regardless of intra-partition storage).
     * <p>
     * Note: <code>association</code> can also be the {@link MRI} of an object
     * value attribute link type.
     * 
     * @param queryClientScope Defines the scope for the query (e.g.
     * ClientSpecs, Partitions); must not be <code>null</code>.
     * @param fromPRI The partition where the links are stored; must not be
     * <code>null</code>.
     * @param association The type of the links to regard; must not be
     * <code>null</code>.
     * @return A set of {@link PRI PRIs} or an empty set if nothing was found
     */
    public Set<PRI> getLinkedPartitions( SpiFacilityQueryClientScope queryClientScope, PRI fromPRI, MRI association );

    /**
     * Depending on the <code>mofClasess</code> parameter this method returns
     * the following:
     * <p>
     * 1. <code>mofClasses</code> not empty (size!=0): Returns all direct
     * {@link PRI} partitions of the specified {@link MofClass MofClasses} in
     * the defined scope <code>queryClientScope</code>. No partitions for
     * instances of sub classes!
     * <p>
     * 2. <code>mofClasses</code> empty (size==0): Returns all partitions of all
     * types within an <b>inclusive</b> partition scope defined in
     * <code>queryClientScope</code>
     * <p>
     * The result contains no duplicate {@link PRI PRIs} and no
     * <code>null</code> values. The element order in the returned {@link Set}
     * is arbitrary.
     * 
     * @param queryClientScope Defines the scope for the query (e.g.
     * ClientSpecs, Partitions); must not be <code>null</code>.
     * @param mofClasses Array of {@link MRI MRIs} of MofClasses for which all
     * instances have to be returned; must not be <code>null</code>.
     * @return A Set of {@link PRI PRIs} of the specified {@link MofClass
     * MofClasses}.
     */
    public Set<PRI> getPartitionsOfInstances( SpiFacilityQueryClientScope queryClientScope, MRI[] mofClasses );

    /**
     * Depending on the <code>mofClasses</code> parameter this method returns
     * the following:
     * <p>
     * 1. <code>mofClasses</code> not empty (size!=0): Returns all direct
     * {@link MRI} instances of the specified {@link MofClass MofClasses} in the
     * defined scope <code>queryClientScope</code>. No instances of sub classes!
     * <p>
     * 2. <code>mofClasses</code> empty (size==0): Returns all elements of all
     * types within a <b>inclusive</b> partition scope defined in
     * <code>queryClientScope</code>
     * <p>
     * The result contains no duplicate {@link MRI MRIs} and no
     * <code>null</code> values. The element order in the returned
     * {@link Collection} is arbitrary.
     * 
     * @param queryClientScope Defines the scope for the query (e.g.
     * ClientSpecs, Partitions); must not be <code>null</code>.
     * @param mofClasses Array of {@link MRI MRIs} of MofClasses for which all
     * instances have to be returned; must not be <code>null</code>.
     * @return A Collection of {@link MRI MRIs} of the specified
     * {@link MofClass MofClasses}.
     * @throws IllegalArgumentException if <code>mofClasses</code> is empty and
     * query scope exclusive.
     */
    public List<MRI> getInstances( SpiFacilityQueryClientScope queryClientScope, MRI[] mofClasses );

}
