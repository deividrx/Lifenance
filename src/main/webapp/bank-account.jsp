<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="pt_BR">

<head>

    <jsp:include page="elements/head.html" />
    <title>Registrar Conta Bancária</title>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="elements/sidebar.html" />

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <jsp:include page="elements/topbar.html" />

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">Registrar Conta Bancária</h1>

                    <div class="row justify-content-md-center">

                        <div class="col-lg-6">

                            <!-- Circle Buttons -->


                            <!-- Brand Buttons -->
                            <div class="card shadow ">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Conta</h6>
                                </div>
                                <div class="card-body">
                                    <form id="account-register" class="row g-3" action="controller/bank-account" method="post">
                                        <div class="col-md-6">
                                            <label for="input" class="form-label">Nome do banco</label>
                                            <input type="name" class="form-control" id="nomeBanco" name="nomeBanco" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="" class="form-label">Agência</label>
                                            <input type="money" class="form-control" id="numAgencia" name="numAgencia" placeholder="1234-5" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="input" class="form-label">Número</label>
                                            <input type="number" class="form-control" id="numAccount" name="numAccount"  required>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="" class="form-label">Limite</label>
                                            <input type="money" class="form-control" id="limiteConta" name="limiteConta" placeholder="R$" required>
                                        </div>

                                        <div class="col-sm-10">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="gridRadios" id="corrente" value="checking" checked>
                                                <label class="form-check-label" for="gridRadios1" role="" required>
                                                    Conta Corrente
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="gridRadios" id="poupanca" value="saving">
                                                <label class="form-check-label" for="gridRadios2" required>
                                                    Conta Poupança
                                                </label>
                                            </div>
                                        </div>
                                    <hr>

                                        <div class="col-12">
                                            <button type="submit" class="btn btn-primary btn-lg">Registrar</button>
                                        </div>
                                    </form>

                                </div>
                            </div>

                        </div>


                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <jsp:include page="elements/footer.html" />

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <jsp:include page="elements/logout-modal.html" />

    <!-- Error Modal -->
    <jsp:include page="elements/error-modal.html" />

    <!-- JavaScript for all pages -->
    <jsp:include page="elements/js.html" />

    <!-- Custom script for form send -->
    <script src="js/form.js"></script>

</body>
</html>