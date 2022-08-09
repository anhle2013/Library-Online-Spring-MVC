//
// function cambiar_login() {
//     document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
//     document.querySelector('.cont_form_login').style.display = "block";
//     document.querySelector('.cont_form_sign_up').style.opacity = "0";
//
//     setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);
//
//     setTimeout(function(){
//         document.querySelector('.cont_form_sign_up').style.display = "none";
//     },200);
// }
//
// function cambiar_sign_up(at) {
//     document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
//     document.querySelector('.cont_form_sign_up').style.display = "block";
//     document.querySelector('.cont_form_login').style.opacity = "0";
//
//     setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
//     },100);
//
//     setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
//     },400);
//
//
// }
//
//
//
// function ocultar_login_sign_up() {
//
//     document.querySelector('.cont_forms').className = "cont_forms";
//     document.querySelector('.cont_form_sign_up').style.opacity = "0";
//     document.querySelector('.cont_form_login').style.opacity = "0";
//
//     setTimeout(function(){
//         document.querySelector('.cont_form_sign_up').style.display = "none";
//         document.querySelector('.cont_form_login').style.display = "none";
//     },500);
//
// }


    let btnRegister = $('#btn_sign_up');
    btnRegister.on('click', () => {
        let username = $('#username').val();
        let password =  $('#password').val();
        let checkPassword =  $('#checkPassword').val();
        let roleId =  2;

        let user = {
            username: username,
            password: password,
                role: {
                id: roleId
            }
        }

        if (password !== checkPassword)
            App.SweetAlert.showErrorAlert("Password and Retype Password must be the same");
        else {
            $.ajax({
                "headers": {
                    "accept": "application/json",
                    "content-type": "application/json"
                },
                "type": "POST",
                "url": "http://localhost:8080/api/auth/register",
                "data": JSON.stringify(user)
            })
                .done((data) => {
                    App.SweetAlert.showSuccessAlert("Created new User successfully");
                    window.location.href = "http://localhost:8080/login";
                })
                .fail((jqXHR) => {
                    console.log(jqXHR)
                })
        }
    })

    let btnLogin = $('#btn_login');
    btnLogin.on('click', () => {
        let username = $('#usernameLogin').val();
        let password =  $('#passwordLogin').val();

        let user = {
            username: username,
            password: password
        }

        $.ajax({
            "headers": {
            "accept": "application/json",
            "content-type": "application/json"
        },
            "type": "POST",
            "url": "http://localhost:8080/api/auth/login",
            "data": JSON.stringify(user)
        })
        .done((data) => {
            let roles = data.roles;
            if (roles[0].authority === "ADMIN")
                window.location.href = "http://localhost:8080/books";
            else
                window.location.href = "http://localhost:8080/user";
            App.SweetAlert.showSuccessAlert("Welcome" + username);
        })
        .fail((jqXHR) => {
            console.log(jqXHR);
            App.SweetAlert.showErrorAlert("Wrong password or username");
        })
    })
