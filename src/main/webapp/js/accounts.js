function populateSelect() {
    $.ajax({
        url : 'controller/bank-account',
        type : 'GET',
        dataType : 'json',
        contentType: "application/json; charset=utf-8",
        success : function(data) {
            $("#selectbody").empty();
            $(data).each(
                    function(i) {
                        $('#selectbody').append(
                            '<option value="' + data[i].id + '">' + data[i].banco + ' AG:' + data[i].agencia + ' NUM:' + data[i].numero + '</option>'
                        )
            });
        },
        error : function(data) {
            alert("Algo deu Errado!");
        }
    });
}

$(document).ready(populateSelect());