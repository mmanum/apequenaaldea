function index_load() {
    $("table.clasico tbody tr:odd").addClass("_imp");
    $("table.clasico tbody tr:even").addClass("_par");

    $("table.clasico tbody tr").mouseover(function() {
        $(this).addClass("_ilumina");
    });
    $("table.clasico tbody tr").mouseout(function() {
        $(this).removeClass("_ilumina");
    });
}

function fraseIns() {
    if(confirm("¿Nuevo Frase?")) {
        window.location = "frases.htm?accion=INS1";
    }
}

function fraseDel() {
    var ids = [];

    $("input[name='del']:checked").each(function() {
        ids.push($(this).val());
    });

    if(ids.length == 0) {
        alert("¡Debe seleccionar Frase(s) a Retirar!");
    } else {
        if(confirm("¿Retirar Frase(s)?")) {
            window.location = "frases.htm?accion=DEL&ids="+ids.toString();
        }
    }
}

function fraseUpd() {
    var id = $("input[name='upd']:checked").val();

    if(isNaN(id)) {
        alert("¡Debe seleccionar Frase para Actualizar sus Datos!");
    } else {
        if(confirm("¿Actualizar Registro?")) {
            window.location = "frases.htm?accion=GET&id="+id;
        }
    }
}

function autoresQry() {
    window.location = "autores.htm?accion=QRY";
}

function valida() {
    if($.trim($("#frase").val()).length == 0) {
        alert("Debe Ingresar Frase");
        return false;
    }
    
    return true;
}
