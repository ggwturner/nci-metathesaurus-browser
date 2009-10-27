#!/bin/csh -f

cd ../ncimbrowser
set CP=.
set CP="$CP":conf
set CP="$CP":build/web/WEB-INF/classes
foreach lib (lib/*.jar)
  set CP="$CP":"$lib"
end
foreach lib (../test/lib/*.jar)
  set CP="$CP":"$lib"
end
setenv CLASSPATH $CP

set java=(java -Xms2048m -Xmx2048m)
set class=gov.nih.nci.evs.browser.utils.test.MainTest
#set args=(-propertyFile /home/evsuser/apps/evs/ncim-webapp/conf/NCImBrowserProperties.xml)
set args=(-propertyFile /local/home/jboss45c/evs/ncim-webapp/conf/NCImBrowserProperties.xml)

set cmd = "$java $class $args"
echo $cmd
$cmd