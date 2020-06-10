function getURI() {
	// 'yyyy-MM-dd'  -> 'yyyyMMdd' 변환
	var bgnde = $("#bgnde").val();
	if (bgnde != '') {
		var dateArr = bgnde.split('-');
		bgnde = dateArr[0] + dateArr[1] + dateArr[2];
	}

	// 'yyyy-MM-dd'  -> 'yyyyMMdd' 변환
	var endde = $("#endde").val();
	if (endde != '') {
		var dateArr = endde.split('-');
		endde = dateArr[0] + dateArr[1] + dateArr[2];
	}

	var upkind = $("#upkind").val();
	var kind = $("#kind").val();
	var upr_cd = $("#upr_cd").val();
	var org_cd = $("#org_cd").val();
	var shelter = $("#shelter").val();
	var neuter_yn = $("#neuter_yn").val();

	var currentPage = $("#pageNo").val(); // 현재 보고 있는 페이지 번호를 가진 input Tag

	var URI = '/api/search?';
	URI += "bgnde=" + bgnde;
	URI += "&endde=" + endde;
	URI += "&upkind=" + upkind;
	URI += "&kind=" + kind;
	URI += "&upr_cd=" + upr_cd;
	URI += "&org_cd=" + org_cd;
	URI += "&shelter=" + shelter;
	URI += "&neuter_yn=" + neuter_yn;
	URI += "&pageNo=" + currentPage;

	return URI;
}