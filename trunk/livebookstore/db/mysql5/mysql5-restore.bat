REM step1: Install MySQL5
REM step2: Create MySQL user "bookstore" with password "livebookstore", and make sure has enough access rights
REM step3: set your "MySQL 5" root path and run this script, then enter root password

set MYSQL_HOME=C:\Program Files\MySQL\MySQL Server 5.0

"%MYSQL_HOME%\bin\mysql" -u root -p --default-character-set=utf8 bookstore < backup.sql
pause
