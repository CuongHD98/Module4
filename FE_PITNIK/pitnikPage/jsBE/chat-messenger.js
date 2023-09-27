function chatMessenger() {
    let account = JSON.parse(localStorage.getItem("account"))
    let idAccount = account.id;
    getAllFriend(idAccount);
    getAllMessage(idAccount);
}
chatMessenger();
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
            showListChatFriend(data)
            // showAllInBoxChat(data, idAccount)
        },
        error: function (err) {
            console.log(err);
        }
    })
}
function showListChatFriend(arr) {
    let str = "";
    for (let i = 0; i < arr.length; i++) {
        str += `<li class="nav-item">
                        <a class="" href="#link${i}" data-toggle="tab">
                            <figure><img src="${arr[i].friend.avatar}" alt="">
                                <span class="status f-away"></span>
                            </figure>
                            <div class="user-name">
                                <h6 class="unread">${arr[i].friend.name}</h6>
                                <span>Long time no see!</span>
                            </div>
                            <div class="more">
                                <div class="more-post-optns"><i class="ti-more-alt"></i>
                                    <ul>
                                        <li><i class="fa fa-bell-slash-o"></i>Mute</li>
                                        <li><i class="ti-trash"></i>Delete</li>
                                        <li><i class="fa fa-folder-open-o"></i>Archive</li>
                                        <li><i class="fa fa-ban"></i>Block</li>
                                        <li><i class="fa fa-eye-slash"></i>Ignore Message</li>
                                        <li><i class="fa fa-envelope"></i>Mark Unread</li>
        
                                    </ul>
                                </div>
                            </div>
                        </a>
                    </li>`
    }
    $(".listChatFriend").html(str);
}

function getAllMessage(idAccount) {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/messages/all",
        success: function (data) {
            console.log(data.length)
            showAllInBoxChat(data, idAccount);
            // showAllMessageInBox(data, idAccount)
        },
        error: function (err) {
            console.log(err);
        }
    })
}
function showAllMessageInBox(arr, idAccount) {
    let str = "";
    for (let i = 0; i < arr.length; i++) {
        if (arr[i].sender.id == idAccount) {
            str += `<li class="me">
                        <figure><img src="${arr[i].sender.avatar}" alt=""></figure>
                        <div class="text-box">
                            <p>${arr[i].content}</p>
                            <span><i class="ti-check"></i><i class="ti-check"></i> 2:35PM</span>
                        </div>
                     </li>`
        } else {
            str += `<li class="you">
                        <figure><img src="${arr[i].sender.avatar}" alt=""></figure>
                        <div class="text-box">
                            <p>
                                ${arr[i].content}
                            </p>
                            <span><i class="ti-check"></i><i class="ti-check"></i> 2:36PM</span>
                        </div>
                    </li>`
        }
    }
    // console.log(str)
    $(".menuChat").html(str);
}

function showAllInBoxChat(arr, idAccount) {
    let str = "";
    for (let i = 0; i < arr.length; i++) {
        if (i == 0) {
            str += `<div class="tab-pane active fade show " id="link${i}">
                        <div class="row merged">
                            <div class="col-lg-12">
                                <div class="mesg-area-head">
                                    <div class="active-user">
                                        <figure><img src="${arr[i].friend.avatar}" alt="">
                                            <span class="status f-online"></span>
                                        </figure>
                                        <div>
                                            <h6 class="unread">${arr[i].friend.name}</h6>
                                            <span>Online</span>
                                        </div>
                                    </div>
                                    <ul class="live-calls">
                                        <li class="audio-call"><span class="fa fa-phone"></span></li>
                                        <li class="video-call"><span class="fa fa-video"></span></li>
                                        <li class="uzr-info"><span class="fa fa-info-circle"></span></li>
                                        <li>
                                            <div class="dropdown">
                                                <button class="btn" data-toggle="dropdown" aria-haspopup="true"
                                                        aria-expanded="false">
                                                    <i class="ti-view-grid"></i>
                                                </button>
                                                <div class="dropdown-menu dropdown-menu-right">
                                                    <a class="dropdown-item audio-call" href="#"><i
                                                        class="ti-headphone-alt"></i>Voice Call</a>
                                                    <a href="#" class="dropdown-item video-call"><i
                                                        class="ti-video-camera"></i>Video Call</a>
                                                    <hr>
                                                        <a href="#" class="dropdown-item"><i class="ti-server"></i>Clear
                                                            History</a>
                                                        <a href="#" class="dropdown-item"><i class="ti-hand-stop"></i>Block
                                                            Contact</a>
                                                        <a href="#" class="dropdown-item"><i class="ti-trash"></i>Delete
                                                            Contact</a>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8">
                                <div class="mesge-area">
                                    <ul class="conversations menuChat">`;
                            for (let j = 0; j < arr[i].messageList.length; j++) {
                                if (arr[i].messageList[j].sender.id == idAccount) {
                                    str += `<li class="me">
                                                <figure><img src="${arr[i].messageList[j].sender.avatar}" alt=""></figure>
                                                <div class="text-box">
                                                    <p>${arr[i].messageList[j].content}</p>
                                                    <span><i class="ti-check"></i><i class="ti-check"></i>${arr[i].messageList[j].createAt}</span>
                                                </div>
                                             </li>`
                                } else {
                                    str += `<li class="you">
                                                <figure><img src="${arr[i].messageList[j].sender.avatar}" alt=""></figure>
                                                <div class="text-box">
                                                    <p>
                                                        ${arr[i].messageList[j].content}
                                                    </p>
                                                    <span><i class="ti-check"></i><i class="ti-check"></i> ${arr[i].messageList[j].createAt}</span>
                                                </div>
                                             </li>`
                                }
                            }

                                str+=  `</ul>
                                </div>
                                <div class="message-writing-box">
                                    <form method="post">
                                        <div class="text-area">
                                            <input type="text" id="message${arr[i].friend.id}" placeholder="write your message here..">
                                                <button type="button" onclick="sendMessage(${idAccount}, ${arr[i].friend.id})"><i class="fa fa-paper-plane-o"></i></button>
                                        </div>
                                        <div class="attach-file">
                                            <label class="fileContainer">
                                                <i class="ti-clip"></i>
                                                <input type="file">
                                            </label>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="chater-info">
                                    <figure><img src="${arr[i].friend.avatar}" alt=""></figure>
                                    <h6>${arr[i].friend.name}</h6>
                                    <span>${arr[i].friend.statusChat.status}</span>
                                    <div class="userabout">
                                        <span>About</span>
                                        <p>${arr[i].friend.aboutMe}</p>
                                        <ul>
                                            <li><span>Phone:</span> ${arr[i].friend.phone}</li>                                      
                                            <li><span>Email:</span> <a href="${arr[i].friend.email}"
                                                                       class="__cf_email__"
                                                                       data-cfemail="a0d3c1cdd0ccc5e0c7cdc1c9cc8ec3cfcd">${arr[i].friend.email}</a>
                                            </li>
                                            <li><span>Country:</span> ${arr[i].friend.country}</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>`;
        } else {
            str += `<div class="tab-pane fade" id="link${i}">
                        <div class="row merged">
                            <div class="col-lg-12">
                                <div class="mesg-area-head">
                                    <div class="active-user">
                                        <figure><img src="${arr[i].friend.avatar}" alt="">
                                            <span class="status f-away"></span>
                                        </figure>
                                        <div>
                                            <h6 class="unread">${arr[i].friend.name}</h6>
                                            <span>Away</span>
                                        </div>
                                    </div>
                                    <ul class="live-calls">
                                        <li><span class="fa fa-phone"></span></li>
                                        <li><span class="fa fa-video"></span></li>
                                        <li><span class="fa fa-info-circle"></span></li>
                                        <li>
                                            <div class="dropdown">
                                                <button class="btn" data-toggle="dropdown" aria-haspopup="true"
                                                        aria-expanded="false">
                                                    <i class="ti-view-grid"></i>
                                                </button>
                                                <div class="dropdown-menu dropdown-menu-right">
                                                    <a class="dropdown-item audio-call" href="#"><i
                                                        class="ti-headphone-alt"></i>Voice Call</a>
                                                    <a href="#" class="dropdown-item video-call"><i
                                                        class="ti-video-camera"></i>Video Call</a>
                                                    <hr>
                                                        <a href="#" class="dropdown-item"><i class="ti-server"></i>Clear
                                                            History</a>
                                                        <a href="#" class="dropdown-item"><i class="ti-hand-stop"></i>Block
                                                            Contact</a>
                                                        <a href="#" class="dropdown-item"><i class="ti-trash"></i>Delete
                                                            Contact</a>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="mesge-area conversations">
                                    <ul class="conversations menuChat">`;
                                    for (let j = 0; j < arr[i].messageList.length; j++) {
                                        if (arr[i].messageList[j].sender.id == idAccount) {
                                            str += `<li class="me">
                                                        <figure><img src="${arr[i].messageList[j].sender.avatar}" alt=""></figure>
                                                        <div class="text-box">
                                                            <p>${arr[i].messageList[j].content}</p>
                                                            <span><i class="ti-check"></i><i class="ti-check"></i> ${arr[i].messageList[j].createAt}</span>
                                                        </div>
                                                     </li>`
                                        } else {
                                            str += `<li class="you">
                                                        <figure><img src="${arr[i].messageList[j].sender.avatar}" alt=""></figure>
                                                        <div class="text-box">
                                                            <p>
                                                                ${arr[i].messageList[j].content}
                                                            </p>
                                                            <span><i class="ti-check"></i><i class="ti-check"></i> ${arr[i].messageList[j].createAt}</span>
                                                        </div>
                                                     </li>`
                                        }
                                    }

                                str += `</ul>
                                </div>
                                <div class="message-writing-box">
                                    <form method="post">
                                        <div class="text-area">
                                            <input type="text" id="message${arr[i].friend.id}" placeholder="write your message here..">
                                                <button type="button" onclick="sendMessage(${idAccount}, ${arr[i].friend.id})"><i class="fa fa-paper-plane-o"></i></button>
                                        </div>
                                        <div class="attach-file">
                                            <label class="fileContainer">
                                                <i class="ti-clip"></i>
                                                <input type="file">
                                            </label>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="chater-info">
                                    <figure><img src="${arr[i].friend.avatar}" alt=""></figure>
                                    <h6>${arr[i].friend.name}</h6>
                                    <span>${arr[i].friend.statusChat.status}</span>
                                    <div class="userabout">
                                        <span>About</span>
                                        <p>${arr[i].friend.aboutMe}</p>
                                        <ul>
                                            <li><span>Phone:</span> ${arr[i].friend.phone}</li>
                                            <li><span>Email:</span> <a href="${arr[i].friend.email}"
                                                                       class="__cf_email__"
                                                                       data-cfemail="ee9d8f839e828bae89838f8782c08d8183">${arr[i].friend.email}</a>
                                            </li>
                                            <li><span>Country:</span> ${arr[i].friend.country}</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>`
        }

    }
    $(".showInBox").html(str);
}

function sendMessage(idAccount, idReceiver) {
    let text = $("#message"+idReceiver).val();

    console.log(text)
    let message = {content: text};
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/messages/" + idReceiver,
        data: JSON.stringify(message),
        success: function (data) {
            console.log(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
    location.reload();

}