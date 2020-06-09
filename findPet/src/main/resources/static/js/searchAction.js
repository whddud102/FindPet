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
		
	});
	