Contains links to metamodel projects that should be 
available in the moin standalone (non-plugin) JUnit tests.
The plugin tests have all normally registered metamodels
available and are not affected by this configuration.

Eclipse setup needed to enable the links:

Go to Window->Preferenes and then
General -> Workspace -> Linked Resources.

Define path variables NGPM and DSL_ENGINEERING that point to the checkout folders of ngpm and DSLEngineering.
If projects are checked out into workspace directly (not imported as existing projects from svn checkout directory),
edit the linked resources section of this project's .project file
replacing NGPM and DSL_ENGINEERING with WORKSPACE.
Then add the linked resource path variable WORKSPACE and point it to the runtime workspace the test fixture folders
were checked out into.

NOTE: This test project needs a refresh after each change to the fixtures.

The subfolders link to moin/meta of the corresponding metamodel projects.
Each moin/meta folder must contain a metamodel.properties that is maintained manually conforming to this schema:

metaModelExtensionPackage=<metamodel.epi project extension package name>
facilityName=PF
partitionList=<partition names separated by semicolon>
version=1.0
metamodelId=<metamodelid>
label=<label>
vendor=<vendor>

A valid example:

metaModelExtensionPackage=com.sap.tc.moin.package6DBFA0FAF73913D04E1A01AB2E5C3D47D568CBAD
facilityName=PF
partitionList=moin/meta/abapMapping.moinmm;moin/meta/behavioral.moinmm;moin/meta/configuration.moinmm;moin/meta/data.moinmm;moin/meta/dataaccess.moinmm;moin/meta/deployment.moinmm;moin/meta/integration.moinmm;moin/meta/localization.moinmm;moin/meta/modelmanagement.moinmm;moin/meta/ngpm.moinmm;moin/meta/persistence.moinmm;moin/meta/ui.moinmm
version=1.0
metamodelId=sap.com/moin/mm/ap/core
label=ngpm
vendor=sap.com