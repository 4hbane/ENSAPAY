<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Laravel</title>

        <!-- Fonts -->

        <!-- Styles -->
        <style>
            html, body {
                background-color: #fff;
                color: #636b6f;
                font-family: 'Nunito', sans-serif;
                font-weight: 200;
                height: 100vh;
                margin: 0;
            }

            .full-height {
                height: 100vh;
            }

            .flex-center {
                align-items: center;
                display: flex;
                justify-content: center;
            }

            .position-ref {
                position: relative;
            }

            .top-right {
                position: absolute;
                right: 10px;
                top: 18px;
            }

            .content {
                text-align: center;
            }

            .title {
                font-size: 44px;
            }

            .titl{
                font-size: 25px;
                margin: 30px;

            }

            .links > a {
                color: #636b6f;
                padding: 0 25px;
                font-size: 13px;
                font-weight: 600;
                letter-spacing: .1rem;
                text-decoration: none;
                text-transform: uppercase;
            }

            .m-b-md {
                margin-bottom: 30px;
                margin-top: 20px;
            }
            span{
                color: orangered;
            }
        </style>
    </head>
    <body>



<div class="">

<div class="titl">
        <span>Ensa</span>Pay
    </div>

    <hr>

<div class="content mt-5">
<div class="title m-b-md">
VOTRE CONFIRMATION E-BILLET
</div>

<div class="links">
    <a> <span>  Nom & prenom </span> : {{ $factureInfo["user"] }} </a>
    <a > <span> Numero de ticket </span>  : 06669958552 </a>
    <a >  <span> transaction Numero  </span>  : 885545522 </a>
    <a >  <span>  Montant voyage </span>  : {{ $factureInfo["price"]  }}  DH</a>

</div>

<div class="title m-b-md ">
   de  {{  $factureInfo["voyage"]["departure_station"]  }}  --------> {{  $factureInfo["voyage"]["arrival_station"] }}
</div>

</div>
</div>

    </div>


    </body>
</html>
