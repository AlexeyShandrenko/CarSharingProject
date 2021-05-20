<#ftl encoding="UTF-8"/>
<!DOCTYPE html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>

    <title>Base Page</title>

    <link rel="stylesheet" type="text/css" href="../css/confirm_page_style.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">

    <meta http-equiv="Content-type" content="text/html" charset="utf-8">

</head>

<body>

<div class="wrapper">
    <div class="content">
        <div class="confirm">
            <ul class="logo">
                <li class="logo__list"><a href="#">ZOZA</a></li>
            </ul>
            <div class="confirm__title">No such account :(</div>
            <p class="confirm__description">Please, try again!</p>
            <div class="try-again">
                <a href="/sign_in">Try Again</a>
            </div>
        </div>
    </div>
</div>

</body>

</html>