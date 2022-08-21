package flex_depot.DataFile;

public class Depot {
    private long idOfGood;
    private String nameOfGood;
    private TypeOfGood typeOfGood;
    private String scaleOfGood;
    private double viewOfGood;

    public Depot(long idOfGood, String nameOfGood, TypeOfGood typeOfGood, String scaleOfGood, double viewOfGood) {
        this.idOfGood = idOfGood;
        this.nameOfGood = nameOfGood;
        this.typeOfGood = typeOfGood;
        this.scaleOfGood = scaleOfGood;
        this.viewOfGood = viewOfGood;
    }

    public long getIdOfGood() {
        return idOfGood;
    }

    public void setIdOfGood(long idOfGood) {
        this.idOfGood = idOfGood;
    }

    public String getNameOfGood() {
        return nameOfGood;
    }

    public void setNameOfGood(String nameOfGood) {
        this.nameOfGood = nameOfGood;
    }

    public TypeOfGood getTypeOfGood() {
        return typeOfGood;
    }

    public void setTypeOfGood(TypeOfGood typeOfGood) {
        this.typeOfGood = typeOfGood;
    }

    public String getScaleOfGood() {
        return scaleOfGood;
    }

    public void setScaleOfGood(String scaleOfGood) {
        this.scaleOfGood = scaleOfGood;
    }

    public double getViewOfGood() {
        return viewOfGood;
    }

    public void setViewOfGood(double viewOfGood) {
        this.viewOfGood = viewOfGood;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Depot{");
        sb.append("idOfGood=").append(idOfGood);
        sb.append(", nameOfGood='").append(nameOfGood).append('\'');
        sb.append(", typeOfGood=").append(typeOfGood);
        sb.append(", scaleOfGood='").append(scaleOfGood).append('\'');
        sb.append(", viewOfGood=").append(viewOfGood);
        sb.append('}');
        return sb.toString();
    }
}
