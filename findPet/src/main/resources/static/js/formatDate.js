function formatDate(timeValue) {
	var dateObj = new Date("2016-10-27T01:02:03");
	var month = dateObj.getMonth() + 1 >= 10 ? dateObj.getMonth() + 1 : '0' + (dateObj.getMonth() + 1);
	var date = dateObj.getDate() + 1 >= 10 ? dateObj.getDate() + 1 : '0' + (dateObj.getDate() + 1);
	var hours = dateObj.getHours() + 1 >= 10 ? dateObj.getHours() + 1 : '0' + (dateObj.getHours() + 1);
	var min = dateObj.getMinutes() + 1 >= 10 ? dateObj.getMinutes() + 1 : '0' + (dateObj.getMinutes() + 1);
	var sec = dateObj.getSeconds() + 1 >= 10 ? dateObj.getSeconds() + 1 : '0' + (dateObj.getSeconds() + 1);
	
	return month + "-" + date + " " + hours + ":" + min + ":" + sec;
}