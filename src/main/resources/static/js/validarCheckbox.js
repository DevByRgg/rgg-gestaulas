function validar() {
	validarDias();
	validarHoras();
}

function validarDias() {
	const lunes = document.getElementById('lunes');
	const martes = document.getElementById('martes');
	const miercoles = document.getElementById('miercoles');
	const jueves = document.getElementById('jueves');
	const viernes = document.getElementById('viernes');
	const sabado = document.getElementById('sabado');
	let diaIsChecked = false;

	if (lunes.checked == true || martes.checked == true || miercoles.checked == true ||
		jueves.checked == true || viernes.checked == true || sabado.checked == true) {
		diaIsChecked = true;
	}

	if (diaIsChecked) {
		lunes.removeAttribute('required');
	} else {

		alert('Selecciona al menos un dia');

		lunes.setAttribute('required');
	}
}

function validarHoras() {
	const man09 = document.getElementById('man09');
	const man10 = document.getElementById('man10');
	const man11 = document.getElementById('man11');
	const man12 = document.getElementById('man12');
	const man13 = document.getElementById('man13');
	const man14 = document.getElementById('man14');
	const tar17 = document.getElementById('tar17');
	const tar18 = document.getElementById('tar18');
	const tar19 = document.getElementById('tar19');
	const tar20 = document.getElementById('tar20');
	const tar21 = document.getElementById('tar21');
	const tar22 = document.getElementById('tar22');
	let horaIsChecked = false;

	if (man09.checked == true || man10.checked == true || man11.checked == true ||
		man12.checked == true || man13.checked == true || man14.checked == true ||
		tar17.checked == true || tar18.checked == true || tar19.checked == true ||
		tar20.checked == true || tar21.checked == true || tar22.checked == true) {
		horaIsChecked = true;
	}

	if (horaIsChecked) {
		man09.removeAttribute('required');
	} else {
		alert('Selecciona al menos una hora')

		man09.setAttribute('required');
	}
}