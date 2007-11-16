@echo off

if "%JAVA_HOME%"=="" goto ERROR_NO_JAVA_HOME
if "%RESIN_HOME%"=="" goto ERROR_NO_RESIN_HOME

if not exist "%JAVA_HOME%" goto ERROR_NOTEXIST_JAVA_HOME
if not exist "%RESIN_HOME%" goto ERROR_NOTEXIST_RESIN_HOME

PATH=%JAVA_HOME%\bin;%PATH%
%RESIN_HOME%\httpd -server-root %CD%/web -conf %CD%/resin.conf
goto END

:ERROR_NO_JAVA_HOME
echo Error: JAVA_HOME is not set.
pause
goto END

:ERROR_NOTEXIST_JAVA_HOME
echo ERROR: JAVA_HOME "%JAVA_HOME%" is not exist.
pause
goto END

:ERROR_NO_RESIN_HOME
echo ERROR: RESIN_HOME is not set.
pause
goto END

:ERROR_NOTEXIST_RESIN_HOME
echo ERROR: RESIN_HOME "%RESIN_HOME%" is not exist.
pause

:END
