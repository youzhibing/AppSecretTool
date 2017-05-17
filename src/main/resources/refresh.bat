@echo off & setlocal enabledelayedexpansion
@set APP_HOME=%~dp0

set LIB_JARS=""

FOR %%i IN (%APP_HOME%*.jar) DO ( 
set LIB_JARS=!LIB_JARS!;%%i
)

set /p var0=input password:
java -classpath %CLASSPATH%;%LIB_JARS% -Xms256m -Xmx512m com.lee.you.tool.RefreshMain %var0%
pause