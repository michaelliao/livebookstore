@echo off
SET CLASSPATH=.\lib\core\hsqldb.jar
java org.hsqldb.util.DatabaseManagerSwing %1 %2 %3 %4 %5 %6 %7 %8 %9
