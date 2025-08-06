@echo off
setlocal enabledelayedexpansion

echo.
echo Welcome to use XianLai - PWUtil
echo.
echo A Password Encryption and Decryption Tool Based on the Command Line
:loop
	echo.
	echo =======================================================
	echo.
	set opt=0
	set /p opt=Please select your option (1-Encryption, 2-Decryption, Q-Quit): 
	if %opt% == 0 (
		goto loop
	) else if %opt% == q (
		goto exit_loop
	) else if %opt% == Q (
		goto exit_loop
	) else if %opt% == 1 (
		set str=
		set /p str=Please enter plaintext: 
		set key_str=
		set /p key_str=Please enter key string: 
		echo.
        	echo [RUN] Run the encryption program: 
        	echo.
		echo Caution!!!
        	echo There may be a problem with entering special characters!
        	echo Please carefully check whether the input plaintext is the same as that read by the program!
		echo You should try to use special characters with the escape character '\' or avoid using special characters.
        	echo.
		java -jar pwutil.jar --en -e !str! !key_str!
		echo.
        	echo [STOP] The encryption program is finished
	) else if %opt% == 2 (
		set crypt_str=
		set /p crypt_str=Please enter ciphertext: 
		set key_str=
		set /p key_str=Please enter key string: 
		echo.
        	echo [RUN] Run the dncryption program: 
        	echo.
		java -jar pwutil.jar --en -d !crypt_str! !key_str!
		echo.
        	echo [STOP] The dncryption program is finished
	) else (
		echo Wrong option
	)
goto loop
:exit_loop
set str=
set key_str=
set crypt_str=

endlocal

