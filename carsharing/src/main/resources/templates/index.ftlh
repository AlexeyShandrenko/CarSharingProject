<#ftl encoding="UTF-8"/>
<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring/>
<head>

    <title>Main Page</title>

    <link rel="stylesheet" type="text/css" href="../css/index_style.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">

    <meta http-equiv="Content-type" content="text/html" charset="utf-8">

</head>

<body>

<div class="wrapper">

    <div class="content">

        <div class="slider">
            <div class="outer">

                <div class="info-block">
                    <div class="container">
                        <div class="info-block__row">
                            <div class="info-block__address">Kazan, Russia</div>
                            <div class="info-block__time">Mon-Sun 09.00-17.00</div>
                            <ul class="info-block__links">
                                <li class="info-block__links-element"><a href=""><img src="../img/vk.png" alt=""></a>
                                </li>
                                <li class="info-block__links-element"><a href=""><img src="../img/instagram.png" alt=""></a>
                                </li>
                                <li class="info-block__links-element"><a href=""><img src="../img/twitter (1).png"
                                                                                      alt=""></a></li>
                                <li class="info-block__links-element"><a href=""><img src="../img/facebook (1).png"
                                                                                      alt=""></a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="header">
                    <div class="container">
                        <div class="header__row">
                            <ul class="logo">
                                <!-- <li class="logo__list"><img src="../img/car.png" alt="" class="logo__image"></li> -->
                                <li class="logo__list"><a href="/main_page">ZOZA</a></li>
                            </ul>
                            <div class="menu">
                                <#if authentication??>
                                <ul class="menu__list">
                                    <li class="menu__element menu__element_active"><a href="/main_page">HOME</a></li>
                                    <li class="menu__element"><a href="/about_page">ABOUT US</a></li>
                                    <li class="menu__element"><a href="/services">SERVICES</a></li>
                                    <li class="menu__element"><a href="/car_page">CARS</a></li>
                                    <li class="menu__element menu__element_pages"><a href="">PAGES</a>
                                        <ul class="pages-list">
                                            <li class="pages-list__element"><a href="/profile">PROFILE</a></li>
                                            <li class="pages-list__element"><a href="/orders">MY ORDERS</a></li>
                                            <li class="pages-list__element"><a href="#">FAQ</a></li>
                                            <li class="pages-list__element"><a href="/history">HISTORY</a></li>
                                            <li class="pages-list__element"><a href="/logout">LOGOUT</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu__element"><a href="/contacts">CHAT</a></li>
                                </ul>
                                    <#else>
                                        <ul class="menu__list">
                                            <li class="menu__element menu__element_active"><a href="/main_page">HOME</a></li>
                                            <li class="menu__element"><a href="/about_page">ABOUT US</a></li>
                                            <li class="menu__element"><a href="/services">SERVICES</a></li>
                                            <li class="menu__element"><a href="/car_page">CARS</a></li>
                                            <li class="menu__element menu__element_pages"><a href="">PAGES</a>
                                                <ul class="pages-list">
                                                    <li class="pages-list__element"><a href="/logout">PROFILE</a></li>
                                                    <li class="pages-list__element"><a href="/logout">MY ORDERS</a></li>
                                                    <li class="pages-list__element"><a href="#">FAQ</a></li>
                                                    <li class="pages-list__element"><a href="/logout">HISTORY</a></li>
                                                    <li class="pages-list__element"><a href="/sign_in">LOGIN</a></li>
                                                </ul>
                                            </li>
                                            <li class="menu__element"><a href="/logout">CHAT</a></li>
                                        </ul>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="book-a-car">
                    <div class="container">
                        <div class="display">
                            <div class="title">BOOK A CAR TODAY!</div>
                            <div class="display__description">
                                <p>Book a car is simple!</p>
                            </div>
                            <div class="display__form">
                                <#if authentication??>
                                <form action="/addCarOnMainPage" method="post">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <input type="text" name="location" placeholder="Enter your Location">
                                    <input type="text" name="pick_date" placeholder="Pick Date">
                                    <input type="text" name="return_date" placeholder="Return Date">
                                    <input type="submit" value="Confirm">
                                </form>
                                    <#else>
                                        <form action="/logout" method="get">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                            <input type="text" name="location" placeholder="Enter your Location">
                                            <input type="text" name="pick_date" placeholder="Pick Date">
                                            <input type="text" name="return_date" placeholder="Return Date">
                                            <input type="submit" value="Confirm">
                                        </form>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

<#--        <div class="about-us">-->
<#--            <div class="container">-->
<#--                <div class="name">-->
<#--                    <div class="name__main">ABOUT US</div>-->
<#--                    <span class="line">-->
<#--							<i class="line__i"><img src="../img/title-line-car.png" alt=""></i>-->
<#--						</span>-->
<#--                    <div class="name__description">-->
<#--                        <p>Our mission is to provide attractive sharing cars for you!</p>-->
<#--                    </div>-->
<#--                </div>-->
<#--                <div class="about-us__description">-->
<#--                    <div class="about-us__description-text">-->
<#--                        <p>More than 250 cars in stock, more than 50 offices into the city!</p>-->
<#--                        <p>Book a car for business meeting, meet a friends from any place, spend your time outside the-->
<#--                            city. All this is provided by our service!</p>-->
<#--                    </div>-->
<#--                    <div class="about-us__description-image">-->
<#--                        <img src="../img/about.jpeg" alt="">-->
<#--                    </div>-->
<#--                </div>-->
<#--                <div class="about-us__links">-->
<#--                    <ul class="about-us__links-list">-->
<#--                        <li class="about-us__links-elements"><a href="#">Book a Car</a></li>-->
<#--                        <li class="about-us__links-elements"><a href="/contacts">Contact Us</a></li>-->
<#--                    </ul>-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->

<#--        <div class="services">-->
<#--            <div class="container">-->
<#--                <div class="name">-->
<#--                    <div class="name__main name__main_white">OUR SERVICES</div>-->
<#--                    <span class="line">-->
<#--							<i class="line__i line__i_white"><img src="../img/title-line-car.png" alt=""></i>-->
<#--						</span>-->
<#--                    <div class="name__description name__description_white">-->
<#--                        <p>Services provided by us</p>-->
<#--                    </div>-->
<#--                </div>-->

<#--                <div class="services__blocks">-->
<#--                    <ul class="services__blocks-list">-->
<#--                        <li class="services__blocks-content services__blocks-content_active">-->
<#--                            <div class="services__blocks-row">-->
<#--                                <img src="../img/rental-car.png" alt="">-->
<#--                                <div class="services__blocks-description">-->
<#--                                    <div class="services__blocks-title">RENTAL CAR</div>-->
<#--                                    <div class="services__blocks-content-text">Rent a car at any time convenient for-->
<#--                                        you!-->
<#--                                    </div>-->
<#--                                </div>-->
<#--                            </div>-->
<#--                        </li>-->
<#--                        <li class="services__blocks-content">-->
<#--                            <div class="services__blocks-row">-->
<#--                                <img src="../img/car-repair.png" alt="">-->
<#--                                <div class="services__blocks-description">-->
<#--                                    <div class="services__blocks-title">CAR REPAIR</div>-->
<#--                                    <div class="services__blocks-content-text">Has a problem with car? We'll take care-->
<#--                                        of it!-->
<#--                                    </div>-->
<#--                                </div>-->
<#--                            </div>-->
<#--                        </li>-->
<#--                        <li class="services__blocks-content">-->
<#--                            <div class="services__blocks-row">-->
<#--                                <img src="../img/taxi-driver.png" alt="">-->
<#--                                <div class="services__blocks-description">-->
<#--                                    <div class="services__blocks-title">TAXI SERVICE</div>-->
<#--                                    <div class="services__blocks-content-text">No need a car? Just order taxi!</div>-->
<#--                                </div>-->
<#--                            </div>-->
<#--                        </li>-->
<#--                        <li class="services__blocks-content">-->
<#--                            <div class="services__blocks-row">-->
<#--                                <img src="../img/life-insurance.png" alt="">-->
<#--                                <div class="services__blocks-description">-->
<#--                                    <div class="services__blocks-title">LIFE INSURANCE</div>-->
<#--                                    <div class="services__blocks-content-text">All cars are insured in the course of an-->
<#--                                        unfortunate accident!-->
<#--                                    </div>-->
<#--                                </div>-->
<#--                            </div>-->
<#--                        </li>-->
<#--                        <li class="services__blocks-content">-->
<#--                            <div class="services__blocks-row">-->
<#--                                <img src="../img/car-wash.png" alt="">-->
<#--                                <div class="services__blocks-description">-->
<#--                                    <div class="services__blocks-title">CAR WASH</div>-->
<#--                                    <div class="services__blocks-content-text">Oh, your car is so dirty... Doesn't-->
<#--                                        matter, just come to our center!-->
<#--                                    </div>-->
<#--                                </div>-->
<#--                            </div>-->
<#--                        </li>-->
<#--                        <li class="services__blocks-content">-->
<#--                            <div class="services__blocks-row">-->
<#--                                <img src="../img/order.png" alt="">-->
<#--                                <div class="services__blocks-description">-->
<#--                                    <div class="services__blocks-title">CALL DRIVER</div>-->
<#--                                    <div class="services__blocks-content-text">No opportunities to drive a car? Just-->
<#--                                        book a car with private driver!-->
<#--                                    </div>-->
<#--                                </div>-->
<#--                            </div>-->
<#--                        </li>-->
<#--                    </ul>-->
<#--                </div>-->

<#--            </div>-->
<#--        </div>-->

<#--        <div class="achievements">-->
<#--            <div class="container">-->
<#--                <ul class="achievements__list">-->
<#--                    <li class="achievements__elements">-->
<#--                        <img style="height: 50px; width: 44px; padding-top: 10px; "-->
<#--                             src="../img/smiling-emoticon-square-face.png" alt="">-->
<#--                        <div class="achievements__text">-->
<#--                            <div class="achievements__elements-number">550+</div>-->
<#--                            <div class="achievements__elements-description">HAPPY CLIENTS</div>-->
<#--                        </div>-->
<#--                    </li>-->
<#--                    <li class="achievements__elements">-->
<#--                        <img style="height: 58px; width: 60px; padding-top: 5px;" src="../img/car-achivement.png"-->
<#--                             alt="">-->
<#--                        <div class="achievements__text">-->
<#--                            <div class="achievements__elements-number">250+</div>-->
<#--                            <div class="achievements__elements-description">CARS IN STOCK</div>-->
<#--                        </div>-->
<#--                    </li>-->
<#--                    <li class="achievements__elements">-->
<#--                        <img style="height: 55px; width: 58px; padding-top: 7px;" src="../img/office-building.png"-->
<#--                             alt="">-->
<#--                        <div class="achievements__text">-->
<#--                            <div class="achievements__elements-number">50+</div>-->
<#--                            <div class="achievements__elements-description">OFFICE IN CITIES</div>-->
<#--                        </div>-->
<#--                    </li>-->
<#--                </ul>-->
<#--            </div>-->
<#--        </div>-->

<#--        <div class="car-menu">-->
<#--            <div class="container">-->
<#--                <div class="name">-->
<#--                    <div class="name__main">CHOOSE YOUR CAR</div>-->
<#--                    <span class="line">-->
<#--							::before-->
<#--							<i><img src="../img/title-line-car.png" alt=""></i>-->
<#--							::after-->
<#--						</span>-->
<#--                    <div class="name__description">-->
<#--                        <p>Lorem ipsum dolor, sit amet consectetur, adipisicing elit.</p>-->
<#--                    </div>-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->


    </div>

    <footer class="footer">
        <div class="first-footer">
            <div class="container">
                <ul class="footer__list">
                    <li class="footer__elements">
                        <div class="footer__elements-title">ABOUT US</div>
                        <div class="footer__elements-logo">
                            <img src="../img/title-line-car.png" alt="">
                            <div class="footer__elements-logo-name">ZOZA</div>
                        </div>
                        <p class="footer__elements-text">Book a car for business meeting, meet a friends from any place,
                            spend your time outside the city. All this is provided by our service.</p>
                    </li>
                    <li class="footer__elements">
                        <div class="footer__elements-title">GET TOUCH</div>
                        <p class="footer__elements-description">Have a questions? Contact us by email or on social
                            networks!</p>
                        <div class="footer__contacts">
                            <div class="footer__contacts-address">Kazan, Russia</div>
                            <div class="footer__contacts-time">Mon-Sun 09.00-17.00</div>
                            <ul class="footer__links">
                                <li class="footer__links-element"><a href=""><img src="../img/vk.png" alt=""></a></li>
                                <li class="footer__links-element"><a href=""><img src="../img/instagram.png" alt=""></a>
                                </li>
                                <li class="footer__links-element"><a href=""><img src="../img/twitter (1).png"
                                                                                  alt=""></a></li>
                                <li class="footer__links-element"><a href=""><img src="../img/facebook (1).png" alt=""></a>
                                </li>
                            </ul>
                        </div>
                        <div class="footer__button">
                            <a class="footer__button-content" href="/contacts">Contact Us</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="second-footer">Copyright ©2021 All rights reserved</div>
    </footer>

</div>

</body>

</html>