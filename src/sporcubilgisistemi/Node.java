
package sporcubilgisistemi;

public class Node
{
    private Bilgi bilgi;
    private Node sonraki;
    private Node onceki;
 
    public Node()
    {
        this.bilgi=null;
        this.onceki=null;
        this.sonraki=null;
    }
    public Node(Bilgi bilgi, Node sonraki,Node onceki)
    {
        this.bilgi=bilgi;
        this.sonraki=sonraki;
        this.onceki=onceki;
    }

    public Bilgi getBilgi() {
        return bilgi;
    }

    public void setBilgi(Bilgi bilgi) 
    {
        this.bilgi = bilgi;
    }

    public Node getOnceki() 
    {
        return onceki;
    }

    public void setOnceki(Node onceki)
    {
        this.onceki = onceki;
    }

    public Node getSonraki() 
    {
        return sonraki;
    }

    public void setSonraki(Node sonraki)
    {
        this.sonraki = sonraki;
    }
}

