function invoicesQry_load() {
    $("table.clasico tbody tr:odd").addClass("_imp");
    $("table.clasico tbody tr:even").addClass("_par");

    $("table.clasico tbody tr").mouseover(function() {
        $(this).addClass("_ilumina");
    });
    $("table.clasico tbody tr").mouseout(function() {
        $(this).removeClass("_ilumina");
    });
}

function invoicesUpd() {
    var id = $("input[name='upd']:checked").val();

    if(isNaN(id)) {
        alert("¡Debe seleccionar Autor!");
    } else {
        if(confirm("¿Actualizar Registro?")) {
            window.location = "autores.htm?accion=GET&id="+id;
        }
    }
}

function inovicesDel() {
    var ids = [];

    $("input[name='del']:checked").each(function() {
        ids.push($(this).val());
    });

    if(ids.length == 0) {
        alert("¡Debe seleccionar Autor(s) a Retirar!");
    } else {
        if(confirm("¿Retirar Autor(s)?")) {
            window.location = "autores.htm?accion=DEL&ids="+ids.toString();
        }
    }
}

function valida() {
    if($.trim($("#autor").val()).length == 0) {
        alert("Debe Ingresar Autor");
        return false;
    }
    
    return true;
}


function companiesChange(urlBase) {
        
    var idcompany = $( "#company" ).val(); // $( "#company option:selected" ).value();
    window.location= urlBase + '/invoicing?accion=INS&company=' + idcompany ;     
}

function doAjaxPost() {
    // get the form values
    var id = $('#name').val();
    var education = $('#education').val();

    $.ajax({
        type: "POST",
        url: contexPath + "/AddUser.htm",
        data: "company=" + id + "&education=" + education,
        success: function(response){
            // we have the response
            if(response.status == "SUCCESS"){
                userInfo = "<ol>";
                for(i =0 ; i < response.result.length ; i++){
                    userInfo += "<br><li><b>Name</b> : " + response.result[i].name +
                    ";<b> Education</b> : " + response.result[i].education;
                 }
                 userInfo += "</ol>";
                 $('#info').html("User has been added to the list successfully. " + userInfo);
                 $('#name').val('');
                 $('#education').val('');
                 $('#error').hide('slow');
                 $('#info').show('slow');
             }else{
                 errorInfo = "";
                 for(i =0 ; i < response.result.length ; i++){
                     errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
                 }
                 $('#error').html("Please correct following errors: " + errorInfo);
                 $('#info').hide('slow');
                 $('#error').show('slow');
             }
         },
         error: function(e){
             alert('Error: ' + e);
         }
    });
}
