<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 입력 속성</title>

<style type="text/css">
</style>

</head>
<body>

	<form>
		<fieldset>
			<legend>disabled 속성과 readonly 속성</legend>
			<p>
				<label for="identification">인증번호</label>
				<input type="text" id="identification" 
					title="인증번호 입력">
				<input type="button" value="이전">
				<input type="button" value="다음" disabled="disabled">
			</p>
			<p>
				<label for="book">선택한 책</label>
				<input type="text" id="book" value="반응형 웹" 
					readonly="readonly"> 
				<label for="quantity">수량</label>
				<input type="number" id="quantity" min="1" value="1" 
					title="수량 입력">
			</p>
		</fieldset>
	</form>

</body>
</html>