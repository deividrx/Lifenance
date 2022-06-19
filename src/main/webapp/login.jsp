<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="pt_BR">

<head>

    <jsp:include page="elements/head.html" />
    <title>Lifenance 2 - Login</title>

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Bem vindo!</h1>
                                    </div>
                                    <form id="login" class="user" method="post" ACTION="authorization/login">
                                        <div class="form-group">
                                            <input type="number" class="form-control form-control-user"
                                                id="exampleInputEmail" name="cpf" aria-describedby="cpfHelp"
                                                placeholder="Insira seu CPF..." required>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" class="form-control form-control-user"
                                                id="exampleInputPassword" placeholder="Senha" required>
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck" name="remember" value="true">
                                                <label class="custom-control-label" for="customCheck">Lembrar
                                                    </label>
                                            </div>
                                        </div>
                                        <button class="btn btn-primary btn-user btn-block">
                                            Login
                                        </button>
                                        <hr>
                                        
                                    </form>
                                    <hr>
                                   
                                    <div class="text-center">
                                        <a class="small" href="register.html">Crie uma conta!</a>
                                    </div>
                                </div>
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