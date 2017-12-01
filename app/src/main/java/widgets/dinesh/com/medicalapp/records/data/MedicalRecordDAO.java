package widgets.dinesh.com.medicalapp.records.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@Dao
public interface MedicalRecordDAO {
    @Query("SELECT * FROM medicalrecordentity")
    Flowable<List<MedicalRecordEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<MedicalRecordEntity> medicalRecordEntities);

}
