<jsp:include page="./WEB-INF/jsp/Header.jsp" >
	<jsp:param name="title" value="メニュー" />
</jsp:include>

<%@ taglib uri="http://jp.co.sample/hello-taglib_1_0" prefix="hello" %>

<style type="text/css">
<!--
//-->
</style>

<body onload="onLoad();">
<form name="f" method="post" action="./TestHelloServlet">
	<input type="hidden" name="screenId" value="SCR0001">
	<%
	%>
	<div id="outFrame">
		<div id="header">
			<div class="headline">
				<div class="contents">
					<div class="systemName">インターナビＱＱコールセンターシステム</div>
					<div class="userInfo">
						<div class="authority">＜権限＞&nbsp;システム開発担当</div>
						<div class="user">＜利用者＞&nbsp;HDNTST0001：ＨＤＮテスト用ユーザ</div>
					</div>
				</div>
				<div class="background"></div>
			</div>
			<div class="background"></div>
		</div>
		<div id="main">
			<div id="breadCrumbs">
				<span>&gt;トップメニュー</span>
			</div>
			<div id="mainContents">
				<div class="inlineBlock">
					<div class="block halfLeft">
						<div class="component">
							<div class="compoTitle"><span class="background"></span><span>コールセンター業務</span></div>
							<div class="compoMenuList">
								<div class="compoMenu"><a href="javascript:void(0);" onclick="doNext(); return false;"><span class="head">&gt;&gt;</span><span class="label"><hello:message key="app.menu.001" /></span></a></div>
								<br/>
								<div class="compoMenu"><a class="disabled" disabled><span class="head">&gt;&gt;</span><span class="label">コンシェルジュツール</span></a></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<table class="mainTable" border="1">
		<col class="mainTableCol">
		<tr class="mainTableHeader">
			<th>
			   	<hello:message key="app.menu.000" />
			</th>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0)" onclick="doNext(); return false;"><hello:message key="app.menu.001" /></a>
			</td>
		</tr>
	</table>

	<script type="text/javascript">
	<!--
		function onLoad() {
//			$("th").css( "color", "red" );

			$("th").hover(
				function(){
			    	$(this).css("color","red");
				},
				function(){
			    	$(this).css("color","black");
				}
			);
		}

		function doNext() {
//			document.f.action.value = './TestHelloServlet';
			doSubmit('next');
		}
	//-->
	</script>

	<input type="hidden" name="fn" value="">
</form>
</body>

<jsp:include page="./WEB-INF/jsp/Footer.jsp" />
