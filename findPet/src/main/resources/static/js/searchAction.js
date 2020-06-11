$(document).ready(function() {
		
		// 동적으로 선택한 시/도에 맞는 시/군/구 목록을 불러오는 코드
		$('#upr_cd').change(function(){
			
			var upr_cd = $("#upr_cd option:selected").val();
			var option = '<option value="" selected>전체</option>';
			
			if(upr_cd != '') {
				$.getJSON("/api/sigungu/" + upr_cd, function(list, textStatus, req) {
					
					
					$("#org_cd").html(option);
					$("#shelter").html('<option value="" selected>시/군/구를 먼저 선택해주세요</option>');
					
					for(var i = 0; i < list.length; i++) {
						var sigungu = list[i];
						option = '<option value="' + sigungu.orgCd + '">' + sigungu.orgdownNm + '</option>';
						$("#org_cd").append(option);
					}
				});
			} else {
				$("#org_cd").html('<option value="" selected>시/도를 먼저 선택해주세요</option>');
				$("#shelter").html('<option value="" selected>시/군/구를 먼저 선택해주세요</option>');
			}
		});
		
		// 동적으로 선택한 시/군/구에 맞는 보호소 목록을 불러오는 코드
		$('#org_cd').change(function(){
			
			var upr_cd = $("#upr_cd option:selected").val();
			var org_cd = $("#org_cd option:selected").val();
			var option = '<option value="" selected>전체</option>';
			
			
			if(upr_cd != '') {
				$.getJSON("/api/shelter/" + upr_cd + "/" + org_cd, function(list, textStatus, req) {
					
					console.log("====== 해당 보호소 =========");
					console.log(list);
					
					$("#shelter").html(option);
					
					for(var i = 0; i < list.length; i++) {
						var shelter = list[i];
						option = '<option value="' + shelter.careRegNo + '">' + shelter.careNm + '</option>';
						$("#shelter").append(option);
					}
				});
			}
		});
		
		// 동적으로 선택한 축종에 맞는 품종 목록을 불러오는 코드
		$('#upkind').change(function(){
			
			var upkind = $("#upkind option:selected").val();
			
			var option = '<option value="" selected>전체</option>';
			
			if(upkind != '') {
				$.getJSON("/api/kind/" + upkind, function(list, textStatus, req) {
					
					$("#kind").html(option);
					
					for(var i = 0; i < list.length; i++) {
						var kind = list[i];
						
						option = '<option value="' + kind.kindCd + '">' + kind.knm + '</option>';
						$("#kind").append(option);
					}
				});
			} else {
				$("#kind").html(option);
			}
		});
		
		
		$("#bgnde").change(function() {
			
			// 선택된 날짜 값을 Date 객체로 가져옴
			var bgnde = $("#bgnde").val();
			var bgnDate = new Date(bgnde);
			
			
			var year = bgnDate.getFullYear();
			var maxYear = year;
			
			var month = bgnDate.getMonth() + 1;
			var maxMonth;
			
			
			
			
			// month 계산
			if(month > 9)  {
				console.log("month 가 6보다큽니다");
				maxYear++;
				maxMonth = month - 9
			} else {
				console.log("month 가 6보다 작습니다");
				maxMonth = month + 3;
			}
			
			// day 계산
			var day = bgnDate.getDate();
			var maxDay = day;
			
			var lastDay = (new Date(maxYear, maxMonth, 0)).getDate();
			
			// 계산한 날이 실제 마지막 날 보다 큰 경우 다음달로 넘겨주는 코드
			if(day > lastDay) {
				maxDay = day - lastDay;
				maxMonth++;
			}
			
			// day, month 를 두 자리로 포맷팅
			day = day < 10 ? '0' + day : day;
			maxDay = maxDay < 10 ? '0' + maxDay : maxDay;
			
			month = month < 10 ? '0' + month : month;
			maxMonth = maxMonth < 10 ? '0' + maxMonth : maxMonth;
			
			
			var min = [year, month, day].join('-');
			var max = [maxYear, maxMonth, maxDay].join('-');
			
			console.log(min + " ~ " + max);
			console.log(maxMonth + "의 마지막 일 : " + lastDay);
			
			$("#endde").attr("min", min);
			$("#endde").attr("max", max);
		});
	
		/*
		$("#endde").change(function() {
			
			// 선택된 날짜 값을 Date 객체로 가져옴
			var endde = $("#endde").val();
			var endDate = new Date(endde);
			
			var year = endDate.getFullYear();

			var minMonth = endDate.getMonth() + 1;
			var maxMonth = (endDate.getMonth() + 1) + 6;
			minMonth = minMonth < 10 ? '0' + minMonth : minMonth;
			maxMonth = maxMonth < 10 ? '0' + maxMonth : maxMonth;

			var date = endDate.getDate();
			date = date < 10 ? '0' + date : date;
				
			var min = [year, minMonth, date].join('-');
			var max = [year, maxMonth, date].join('-');
			
			console.log("min : " + min);
			console.log("max : " + max);
			
			$("#bgnde").attr("min", min);
			$("#bgnde").attr("max", max);
		});
		*/
	});
	
