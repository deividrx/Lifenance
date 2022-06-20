<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="pt_BR">

<head>

    <jsp:include page="elements/head.html" />
    <title>Registrar Cartao</title>

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
                    <h1 class="h3 mb-4 text-gray-800">Registrar Cartão</h1>

                    <div class="container py-5">
                              
                        <div class="row">
                          <div class="col-lg-7 mx-auto">
                            <div class="bg-white rounded-lg shadow-sm p-5">
                              <!-- Credit card form tabs -->
                              <ul role="tablist" class="nav bg-light nav-pills rounded-pill nav-fill mb-3">
                                <li class="nav-item">
                                  <a data-toggle="pill" href="#nav-tab-card" class="nav-link active rounded-pill">
                                                      <i class="fa fa-credit-card"></i>
                                                      Cartão de Crédito
                                                  </a>
                                </li>
                               
                                
                              </ul>
                              <!-- End -->
                      
                      
                              <!-- Credit card form content -->
                              <div class="tab-content">
                      
                                <!-- credit card info-->
                                <div id="nav-tab-card" class="tab-pane fade show active">
                               <!--  <p class="alert alert-success"></p> --> 
                                  <form id="register-card" role="form">
                                    <div class="form-group">
                                      <label for="username">Nome Completo (no cartão)</label>
                                      <input type="text" name="username" placeholder="" required class="form-control">
                                    </div>


                                    <div class="form-group">
                                      <label for="cardNumber">Número</label>
                                      <div class="input-group">
                                        <input type="text" name="cardNumber" placeholder="Número do cartão" class="form-control" required>
                                        <div class="input-group-append">

                                        </div>
                                      </div>
                                    </div>
                                    <div class="row">
                                      <div class="col-sm-8">
                                        <div class="form-group">
                                          <label><span class="hidden-xs">Validade</span></label>
                                          <div class="input-group">
                                            <input type="number" placeholder="Mês" name="validadeMes" class="form-control" required>
                                            <input type="number" placeholder="Ano" name="validadeAno" class="form-control" required>
                                          </div>
                                        </div>
                                      </div>

                                    </div>
                                        <div class="form-group">
                                          <label for="limite">Limite do cartão</label>
                                          <input id="limiteCartao" type="text" name="limiteCard" placeholder="R$" required class="form-control">
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-8">
                                            <div class="form-group">
                                              <label><span class="hidden-xs">Vencimento da fatura</span></label>
                                              <div class="input-group">
                                                <input type="number" placeholder="Dia" name="fatura-dia" class="form-control" required>
                                              <input type="number" placeholder="Mês" name="fatura-mes" class="form-control" required>
                                              </div>
                                            </div>
                                        </div>
                                    <div class="col-sm-4">

                                      <div class="form-group mb-4">
                                          <label data-toggle="tooltip" title="Tres digitos na parte de trás do cartão">Bandeira </label>
                                          <select id="selectbody" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                            <option value="1">Mastercard</option>
                                            <option value="2">Visa</option>
                                            <option value="3">American Express</option>
                                            <option value="4">Hipercard</option>
                                            <option value="5">Elo</option>
                                          </select>
                                    </div>
                                  </form>
                                </div>
                                <!-- End -->
            
                                    <button form="register-card" type="submit" class="subscribe btn btn-primary btn-block rounded-pill shadow-sm"> Confirmar  </button>
                                <!-- End -->
                              </div>
                              <!-- End -->
                      
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

    <!-- JavaScript for all pages -->
    <jsp:include page="elements/js.html" />

    <script src="js/card-flag.js"></script>
    <script src="js/form.js"></script>

</body>

</html>