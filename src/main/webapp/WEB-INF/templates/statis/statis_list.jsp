<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据统计</title>
</head>
<body>
    <div style="width:100%;height: 10%;">
        <div style="margin-top: 2%;margin-left: 2%; ">
            <form id="zhexian_form" method="post">
                菜单名称: <input id="zhexianname">
                菜单状态: <input id="zhexiandel">
                <a href="#" id="qk" class="easyui-linkbutton" iconCls="icon-clear">清空</a>
                <a href="#" id="ss" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
            </form>
        </div>
    </div>
    <div style="width:100%;height: 400px;">
        <!-- 折线 -->
        <div id="brokenLine" style="width:50%;height: 400px;">
        </div>
        <!-- 饼图 -->
        <div id="pieChart" style="width:50%;height: 400px;margin-left: 50%;margin-top: -400px;">
        </div>
    </div>
    <script>
        $().ready(function (){
            $("#zhexianname").textbox({
                width:"10%"
            });
            $("#zhexiandel").textbox({
                width:"10%"
            });

            //清空
            $("#qk").click(function () {
                $("#zhexian_form").form("clear");
            });

            //搜索
            $("#ss").click(function () {
                alert("虚拟");
            });
        });
        /*折现*/
        var brokenLine = echarts.init(document.getElementById('brokenLine'));
        var brokenLineOption = {
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : ['周一','周二','周三','周四','周五','周六','周日']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'邮件营销',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'联盟广告',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'视频广告',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'直接访问',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'搜索引擎',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        brokenLine.setOption(brokenLineOption);

        /*饼图*/
        var pieChart = echarts.init(document.getElementById('pieChart'));
        var pieChartOption = {
            title : {
                text: '某站点用户访问来源',
                subtext: '纯属虚构',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient : 'vertical',
                x : 'left',
                data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
            },
            calculable : true,
            series : [
                {
                    name:'访问来源',
                    type:'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[
                        {value:335, name:'直接访问'},
                        {value:310, name:'邮件营销'},
                        {value:234, name:'联盟广告'},
                        {value:135, name:'视频广告'},
                        {value:1548, name:'搜索引擎'}
                    ]
                }
            ]
        };
        pieChart.setOption(pieChartOption,true);
    </script>
</body>
</html>
