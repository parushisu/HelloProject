// 処理遷移処理
function doSubmit(fn) {
	document.f.fn.value = fn;
	document.f.submit();
}

// CSS初期化処理
function initCss() {
	$("input:button").hover(
		function(){
	    	$(this).css("cursor","pointer");
		},
		function(){
	    	$(this).css("cursor","default");
		}
	);
}


