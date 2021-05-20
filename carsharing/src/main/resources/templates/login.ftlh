<#ftl encoding="UTF-8"/>
<!DOCTYPE html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>

    <title>Login Page</title>

    <link rel="stylesheet" type="text/css" href="../css/registration_style.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">

    <meta http-equiv="Content-type" content="text/html" charset="utf-8">

</head>

<body>

<div class="wrapper">
    <div class="slider">
        <div class="outer">
            <div class="registration">
                <form class="registration__box" action="" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <a href="/base_page"><img src="../img/car.png" alt="" class="registration__img"></a>
                    <h1 class="registration__title">Enter into Account</h1>
                    <input type="email" name="email" placeholder="Email">
                    <input type="password" name="password" placeholder="Password">
                    <input type="checkbox" name="remember-me"><div class="remember-me">Remember me</div>
                    <a href="" class=""><input type="submit" value="Enter"></a>
                    <div class="sign-up"> Don't have an account? <a href="/sign_up" class="sign-up__link">Create
                            New!</a></div>
                    <div class="sign-up">Enter like <a href="#" class="sign-up__link">Anonymous!</a></div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>

</html>