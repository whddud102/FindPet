$(document).ready(function() {

	// 날짜 입력 태그의 최대 날짜를 오늘 이후로는 선택할 수 없도록 설정
	var today = new Date();
	var year = today.getFullYear();

	var month = today.getMonth() + 1;
	month = month < 10 ? '0' + month : month;

	var date = today.getDate();
	date = date < 10 ? '0' + date : date;

	var maxDate = [year, month, date].join('-');

	$("#bgnde").attr("max", maxDate);
	$("#endde").attr("max", maxDate);
	
});
