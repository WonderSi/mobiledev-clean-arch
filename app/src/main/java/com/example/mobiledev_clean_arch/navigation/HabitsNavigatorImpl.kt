package com.example.mobiledev_clean_arch.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.core.navigation.HabitsNavigator
import com.example.mobiledev_clean_arch.R
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class HabitsNavigatorImpl @Inject constructor(
    private val navController: NavController
) : HabitsNavigator {

    override fun openHabitDetail(habitId: Long) {
        navController.navigate(
            R.id.action_habitList_to_habitDetail,
            bundleOf("habitId" to habitId)
        )
    }

    override fun openCreateHabit() {
        navController.navigate(R.id.action_habitList_to_createHabit)
    }
}
