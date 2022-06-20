var arrayData;

function populateTable() {
    $.ajax({
        url : 'controller/bacate',
        type : 'GET',
        dataType : 'json',
        contentType: "application/json; charset=utf-8",
        success : function(data) {
            $("#tbody").empty();
            arrayData = data;
            $(data).each(
                    function(i) {
                        $('#tbody').append(
                                '<tr><td>'
                                        +'<div class="row">'
                                        + '<div class="col-sm-3">'
                                        + '<form class="delete-conta" method="post" action="controller/bacate/delete">'
                                            + '<button class="btn btn-primary"><i class="fas fa-trash"></i></button>'
                                            + '<input type="hidden" name="id" value="' + data[i].id + '">'
                                        + '</form>'
                                        + '</div>'
                                        + '<div class="col-sm-3">'
                                            + '<button class="btn btn-primary" onclick="edit(' + i + ')"><i class="fas fa-pen"></i></button>'
                                        + '</div>'
                                        + '</div>'
                                        + '</td><td>'
                                        + data[i].nomeDespesa + '</td><td>'
                                        + data[i].contaDespesa + '</td><td>'
                                        + data[i].tipo.toLowerCase() + '</td><td>'
                                        + data[i].dataDespesa + '</td><td>'
                                        + data[i].valorDespesa +
                                '</td></tr>')
            });
        },
        error : function(data) {
            alert("Algo deu Errado!");
        }
    });
}

function edit(index) {
    let data = arrayData[index];

    $('#despesa-id').val(data.id);
    $('#nomeDespesa').val(data.nomeDespesa);
    $('#nomeConta').val(data.contaDespesa);
    $('#data').val(data.dataDespesa);
    $('#valor').val(data.valorDespesa);
    $('#form-modal').modal('show');

    switch (data.tipo) {
        case 'checking':
            $('#corrente').attr('checked','checked');
            break;
        case 'saving':
            $('#poupanca').attr('checked','checked');
            break;
    }

    $("#account-register").submit(function(event) {
        event.preventDefault();

        let form = $(this);
        let actionUrl = 'controller/bank-account/edit';

        $.ajax({
            type: "POST",
            url: actionUrl,
            data: form.serialize(),
            success: function(data) {

                if (data.error == true) {
                    $('#modal-title').text('Erro!');
                } else {
                    $('#form-modal').modal('hide');
                    $('#error-modal').modal('show');
                    $('#modal-title').text('Sucesso!');
                    $('#modal-text').text(data.text);
                    $("#modal-close").click(function(){
                        populateTable();
                    });
                }
            }
        });
    });
}

$(document).ready(populateTable());

$(document).on('submit', '.delete-despesa', function(event) {
    event.preventDefault();

    let form = $(this);

    $.ajax({
        type: "POST",
        url: 'controller/bacate/delete',
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