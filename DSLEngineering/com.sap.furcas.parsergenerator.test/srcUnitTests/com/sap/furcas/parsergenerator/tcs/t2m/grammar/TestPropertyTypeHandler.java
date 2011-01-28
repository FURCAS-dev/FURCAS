/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static com.sap.furcas.test.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.CreateAsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.CreateInPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ImportContextPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupScopePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ModePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PostfixPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PrefixPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.LocatedElementStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.PrimitiveTemplateStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.PropertyStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.SequenceStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.TemplateStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.PropertyInstanceOfConstraint;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.PropertyQuantityConstraint;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.MetaLookupStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.RuleBodyStringBufferStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.SyntaxLookupStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.TemplateNamingHelperStub;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.MultiplicityBean;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

/**
 *
 */
public class TestPropertyTypeHandler {

    @BeforeClass
    public static void setup() {
        ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.NONE;
    }

    @Test
    public void testAppendBitWithSeparator() throws Exception {
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        List<PropertyArg> argsList = new ArrayList<PropertyArg>();
        PropertyTypeHandler.PropertyArgs args = new PropertyTypeHandler.PropertyArgs(argsList);
        StringBuilder repeatablePart = new StringBuilder("repeatableBit");
        /** test without separator **/
        PropertyTypeHandler.appendBitWithSeparator(buf, repeatablePart, args.separator, null);
        assertEquals("(repeatableBit)", buf.getResult());

        /** test with separator **/

        SequenceStub sequence = new SequenceStub();
        sequence.representation = "(SEP)";
        argsList.add(new SeparatorArgStub(sequence));
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        buf = new RuleBodyStringBufferStub();
        PropertyTypeHandler.appendBitWithSeparator(buf, repeatablePart, args.separator, null);
        assertEquals("((SEP)repeatableBit)", buf.getResult());
    }

    @Test
    public void testAddRepeatableWithMultiplicity() throws Exception {
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        SequenceStub sequence = new SequenceStub();
        sequence.representation = "(SEP)";
        List<PropertyArg> argsList = new ArrayList<PropertyArg>();
        argsList.add(new SeparatorArgStub(sequence));

        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        PropertyTypeHandler.PropertyArgs args = new PropertyTypeHandler.PropertyArgs(argsList);
        StringBuilder repeatablePart = new StringBuilder("repeatableBit");

        MultiplicityBean multiBean = new MultiplicityBean();
        propHandler.addRepeatableWithMultiplicity(buf, null, repeatablePart, multiBean, args);
        assertEquals("(repeatableBit)", buf.getResult());

        buf = new RuleBodyStringBufferStub();
        multiBean.setLowerBound(0);
        propHandler.addRepeatableWithMultiplicity(buf, null, repeatablePart, multiBean, args);
        assertEquals("(repeatableBit)? ", buf.getResult());

        buf = new RuleBodyStringBufferStub();
        multiBean.setUpperBound(-1);
        propHandler.addRepeatableWithMultiplicity(buf, null, repeatablePart, multiBean, args);
        assertEquals("(repeatableBit ((SEP)repeatableBit)* )? ", buf.getResult());

        buf = new RuleBodyStringBufferStub();
        multiBean.setLowerBound(1);
        propHandler.addRepeatableWithMultiplicity(buf, null, repeatablePart, multiBean, args);
        assertEquals("(repeatableBit ((SEP)repeatableBit)* )", buf.getResult());

    }

    /**
     * Tests conditionals constraints override multiplicity
     * 
     * @throws Exception
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddRepeatableWithMultiplicityInConditional() throws Exception, SyntaxParsingException {
        // within conditional elements, properties' multiplicity may be
        // overriden
        // example in : (isDefined(title) ? title : "Notitle"), the
        // then-sequence should enforce presence of title,
        // even if outside the context of isDefined, it is an optional element.
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        SequenceStub sequence = new SequenceStub();
        sequence.representation = "SEP";
        List<PropertyArg> argsList = new ArrayList<PropertyArg>();
        argsList.add(new SeparatorArgStub(sequence));
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        PropertyTypeHandler.PropertyArgs args = new PropertyTypeHandler.PropertyArgs(argsList);
        StringBuilder repeatablePart = new StringBuilder("repeatableBit");

        PropertyStub propStub = new PropertyStub();
        propStub.propRef.name = "propertyname";

        MultiplicityBean multiBean = new MultiplicityBean();

        buf.currentConstraints.add(new PropertyQuantityConstraint(propStub.propRef.name,
                PropertyQuantityConstraint.ISDEFINED_KEY, false));
        boolean thrown = false;
        try {
            propHandler.addRepeatableWithMultiplicity(buf, propStub, repeatablePart, multiBean, args);
        } catch (SyntaxElementException e) {
            thrown = true;
        }
        assertTrue("Exception expected because conditional constraint violates usage of this property", thrown);

        buf = new RuleBodyStringBufferStub();
        buf.currentConstraints.add(new PropertyQuantityConstraint(propStub.propRef.name,
                PropertyQuantityConstraint.ISDEFINED_KEY, true));
        multiBean.setLowerBound(0);
        multiBean.setUpperBound(-1);
        propHandler.addRepeatableWithMultiplicity(buf, propStub, repeatablePart, multiBean, args);
        // question mark should be present, like TCS allowing optional multiple
        // elements to remain optional
        assertEquals("(repeatableBit (SEPrepeatableBit)* )? ", buf.getResult());
        multiBean.setUpperBound(1);

        buf = new RuleBodyStringBufferStub();
        buf.currentConstraints.add(new PropertyQuantityConstraint(propStub.propRef.name,
                PropertyQuantityConstraint.ISDEFINED_KEY, true));
        multiBean.setLowerBound(0);

        propHandler.addRepeatableWithMultiplicity(buf, propStub, repeatablePart, multiBean, args);
        // question mark should be present, like TCS allowing optional multiple
        // elements to remain optional
        assertEquals("(repeatableBit)", buf.getResult());

        buf = new RuleBodyStringBufferStub();
        buf.currentConstraints
                .add(new PropertyQuantityConstraint(propStub.propRef.name, PropertyQuantityConstraint.ONE_KEY, true));
        multiBean.setUpperBound(-1);
        propHandler.addRepeatableWithMultiplicity(buf, propStub, repeatablePart, multiBean, args);
        // even though unbounded and optional, expect neither ? not *
        assertEquals("(repeatableBit)", buf.getResult());

        buf = new RuleBodyStringBufferStub();
        buf.currentConstraints
                .add(new PropertyQuantityConstraint(propStub.propRef.name, PropertyQuantityConstraint.ONE_KEY, true));
        multiBean.setLowerBound(1);
        propHandler.addRepeatableWithMultiplicity(buf, propStub, repeatablePart, multiBean, args);
        // even though unbounded, expect no *
        assertEquals("(repeatableBit)", buf.getResult());

    }

    @Test
    public void testInnerClassPropertyArgsDoubleException() throws MetaModelLookupException, SyntaxElementException {
        // test double setting of a PArg causes Exception
        // test null causes no exception
        PropertyTypeHandler.PropertyArgs args;
        List<PropertyArg> argsList;
        boolean thrown = false;

        argsList = new ArrayList<PropertyArg>();
        Sequence sequence = new SequenceStub();
        argsList.add(new SeparatorArgStub(sequence));
        argsList.add(new SeparatorArgStub(sequence));

        try {
            args = new PropertyTypeHandler.PropertyArgs(argsList);
        } catch (SyntaxElementException e) {
            thrown = true;
        }
        assertTrue("SyntaxParsingException expected.", thrown);

        thrown = false;

        argsList = new ArrayList<PropertyArg>();
        argsList.add(new ForcedLowerPArgStub(4));
        argsList.add(new ForcedLowerPArgStub(4));

        try {
            args = new PropertyTypeHandler.PropertyArgs(argsList);
        } catch (SyntaxElementException e) {
            thrown = true;
        }
        assertTrue("SyntaxParsingException expected.", thrown);

        thrown = false;

        argsList = new ArrayList<PropertyArg>();
        argsList.add(new CreateasPArgStub());
        argsList.add(new CreateasPArgStub());

        try {
            args = new PropertyTypeHandler.PropertyArgs(argsList);
        } catch (SyntaxElementException e) {
            thrown = true;
        }
        assertTrue("SyntaxParsingException expected.", thrown);

        thrown = false;

        argsList = new ArrayList<PropertyArg>();
        argsList.add(new AutoCreatePArgStub());
        argsList.add(new AutoCreatePArgStub());

        try {
            args = new PropertyTypeHandler.PropertyArgs(argsList);
        } catch (SyntaxElementException e) {
            thrown = true;
        }
        assertTrue("SyntaxParsingException expected.", thrown);

        thrown = false;

        argsList = new ArrayList<PropertyArg>();
        argsList.add(new AsPargStub());
        argsList.add(new AsPargStub());

        try {
            args = new PropertyTypeHandler.PropertyArgs(argsList);
        } catch (SyntaxElementException e) {
            thrown = true;
        }
        assertTrue("SyntaxParsingException expected.", thrown);

        thrown = false;

        argsList = new ArrayList<PropertyArg>();
        argsList.add(new LookInpPargStub());
        argsList.add(new LookInpPargStub());

        try {
            args = new PropertyTypeHandler.PropertyArgs(argsList);
        } catch (SyntaxElementException e) {
            thrown = true;
        }
        assertTrue("SyntaxParsingException expected.", thrown);

        thrown = false;

        argsList = new ArrayList<PropertyArg>();
        argsList.add(new ImportContextPArgStub());
        argsList.add(new ImportContextPArgStub());

        try {
            args = new PropertyTypeHandler.PropertyArgs(argsList);
        } catch (SyntaxElementException e) {
            thrown = true;
        }
        assertTrue("SyntaxParsingException expected.", thrown);

        thrown = false;

        argsList = new ArrayList<PropertyArg>();
        argsList.add(new CreateInPArgStub());
        argsList.add(new CreateInPArgStub());

        try {
            args = new PropertyTypeHandler.PropertyArgs(argsList);
        } catch (SyntaxElementException e) {
            thrown = true;
        }
        assertTrue("SyntaxParsingException expected.", thrown);

        thrown = false;

        argsList = new ArrayList<PropertyArg>();
        argsList.add(new RefersToPargStub());
        argsList.add(new RefersToPargStub());

        try {
            args = new PropertyTypeHandler.PropertyArgs(argsList);
        } catch (SyntaxElementException e) {
            thrown = true;
        }
        assertTrue("SyntaxParsingException expected.", thrown);

        /** Test for illegal type **/
        thrown = false;

        argsList = new ArrayList<PropertyArg>();
        argsList.add(new PargStub());

        try {
            args = new PropertyTypeHandler.PropertyArgs(argsList);
        } catch (RuntimeException e) {
            thrown = true;
        }
        assertTrue("SyntaxParsingException expected.", thrown);
    }

    @Test
    public void testAddElement() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");})", buf.getResult() );
    }

    @Test
    public void testAddElementMode() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        ModePargStub modePArg = new ModePargStub();
        modePArg.mode = "testmode";
        prop.args.add(modePArg);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName_testmode {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");})", buf.getResult() );
    }

    /**
     * @return
     */
    private SyntaxLookupStub getSyntaxStubWithTemplateStubs() {
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        TemplateStub parentTemplateStub = new TemplateStub();
        parentTemplateStub.names = list("FeatureTypeName");
        syntaxLookupStub.enclosingName = parentTemplateStub;
        syntaxLookupStub.typeTemplate = parentTemplateStub;
        return syntaxLookupStub;
    }

    /**
     * @return
     */
    private SyntaxLookupStub getSyntaxStubWithPrimitiveTemplateStubs() {
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        PrimitiveTemplateStub parentTemplateStub = new PrimitiveTemplateStub();
        parentTemplateStub.names = list("FeatureTypeName");
        syntaxLookupStub.enclosingName = parentTemplateStub;
        syntaxLookupStub.typeTemplate = parentTemplateStub;
        return syntaxLookupStub;
    }

    /**
     * needs an additional "?"
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test
    public void testAddElementOptional() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, true, false);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");})? ", buf.getResult());
    }

    /**
     * needs an additional "*"
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test
    public void testAddElementUnbounded() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, true);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");} ( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");})* )", buf.getResult() );
    }

    /**
     * needs an additional "*"
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test
    public void testAddElementUnboundedSeparator() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, true);

        SequenceStub separatorSequence = new SequenceStub();
        separatorSequence.representation = "(SEP)";
        SeparatorArgStub separator = new SeparatorArgStub(separatorSequence);

        prop.args.add(separator);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");}" +
        		" ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");})* )", 
        		buf.getResult() );
    }

    /**
     * needs an additional "?" and "*"
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test
    public void testAddElementOptionalUnbounded() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, true, true);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"} ( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");})* )? ",
        		buf.getResult() );
    }

    /**
     * needs additional inner brackets to force the number of forcedLower P Arg
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test
    public void testAddElementUnboundedForcedLower() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        // setup forcedLower arg
        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, true);
        prop.args.add(new ForcedLowerPArgStub(3));

        // setup separator
        SequenceStub separatorSequence = new SequenceStub();
        separatorSequence.representation = "(SEP)";
        SeparatorArgStub separator = new SeparatorArgStub(separatorSequence);
        prop.args.add(separator);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");}" +
        		" ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");}) ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);" +
        		"\nsetParent(temp,ret,\"PropertyName\");})+)", buf.getResult() );
    }

    /**
     * upper and lower bounds
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test
    public void testAddElementUnboundedForcedBoundsMeta() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        // setup forcedLower arg
        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, 3, 5);

        // setup separator
        SequenceStub separatorSequence = new SequenceStub();
        separatorSequence.representation = "(SEP)";
        SeparatorArgStub separator = new SeparatorArgStub(separatorSequence);
        prop.args.add(separator);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"} ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");}) ((SEP) temp=FeatureTypeName " +
        		"{setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");}) ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"})? ((SEP) temp=FeatureTypeName " +
        		"{setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");})?)", buf.getResult() );
    }

    /**
     * upper bounds only
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test
    public void testAddElementUnboundedForcedBoundsMeta2() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        // setup forcedLower arg
        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, 1, 3);

        // setup separator
        SequenceStub separatorSequence = new SequenceStub();
        separatorSequence.representation = "(SEP)";
        SeparatorArgStub separator = new SeparatorArgStub(separatorSequence);
        prop.args.add(separator);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"} ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"})? ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");})?)", buf.getResult() );
    }

    /**
     * upper bounds only and optional
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test
    public void testAddElementUnboundedForcedBoundsMeta3() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        // setup forcedLower arg
        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, 0, 3);

        // setup separator
        SequenceStub separatorSequence = new SequenceStub();
        separatorSequence.representation = "(SEP)";
        SeparatorArgStub separator = new SeparatorArgStub(separatorSequence);
        prop.args.add(separator);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"} ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"})? ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"})?)? ", buf.getResult() );
    }

    /**
     * upper bounds only and optional
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test
    public void testAddElementUnboundedForcedBoundsMeta4() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        // setup forcedLower arg
        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, 3, 3);

        // setup separator
        SequenceStub separatorSequence = new SequenceStub();
        separatorSequence.representation = "(SEP)";
        SeparatorArgStub separator = new SeparatorArgStub(separatorSequence);
        prop.args.add(separator);

        propHandler.addElement(prop, buf);

        assertEquals("( temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"} ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"}) ((SEP) temp=FeatureTypeName {setProperty(ret, \"PropertyName\", temp);\nsetParent(temp,ret,\"PropertyName\");" +
        		"}))", buf.getResult() );
    }

    /**
     * metamodel bounds are invalid
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test
    public void testAddElementUnboundedInvalidBoundsMeta() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        // setup forcedLower arg
        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, 5, 4);
        prop.args.add(new ForcedLowerPArgStub(3));

        // setup separator
        SequenceStub separatorSequence = new SequenceStub();
        separatorSequence.representation = "(SEP)";
        SeparatorArgStub separator = new SeparatorArgStub(separatorSequence);
        prop.args.add(separator);
        boolean caught = false;
        try {
            propHandler.addElement(prop, buf);
        } catch (SyntaxElementException e) {
            caught = true;
        }
        assertTrue("Exception expected because Metamodel is invalid", caught);

    }
    
    private PropertyStub getMockProperty(String propertyName, String parentName, String featureName,
            MetaLookupStub metaLookupStub, boolean isOptional, boolean isUnbounded) {
        // the template as class under test will use this for meta lookup
        final TemplateStub owner = new TemplateStub();
        owner.names = list(parentName);
        PropertyStub prop = new PropertyStub() {
            @Override
            public EObject eContainer() {
                return owner;
            }

            @Override
            public Template getParentTemplate() {
                return owner;
            }

        };
        prop.propRef.name = propertyName;
        prop.args = new BasicEList<PropertyArg>();

        metaLookupStub.featureClassName = list(featureName);
        metaLookupStub.multiplicity = new MultiplicityBean();
        if (isOptional) {
            metaLookupStub.multiplicity.setLowerBound(0);
        } else {
            metaLookupStub.multiplicity.setLowerBound(1);
        }
        if (isUnbounded) {
            metaLookupStub.multiplicity.setUpperBound(-1);
        } else {
            metaLookupStub.multiplicity.setUpperBound(1);
        }

        return prop;
    }

    private PropertyStub getMockProperty(String propertyName, String parentName, String featureName,
            MetaLookupStub metaLookupStub, int lower, int upper) {
        // the template as class under test will use this for meta lookup
        final TemplateStub owner = new TemplateStub();
        owner.names = list(parentName);
        PropertyStub prop = new PropertyStub() {
            @Override
            public EObject eContainer() {
                return owner;
            }
        };
        prop.propRef.name = propertyName;
        prop.args = new BasicEList<PropertyArg>();

        metaLookupStub.featureClassName = list(featureName);
        metaLookupStub.multiplicity = new MultiplicityBean();

        metaLookupStub.multiplicity.setLowerBound(lower);
        metaLookupStub.multiplicity.setUpperBound(upper);
        return prop;
    }

    @Test
    public void testAddElementRefersTo() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        RefersToPargStub referTo = new RefersToPargStub();
        referTo.propertyName = "ArgPropertyName";
        prop.args.add(referTo);

        propHandler.addElement(prop, buf);

        assertEquals(
                "( temp=FeatureTypeName {setRef(ret, \"PropertyName\", \"[FeatureTypeName]\", \"ArgPropertyName\", temp, null, \"never\", null, false, null);})",
                buf.getResult());
    }

    @Test
    public void testAddElementRefersToInstanceOf() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeRuleName", metaLookupStub, false, false);

        RefersToPargStub referTo = new RefersToPargStub();
        referTo.propertyName = "ArgPropertyName";
        prop.args.add(referTo);

        buf.currentConstraints.add(new PropertyInstanceOfConstraint("PropertyName", list("FeatureType", "RealName")));

        propHandler.addElement(prop, buf);

        // FeatureTypeRealname to override FeatureTypeRuleName in set part
        assertEquals(
                "( temp=FeatureTypeRuleName {setRef(ret, \"PropertyName\", \"[FeatureType, RealName]\", \"ArgPropertyName\", temp, null, \"never\", null, false, null);})",
                buf.getResult());
    }

    @Test
    public void testAddElementRefersToLookIn() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        RefersToPargStub referTo = new RefersToPargStub();
        referTo.propertyName = "ArgPropertyName";
        prop.args.add(referTo);
        LookInpPargStub lookIn = new LookInpPargStub();
        lookIn.propertyName = list("ArgLookInName");
        prop.args.add(lookIn);
        propHandler.addElement(prop, buf);
        assertEquals(
                "( temp=FeatureTypeName {setRef(ret, \"PropertyName\", \"[FeatureTypeName]\", \"ArgPropertyName\", temp, \"ArgLookInName\", \"never\", null, false, null);})",
                buf.getResult());

        buf = new RuleBodyStringBufferStub();
        lookIn.propertyName = list("#all");
        propHandler.addElement(prop, buf);
        assertEquals(
                "( temp=FeatureTypeName {setRef(ret, \"PropertyName\", \"[FeatureTypeName]\", \"ArgPropertyName\", temp, \"#all\", \"never\", null, false, null);})",
                buf.getResult());

        buf = new RuleBodyStringBufferStub();
        lookIn.propertyName = list("test1", "test2");
        propHandler.addElement(prop, buf);
        assertEquals(
                "( temp=FeatureTypeName {setRef(ret, \"PropertyName\", \"[FeatureTypeName]\", \"ArgPropertyName\", temp, \"test1.test2\", \"never\", null, false, null);})",
                buf.getResult());
    }

    @Test
    public void testAddElementRefersToAutoCreate() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        RefersToPargStub referTo = new RefersToPargStub();
        referTo.propertyName = "ArgPropertyName";
        prop.args.add(referTo);
        AutoCreatePArgStub autoCreate = new AutoCreatePArgStub();
        autoCreate.kind = AutoCreateKind.ALWAYS;
        prop.args.add(autoCreate);
        propHandler.addElement(prop, buf);
        assertEquals(
                "( temp=FeatureTypeName {setRef(ret, \"PropertyName\", \"[FeatureTypeName]\", \"ArgPropertyName\", temp, null, \"always\", null, false, null);})",
                buf.getResult());

        buf = new RuleBodyStringBufferStub();
        autoCreate.kind = AutoCreateKind.IFMISSING;
        propHandler.addElement(prop, buf);
        assertEquals(
                "( temp=FeatureTypeName {setRef(ret, \"PropertyName\", \"[FeatureTypeName]\", \"ArgPropertyName\", temp, null, \"ifmissing\", null, false, null);})",
                buf.getResult());

        buf = new RuleBodyStringBufferStub();
        autoCreate.kind = AutoCreateKind.NEVER;
        propHandler.addElement(prop, buf);
        assertEquals(
                "( temp=FeatureTypeName {setRef(ret, \"PropertyName\", \"[FeatureTypeName]\", \"ArgPropertyName\", temp, null, \"never\", null, false, null);})",
                buf.getResult());
    }

    @Test
    public void testAddElementRefersToCreateAs() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        RefersToPargStub referTo = new RefersToPargStub();
        referTo.propertyName = "ArgPropertyName";
        prop.args.add(referTo);
        CreateasPArgStub createAs = new CreateasPArgStub();
        createAs.name = list("Test"); // need to make sure Metamodel knows this
        // type

        prop.args.add(createAs);
        propHandler.addElement(prop, buf);
        // argument "Test" looks different with original NamingHelper
        assertEquals(
                "( temp=FeatureTypeName {setRef(ret, \"PropertyName\", \"[FeatureTypeName]\", \"ArgPropertyName\", temp, null, \"never\", Test, false, null);})",
                buf.getResult());
    }

    @Test
    public void testAddElementRefersToCreateIn() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        RefersToPargStub referTo = new RefersToPargStub();
        referTo.propertyName = "ArgPropertyName";
        prop.args.add(referTo);
        CreateInPArgStub lookIn = new CreateInPArgStub();
        lookIn.pName = list("test1", "test2");
        prop.args.add(lookIn);
        propHandler.addElement(prop, buf);
        assertEquals(
                "( temp=FeatureTypeName {setRef(ret, \"PropertyName\", \"[FeatureTypeName]\", \"ArgPropertyName\", temp, null, \"never\", null, false, \"test1.test2\");})",
                buf.getResult());
    }

    @Test
    public void testAddElementRefersToCreateImportContext() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        RefersToPargStub referTo = new RefersToPargStub();
        referTo.propertyName = "ArgPropertyName";
        prop.args.add(referTo);
        ImportContextPArgStub lookIn = new ImportContextPArgStub();
        prop.args.add(lookIn);
        propHandler.addElement(prop, buf);
        assertEquals(
                "( temp=FeatureTypeName {setRef(ret, \"PropertyName\", \"[FeatureTypeName]\", \"ArgPropertyName\", temp, null, \"never\", null, true, null);})",
                buf.getResult());

    }
    
    @Test
    public void testAddElementReferenceByViaPropertyName() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithPrimitiveTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        PrimitiveTemplateStub primitiveTemplate = new PrimitiveTemplateStub();
        primitiveTemplate.setTemplateName("DefaultPrimitiveTemplate");
        syntaxLookupStub.defaultPrimitiveTemplate = primitiveTemplate;
        
        LookupScopePargStub query = new LookupScopePargStub();
        query.query = "OCL:self.fooFeature";
        prop.args.add(query);
        
        ReferenceByPArgStub referenceBy = new ReferenceByPArgStub();
        referenceBy.referenceBy = "ArgFeatureName";
        prop.args.add(referenceBy);

        propHandler.addElement(prop, buf);

        assertEquals(
                "( temp=DefaultPrimitiveTemplate {setOclRef(ret, \"PropertyName\", null, temp, \"OCL:self.fooFeature->select(ArgFeatureName = ?)\");})",
                buf.getResult());
    }
    
    @Test
    public void testAddElementReferenceByViaOCL() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithPrimitiveTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        PrimitiveTemplateStub primitiveTemplate = new PrimitiveTemplateStub();
        primitiveTemplate.setTemplateName("DefaultPrimitiveTemplate");
        syntaxLookupStub.defaultPrimitiveTemplate = primitiveTemplate;
        
        LookupScopePargStub query = new LookupScopePargStub();
        query.query = "OCL:self.fooFeature";
        prop.args.add(query);
        
        ReferenceByPArgStub referenceBy = new ReferenceByPArgStub();
        referenceBy.referenceBy = "OCL:self.random.ocl.expression";
        prop.args.add(referenceBy);

        propHandler.addElement(prop, buf);

        assertEquals(
                "( temp=DefaultPrimitiveTemplate {setOclRef(ret, \"PropertyName\", null, temp, \"OCL:self.fooFeature->select(candidate | candidate.random.ocl.expression = ?)\");})",
                buf.getResult());
    }
    
    @Test
    public void testAddElementReferenceByWithAs() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithPrimitiveTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        LookupScopePargStub query = new LookupScopePargStub();
        query.query = "OCL:self.fooFeature";
        prop.args.add(query);
        
        ReferenceByPArgStub referenceBy = new ReferenceByPArgStub();
        referenceBy.referenceBy = "ArgFeatureName";
        prop.args.add(referenceBy);
        
        // Provide a specific primitive template that we want to use for serializing
        AsPargStub asPArg = new AsPargStub();
        PrimitiveTemplateStub primitiveTemplate = new PrimitiveTemplateStub(list("SpecificPrimitiveTemplate"));
        primitiveTemplate.setTemplateName("SpecificPrimitiveTemplate");
        asPArg.setTemplate(primitiveTemplate);
        prop.args.add(asPArg);

        propHandler.addElement(prop, buf);

        assertEquals(
                "( temp=SpecificPrimitiveTemplate {setOclRef(ret, \"PropertyName\", null, temp, \"OCL:self.fooFeature->select(ArgFeatureName = ?)\");})",
                buf.getResult());
    }
    
    @Test
    public void testAddElementReferenceByWithPrefixPostfix() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithPrimitiveTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        PrimitiveTemplateStub primitiveTemplate = new PrimitiveTemplateStub();
        primitiveTemplate.setTemplateName("DefaultPrimitiveTemplate");
        syntaxLookupStub.defaultPrimitiveTemplate = primitiveTemplate;
        
        LookupScopePargStub query = new LookupScopePargStub();
        query.query = "OCL:self.fooFeature";
        prop.args.add(query);
        
        ReferenceByPArgStub referenceBy = new ReferenceByPArgStub();
        referenceBy.referenceBy = "ArgFeatureName";
        prop.args.add(referenceBy);
        
        PrefixPArgStub prefix = new PrefixPArgStub();
        prefix.prefix = "prefix";
        prop.args.add(prefix);
        
        PostfixPArgStub postfix = new PostfixPArgStub();
        postfix.postfix = "postfix";
        prop.args.add(postfix);

        propHandler.addElement(prop, buf);

        assertEquals(
                "( temp=DefaultPrimitiveTemplate {setOclRef(ret, \"PropertyName\", null, temp, \"OCL:self.fooFeature->select(ArgFeatureName = 'prefix'.concat(?).concat('postfix'))\");})",
                buf.getResult());
    }

    @Test
    public void testInnerClassPropertyArgs() throws MetaModelLookupException, SyntaxElementException {

        // test null causes no exception
        PropertyTypeHandler.PropertyArgs args = new PropertyTypeHandler.PropertyArgs(null);

        assertNull(args.forcedLower);
        assertNull(args.separator);

        // test empty list causes no exception
        List<PropertyArg> argsList = new ArrayList<PropertyArg>();
        args = new PropertyTypeHandler.PropertyArgs(argsList);

        Sequence sequence = new SequenceStub();
        argsList.add(new SeparatorArgStub(sequence));
        args = new PropertyTypeHandler.PropertyArgs(argsList);

        assertEquals(sequence, args.separator.getSeparatorSequence());
        assertNull(args.forcedLower);

        argsList.add(new ForcedLowerPArgStub(4));
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertSame(4, args.forcedLower.getValue());

        argsList = new ArrayList<PropertyArg>();
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNull(args.createAsPArg);
        argsList.add(new CreateasPArgStub());
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNotNull(args.createAsPArg);

        argsList = new ArrayList<PropertyArg>();
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNull(args.autoCreatePArg);
        argsList.add(new AutoCreatePArgStub());
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNotNull(args.autoCreatePArg);

        argsList = new ArrayList<PropertyArg>();
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNull(args.lookInPArg);
        argsList.add(new LookInpPargStub());
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNotNull(args.lookInPArg);

        argsList = new ArrayList<PropertyArg>();
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNull(args.refersTo);
        argsList.add(new RefersToPargStub());
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNotNull(args.refersTo);

        argsList = new ArrayList<PropertyArg>();
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNull(args.importContextPArg);
        argsList.add(new ImportContextPArgStub());
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNotNull(args.importContextPArg);

        argsList = new ArrayList<PropertyArg>();
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNull(args.createInPArg);
        argsList.add(new CreateInPArgStub());
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNotNull(args.createInPArg);
        
        argsList = new ArrayList<PropertyArg>();
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNull(args.lookupScopePArg);
        argsList.add(new LookupScopePargStub());
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNotNull(args.lookupScopePArg);
        
        argsList = new ArrayList<PropertyArg>();
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNull(args.referenceByPArg);
        argsList.add(new ReferenceByPArgStub());
        args = new PropertyTypeHandler.PropertyArgs(argsList);
        assertNotNull(args.referenceByPArg);
    }

    /**
     * tests for making sure runtimeexception is thrown
     * 
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    @Test(expected = RuntimeException.class)
    public void testAddElementUnknownType() throws MetaModelLookupException, SyntaxElementException {
        SyntaxLookupStub syntaxLookupStub = getSyntaxStubWithTemplateStubs();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();

        // Class under test
        PropertyTypeHandler propHandler = new PropertyTypeHandler(metaLookupStub, syntaxLookupStub, namingStub, new SemanticErrorBucket());

        // result buffer
        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();

        PropertyStub prop = getMockProperty("PropertyName", "ParentClass", "FeatureTypeName", metaLookupStub, false, false);

        PropertyArg unknownArgType = new InvalidPropertyArgStub();
        prop.args.add(unknownArgType);
        propHandler.addElement(prop, buf);

    }

    /**
     *
     */
    class SeparatorArgStub extends PargStub implements SeparatorPArg {

        private final Sequence sequence;

        public SeparatorArgStub(Sequence sequence) {
            this.sequence = sequence;
        }

        /*
         * (non-Javadoc)
         * 
         * @see TCS.SeparatorPArg#getSeparatorSequence()
         */
        @Override
		public Sequence getSeparatorSequence() {
            return sequence;
        }

        /*
         * (non-Javadoc)
         * 
         * @see TCS.SeparatorPArg#setSeparatorSequence(TCS.Sequence)
         */
        @Override
		public void setSeparatorSequence(Sequence value) {
        }

    }

    /**
     *
     */
    class ForcedLowerPArgStub extends PargStub implements ForcedLowerPArg {

        private final int value;

        public ForcedLowerPArgStub(int value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return this.value;
        }

        @Override
        public void setValue(Integer value) {
            // TODO Auto-generated method stub

        }
    }

    /**
     *
     */
    class CreateasPArgStub extends PargStub implements CreateAsPArg {

        public EList<String> name;

        public void setName(EList<String> name) {
            this.name = name;
        }

        @Override
        public EList<String> getName() {
            return name;
        }

    }

    /**
     *
     */
    class AutoCreatePArgStub extends PargStub implements AutoCreatePArg {

        public AutoCreateKind kind;

        /*
         * (non-Javadoc)
         * 
         * @see TCS.AutoCreatePArg#getValue()
         */
        @Override
		public AutoCreateKind getValue() {
            return kind;
        }

        /*
         * (non-Javadoc)
         * 
         * @see TCS.AutoCreatePArg#setValue(TCS.AutoCreateKind)
         */
        @Override
		public void setValue(AutoCreateKind value) {

        }

    }

    class LookInpPargStub extends PargStub implements LookInPArg {

        public EList<String> propertyName;

        @Override
		public EList<String> getPropertyName() {
            return propertyName;
        }

    }

    class InvalidPropertyArgStub extends PargStub implements PropertyArg {

    }

    class AsPargStub extends PargStub implements AsPArg {
        private String value;
        private Template template;

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String newValue) {
            value = value;
        }

        @Override
        public void setTemplate(Template newValue) {
            template = newValue;
        }

        @Override
        public Template getTemplate() {
            return template;
        }
    }

    class ModePargStub extends PargStub implements ModePArg {
        public String mode;

        /*
         * (non-Javadoc)
         * 
         * @see TCS.AsPArg#getValue()
         */
        @Override
		public String getMode() {
            return mode;
        }

        /*
         * (non-Javadoc)
         * 
         * @see TCS.AsPArg#setValue(java.lang.String)
         */
        @Override
		public void setMode(String value) {

        }

    }

    class RefersToPargStub extends PargStub implements RefersToPArg {

        public String propertyName;

        @Override
		public String getPropertyName() {
            return propertyName;
        }

        /*
         * (non-Javadoc)
         * 
         * @see TCS.RefersToPArg#setPropertyName(java.lang.String)
         */
        @Override
		public void setPropertyName(String value) {

        }
    }
    
    class LookupScopePargStub extends PargStub implements LookupScopePArg {

        public String query;
        
        @Override
        public String getQuery() {
            return query;
        }

        @Override
        public void setQuery(String value) {
            query = value;
        }
    }
    
    class ReferenceByPArgStub extends PargStub implements ReferenceByPArg {

        public String referenceBy;

        @Override
        public String getReferenceBy() {
            return referenceBy;
        }

        @Override
        public void setReferenceBy(String value) {
            referenceBy = value;            
        }
    }
    
    class PrefixPArgStub extends PargStub implements PrefixPArg {

        public String prefix;
        
        @Override
        public String getPrefix() {
            return prefix;
        }

        @Override
        public void setPrefix(String value) {
            prefix = value;
        }
        
    }
    
    class PostfixPArgStub extends PargStub implements PostfixPArg {

        public String postfix;
        
        @Override
        public String getPostfix() {
            return postfix;
        }

        @Override
        public void setPostfix(String value) {
            postfix = value;
        }
        
    }

    class PargStub extends LocatedElementStub implements PropertyArg {
        public Property property;

        @Override
		public final Property getProperty() {
            return property;
        }

        @Override
		public final void setProperty(Property property) {
            this.property = property;
        }
    }

    class ImportContextPArgStub extends PargStub implements ImportContextPArg {

    }

    class CreateInPArgStub extends PargStub implements CreateInPArg {

        public EList<String> pName;

        /*
         * (non-Javadoc)
         * 
         * @see TCS.CreateInPArg#getPropertyName()
         */
        @Override
		public EList<String> getPropertyName() {
            return pName;
        }

    }

}
