var idFestivo;
		function configurarBorrado(id){
			idFestivo=id;
		}
		function borrar(){
			window.location.href = "borrarFestivo?id=" + idFestivo;
		}