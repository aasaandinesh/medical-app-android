package widgets.dinesh.com.medicalapp.shared.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import widgets.dinesh.com.medicalapp.shared.models.UserEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@Dao
public interface UserDAO {

    @Query("SELECT * FROM userentity")
    Flowable<List<UserEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserEntity userEntity);
}
