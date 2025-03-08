
$(document).ajaxSend(function(e, xhr, opt){
    // 从后端获token
    var token = localStorage.getItem("user_token");
    // 将token放到header中
    xhr.setRequestHeader("user_token_header", token);
});

function getUserInfo(url){
    $.ajax({
        url:url,
        type:"get",
        success:function(result){
            if(result.code=="SUCCESS" && result.data!=null){
                $(".left .card h3").text(result.data.userName);
                $(".left .card a").attr("href",result.data.githupUrl);
            }
        },
        error:function(error){
            consloe.log(error);
        }
    });
}

function logout(){
    localStorage.removeItem("user_token");
    location.href="blog_login.html";
}
