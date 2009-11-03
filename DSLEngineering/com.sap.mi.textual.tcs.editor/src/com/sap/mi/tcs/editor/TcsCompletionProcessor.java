package com.sap.mi.tcs.editor;
/**
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;


/**
 * @author C5106462
 *
 */
public class TcsCompletionProcessor implements IContentAssistProcessor {

	private HashMap<String,String> defaultCharacterisations = new HashMap<String, String>();
	private HashMap<String,String> parameterNames = new HashMap<String, String>();

	private String templatePrefixes = "+-*/%(?:";
	
	private TcsTemplatesCompletionProcessor templateProcessor;

	/**
	 * 
	 */
	public TcsCompletionProcessor() {
		templateProcessor = new TcsTemplatesCompletionProcessor();
		
		defaultCharacterisations.put("BYTESIZE", "Characterise the memory footprint in bytes");
		defaultCharacterisations.put("NUMBER_OF_ELEMENTS", "Characterise the number of elements of a collection datatype");
		defaultCharacterisations.put("STRUCTURE", "Characterise the structure of a datastructure");
		defaultCharacterisations.put("VALUE", "Characterise the actual value of a variable");
		defaultCharacterisations.put("TYPE", "Characterise the type of a variable");

//		for (int i=0; i<context.length; i++){
//			String[] parameterPrefixes = getPrefixesFor(context[i]);
//			for (String parameterPrefix : parameterPrefixes) {
//				if (parameterPrefix.startsWith("RETURN"))
//					parameterNames.put(parameterPrefix, "Call Result " + context[i].getParameterName());
//				else
//					parameterNames.put(parameterPrefix, "Signature Parameter " + context[i].getParameterName());
//			}
//		}
		
	}

//	private String[] getPrefixesFor(Object parameter) {
//		ArrayList<String> prefixes = new ArrayList<String>();
//		prefixes.add(parameter.getParameterName());
//		appendDatatypePrefixes(prefixes,parameter.getParameterName(),parameter.getDatatype__Parameter());
//		return prefixes.toArray(new String[]{});
//	}
//
//	private void appendDatatypePrefixes(ArrayList<String> prefixes,
//			String parameterName, DataType datatype__Parameter) {
//		if (datatype__Parameter instanceof CollectionDataType) {
//			prefixes.add(parameterName+".INNER");
//			appendDatatypePrefixes(prefixes,parameterName+".INNER", ((CollectionDataType)datatype__Parameter).getInnerType_CollectionDataType());
//		} else if (datatype__Parameter instanceof CompositeDataType) {
//			CompositeDataType cdt = (CompositeDataType) datatype__Parameter;
//			for (InnerDeclaration inner : cdt.getInnerDeclaration_CompositeDataType()) {
//				prefixes.add(parameterName+"."+inner.getEntityName());
//				appendDatatypePrefixes(prefixes, parameterName+"."+inner.getEntityName(), inner.getDatatype_InnerDeclaration());
//			}
//		}
//	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
		ArrayList<ICompletionProposal> resultList=new ArrayList<ICompletionProposal>();
		
		String currentText = viewer.getDocument().get();
		
		// compute variable characterisation completions (i.e., VALUE, TYPE, etc.)
		int lastDotIndex = currentText.substring(0,offset).lastIndexOf("."); 
		if (isCharactersationCompletionApplicable(lastDotIndex,currentText)){
			String typedFragment = currentText.substring(lastDotIndex+1, offset);
			addCompletionProposalsString(resultList, lastDotIndex, typedFragment, defaultCharacterisations);
		}
		
		// compute parameter from context completions (i.e., current input parameters)
		int lastIndex = getLastIndexOfTemplatePrefix(offset, currentText);
		if (isStartOfAtom(lastIndex, currentText)){
			String typedFragment = currentText.substring(lastIndex+1, offset).trim();
			addCompletionProposalsString(resultList, lastIndex, typedFragment, parameterNames);
		}
		// compute template completions (i.e., IntPMF, DoublePDF, etc.)
		if (isStartOfAtom(lastIndex, currentText)) {
			String typedFragment = currentText.substring(lastIndex+1, offset).trim();
			for (ICompletionProposal p : templateProcessor.computeCompletionProposals(viewer, offset)){
				if (p.getDisplayString().toUpperCase().startsWith(typedFragment.toUpperCase())){
					resultList.add(p);
				}
			}
		}
			
		return resultList.toArray(new ICompletionProposal[]{});
	}
	
	/**
	 * Checks, whether the user is characterising a variable (i.e., typed a dot)
	 * 
	 * @param offset
	 * @param currentText
	 * @return
	 */
	private boolean isCharactersationCompletionApplicable(int offset, String currentText){
		return (
		     // there is a dot (offset>=-1) and it's not the first char (offset>=0)	
			 offset-1 >= 0 					
			 // ???
			 && offset-1 < currentText.length() 
			 // the first char before the dot was a letter
			 && Character.isLetter(currentText.charAt(offset-1))
			 ); 
	}
	
	
	/**
	 * Checks, whether user started to type a atom.
	 * 
	 * @param offset
	 * @param currentText
	 * @return
	 */
	private boolean isStartOfAtom(int offset, String currentText) {
		if (offset+1 < currentText.length()  	// cursor is not at last character 
			&& offset+1 >= 0){ 					// cursor is not at first character
			currentText = currentText.substring(offset+1); // cut of everything before cursor
		}
		
		String trimText = currentText.trim();
		
		if (trimText.equals("")) 
			// only whitespace after offset 
			return true;
		
		char lastChar = trimText.charAt(trimText.length()-1);
		if (templatePrefixes.indexOf(lastChar) >= 0) 
			// last character before current offset is one of the template prefixes 
			return true;
		
		boolean hasOnlyChars = true;
		for (int i=0; i<trimText.length(); i++){
			if (!Character.isLetter(trimText.charAt(i)) && trimText.charAt(i) != '.') hasOnlyChars = false;
		}
		if (hasOnlyChars) return true;
		
		return false;
	}

	private int getLastIndexOfTemplatePrefix(int offset, String currentText) {
		int lastIndex = -1;
		String templatePrefixesAndWS = templatePrefixes + " ";
		for (int i=0; i<templatePrefixesAndWS.length(); i++) {
			int newLastIndex = currentText.substring(0, offset).lastIndexOf(
					templatePrefixesAndWS.charAt(i));
			if (newLastIndex > lastIndex)
				lastIndex = newLastIndex;
		}
		return lastIndex;
	}

	private void addCompletionProposalsString(
			ArrayList<ICompletionProposal> resultList, 
			int lastIndex,
			String typedFragment, 
			HashMap<String,String> completions) {
		for (Entry<String,String> entry : completions.entrySet()){
			String completion = entry.getKey();
			String description = entry.getValue();
			
			if (completion.toUpperCase().startsWith(typedFragment.toUpperCase())){
				IContextInformation info = new ContextInformation(
						completion,
						description); //$NON-NLS-1$
				resultList.add(new CompletionProposal(
						completion, 
						lastIndex+1, 
						typedFragment.length(), 
						completion.length(), 
						null, 
						completion + " - "+ description, 
						info, 
						description)); //$NON-NLS-1$
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		ArrayList<Character> result = new ArrayList<Character>();
		for (String parameterName : parameterNames.keySet())
			result.add(parameterName.charAt(0));	
		for (int i=0; i < templatePrefixes.length(); i++)
			result.add(templatePrefixes.charAt(i));
		result.add('.');
		char[] realResult = new char[result.size()];
		for (int i=0; i < result.size(); i++)
			realResult[i] = result.get(i);
		return realResult;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer, int)
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
	 */
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
	 */
	public String getErrorMessage() {
		return "No proposals available";
	}
}
