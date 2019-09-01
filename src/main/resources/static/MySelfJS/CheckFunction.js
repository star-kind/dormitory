var checkAll = false;

/**实现全选/全不选效果*/
function allChoice() {
	if (checkAll) {
		$("input[type='checkbox']").each(function() {
					this.checked = false;
				});
				
		checkAll = false;
	} else {
		$("input[type='checkbox']").each(function() {
					this.checked = true;
				});
		checkAll = true;
	}

}