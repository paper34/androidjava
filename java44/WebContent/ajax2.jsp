<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">

   $(function() {
         $('#b1').click(function() {
        	$('#d1').empty()
			$.ajax({
				url: " https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Fhealth.chosun.com%2Fsite%2Fdata%2Frss%2Frss.xml&api_key=jv4cthkvjtmd5otdgnph4my88bpq3vdft885wafh",
				data: {
					url: 'http://health.chosun.com/site/data/rss/rss.xml',
					api_key : 'jv4cthkvjtmd5otdgnph4my88bpq3vdft885wafh',
					count : 20
					
				},
				success: function(result) {
					console.log('성공!' + result.items)
					list = result.items
					console.log(list.length)
					
					if (list.length > 0) {
						$(list).each(function(index, news) {
						title = news.title
						pubDate = news.pubDate
						link = news.link
						
						console.log(news.title)
						console.log(news.pubDate)
						console.log(news.link)
						total = "<b><a href =" + link + ">" + title +"</a></b> : " + pubDate + "<br>" + 
								link
						$('#d1').append(total + "<hr>")
					  }) // each end
				   } // if end	
				} //success end
			}) // ajax end
		}) // b1 click end
		
		 $('#b2').click(function() {
			$('#d1').empty()
			$.ajax({
				url: " https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Fedu.chosun.com%2Fsite%2Fdata%2Frss%2Frss.xml&api_key=jv4cthkvjtmd5otdgnph4my88bpq3vdft885wafh",
				data: {
					url: 'http://edu.chosun.com/site/data/rss/rss.xml',
					api_key : 'jv4cthkvjtmd5otdgnph4my88bpq3vdft885wafh',
					count : 20
					
				},
				success: function(result) {
					console.log('성공!' + result.items)
					list = result.items
					console.log(list.length)
					
					if (list.length > 0) {
						$(list).each(function(index, news) {
						title = news.title
						pubDate = news.pubDate
						link = news.link
						
						console.log(news.title)
						console.log(news.pubDate)
						console.log(news.link)
						total = "<b><a href =" + link + ">" + title +"</a></b> : " + pubDate + "<br>" + 
								link
						$('#d1').append(total + "<hr>")
					  }) // each end
				   } // if end	
				} // success end
			}) // 
		}) // b2 click end
		
		
		
   }) /* end */
</script>

</head>
<body>
	<button id="b1">헬스 연결</button>
	<button id="b2">맛있는 교육</button>
	<hr>
	<div id="d1"></div>
</body>
</html>