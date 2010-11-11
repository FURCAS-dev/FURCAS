package com.sap.ide.cts.editor.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;

import com.sap.ide.cts.editor.matching.CtsDynamicMatcher;
import com.sap.ide.cts.editor.matching.CtsStaticMatcher;
import com.sap.ide.cts.editor.matching.ICtsDynamicMatcher;

public class CtsAutoEdit {
	CtsStaticMatcher ctsStaticMatcher;
	CtsDynamicMatcher ctsDynamicMatcher;
	ICtsDynamicMatcher iCtsDynamicMatcher;
	String indentLine="\t\t";
	
	public CtsAutoEdit(CtsStaticMatcher ctsStaticMatcher){
		this.ctsStaticMatcher=ctsStaticMatcher;		
		
	}
	
	public CtsAutoEdit(CtsDynamicMatcher ctsDynamicMatcher){
		
		this.ctsDynamicMatcher=ctsDynamicMatcher;
		
	}
	public CtsAutoEdit(ICtsDynamicMatcher iCtsDynamicMatcher){
		
		this.iCtsDynamicMatcher=iCtsDynamicMatcher;
		
	}
	private int findEndOfWhiteSpace(IDocument document, int offset, int end) throws BadLocationException {
		while (offset < end) {
			char c= document.getChar(offset);
			if (c != ' ' && c != '\t') {
				return offset;
			}
			offset++;
		}
		return end;
	}
	public boolean isNewLineDetected(IDocument d, DocumentCommand c){
		return c.length == 0 && c.text != null && TextUtilities.endsWith(d.getLegalLineDelimiters(), c.text) != -1;
	}
	private void shiftCarret(DocumentCommand c,int shiftToOffset) {
		c.shiftsCaret=false;
		c.doit=false;
		c.caretOffset=shiftToOffset;
		
	}
	public void autoEditAfterNewLine(IDocument d, DocumentCommand c) {

		if (c.offset == -1 || d.getLength() == 0) {
            return;
        }
		try {
						
			int p= (c.offset == d.getLength() ? c.offset  - 1 : c.offset);
			IRegion info= d.getLineInformationOfOffset(p);
			int start= info.getOffset();
			int endOfLineOffset = start+info.getLength();
			int end= findEndOfWhiteSpace(d, start, c.offset);
			
			StringBuffer buf= new StringBuffer(c.text);
			
			if (end > start) {
                buf.append(d.get(start, end - start));
            }
		
			if(ctsStaticMatcher!=null){
				String currentChar=""+d.getChar(endOfLineOffset-1);
				if ( ctsStaticMatcher.isIndentingChar(currentChar)&&c.offset==endOfLineOffset) {
					
					buf.append(indentLine);
					
					int shiftToOffset=c.offset+buf.length();
					
					if(ctsStaticMatcher.areBracesMatching(d)==false){
										
						
						buf.append('\n');
						buf.append(d.get(start, end - start));
						buf.append(ctsStaticMatcher.getClosingBrace());
						shiftCarret(c, shiftToOffset);
						
					}
				}
			}
			if(ctsDynamicMatcher!=null){
				String currentLine=d.get(start, endOfLineOffset - start);
				
				if ( ctsDynamicMatcher.isTagValid(currentLine)&&c.offset==endOfLineOffset) {
					
				        String lastTag=ctsDynamicMatcher.getLastOpeningTag(currentLine);
                                        String closingTag=ctsDynamicMatcher.getClosingTag(lastTag);
                                        int shiftToOffset=0;
                                        if(currentLine.indexOf(closingTag)<currentLine.indexOf(lastTag)){
                                                
                                                buf.append(this.ctsDynamicMatcher.setIndentLine());
                                                shiftToOffset=c.offset+buf.length();
                                        }
					
					if(ctsDynamicMatcher.areTagsMatching(d,lastTag)==false){
										
						buf.append('\n');
						buf.append(d.get(start, end - start));
						buf.append(ctsDynamicMatcher.getClosingTag(lastTag));
						shiftCarret(c, shiftToOffset);
						
					}
				}
			}	
				
			if(iCtsDynamicMatcher!=null){
				String currentLine=d.get(start, endOfLineOffset - start);
				
				if ( iCtsDynamicMatcher.isTagValid(currentLine)&&c.offset==endOfLineOffset) {
					
					String lastTag=iCtsDynamicMatcher.getLastOpeningTag(currentLine);
					
					buf.append(this.iCtsDynamicMatcher.setIndentLine());
					
					int shiftToOffset=c.offset+buf.length();
					
					if(iCtsDynamicMatcher.areTagsMatching(d,lastTag)==false){
										
						buf.append('\n');
						buf.append(d.get(start, end - start));
						buf.append(iCtsDynamicMatcher.getClosingTag(lastTag));
						shiftCarret(c, shiftToOffset);
						
					}
				}
			}	
			c.text= buf.toString();
			
		} catch (BadLocationException excp) {
			excp.printStackTrace();
		}
	}
	

}
