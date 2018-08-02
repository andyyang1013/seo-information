<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="${column.desc}">
    <meta name="keywords" content="${column.keyword}">
    <#assign base=springMacroRequestContext.contextPath />
    <#assign indexPage="https://www.daicaihang.com/" />
    <link href="${base}/images/favicon.ico" rel="icon" type="image/x-icon">
    <link rel="shortcut icon" href="${base}/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${base}/css/main.css">
    <title>${column.title}</title>
</head>
<body>
<!-- 页头 -->
<div class="menu" id="menu">
    <div class="top_menu">
        <div class="top_menu_L">
            <a href="https://www.daicaihang.com/"></a>
        </div>
        <div class="top_menu_R">
            <div class="top_list">
                <ul class="tnav">
                        <#list columnList as col>
                        <li class="n1">
                            <a href="${base}/${col.namePinyin}/">
                                ${col.name}
                            </a>
                        </li>
                        </#list>
                    <li class="n1">
                        <a href="${indexPage}" class="ore">
                            首页
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- 面包屑 -->
<div class="breadcrumb">
    当前位置：<a href="${base}">頻道</a><span>&gt;</span><a href="${base}/${column.namePinyin}/">${column.name}</a>
</div>
<!-- 内容  -->
<div class="container">
    <div class="content-l">
            <#list articleList as article>
                <div class="item">
                    <h4><a href="${base}/${article.id}.html">${article.name}</a><span>${article.updateTime?date}</span>
                    </h4>
                    <div class="item-content">
                        ${article.content}
                        <a href="${base}/${article.id}.html">阅读全文&gt;&gt;</a>
                    </div>
                    <div class="item-tag">
                        标签:
                        <#list article.tagList as tag>
                            <a href="${base}/tag/${tag.id}.html">${tag.name}</a>
                        </#list>
                    </div>
                </div>
            </#list>
        <ul class="page-container">
                <#if pageCount != 1>
                    <#list 1..pageCount as i>
                        <li><a href="${base}/${column.namePinyin}?${i}">${i}</a></li>
                    </#list>
                </#if>
                <#if pageCount <= 1>
                    <li><a href="${base}/${column.namePinyin}?1">1</a></li>
                </#if>
        </ul>
    </div>
    <div class="content-r">
        <div class="item column-item">
            <h3>
                <span class="select">栏目</span>
            </h3>
            <div class="item-content">
                    <#list columnList as col>
                        <a href="${base}/${col.namePinyin}/" class="">${col.name}</a>
                    </#list>
            </div>
        </div>
        <div class="item article-item">
            <h3 class="tab">
                <span class="select">热门文章</span>
                <span>推荐文章</span>
            </h3>
            <div class="item-content">
                <ul class="item-content-list select" style="display: block;">
                        <#list hottest as article>
                            <li><span>${article_index}</span><a href="${base}/${article.id}.html">${article.name}</a>
                            </li>
                        </#list>
                </ul>
                <ul class="item-content-list">
                        <#list recommended as article>
                            <li><span>${article_index}</span><a href="${base}/${article.id}.html">${article.name}</a>
                            </li>
                        </#list>
                </ul>
            </div>
        </div>
        <div class="item rank-item">
            <h3 class="tab">
                <span class="select">日排行榜</span>
                <span>周排行榜</span>
            </h3>
            <div class="item-content">
                <ul class="item-content-list select" style="display: block;">
                        <#list dayTopArticles as article>
                            <li><span>${article_index}</span><a href="${base}/${article.id}.html">${article.name}</a>
                            </li>
                        </#list>
                </ul>
                <ul class="item-content-list">
                        <#list weekTopArticles as article>
                            <li><span>${article_index}</span><a href="${base}/${article.id}.html">${article.name}</a>
                            </li>
                        </#list>
                </ul>
            </div>
        </div>
        <div class="item tag-item">
            <h3>
                <span class="select">标签</span>
            </h3>
            <div class="item-content">
                    <#list tagList as tag>
                        <a href="${base}/tag/${tag.id}.html" class="tag tag1">${tag.name}</a>
                    </#list>
            </div>
        </div>
    </div>
</div>
<!-- 页脚 -->
<div class="footer">
    <div class="mi">
        <div class="pa1">
            <ul>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_company.html" class="fln">关于贷财</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_company.html" class="fln">信息披露</a></li>
                <li><a href="" class="fln">快速链接</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_company.html">公司介绍</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_info.html">基本信息</a></li>
                <li><a href="https://www.daicaihang.com/index/user/reg.html">免费注册</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_connect.html">联系我们</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_progress.html">合规进程</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_psafe.html">法律法规</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_msafe.html">安全保障</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_issues.html">重大事项</a></li>
                <li><a href="https://www.daicaihang.com/index/front/helpcentral.html">帮助中心</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_honor.html">荣誉资质</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_datagrid.html">运营数据</a></li>
                <li><a href="https://www.daicaihang.com/index/front/xxpl_partner.html">合作伙伴</a></li>
            </ul>
        </div>
        <div class="pa2">
            <ul>
                <li><img src="http://static.daicash.cn/pc1/images/foobook.png?v=0628">贷财行订阅号</li>
                <li><img src="http://static.daicash.cn/pc1/images/foosev.png?v=0628">贷财行服务号</li>
                <li><img src="http://static.daicash.cn/pc1/images/foodl.png?v=0619">贷财行APP下载</li>
            </ul>
        </div>
        <div class="pa3">
            <p>咨询/投诉热线（工作时间：9:00-18:00）</p>
            <p class="p2">400-6649-666</p>
            <p class="p3">E-mail：service@daicaihang.cn</p>
            <p class="p3">总部地址：辽宁省沈阳市沈河区
                <br>北站路61号2706A</p>
        </div>
        <p class="pa4"><a style="margin-right: 60px;color:#999;margin-left: 50px" target="_blank"
                          href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=21010302000363"
                          rel="nofollow">
            <img src="http://static.daicash.cn/pc1/images/foticon.png" style="display: inline-block">辽公网安备
            21010302000363号</a>
            <span>2014-2018 辽宁贷财互联网科技有限公司 <a href="http://www.miibeian.gov.cn" rel="nofollow" style="color: #999">辽ICP备16013770号-1</a>|辽B2-20170199</span>
            温馨提示：市场有风险，投资需谨慎
        </p>
        <div class="pa5">
            <a target="_blank" rel="nofollow"
               href="http://wljg.lngs.gov.cn/iciaicweb/dzbscheck.do?method=change&amp;id=E2017010300071190" alt="工商网监"
               title="工商网监"><img src="http://static.daicash.cn/pc1/images/bottom_02.png"></a>
            <a rel="nofollow" target="_blank" alt="安全加密认证" title="安全加密认证"><img
                    src="http://static.daicash.cn/pc1/images/comodo_sec.gif" width="83" height="35"></a>
            <a rel="nofollow" target="_blank" alt="安全联盟" title="安全联盟"
               href="https://v.pinpaibao.com.cn/cert/site/?site=www.daicaihang.com&amp;at=business"><img
                    src="http://static.daicash.cn/pc1/images/footer_aqlm.png?v=07171" width="83" height="35"></a>
            <a rel="nofollow" target="_blank" alt="诚信网站" title="诚信网站"
               href="https://credit.szfw.org/CX20170407033562581517.html" id="___szfw_logo___"><img
                    src="http://static.daicash.cn/pc1/images/footer_cxwz.png?v=07171" width="83" height="35"></a>
            <script type="text/javascript">
                (function () {
                    document.getElementById('___szfw_logo___').oncontextmenu = function () {
                        return false;
                    }
                })();
            </script>
            <a rel="nofollow" target="_blank" alt="互联网金融品牌官网" title="互联网金融品牌官网" id="_pingansec_bottomimagesmall_p2p"
               href="http://si.trustutn.org/info?sn=510170301000569641759&amp;certType=4"><img
                    src="http://static.daicash.cn/pc1/images/footer_jrpp.png?v=07171" width="83" height="35"></a>
        </div>
    </div>
</div>
<script src="${base}/jslib/jquery/jquery.min.js"></script>
<script src="${base}/js/main.js"></script>
</body>
</html>