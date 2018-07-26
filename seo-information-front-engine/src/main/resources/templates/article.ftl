<html>
<head>
    <title>文章页</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="content-language" content="zh-CN"/>
</head>
<body>
<!-- 文章标题 -->
${article.name}
<!-- 来源 -->
来源:${article.column.name}
<!-- 添加时间 -->
添加时间:${article.updateTime}
<!-- 阅读量 -->
阅读量:${article.readingNum}
<!-- 文章内容 -->
${article.content}
<!-- 文章标签 -->
<#list article.tagList as tag>
    <a href="#">tag.name</a>
</#list>
</body>
</html>