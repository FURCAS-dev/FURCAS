rem *******************************************************************************
rem Copyright (c) 2006, 2009 SAP AG and others.
rem All rights reserved. This program and the accompanying materials
rem are made available under the terms of the Eclipse Public License v1.0
rem which accompanies this distribution, and is available at
rem http://www.eclipse.org/legal/epl-v10.html
rem
rem Contributors:
rem     SAP AG - initial API and implementation
rem *******************************************************************************
cd ..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\..
cd moin\moin.base\dev\src\_tc~moin~repository~util\libm\api\com\sap\tc\moin\repository\shared\util\parsers

copy MoinLexerTemplate.g ..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\
copy MoinParserTemplate.g ..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\

copy btParserTemplateD.g ..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\
copy dtParserTemplateD.g ..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\
copy KeywordTemplateD.g ..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\
copy KWLexerMap.g ..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\
copy LexerBasicMap.g ..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\
copy LexerTemplateD.g ..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\

cd ..\..\..\..\..\..\..\..\..\..\..\..\..\..\..\

copy MoinLexerTemplate.g moin\moin.core\dev\src\_tc~moin~query~moinql~impl\libm\api\com\sap\tc\moin\repository\core\query\moinql\parser\grammar
copy MoinParserTemplate.g moin\moin.core\dev\src\_tc~moin~query~moinql~impl\libm\api\com\sap\tc\moin\repository\core\query\moinql\parser\grammar

copy btParserTemplateD.g moin\moin.core\dev\src\_tc~moin~query~moinql~impl\libm\api\com\sap\tc\moin\repository\core\query\moinql\parser\grammar
copy dtParserTemplateD.g moin\moin.core\dev\src\_tc~moin~query~moinql~impl\libm\api\com\sap\tc\moin\repository\core\query\moinql\parser\grammar
copy KeywordTemplateD.g moin\moin.core\dev\src\_tc~moin~query~moinql~impl\libm\api\com\sap\tc\moin\repository\core\query\moinql\parser\grammar
copy KWLexerMap.g moin\moin.core\dev\src\_tc~moin~query~moinql~impl\libm\api\com\sap\tc\moin\repository\core\query\moinql\parser\grammar
copy LexerBasicMap.g moin\moin.core\dev\src\_tc~moin~query~moinql~impl\libm\api\com\sap\tc\moin\repository\core\query\moinql\parser\grammar
copy LexerTemplateD.g moin\moin.core\dev\src\_tc~moin~query~moinql~impl\libm\api\com\sap\tc\moin\repository\core\query\moinql\parser\grammar

del MoinLexerTemplate.g
del MoinParserTemplate.g

del btParserTemplateD.g
del dtParserTemplateD.g
del KeywordTemplateD.g
del KWLexerMap.g
del LexerBasicMap.g
del LexerTemplateD.g

cd moin\moin.core\dev\src\_tc~moin~query~moinql~impl\libm\api\com\sap\tc\moin\repository\core\query\moinql\parser\grammar

