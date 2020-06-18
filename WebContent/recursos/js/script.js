$(document).ready(function(){
listarCat(0);
listarProd();
});

$("#boton").click(function(){
	var ep= $("#ep").val();	
	var name= $("#name").val();
	var email= $("#email").val();
	var fono = $("#fono").val();
	var id = $("#id").val();
	if(id==0){
		$.post( "hc", {ep:ep,name:name,email:email,fono:fono, opc:3}).done(function(data){
					bootbox.alert(data);
					limpiar();
					listarCat(0);
					listarProd();} );
	}else{
		alert("Esto se edita");
		$.post( "hc", {idescuela:ep, nombre:name, correo:email, telefono:fono, ida:id, opc:6}).done(function(data){
			
			$("#id").val(0);
			limpiar();
			listarCat(0);
			listarProd();		
		});
	}
});
function listarCat(x){
	var i, c =1;
	if(x==0){
		$.get("hc",{opc:"1"},function(data){
			var d = JSON.parse(data);
			for(i=0;i<d.length;i++){
				$("#ep").append("<option value='"+d[i].idescuela+"'>"+d[i].nombrecat+"</option>");
			}
		});
	}else{
		$.get("hc",{opc:"1"},function(data){
			var d = JSON.parse(data);
			for(i=0;i<d.length;i++){
				if(x==d[i].idescuela){
					
					$("#ep").append("<option value='"+d[i].idescuela+"' selected>"+d[i].nombrecat+"</option>");
				}else{
					$("ep").append("<option value='"+d[i].idescuela+"'>"+d[i].nombrecat+"</option>");
				}
			}
		});
	}
}
function listarProd(){
	var i, c =1;
	$.get("hc",{opc:"2"},function(data){	
		var d = JSON.parse(data);
		$('#tablita tbody').empty();
		for(i=0;i<d.length;i++){
			$("#tablita tbody").append("<tr><td style='color:blue'>"+c+"</td><td>"+d[i].nombrecat+"</td><td>"+d[i].apellnombres+"</td><td>"+d[i].correo+"</td><td>"+d[i].telefono+
			"</td><td><a href='#' style='color:green' onclick='modificar("+d[i].idalumno+")'><i class='far fa-edit'></i></a></td><td><a href='#' style='color:red' onclick='eliminar("+d[i].idalumno+")'><i class='far fa-trash-alt'></i></a></td></tr>")
			c++;
		}
	});
}
function eliminar(id){	

	bootbox.confirm("Desea Eliminar?", function(result) {
    if(result){
    	bootbox.alert("Registro Eliminado Correctamente...!", function() {
    		$.get("hc",{id:id,opc:5},function(data){
    			listarCat(0);
    			listarProd();
		});
    	});
		 
    }else{
    	bootbox.alert("El registro no se Elimino...!")
    }}); 
}
function modificar(id){
	$.post("hc",{id:id,opc:4},function(data){
	
		var x = JSON.parse(data);
		$("#name").val(x[0].apellnombres);
		$("#email").val(x[0].correo);
		$("#fono").val(x[0].telefono);
		$("#id").val(x[0].idalumno);	
		listarCat(x[0].idescuela);
		
	});
}
function limpiar(){
	$("#name").val("");
	$("#email").val("");
	$("#fono").val("");
	$("#name").focus();
}