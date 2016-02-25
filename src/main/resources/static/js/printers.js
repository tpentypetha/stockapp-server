var printers = (function(){

    function goToAddPrinter() {
        window.location.href = '/addPrinter';
    }

    return {
        goToAddPrinter: goToAddPrinter
    };
}());
