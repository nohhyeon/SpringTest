<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 삭제</title>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#deleteBtn").click(function() {
			var id = $('#id').val();
			if (id.trim() === "")
				return;
			$.ajax({
				url : './id_Delete/' + id,
				type : 'delete',
				dataType : 'json',
				contentType : 'application/json',
				data : id,
				success : function(result) {
					console.log("아이디 값 - " + result.result);
					if (result.result == 1)
						alert("아이디가 삭제되었습니다.");
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<form id="signupForm">
			<fieldset>
				<div class="form-group row form-inline">
					<label for="id" class="ml-sm-3 col-form-label"> 아이디 </label>
					<div class="ml-sm-3">
						<input type="text" name="id" id="id" class="form-control mr-sm-2">
					</div>
					<button type="button" class="btn btn-outline-secondary"
						id="deleteBtn">아이디 삭제</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>