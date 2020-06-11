function showDetail(id) {
	
	var detail_datas = $(id).find("span");
	
	$("#age").val(detail_datas[0].innerHTML);
	$("#colorCd").val(detail_datas[1].innerHTML);
	$("#kindCd").val(detail_datas[2].innerHTML);
	$("#sexCd").val(detail_datas[3].innerHTML);
	$("#neuterYn").val(detail_datas[4].innerHTML);
	$("#specialMark").val(detail_datas[5].innerHTML);
	$("#weight").val(detail_datas[6].innerHTML);
	$("#happenDt").val(detail_datas[7].innerHTML);
	$("#happenPlace").val(detail_datas[8].innerHTML);
	$("#orgNm").val(detail_datas[9].innerHTML);
	$("#processState").val(detail_datas[10].innerHTML);
	$("#desertionNo").val(detail_datas[11].innerHTML);
	$("#noticeNo").val(detail_datas[12].innerHTML);
	$("#noticeSdt").val(detail_datas[13].innerHTML);
	$("#noticeEdt").val(detail_datas[14].innerHTML);
	$("#careNm").val(detail_datas[15].innerHTML);
	$("#careTel").val(detail_datas[16].innerHTML);
	$("#careAddr").val(detail_datas[17].innerHTML);
	$("#chargeNm").val(detail_datas[18].innerHTML);
	$("#officetel").val(detail_datas[19].innerHTML);
	$("#popfile").val(detail_datas[20].innerHTML);
	
	$("#detail_form").submit();
}