<?php

use App\voyage;
use Illuminate\Database\Seeder;

class voyagesSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        factory(voyage::class , 10)->create();
    }
}
