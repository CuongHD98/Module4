function getContentTimeline() {
    getAccountTimeLine();
    getNewFriend();
    getAllPostByAccount()
    // getAllFriend(idAccount);
}

getContentTimeline();

function getAccountTimeLine() {
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
            showContentAccountTimeLine(data);
        },
        error: function (err) {
            console.log(err);
        }
    })
}

function showContentAccountTimeLine(account) {
    $(".accountName").html(account.name);
    $(".accountAvatar").attr("src", account.avatar);
}

function getNewFriend() {
    let idAccountView = localStorage.getItem("idAccountView");
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        },
        url: "http://localhost:8080/user/" + idAccountView + "/newFriends",
        success: function (data) {
            console.log(data)
            showMenuNewFriend(data);
        },
        error: function (err) {
            console.log(err);
        }
    })
}

function showMenuNewFriend(arr) {
    let str = "";
    for (let i = 0; i < arr.length; i++) {
        str += `<li>
                    <img src="${arr[i].avatar}" alt="">
                        <div class="sugtd-frnd-meta">
                            <a href="timeline.html" onclick="setIdAccountViewN(${arr[i].id})" title="">${arr[i].name}</a>
                            <span>1 mutual friend</span>
                            <ul class="add-remove-frnd">
                                <li class="add-tofrndlist"><a href="#" onclick="getFriendRequest(${arr[i].id})" title="Add friend"><i
                                    class="fa fa-user-plus"></i></a></li>
                                <li class="remove-frnd"><a href="#" title="remove friend"><i
                                    class="fa fa-user-times"></i></a></li>
                            </ul>
                        </div>
                </li>`
    }
    $("#menuNewFriend").html(str);
}

function getFriendRequest(idSender) {
    let idAccount = JSON.parse(localStorage.getItem("account")).id;
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        },
        url: "http://localhost:8080/user/" + idAccount + "/friendRequests/" + idSender,
        success: function (data) {
            console.log(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
    location.reload();
}

function setIdAccountViewN(idAccountView) {
    localStorage.setItem("idAccountView", idAccountView);
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccountView,
        success: function (data) {
            console.log(data)
            localStorage.setItem("accountView", JSON.stringify(data));
        },
        error: function (err) {
            console.log(err);
        }
    })
}

function getAllPostByAccount() {
    let idAccountView = localStorage.getItem("idAccountView");
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccountView + "/commentWithPosts",
        success: function (data) {
            console.log(data)
            showAllPostByAccount(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
}


function showAllPostByAccount(arr) {
    let account = JSON.parse(localStorage.getItem("accountView"));
    let accountLogin = JSON.parse(localStorage.getItem("account"));
    let str = "";
    for (let i = 0; i < arr.length; i++) {
        str += `<div class="central-meta item">
										<div class="user-post">
											<div class="friend-info">
												<figure>
													<img src="${account.avatar}" alt="">
												</figure>
												<div class="friend-name">
													<div class="more">
														<div class="more-post-optns"><i class="ti-more-alt"></i>
															<ul>
																<li><i class="fa fa-pencil-square-o"></i>Edit Post</li>
																<li><i class="fa fa-trash-o"></i>Delete Post</li>
																<li class="bad-report"><i class="fa fa-flag"></i>Report Post</li>
																<li><i class="fa fa-address-card-o"></i>Boost This Post</li>
																<li><i class="fa fa-clock-o"></i>Schedule Post</li>
																<li><i class="fa fa-wpexplorer"></i>Select as featured</li>
																<li><i class="fa fa-bell-slash-o"></i>Turn off Notifications</li>
															</ul>
														</div>
													</div>
													<ins><a href="time-line.html" title="">${account.name}</a></ins>
													<span>sponsored <i class="fa fa-globe"></i></span>
													
												</div>
												<div class="post-meta">
													<figure>
														<img src="${arr[i].post.imageList[0]}" alt="">
														<ul class="like-dislike">
															<li><a class="bg-purple" href="#" title="Save to Pin Post"><i class="fa fa-thumb-tack"></i></a></li>
															<li><a class="bg-blue" href="#" title="Like Post"><i class="ti-thumb-up"></i></a></li>
															<li><a class="bg-red" href="#" title="dislike Post"><i class="ti-thumb-down"></i></a></li>
														</ul>
													</figure>	
													<div class="description">
														<a href="#" class="learnmore" data-ripple="">Learn More</a>
														<p>
															${arr[i].post.content}
														</p>
													</div>
													<div class="we-video-info">
														<ul>
															<li>
																<span class="views" title="views">
																	<i class="fa fa-eye"></i>
																	<ins>1.2k</ins>
																</span>
															</li>
															<li>
																<div class="likes heart" title="Like/Dislike">❤ <span>2K</span></div>
															</li>
															<li>
																<span class="comment" title="Comments">
																	<i class="fa fa-commenting"></i>
																	<ins>52</ins>
																</span>
															</li>

															<li>
																<span>
																	<a class="share-pst" href="#" title="Share">
																		<i class="fa fa-share-alt"></i>
																	</a>
																	<ins>20</ins>
																</span>	
															</li>
														</ul>
														<div class="users-thumb-list">
															<a data-toggle="tooltip" title="Anderw" href="#">
																<img alt="" src="images/resources/userlist-1.jpg">  
															</a>
															<a data-toggle="tooltip" title="frank" href="#">
																<img alt="" src="images/resources/userlist-2.jpg">  
															</a>
															<a data-toggle="tooltip" title="Sara" href="#">
																<img alt="" src="images/resources/userlist-3.jpg">  
															</a>
															<a data-toggle="tooltip" title="Amy" href="#">
																<img alt="" src="images/resources/userlist-4.jpg">  
															</a>
															<a data-toggle="tooltip" title="Ema" href="#">
																<img alt="" src="images/resources/userlist-5.jpg">  
															</a>
															<span><strong>You</strong>, <b>Sarah</b> and <a href="#" title="">24+ more</a> liked</span>
														</div>
													</div>
												</div>
												<div class="coment-area" style="display: block;">
													<ul class="we-comet" id="menuComment">`
                                                    for (let j = 0; j < arr[i].commentList.length; j++) {
                                                        str += `<li>
                                                            <div class="comet-avatar">
                                                                <img src="${arr[i].commentList[j].account.avatar}" alt="">
                                                            </div>
                                                            <div class="we-comment">
                                                                <h5><a href="time-line.html" title="">${arr[i].commentList[j].account.name} </a>
                                                                </h5>
                                                                <p>${arr[i].commentList[j].content}</p>
                                                                <div class="inline-itms">
                                                                    <span>1 year ago</span>
                                                                    <a class="we-reply" href="#" title="Reply"><i
                                                                        class="fa fa-reply"></i></a>
                                                                    <a href="#" title=""><i class="fa fa-heart"></i><span>20</span></a>
                                                                </div>
                                                            </div>

                                                        </li>`
                                                    }

														str+=`<li class="post-comment">
															<div class="comet-avatar">
																<img src="${accountLogin.avatar}" alt="">
															</div>
															<div class="post-comt-box">
																<form method="post">
																	<textarea id="comment" name="comment" placeholder="Post your comment"></textarea>
																	<button type="button" onclick="sendComment(${arr[i].post.id})" style="color: black">Send</button>

																	
																</form>	
															</div>
														</li>
													</ul>
												</div>
											</div>
										</div>
									</div>`
    }
    $("#listPost").html(str);

}
function sendComment(idPost) {
    let idAccount = JSON.parse(localStorage.getItem("account")).id;
    let content = $("#comment").val();
    let comment = {
        content: content
    }
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/" + idPost,
        data: JSON.stringify(comment),
        success: function (data) {
            console.log(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
    location.reload();

}
function createPost() {
    let content = $("#contentPost").val();
    let post = {
        content: content
    }
    let idAccount = JSON.parse(localStorage.getItem("account")).id;
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8080/user/" + idAccount + "/posts",
        data: JSON.stringify(post),
        success: function (data) {
            console.log(data)
        },
        error: function (err) {
            console.log(err);
        }
    })
    location.reload();
}
    
