package com.sap.ide.cts.editor.contentassist;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.TCS.Alternative;
import com.sap.furcas.metamodel.TCS.Block;
import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.ConditionalElement;
import com.sap.furcas.metamodel.TCS.CreateAsPArg;
import com.sap.furcas.metamodel.TCS.CustomSeparator;
import com.sap.furcas.metamodel.TCS.FunctionCall;
import com.sap.furcas.metamodel.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.metamodel.TCS.LiteralRef;
import com.sap.furcas.metamodel.TCS.ModePArg;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.PropertyReference;
import com.sap.furcas.metamodel.TCS.RefersToPArg;
import com.sap.furcas.metamodel.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.TCS.Sequence;
import com.sap.furcas.metamodel.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.TCS.Symbol;
import com.sap.furcas.metamodel.TCS.TCSPackage;


public class TcsModelElementMoinFactory extends ModelElementMoinFactory
		implements TcsModelElementFactory {

	private TCSPackage rootPkg;

	public TcsModelElementMoinFactory(ResourceSet connection) {
		super(connection);
		rootPkg = connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR);
	}

	@Override
	public Alternative createAlternative() {
		return (Alternative) rootPkg.getAlternative().refCreateInstance();
	}

	@Override
	public Block createBlock() {
		return (Block) rootPkg.getBlock().refCreateInstance();
	}

	@Override
	public ConditionalElement createConditionalElement() {
		return (ConditionalElement) rootPkg.getConditionalElement()
				.refCreateInstance();
	}

	@Override
	public Sequence createSequence() {
		return (Sequence) rootPkg.getSequence().refCreateInstance();
	}

	@Override
	public ClassTemplate createClassTemplate() {
		return (ClassTemplate) rootPkg.getClassTemplate().refCreateInstance();
	}

	@Override
	public Keyword createKeyword() {
		return (Keyword) rootPkg.getKeyword().refCreateInstance();
	}

	@Override
	public LiteralRef createLiteralRef() {
		return (LiteralRef) rootPkg.getLiteralRef().refCreateInstance();
	}

	@Override
	public Symbol createSymbol() {
		return (Symbol) rootPkg.getSymbol().refCreateInstance();
	}

	@Override
	public Property createProperty() {
		return (Property) rootPkg.getProperty().refCreateInstance();
	}

	@Override
	public FunctionTemplate createFunctionTemplate() {
		return (FunctionTemplate) rootPkg.getFunctionTemplate()
				.refCreateInstance();
	}

	@Override
	public FunctionCall createFunctionCall() {
		return (FunctionCall) rootPkg.getFunctionCall().refCreateInstance();
	}

	@Override
	public CustomSeparator createCustomSeparator() {
		return (CustomSeparator) rootPkg.getCustomSeparator()
				.refCreateInstance();
	}

	@Override
	public SeparatorPArg createSeparatorParg() {
		return (SeparatorPArg) rootPkg.getSeparatorPArg().refCreateInstance();
	}

	@Override
	public RefersToPArg createRefersToParg() {
		return (RefersToPArg) rootPkg.getRefersToPArg().refCreateInstance();
	}

	@Override
	public CreateAsPArg createCreateAsParg() {
		return (CreateAsPArg) rootPkg.getCreateAsPArg().refCreateInstance();
	}

	@Override
	public ConcreteSyntax createConcreteSyntax() {
		return (ConcreteSyntax) rootPkg.getConcreteSyntax().refCreateInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.ide.cts.editor.contentassist.TcsModelElementFactory#createPropertyRef
	 * ()
	 */
	@Override
	public PropertyReference createPropertyRef() {
		return (PropertyReference) rootPkg.getPropertyReference()
				.refCreateInstance();
	}

	@Override
	public SequenceInAlternative createSequenceInAlternative() {
		return (SequenceInAlternative) rootPkg.getSequenceInAlternative()
				.refCreateInstance();
	}

	@Override
	public ModePArg createModeParg() {
		return (ModePArg) rootPkg.getModePArg().refCreateInstance();
	}

}
