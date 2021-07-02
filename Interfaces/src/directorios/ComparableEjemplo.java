package directorios;

public class ComparableEjemplo implements Comparable<ComparableEjemplo>
{
    private String str;
 
    public ComparableEjemplo(String str)
    {
        this.str = str;
    }
 
    // El método compareTo devuelve el tipo int
    public int compareTo(ComparableEjemplo domain)
    {
        if (this.str.compareTo(domain.str) > 0)
            return 1;
        else if (this.str.compareTo(domain.str) == 0)
            return 0;
        else 
            return -1;
    }
    
    public String getStr()
    {
        return str;
    }

    
    public static void main(String[] args) {
		ComparableEjemplo p1= new ComparableEjemplo("Alan");
		ComparableEjemplo p2= new ComparableEjemplo("Alan");
		ComparableEjemplo p3= new ComparableEjemplo("Sky");
		ComparableEjemplo p4= new ComparableEjemplo("Jeampierre");
		System.out.println(p1.compareTo(p2));
		System.out.println(p3.compareTo(p4));
	}
}

