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
const checkBoxes = document.getElementById('divHoras').children;

for (var i = 0; i < checkBoxes.length; i++) {
    checkBoxes[i].addEventListener('click', numeroHoras);
}

let numeroHoras = function numeroHoras() {
	const btnActualiza = document.getElementById('btnActualiza');
	let numeroHoras = 0;
    
    if (man09.checked == true) {numeroHoras++} 
	if (man10.checked == true) {numeroHoras++}
	if (man11.checked == true) {numeroHoras++}
	if (man12.checked == true) {numeroHoras++}
	if (man13.checked == true) {numeroHoras++}
	if (man14.checked == true) {numeroHoras++}
	if (tar17.checked == true) {numeroHoras++}
	if (tar18.checked == true) {numeroHoras++}
	if (tar19.checked == true) {numeroHoras++}
	if (tar20.checked == true) {numeroHoras++}
	if (tar21.checked == true) {numeroHoras++}
	if (tar22.checked == true) {numeroHoras++}
	
	
	if (numeroHoras != 1) {
		btnActualiza.setAttribute('disabled');
		alert('Selecciona una hora !SOLO¡ una hora')
	} else {
		btnActualiza.remaveAttribute('disabled');
	}
}
