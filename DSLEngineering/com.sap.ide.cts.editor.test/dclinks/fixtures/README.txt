Contains links to fixture model projects that should
be available in moin (plugin) JUnit tests.
Not available in the standalone environment.

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

The fixtures subfolders link to the src folders of the fixture projects.