function populateSelect() {
    $.ajax({
        url : 'controller/card-flag',
        type : 'GET',
        dataType : 'json',
        contentType: "application/json; charset=utf-8",
        success : function(data) {
            $("#selectbody").empty();
            $(data).each(
                    function(i) {
                        $('#selectbody').append(
                            '<option value="' + data[i].id + '">' + data[i].name + '</option>'
                        )
            });
        },
        error : function(data) {
            alert("Algo deu Errado!");
        }
    });
}

$(document).ready(populateSelect());