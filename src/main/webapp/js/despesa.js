var arrayData;

function populateTable() {
    $.ajax({
        url : 'controller/transaction/despesa',
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

                            + '<div class="col-">'
                            + '<form class="delete-transaction" method="post" action="controller/bacate/delete">'
                                + '<button class="btn btn-primary"><i class="fas fa-trash"></i></button>'
                                + '<input type="hidden" name="id" value="' + data[i].idTransaction + '">'
                            + '</form>'

                            + '</div>'
                            + '<div class="mx-auto">'
                                + '<button class="btn btn-primary" onclick="edit(' + i + ')"><i class="fas fa-pen"></i></button>'
                            + '</div>'
                            + '</div>'
                            + '</td><td>'
                            + data[i].name + '</td><td>'
                            + data[i].value + '</td><td>'
                            + data[i].dataInicial + '</td><td>'
                            + data[i].dataFinal + '</td><td>'
                            + data[i].valorReceita +
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

$(document).on('submit', '.delete-transaction', function(event) {
    event.preventDefault();

    let form = $(this);

    $.ajax({
        type: "POST",
        url: 'controller/transaction/delete',
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