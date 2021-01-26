<?php

use App\invoice;
use Illuminate\Database\Seeder;

class invoiceSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        factory(invoice::class,3)->create();
    }
}
