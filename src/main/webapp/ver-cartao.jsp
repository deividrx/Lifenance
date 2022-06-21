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
                                        <th>Opções</th>
                                        <th>Nome Completo</th>
                                        <th>Numero</th>
                                        <th>Validade</th>
                                        <th>Limite</th>
                                        <th>Multa</th>
                                        <th>Dia Vencimento Fatura</th>
                                        <th>Bandeira</th>
                                    </tr>
                                    </thead>
                                    <tfoot>
                                    <tr>
                                        <th>Opções</th>
                                        <th>Nome Completo</th>
                                        <th>Numero</th>
                                        <th>Validade</th>
                                        <th>Limite</th>
                                        <th>Multa</th>
                                        <th>Dia Vencimento Fatura</th>
                                        <th>Bandeira</th>
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
                  <h5 class="modal-title" id="exampleModalLabel">Editar</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                    <form id="card-register">
                        <input id="card-id" type="hidden" name="id" value="">
                        <div class="form-group">
                            <label for="input" class="form-label">Nome completo</label>
                            <input type="name" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="form-group">
                            <label for="" class="form-label">Número</label>
                            <input type="number" name="cardNumber" placeholder="Número do cartão" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label><span class="hidden-xs">Validade</span></label>
                               <div class="input-group">
                                   <input type="number" placeholder="Mês" name="validadeMes" class="form-control" required>
                                   <input type="number" placeholder="Ano" name="validadeAno" class="form-control" required>
                               </div>
                        </div>
                        <div class="form-group">
                            <label for="username">Multa</label>
                            <input type="text" required="required" placeholder="%" name="card-multa" pattern="[0-3]+$" required class="form-control">
                        </div>

                        <div class="form-group">
                            <div class="form-check">
                                 <label for="limite">Limite do cartão</label>
                                 <input id="limiteCartao" type="text" name="limiteCard" placeholder="R$" required class="form-control">
                            </div>
                            <div class="form-group">
                                <label><span class="hidden-xs">Vencimento da fatura</span></label>
                                           <input type="number" placeholder="Dia" name="fatura-dia" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label data-toggle="tooltip" title="Tres digitos na parte de trás do cartão">Bandeira </label>
                                    <select name="bandeira" id="selectbody" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                    </select>
                            </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                  <button type="submit" class="btn btn-primary" form="card-register" >Salvar</button>
                </div>
              </div>
            </div>
          </div>


    <!-- Logout Modal-->
    <jsp:include page="elements/logout-modal.html" />
    <jsp:include page="elements/error-modal.html" />

    <!-- JavaScript for all pages -->
    <jsp:include page="elements/js.html" />
    <script src="js/cards.js"></script>

</body>

</html>