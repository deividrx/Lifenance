<%@page
    contentType="text/html"
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="pt_BR">

<head>

    <jsp:include page="elements/head.html" />
    <title>Ver Cartões</title>

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
                    <h1 class="h3 mb-2 text-gray-800">Cartão</h1>
                    <p class="mb-4">Seus cartões cadastrados aparecerão nessa página, caso ainda nao tenha registrado <a
                                                                                href="cards.jsp">clique aqui</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Ver cartões</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>Nome Completo</th>
                                        <th>Número</th>
                                        <th>CVV</th>
                                        <th>Validade</th>
                                        
                                    </tr>
                                    </thead>
                                    <tfoot>
                                    <tr>
                                        <th>Nome da despesa</th>
                                        <th>Conta</th>
                                        <th>Tipo</th>
                                        <th>Data</th>
                                        <th>Valor</th>
                                    </tr>
                                    </tfoot>
                                    <tbody>
                                    <tr>
                                        <td>Conta de Luz</td>
                                        <td>Itaú</td>
                                        <td>Fixa</td>

                                        <td>07/06/2022</td>
                                        <td>$220</td>
                                    </tr>
                                    <tr>
                                        <td>Agiota</td>
                                        <td>Quilombo</td>
                                        <td>Fixa</td>

                                        <td>2011/07/25</td>
                                        <td>$170,750</td>
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