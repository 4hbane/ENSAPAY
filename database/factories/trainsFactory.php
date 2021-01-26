<?php

/** @var \Illuminate\Database\Eloquent\Factory $factory */

use App\train;
use Faker\Generator as Faker;

$factory->define(train::class, function (Faker $faker) {
    return [
        'train_name' => $faker->name,
        'places_number' => $faker->numberBetween(20,60),
    ];
});
