<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="${ctx}/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!--Custom-Theme-files-->
    <link href="${ctx}/css/style.css" rel='stylesheet' type='text/css'/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${ctx}/js/jquery-1.12.4.js"></script>
    <link rel="stylesheet" href="${ctx}/css/jquery-ui.css" />
    <link rel="stylesheet" href="${ctx}/css/layer.css" media="all">
    <script src="${ctx}/js/jquery-ui.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${ctx}/js/bootstrap.js"></script>
    <script src="${ctx}/js/layer.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#date").datepicker();
            // layer.alert('内容');
        })
    </script>
</head>
<body>
<!-- header-section-starts -->
<#include "common/home.ftl" />
<div class="full">
    <div class="col-md-3 top-nav">
        <#include "common/top-nav.ftl" />
    </div>
    <div class="col-md-9 main">
        <div>
            <button type="button" value="submit" class="btn-danger" id="smt"></button>
            <input type="text" name="date" id="date" />
        </div>
        <#include "common/footer.ftl" />
    </div>
    <div class="clearfix"></div>
</div>

</body>
</html>