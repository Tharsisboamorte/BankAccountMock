package com.example.bankaccountapp.features.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bankaccountapp.data.repository.UserRepositoryImpl
import com.example.model.BillsData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    userRepo: UserRepositoryImpl
): ViewModel() {

    val getAllUsers = userRepo.getAllUser

    private val listOfBills = BillsData.fakeList()



}