<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="pt_BR">

<head>

    <jsp:include page="elements/head.html" />
    <title>Registrar Receita</title>

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
                    <h1 class="h3 mb-4 text-gray-800">Registrar Receita</h1>

                    <div class="row">

                        <div class="col-lg-6">

                            <!-- Circle Buttons -->
                           

                            <!-- Brand Buttons -->
                            <div class="card shadow mb-3">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Receita</h6>
                                </div>
                                <div class="card-body">
                                    <form class="row g-3">
                                        <div class="col-md-6">
                                          <label for="inputEmail4" class="form-label">Nome da receita</label>
                                          <input type="name" class="form-control" id="nomeReceita" required>
                                        </div>
                                        <div class="col-md-6">
                                          <label for="" class="form-label">Valor</label>
                                          <input type="money" class="form-control" id="valorReceita" placeholder="R$" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="inputEmail4" class="form-label">Data inicial</label>
                                            <input type="date" class="form-control" id="dataInicio" required>
                                          </div>
                                          <div class="col-md-6">
                                             <label for="inputEmail4" class="form-label">Data final</label>
                                              <input type="date" class="form-control" id="dataFim" required>
                                          </div>
                                          <div class="col-md-6">
                                            <label for="" class="form-label">Conta</label>
                                            <select name="bandeira" id="selectbody" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                          </div>

                                          <div class="col-md-6">
                                            <label for="exampleFormControlTextarea5">Descrição da receita</label>
                                                                                        <textarea class="form-control" id="exampleFormControlTextarea5" rows="3"></textarea>
                                          </div>


                                          
                                          <div class="col-12">
                                            <button type="submit" class="btn btn-primary btn-lg">Registrar</button>
                                          </div>
                                      </form> 

                                </div>
                            </div>

                        </div>

                        <div class="col-lg-6">

                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">O que é receita?</h6>
                                </div>
                                <div class="card-body">
                                    <p>Receita é tudo que adiciona a sua fonte de renda, em geral o  <code>salário</code> 
                                        que pode ser registrado como <strong>receita fixa</strong>, já o rendimento com investimentos, ganhos como freelancer, 
                                        rendimentos com pensões e aposentadoria, ganhos com alugueis, ganhos com ações e etc, devem ser marcados como <strong>esporádico.</strong></p>
                                   

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

    <!-- JavaScript for all pages -->
    <jsp:include page="elements/js.html" />

</body>

</html>