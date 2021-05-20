<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>Thanks for Registration</title>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">

    <meta http-equiv="Content-type" content="text/html" charset="utf-8">

    <style>

        /*Обнуление*/
        * {
            padding: 0;
            margin: 0;
            border: 0;
        }

        *, *:before, *:after {
            box-sizing: border-box;
        }

        :focus, :active {
            outline: none;
        }

        a:focus, a:active {
            outline: none;
        }

        nav, footer, header, aside {
            display: block;
        }

        html, body {
            height: 100%;
            width: 100%;
            font-size: 100%;
            line-height: 1;
            font-size: 14px;
            -ms-text-size-adjust: 100%;
            -moz-text-size-adjust: 100%;
            -webkit-text-size-adjust: 100%;
        }

        input, button, textarea {
            font-family: inherit;
        }

        input::-ms-clear {
            display: none;
        }

        button {
            cursor: pointer;
        }

        button::-moz-focus-inner {
            padding: 0;
            border: 0;
        }

        a, a:visited {
            text-decoration: none;
        }

        a:hover {
            text-decoration: none;
        }

        ul li {
            list-style: none;
        }

        img {
            vertical-align: top;
        }

        h1, h2, h3, h4, h5, h6 {
            font-size: inherit;
            font-weight: 400;
        }

        /*--------------------*/

        body {

        }

        .wrapper {
            font-family: 'Roboto', sans-serif;
            background-color: #333333;
        }

        .content {
            max-width: 1440px;
            margin: 0 auto;
        }

        .mail {
            text-align: center;
            padding: 30px 0;
        }

        .logo {
            margin-bottom: 20px;
        }

        .logo__list a {
            font-size: 36px;
            color: #9d6cd9;
            font-weight: 300;
            line-height: 1.4;
        }

        .mail__title {
            font-size: 36px;
            font-weight: 800;
            letter-spacing: 2px;
            margin-bottom: 30px;
            color: #fff;
        }

        .mail__img img {
            margin-bottom: 30px;
        }

        .mail__link {
            width: 200px;
            background-color: #9d6cd9;
            border-radius: 25px;
            padding: 10px 0;
            transition: 0.7s;
            margin: 0 auto;
        }

        .mail__link:hover {
            width: 230px;
        }

        .mail__link a {
            color: #fff;
            font-size: 16px;
            font-weight: 500;
        }

    </style>
</head>
<body>
    <div class="wrapper">
        <div class="content">
            <div class="mail">
                <ul class="logo">
                    <li class="logo__list"><a href="#">ZOZA</a></li>
                </ul>
                <div class="mail__title">Activation Account</div>
                <div class="mail__img">
                    <img src="https://image.freepik.com/free-vector/car-sharing-service-mobile-city-transportation-business-concept-vector-illustration_114835-236.jpg" alt="">
                </div>
                <div class="mail__link">
                    <a href="${server_url}/activate">Activate</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>