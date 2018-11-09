package com.nikhilz.sam.repository.local

import com.nikhilz.empire.repository.local.contents.KingRepo
import com.nikhilz.sam.repository.local.contents.PredictableRepo
import com.nikhilz.empire.repository.local.dao.KingDao
import com.nikhilz.sam.repository.local.contents.ManagerRepo
import com.nikhilz.sam.repository.local.dao.ManagerDao
import com.nikhilz.sam.repository.local.dao.PredictableDao

class Local {

    fun predictableRepository(predictableDao: PredictableDao): PredictableRepo {
        return PredictableRepo(predictableDao)
    }

    fun managerRepository(managerDao: ManagerDao): ManagerRepo {
        return ManagerRepo(managerDao)
    }
}