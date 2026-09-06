package hospital;

public class Visit {

    int visitId;
    String visitDate;
    String doctorName;
    String diagnosis;
    String treatment;

    public Visit(int visitId, String visitDate, String doctorName,
                 String diagnosis, String treatment) {

        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }
}