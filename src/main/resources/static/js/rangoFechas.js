	const fechaEntrada = document.getElementById('fechaInicio')
	const fechaSalida = document.getElementById('fechaFin')
	
	var today = moment().format('YYYY-MM-DD')
	var tomorrow = moment(today).add(1, 'days').format('YYYY-MM-DD')
	
	fechaEntrada.setAttribute('value', today)
	fechaEntrada.setAttribute('min', today)
	fechaSalida.setAttribute('value', tomorrow)
     fechaSalida.setAttribute('min', tomorrow)
	
	$('#fechaEntrada').on('change', function(){
    	var date = new Date($('#fechaEntrada').val());
     	day = date.getDate();
     	month = date.getMonth() + 1;
     	year = date.getFullYear();
     	
     	var entrada = [year, month, day].join('-');
     	var limite = moment(entrada).add(1, 'days').format('YYYY-MM-DD')
     	
     	fechaSalida.setAttribute('value', limite)
     	fechaSalida.setAttribute('min', limite)
		
	});