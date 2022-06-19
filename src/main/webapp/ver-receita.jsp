<%@page
    contentType="text/html"
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="pt_BR">

<head>

    <jsp:include page="elements/head.html" />
    <title>Ver Receitas</title>


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
                <h1 class="h3 mb-2 text-gray-800">Receitas</h1>
                <p class="mb-4">Suas receitas aparecerão nessa página, caso ainda nao tenha registrado <a target="_blank"
                                                                                                                  href="ver-receita.jsp">clique aqui</a>.</p>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Despesas</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="tableConta" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Nome do Banco</th>
                                    <th>Agência</th>
                                    <th>Número</th>
                                    <th>Tipo</th>
                                    <th>Limite</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Nome do Banco</th>
                                    <th>Agência</th>
                                    <th>Número</th>
                                    <th>Tipo</th>
                                    <th>Limite</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <tr>
                                    <td>Caixa Econômica Federal</td>
                                    <td>12345-6</td>
                                    <td>224612</td>
                                    <td>Conta Corrente</td>
                                    <td>$2.200</td>
                                </tr>
                                <tr>
                                    <td>Banco Bacate</td>
                                    <td>65432-1</td>
                                    <td>666666</td>
                                    <td>Conta Poupança</td>
                                    <td>$5.000.000</td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Lifenance²</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

</body>

</html>