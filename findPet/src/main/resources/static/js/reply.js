console.log("Reply Manager load...");

var BASE_URL = "/replies";

var replyManager = (function() {


	var getAll = function(bno, callback){
		console.log("댓글 목록 조회...");
		$.getJSON(BASE_URL + "/" + bno, callback);
	};	
		
	var add = function(reply, callback){
		console.log("댓글 등록 요청");
		
		$.ajax({
			type : 'post',
			url : BASE_URL + '/new',
			data : JSON.stringify(reply),
			dataType : 'json',
			contentType: 'application/json',
			success : callback
		});
	};	
	
	var update = function(obj, callback){
		console.log("댓글 수정...");
	};
		
	var remove = function(obj, callback){
		console.log("remove...");
	};	
	
	return {
		getAll : getAll,
		add : add,
		update : update,
		remove : remove
	}
})();