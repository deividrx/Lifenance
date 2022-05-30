$("#login_form").submit(function(event) {
    // avoid to execute the actual submit of the form.
    event.preventDefault();

    let form = $(this);
    let actionUrl = form.attr('action');
    
    $.ajax({
        type: "POST",
        url: actionUrl,
        // serializes the form's elements.
        data: form.serialize(), 
        success: function(data) {   
            
            if (data.erro == true)
                alert(data.text);
            else {
                alert(data.text);
                window.location.replace("index.jsp");
            }
          
        }
    });
});
    
   
