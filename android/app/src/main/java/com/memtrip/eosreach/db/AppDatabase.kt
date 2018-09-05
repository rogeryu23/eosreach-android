package com.memtrip.eosreach.db

import androidx.room.Database

import androidx.room.RoomDatabase
import com.memtrip.eosreach.db.account.AccountDao
import com.memtrip.eosreach.db.account.AccountEntity
import com.memtrip.eosreach.db.blockproducer.BlockProducerDao
import com.memtrip.eosreach.db.blockproducer.BlockProducerEntity

@Database(entities = [AccountEntity::class, BlockProducerEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
    abstract fun blockProducerDao(): BlockProducerDao
}