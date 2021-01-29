<?php
use Illuminate\Support\Facades\Route;

Route::group([
    'prefix' => 'voyages',
], function () {
    Route::get('/' , 'VoyageController@Voyages');

   // Route::get('/stations' ,'VoyageController@getAllStations' );

    Route::get('/transportForm' , 'VoyageController@getForms');
});
