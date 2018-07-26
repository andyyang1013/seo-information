<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <#assign base=springMacroRequestContext.contextPath />
    <#assign indexPage="https://www.daicaihang.com/" />
    <link href="${base}/images/favicon.ico"  rel="icon" type="image/x-icon">
    <link rel="shortcut icon" href="${base}/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${base}/jslib/swiper-4.1.6/swiper-4.1.6.min.css">
    <link rel="stylesheet" href="${base}/css/main.css">
    <title>贷财行SEO</title>
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
                        <#list columnList as column>
                        <li class="n1">
                            <a href="${base}/${column.href}">
                                ${column.name}
                            </a>
                        </li>
                        </#list>
                        <li class="n1">
                            <a href="${indexPage}" class="ore">
                                首页
                            </a>
                        </li>
                        <#--<li class="n1">
                            <a href="column.ftl">
                        内容6
                        </a>
                        </li>
                        <li class="n1">
                            <a href="column.ftl">
                        内容5
                        </a>
                        </li>
                        <li class="n1">
                            <a href="column.ftl">
                        内容4
                        </a>
                        </li>
                        <li class="n1">
                            <a href="column.ftl">
                        内容3
                        </a>
                        </li>
                        <li class="n1">
                            <a href="column.ftl">
                        内容2
                        </a>
                        </li>
                        <li class="n1">
                            <a href="column.ftl">
                        内容1
                        </a>
                        </li>
                        <li class="n1">
                            <a href="index.ftl" class="ore">
                        首页
                        </a>
                        </li>-->
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- 轮播 -->
    <div class="banner-content">
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide"><a href="https://www.daicaihang.com/index/front/xxpl_bankmana.html"><img src="${base}/images/banner01.jpg" alt=""></a></div>
                <div class="swiper-slide"><a href="https://www.daicaihang.com/index/front/dbsj.html"><img src="${base}/images/banner02.jpg" alt=""></a></div>
                <div class="swiper-slide"><a href="https://www.daicaihang.com/index/front/xxpl_progress.html"><img src="${base}/images/banner03.jpg" alt=""></a></div>
            </div>
            <!-- Add Pagination -->
            <div class="swiper-pagination"></div>
        </div>
    </div>
    <!-- 面包屑 -->
    <div class="breadcrumb" style="margin-top: 0;">
        当前位置：<a href="#">频道</a><span>&gt;</span><a href="column.ftl">栏目1</a>
    </div>
    <!-- 内容  -->
    <div class="container ">
        <div class="content-l">
            <!-- 文本内容 -->
            <div class="detail-content">
                <h1>${article.name}</h1>
                <h4>
                    <span>来源：<a href="${base}/${article.column.href}">${article.column.name}</a></span>
                    <span>添加时间：${article.updateTime?date}</span>
                    <span>阅读量：${article.readingNum}</span>
                </h4>
                ${article.content}
                <#--<p>
                    内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容
                </p>
                <p>
                    内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容
                </p>-->
                <div class="item-tag">
                    标签:
                    <#list
                    <a href="tag.ftl">标签名1</a><a href="tag.ftl">标签名2</a><a href="tag.ftl">标签名3</a>
                    <#--标签:<a href="tag.ftl">标签名1</a><a href="tag.ftl">标签名2</a><a href="tag.ftl">标签名3</a>-->
                </div>
                <!-- 上下篇 -->
                <div class="item-next-prev">
                    <a href="#" class="fl-l"><strong>上一篇：</strong>上一篇名字</a>
                    <a href="#" class="fl-r"><strong>下一篇：</strong>下一篇名字</a>
                </div>
                <!-- 推荐 -->
                <div class="item-recommend">
                    <ul class="list fl-l">
                        <h5>推荐文章</h5>
                        <li><a href="#">推荐文章名推荐文章名推荐文章名</a></li>
                        <li><a href="#">推荐文章名推荐文章名推荐文章名</a></li>
                        <li><a href="#">推荐文章名推荐文章名推荐文章名</a></li>
                        <li><a href="#">推荐文章名推荐文章名推荐文章名</a></li>
                        <li><a href="#">推荐文章名推荐文章名推荐文章名</a></li>
                    </ul>
                    <ul class="list fl-r">
                        <h5>推荐文章</h5>
                        <li><a href="#">推荐文章名推荐文章名推荐文章名</a></li>
                        <li><a href="#">推荐文章名推荐文章名推荐文章名</a></li>
                        <li><a href="#">推荐文章名推荐文章名推荐文章名</a></li>
                        <li><a href="#">推荐文章名推荐文章名推荐文章名</a></li>
                        <li><a href="#">推荐文章名推荐文章名推荐文章名</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="content-r">
            <div class="item column-item">
                <h3>
                    <span class="select">栏目</span>
                </h3>
                <div class="item-content">
                    <a href="#" class="">栏目1</a>
                    <a href="#" class="">栏目2</a>
                    <a href="#" class="">栏目3</a>
                    <a href="#" class="">栏目4</a>
                    <a href="#" class="">栏目5</a>
                    <a href="#" class="">栏目6</a>
                </div>
            </div>
            <a href="#">
            <img class="img-item" src="${base}/images/banner01.jpg" >
            </a>
            <div class="item article-item">
                <h3 class="tab">
                    <span class="select">热门文章</span>
                    <span>推荐文章</span>
                </h3>
                <div class="item-content">
                    <ul class="item-content-list select" style="display: block;">
                        <li><span>1</span><a href="#">文章名称文章名称文章名称文章名称文章名称文章名称</a></li>
                        <li><span>1</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>1</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>1</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>1</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>1</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>1</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>1</span><a href="#">文章名称文章名称文章名称</a></li>
                    </ul>
                    <ul class="item-content-list">
                        <li><span>8</span><a href="#">文章名称文章名称文章名称文章名称文章名称文章名称</a></li>
                        <li><span>8</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>8</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>8</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>8</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>8</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>8</span><a href="#">文章名称文章名称文章名称</a></li>
                        <li><span>8</span><a href="#">文章名称文章名称文章名称</a></li>
                    </ul>
                </div>
            </div>
            <div class="item tag-item">
                <h3>
                    <span class="select">标签</span>
                </h3>
                <div class="item-content">
                    <a href="#" class="tag tag1">理财小知识</a>
                    <a href="#" class="tag tag2">理财</a>
                    <a href="#" class="tag tag3">小知识</a>
                    <a href="#" class="tag tag1">知识</a>
                    <a href="#" class="tag tag2">小知识</a>
                    <a href="#" class="tag tag3">理财小知识</a>
                    <a href="#" class="tag tag1">知识</a>
                    <a href="#" class="tag tag3">小知识</a>
                    <a href="#" class="tag tag2">理财小知识</a>
                    <a href="#" class="tag tag1">知识</a>
                    <a href="#" class="tag tag2">理财小知识</a>
                    <a href="#" class="tag tag3">理财小知识</a>
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
            <p class="pa4"><a style="margin-right: 60px;color:#999;margin-left: 50px" target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=21010302000363" rel="nofollow">
          <img src="http://static.daicash.cn/pc1/images/foticon.png" style="display: inline-block">辽公网安备 21010302000363号</a>
                <span>2014-2018 辽宁贷财互联网科技有限公司 <a href="http://www.miibeian.gov.cn" rel="nofollow" style="color: #999">辽ICP备16013770号-1</a>|辽B2-20170199</span> 温馨提示：市场有风险，投资需谨慎
            </p>
            <div class="pa5">
                <a target="_blank" rel="nofollow" href="http://wljg.lngs.gov.cn/iciaicweb/dzbscheck.do?method=change&amp;id=E2017010300071190" alt="工商网监" title="工商网监"><img src="http://static.daicash.cn/pc1/images/bottom_02.png"></a>
                <a rel="nofollow" target="_blank" alt="安全加密认证" title="安全加密认证"><img src="http://static.daicash.cn/pc1/images/comodo_sec.gif" width="83" height="35"></a>
                <a rel="nofollow" target="_blank" alt="安全联盟" title="安全联盟" href="https://v.pinpaibao.com.cn/cert/site/?site=www.daicaihang.com&amp;at=business"><img src="http://static.daicash.cn/pc1/images/footer_aqlm.png?v=07171" width="83" height="35"></a>
                <a rel="nofollow" target="_blank" alt="诚信网站" title="诚信网站" href="https://credit.szfw.org/CX20170407033562581517.html" id="___szfw_logo___"><img src="http://static.daicash.cn/pc1/images/footer_cxwz.png?v=07171" width="83" height="35"></a>
                <script type="text/javascript">
                (function() { document.getElementById('___szfw_logo___').oncontextmenu = function() { return false; } })();
                </script>
                <a rel="nofollow" target="_blank" alt="互联网金融品牌官网" title="互联网金融品牌官网" id="_pingansec_bottomimagesmall_p2p" href="http://si.trustutn.org/info?sn=510170301000569641759&amp;certType=4"><img src="http://static.daicash.cn/pc1/images/footer_jrpp.png?v=07171" width="83" height="35"></a>
            </div>
        </div>
    </div>
    <script src="${base}/jslib/jquery/jquery.min.js"></script>
    <script src="${base}/jslib/swiper-4.1.6/swiper-4.1.6.min.js"></script>
    <script src="${base}/js/main.js"></script>
    <script>
    var swiper = new Swiper('.swiper-container', {
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        loop: true,
        autoplay: true,
    });
    </script>
</body>
</html>