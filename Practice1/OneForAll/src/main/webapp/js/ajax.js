let ajax= {
    get: function (url, callback) {
        let xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                callback(JSON.parse(xmlhttp.responseText))
            }
        }
        xmlhttp.open("get", url, true)    //true表示异步加载
        xmlhttp.send()
    }
}