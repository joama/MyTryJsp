<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<title>社區主頁</title>
</head>
<body>
	<div id="outer">
		<div id="upbg"></div>
		<div id="inner">
			<div id="header">
				<h1>
					<span>簡易社區</span>
				</h1>
				<h2>by 社區小組</h2>
			</div>
			<div id="splash"></div>
			<div id="menu">
				<ul>
					<li class="first"><a class="more-link" href="main.action">資訊瀏覽</a></li>
					<li><a class="more-link" href="controlPanel_input.action">控制面板</a></li>
					<li><a class="more-link" href="logout.action">退出</a></li>
				</ul>
				<div id="date"></div>
			</div>
			<div id="primarycontent">

				<!-- primary content start -->
				<div class="post">
					<!-- 反覆運算資訊Map清單的key集合，為iteratoe標籤指定id，儲存反覆運算的元素到OgnlContext的非值推疊對象中 -->
					<s:iterator value="informations.keySet()" id="listType">
						<div class="header">
							<!-- 取用儲存在OgnlContext中的非推疊頂端反覆運算元素listType -->
							<h3>
								<s:property value="#listType" escapeHtml="false"/>
							</h3>
							<div class="date"></div>
						</div>
						<div class="content">
						<!-- 對類別資訊的清單進行反覆運算，該iterator標籤未指定id屬性，因此反覆運算的元素位於推疊頂端 -->
							<s:iterator value="informations.get(#listType)">
								<s:url id="detail" action="information_detail.action">
									<s:param name="infoId">
										<s:property value="id" escapeHtml="false"/>
									</s:param>
								</s:url>
								<p>
									<s:a href="%{#detail}">
										<s:property value="title" escapeHtml="false"/>
									</s:a>
								</p>
							</s:iterator>
						</div>
						<div class="footer">
							<a
								href=information_list?listType=<s:property value="#listType" escapeHtml="false"/>>更多...</a>
						</div>
					</s:iterator>
				</div>
				<!-- primary content end -->

			</div>

			<div id="secondarycontent">

				<!-- secondary content start -->
				<h3>
					<s:property value="userName" />
				</h3>

				<div class="content">
					<p>
						<s:a href="information_input.action">發布資訊</s:a>
					</p>
				</div>
				<!-- secondary content end -->

			</div>

			<div id="footer">&copy; 社區小組. All rights reserved. Design by
				社區小組.</div>

		</div>
	</div>
</body>
</html>
