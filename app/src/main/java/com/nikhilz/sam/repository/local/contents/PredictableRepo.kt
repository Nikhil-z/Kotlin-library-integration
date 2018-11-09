package com.nikhilz.sam.repository.local.contents

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.nikhilz.sam.repository.local.dao.PredictableDao
import com.nikhilz.sam.repository.local.entity.PredictableEntity

class PredictableRepo(private var predictableDao: PredictableDao) {


    val predictions: LiveData<List<PredictableEntity>> = predictableDao.getPredictions()

    @WorkerThread
    suspend fun remember(predictableEntity: PredictableEntity) {
        predictableDao.insert(predictableEntity)
    }


}