function getContent() {
    let idAccountView = localStorage.getItem("idAccountView");
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        },
        url: "http://localhost:8080/user/" + idAccountView,
        success: function (data) {
            console.log(data)
            showContent(data);
        },
        error: function (err) {
            console.log(err);
        }
    })
    // getAllFriend(idAccount);
}
getContent();
function showContent(accountView) {
    $(".accountName").html(accountView.name);
    $(".accountAvatar").attr("src", accountView.avatar);
    $(".accountCoverPhoto").attr("src", accountView.coverPhoto);
    $(".accountEmail").attr("href", accountView.email);
    $(".accountEmail").html(accountView.email);
    $(".accountAboutMe").html(accountView.aboutMe);
    $(".accountBirthday").html(accountView.birthday);
    $(".accountPhone").html(accountView.phone);
    $(".accountGender").html(accountView.gender);
    $(".accountCountry").html(accountView.country);
}



function getAllFriend(idAccount) {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/friendships",
        success: function (data) {
            console.log(data)
            showFriend(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
}
function showFriend(arr) {
    let str = "";
    for (let i = 0; i < arr.length; i++) {
        str += `<li>
                    <img src="${arr[i].friend.avatar}" alt="">
                    <div class="sugtd-frnd-meta">
                        <a href="#" title="">${arr[i].friend.name}</a>
                        <span>1 mutual friend</span>
                        <ul class="add-remove-frnd">
                            <li class="add-tofrndlist"><a class="send-mesg" href="#" title="Send Message"><i
                                class="fa fa-commenting"></i></a></li>
                            <li class="remove-frnd"><a href="#" title="remove friend"><i
                                class="fa fa-user-times"></i></a></li>
                        </ul>
                    </div>
                </li>`
    }
    $(".countFriend").html(`Friend's (${arr.length})<a href="timeline-friends2.html" title="">See All</a>`);
    $("#menuFriend").html(str);


}