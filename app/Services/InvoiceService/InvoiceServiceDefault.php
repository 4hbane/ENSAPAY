<?php

namespace App\Services\InvoiceService;
use App\voyage;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Log;
use App\invoice;

use Exception;
use Illuminate\Support\Facades\Storage;
use Barryvdh\DomPDF\Facade as PDF;

class InvoiceServiceDefault implements InvoiceServiceInterface {

    public function payInvoice( Request $request )
    {
        try {

            $invoice = invoice::create(
                [
                    'id_voyage' =>  $request->id_voyage ,
                    'nb_personne' => $request->nb_personne,
                    'voyage_day' => $request->voyage_day,
                ]

            );

            $voyage = voyage::find($request->id_voyage);
            $train = $voyage->train()->get()->first();
            if( $train->places_number - $request->nb_personne  <= 0 ) {
                return response()->json([
                    "message" => "sorry the train is full",
            ]);
            }

            $train->places_number -= $request->nb_personne ;
            $train->save();



            $factureInfo = [
                "voyage" => $voyage,
                "user" => "Abdelghani Kaddouri",
                "price" => $voyage->voyage_price * $request->nb_personne,

            ];
            Log::channel('ghaniLog')->info($factureInfo);

            $pdf_doc = PDF::loadView('invoice',[ "factureInfo"=>$factureInfo]);

            Log::channel('ghaniLog')->info("test1");
            $ff =  $pdf_doc->download("myInvoice.pdf");
            Log::channel('ghaniLog')->info("test2");
            $invoiceName = "invoice".uniqid().".pdf";
            Storage::put("invoices/".$invoiceName , $ff);
            Log::channel('ghaniLog')->info('invoice paid by');
            return response()->json([
                    "invoiceUrl" => Storage::url("invoices/".$invoiceName)
            ]);


        } catch (Exception $e) {
            return response()->json([
                "message" => "something went wrong try again later".$e,
            ]);
        }
    }


    public function downloadInvoice($invoiceName){
       return  response()->download( storage_path("app/invoices/".$invoiceName) , 'facture.pdf', [], 'inline');
    }


}
