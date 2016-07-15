function formatDate(date){
		var day = date.getDate();
	    var month = date.getMonth() + 1; //Months are zero based
	    var year = date.getFullYear();
	    return (year+"-" + month +"-" + day);  
}


//从字符串转型成日期类型
function toDate( val){
		return new   Date(Date.parse(val.replace(/-/g,"/")));  
}

//格式化日期
//用法：date.format("yyyy-MM-dd hh:mm:ss")
Date.prototype.format=function(fmt) {     
    var o = {     
    "M+" : this.getMonth()+1, //月份     
    "d+" : this.getDate(), //日     
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时     
    "H+" : this.getHours(), //小时     
    "m+" : this.getMinutes(), //分     
    "s+" : this.getSeconds(), //秒     
    "q+" : Math.floor((this.getMonth()+3)/3), //季度     
    "S" : this.getMilliseconds() //毫秒     
    };     
    var week = {     
    "0" : "周一",     
    "1" : "周二",     
    "2" : "周三",     
    "3" : "周四",     
    "4" : "周五",     
    "5" : "周六",     
    "6" : "周日"    
    };     
    if(/(y+)/.test(fmt)){     
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));     
    }     
    if(/(E+)/.test(fmt)){     
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);     
    }     
    for(var k in o){     
        if(new RegExp("("+ k +")").test(fmt)){     
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));     
        }     
    }     
    return fmt;     
}

function formatNumber(srcStr,nAfterDot){ 　　
	var srcStr,nAfterDot; 　　
	var resultStr,nTen; 　　
	srcStr = ""+srcStr+""; 　　
	strLen = srcStr.length; 　　
	dotPos = srcStr.indexOf(".",0); 　　
	if (dotPos == -1){ 　　　　
		resultStr = srcStr+"."; 　　　　
		for (i=0;i<nAfterDot;i++){ 　　　　　　
			resultStr = resultStr+"0"; 　　　　
		} 　　　　
		return resultStr; 　　
	}else{ 　　　　
		if ((strLen - dotPos - 1) >= nAfterDot){ 　　　　　　
			nAfter = dotPos + nAfterDot + 1; 　　　　　　
			nTen =1; 　　　　　　
			for(j=0;j<nAfterDot;j++){ 　　　　　　　　
				nTen = nTen*10; 　　　　　　
			} 　　　　　　
			resultStr = Math.round(parseFloat(srcStr)*nTen)/nTen; 　　　　　　
			return resultStr; 　　　　
		}else{ 　　　　　　
			resultStr = srcStr; 　　　　　　
			for (i=0;i<(nAfterDot - strLen + dotPos + 1);i++){ 　　　　　　　　
				resultStr = resultStr+"0"; 　　　　　　
			} 　　　　　　
			return resultStr; 　　　　
		} 　　
	} 
} 

//自定义hashtable
function Hashtable() {
    this._hash = new Object();
    this.put = function(key, value) {
        if (typeof (key) != "undefined") {
            if (this.containsKey(key) == false) {
                this._hash[key] = typeof (value) == "undefined" ? null : value;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    this.remove = function(key) { delete this._hash[key]; }
    this.size = function() { var i = 0; for (var k in this._hash) { i++; } return i; }
    this.get = function(key) { return this._hash[key]; }
    this.containsKey = function(key) { return typeof (this._hash[key]) != "undefined"; }
    this.clear = function() { for (var k in this._hash) { delete this._hash[k]; } }
}



