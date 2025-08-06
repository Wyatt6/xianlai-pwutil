@echo off
setlocal enabledelayedexpansion

echo.
echo 欢迎使用 XianLai - PWUtil
echo.
echo 这是一个基于命令行的密码加解密工具
:loop
	echo.
	echo =======================================================
	echo.
	set opt=0
	set /p opt=请选择操作 (1-加密, 2-解密, Q-退出): 
	if %opt% == 0 (
		goto loop
	) else if %opt% == q (
		goto exit_loop
	) else if %opt% == Q (
		goto exit_loop
	) else if %opt% == 1 (
		set str=
		set /p str=请输入明文: 
		set key_str=
		set /p key_str=请输入密钥: 
		echo.
        	echo [RUN] 执行加密程序: 
        	echo.
		echo 【注意】
        	echo 输入特殊字符可能出现问题！请认真核对输入的明文与程序读取的明文是否相同！
        	echo 有些情况程序暂时无法处理，如中间的‘\$’会截断输入的明文，应尽量避免使用特殊字符，或使用转义字符‘\’处理。
        	echo.
		java -jar pwutil.jar --zh -e !str! !key_str!
		echo.
        	echo [STOP] 加密程序执行完毕
	) else if %opt% == 2 (
		set crypt_str=
		set /p crypt_str=请输入密文: 
		set key_str=
		set /p key_str=请输入密钥: 
		echo.
        	echo [RUN] 执行解密程序: 
        	echo.
		java -jar pwutil.jar --zh -d !crypt_str! !key_str!
		echo.
        	echo [STOP] 解密程序执行完毕
	) else (
		echo 输入错误
	)
goto loop
:exit_loop
set str=
set key_str=
set crypt_str=

endlocal

