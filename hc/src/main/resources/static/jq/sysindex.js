function aaa() {
    $.ajax({
        url:"/present/show",
        type:"post",
        datatype:"json",
        success:function (data,status) {
            if(status=="success"){
                var list=data;
                var table="";
                for(var i=0;i<list.length;i++){
                    table+='<tr><td>'+list[i].presentName+'</td><td>'+list[i].presentType+'</td><td>'+list[i].times+'</td><td>'+list[i].get+'</td></tr>'
                }
                $("#sss").html(table);
            }

        }
    });
    // $("tbody").html(tr);
}
function bbb(){
    var bt=document.getElementById("cc");
    var tb=document.getElementById("c");
        if(tb.style.display=="none"){
            tb.style.display="block";
            // obt.value="隐藏模块";
        }
        else{
            tb.style.display="none";
            // obt.value="显示模块";
        }
}
function hhh() {
    var presentName=prompt("输入要修改的奖品名字","");
    var kk=prompt("您要修改为的概率","");
    $.ajax({
        url:"/present/update",
        data:{
            get:kk,
            presentName:presentName
        },
        type:'post',
        datatype:"json",
        success:function () {
            
        }
    })
}