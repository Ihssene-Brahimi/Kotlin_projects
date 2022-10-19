import java.util.* 

fun main() 
{   
    var tab=intArrayOf(10,30,12,113);
    var ar=ArraySorter();
    println( "\n Original:\n");
    for (item in tab)
    { 
        print(item);
        print(" | ")
    }
    ar.Sort(tab);
    println( "\n Sorted:\n");
    for (item in tab)
    { 
        print(item);
        print(" | ")
    }

}