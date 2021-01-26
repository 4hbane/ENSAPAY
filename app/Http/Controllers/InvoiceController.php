<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Services\InvoiceService\InvoiceServiceInterface;
class InvoiceController extends Controller
{
    protected $invoiceService;
    public function __construct(InvoiceServiceInterface $invoiceService)
    {
        $this->invoiceService = $invoiceService;
    }

    public function payeInvoice(Request $request) {
        return $this->invoiceService->payInvoice($request);
    }

    public function downloadInvoice($invoiceName){
         return $this->invoiceService->downloadInvoice($invoiceName);
    }


}
