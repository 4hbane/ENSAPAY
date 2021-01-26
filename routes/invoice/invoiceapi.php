<?php
use Illuminate\Support\Facades\Route;

Route::group([
    'prefix' => 'invoice',
], function () {

    Route::post('paye' , 'InvoiceController@payeInvoice' );
    Route::get('reciept' , 'InvoiceController@getInvoiceReciept' );

});
