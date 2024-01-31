package backend;

public class PatientDoesntExistException extends Throwable {
    private String additionalInfo;
    public PatientDoesntExistException(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    // Getter method to retrieve the additional information
    public String getAdditionalInfo() {
        return additionalInfo;
    }
}
