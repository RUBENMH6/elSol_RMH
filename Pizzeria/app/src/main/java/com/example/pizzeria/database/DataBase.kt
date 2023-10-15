package com.example.pizzeria.database

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.firestore.ktx.memoryCacheSettings
import com.google.firebase.firestore.ktx.persistentCacheSettings
import com.google.firebase.ktx.Firebase
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

abstract class PizzaDatabaseManager(val db: FirebaseFirestore) {

    companion object {

        private val TAG = "PizzeriaDatabase"

        private val EXECUTOR = ThreadPoolExecutor(
            2,
            4,
            60,
            TimeUnit.SECONDS,
            LinkedBlockingQueue(),
        )
    }

    private fun setup() {

        val db = Firebase.firestore

        val settings = firestoreSettings {
            setLocalCacheSettings(memoryCacheSettings {})
            setLocalCacheSettings(persistentCacheSettings {})
        }
        db.firestoreSettings = settings
    }
}