$("#register").submit(function(event) {
    event.preventDefault();

    let form = $(this);
    let actionUrl = form.attr('action');
    
    $.ajax({
        type: "POST",
        url: actionUrl,
        data: form.serialize(), 
        success: function(data) {   
            
            $('#error-modal').modal('show');
            $('#modal-title').text('Sucesso!');      
            
            if (data.error == true) {
                $('#modal-title').text('Erro!'); 
            }            
            $('#modal-text').text(data.text);
            
            if (data.error == false) {
                $("#modal-close").click(function(){
                    window.location.assign("login.jsp"); 
                });
            }
        }
    });
}); 

$("#login").submit(function(event) {
    event.preventDefault();

    let form = $(this);
    let actionUrl = form.attr('action');
    
    $.ajax({
        type: "POST",
        url: actionUrl,
        data: form.serialize(), 
        success: function(data) {   
            
            if (data.error == false) {
                window.location.assign("index.jsp"); 
            } else {
                $('#error-modal').modal('show');    
                $('#modal-title').text('Erro!'); 
                $('#modal-text').text(data.text);        
            }
        }
    });
}); 
