@echo Start HSQLDB Server...
@echo Database file is stored at .\db\bookstore
@SET CLASSPATH=.\lib\core\hsqldb.jar
java org.hsqldb.Server -database.0 file:.\db\bookstore -dbname.0 bookstore