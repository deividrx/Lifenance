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
                            <h6 class="m-0 font-weight-bold text-primary">Ver contas</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="tableConta" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>Opções</th>
                                        <th>Nome do Banco</th>
                                        <th>Agência</th>
                                        <th>Número</th>
                                        <th>Tipo</th>
                                        <th>Limite</th>
                                    </tr>
                                    </thead>
                                    <tfoot>
                                    <tr>
                                        <th>Opções</th>
                                        <th>Nome do Banco</th>
                                        <th>Agência</th>
                                        <th>Número</th>
                                        <th>Tipo</th>
                                        <th>Limite</th>
                                    </tr>
                                    </tfoot>
                                    <tbody id="tbody"> 
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


    <div class="modal fade" id="form-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">New message</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
                <form id="account-register">
                    <input id="conta-id" type="hidden" name="id" value="">
                    <div class="form-group">
                        <label for="input" class="form-label">Nome do banco</label>
                        <input type="name" class="form-control" id="nomeBanco" name="nomeBanco" required>
                    </div>
                    <div class="form-group">
                        <label for="" class="form-label">Agência</label>
                        <input type="money" class="form-control" id="numAgencia" name="numAgencia" placeholder="1234-5" required>
                    </div>
                    <div class="form-group">
                        <label for="input" class="form-label">Número</label>
                        <input type="number" class="form-control" id="numAccount" name="numAccount"  required>
                    </div>
                    <div class="form-group">
                        <label for="" class="form-label">Limite</label>
                        <input type="money" class="form-control" id="limiteConta" name="limiteConta" placeholder="R$" required>
                    </div>

                    <div class="form-group">
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
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              <button type="submit" class="btn btn-primary" form="account-register" >Salvar</button>
            </div>
          </div>
        </div>
      </div>


    <!-- Logout Modal-->
    <jsp:include page="elements/logout-modal.html" />
    <!-- Error Modal-->
    <jsp:include page="elements/error-modal.html" />

    <!-- JavaScript for all pages -->
    <jsp:include page="elements/js.html" />

    <script src="js/bank-account.js"></script>

</body>

</html>