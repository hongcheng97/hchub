function g() {
    var bt=document.getElementById("xhx");
    if(bt.style.display=="none"){
        bt.style.display="block";
    }
}

function sum (){
    var num = Math.floor(Math.random()*100);
    var cc = new Date().getFullYear();
    var yy = new Date().getFullYear();
    var mm = new Date().getMonth();
    var dd = new Date().getDate();
    var hh = new Date().getHours();
    var ff = new Date().getMinutes();
    var ss = new Date().getSeconds();
    var tt = yy+'-'+mm+'-'+dd+'   '+hh+':'+ff+':'+ss
    $.ajax({
        url:'/present/show',
        async:false,
        success:function (result) {
            if(num<=result[0].get){
                var r=855+1800;
                $("#hc").css('transform','rotate('+r+'deg)');
                setTimeout("alert('恭喜您获得一等级')",3500);
                $("#pri").val("iphone一个")
            }else if(num<=result[1].get){
                var r=765+1800;
                $("#hc").css('transform','rotate('+r+'deg)');
                setTimeout("alert('恭喜您获得二等级')",3500);
                $("#pri").val("篮球鞋一双")
            }else if(num<=result[2].get){
                var r=1035+1800;
                $("#hc").css('transform','rotate('+r+'deg)');
                setTimeout("alert('恭喜您获得三等级')",3500);
                $("#pri").val("篮球一个")
            }else {
                var r=945+1800;
                $("#hc").css('transform','rotate('+r+'deg)');
                setTimeout("alert('谢谢参与')",3500);
                $("#pri").val("谢谢参与")
            }
        }
    })
        $("#ti").val(tt);
        document.getElementById("start").disabled=true;
        setTimeout('g()',5000)
}


function aa() {
    $.ajax({
        url:"/present/show",
        type:"post",
        dataType:"json",
        success:function (data,status) {
            if(status=="success"){
                var list=data;
                var table="";
                for(var i=0;i<list.length;i++){
                    table+='<tr><td>'+list[i].presentName+'</td><td>'+list[i].presentType+'</td><td>'+list[i].times+'</td><td>'+list[i].get+'</td></tr>'
                }
                $("#ss").html(table);
            }

        }
    });
}
