package com.sap.tc.moin.ocl.parser;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;

/**
 * The OclParser parses OclExpressions and turns them into JMI graphs. It
 * basically accepts 4 types of expressions:
 * <ul>
 * <li>an expression containing one or more package statements e.g. package
 * This::IsAPackage context ... endpackage</li>
 * <li>an expression containing one or more context statements e.g. context
 * ConstrainedClass ...</li>
 * <li>an expression containing one or more constraint statements e.g. inv: ...,
 * post: ... pre: ...</li>
 * <li>an expression containing a simple OclExpression</li>
 * </ul>
 */
public interface IOclParser {

    /**
     * Returns a parsing report.
     * <p>
     * The <code>ParsingReport</code> gives detailed information about errors
     * and warnings. If this is called before parsing was done, an initial
     * (empty) report will be returned.
     * 
     * @return the <code>ParsingReport</code> instance
     */
    public ProcessReport getReport( );

    /**
     * Parses the String representation of an OCL expression.
     * <p>
     * The String is expected to contain <b>at most one </b>
     * <code>package</code> statements and <b>at most one </b>
     * <code>context</code> statements. If no <code>package</code> statement is
     * supplied in the textual representation types are looked up in
     * <code>types</code>. If a <code>package</code> statement is supplied but
     * differs from <code>types</code> an exception will be thrown. If a
     * <code>context</code> statement is supplied but differs from
     * <code>context</code> an exception will be thrown.
     * 
     * @param ocl String representing an OCL statement
     * @param context the context of the statement. If null is provided here, at
     * least one context statement must be contained in <code>ocl</code>.
     * @param types an array of packages to look up types. If null or empty, at
     * least one package statement must be contained in <code>ocl</code>.
     * @return the statements
     * @throws ParsingException the {@link ParsingException}
     */
    public Set<OclStatement> parseString( String ocl, RefObject context, RefPackage[] types ) throws ParsingException;

    /**
     * Mainly used for parsing the MOF constraints; since the helper operations
     * are not modeled in the MOF meta model, they can not be attached to that
     * meta model and must be provided programmatically to the parsing context
     * 
     * @param ocl String representing an OCL expression
     * @param context the parsing context
     * @param types the types packages
     * @param oclDefinedFeatures the features (operations) defined in OCL; may
     * be null
     * @return the parsing result
     * @throws ParsingException the {@link ParsingException}
     */
    public Set<OclStatement> parseString( String ocl, RefObject context, RefPackage[] types, Map<Classifier, Set<Feature>> oclDefinedFeatures ) throws ParsingException;

    /**
     * Used to parse OCL Body expressions
     * 
     * @param oclExpression String representing an OCL statement
     * @param op the operation
     * @param modelElementsByName a Map of Model Elements by name
     * @param modelElementsByOclQualifiedName a Map of Model Elements by
     * qualified name in OCL syntax (i.e. name components are separated by
     * '::').
     * @param oclDefinedFeatures the features (operations) defined in OCL; may
     * be null
     * @return the statements
     * @throws ParsingException the {@link ParsingException}
     */
    public Set<OclStatement> parseString( String oclExpression, Operation op, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) throws ParsingException;

    /**
     * Used to parse the helper operations
     * 
     * @param oclExpression The OCL Expression
     * @param modelElementsByName the ModelElement/Name mapping
     * @param modelElementsByOclQualifiedName the ModelElement/Qualified Name
     * mapping
     * @param oclDefinedFeatures the OCL Defined features (Operations)
     * @return the statements the OCL Statements
     * @throws ParsingException the {@link ParsingException}
     */
    public Set<OclStatement> parseString( String oclExpression, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) throws ParsingException;

    /**
     * Used for parsing during metamodel conversion
     * 
     * @param oclExpression the OCL Expression
     * @param contextPackage the context package (container of the context
     * classifier)
     * @param modelElementsByName the ModelElement/Name mapping
     * @param modelElementsByOclQualifiedName the ModelElement/QualifiedName
     * mapping
     * @param oclDefinedFeatures the OCL Defined features (Operations)
     * @return the statements the OCL Statements
     * @throws ParsingException the {@link ParsingException}
     */
    public Set<OclStatement> parseString( String oclExpression, MofPackage contextPackage, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) throws ParsingException;

    /**
     * Used to pars violation message expressions
     * 
     * @param oclExpression the OCL Expression
     * @param context the context
     * @param modelElementsByName the ModelElement/Name mapping
     * @param modelElementsByOclQualifiedName the ModelElement/QualifiedName
     * mapping
     * @param oclDefinedFeatures the OCL Defined features (Operations)
     * @return the statements the OCL Statements
     * @throws ParsingException the {@link ParsingException}
     */
    public Set<OclStatement> parseString( String oclExpression, RefObject context, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) throws ParsingException;

}