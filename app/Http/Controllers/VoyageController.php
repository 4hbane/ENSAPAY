<?php

namespace App\Http\Controllers;

use App\voyage;
use Exception;
use Illuminate\Http\Request;
use stdClass;

class VoyageController extends Controller
{

    private function getAllStations() {

        try {
            $stations = voyage::all('departure_station', 'arrival_station');

            return response()->json(
                [
                    "stations" => $stations ,
                ]
            );

        } catch (Exception $e) {
            return response()->json(
                [
                    "message" => "data not found" ,
                ]
            );
        }

    }



    public function Voyages( Request $request ){

        try {
            $voyages = voyage::where([
                ["arrival_station" , $request->gare_darrive],
                ["departure_station" , $request->gare_depart]
                ] )->with('train:id,train_name')->get();

                    return   response()->json([
                        "voyages" => $voyages ,
                    ] , 200) ;

        } catch (Exception $e) {
            return response()->json([
                "message" => $e ,
            ], 403) ;
        }

    }

    /**
     * return form and attributes for the client
     */

    public function getForms(){
        try {

            $arrival_stations = voyage::all('arrival_station') ;
            $departure_stations = voyage::all('arrival_station') ;
           $form = [
               "attributes" => [
                   'arivale_stations' => [
                       "type" => "select" , "possibleValues" => $arrival_stations,

                   ],
                   'departure_station' => [
                       "type" => 'select' , "possibleValues" => $departure_stations
                   ],

                   'voyage_day' => [
                    "type" => 'date' , "possibleValues" => now()
                   ],

                   'number_personne' => [
                       "type" => 'number' , "possibleValues" => NULL
                   ]

               ]
                ];

                return $form;

        } catch(Exception $e){
            return response()->json([
                "message" => $e
            ]);
        }


    }



}
