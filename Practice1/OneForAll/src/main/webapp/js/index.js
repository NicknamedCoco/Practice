window.onload=function(){
    let username = document.getElementById("username")
    username.onblur=()=> {
        ajax.get("http://localhost:8080/OneForAll/UserServlet?action=ajax&username="+username.value,usernameVerify);
    }

}
function usernameVerify(data) {
    let verify = document.getElementById("usernameVerify");
    verify.innerText=data.username
}

