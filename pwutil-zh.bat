@echo off
setlocal enabledelayedexpansion

echo.
echo ��ӭʹ�� XianLai - PWUtil
echo.
echo ����һ�����������е�����ӽ��ܹ���
:loop
	echo.
	echo =======================================================
	echo.
	set opt=0
	set /p opt=��ѡ����� (1-����, 2-����, Q-�˳�): 
	if %opt% == 0 (
		goto loop
	) else if %opt% == q (
		goto exit_loop
	) else if %opt% == Q (
		goto exit_loop
	) else if %opt% == 1 (
		set str=
		set /p str=����������: 
		set key_str=
		set /p key_str=��������Կ: 
		echo.
        	echo [RUN] ִ�м��ܳ���: 
        	echo.
		echo ��ע�⡿
        	echo ���������ַ����ܳ������⣡������˶����������������ȡ�������Ƿ���ͬ��
        	echo ��Щ���������ʱ�޷��������м�ġ�\$����ض���������ģ�Ӧ��������ʹ�������ַ�����ʹ��ת���ַ���\������
        	echo.
		java -jar pwutil.jar --zh -e !str! !key_str!
		echo.
        	echo [STOP] ���ܳ���ִ�����
	) else if %opt% == 2 (
		set crypt_str=
		set /p crypt_str=����������: 
		set key_str=
		set /p key_str=��������Կ: 
		echo.
        	echo [RUN] ִ�н��ܳ���: 
        	echo.
		java -jar pwutil.jar --zh -d !crypt_str! !key_str!
		echo.
        	echo [STOP] ���ܳ���ִ�����
	) else (
		echo �������
	)
goto loop
:exit_loop
set str=
set key_str=
set crypt_str=

endlocal

