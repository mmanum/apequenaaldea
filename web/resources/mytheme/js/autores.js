function autoresQry_load() {
    $("table.clasico tbody tr:odd").addClass("_imp");
    $("table.clasico tbody tr:even").addClass("_par");

    $("table.clasico tbody tr").mouseover(function() {
        $(this).addClass("_ilumina");
    });
    $("table.clasico tbody tr").mouseout(function() {
        $(this).removeClass("_ilumina");
    });
}

function autoresIns() {
    if(confirm("¿Nuevo Autor?")) {
        window.location = "autores.htm?accion=INS1";
    }
}

function autoresUpd() {
    var id = $("input[name='upd']:checked").val();

    if(isNaN(id)) {
        alert("¡Debe seleccionar Autor!");
    } else {
        if(confirm("¿Actualizar Registro?")) {
            window.location = "autores.htm?accion=GET&id="+id;
        }
    }
}

function autoresDel() {
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