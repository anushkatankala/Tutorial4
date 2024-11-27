import java.util.ArrayList;
import java.util.List;

public class DVDCollection {
    public static final int     MAX_DVDS = 100;

    private DVD[]   dvds;
    private int     dvdCount;

    public DVDCollection() { dvds = new DVD[MAX_DVDS]; }

    public DVD[] getDvds() { return dvds; }
    public int getDvdCount() { return dvdCount; }
    public String toString() { return ("DVD Collection of size " + dvdCount); }

    public void add(DVD aDvd) {
        if (dvdCount < MAX_DVDS)
            dvds[dvdCount++] = aDvd;
    }
    public boolean remove(String title) {
        for (int i=0; i<dvdCount; i++) {
            DVD d = dvds[i];
            if (dvds[i].getTitle().equals(title)) {
                dvds[i] = dvds[dvdCount-1];
                dvdCount--;
                return true;
            }
        }
        return false;
    }

    public ArrayList<DVD> getDVDList(){
        ArrayList<DVD> myList = new ArrayList<DVD>();
        for (DVD i : this.getDvds()){
            if (i != null){
                myList.add(i);
            }
        }
        return myList;
    }

    public static DVDCollection example1() {
        DVDCollection c = new DVDCollection();
        c.add(new DVD("If I Was a Student", 2007, 65));
        c.add(new DVD("Don't Eat Your Pencil !", 1984, 112));
        c.add(new DVD("The Exam", 2001, 180));
        c.add(new DVD("Tutorial Thoughts", 2003, 128));
        c.add(new DVD("Fried Monitors", 1999, 94));
        return c;
    }
}