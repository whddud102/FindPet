$(document).ready(
		function() {
			$(function() {
				$("#bgnde").datepicker(
						{
							onClose : function(selectedDate) {
								var maxDate = $(this).datepicker("getDate");
								if (maxDate != null) {
									maxDate.setMonth(maxDate.getMonth() + 3);

									$("#endde").datepicker("option",
											"minDate", selectedDate);
									$("#endde").datepicker("option",
											"maxDate", maxDate);
									$("#endde").datepicker("setDate",
											maxDate);
								}
							}
						});

				$("#endde").datepicker();
			});
		});