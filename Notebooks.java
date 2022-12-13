import java.util.ArrayList;
import java.util.List;

class Notebooks{
    private int ozu;
    private int size_of_hard_drive;
    private String os;
    private String color;
    List<NameofModel> nameofmodel = new ArrayList<>();
    public Notebooks(int ozu, int size_of_hard_drive, String os, String color, List<NameofModel> nameofmodel){
        this.ozu = ozu;
        this.size_of_hard_drive = size_of_hard_drive;
        this.os = os;
        this.color = color;
        this.nameofmodel = nameofmodel;
    }
   
    public int getOzu() {
        return ozu;
    }

    public int getSize_of_hard_drive() {
        return size_of_hard_drive;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public List<NameofModel> getNameofmodel() {
        return nameofmodel;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ozu;
        result = prime * result + size_of_hard_drive;
        result = prime * result + ((os == null) ? 0 : os.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((nameofmodel == null) ? 0 : nameofmodel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebooks other = (Notebooks) obj;
        if (ozu != other.ozu)
            return false;
        if (size_of_hard_drive != other.size_of_hard_drive)
            return false;
        if (os == null) {
            if (other.os != null)
                return false;
        } else if (!os.equals(other.os))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (nameofmodel == null) {
            if (other.nameofmodel != null)
                return false;
        } else if (!nameofmodel.equals(other.nameofmodel))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ноутбуки" +  " [память = " + ozu + ", объем жесткого диска = " + size_of_hard_drive + ", операционная система = " + os + ", цвет корпуса = "
                + color + "]" + nameofmodel;
    }


    
}