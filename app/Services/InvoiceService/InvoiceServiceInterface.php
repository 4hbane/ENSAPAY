<?php

namespace App\Services\InvoiceService;

use Illuminate\Http\Request;

interface InvoiceServiceInterface {

    /*
    ** pay invoice methode that takes in parrametre the request from the front"
    */
    public function payInvoice( Request $request ) ;


    /**
     * download Invoice methode
     */
    public function downloadInvoice(string $invoiceNmae);

}
