package widgets.dinesh.com.medicalapp.records.data;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import widgets.dinesh.com.medicalapp.data.entity.BaseEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@Entity
public class MedicalRecordEntity extends BaseEntity{

    @SerializedName("doctor")
    @Expose
    @NonNull
    private String doctor;

    @SerializedName("disease")
    @Expose
    @NonNull
    private String disease;

    @SerializedName("prescription_details")
    @Expose
    @NonNull
    private String prescription;

    @SerializedName("patient_id")
    @Expose
    @NonNull
    private int patientId;



    @NonNull
    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(@NonNull String doctor) {
        this.doctor = doctor;
    }

    @NonNull
    public String getDisease() {
        return disease;
    }

    public void setDisease(@NonNull String disease) {
        this.disease = disease;
    }

    @NonNull
    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(@NonNull String prescription) {
        this.prescription = prescription;
    }

    @NonNull
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(@NonNull int patientId) {
        this.patientId = patientId;
    }
}
