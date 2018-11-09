package com.nikhilz.sam.repository.local.contents

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.nikhilz.sam.repository.local.dao.ManagerDao
import com.nikhilz.sam.repository.local.entity.ManagerEntity

class ManagerRepo(private var kingDao: ManagerDao) {


    val king: LiveData<List<ManagerEntity>> = kingDao.getAll()

    @WorkerThread
    suspend fun insert(managerEntity: ManagerEntity) {
        kingDao.insert(managerEntity)
    }

}