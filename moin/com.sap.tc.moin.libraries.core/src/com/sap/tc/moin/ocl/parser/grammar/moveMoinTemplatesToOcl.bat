cd ..\..\..\..\..\..\..\..\..\..\..\..\..\..
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

copy MoinLexerTemplate.g moin\moin.core\dev\src\_tc~moin~ocl~parser\libm\api\com\sap\tc\moin\ocl\parser\grammar
copy MoinParserTemplate.g moin\moin.core\dev\src\_tc~moin~ocl~parser\libm\api\com\sap\tc\moin\ocl\parser\grammar

copy btParserTemplateD.g moin\moin.core\dev\src\_tc~moin~ocl~parser\libm\api\com\sap\tc\moin\ocl\parser\grammar
copy dtParserTemplateD.g moin\moin.core\dev\src\_tc~moin~ocl~parser\libm\api\com\sap\tc\moin\ocl\parser\grammar
copy KeywordTemplateD.g moin\moin.core\dev\src\_tc~moin~ocl~parser\libm\api\com\sap\tc\moin\ocl\parser\grammar
copy KWLexerMap.g moin\moin.core\dev\src\_tc~moin~ocl~parser\libm\api\com\sap\tc\moin\ocl\parser\grammar
copy LexerBasicMap.g moin\moin.core\dev\src\_tc~moin~ocl~parser\libm\api\com\sap\tc\moin\ocl\parser\grammar
copy LexerTemplateD.g moin\moin.core\dev\src\_tc~moin~ocl~parser\libm\api\com\sap\tc\moin\ocl\parser\grammar

del MoinLexerTemplate.g
del MoinParserTemplate.g

del btParserTemplateD.g
del dtParserTemplateD.g
del KeywordTemplateD.g
del KWLexerMap.g
del LexerBasicMap.g
del LexerTemplateD.g

cd moin\moin.core\dev\src\_tc~moin~ocl~parser\libm\api\com\sap\tc\moin\ocl\parser\grammar

