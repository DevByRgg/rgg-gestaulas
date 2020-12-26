$(document).ready(function() {

//Puesto en Castellano

	$('#calendar').fullCalendar({
		defaultView: 'agendaDay',
		lang: 'es',
		columnFormat: 'ddd',
		monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
		monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
		dayNames: ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'],
		dayNamesShort: ['Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb', 'Dom'],
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		allDaySlot: false,
		weekend: true,
		minTime: '08:00:00',
		maxTime: '15:00:00',
		slotDuration: '01:00:00'
	});



});