<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="pt_BR">

<head>

    <jsp:include page="elements/head.html" />
    <title>Lifenance 2 - Registro</title>

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Crie uma Conta!</h1>
                            </div>
                            <form class="user" method="post" action="authorization/register" id="register">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" name="first_name" class="form-control form-control-user" id="exampleFirstName"
                                            placeholder="Primeiro Nome" required>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name="last_name" class="form-control form-control-user" id="exampleLastName"
                                            placeholder="Sobrenome" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="number" name="cpf" class="form-control form-control-user" id="cpf"
                                        placeholder="CPF " required>
                                </div>
                                <div class="form-group">
                                    <input type="email" name="email" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="Email " required>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" name="password" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="Senha" required>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" name="repeatPassword" class="form-control form-control-user"
                                            id="exampleRepeatPassword" placeholder="Repetir a senha" required>
                                    </div>
                                </div>
                                <button class="btn btn-primary btn-user btn-block">
                                    Registrar Conta
                                </button>
                                <hr>
                            </form>
                            <hr>
                            
                            <div class="text-center">
                                <a class="small" href="login.jsp">Já tem uma Conta? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Error Modal -->
    <jsp:include page="elements/error-modal.html" />

    <!-- JavaScript for all pages -->
    <jsp:include page="elements/js.html" />

    <!-- Custom script for form send -->
    <script src="js/form.js"></script>

</body>
</html>