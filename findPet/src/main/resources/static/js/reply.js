console.log("Reply Manager load...");

var BASE_URL = "/replies";

var replyManager = (function() {


	var getAll = function(bno, callback){
		$.getJSON(BASE_URL + "/" + bno, callback);
	};	
		
	var add = function(reply, callback){
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
		
	var remove = function(rno, callback){
		$.ajax({
			type : 'delete',
			url : BASE_URL + '/' + rno,
			dataType : 'json',
			contentType: 'application/json',
			success : callback
		});
		
	};
		
	
	return {
		getAll : getAll,
		add : add,
		update : update,
		remove : remove
	}
})();