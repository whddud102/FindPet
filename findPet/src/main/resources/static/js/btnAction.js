$(document).ready(function() {

	$("#searchBtn").on("click", function(e) {
		e.preventDefault();

		var bgnde = $("#bgnde").val();
		var endde = $("#endde").val();

		var upkind = $("#upkind").val();
		var kind = $("#kind").val();
		var upr_cd = $("#upr_cd").val();
		var org_cd = $("#org_cd").val();
		var shelter = $("#shelter").val();
		var state = $("#state").val();
		var neuter_yn = $("#neuter_yn").val();

		if (bgnde == '' || endde == '') {
			alert("검색 시작일과 종료일을 모두 선택해주세요");
			return false;
		}

		var bgnDate = new Date(bgnde);
		var endDate = new Date(endde);

		if (bgnDate > endDate) {
			alert("시작일은 종료일 보다 이전이어야 합니다");
			return false;
		}

		console.log("bgnde  : " + bgnde);
		console.log("endde  : " + endde);
		console.log("upkin  : " + upkind);
		console.log("kind  : " + kind);
		console.log("upr_cd  : " + upr_cd);
		console.log("org_cd  : " + org_cd);
		console.log("shelter  : " + shelter);
		console.log("state  : " + state);
		console.log("neuter_yn  : " + neuter_yn);
		console.log("==================\n\n");

		$('#searchForm').submit();
	});
});