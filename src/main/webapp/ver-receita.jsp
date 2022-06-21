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
                            <h6 class="m-0 font-weight-bold text-primary">Suas Receitas</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="tableReceita" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>Nome da receita</th>
                                        <th>Conta</th>
                                        <th>Tipo</th>
                                        <th>Data</th>
                                        <th>Valor</th>
                                    </tr>
                                    </thead>
                                    <tfoot>
                                    <tr>
                                        <th>Nome da receita</th>
                                        <th>Conta</th>
                                        <th>Tipo</th>
                                        <th>Data</th>
                                        <th>Valor</th>
                                    </tr>
                                    </tfoot>
                                    <tbody>


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
                        <form id="receita-register">
                            <input id="conta-id" type="hidden" name="id" value="">
                            <div class="form-group">
                                <label for="inputEmail4" class="form-label">Nome da receita</label>
                                <input type="name" name="nomeReceita" class="form-control" id="nomeReceita" required>
                            </div>
                            <div class="form-group">
                                <label for="" class="form-label">Valor</label>
                                <input type="money" name="valorReceita" class="form-control" id="valorReceita" placeholder="R$" required>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail4" class="form-label">Data inicial</label>
                                <input type="date" name="dataInicio" class="form-control" id="dataInicio" required>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail4" class="form-label">Data final</label>
                                <input type="date" name="dataFim" class="form-control" id="dataFim">
                            </div>

                            <div class="form-group">
                                <div class="form-check">
                                    <label for="selectbody" class="form-label">Conta</label>
                                    <select name="conta" name="conta" id="selectbody" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                    </select>
                                </div>
                                <div class="form-check">
                                    <label for="receita-des" class="form-label">Conta</label>
                                    	<textarea id="description" name="description" class="form-control"
                                    	placeholder="Descrição da receita" id="receita-des" style="height: 100px" required></textarea>
                                </div>
                            </div>
                      </form>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                      <button type="submit" class="btn btn-primary" form="receita-register" >Salvar</button>
                    </div>
                  </div>
                </div>
              </div>


    <!-- Logout Modal-->
    <jsp:include page="elements/logout-modal.html" />

    <!-- JavaScript for all pages -->
    <jsp:include page="elements/js.html" />
    <script src="webjars/moment/2.29.3/min/moment.min.js"></script>
        <script src="js/receita.js"></script>


</body>

</html>