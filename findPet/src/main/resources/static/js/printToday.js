
function printToday(result) {	
	
		if(result.prev == false) {
			$("#left_btn").css('visibility', 'hidden');
		} else {
			$("#left_btn").css('visibility', 'visible');
			$("#left_btn").css('background-color', '#e3f2fd');
		}
		
		if(result.next == false) {
			$("#right_btn").css('visibility', 'hidden');
		} else {
			$("#right_btn").css('visibility', 'visible');
			$("#right_btn").css('background-color', '#e3f2fd');
		}
		
		$('#card_row').html("");
		
		var petList = result.petList;
		
		for(var i = 1; i <= 4; i++) {
			// items의 인덱스는 0부터 시작하므로 1을 빼서 가져옴
			var item = petList[i-1];
			
			var cardStr = '';
			
			if(i <= petList.length) {
			
				cardStr += '<div class="col-xl-6">';
				cardStr += 		'<div id="card' + i + '" class="card mb-2 border-dark px-4 py-2" style="min-width: 18rem; background-color: #FDFEF2; border-radius : 20px;">'; 
				cardStr += 			'<div class="row no-gutters h-100">';
				
				// Card Image
				cardStr += 				'<div class="col-md-4 d-flex align-items-center justify-content-center">';
				cardStr +=	 					'<img class="card-img img-thumbnail" src=' + item.popfile  + '  alt="이미지 출력 불가">';
				cardStr += 				'</div>';
				// Card Image End
				
				// Card Body
				cardStr +=				'<div class="col-md-8 d-flex align-items-center">';
				cardStr += 					'<div class="card-body pl-0">';
				cardStr += 						'<ul id="card_info">';
				cardStr += 							'<li class="m-1">나이 : <span class="font-weight-bold">' + item.age + '</span></li>';
				cardStr += 							'<li class="m-1">색상 : <span class="font-weight-bold">' + item.colorCd + '</span></li>';
				cardStr += 							'<li class="m-1">품종 : <span class="font-weight-bold">' + item.kindCd + '</span></li>';
				cardStr += 							'<li class="m-1">성별 : <span class="font-weight-bold">' + (item.sexCd == 'F' ? '암컷' : '수컷') + '</span></li>';
				cardStr += 							'<li class="m-1">중성화 여부 : <span class="font-weight-bold">' + (item.neuterYn == 'Y' ? 'O' : 'X') + '</span></li>';
				cardStr += 							'<li class="m-1">특징 : <span class="font-weight-bold">' + item.specialMark + '</span></li>';
				cardStr += 							'<li class="m-1">체중 : <span class="font-weight-bold">' + item.weight + '</span></li>';
				cardStr +=							 '<li class="m-1">발견날짜 : <span class="font-weight-bold">' + item.happenDt.replace(/(\d{4})(\d{2})(\d{2})/, '$1-$2-$3') + '</span></li>';
				cardStr +=							 '<li class="m-1">발견장소 : <span class="font-weight-bold">' + item.happenPlace + '</span></li>';
				cardStr += 							'<li class="m-1">관할기관 : <span class="font-weight-bold">' + item.orgNm + '</span></li>';
				cardStr += 							'<li class="m-1">상태 : <span class="font-weight-bold">' + item.processState + '</span></li>';
													
													// 상세 페이지 조회를 위한 hidden 태그
				cardStr += 							'<li class="d-none"><span>' + item.desertionNo + '</span></li>';
				cardStr += 							'<li class="d-none"><span>' + item.noticeNo + '</span></li>';
				cardStr += 							'<li class="d-none"><span>' + item.noticeSdt + '</span></li>';
				cardStr += 							'<li class="d-none"><span>' + item.noticeEdt + '</span></li>';
				cardStr += 							'<li class="d-none"><span>' + item.careNm + '</span></li>';
				cardStr += 							'<li class="d-none"><span>' + item.careTel + '</span></li>';
				cardStr += 							'<li class="d-none"><span>' + item.careAddr + '</span></li>';
				cardStr += 							'<li class="d-none"><span>' + item.chargeNm + '</span></li>';
				cardStr += 							'<li class="d-none"><span>' + item.officetel + '</span></li>';
				cardStr += 							'<li class="d-none"><span>' + item.popfile + '</span></li>';
				cardStr +=						'</ul>';
				cardStr += 					'</div>';
				cardStr += 				'</div>';
				// Card Body End
				
				cardStr += 			'</div>';
				cardStr += 		'</div>';
				cardStr += 	'</div>';
			
			} else {
				cardStr += '<div class="col-xl-6"></div>';
			}
			
			$("#card_row").append(cardStr);
		}
};