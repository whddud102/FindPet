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
		
		
		console.log("bgnde : " + bgnde);
		console.log("endde : " + endde);
		
		if (bgnde == '' || endde == '') {
			alert("검색 시작일과 종료일을 모두 선택해주세요");
			return false;
		}
		
		var bgnDate = new Date(bgnde);
		var endDate = new Date(endde);

		if (bgnDate > endDate) {
			alert("시작일은 종료일 보다 이전이어야 합니다");
			return false;
		} else if(endDate.getYear() - bgnDate.getYear() > 0 
				||  endDate.getMonth() - bgnDate.getMonth() > 3  
				||  endDate.getMonth() - bgnDate.getMonth() == 3 && endDate.getDate() - bgnDate.getDate() > 0) {
			alert("검색 가능 기간은 최대 3개월 입니다");
			return false;
		} 
		
		
		console.log("종료 Year - 시작 Year : " + (endDate.getYear() - bgnDate.getYear()));
		console.log("종료 Month - 시작 Month : " + (endDate.getMonth() - bgnDate.getMonth()));
		console.log("종료 Date - 시작 Date : " + (endDate.getDate() - bgnDate.getDate()));
		

		
		
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