<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 1/7/2022
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<section class="vh-100" style="background-color: #9A616D;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                            <img
                                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
                                    alt="login form"
                                    class="img-fluid" style="border-radius: 1rem 0 0 1rem;"
                            />
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">
                                <form action="/user?action=singup" method="post">
                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                        <span class="h1 fw-bold mb-0">Logo</span>
                                    </div>

                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign Up Account</h5>

                                    <div class="form-outline mb-4">
                                        <input name="username" type="text" id="form2Example17" class="form-control form-control-lg" />
                                        <label  class="form-label" for="form2Example17">User</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input name="pass" type="password" id="form2Example27" class="form-control form-control-lg" />
                                        <label class="form-label" for="form2Example27">Password</label>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <input name="phone" type="number" id="form2Example37" class="form-control form-control-lg" />
                                        <label  class="form-label" for="form2Example17">Phone Number</label>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <input name="email" type="email" id="form2Example47" class="form-control form-control-lg" />
                                        <label  class="form-label" for="form2Example17">Email</label>
                                    </div><div class="form-outline mb-4">
                                    <input name="address" type="text" id="form2Example57" class="form-control form-control-lg" />
                                    <label  class="form-label" for="form2Example17">Address</label>
                                </div>

                                    <div class="pt-1 mb-4">
                                        <button  class="btn btn-dark btn-lg btn-block" type="submit">Sing Up</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>