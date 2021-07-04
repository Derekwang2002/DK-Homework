<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>Admin Dashboard</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="icon" href="assets/image/logo.png" type="image/png">
    <style>
        .container {
            max-width: 960px;
        }
    </style>
    <!-- Custom styles for this template -->
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      main > .container {
        padding: 60px 15px 0;
      }
      .quote {
        margin: 0;
        background: #eee;
        padding: 1em;
        border-radius: 1em;
      }
      .quote figcaption,
      .quote blockquote {
        margin: 1em;
      }
    </style>
</head>
<body>
<div class="container">
    <header class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
        <a href="#" class="d-flex align-items-center text-dark text-decoration-none">
            <span class="fs-4">Admin Dashboard</span>
        </a>

        <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
            <a class="btn btn-outline-success my-2 my-sm-0" href="add-book">Add New Book</a>
        </nav>
    </header>
<!--
forEach books in the <table></table>. Each book is also inside a <form></form>, whose request is to delete it.
-->
</div>
<!-- Begin page content -->
<main class="flex-shrink-0">
    <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <c:forEach var="book" items="${books}">
                <div class="col">
                    <a href="book?id=${book.id}">
                        <div class="card shadow-sm" style="width: 18rem;">
                            <img src="${book.imageURL}" class="card-img-top bd-placeholder-img" height="225" width="100%">
                            <div class="card-body">
                                <p class="card-text">${book.title} <br><span class="badge bg-success">by</span> ${book.author}
                                    <br/>
                                    <a class="btn btn-outline-success my-2 my-sm-0" href="del-book?id=${book.id}">Delete</a></p>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

</body>
</html>
