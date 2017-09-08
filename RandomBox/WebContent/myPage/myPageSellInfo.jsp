<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript">
Highcharts.chart('container', {
    chart: {
        type: 'line'
    },
    title: {
        text: '매출현황'
    },
    subtitle: {
        text: '카테고리'
    },
    xAxis: {
        categories: ['여자', '남자', '아이', '성인']
    },
    yAxis: {
        title: {
            text: '수량'
        }
    },
    plotOptions: {
        line: {
            dataLabels: {
                enabled: true
            },
            enableMouseTracking: true
        }
    },
    series: [{
        name: '생활용품카테고리',
        data: [80, 70, 60, 10]
    }, {
        name: '자동차카테고리',
        data: [10, 100, 5, 80]
    }]
});
</script>