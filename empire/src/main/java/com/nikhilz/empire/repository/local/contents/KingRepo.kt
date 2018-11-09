package com.nikhilz.empire.repository.local.contents

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.nikhilz.empire.repository.local.dao.KingDao
import com.nikhilz.empire.repository.local.entity.KingEntity

class KingRepo(private var kingDao: KingDao) {


    val king: LiveData<List<KingEntity>> = kingDao.getAll()

    @WorkerThread
    suspend fun insert(kingEntity: KingEntity) {
        kingDao.insert(kingEntity)
    }

}