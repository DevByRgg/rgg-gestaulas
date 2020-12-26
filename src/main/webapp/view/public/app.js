$(document).ready(function () {
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

	$('#horarios').fullCalendar({
		defaultView: 'agendaWeek',
		lang: 'es',
		weekends: false,
		columnFormat: 'dddd',

		monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
		monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
		dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
		dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'],


		//dayNames: ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'],
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		defaultDate: '2018-11-11',
		editable: true,
		eventLimit: true,
		weekend: true,
		allDaySlot: false,
		minTime: '08:00:00',
		maxTime: '15:00:00',
		slotDuration: '01:00:00',
		slotLabelInterval: '01:00:00',
		events: [
			{
				title: 'Curso Master Java 4646',
				start: '2020-12-28T09:00:55.008',
				end: '2020-12-31T09:15:55.008'
			}
		]
	});

});

