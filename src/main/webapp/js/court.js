function initCalendar(calendarNo) {
   $('#calendar-'+calendarNo).fullCalendar({
    	editable: true,
    	disableDragging: true,
    	disableResizing: true,
    	firstDay: 1,
    	defaultView: 'agendaWeek',
    	buttonIcons: false,
    	allDayDefault: false,
    	allDaySlot: false,
    	axisFormat: 'HH:mm',
    	slotMinutes: 60,
    	defaultEventMinutes: 60,
    	minTime: 17,
    	maxTime: 23,
    	timeFormat: 'HH:mm',
    	columnFormat: 'dd-MM',
    	buttonText: {
    		today: 'Dana&#x0161;nji dan'
    	},
    	monthNames: [
    	    'Januar', 'Februar', 'Mart', 'April', 'Maj', 'Jun', 'Jul',
    	    'Avgust', 'Septembar', 'Oktobar', 'Novembar', 'Decembar'
    	],
    	monthNamesShort: [
    	    'Jan', 'Feb', 'Mar', 'Apr', 'Maj', 'Jun',
    	    'Jul', 'Avg', 'Sep', 'Okt', 'Nov', 'Dec'
    	],
    	dayNames: [
    	    'Nedelja', 'Ponedeljak', 'Utorak', 'Sreda',
    	    '&#x010C;etvrtak', 'Petak', 'Subota'
    	],
    	dayNamesShort: [
    	    'Ned', 'Pon', 'Ut', 'Sre', '&#x010C;et', 'Pet', 'Sub'
    	],
    	eventSources: [
    	    {
    	 		url: 'courts/'+calendarNo+'/slots',
    	 		type: 'GET',
    	 		error: function() {
    	 			alert('Error fetching slots');
    	 		}
    	 	}
    	],
    	dayClick: function(date, allDay, jsEvent, view) {
    		var events = $('#calendar-'+calendarNo).fullCalendar('clientEvents');
    		for (var i = 0; i < events.length; i++) {
    			if (events[i].start.getDate() === date.getDate()
    					&& events[i].start.getMonth() === date.getMonth()
    					&& events[i].start.getFullYear() === date.getFullYear()
    					&& events[i].start.getHours() === date.getHours()) {
    				return;
    			}
    		}
    		var $dialog = $('<div></div>')
    			.html('Da li zelite da rezervisete termin ' + $.fullCalendar.formatDate(date, 'dd-MM-yyyy HH:mm') + '?')
    			.dialog({
    				autoOpen: false,
    				title: 'Rezervacija termina',
    				modal: true,
    				resizable: false,
    				buttons: {
			        	  Da: function() {
			        		  	$.ajax({
			        		  		type: 'POST',
			        		  		url: 'courts/'+calendarNo+'/slots',
			        		  		data: {
			        		  			start: date.getTime() / 1000
			        		  		},
			        		  		success: function(data) {
			        		  			if (!(data === 'Success')) {
			        		  				alert(data);
			        		  			}
			        		  			$('#calendar-'+calendarNo).fullCalendar('refetchEvents');
			        		  		}
			        		  	});
								$(this).dialog("close");
			        	  },
			        	  Ne: function() {
								$(this).dialog("close");
			        	  }
    				}
    			});
    		$dialog.dialog('open');
    	},
    	eventClick: function(calEvent, jsEvent, view) {
    		if (!calEvent.editable) return;

    		var $dialog = $('<div></div>')
				.html('Da li zelite da otkazete rezervaciju termina ' + $.fullCalendar.formatDate(calEvent.start, 'dd-MM-yyyy HH:mm') + '?')
				.dialog({
					autoOpen: false,
					title: 'Otkazivanje rezervacije termina',
					modal: true,
					resizable: false,
					buttons: {
			        	  Da: function() {
			        		  	$.ajax({
			        		  		type: 'POST',
			        		  		url: 'courts/'+calendarNo+'/slots/' + calEvent.id + '?cancel',
			        		  		success: function(data) {
			        		  			if (!(data === 'Success')) {
			        		  				alert(data);
			        		  			}
			        		  			$('#calendar-'+calendarNo).fullCalendar('refetchEvents');
			        		  		}
			        		  	});
								$(this).dialog("close");
			        	  },
			        	  Ne: function() {
								$(this).dialog("close");
			        	  }
					}
				});
    		$dialog.dialog('open');
    	}
   });
}

