<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class voyage extends Model
{


    public function train(){
        return $this->hasOne(train::class , 'id' , 'train_id');
    }
}
