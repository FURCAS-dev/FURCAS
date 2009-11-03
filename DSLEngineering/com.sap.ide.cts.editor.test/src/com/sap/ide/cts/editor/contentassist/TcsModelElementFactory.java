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

public interface TcsModelElementFactory extends ModelElementFactory {

	public Block createBlock();

	public ClassTemplate createClassTemplate();

	public Sequence createSequence();

	public SequenceInAlternative createSequenceInAlternative();

	public Alternative createAlternative();

	public ConditionalElement createConditionalElement();

	public LiteralRef createLiteralRef();

	public Keyword createKeyword();

	public Symbol createSymbol();

	public Property createProperty();

	public FunctionTemplate createFunctionTemplate();

	public FunctionCall createFunctionCall();

	public CustomSeparator createCustomSeparator();

	public SeparatorParg createSeparatorParg();

	public RefersToParg createRefersToParg();

	public CreateAsParg createCreateAsParg();

	public ConcreteSyntax createConcreteSyntax();

	/**
	 * @return
	 */
	public PropertyReference createPropertyRef();

	public ModeParg createModeParg();

}
