<?php

/** @var \Illuminate\Database\Eloquent\Factory $factory */

use App\train;
use App\voyage;
use Faker\Generator as Faker;

$factory->define(voyage::class, function (Faker $faker) {
    return [
        'departure_station' => $faker->city,
        'arrival_station' => $faker->city,
        'departure_time' => $faker->numberBetween(1 , 12),
        'arivale_time' => $faker->numberBetween(1,12),
        'voyage_price' => $faker->numberBetween(1 , 200),
        'train_id' => factory(train::class)->create() ,
    ];
});
