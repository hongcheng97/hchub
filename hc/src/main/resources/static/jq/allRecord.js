function kill() {
    $("#p").val(0);
    $.ajax({
        url:"/info/find1",
        type:'post',
        dataType:'json',
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
            $("#kill").html(xc);
        }
    })
}

function killTwo() {
    var pageStart=parseInt($("#p").val());
    pageStart+=5;
    $("#p").val(pageStart);
    $.ajax({
        url:"/info/find1",
        type:'post',
        dataType:'json',
        data:{
            pageStart:pageStart,
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
            $("#kill").html(xc);
        }
    })
}

function killThree() {
    var pageStart=parseInt($("#p").val());
    pageStart-=5;
    if(pageStart<5){
        pageStart=0;
    }
    $("#p").val(pageStart);
    $.ajax({
        url:"/info/find1",
        type:'post',
        dataType:'json',
        data:{
            pageStart:pageStart,
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
            $("#kill").html(xc);
        }
    })

}

function del() {
    var name=prompt("要删除的用户名","");
    $.ajax({
        url:'/info/delete',
        data:{
            userName:name
        },
        dataType:'post',
        type:'post',
        success:function (result) {
            if(result==1){
                alert("删除成功");
            }else {
                alert("请输入正确的用户名");
            }
        }
    })
}

function kl() {
    var id = $("input").attr('name')
    alert(id)
    $.ajax({
        url:'/info/delete',
        data:{
            ID:id
        },
        dataType:'json',
        type:'post',
        success:function () {
            
        }
    })
}