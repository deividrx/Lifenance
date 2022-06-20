$(document).ready(
    function() {
        $.ajax({
            url : 'controller/bank-account',
            type : 'GET',
            dataType : 'json',
            contentType: "application/json; charset=utf-8",
            success : function(data) {
                $(data).each(
                        function(i) {
                            console.log("Itaú");
                            $('#tbody').append(
                                    '<tr><td>' 
                                            + '<form class="delete-conta" method="post" action="controller/bank-account/delete">' 
                                                + '<button class="btn btn-primary">Deletar</button>'    
                                                + '<input type="hidden" name="id" value="' + data[i].id + '">'
                                            + '</form></td><td>'
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
});