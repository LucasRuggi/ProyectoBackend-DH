
    (function(){
      const url = '/odontologo';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         for(odontologo of data){
          let table = document.getElementById("odontologoTable");
          let odontologoTh = table.insertRow();
          let tr_id = 'tr_' + odontologo.id;
          odontologoTh.id = tr_id;

           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                      ' type="button" onclick="deleteBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                      'Eliminar' +
                                      '</button>';

          let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                      ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-info btn_id m-3">' +
                                      "Editar" +
                                      '</button>';

         odontologoTh.innerHTML = '<td class=\"td_id\">' + odontologo.id + '</td>' +
                              '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>' +
                              '<td class=\"td_matricula\">' + odontologo.matricula + '</td>' +
                              '<td class=\"td_accion\">' + updateButton + deleteButton + '</td>';
        };
})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/listaOdontologo.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})
