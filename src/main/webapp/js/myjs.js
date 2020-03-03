$(document).ready(function(){
    $(document).on("click",".delbut",function(){
        $(this).parents("tr").remove();
        changeIndex();
        return false;
    })
    $("#linkmanaddbut").click(function(){
        var trobj = $("#trmodel").clone(true);
        trobj.prop("id","");
        $("#linkmanTab").append(trobj);
        changeIndex();
    });
    //调整序号
    function changeIndex(){
        var lids = $("input[name$=lid]");//得到所有联系人编号对象数组
        var lnames = $("input[name$=lname]");//得到所有联系人姓名对象数组
        var ltels = $("input[name$=ltel]");//得到所有联系人电话对象数组
        $.each(lids,function(i,o){
            o.name = "list[" + i + "].lid";
        });
        $.each(lnames,function(i,o){
            o.name = "list[" + i + "].lname";
        });
        $.each(ltels,function(i,o){
            o.name = "list[" + i + "].ltel";
        });
    }
});