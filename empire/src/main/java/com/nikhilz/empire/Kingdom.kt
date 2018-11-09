package com.nikhilz.empire

import androidx.lifecycle.LiveData
import com.nikhilz.empire.base.BaseAndroidViewModel
import com.nikhilz.empire.repository.Cabinet
import com.nikhilz.empire.repository.local.contents.KingRepo
import com.nikhilz.empire.repository.local.entity.KingEntity
import kotlinx.coroutines.launch

class Kingdom : BaseAndroidViewModel() {

    private var kingRepo: KingRepo
    val kings: LiveData<List<KingEntity>>

    init {

        val kingDao = Cabinet.database.kingDao()
        kingRepo = Cabinet.neighbourhood.kingRepository(kingDao)
        kings = kingRepo.king


    }


    fun add(int: Int, string: String, long: Long) {

        scope.launch {
            val kingEntity = KingEntity(string, int, long)
            kingRepo.insert(kingEntity)
        }

    }

    fun add(kingEntity: KingEntity) {

        scope.launch {
            kingRepo.insert(kingEntity)
        }

    }

    companion object {

        val PRINCESS = 0
        val PRINCE = 1
    }


}