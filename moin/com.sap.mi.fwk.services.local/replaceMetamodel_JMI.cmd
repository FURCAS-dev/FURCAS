
rem com.sap.mi.tg		com.sap.mm.tg
rem com.sap.mi.tools	com.sap.mm.tools
rem com.sap.ide.mi.tg       com.sap.ide.mm.tg

rem MITG                  MMTG 


SET SCRIPTHOME=%MITG_SRCDIR%\utility\scripts\sar
SET TARGET_FOLDER=api


perl %SCRIPTHOME%\renamefolders.pl -r com.sap.ide.metamodel.query.api  com.sap.mi.fwk.query.api           %TARGET_FOLDER%


perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.mi.fwk.qu.   com.sap.mi.fwk.query. . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.ide.metamodel.general.query.   com.sap.mi.fwk.query. . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.ide.metamodel.general.query   com.sap.mi.fwk.query . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.ide.metamodel.general.DevelopmentObject   javax.jmi.reflect.RefBaseObject . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.ide.metamodel.general.MetamodelObject   javax.jmi.reflect.RefBaseObject . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.ide.metamodel.general.Root  javax.jmi.reflect.RefPackage . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.ide.metamodel.general.metainfo.MetaClass  javax.jmi.model.MofClass . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.ide.metamodel.general.metainfo.Aggregation   javax.jmi.model.Association . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.ide.metamodel.general.metainfo.Association   javax.jmi.model.Association . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.ide.metamodel.general.metainfo.Relation   javax.jmi.model.Association . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g com.sap.ide.metamodel.general.metainfo.Property   javax.jmi.model.Attribute . %TARGET_FOLDER%
perl %SCRIPTHOME%\sarplain.pl   -r -g MetamodelObject   RefBaseObject . %TARGET_FOLDER%

perl %SCRIPTHOME%\sarplain.pl   -r -g MetaClass  MofClass . %TARGET_FOLDER%


