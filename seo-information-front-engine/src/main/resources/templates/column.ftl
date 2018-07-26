<html>
<head>
    <title>栏目页</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="content-language" content="zh-CN"/>
</head>
<body>
<!-- 文章列表 -->
<#list articleList as article>
    <p>
        <!-- 文章标题 -->
        <a href="${article.href}">${article.name}</a>
        <!-- 文章时间 -->
        ${article.updateTime}
        <!-- 链接 -->
        <a href="${article.href}">阅读全文></a>
    </p>
</#list>
<!-- 翻页 -->

<!-- 栏目 -->
<p>栏目</p>
<!-- 栏目列表 -->
<#list columnList as column>
    <a href="${column.href}">${column.name}</a>
</#list>

<!-- 热门文章 -->
热门文章
<#list hottest as article>
    <a href="${article.href}">${article.name}</a>
</#list>

<!-- 推荐文章 -->
推荐文章
<#list recommended as article>
    <a href="${article.href}">${article.name}</a>
</#list>

<!-- 日排行榜 -->
日排行榜
<#list topArticlesByDay as article>
    <a href="${article.href}">${article.name}</a>
</#list>

<!-- 周排行榜 -->
周排行榜
<#list topArticlesByWeek as article>
    <a href="${article.href}">${article.name}</a>
</#list>

<!-- 标签云 -->
</body>
</html>