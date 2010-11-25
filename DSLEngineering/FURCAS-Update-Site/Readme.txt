How to update the FURCAS update site

1) Synchronize features using "Synchronize button" in site.xml editor
2) "Build all" using site.xml editor
3) Delete content.jar and artifacts.jar from site project
4) Run launch config "Generate Update Site Content.jar"
5) Refresh Project
6) Upload site.xml, content.jar, artifacts.jar and directories "plugins" and "features" using ftp:
	ftp://www.furcas.org
	user: furcas
	pw: moin
7) Finished