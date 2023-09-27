function showNavBar() {
    let account = JSON.parse(localStorage.getItem("account"))
    let idAccount = account.id;
    getAllFriendRequest(idAccount);
    getAllNotification(idAccount);
    getAllLastMessage(idAccount);
    $("#accountName").html(account.name);
    $("#accountAvatar").attr("src", account.avatar);
    // $(".accountCoverPhoto").attr("src", account.coverPhoto);
    // $(".accountEmail").attr("href", account.email);
    // $(".accountEmail").html(account.email);
    // $(".accountAboutMe").html(account.aboutMe);
    // $(".accountBirthday").html(account.birthday);
    // $(".accountPhone").html(account.phone);
    // $(".accountGender").html(account.gender);
    // $(".accountCountry").html(account.country);

    getAllPost(idAccount);
    // getAllFollow(idAccount);
    getAllFriend(idAccount);
}

function getAllFriendRequest(idAccount) {

    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/friendRequests",
        success: function (data) {
            console.log(data)
            showFriendRequest(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
}
function showFriendRequest(arr) {
    let str = "";
    for (let i = 0; i < arr.length; i++) {
        str += `<li>
                    <div>
                        <figure>
                            <img src="${arr[i].sender.avatar}" alt="">
                        </figure>
                        <div class="mesg-meta">
                            <h6><a href="#" title="">${arr[i].sender.name}</a></h6>
                            <span><b>Amy</b> is mutule friend</span>
                            <i>yesterday</i>
                        </div>
                        <div class="add-del-friends">   
                            <button style="border: white; background: white" href="#" title="" onclick="updateFriendRequest(${arr[i].id},1)"><i style="color: red" class="fa fa-heart"></i></button>
                            <button style="border: white; background: white" href="#" title="" onclick="updateFriendRequest(${arr[i].id},0)"><i class="fa fa-trash"></i></button>
                        </div>
                    </div>
                </li>`
    }
    document.getElementById("countFriendRequestNumber").innerHTML = arr.length;
    document.getElementById("countFriendRequest").innerHTML = arr.length + ` FriendRequests <a href="#" title="">View all Requests</a> `;
    document.getElementById("menuFriendRequest").innerHTML = str;

}
showNavBar()
function updateFriendRequest(idFriendRequest, action) {
    let idAccount = JSON.parse(localStorage.getItem("account")).id;
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/friendRequests/" + idFriendRequest + "/" + action,
        success: function (data) {
            console.log(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
}

function getAllNotification(idAccount) {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/notifications",
        success: function (data) {
            console.log(data)
            showNotification(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
}
function showNotification(arr) {
    let str = "";
    for (let i = 0; i < arr.length; i++) {
        str += `<li>
                    <a href="notifications.html" title="">
                        <figure>
                            <img src="${arr[i].sender.avatar}" alt="">
                                <span class="status f-online"></span>
                        </figure>
                        <div class="mesg-meta">
                            <h6>${arr[i].sender.name}</h6>
                            <span>${arr[i].content}</span>
                            <i>2 min ago</i>
                        </div>
                    </a>
                </li>`
    }
    document.getElementById("countNotificationNumber").innerHTML = arr.length;
    document.getElementById("countNotification").innerHTML = arr.length + ` Notifications <a href="#" title="">Mark all as read</a> `;
    document.getElementById("menuNotification").innerHTML = str;

}
function getAllLastMessage(idAccount) {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/messages/last",
        success: function (data) {
            console.log(data)
            showAllLastMessage(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
}
function showAllLastMessage(arr) {
    let str = "";
    for (let i = 0; i < arr.length; i++) {
        str += `<li>
                    <a class="show-mesg" href="#" title="">
                        <figure>
                            <img src="${arr[i].sender.avatar}" alt="">
                                <span class="status f-online"></span>
                        </figure>
                        <div class="mesg-meta">
                            <h6>${arr[i].sender.name}</h6>
                            <span><i class="ti-check"></i>${arr[i].content}</span>
                            <i>2 min ago</i>
                        </div>
                    </a>
                </li>`
    }
    document.getElementById("countMessageNumber").innerHTML = arr.length;
    document.getElementById("countMessage").innerHTML = arr.length + ` Messages <a href="#" title="">Mark all as read</a> `;
    document.getElementById("menuMessage").innerHTML = str;
}
function getAllPost(idAccount) {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/posts",
        success: function (data) {
            console.log(data)
            $(".countPost").html(data.length);
        },
        error: function (err) {
            console.log(err);
        }
    })
}
function getAllFollow(idAccount) {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/follows",
        success: function (data) {
            console.log(data)
            $(".countFollower").html(data.follower);
            $(".countFollowing").html(data.following);
        },
        error: function (err) {
            console.log(err);
        }
    })
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
            showFriendChat(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
}
function showFriendChat(arr) {
    let str = "";
    for (let i = 0; i < arr.length; i++) {
        str += `<li>
					<div class="author-thmb">
						<img src="${arr[i].friend.avatar}" alt="">
						<span class="status f-away"></span>
					</div>
				</li>`

    }
    $(".menuFriendChat").html(str);
}

// <li>
//     <div class="author-thmb">
//         <img src="${arr[i].friend.avatar}" alt="">
//             <span class="status f-online"></span>
//     </div>
// </li>