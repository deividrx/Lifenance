<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="pt_BR">

<head>

    <jsp:include page="elements/head.html" />
    <title>Ver conta bancária</title>

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
                    <h1 class="h3 mb-2 text-gray-800">Conta Bancária</h1>
                    <p class="mb-4">Suas contas bancárias aparecerão nessa página, caso ainda nao tenha registrado <a target="_blank"
                                                                                                                        href="bank-account.html">clique aqui</a>.</p>

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

    <!-- JavaScript for all pages -->
    <jsp:include page="elements/js.html" />

</body>

</html>