/**
 * 
 */

function submitFormJavaScript() {
	document.getElementById('multiCheckBox').action = "${s:mvcUrl('PC#cadastrarProduto').build()}";
	document.getElementById('multiCheckBox').submit();
}