function makePagination(result) {
	var currentPage = result.pageNo;		
	var endPage = result.endPage;			// 전체 페이지의 끝
	var current_end_page = Math.ceil(currentPage / 10.0) * 10;	// 현재 보고 있는 10개 페이지의 끝
	var starPage = current_end_page - 9;

	// 현재 보고 있는 페이지의 끝 보다 전체 페이지의 끝이 더 작으면 현재 페이지의 끝을 전체 페이지의 끝으로 갱신
	if (endPage < current_end_page) {
		current_end_page = endPage;
	}

	var li = '';

	// prev를 표시해야하는 경우
	if (starPage != 1) {
		li += '<li class="page-item"><a class="page-link" href="'
				+ (starPage - 1) + '">&laquo;</a></li>'
	}

	for (var i = starPage; i <= current_end_page; i++) {

		if (i == currentPage) {
			li += '<li class="page-item active"><a class="page-link" href="'
					+ i + '">' + i + '</a></li>';
		} else {
			li += '<li class="page-item"><a class="page-link" href="' + i
					+ '">' + i + '</a></li>';
		}
	}

	// next가 true라면
	if (current_end_page != endPage) {
		li += '<li class="page-item"><a class="page-link" href="'
				+ (current_end_page + 1) + '">&raquo;</a></li>'
	}

	$("#pagination").html(li);
}
