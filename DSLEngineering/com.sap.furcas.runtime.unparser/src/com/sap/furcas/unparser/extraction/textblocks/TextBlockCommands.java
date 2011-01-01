/*******************************************************************************
 * Copyright (c) 2008-2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.unparser.extraction.textblocks;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

public class TextBlockCommands {

    public static abstract class TextBlockCommand {
	
	protected TextBlockTCSExtractorStream stream;
	
	public TextBlockCommand(TextBlockTCSExtractorStream stream) {
	    this.stream = stream;
	}
	
	abstract void execute();
    }

    public static class AddNextTextBlockCommand extends TextBlockCommand {
	public final EObject object;
	public final Template t;
	public final SequenceElement se;
	public final int handle;

	public AddNextTextBlockCommand(TextBlockTCSExtractorStream stream, EObject object, Template t, SequenceElement se, int handle) {
	    super(stream);
	    this.object = object;
	    this.t = t;
	    this.se = se;
	    this.handle = handle;
	}

	@Override
	public void execute() {
	    stream.addNextTextBlock(object, t, se, handle);
	}
    }

    
    public static class FinishTextBlockCommand extends TextBlockCommand {

	public final int handle;

	public FinishTextBlockCommand(TextBlockTCSExtractorStream stream, int handle) {
	    super(stream);
	    this.handle = handle;
	}

	@Override
	public void execute() {
	    stream.finishTextBlock(handle);
	}
    }
    

    public static class AddNextTokenCommand extends TextBlockCommand {
	public final String s;
	public final SequenceElement se;

	public AddNextTokenCommand(TextBlockTCSExtractorStream stream, String s, SequenceElement se) {
	    super(stream);
	    this.s = s;
	    this.se = se;
	}

	@Override
	public void execute() {
	    stream.addNextToken(s, se);
	}
    }
    
    
    public static class EnterAlternativeMarkerCommand extends TextBlockCommand {

	public EnterAlternativeMarkerCommand(TextBlockTCSExtractorStream stream) {
	    super(stream);
	}

	@Override
	public void execute() {
	    stream.enterAlternativeAndAddMarker();
	}
    }
    

    public static class ExitAlternativeMarkerCommand extends TextBlockCommand {

	public ExitAlternativeMarkerCommand(TextBlockTCSExtractorStream stream) {
	    super(stream);
	}

	@Override
	public void execute() {
	    stream.exitAlternativeAndAddMarker();
	}
    }

    
    public static class BeginAlternativeChoiceCommand extends TextBlockCommand {

	private final int choiceIndexInAlternative;

	public BeginAlternativeChoiceCommand(TextBlockTCSExtractorStream stream, int choiceIndexInAlternative) {
	    super(stream);
	    this.choiceIndexInAlternative = choiceIndexInAlternative;
	}
	
	@Override
	public void execute() {
	    stream.addAlternativeChoice(choiceIndexInAlternative);
	}

    }

}