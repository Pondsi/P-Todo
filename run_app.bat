@echo off
cd /d "%~dp0"
java -jar target\team-todo-1.0.0.jar > tmp_run.log 2>&1
echo EXIT_CODE=%ERRORLEVEL% >> tmp_run.log
