/*
	password : 암호화 되지 않은 비밀번호
	id : 전달할 bno 또는 rno
	type : board 또는 reply를 구분
	
	return : 
		- 암호화 되지 않은 비밀번호와 게시글/댓글 구분 및 id를 전달하고 해당 게시글/댓글의 암호화된 비밀번호를 반환 받는다.
		- 성공할 경우 : 암호화 된 비밀번호, 실패할 경우 문자열 "false" 반환.
		
*/

function encryptPassword(password, id, type) {
	var URI = "/api/encrypt";
	var result;
	
	$.ajax({
		type : 'post',
		url :  URI,
		async : false,
		data : JSON.stringify({"password" : password, "id" : id, "type" : type}),
		contentType : "application/json; charset=utf-8",
		success : function(data, status, xhr) {
			result = data;
		},
		error: function(xhr, status, error) {
			console.log("비밀번호 암호화 요청 실패....");
			return false;
		}
	});
	
	return result;
}