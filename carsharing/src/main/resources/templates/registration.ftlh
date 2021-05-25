<#ftl encoding="UTF-8"/>
<!DOCTYPE html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>

    <title>Registration Page</title>

    <link rel="stylesheet" type="text/css" href="../css/registration_style.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">

    <meta http-equiv="Content-type" content="text/html" charset="utf-8">

</head>

<body>
<@spring.bind "userForm"/>
<div class="wrapper">
    <div class="slider">
        <div class="outer">
            <div class="registration">
                <form class="registration__box" action="/sign_up" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <a href="/base_page"><img src="../img/car.png" alt="" class="registration__img"></a>
                    <h1 class="registration__title">Registration</h1>
<#--                    <input type="text" name="firstname" placeholder="Firstname">-->
<#--                    <input type="text" name="lastname" placeholder="Lastname">-->
                    <@spring.formInput "userForm.firstname" "placeholder='Firstname'"/>
                    <@spring.showErrors "<br>" "error"/>

                    <@spring.formInput "userForm.lastname" "placeholder='Lastname'"/>
                    <@spring.showErrors "<br>" "error"/>

                    <#if namesErrorMessage??>
                        <p class="errorMessage">${namesErrorMessage}</p>
                    </#if>

<#--                    <input type="email" name="email" placeholder="Email">-->

                    <@spring.formInput "userForm.email" "placeholder='Email'"/>
                    <@spring.showErrors "<br>" "error"/>

<#--                    <input type="password" name="password" placeholder="Password">-->
<#--                    <input type="password" name="password_repeat" placeholder="Password Repeat">-->

                    <@spring.formPasswordInput "userForm.password" "placeholder='Password'"/>
                    <@spring.showErrors "<br>" "error"/>

                    <@spring.formPasswordInput "userForm.password_repeat" "placeholder='Password Repeat'"/>
                    <@spring.showErrors "<br>" "error"/>

                    <#if passwordMatchErrorMessage??>
                        <p class="passwordMatchErrorMessage">${passwordMatchErrorMessage}</p>
                    </#if>

<#--                    <input type="number" name="age" placeholder="Age">-->
                    <@spring.formInput "userForm.age" "placeholder='Age'"/>
                    <@spring.showErrors "<br>" "error"/>

                    <input type="text" name="city" placeholder="Your City">

                    <a href="" class=""><input type="submit" value="Sign Up"></a>
                    <div class="sign-up"> Have an Account? <a href="/sign_in" class="sign-up__link">Sign In!</a></div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>

</html>