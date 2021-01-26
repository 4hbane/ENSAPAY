<?php

/** @var \Illuminate\Database\Eloquent\Factory $factory */

use App\invoice;
use App\voyage;
use Faker\Generator as Faker;

$factory->define(invoice::class, function (Faker $faker) {
    return [
        "id_voyage" => factory(voyage::class)->create(),
        "nb_personne" => $faker->numberBetween(1,7),
        "voyage_day" => now(),
    ];
});
