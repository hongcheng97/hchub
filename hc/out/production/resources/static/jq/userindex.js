function ok() {
    var name=prompt("确认您的姓名","");
    $.ajax({
        url:"/info/findOne",
        type:"post",
        dataType:"json",
        data:{
            userName:name
        },
        success:function (result) {
            var xc="";
            for (var i=0;i<result.length;i++){
                var cc = new Date(result[i].date);
                var yy = cc.getFullYear();
                var mm = cc.getMonth();
                var dd = cc.getDate();
                var hh = cc.getHours();
                var ff = cc.getMinutes();
                var ss = cc.getSeconds();
                if (hh<10){
                    hh="0"+hh;
                } if (ff<10){
                    ff="0"+ff;
                } if (ss<10) {
                    ss="0"+ss;
                }
                xc+='<tr><td>'+result[i].userName+'</td><td>'+result[i].presentName+'</td><td>'+result[i].phone+'</td><td>'+yy+'-'+mm+'-'+dd+'   '+hh+':'+ff+':'+ss+'</td></tr>'
            }
            $("#persenalHistory").html(xc);
        }
    })
}
