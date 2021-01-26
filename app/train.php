<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class train extends Model
{
    public function voyages(){
        return $this->hasMany(voyage::class);
    }
}
