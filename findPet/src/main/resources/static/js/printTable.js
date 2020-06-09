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
			tbody += '</tr>'; 
		}
		
		$('#tbody').html(tbody);
}