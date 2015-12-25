var addDigits = function(num) {
	var sum, arr = num.toString().split('');
	while (arr.length>1) {
		sum = arr.reduce(function(prev,next){
			return parseInt(prev) + parseInt(next);
		});
		arr = sum.toString().split('');
	}
	return parseInt(arr[0]);
};