function checkLogin() {
    let accountToken = JSON.parse(localStorage.getItem("accountToken"));
    if (accountToken == null) {
        location.href = "login.html";
    } else {
        console.log(accountToken)
        if (accountToken.account.role.name === "ROLE_ADMIN") {
            location.href = "/FE_PITNIK/403.html";
        }
    }
    if (window.closed) {
        localStorage.clear();

    }
}
checkLogin();