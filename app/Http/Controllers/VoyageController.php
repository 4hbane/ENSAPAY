<?php

namespace App\Http\Controllers;

use App\voyage;
use Exception;
use Illuminate\Http\Request;

class VoyageController extends Controller
{

    public function getAllStations() {

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




}
