import java.util.* 


 interface Impot
{
    fun CalculImpot():Double;
 }

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

 class compteEpargneVIP(numero:String,solde:Double):compteEpargne(numero,solde),Impot
{
        override fun CalculerComission():Double
    {
       return (0.002*solde)
    }
    
     override fun CalculImpot():Double
    {
        return (0.002*solde)
    }
}

abstract class Bien(var valeur:Double)
{
    
}
 class immeuble(valeur:Double):Bien(valeur), Impot
{
    override fun CalculImpot():Double
    {
        return (0.001*valeur)
    }
}
 
 class terrain(valeur:Double):Bien(valeur){}
 

 
fun main() 
{   
    
    var total:Double=0.00;
   
    var ListeCompte:List<compte> =listOf(
    compteDevise("102",3000.0,0.2),
    compteEpargne("530",4000.0),
    compteEpargneVIP("420",5000.0))
    
    var ListeBien:List<Bien> =listOf(
    immeuble(9999.0),
    terrain(4000.0),
    immeuble(5000.0))
    
    var calculateur=0.0;
    
    
    for (item in ListeBien)
    {
        if (item is immeuble)
        { 
            calculateur=calculateur+(item.CalculImpot());
            
        }
    }
    
    for (item in ListeCompte)
    {
        if (item is compteEpargneVIP)
        { 
            calculateur=calculateur+(item.CalculImpot());
            
        }
    }
    println( "\n Le total des impots : $calculateur \n");
    println( "\n La liste des comptes:\n");
    for (item in ListeCompte)
    { 
        print(item.numero);
        total=total+(item.CalculerComission());
        print(" | ");
    }
    println( "\n Comission totale = $total");
}