function populateSelect() {
    $.ajax({
        url : 'controller/card',
        type : 'GET',
        dataType : 'json',
        contentType: "application/json; charset=utf-8",
        success : function(data) {
            $("#selectcard").empty();
            $('#selectcard').append('<option value="null">Sem</option>');
            $(data).each(
                    function(i) {
                        $('#selectcard').append(
                            '<option value="' + data[i].id + '">' + data[i].number + ' ' + data[i].cardFlag.name + '</option>'
                        )
            });
        },
        error : function(data) {
            alert("Algo deu Errado!");
        }
    });
}

$(document).ready(populateSelect());