@echo off

if "%JAVA_HOME%"=="" goto ERROR_NO_JAVA_HOME
if "%RESIN_HOME%"=="" goto ERROR_NO_RESIN_HOME

if not exist "%JAVA_HOME%" goto ERROR_NOTEXIST_JAVA_HOME
if not exist "%RESIN_HOME%" goto ERROR_NOTEXIST_RESIN_HOME

PATH=%JAVA_HOME%\bin;%PATH%
set RESIN_CONF=%CD%/resin.conf
CD web
%RESIN_HOME%\httpd -Djavax.xml.stream.XMLInputFactory=com.ctc.wstx.stax.WstxInputFactory -Djavax.xml.stream.XMLOutputFactory=com.ctc.wstx.stax.WstxOutputFactory -Djavax.xml.stream.XMLEventFactory=com.ctc.wstx.stax.WstxEventFactory -server-root %CD% -conf %RESIN_CONF%
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
