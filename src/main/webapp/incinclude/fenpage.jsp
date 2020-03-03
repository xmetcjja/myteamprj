<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div align="center">
    每页显示：${p.pageSize}条记录,总记录条数：${p.total} 总页数:${p.pages}
    <button onclick="toPage(1)" ${p.isFirstPage?'disabled':''}>首页</button>
    <button onclick="toPage(${p.prePage})" ${p.isFirstPage?'disabled':''}>上一页</button>
    <input name="pageNo" value="${p.pageNum}" size="3">
    <button onclick="toPage(${p.nextPage})" ${p.isLastPage?'disabled':''}>下一页</button>
    <button onclick="toPage(${p.pages})" ${p.isLastPage?'disabled':''}>末页</button>
    <script>
        function toPage(val){
            document.getElementsByName("pageNo")[0].value=val;
            document.forms[0].submit();
        }
    </script>
</div>