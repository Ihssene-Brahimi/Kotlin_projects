fun main() 
{   val x=0 ;
    val y=0;

  fun sub(x: Int,y:Int) = x - y ; //lambda version  var sub = ( x:int , y; int  -> x-y )
    var operation= Operation();
    var s = operation.add(3,4);
    var a = sub(7,6);

    println( "le résultat de la soustraction est : $a");
    println( "le résultat de l'addition est : $s");

}