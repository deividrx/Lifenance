function edit() {
    let contaId = $("#conta-id").val();
    console.log(contaId);
    $('#form-modal').modal('show')
    $("#modal-close").click(function(){ 
        $('#form-modal').modal('show');
    });
}

function populateTable() {
    $.ajax({
        url : 'controller/bank-account',
        type : 'GET',
        dataType : 'json',
        contentType: "application/json; charset=utf-8",
        success : function(data) {
            $("#tbody").empty();
            $(data).each(
                    function(i) {
                        $('#tbody').append(
                                '<tr><td>'
                                        +'<div class="row">'
                                        + '<div class="col-sm-3">'
                                        + '<form class="delete-conta" method="post" action="controller/bank-account/delete">' 
                                            + '<button class="btn btn-primary"><i class="fas fa-trash"></i></button>'    
                                            + '<input id="conta-id" type="hidden" name="id" value="' + data[i].id + '">'
                                        + '</form>'
                                        + '</div>'
                                        + '<div class="col-sm-3">'
                                            + '<button class="btn btn-primary" onclick="edit()"><i class="fas fa-pen"></i></button>'
                                        + '</div>'
                                        + '</div>'
                                        + '</td><td>'
                                        + data[i].banco + '</td><td>'
                                        + data[i].agencia + '</td><td>'
                                        + data[i].numero + '</td><td>'
                                        + data[i].tipo.toLowerCase() + '</td><td>'
                                        + data[i].limite +
                                '</td></tr>')
            });
        },
        error : function(data) {
            alert("Algo deu Errado!");
        }
    });
}

$(document).ready(populateTable());

$(document).on('submit', '.delete-conta', function(event) {
    event.preventDefault();

    let form = $(this);
    
    $.ajax({
        type: "POST",
        url: 'controller/bank-account/delete',
        data: form.serialize(), 
        success: function(data) {   
            
            $('#error-modal').modal('show');    
            
            if (data.error == true) {
                $('#modal-title').text('Erro!');
                $('#modal-text').text(data.text); 
            } else {
                $('#modal-title').text('Sucesso!');
                $('#modal-text').text(data.text);
                $("#modal-close").click(function(){ 
                    populateTable(); 
                });
                
            }          
            
        },
        error : function(data) {
            alert("Algo deu Errado!");
        }
    });
}); 