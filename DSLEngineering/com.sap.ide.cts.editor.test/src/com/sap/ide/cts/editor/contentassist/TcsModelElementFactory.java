package com.sap.ide.cts.editor.contentassist;

import com.sap.furcas.metamodel.TCS.Alternative;
import com.sap.furcas.metamodel.TCS.Block;
import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.ConditionalElement;
import com.sap.furcas.metamodel.TCS.CreateAsPArg;
import com.sap.furcas.metamodel.TCS.CreateInPArg;
import com.sap.furcas.metamodel.TCS.CustomSeparator;
import com.sap.furcas.metamodel.TCS.FunctionCall;
import com.sap.furcas.metamodel.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.metamodel.TCS.LiteralRef;
import com.sap.furcas.metamodel.TCS.ModePArg;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.PropertyReference;
import com.sap.furcas.metamodel.TCS.RefersToKeyPArg;
import com.sap.furcas.metamodel.TCS.RefersToPArg;
import com.sap.furcas.metamodel.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.TCS.Sequence;
import com.sap.furcas.metamodel.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.TCS.Symbol;

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

	public SeparatorPArg createSeparatorParg();

	public RefersToPArg createRefersToParg();

	public CreateInPArg createCreateAsParg();

	public ConcreteSyntax createConcreteSyntax();

	/**
	 * @return
	 */
	public PropertyReference createPropertyRef();

	public ModePArg createModeParg();

}
