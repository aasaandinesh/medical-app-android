package widgets.dinesh.com.medicalapp.data.disc;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import widgets.dinesh.com.medicalapp.records.data.MedicalRecordDAO;
import widgets.dinesh.com.medicalapp.records.data.MedicalRecordEntity;
import widgets.dinesh.com.medicalapp.requests.data.RequestDAO;
import widgets.dinesh.com.medicalapp.requests.data.RequestEntity;
import widgets.dinesh.com.medicalapp.shared.data.UserDAO;
import widgets.dinesh.com.medicalapp.shared.models.UserEntity;

@Database(entities = {UserEntity.class, MedicalRecordEntity.class, RequestEntity.class}, version = 1)
public abstract class MedicalDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract MedicalRecordDAO medicalRecordDAO();
    public abstract RequestDAO requestDAO();
}
