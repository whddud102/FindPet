// 테이블의 행 클릭 시, 이벤트 처리 함수
$(document).ready(function() {
	$("#tbody").on("click", "tr", function(e) { 
		event.preventDefault();
		
		var tr = $(this);
		var td = tr.children();
		
		var age = td.eq(1).text();
		$("#age").val(age);
		
		var kindCd = td.eq(2).text();
		$("#kindCd").val(kindCd);
		
		var weight = td.eq(3).text();
		$("#weight").val(weight);
		
		var sexCd = td.eq(4).text();
		$("#sexCd").val(sexCd);
		
		var neuterYn = td.eq(5).text();
		$("#neuterYn").val(neuterYn);
		
		var specialMark = td.eq(6).text();
		$("#specialMark").val(specialMark);
		
		var happenDt = td.eq(7).text();
		$("#happenDt").val(happenDt);
		
		var happenPlace = td.eq(8).text();
		$("#happenPlace").val(happenPlace);
		
		var processState = td.eq(9).text();
		$("#processState").val(processState);
		
		var desertionNo = td.eq(10).text();
		$("#desertionNo").val(desertionNo);
		
		var colorCd = td.eq(11).text();
		$("#colorCd").val(colorCd);
		
		var noticeNo = td.eq(12).text();
		$("#noticeNo").val(noticeNo);
		
		var noticeSdt = td.eq(13).text();
		$("#noticeSdt").val(noticeSdt);
		
		var noticeEdt = td.eq(14).text();
		$("#noticeEdt").val(noticeEdt);
		
		var careNm = td.eq(15).text();
		$("#careNm").val(careNm);
		
		var careTel = td.eq(16).text();
		$("#careTel").val(careTel);
		
		var careAddr = td.eq(17).text();
		$("#careAddr").val(careAddr);
		
		var orgNm = td.eq(18).text();
		$("#orgNm").val(orgNm);
		
		var chargeNm = td.eq(19).text();
		$("#chargeNm").val(chargeNm);
		
		var officetel = td.eq(20).text();
		$("#officetel").val(officetel);
		
		var popfile = td.eq(21).text();
		$("#popfile").val(popfile);
		
		$("#detail_form").submit();
	});
});
		