function do_calc() {
    var left = ($('left').value == '' ? 0 : $('left').value);
    var right = ($('right').value == '' ? 0 : $('right').value);
    var operatorBox = $('operator');
	var operator = operatorBox.options[operatorBox.selectedIndex].value;
	var url = operator + '/' + left + '/' + right;
    new Ajax.Updater('result', url,
 			{
	            asynchronous:1,
	            method: 'GET'
	        }
	)
}