$(document).ready(function() {

	$('#calendarMorning').fullCalendar({
		height: 'auto',
		contentHeight: 300, //altura de cada cuadrado en mes
		defaultView: 'agendaWeek',
		monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
		monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
		dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
		dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'],
		header: {
			left: 'prev,next today', 
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		allDaySlot: false, //mostrar un campo en la tabla de todo el día
		weekend: true, //incluir fines de semana
		minTime: '08:00', //hora de inicio
		maxTime: '15:00', //hora de fin
		slotDuration: '01:00' //duracion de cada cuadrado
		
	});
	
	$('#calendarAfternoon').fullCalendar({
		height: 'auto',
		contentHeight: 300,
		defaultView: 'agendaWeek',
		monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
		monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
		dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
		dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'],
		header: {
			left: 'prev,next today', 
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		allDaySlot: false, //mostrar un campo en la tabla de todo el día
		weekend: true, //incluir fines de semana
		minTime: '15:00', //hora de inicio
		maxTime: '22:00', //hora de fin
		slotDuration: '01:00' //duracion de cada cuadrado
		
	});
});