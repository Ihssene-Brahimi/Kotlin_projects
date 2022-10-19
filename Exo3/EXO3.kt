import java.util.* 

abstract class compte(var numero:String,var solde:Double)
{ 	
    
    init
    {   this.numero=numero;
        this.solde=solde;
    }
    
    
    abstract fun CalculerComission():Double;
}

class compteDevise(numero:String,solde:Double,var taux:Double):compte(numero,solde)
{
    override fun CalculerComission():Double
    {
       return ((0.002*solde)*taux);
    }
}

 open class compteEpargne(numero:String,solde:Double):compte(numero,solde)
{
    override fun CalculerComission():Double
    {
       return (0.001*solde);
    }
}

 class compteEpargneVIP(numero:String,solde:Double):compteEpargne(numero,solde)
{
        override fun CalculerComission():Double
    {
       return (0.002*solde)
    }
}

fun main() 
{   
    
    var total:Double=0.00;
   
    var ListeCompte:List<compte> =listOf(
    compteDevise("102",3000.0,0.2),
    compteEpargne("530",4000.0),
    compteEpargneVIP("420",5000.0))
    println( "\n La liste des comptes:\n");
    for (item in ListeCompte)
    { 
        print(item.numero);
        total=total+(item.CalculerComission());
        print(" | ");
    }
    println( "\n Comission totale = $total");
}