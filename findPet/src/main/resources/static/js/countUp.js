function countUp() {
	
	var totalCount = $("#totalCount").text();
	
	if(totalCount < 50) {
		$('.count-num').rCounter({
			duration : 20
		});	
	} else {
		$('.count-num').rCounter({
			duration : 30
		});	
	}
	
	
	console.log("countUp 수행 됨");
};