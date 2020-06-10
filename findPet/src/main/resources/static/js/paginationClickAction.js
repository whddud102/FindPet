$(document).ready(function() {
	$("#pagination").on("click", "a", function(e) { 
		event.preventDefault();
		var targetPage = $(this).attr("href");
		
		$("#pageNo").val(targetPage);
		
		// 페이지 버튼 클릭 시, 클릭한  페이지 번호를 history에 저장
		history.replaceState({pageNo : targetPage}, null);
		
		var URI = getURI();
		
		console.log("요청 URI : " + URI);
		
		$.getJSON(URI, function(result, textStatus, req) {
			printTable(result.petList);
			makePagination(result);
		});
	});
});
