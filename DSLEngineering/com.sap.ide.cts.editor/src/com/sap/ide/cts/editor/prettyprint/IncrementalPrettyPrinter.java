package com.sap.ide.cts.editor.prettyprint;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.Template;
import textblocks.TextBlock;

import com.sap.furcas.textual.textblocks.TbChangeUtil;
import com.sap.furcas.textual.textblocks.TbNavigationUtil;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * This class enables incremental pretty printing by using the class PrettyPrinter.
 * However it extends the original non-incremental pretty printer by the possibility of
 * pretty printing particular model elements rather than only root elements.
 * @author Andreas Landerer
 * @version 1.0
 *
 */
public class IncrementalPrettyPrinter
{
	private TextBlock	rootBlock;

	/**
	 * Method starting incremental pretty printer
	 * @param rootTbs
	 * 					old text blocks existing for text block to be printed
	 * @param source
	 * 					correpsonding model element
	 * @param syntax
	 * 					concrete syntax of text block
	 * @param target
	 * 					extractor stream
	 * @param template
	 * 					template which is used for model element
	 * @throws SyntaxAndModelMismatchException
	 */
	public void prettyPrint(RefObject[] rootTbs, RefObject source,
			ConcreteSyntax syntax, TCSExtractorStream target,
			ClassTemplate template) throws SyntaxAndModelMismatchException
	{
		assert rootTbs != null;
		assert source != null;
		assert syntax != null;
		assert target != null;

		TextBlock parent = null;
		TextBlock oldTbForSource = null;
		PrettyPrintContext context = null;
		int iOldTbLength = 0;
		int iOldTbIndex = 0;
		int iOldOffset = 0;
		int iOldAbsoluteOffset = 0;
		String cachedString = null;
		String toDelete = null;

		// check if a textblock has already existed for the model element source
		// if there are more textblocks existing choose first one fitting
		for (RefObject o : rootTbs)
		{
			if (o instanceof TextBlock)
			{
				oldTbForSource = (TextBlock) o;
				iOldTbLength = oldTbForSource.getLength();

				// if template has no syntax contribution, pretty printing is
				// currently not possible
				if(oldTbForSource.getType() == null || !template.equals(oldTbForSource.getType().getParseRule()))
				{
					oldTbForSource = null;
					continue;
				}

				// if textblock has a parent, save reference to parent and cut
				// off oldTbForSource
				// build context
				if (oldTbForSource != null
						&& oldTbForSource.getParentBlock() != null)
				{
					parent = oldTbForSource.getParentBlock();
					iOldAbsoluteOffset = oldTbForSource.getAbsoluteOffset();
					iOldOffset = oldTbForSource.getOffset();
					iOldTbIndex = parent.getSubNodes().indexOf(oldTbForSource);
					context = new PrettyPrintContext();
					this.constructContext(context, oldTbForSource, source, syntax);
					parent.getSubBlocks().remove(oldTbForSource);

					// remove substring representing the removed textblock
					cachedString = TbNavigationUtil.getUltraRoot(parent)
							.getCachedString();
					if (cachedString != null)
					{
						toDelete = cachedString.substring(iOldAbsoluteOffset,
								iOldAbsoluteOffset + iOldTbLength);
						cachedString = cachedString.replace(toDelete, "");
					}
					parent.setCachedString(cachedString);
				}
				//oldTbForSource.refDelete();
				break;
			}
		}

		// text block is either subblock or root block
		// avoids pretty printing of text blocks with no syntax contribution
		if(oldTbForSource != null || rootTbs.length == 0)
		{
			if(oldTbForSource != null && target instanceof CtsTextBlockIncrementalTCSExtractorStream)
			{
				((CtsTextBlockIncrementalTCSExtractorStream)target).setOldTextBlock(oldTbForSource);
			}
			// call pretty printer with corresponding model element
			CtsPrettyPrinter.prettyPrint(source, syntax, target, template, context);
			if (target instanceof CtsTextBlockIncrementalTCSExtractorStream)
			{
				rootBlock = ((CtsTextBlockIncrementalTCSExtractorStream) target)
						.getRootBlock();

				// if textblock has got a parent, hang up rootBlock and modify
				// cachedString
				if (parent != null)
				{
					rootBlock.setOffset(iOldOffset);
					parent.getSubBlocks().add(iOldTbIndex, rootBlock);
					rootBlock.setParentBlock(parent);
					int lengthToAdd = rootBlock.getLength() - iOldTbLength;
					TbChangeUtil.updateOffsetsWithinTextBlock(rootBlock,
							lengthToAdd);
					TbChangeUtil.updateLengthAscending(parent, lengthToAdd);
					StringBuffer newCachedString = new StringBuffer(cachedString);
					newCachedString.insert(iOldAbsoluteOffset, rootBlock
							.getCachedString());
					TbNavigationUtil.getUltraRoot(rootBlock).setCachedString(
							newCachedString.toString());
				}
			}
		}
	}

	/**
	 * Method computing context for model element
	 * @param context
	 * 					context to be built
	 * @param textblock
	 * 					textblock to be pretty printed
	 * @param element
	 * 					model element that correpsonds to text block
	 * @param syntax
	 * 					syntax the pretty printer uses
	 */
	private void constructContext(PrettyPrintContext context, TextBlock textblock, RefObject element, ConcreteSyntax syntax)
	{
		assert(context != null);
		assert(textblock != null);
		assert(syntax != null);

		for(TextBlock parent = textblock.getParentBlock(); parent != null; parent = parent.getParentBlock())
		{
			Template t = parent.getType().getParseRule();
			ClassTemplate tp = null;
			if(t instanceof ClassTemplate)
			{
				tp = (ClassTemplate) t;

				if(tp != null)
				{
					context.getClassTemplates().add(0, tp);
					context.getParentRefObjects().add(0, parent.getCorrespondingModelElements().get(0));
				}
			}
		}
	}

//	private void buildContext(PrettyPrintContext context, TextBlock textblock,
//			TextBlock outermostParent, ConcreteSyntax syntax)
//	{
//		if (outermostParent == null)
//		{
//			outermostParent = TbNavigationUtil.getUltraRoot(textblock);
//		}
//		if (outermostParent != null && !outermostParent.equals(textblock))
//		{
//			RefObject outermostElement = null;
//			if (outermostParent.getCorrespondingModelElements().size() == 1)
//			{
//				outermostElement = outermostParent
//						.getCorrespondingModelElements().get(0);
//				Connection connection = outermostElement.get___Connection();
//				MQLProcessor mql = connection.getMQLProcessor();
//				// select corresponding templatee
//				String mqlTemplates = "select template \n"
//						+ "from \"demo.sap.com/tcsmeta\"#TCS::ClassTemplate as template, \n"
//						+ "\""
//						+ ((MofClass) outermostElement.refMetaObject())
//								.get___Mri() + "\" as class, \n" + "\""
//						+ syntax.get___Mri() + "\" as syntax \n"
//						+ "where template.metaReference = class" + "\n"
//						+ "where template.concreteSyntax = syntax";
//				MQLResultSet resultSet = mql.execute(mqlTemplates);
//				RefObject[] templates = resultSet.getRefObjects("template");
//				if (templates != null)
//				{
//					ClassTemplate tp = null;
//					// if there is more than 1 template determine which template
//					// to use
//					if (templates.length > 1)
//					{
//						// seek for main template
//						for (RefObject object : templates)
//						{
//							if (object instanceof ClassTemplate)
//							{
//								if (((ClassTemplate) object).isMain())
//								{
//									tp = (ClassTemplate) object;
//									break;
//								}
//							}
//						}
//						// if no template is main template choose template
//						// without mode
//						if (tp == null)
//						{
//							for (RefObject object : templates)
//							{
//								if (object instanceof ClassTemplate)
//								{
//									if (((ClassTemplate) object).getMode() == null)
//									{
//										tp = (ClassTemplate) object;
//										break;
//									}
//								}
//							}
//						}
//					}
//					// choose only template existing
//					else if (templates.length == 1)
//					{
//						if (templates[0] instanceof ClassTemplate)
//						{
//							tp = (ClassTemplate) templates[0];
//						}
//					}
//					// add Template to context
//					if (tp != null)
//					{
//						context.getVisitedModelElements().add(outermostParent);
//						context.getClassTemplates().push(tp);
//						context.getParentRefObjects().push(outermostElement);
//					}
//
//					// add templates of the corresponding subblocks to context
//					for (TextBlock child : outermostParent.getSubBlocks())
//					{
//						if (child != null
//								&& !context.getVisitedModelElements().contains(
//										child))
//						{
//							this
//									.buildContext(context, child, textblock,
//											syntax);
//						}
//					}
//				}
//			}
//		}
//	}

	public TextBlock getRootBlock()
	{
		return this.rootBlock;
	}
}
