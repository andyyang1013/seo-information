<html>
<head>
    <title>head</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="content-language" content="zh-CN"/>
</head>
<body>
<!-- 栏目列表 -->
<a href="www.daicaihang.com/">首页</a>
  <#list columnList as column>
      <a href="www.daicaihang.com/news/${column.namePinyin}/">${column.name}</a>
  </#list>
</body>
</html>