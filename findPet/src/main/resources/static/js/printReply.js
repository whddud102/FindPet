function printReply(list) {
	var replyArea = $("#replyArea");
	var reply; 
	var str = "";
	
	console.log(list);
	
	for(var i = 0; i < list.length; i++) {
		reply = list[i];
		
		str += '<div class="row  d-flex justify-content-center mt-1 mb-1 w-100">';
		str +=		'<div class="col-md-10 col-lg-8">';
		str +=				'<div class="card">';
		str +=					'<div class="card-body row align-items-center">';
		str +=						'<div class="col-12 col-xl-3  mb-1 mb-xl-0">';
		str +=							'<span class="font-weight-bold d-xl-block mr-2"> ' + reply.nickname + '</span>'; 
		str +=							'<span class="d-xl-block">(' + formatDate(reply.created_datetime) + ')</span>';
		str +=						'</div >';
		str +=						'<hr>';
		str +=						'<div class="col-12 col-xl-7">';
		str +=							'<p>' + reply.contents + '</p>';
		str +=						'</div>';
		str +=						'<div class="col-12 col-xl-2">';
		str +=							'<div class="w-100 justify-content-center d-flex">';
		str +=								'<button type="button" id="btn_modify" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">수정</button>';
		str +=								'<button type="button" id="btn_remove" class="btn btn-danger btn-sm ml-1" data-toggle="modal"	data-target="#myModal">삭제</button>';
		str +=							'</div>';
		str +=						'</div>';
		str +=					'</div>';
		str +=				'</div>';
		str +=			'</div>';
		str +=		'</div>';
	}
	
	
	replyArea.html(str);
	
}