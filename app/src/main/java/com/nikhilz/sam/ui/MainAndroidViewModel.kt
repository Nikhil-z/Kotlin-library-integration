package com.nikhilz.sam.ui

import androidx.lifecycle.LiveData
import com.nikhilz.sam.BaseAndroidViewModel
import com.nikhilz.sam.repository.DataRepository
import com.nikhilz.sam.repository.local.contents.ManagerRepo
import com.nikhilz.sam.repository.local.contents.PredictableRepo
import com.nikhilz.sam.repository.local.entity.ManagerEntity
import com.nikhilz.sam.repository.local.entity.PredictableEntity
import kotlinx.coroutines.launch

class MainAndroidViewModel : BaseAndroidViewModel() {


    private var predictableRepo: PredictableRepo
    val predicitions: LiveData<List<PredictableEntity>>

    private var kingRepo: ManagerRepo
    val managers: LiveData<List<ManagerEntity>>


    init {
        val predictableDao = DataRepository.database.predictableDao()
        predictableRepo = DataRepository.local.predictableRepository(predictableDao)
        predicitions = predictableRepo.predictions

        val managerDao = DataRepository.database.managerDao()
        kingRepo = DataRepository.local.managerRepository(managerDao)
        managers = kingRepo.king


    }

    fun remember(string: String) {

        scope.launch {
            val predictableEntity = PredictableEntity(string)
            predictableRepo.remember(predictableEntity)
        }
    }

    fun scrap(title: String, type: Int, total: Long) {

        scope.launch {

            val managerEntity = ManagerEntity(title, type, total)
            kingRepo.insert(managerEntity)

        }
    }


}