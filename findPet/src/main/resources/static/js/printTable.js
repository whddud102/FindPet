function printTable(list) {
		var tbody = '';
		
		for(var i = 0; i < list.length; i++) {
			var item = list[i];
			
			tbody += '<tr>';
			tbody += '<td class="align-middle"><img src="' + item.filename + '"></td>';
			tbody += '<td class="align-middle">' + item.age + '</td>';
			tbody += '<td class="align-middle">' + item.kindCd + '</td>';
			tbody += '<td class="align-middle">' + item.weight + '</td>';
			tbody += '<td class="align-middle">' + (item.sexCd == 'F' ? '암컷' : '수컷') + '</td>';
			tbody += '<td class="align-middle">' + (item.neuterYn == 'Y' ? 'O' : 'X') + '</td>';
			tbody += '<td class="align-middle">' + item.specialMark + '</td>';
			tbody += '<td class="align-middle">' +  item.happenDt.replace(/(\d{4})(\d{2})(\d{2})/, '$1-$2-$3') + '</td>';
			tbody += '<td class="align-middle">' + item.happenPlace + '</td>';
			tbody += '<td class="align-middle">' + item.processState + '</td>';
			

			// 상세 정보 조회에 필요한 값을 저장하는 숨겨진 td 태그
			// 유기번호
			tbody += '<td class="d-none">' + item.desertionNo + '</td>';
			// 색상
			tbody += '<td class="d-none">' + item.colorCd + '</td>';
			// 공고번호
			tbody += '<td class="d-none">' + item.noticeNo + '</td>';
			// 공고시작일
			tbody += '<td class="d-none">' + item.noticeSdt + '</td>';
			// 공고 종료일
			tbody += '<td class="d-none">' + item.noticeEdt + '</td>';
			// 보호소 이름
			tbody += '<td class="d-none">' + item.careNm + '</td>';
			// 보호소 전화번호
			tbody += '<td class="d-none">' + item.careTel + '</td>';
			// 보호 장소
			tbody += '<td class="d-none">' + item.careAddr + '</td>';
			// 관할기관
			tbody += '<td class="d-none">' + item.orgNm + '</td>';
			// 담당자
			tbody += '<td class="d-none">' + item.chargeNm + '</td>';
			// 담당자 연락처
			tbody += '<td class="d-none">' + item.officetel + '</td>';
			
			tbody += '</tr>'; 
		}
		
		$('#tbody').html(tbody);
}