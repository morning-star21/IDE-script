@echo off
setlocal enabledelayedexpansion

:loop
REM === generate two random numbers between 10 and 99 ===
set /a k=%random% %% 90 + 10
set /a m=%random% %% 90 + 10

REM === take the max of k and m ===
if %k% GEQ %m% (
  set max=%k%
) else (
  set max=%m%
)

REM === calculate wait time (600000 / max) in seconds ===
set /a wait=600000/%max%/1000

echo === %k%, %m%, %wait%s ===
echo CYCLE

for /l %%i in (1,1,%max%) do (
  set /a r=%random% %% 100
  for /f "tokens=* delims=" %%t in ('powershell -command "Get-Date -Format yyyy-MM-dd_HH:mm:ss"') do set ts=%%t
  powershell -command "$wshell = New-Object -ComObject wscript.shell; $wshell.SendKeys('%')"
  echo KC !r! !ts!
  timeout /nobreak /t %wait% >nul
)

goto loop
