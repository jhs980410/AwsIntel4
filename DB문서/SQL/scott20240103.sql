

SELECT SUBSTR('Welcome To Oracle', 3, 4), SUBSTRB('Welcome To Oracle', 3, 4)
FROM DUAL;

SELECT SUBSTR('웹컴투오라클', 3, 4), SUBSTRB('웹컴투오라클', 3, 4)
FROM DUAL;

SELECT instr('Welcome To Oracle', 'O')
FROM DUAL;

SELECT instr('WELCOME TO ORACLE', 'O', 6, 2) , instr('WELCOME TO ORACLE', 'O')
FROM DUAL;

SELECT LPAD('ORACLE', 20, '#') , RPAD('ORACLE', 20, '#') -- 계단식?
FROM DUAL;

SELECT LTRIM('  ORACLE  ') , RTRIM('  ORACLE  '), TRIM('  ORACLE  ') ㅁ
FROM DUAL;

SELECT TRIM('a' from 'aaaaOracleaaaa')
FROM DUAL;

SELECT CONCAT(PLAYER_NAME, ' 축구선수') 선수명, PLAYER_NAME || ' 축구선수' 선수명
FROM PLAYER;

--날짜형 함수 -> 검증 영수증
SELECT SYSDATE - 1 어제, SYSDATE, SYSDATE + 1 내일
FROM DUAL;

--25/01/06	25/01/07	25/01/08
--25/01/02	25/01/03	25/01/04

--SYSDATE?  가상 컬럼
--오라클에서 사용할 수 있는 예약어
--현재 날짜 데이터를 시스템에서 가져올 수 있다


SELECT HIREDATE, SYSDATE - HIREDATE 근무일수, (SYSDATE - HIREDATE) / 365
FROM EMP;

SELECT HIREDATE, ROUND(HIREDATE, 'MONTH')
FROM EMP;

SELECT HIREDATE, TRUNC(HIREDATE, 'MONTH')
FROM EMP;

SELECT ENAME, SYSDATE, HIREDATE, MONTHS_BETWEEN(SYSDATE, HIREDATE) "두 날짜의 개월수 차이"
FROM EMP;

SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) 개월수추가
FROM EMP;

SELECT SYSDATE, NEXT_DAY(SYSDATE, '수요일') 가장가까운수요일
FROM DUAL;

SELECT HIREDATE, LAST_DAY(HIREDATE) "해당달의 마지막 날짜"
FROM EMP;

SELECT EXTRACT(YEAR FROM HIREDATE) 입사년도
,   EXTRACT(MONTH FROM HIREDATE) 월
,   EXTRACT(DAY FROM HIREDATE) 일
FROM EMP;


--SELECT 1 년, '일', '시', '분', '초'
--FROM DUAL;

SELECT 1 초, 1 * 60 초, 61 초, '1분 1초' "1분 1초"
FROM DUAL;

SELECT 1 초, 1 * 60 초, 1 분, 1 * 60 분, 1 시간, 1 * 24, 1 일
FROM DUAL;

--하루의 초단위,      870423이라는 초는 몇 시간인가(시간 이외에는 내림처리한다)
                
--포맷터(FORMAT)
--문자열
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY')
FROM DUAL;

SELECT SYSDATE, SYSDATE - '80/12/17', SYSDATE - '1980/12/17'
FROM DUAL;

SELECT *
FROM EMP;

DESC EMP;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD DY, HH24 : MI : SS')
FROM DUAL;

-- 숫자형을 문자형으로 변환하기
SELECT TO_CHAR(123456789), TO_CHAR(123456789) * 100, '23234' + 1
FROM DUAL;
--안된다

SELECT TO_CHAR(123456789, 'L999,999'), TO_CHAR(123456789, 'L999,999,999')
FROM DUAL;

SELECT TO_CHAR(123456789, 'L999,999') + 1
FROM DUAL;

SELECT TO_CHAR(123456789, '000000000'), TO_CHAR(123456789, '000,000,000'), 
    TO_CHAR(123456789, 'L000,000,000')
FROM DUAL;

SELECT '30,000' - '10,000'
FROM DUAL;

SELECT TO_NUMBER('30,000', '999999') - TO_NUMBER('10,000', '00,000')
FROM DUAL;


--년차 증명하는 로직
SELECT ((2025*365*24*60*60*1)-(2024*365*24*60*60*1))/(365*24*60*60*1)||'년차' 경력
FROM DUAL;

SELECT CEIL((((2025*365*24*60*60*1)+1)-(2024*365*24*60*60*1))/(365*24*60*60*1))||'년차' 경력
FROM DUAL;
