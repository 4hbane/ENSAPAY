<?php

use App\train;
use Illuminate\Database\Seeder;

class trainsSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        factory(train::class , 10)->create();
    }
}
