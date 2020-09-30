/*
	LocalDateTime 형식의 시간을 포맷팅 해주는 함수
*/

function formatDate(timeValue) {
	var dateObj = new Date(timeValue);
	var month = dateObj.getMonth() + 1 >= 10 ? dateObj.getMonth() + 1 : '0' + (dateObj.getMonth() + 1);
	var date = dateObj.getDate() >= 10 ? dateObj.getDate() : '0' + dateObj.getDate();
	var hours = dateObj.getHours() >= 10 ? dateObj.getHours() : '0' + dateObj.getHours();
	var min = dateObj.getMinutes() >= 10 ? dateObj.getMinutes() : '0' + dateObj.getMinutes();
	var sec = dateObj.getSeconds() >= 10 ? dateObj.getSeconds() : '0' + dateObj.getSeconds();
	
	return month + "-" + date + " " + hours + ":" + min + ":" + sec;
}