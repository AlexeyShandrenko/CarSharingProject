<!DOCTYPE html>
<html>

<head>

    <title>Profile Page</title>

    <link rel="stylesheet" type="text/css" href="../css/profile_style.css">

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
                            </div>
                        </div>
                    </div>
                </div>

                <div class="book-a-car">
                    <div class="container">
                        <div class="display">
                            <div class="name">
                                <div class="name__main name__main_about-us">PROFILE</div>
                                <span class="line">
							<i class="line__i line__i_about-us"><img src="../img/title-line-car.png" alt=""></i>
						</span>
                                <div class="name__description name__description_about-us">
                                    <p>All info about you is here. You can edit your personal data!</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="profile">
            <div class="container">

                <div class="profile__row">

                    <div class="profile__avatar">
                        <img src="http://cdn.onlinewebfonts.com/svg/download_332758.png" alt="">
                        <div class="profile__avatar-change">
                            <a href="/edit_image">Change Avatar</a>
                        </div>
                        <div class="profile__avatar-edit">
                            <a href="/edit_profile">Edit Profile</a>
                        </div>
                    </div>

                    <table class="profile__data">

                        <tr>
                            <td>Firstname:</td>
                            <td>${user.firstname}</td>
                        </tr>

                        <tr>
                            <td>Lastname:</td>
                            <td>${user.lastname}</td>
                        </tr>

                        <tr>
                            <td>Email:</td>
                            <td>${user.email}</td>
                        </tr>

                        <tr>
                            <td>Age:</td>
                            <td>${user.age}</td>
                        </tr>

                        <#if user.phone??>

                        <tr>
                            <td>Phone:</td>
                            <td>${user.phone}</td>
                        </tr>

                        <#else>
                            Fill the phone
                            <tr>
                                <td>Phone:</td>
                                <td><form action="/profile&phone" method="post">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                        <input type="text" name="phone">
                                        <input type="submit" name="phone_submit" value="Add">
                                    </form>
                                </td>
                            </tr>

                        </#if>

                        <#if user.city??>

                        <tr>
                            <td>City:</td>
                            <td>${user.city}</td>
                        </tr>

                        <#else>
                            Fill the city
                        <tr>
                            <td>City:</td>
                            <td><form action="/profile&city" method="post">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <input type="text" name="city">
                                    <input type="submit" name="city_submit" value="Add">
                                </form>
                            </td>
                        </tr>

                        </#if>


                    </table>
                </div>

                <!--  <div class="profile__links">
                     <ul class="profile__list">
                         <li class="profile__list-elements"><a href="">History</a></li>
                         <li class="profile__list-elements"><a href=""></a></li>
                     </ul>
                 </div> -->

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