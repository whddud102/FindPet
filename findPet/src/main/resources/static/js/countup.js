$(function() {
	
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
});