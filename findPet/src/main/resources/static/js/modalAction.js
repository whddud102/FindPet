// 모달창을 보여줄 때 필요한 파라미터를 셋팅하고 모달창을 출력하는 함수
function showModal(id, type, mode, contents) {
	
	$(".modal-footer").data("mode", mode);
	$(".modal-footer").data("type", type);	// 지정된 타입의 비밀번호 암호화를 요청 (게시판 : board, 댓글 : reply)
	$(".modal-footer").data("id", id);	// data-id 에 bno 값을 세팅
	
	if(mode == "modify_reply") {
		$(".modal-footer").data("contents", contents);	// data-contents 에 댓글 내용을 셋팅
	}
	
	$('#myModal').modal('show');
	$("#password").focus();
};


// 댓글 수정 모달창을 보여주거나 감추는 함수
function replyModifyModal(action) {
	if(action == "show") {
		var contents = $(".modal-footer").data("contents");
	
		$("#modalLongTitle").text("댓글 수정");
		$("#contents_modifyReply").removeClass('d-none');
		$("#modalBtn_modifyReply").removeClass('d-none');
		$("#btn_ok").addClass("d-none");
		$("#password").addClass("d-none");
		$("#contents_modifyReply").val(contents);
		
	} else if(action == "hide") {
		$('#myModal').modal('hide');
			
		$("#password").val("");
		$("#contents_modifyReply").val('');
			
		$("#modalLongTitle").text("비밀번호");
		$("#contents_modifyReply").addClass('d-none');
		$("#modalBtn_modifyReply").addClass('d-none');
		$("#btn_ok").removeClass("d-none");
		$("#password").removeClass("d-none");
	}
};