
    (function(){
      const url = '/paciente';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         for(paciente of data){
          let table = document.getElementById("pacienteTable");
          let pacienteTh = table.insertRow();
          let tr_id = 'tr_' + paciente.id;
          pacienteTh.id = tr_id;

           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                      ' type="button" onclick="deleteBy('+ paciente.id +')" class="btn btn-danger btn_delete">' +
                                      'Eliminar' +
                                      '</button>';

          let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                      ' type="button" onclick="findBy('+ paciente.id +')" class="btn btn-info btn_id m-3">' +
                                      "Editar" +
                                      '</button>';

         pacienteTh.innerHTML = '<td class=\"td_id\">' + paciente.id + '</td>' +
                              '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                              '<td class=\"td_domicilio\">' + paciente.domicilio.toUpperCase() + '</td>' +
                              '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                              '<td class=\"td_fechaDeAlta\">' + paciente.fechaDeAlta.toUpperCase() + '</td>' +
                              '<td class=\"td_accion\">' + updateButton + deleteButton + '</td>';
        };
})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/listaPaciente.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})
