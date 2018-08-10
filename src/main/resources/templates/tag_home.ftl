<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <#assign base=springMacroRequestContext.contextPath />
    <#assign indexPage="https://www.daicaihang.com/" />
    <link href="${base}/images/favicon.ico" rel="icon" type="image/x-icon">
    <link rel="shortcut icon" href="${base}/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${base}/css/main.css">
    <title>${channel.title} - 贷财行</title>
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
                            <a href="${base}/${column.namePinyin}/">
                                ${column.name}
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
    当前位置：<a href="${base}/">頻道</a><span>&gt;</span><a href="#">标签首页</a>
</div>
<!-- 内容 -->
<div class="container tag-home-container">
    <#list tagList as tag>
        <a href="${base}/tag/${tag.id}.html" class="tag1">${tag.name}</a>
    </#list>
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
<script>
    (function(){
        var bp = document.createElement('script');
        var curProtocol = window.location.protocol.split(':')[0];
        if (curProtocol === 'https') {
            bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
        }
        else {
            bp.src = 'http://push.zhanzhang.baidu.com/push.js';
        }
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(bp, s);
    })();
</script>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?4a76468298a6f372ab656b45e9e09191";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>