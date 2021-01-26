<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class invoice extends Model
{
    protected $fillable = ['id_voyage', 'nb_personne' , 'voyage_day'];
}
