/**
 * 住宿生列表展示
 */
function showStudsList() {
        var url = "/dormitory/Students/show_stud_list";
        $.ajax({
            url: url,
            type: "GET",
            contentType: "application/json;cherset=utf-8",
            dataType: "json",
            success: function (j) {
                $(".tab_body").empty();
                
                var list = j.data;
                if (list !== null) {
                    //对list值进行遍历
                    for (var index = 0; index <= list.length; index++) {
                        var child = '<tr> <td>'+ index +' </td>' +
                            '<td class="studentNo_item">' + list[index].studentNo + '</td> ' +
                            '<td class="studentName_item">' + list[index].studentName + '</td> ' +
                            '<td class="buildingNo_item">' + list[index].buildingNo + '</td> ' +
                            '<td class="chamberNo_item">' + list[index].chamberNo + '</td> ' +
                            '<td class="enterTime_item">' + list[index].enterTime + '</td> ' +
                            '<td><a href="javascript:deleBySid(' + list[index].sid + ')">删除</a></td> ' +
                            '<td><a href="javascript:editBySid('+ list[index].sid +')">修改</a></td>' +
                            '</tr>';
                            
                        //将信息追加
                        $(".tab_body").append(child);
                    }
                   
                }
           }
     });
}

/**
 * 将格林威治时间格式转为年月日格式
 * 
 * @returns
 */
function changingDateFormat() {
	// 按classname获取一长串String
	var arr = $('.enterTime_item').text();

	// 每28个字符为一单位日期String
	var unit = 28;
	var part = arr.length / unit;

	var j = 0;
	var strArr = [];
	var vari = "";
	for (var i = 1; i <= part; i++) {
		// 分段截取28字符
		var sub = arr.substring(j, unit * i);
		j = unit * i;

		vari = GMTToStr(sub);

		$('.enterTime_item').eq(i - 1).text(vari);
	}

}

/**
 * 格林威治时间转为普通格式
 * 
 * @param greenwich
 * @returns
 */
function GMTToStr(greenwich) {
	var date = new Date(greenwich);

	var gener = date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
			+ date.getDate()+ ' ' + 
    		  date.getHours() + ':' + 
    		  date.getMinutes() + ':' + 
    		  date.getSeconds();

	return gener;
}