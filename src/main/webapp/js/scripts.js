$("#register").submit(function(event) {
    // avoid to execute the actual submit of the form.
    event.preventDefault();

    let form = $(this);
    let actionUrl = form.attr('action');
    
    $.ajax({
        type: "POST",
        url: actionUrl,
        data: form.serialize(), 
        success: function(data) {   
            
            $('#siteModal').modal('show');
            $('#modal-title').text('Sucesso!');      
            
            if (data.error == true) {
                $('#modal-title').text('Erro!'); 
            }            
            $('#modal-text').text(data.text);
            
            if (data.error == false) {
                $("#modal-close").click(function(){
                    window.location.assign("login.html"); 
                });
            }
        }
    });
}); 
