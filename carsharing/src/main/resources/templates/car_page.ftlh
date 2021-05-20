<#ftl encoding="UTF-8"/>
<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring/>

<head>

    <title>Cars Page</title>

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
                                <ul class="menu__list">
                                    <li class="menu__element"><a href="/main_page">HOME</a></li>
                                    <li class="menu__element"><a href="/about_page">ABOUT US</a></li>
                                    <li class="menu__element"><a href="/services">SERVICES</a></li>
                                    <li class="menu__element menu__element_active"><a href="#">CARS</a></li>
                                    <li class="menu__element menu__element_pages"><a href="">PAGES</a>
                                        <ul class="pages-list">
                                            <li class="pages-list__element"><a href="/profile">PROFILE</a></li>
                                            <li class="pages-list__element"><a href="/orders">MY ORDERS</a></li>
                                            <li class="pages-list__element"><a href="/faq">FAQ</a></li>
                                            <li class="pages-list__element"><a href="/history">HISTORY</a></li>
                                            <li class="pages-list__element"><a href="/logout">LOGOUT</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu__element"><a href="/contacts">CONTACT</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="book-a-car">
                    <div class="container">
                        <div class="display">
                            <div class="name">
                                <div class="name__main name__main_about-us">CARS</div>
                                <span class="line">
							<i class="line__i line__i_about-us"><img src="../img/title-line-car.png" alt=""></i>
						</span>
                                <div class="name__description name__description_about-us">
                                    <p>Select any car for you!</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="car-menu">
            <div class="container">
                <div class="car-menu__row">
<#--                    <div class="car-menu__sidebar">-->
<#--                    <div class="car-menu__information">-->
<#--                        <div class="car-menu__title">FOR MORE INFORMATION</div>-->
<#--                            <div class="car-menu__description">-->
<#--                                <p class="city">-->
<#--                                    <img src="../img/cityscape.png" alt="">-->
<#--                                        Kazan, Russia-->
<#--                                </p>-->
<#--                                <p class="time">-->
<#--                                    <img src="../img/clock.png" alt="">-->
<#--                                        Mon-Sun 09.00-17.00-->
<#--                                </p>-->
<#--                            </div>-->
<#--                    </div>-->
<#--                    <div class="car-menu__social-media">-->
<#--                        <div class="car-menu__title">CONNECT WITH US</div>-->
<#--                        <ul class="car-menu__social-media-list">-->
<#--                            <li class="car-menu__social-media-elements">-->
<#--                                <a href="#"><img src="../img/instagram-purple.png" alt=""></a>-->
<#--                            </li>-->
<#--                            <li class="car-menu__social-media-elements">-->
<#--                                <a href="#"><img src="../img/vk-purple.png" alt=""></a>-->
<#--                            </li>-->
<#--                            <li class="car-menu__social-media-elements">-->
<#--                                <a href="#"><img src="../img/facebook-purple.png" alt=""></a>-->
<#--                            </li>-->
<#--                            <li class="car-menu__social-media-elements">-->
<#--                                <a href="#"><img src="../img/twitter-purple.png" alt=""></a>-->
<#--                            </li>-->
<#--                            -->
<#--                        </ul>-->
<#--                    </div>-->
<#--                </div>-->
                    <div class="car-menu__column">
                    <ul class="car-menu__list">

                        <#if vehicles??>

                        <#list vehicles as vehicle>

                        <li class="car-menu__elements">
                            <a href="/car_description"><img src="${vehicle.vehiclePhoto.url}" alt=""></a>
                            <div class="car-menu__elements-description">
                                <div class="car-menu__name">${vehicle.name}</div>
                                <div class="car-menu__price">${vehicle.price}$ RENT/PER DAY</div>
                                <div class="car-menu__description">${vehicle.description}</div>
                                <ul class="car-menu__characteristics">
                                    <li>${vehicle.acceleration_time}</li>
                                    <li>${vehicle.max_speed}</li>
                                    <li>${vehicle.bodyType.name}</li>
                                </ul>
                                <div class="car-menu__button">
                                    <a href="">Book It</a>
                                </div>
                            </div>
                        </li>

                        </#list>

                        </#if>

                    </ul>
                </div>
                </div>
            </div>
        </div>



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