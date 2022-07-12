(function(){
        const url = '/turno';
        const settings = {
          method: 'GET'
      }
      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
           for(turno of data){
            let table = document.getElementById("turnoTable");
            let turnoTh = table.insertRow();
            let tr_id = 'tr_' + turno.id;
            turnoTh.id = tr_id;

             let deleteButton = '<button' +
                                        ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                                        ' type="button" onclick="deleteBy('+turno.id+')" class="btn btn-danger btn_delete">' +
                                        'Eliminar' +
                                        '</button>';

            let updateButton = '<button' +
                                        ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                        ' type="button" onclick="findBy('+turno.id+')" class="btn btn-info btn_id m-3">' +
                                        "Editar" +
                                        '</button>';

           turnoTh.innerHTML = '<td class=\"td_id\">' + turno.id + '</td>' +
                                '<td class=\"td_fecha\">' + turno.date + '</td>' +
                                '<td class=\"td_hora\">' + turno.time + '</td>' +
                                '<td class=\"td_odontologoId\">' + turno.odontologo.id + '</td>' +
                                '<td class=\"td_pacienteId\">' + turno.paciente.id + '</td>' +
                                '<td class=\"td_accion\">' + updateButton + deleteButton + '</td>';
          };
  })
})

(function(){
    let pathname = window.location.pathname;
    if (pathname == "/listaTurno.html") {
        document.querySelector(".nav .nav-item a:last").addClass("active");
    }
})