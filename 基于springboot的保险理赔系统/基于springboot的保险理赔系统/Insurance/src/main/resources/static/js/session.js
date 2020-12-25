
function getSession() {
    $.ajax({
        type: "get",
        url: "http://127.0.0.1:8083/user/getSession",
        async: true,
        withCredentials: true,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
        },	//前端适配：允许session跨域
        dataType: "json",
        success: function (result) {
            if (result.code!=404){

            }else {
                alert("未登录！请登录");
                location.href = "../../index.html";
            }
        }
    })
}
$(function () {
    getSession();
})