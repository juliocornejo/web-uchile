//PrimeFaces.widget.Dialog.prototype.applyFocus = function() {
//    var firstInput = this.jq.find(':not(:submit):not(:button):input:visible:enabled:first');
//    if(!firstInput.hasClass('hasDatepicker')) {
//        firstInput.focus();
//    }
//}
//
//
//function onQuantityChange(event) {
//     //alert(event);
//}
//
//
//
//function onSelectItemcode(event) {
//    //alert(event.toString());
//    //jQuery('.ui-datatable-data tr td:nth-child(3)').each(function(){jQuery(this).find("div.ui-cell-editor-output").click()});
//    //autocompleteNameWidget.focus();
//
//    document.getElementById("#{p:component('amountInput')}").focus();
//
//
//
//    jQuery('.ui-datatable-data tr td:nth-child(3)').each(function(){
//        jQuery(this).find("div.ui-cell-editor").click();
//        //$div = jQuery(this).find("div.ui-cell-editor-output");
//        //var divclick = jQuery(this).find("div.ui-cell-editor");
//        //$(divclick).click();
//       // event.stopPropagation();
//        //alert($div);
//    });
//}
//
//function onSelectItemname(event) {
//    jQuery('.ui-datatable-data tr td:nth-child(4)').each(function(){
//        jQuery(this).find("div.ui-cell-editor").click();
//      //  var divclick = jQuery(this).find("div.ui-cell-editor");
//        //$(divclick).click();
//       // event.stopPropagation();
//        //alert($div);
//    });
//
//}
//
//function nextFocus(elementName){
//    reg = /\d/;
//    num = reg.exec(elementName);
//    if (num) {
//        elementName = elementName.replace(num, parseInt(num) + 1);
//        element = document.getElementById(elementName);
//        element.focus();
//    }
//}
//
//function activateEditor() {
//    //jQuery('.ui-datatable-data tr').last().find('span.ui-icon-pencil').each(function(){jQuery(this).click()});
//    //jQuery('.ui-datatable-data tr td:nth-child(3)').each(function(){jQuery(this).find("div.ui-cell-editor-output").click()});
//   // $("#form:productItems:0:j_idt60").click();
//}