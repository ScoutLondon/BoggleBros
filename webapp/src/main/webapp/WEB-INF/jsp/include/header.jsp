<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Boggle Bros- Become A Rat Parent</title>
    <link rel="stylesheet" href="/pub/css/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Oswald&display=swap" rel="stylesheet">
<script src="/script/script.js" defer></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
          crossorigin="anonymous"></script>

<style>
    body{
        font-family: 'Montserrat', sans-serif;
    }
</style>
</head>
<body>
    <header>
            <img src="https://i0.wp.com/bogglebros.com/wp-content/uploads/2022/06/294849392_1126915941577557_873610920801494896_n.png?w=1343&ssl=1"
            alt="Boggle Bros Rattery NC">
        <p class="bbr-slogan">Become a rat parent.</p>
    </header>

    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/rat/available">Available Rats</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/about">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/blog">Blog</a>
                    </li>

                    <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/auth/register">Adopter Application</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/auth/login">Login</a>
                    </li>
                    </sec:authorize>

                    <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="!hasAnyAuthority('ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="/order/view">My Adoption</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/reservation/view">My Reservations</a>
                        </li>
                    </sec:authorize>
                    </sec:authorize>

                    <sec:authorize access="hasAnyAuthority('ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="/rat/create">Add Rat</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/rat/edit">Edit Ratabase</a>
                        </li>
                    </sec:authorize>

                    <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/auth/logout">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href=""><sec:authentication property="principal.username" /></a>
                    </li>
                    </sec:authorize>



                </ul>
            </div>
        </div>
    </nav>