package com.sap.ide.cts.editor.contentassist;

import tcs.Alternative;
import tcs.Block;
import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.ConditionalElement;
import tcs.CreateAsParg;
import tcs.CustomSeparator;
import tcs.FunctionCall;
import tcs.FunctionTemplate;
import tcs.Keyword;
import tcs.LiteralRef;
import tcs.ModeParg;
import tcs.Property;
import tcs.PropertyReference;
import tcs.RefersToParg;
import tcs.SeparatorParg;
import tcs.Sequence;
import tcs.SequenceInAlternative;
import tcs.Symbol;
import tcs.TcsPackage;

import com.sap.tc.moin.repository.Connection;

public class TcsModelElementMoinFactory extends ModelElementMoinFactory
		implements TcsModelElementFactory {

	private TcsPackage rootPkg;

	public TcsModelElementMoinFactory(Connection connection) {
		super(connection);
		rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
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
	public SeparatorParg createSeparatorParg() {
		return (SeparatorParg) rootPkg.getSeparatorParg().refCreateInstance();
	}

	@Override
	public RefersToParg createRefersToParg() {
		return (RefersToParg) rootPkg.getRefersToParg().refCreateInstance();
	}

	@Override
	public CreateAsParg createCreateAsParg() {
		return (CreateAsParg) rootPkg.getCreateAsParg().refCreateInstance();
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
	public ModeParg createModeParg() {
		return (ModeParg) rootPkg.getModeParg().refCreateInstance();
	}

}
