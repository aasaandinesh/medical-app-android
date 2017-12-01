package widgets.dinesh.com.medicalapp.requests.data;

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
public interface RequestDAO {
    @Query("SELECT * FROM requestentity")
    Flowable<List<RequestEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<RequestEntity> requestEntities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOne(RequestEntity requestEntitie);
}
