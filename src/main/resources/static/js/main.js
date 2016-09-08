$(document).ready(function() {
    //toggle `popup` / `inline` mode
    $.fn.editable.defaults.mode = 'popup';     
    
    //make username editable
    $('.editabletext').editable(function () {
        $.ajax({

            url: "/editticket/fjdsfhsd"

        });



    });
    //make status editable

});