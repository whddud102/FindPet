$(document).ready(function() {
	$("#pagination").on("click", "a", function(e) { 
		event.preventDefault();
		var targetPage = $(this).attr("href");
		
		$("#pageNo").val(targetPage);
		
		var URI = getURI();
		
		console.log("요청 URI : " + URI);
		
		$.getJSON(URI, function(result, textStatus, req) {
			printTable(result.petList);
			makePagination(result);
		});
	});
});
