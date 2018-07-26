<html>
<head>
    <title>频道首页</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="content-language" content="zh-CN"/>
</head>
<body>

<#--<!-- banner列表 &ndash;&gt;
<#list bannerList as banner>
      <img src="${banner.pictureUrl}"/>
</#list>

<!-- 热门文章 &ndash;&gt;
<p>热门文章</p>
<ul>
<#list hottest as article>
    <li><a href="${article.articleUrl}">${article.name}</a></li>
</#list>
</ul>

<!-- 最新文章 &ndash;&gt;
<p>最新文章</p>
<ul>
<#list newest as article>
    <li><a href="${article.articleUrl}">${article.name}</a></li>
</#list>
</ul>

<!-- 推荐文章 &ndash;&gt;
<p>推荐文章</p>
<ul>
<#list recommended as article>
    <li><a href="${article.articleUrl}">${article.name}</a></li>
</#list>
</ul>

<!-- 遍历栏目 &ndash;&gt;
<#list columnList as column>
    <!-- 栏目名称 &ndash;&gt;
    ${column.name}
    <!-- 栏目图片 &ndash;&gt;
    <img src="${column.pictureUrl}"/>
    <!-- 栏目下的文章 &ndash;&gt;
    <ul>
        <#list column.articleList as article>
            <li><a href="${article.articleUrl}">${article.name}</a></li>
        </#list>
    </ul>
    <a href="#">查看更多>></a>
</#list>-->

<p>热门文章</p>
<ul>
<#list hottest.list as article>
    <li><a href="${article.articleUrl}">${article.name}</a></li>
</#list>
</ul>
</body>
</html>