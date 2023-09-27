function getAccountLogin() {
    let idAccount = JSON.parse(localStorage.getItem("accountToken")).account.id;
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount,
        success: function (data) {
            localStorage.setItem("account", JSON.stringify(data));
        },
        error: function (err) {
            console.log(err);
        }
    })
}
getAccountLogin();