package com.nikhilz.empire.repository.local

import com.nikhilz.empire.repository.local.contents.KingRepo
import com.nikhilz.empire.repository.local.dao.KingDao

class Neighbourhood {

    fun kingRepository(kingDao: KingDao): KingRepo {
        return KingRepo(kingDao)
    }
}