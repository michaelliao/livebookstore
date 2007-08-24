REM step1: Install MySQL5
REM step2: Create MySQL user "bookstore" with password "livebookstore", and make sure has enough access rights
REM step3: set your "MySQL 5" root path and run this script

set MYSQL_HOME=C:\Program Files\MySQL\MySQL Server 5.0

"%MYSQL_HOME%\bin\mysqldump" --user=bookstore --password=livebookstore --skip-opt --single-transaction --quick --add-drop-table --default-character-set=utf8 bookstore > "bookstore_backup_%DATE%.sql"
